package com.psk.Store.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import com.psk.Store.entity.Admin;
import com.psk.Store.service.AdminService;


@RestController
@CrossOrigin(origins = {"http://localhost:4200"})
@RequestMapping("/admin")
public class AdminController 
{
	@Autowired
	private AdminService adminService;
	@GetMapping()
	public ResponseEntity<List<Admin>> getAllTheAdmins()
	{
		List<Admin> Alist = adminService.findAllAdmins();
		if(Alist.size()!=0)
			return new ResponseEntity<List<Admin>>(Alist,HttpStatus.OK);
		return new ResponseEntity<List<Admin>>(Alist,HttpStatus.NOT_FOUND);
	}
	
	//@GetMapping("/{trainId}")
	@GetMapping(value="/{adminId}", produces="application/json")
	public ResponseEntity<Admin> getAdminByAdminId(@PathVariable int adminId)
	{
		Admin a = adminService.getAdminByAdminId(adminId);
		if(a!=null)
			return new ResponseEntity<Admin>(a, HttpStatus.OK);
		return new ResponseEntity<Admin>(a,HttpStatus.NOT_FOUND);
	}
	
	@PostMapping(value="/signup", consumes="application/json")
	public HttpStatus insertAdmin(@RequestBody Admin admin)
	{
		adminService.insertOrModifyAdmin(admin);
		return HttpStatus.OK;
	}
	
	@PutMapping(value="/", consumes="application/json")
	public HttpStatus modifyAdmin(@RequestBody Admin admin)
	{
		adminService.insertOrModifyAdmin(admin);
		return HttpStatus.OK;
	}
	
	@DeleteMapping("/{adminId}")
	public HttpStatus deleteAdmin(@PathVariable int adminId)
	{
		if(adminService.deleteAdminByAdminId(adminId))
			return HttpStatus.OK;
		return HttpStatus.NOT_FOUND;
	}

	@PostMapping(value="/login",consumes="application/json")
	public boolean countOfValidAdmin(@RequestBody Admin admin) 
	{
		return adminService.countOfAdmin(admin.getEmail(),admin.getPassword());
	}
	
}
