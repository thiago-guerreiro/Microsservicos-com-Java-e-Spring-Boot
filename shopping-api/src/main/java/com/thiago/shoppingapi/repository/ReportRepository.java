package com.thiago.shoppingapi.repository;

import java.util.Date;
import java.util.List;

import com.thiago.shoppingapi.model.Shop;
import com.thiago.shoppingclient.dto.ShopReportDTO;

public interface ReportRepository {

	public List<Shop> getShopByFilters(Date dataInicio, Date dataFim, Float valorMinimo);
	
	public ShopReportDTO getReportByDate(Date dataInicio, Date dataFim);

}
