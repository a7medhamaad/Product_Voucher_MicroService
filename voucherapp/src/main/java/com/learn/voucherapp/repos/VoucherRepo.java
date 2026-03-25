package com.learn.voucherapp.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.learn.voucherapp.model.Voucher;


public interface VoucherRepo extends JpaRepository<Voucher, Long> {

	Voucher findByCode(String code);
}
