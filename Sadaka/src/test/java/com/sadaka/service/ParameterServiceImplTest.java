package com.sadaka.service;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Set;
import java.util.TreeSet;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.runners.MockitoJUnitRunner;

import com.sadaka.model.Parameter;

@RunWith(MockitoJUnitRunner.class)
public class ParameterServiceImplTest {
	
	private Set<Parameter> parameters;
	private static final String FILE_PATH = "/Users/martintchokonthe/Documents/SadakaLocal/Sadaka/file.json";
	private static final String FILE_PATH_BACKUP = "/Users/martintchokonthe/SadakaLocal/workspace/Sadaka/conf.json";
	
	public ParameterServiceImplTest() {
		parameters = new TreeSet<>(new CompareDate());
	}
	
	@InjectMocks
	ParameterServiceImpl service;
	
	
	
	@Before
	public void setUp() {
	parameters = service.readJson(FILE_PATH);
	service.writeJson(parameters, FILE_PATH_BACKUP);
	}
	
	
	
	
	
	@Test
	public void testGetAllParameters(){
		Set<Parameter> list = service.listAllParameters();
		System.out.println(list);
		Assert.assertNotNull("failure - expected the list to be not null", list);
		Assert.assertEquals("failure expected list size",4,list.size());
		
	}
	
	

}
