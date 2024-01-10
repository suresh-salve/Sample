package com.jbk.dao;

import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import com.jbk.model.ProductModel;

public interface ProductDao {
	public int addProduct(ProductModel productModel);
	public ProductModel getProductById(long productId);
	public Boolean deleteProductById(long productId);
	public int updateProduct(ProductModel productModel) ;
	public List<ProductModel> getAllProducts();
	public ProductModel getProductByName(String productName);
	public Object getProductByGreaterPrice(double productPrice);
	public List<ProductModel> sortProductByPrice();
	public List<ProductModel> sortProductByName();
	public ProductModel maxPrice();
	public List<ProductModel> findProductsInPriceRange( double low,  double high);
}
