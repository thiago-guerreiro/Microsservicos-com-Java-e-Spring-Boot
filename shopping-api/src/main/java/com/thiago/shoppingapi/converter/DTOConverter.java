package com.thiago.shoppingapi.converter;

import java.util.stream.Collectors;

import com.thiago.shoppingapi.model.Item;
import com.thiago.shoppingapi.model.Shop;
import com.thiago.shoppingclient.dto.ItemDTO;
import com.thiago.shoppingclient.dto.ShopDTO;

public class DTOConverter {

	public static ItemDTO convert(Item item) {
		ItemDTO itemDTO = new ItemDTO();
		itemDTO.setProductIdentifier(item.getProductIdentifier());
		itemDTO.setPrice(item.getPrice());
		return itemDTO;
	}

	public static ShopDTO convert(Shop shop) {
		ShopDTO shopDTO = new ShopDTO();
		shopDTO.setUserIdentifier(shop.getUserIdentifier());
		shopDTO.setTotal(shop.getTotal());
		shopDTO.setDate(shop.getDate());
		shopDTO.setItems(shop.getItems().stream().map(DTOConverter::convert).collect(Collectors.toList()));
		return shopDTO;
	}

}
