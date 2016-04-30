package com.sadaka.service;

import java.util.Set;

import com.sadaka.exceptions.BusinessException;
import com.sadaka.model.Parameter;

public interface ParameterService {
	
	Parameter findParameter(String date,String parameter) throws BusinessException;
	
	Parameter createParameter(Parameter parameter) throws BusinessException;
	
	Parameter updateParameter(Parameter parameter) throws BusinessException;
	
	void deleteParameter(String date,String parameter) throws BusinessException;
	
	Set<Parameter> listAllParameters();

}
