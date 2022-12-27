package com.intelligicsoftware.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.intelligicsoftware.dto.AdminDto;
import com.intelligicsoftware.dto.DonarDto;
import com.intelligicsoftware.dto.LoginDto;
import com.intelligicsoftware.dto.PartnerDto;
import com.intelligicsoftware.dto.StaffDto;
import com.intelligicsoftware.service.AdminService;
import com.intelligicsoftware.service.DonarService;
import com.intelligicsoftware.service.LoginService;
import com.intelligicsoftware.service.PartnerService;
import com.intelligicsoftware.service.StaffService;

@RestController
@RequestMapping("/api")
public class LoginController {
	@Autowired
	private LoginService loginService;
	@Autowired
	private StaffService staffService;

	@Autowired
	private AdminService adminService;

	@Autowired
	private PartnerService partnerService;
	@Autowired
	private DonarService donarService;

	@GetMapping("/get/{loginUsername}/{loginPassword}")
	public Object getLogin(@PathVariable String LoginUsername, @PathVariable String LoginPassword) {
		LoginDto login = this.loginService.getLogin(LoginUsername, LoginPassword);

		if (login.getLoginType().equalsIgnoreCase("staff")) {
			StaffDto staffDto = this.staffService.getStaffByLogin(login);

			return staffDto;
		} else if (login.getLoginType().equalsIgnoreCase("Admin")) {
			AdminDto admindto = this.adminService.getAdminByLogin(login);
			return admindto;
		} else if (login.getLoginType().equalsIgnoreCase("partner")) {
			PartnerDto partnerByLogin = this.partnerService.getPartnerByLogin(login);
			return partnerByLogin;
		} else if (login.getLoginType().equalsIgnoreCase("donar")) {
			DonarDto donarByLogin = this.donarService.getDonarByLogin(login);
			return donarByLogin;

		}

		return login;
	}

}
