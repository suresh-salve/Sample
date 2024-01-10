package com.jbk.service.impl;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.jbk.dao.ProductDao;
import com.jbk.dao.impl.ProductDaoImpl;
import com.jbk.model.ProductModel;
import com.jbk.service.ProductService;

public class ProductServiceImpl implements ProductService {

	ProductDao dao=new ProductDaoImpl();
	@Override
	public int addProduct(ProductModel productModel) {
		//String timeStamp = new SimpleDateFormat("yyyyMMddHHmmss").format(new java.util.Date());
		 //java.sql.Date createdDate=new java.sql.Date(System.currentTimeMillis());
		//productModel.setProductId(Long.parseLong(timeStamp));
		 LocalDate createdDate=LocalDate.now();
		productModel.setCreatedDate(createdDate);
		
		return dao.addProduct(productModel);
	}
	@Override
	public ProductModel getProductById(long productId) {
		
		
		return dao.getProductById(productId);
	}
	@Override
	public Boolean deleteProductById(long productId) {
		
		return dao.deleteProductById(productId);
	}
	@Override
	public int updateProduct(ProductModel productModel) {
		
		return dao.updateProduct(productModel);
	}
	@Override
	public List<ProductModel> getAllProducts() {
		
		return dao.getAllProducts();
	}
	@Override
	public ProductModel getProductByName(String productName) {
		
		return dao.getProductByName(productName);
	}
	@Override
	public Object getProductByGreaterPrice(double productPrice) {
		
		return dao.getProductByGreaterPrice(productPrice);
	}
	@Override
	public List<ProductModel> sortProductByPrice() {
		
		return dao.sortProductByPrice();
	}
	@Override
	public List<ProductModel> sortProductByName() {
		
		return dao.sortProductByPrice();
	}
	@Override
	public ProductModel maxPrice() {
		
		return dao.maxPrice();
	}
	@Override
	public List<ProductModel> findProductsInPriceRange(double low, double high) {
		// TODO Auto-generated method stub
		return dao.findProductsInPriceRange(low, high);
	}
	@Override
	public Object sort(String orderType, String propertyName) {
		List<ProductModel> list = getAllProducts();
		Comparator<ProductModel> comparator=null;
		if(!list.isEmpty()) {
			switch (propertyName) {
			case "productName":{
				comparator=Comparator.comparing(ProductModel::getProductName);
		
				break;
			}
            case "productPrice":{
            	
            	comparator=Comparator.comparing(ProductModel::getProductPrice);
            	
            	break;
            }
		
			default:
				break;
			}
			if(orderType.equalsIgnoreCase("desc")) {
				comparator=comparator.reversed();
			}
			
			Stream<ProductModel> sorted = list.stream().sorted(comparator);
			 list = sorted.collect(Collectors.toList());
			
		}
		else {
			
			return list;
		}
		return list;
		
	}
	

}
