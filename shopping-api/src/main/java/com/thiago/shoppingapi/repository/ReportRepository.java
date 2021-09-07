package com.thiago.shoppingapi.repository;

import java.util.Date;
import java.util.List;

import com.thiago.shoppingapi.dto.ShopReportDTO;
import com.thiago.shoppingapi.model.Shop;

public interface ReportRepository {

	public List<Shop> getShopByFilters(Date dataInicio, Date dataFim, Float valorMinimo);
	
	public ShopReportDTO getReportByDate(Date dataInicio, Date dataFim);

}
