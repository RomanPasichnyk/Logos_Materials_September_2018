package ua.logos.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import ua.logos.domain.MakeDTO;
import ua.logos.service.MakeService;

@RestController
public class MakeController {

	@Autowired
	private MakeService makeService;
	
	@GetMapping("/test")
	public String test() {
		return "Hello";
	}
	
	@PostMapping("/make/create")
	public ResponseEntity<Void> createMake(@RequestBody MakeDTO dto) {
		
		System.out.println(dto.getName());
		System.out.println(dto.getShortName());
		
		makeService.saveMake(dto);
		return new ResponseEntity<>(HttpStatus.CREATED); // code - 201
	}
	
	@GetMapping("/make/all")
	public ResponseEntity<List<MakeDTO>> getAllMakes() {
		List<MakeDTO> dtos = makeService.getAllMakes();
		return new ResponseEntity<List<MakeDTO>>(dtos, HttpStatus.OK);
	}
	
	@GetMapping("/make/{makeId}")
	public ResponseEntity<MakeDTO> getMakeById(
				@PathVariable("makeId") Long id
			) {
		System.out.println("Make ID: " + id);
		
		MakeDTO make = makeService.getMakeById(id);
		
		return new ResponseEntity<MakeDTO>(make, HttpStatus.OK);
	}
}
