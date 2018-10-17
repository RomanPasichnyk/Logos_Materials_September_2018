package ua.logos.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import ua.logos.domain.ModelDTO;
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
	public ResponseEntity<Void> create(@RequestBody ModelDTO dto) {
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
	
	@PostMapping("image")
	public ResponseEntity<Void> uploadImage(
			@RequestParam("file") MultipartFile file) {
		
		System.out.println(file.getOriginalFilename());
		fileStorageService.storeFile(file);
		return new ResponseEntity<Void>(HttpStatus.ACCEPTED);
	}
}
