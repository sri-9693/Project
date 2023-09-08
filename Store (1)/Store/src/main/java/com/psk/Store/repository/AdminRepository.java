package com.psk.Store.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.psk.Store.entity.Admin;

public interface AdminRepository extends JpaRepository<Admin, Integer>
{
	@Query("SELECT CASE WHEN COUNT(a) = 1 THEN true ELSE false END FROM Admin a WHERE a.email = :emailId AND a.password = :password")

    boolean validateLogin(

        @Param("emailId") String email,

        @Param("password") String password

    );	

}
