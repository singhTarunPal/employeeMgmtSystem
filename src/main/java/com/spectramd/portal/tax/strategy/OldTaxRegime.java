package com.spectramd.portal.tax.strategy;

import com.spectramd.portal.Entity.Deductions;
import com.spectramd.portal.Entity.Earnings;
import com.spectramd.portal.model.Savings;

public class OldTaxRegime implements TaxRegimeStrategy {

	@Override
	public Integer calculateTax(Earnings earnings,Deductions deductions, Savings savings) {
		System.out.println("Calculate tax with old tax regime");
		return earnings.sum() 
				- (deductions !=null? deductions.sum():0) 
				- (savings !=null?savings.sum():0);
	}

}
