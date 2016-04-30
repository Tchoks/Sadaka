package com.sadaka.service;

import java.util.Comparator;

import com.sadaka.model.Parameter;

public class CompareDate implements Comparator<Parameter> {

	@Override
	public int compare(Parameter o1, Parameter o2) {
			return o1.getDate().compareTo(o2.getDate());
	}

}
