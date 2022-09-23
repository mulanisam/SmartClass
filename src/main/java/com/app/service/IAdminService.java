package com.app.service;

import java.util.List;

import com.app.dto.AdminLoginResponse;

public interface IAdminService {
	AdminLoginResponse login(String email, String password, String role);

	List<String> getAllRequest(String role);
}
