package com.Shopping.Controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.Shopping.Exceptions.AdminException;
import com.Shopping.Exceptions.LoginException;
import com.Shopping.Model.Admin;
import com.Shopping.Services.AdminServices;

@RestController
public class AdminController {

	@Autowired
	private AdminServices aservice;
	
	@PostMapping("/addAdmin")
	public ResponseEntity<Admin> addAdminHandler(@Valid @RequestBody Admin admin) throws AdminException{
		
		Admin savedAdmin = aservice.addadmin(admin);
		
		return new ResponseEntity<Admin>(savedAdmin,HttpStatus.ACCEPTED);
	}
	
	@PutMapping("/updateAdmin")
	public ResponseEntity<Admin> updateAdminHandler(@RequestBody Admin admin,@RequestParam String key) throws AdminException,LoginException{
		
		Admin savedAdmin = aservice.updateAdmin(admin, key);
		
		return new ResponseEntity<Admin>(savedAdmin,HttpStatus.ACCEPTED);
	}
	
	@DeleteMapping("/deleteAdmin")
	public ResponseEntity<String> deleteAdminHandler(@RequestParam Integer adminId,@RequestParam String key) throws AdminException,LoginException{
		
		String message = aservice.deleteAdmin(adminId, key);
		
		return new ResponseEntity<String>(message,HttpStatus.ACCEPTED);
	}
	
	@GetMapping("/getAdmin")
	public ResponseEntity<Admin> getAdminByIdHandler(@RequestParam Integer adminId,@RequestParam String key) throws AdminException,LoginException{
		
		Admin savedAdmin = aservice.getAdminById(adminId, key);
		
		return new ResponseEntity<Admin>(savedAdmin,HttpStatus.ACCEPTED);
	}
}
