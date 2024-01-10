package com.jbk.dao.impl;

import java.sql.Date;
import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import com.jbk.dao.ProductDao;
import com.jbk.model.NameComparator;
import com.jbk.model.PriceComparator;
import com.jbk.model.ProductModel;

public class ProductDaoImpl implements ProductDao {

	 LocalDate createdDate=LocalDate.now();
	List<ProductModel> list=new ArrayList<>();
	 public ProductDaoImpl() {
		 list.add(new ProductModel(1l,"laptop",20000d,10,LocalDate.of(2020, Month.SEPTEMBER, 1),LocalDate.of(2026, Month.JANUARY, 1),createdDate));
		 list.add(new ProductModel(2l,"pen",200d,10,LocalDate.of(2021, Month.AUGUST, 10),LocalDate.of(2024, Month.APRIL, 14),createdDate));
		 list.add(new ProductModel(3l,"shirt",1200d,10,LocalDate.of(2020, Month.SEPTEMBER, 17),LocalDate.of(2025, Month.JULY, 15),createdDate));
	 }
	
	@Override
	public int addProduct(ProductModel productModel) {
		int status=0;
		for (ProductModel pro : list) {
			if(pro.getProductName().equals(productModel.getProductName()))
			{
				status=2;
				break;
			}
		}
		if(status !=2) {
			try {
					list.add(productModel);
					status=1;
					
				} catch (Exception e) {
					e.printStackTrace();
					status=3;
				}
				
			}
		for (ProductModel prodModel : list) {
			System.out.println(prodModel);
		}
		return status;
	}

	@Override
	public ProductModel getProductById(long productId) {
		for (ProductModel pro : list) {
			if(pro.getProductId()==productId)
				return pro;
		}
		return null;
	}

	@Override
	public Boolean deleteProductById(long productId) {
		for (ProductModel pro : list) {
			if(pro.getProductId()==productId) {
			return list.remove(pro);
			}
			
		}
		return null;
	}

	@Override
	public int updateProduct(ProductModel productModel) {
		for (ProductModel pro : list) {
			if(pro.getProductId()==productModel.getProductId()) {
				pro.setProductName(productModel.getProductName());
				pro.setProductPrice(productModel.getProductPrice());
				pro.setProductQty(productModel.getProductQty());
				pro.setMfgDate(productModel.getMfgDate());
				pro.setExpDate(productModel.getExpDate());
				return 1;
				
			}
		}

		return 0;
	}

	@Override
	public List<ProductModel> getAllProducts() {
	
		return list;
	}

	@Override
	public ProductModel getProductByName(String productName) {
		for (ProductModel pro : list) {
			if(pro.getProductName().equals(productName)) {
				return pro;
			}
		}
		return null;
	}

	@Override
	public Object getProductByGreaterPrice(double productPrice) {
		List<ProductModel> list1=new ArrayList<>();
		for (ProductModel pro : list) {
			if(pro.getProductPrice()>productPrice) {
				list1.add(pro);
				return list1;
				}
		
			}
		return null;
		}

	@Override
	public List<ProductModel> sortProductByPrice() {
		 Collections.sort(list, new PriceComparator());
		 
		return list;
	}

	@Override
	public List<ProductModel> sortProductByName() {
		 Collections.sort(list, new NameComparator());
		 
		return null;
	}

	@Override
	public ProductModel maxPrice() {
		
		 ProductModel d=Collections.max(list, new PriceComparator());
		 
		return d;
	}

	@Override
	public List<ProductModel> findProductsInPriceRange(double low, double high) {
		List<ProductModel> list1=new ArrayList<>();
		for (ProductModel pro : list) {
			if(pro.getProductPrice()>=low && pro.getProductPrice()<=high) {
				list1.add(pro);
				return list1;
				}
			}
		return null;
	}

}
