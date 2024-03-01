package com.ait.service;

import java.util.List;

import com.ait.entity.CompanyEntity;

public interface CompanyService {
	
	public String createCompany(CompanyEntity entity);

	public CompanyEntity getCompanyById(Integer id);

	public List<CompanyEntity> getAllCompanies();

	public boolean deleteCompanyId(Integer id);

	public CompanyEntity UpdateCompany(Integer id, CompanyEntity entity);

}
