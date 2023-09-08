package com.psk.Store.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.psk.Store.entity.Admin;
import com.psk.Store.repository.AdminRepository;

@Service
public class AdminService 
{
	@Autowired
   private AdminRepository adminRepository;
	
	@Transactional(readOnly=true)
	public List<Admin> findAllAdmins()
	{
		return adminRepository.findAll();
	}
	
	@Transactional(readOnly=true)
	public Admin getAdminByAdminId(int adminId)
	{
		Optional<Admin> ot = adminRepository.findById(adminId);
		if(ot.isPresent())
			return ot.get();
		return new Admin();
	}
	
	@Transactional
	public boolean insertOrModifyAdmin(Admin admin)
	{
		if(adminRepository.save(admin) == null)
			return false;
			return true;
	}
	
	@Transactional
	public boolean deleteAdminByAdminId(int adminId)
	{
		long count = adminRepository.count();
		adminRepository.deleteById(adminId);
		if(count > adminRepository.count())
			return true;
		return false;
	}
	
	@Transactional
	public boolean countOfAdmin(String email,String password) 
	{
		return adminRepository.validateLogin(email, password);
	}

}
