package com.jbk.model;

import java.util.Comparator;

public class PriceComparator implements Comparator<ProductModel> {

	@Override
	public int compare(ProductModel o1, ProductModel o2) {
		if(o1.getProductPrice()>o2.getProductPrice())
			return 1;
		else
		return -1;
		
	}

}
