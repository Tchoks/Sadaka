package com.sadaka.service;

import java.io.File;
import java.io.IOException;
import java.util.Optional;
import java.util.Set;
import java.util.TreeSet;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.jgroups.protocols.FILE_PING;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sadaka.exceptions.BusinessException;
import com.sadaka.model.Parameter;

@Service("ParameterService")
public class ParameterServiceImpl implements ParameterService {
	
	private static Logger logger = null;

	private static final String FILE_PATH = "/Users/martintchokonthe/Documents/SadakaLocal/Sadaka/conf.json";
	
	private Set<Parameter> parameters = new TreeSet<>(new CompareDate());

	public ParameterServiceImpl() {
		logger = Logger.getLogger(ParameterServiceImpl.class.getName());
		parameters = readJson(FILE_PATH);
	}
	
		
	
	@SuppressWarnings("deprecation")
	public  Set<Parameter> readJson(String filePath){
		logger.info("Read the json file and fill the list");
		ObjectMapper mapper = new ObjectMapper();
		Set<Parameter> list = new TreeSet<>(new CompareDate());
		try{
			JsonFactory f = new JsonFactory();
			JsonParser jp = f.createJsonParser(new File(filePath));
			while(jp.nextToken() == JsonToken.START_OBJECT){
				Parameter parameter;
				parameter = mapper.readValue(jp,Parameter.class);
				list.add(parameter);
			}
		}catch(IOException e){
			logger.log(Level.INFO, e);
		}
		return list;	
	}
	
	public void writeJson(Set<Parameter> parameters,String filePath){
		logger.info("Write parameters of the list into the json file");
		ObjectMapper mapper = new ObjectMapper();
		try{
			mapper.writerWithDefaultPrettyPrinter().writeValue(new File(filePath),parameters);
		}catch(IOException e){
			logger.log(Level.INFO,e);
		}
	}

	@Override
	public Parameter findParameter(String date, String parameter) throws BusinessException {
		logger.info("Searching the Parameter with date: "+date+" and parameter = "+parameter);
		Optional<Parameter> opt = parameters.stream().filter(p -> p.getDate().equals(date) && p.getParameter().equals(parameter)).findFirst();
		if(opt.isPresent()){
			return opt.get();
		}
		throw new BusinessException("Parameter doesn't exist");
	}

	@Override
	public Parameter createParameter(Parameter parameter) throws BusinessException {
		logger.info("Creating a new parameter");
		Parameter p = findParameter(parameter.getDate(),parameter.getParameter()); 
		if(p!=null){
			parameters.add(parameter);
			writeJson(parameters,FILE_PATH);
			logger.info("Parameter created successfully");
		}
		throw new BusinessException("This parameter already exist!");
	}

	@Override
	public Parameter updateParameter(Parameter parameter) throws BusinessException {
		logger.info("Updating parameter: "+parameter);
		Parameter p = findParameter(parameter.getDate(),parameter.getParameter());
		if(p!=null){
			p.setValue(parameter.getComment());
			p.setValue(parameter.getValue());
			writeJson(parameters,FILE_PATH);
			logger.info("Parameter updated successfully");
		}
		throw new BusinessException("Parameter cannot be updated because it doesn't existed");
	}

	@Override
	public void deleteParameter(String date, String parameter) throws BusinessException {
        logger.info("deleting the paramter with date:"+date+" and containing the parameter: "+parameter);
       Optional<Parameter> opt =  parameters.stream().filter(p -> p.getDate().equals(date) && p.getParameter().equals(parameter)).findFirst();
        if(opt.isPresent()){
        	  parameters.remove(opt.get());
        	  writeJson(parameters,FILE_PATH);
        	  logger.info("Parameter successfully deleted");
        }
		throw new BusinessException("Parameter cannot be deleted because it doesn't existed");
	}

	@Override
	public Set<Parameter> listAllParameters() {
		return parameters;
	}

}
