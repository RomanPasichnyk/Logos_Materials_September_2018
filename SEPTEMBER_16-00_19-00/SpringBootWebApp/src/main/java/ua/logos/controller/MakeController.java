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

import ua.logos.entity.MakeEntity;
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
	public ResponseEntity<Void> createMake(@RequestBody MakeEntity entity) {
		
		System.out.println(entity.getName());
		System.out.println(entity.getShortName());
		
		makeService.saveMake(entity);
		return new ResponseEntity<>(HttpStatus.CREATED); // code - 201
	}
	
	@GetMapping("/make/all")
	public ResponseEntity<List<MakeEntity>> getAllMakes() {
		List<MakeEntity> entities = makeService.getAllMakes();
	
		return new ResponseEntity<List<MakeEntity>>(entities, HttpStatus.OK);
	}
	
	@GetMapping("/make/{makeId}")
	public ResponseEntity<MakeEntity> getMakeById(
				@PathVariable("makeId") Long id
			) {
		System.out.println("Make ID: " + id);
		
		MakeEntity make = makeService.getMakeById(id);
		
		if(make == null) {
			return new ResponseEntity<MakeEntity>(HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<MakeEntity>(make, HttpStatus.OK);
	}
}
