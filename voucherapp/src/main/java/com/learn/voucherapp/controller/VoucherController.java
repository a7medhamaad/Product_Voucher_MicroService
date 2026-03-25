package com.learn.voucherapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.learn.voucherapp.model.Voucher;
import com.learn.voucherapp.repos.VoucherRepo;

@Controller
public class VoucherController {

	@Autowired
	private VoucherRepo repo;
	
	@GetMapping("/showCreateVoucher")
	public String showCreateVoucher() {
		return "createVoucher";
	}
	
	@PostMapping("/saveVoucher")
	public String saveVoucher(Voucher voucher) {
		repo.save(voucher);
		return "createResponse";
	}
	
 
	
	@PostMapping("/getVoucher")
	public ModelAndView getVoucher(String code) {
		ModelAndView mav =new ModelAndView("VoucherDetails");
		System.out.println(code);
		mav.addObject("voucher", repo.findByCode(code));
		return mav;
	}
}
