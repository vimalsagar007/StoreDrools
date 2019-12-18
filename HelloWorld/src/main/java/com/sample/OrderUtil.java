package com.sample;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class OrderUtil {
	
	
	public static Set<String> getProductNames(ProductSummary productSummary){
		
		Set<String> productNames = new HashSet<>();
		
		for (Product product:productSummary.getProducts()) {
			productNames.add(product.getName());
		}
		return productNames;
		
	}
	
	public static Map<String,List<Product>> createProductMap(Set<String> productNames,ProductSummary productSummary){
		Map<String,List<Product>> map = new HashMap<>();
		List<Product> productList = new ArrayList<Product>();
		int count=1;
		for (Product product:productSummary.getProducts()) {
			if(productNames.contains(product.getName())){
				productList.add(product);
				
			}
			
		}
		
		return map;
	}

}
