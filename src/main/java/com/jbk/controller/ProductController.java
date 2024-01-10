package com.jbk.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jbk.exception.ProductAlreadyExistException;
import com.jbk.exception.ProductDoesNotFoundException;
import com.jbk.exception.SomethingWentWrongException;
import com.jbk.model.ProductModel;
import com.jbk.service.ProductService;
import com.jbk.service.impl.ProductServiceImpl;

@RestController
public class ProductController {

	ProductService service=new ProductServiceImpl();
	@PostMapping("/addProduct")
	public String addProduct(@RequestBody @Valid ProductModel productModel) {
		int status = service.addProduct(productModel);
		if(status==1) {
			return "Added succesfully";
		}
		else if(status==2){
			throw new ProductAlreadyExistException("Product is already exists:"+productModel.getProductName());
			
		}
		else {
			throw new SomethingWentWrongException("Something went wrong");
		}
		
	}
	
	@GetMapping("/getProductById/{productId}")
	public Object getProductById(@PathVariable long productId) {
		ProductModel productModel = service.getProductById(productId);
		if(productModel!=null) {
			return productModel;
			}
		else {
			throw new ProductDoesNotFoundException("This product does not exist in Database");
		}
	
	}
	
	@DeleteMapping("/deleteProductById/{productId}")
	public String deleteProductById(@PathVariable long productId) {
		Boolean deleteProduct = service.deleteProductById(productId);
		if(deleteProduct!=null) {
			return "Product deleted succesfully::"+productId;
		}
		else {
			return "This product does not exist in database::"+productId;
		}
	
	}
	
	@PutMapping("/updateProduct")
	public String updateProduct(@RequestBody  ProductModel productModel) {
		int up = service.updateProduct(productModel);
		if(up==1) {
			return "Product updated succesfully::"+productModel.getProductId();
		}
		else {
			return "This product does not exist in database::"+productModel.getProductId();
		}
		
	
	}
	
	@GetMapping("/getAllProducts")
	public Object getAllProducts() {
		List<ProductModel> allProducts = service.getAllProducts();
		if(allProducts!=null) {
			return allProducts;
		}
		else {
			return "Something went wrong";
		}
		
		}
	
	@GetMapping("/getProductByName/{productName}")
	public Object getProductByName(@PathVariable String productName) {
		ProductModel productByName = service.getProductByName(productName);
		if(productByName!=null) {
			return productByName;
		}
		else {
			return "This product name does not exist in database";
		}
		
	}
	
	
	
	@GetMapping("/getProductByGreaterPrice/{productPrice}")
	public Object getProductByGreaterPrice(@PathVariable double productPrice) {
		Object productByGreaterPrice = service.getProductByGreaterPrice(productPrice);
		if(productByGreaterPrice!=null) {
			return productByGreaterPrice;
		}
		else {
			return "Product's with greater than this price does not exist in database";
		}
		
}
	
	@GetMapping("/sortProductByPrice")
	public List<ProductModel> sortProductByPrice() {
		
	return service.sortProductByPrice();
		
		}
	
	@GetMapping("/sortProductByName")
	public List<ProductModel> sortProductByName() {
		
	return service.sortProductByName();
		
		}
	
	@GetMapping("/maxPrice")
	public double maxPrice() {
		
	 ProductModel maxPrice = service.maxPrice();
	 double price=maxPrice.getProductPrice();
	 return price;
		
		}
	
	@GetMapping("/get-CostRange-Product")
	public Object findProductsInPriceRange(@RequestParam double low, @RequestParam double high){
		List<ProductModel> ProductsInPriceRange = service.findProductsInPriceRange(low, high);
		if(ProductsInPriceRange!=null) {
			return ProductsInPriceRange;
		}
		else {
			return "Products in this range does not exist";
		}
		
	}
	@GetMapping("/sort-product/{orderType}/{propertyName}")
	public Object sort(@PathVariable String orderType ,@PathVariable String propertyName ){
		
		Object list = service.sort(orderType, propertyName);
		
		return list;
	
	}
	
	
}