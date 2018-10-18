package ua.logos.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.core.io.Resource;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import ua.logos.domain.ErrorDTO;
import ua.logos.domain.ModelDTO;
import ua.logos.domain.filter.SearchFilter;
import ua.logos.service.FileStorageService;
import ua.logos.service.ModelService;

@RestController
@RequestMapping("model")
public class ModelController {

	@Autowired
	private ModelService modelService;
	
	@Autowired
	private FileStorageService fileStorageService;
	
	@PostMapping
	public ResponseEntity<?> create(
			@Valid @RequestBody ModelDTO dto, BindingResult br) {
				
		if(br.hasErrors()) {
			System.out.println("Validation Error");
			String errorMsg = br.getFieldErrors().stream()
	                .map(DefaultMessageSourceResolvable::getDefaultMessage).findFirst().get().toString();
			
			ErrorDTO errorDTO = new ErrorDTO(errorMsg);
			return new ResponseEntity<>(errorDTO, HttpStatus.BAD_REQUEST);
		}
		
		modelService.saveModel(dto);
		return new ResponseEntity<Void>(HttpStatus.CREATED);
	}
	
	@GetMapping
	public ResponseEntity<?> getAll() {
		List<ModelDTO> dtos = modelService.findAllModels();
		return new ResponseEntity<List<ModelDTO>>(dtos, HttpStatus.OK);
	}
	
	@GetMapping("{modelId}")
	public ResponseEntity<?> getById(@PathVariable("modelId") Long id) {
		ModelDTO dto = modelService.findModelById(id);
		return new ResponseEntity<ModelDTO> (dto, HttpStatus.OK);
	}
	
	@PostMapping("{modelId}/image")
	public ResponseEntity<Void> image(
			@PathVariable("modelId") Long id,
			@RequestParam("file") MultipartFile file) {
		System.out.println("ModelID: " + id);
		String filePath = fileStorageService.storeFile(file);
		System.out.println(filePath);
		
		return new ResponseEntity<Void>(HttpStatus.ACCEPTED);
	}
	
	@GetMapping("image/{fileName:.+}")
	public ResponseEntity<Resource> downloadFile(
			@PathVariable("fileName") String fileName, 
			HttpServletRequest request) {
		
        Resource resource = fileStorageService.loadFileAsResource(fileName);

        String contentType = null;
        try {
            contentType = request.getServletContext().getMimeType(resource.getFile().getAbsolutePath());
        } catch (IOException ex) {
            ex.printStackTrace();
        }

        if(contentType == null) {
            contentType = "application/octet-stream";
        }

        return ResponseEntity.ok()
                .contentType(MediaType.parseMediaType(contentType)) // attachment
                .header(HttpHeaders.CONTENT_DISPOSITION, "inline; filename=\"" + resource.getFilename() + "\"")
                .body(resource);
    }
	
	@PostMapping("search")
	public ResponseEntity<?> findByFilter(@RequestBody SearchFilter filter) {
		return new ResponseEntity<List<ModelDTO>>(modelService.findBySearch(filter), HttpStatus.OK);
	}
	
	@GetMapping("page")
	public ResponseEntity<?> findByPage(@PageableDefault Pageable pageable) {
		return new ResponseEntity<List<ModelDTO>>(modelService.findByPage(pageable), HttpStatus.OK);
	}
}
