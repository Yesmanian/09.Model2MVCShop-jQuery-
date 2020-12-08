package com.model2.mvc.web.product;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.model2.mvc.service.domain.Product;
import com.model2.mvc.service.domain.User;
import com.model2.mvc.service.product.ProductService;

@RestController
@RequestMapping("/product/*")
public class ProductRestController {
	
	//Field
	@Autowired
	@Qualifier("productServiceImpl")
	private ProductService productService;
	
	@Value("#{commonProperties['pageUnit']}")
	int pageUnit;
	@Value("#{commonProperties['pageSize']}")
	int pageSize;
	
	
	//Constructor
	public ProductRestController() {
		System.out.println("::ProductRestController default Constructor");
	}
	
	@RequestMapping(value = "json/getProduct/{prod_No}",method = RequestMethod.GET)
	public Product getProduct( @PathVariable int prod_No) throws Exception{
		
		System.out.println("/product/json/getProduct : GET");
		
		System.out.println(prod_No);
//		int prodNo = Integer.parseInt(prod_No); 
		//Business Logic
		return productService.getProduct(prod_No);
		
	}
	
	
	
	@RequestMapping(value = "json/addProduct")
	public Map addProduct(@RequestBody Product product) throws Exception {
	
		System.out.println("/product/json/addProduct : POST");
		
		//business Logic
		System.out.println("::"+product);
		productService.addProduct(product);
//		
		String returnString = "상품이 추가되었숩나더";
		
		Map map = new HashMap<String, String>();
		map.put("m", "상품이 추가되었숩나더");
		
		return map;
	}
	
	
}
