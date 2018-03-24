package com.ghostjsonconverter.dao.impl;

import java.io.File;
import java.io.IOException;
import java.util.List;

import com.fasterxml.jackson.core.JsonEncoding;
import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonGenerator;
import com.ghostjsonconverter.constants.TaskField;
import com.ghostjsonconverter.dao.TaskDao;
import com.ghostjsonconverter.model.Task;

public class TaskJsonDaoImpl implements TaskDao {
	
	private static String TASK_OUTPUT_PATH = "src/main/output/tasks.json";
	
	private static JsonFactory jfactory = new JsonFactory();
	
	@Override
	public int save(List<Task> tasks) {
		JsonGenerator jGenerator = null;
		try {
			jGenerator = jfactory.createGenerator(new File(TASK_OUTPUT_PATH), JsonEncoding.UTF8);
			jGenerator.writeStartArray();
			
			for (Task task: tasks) {
				
		    	jGenerator.writeStartObject(); // {
		
		    	jGenerator.writeStringField(TaskField.URL.getField(), task.getUrl());
		    	jGenerator.writeStringField(TaskField.SIZE.getField(), task.getSize());
		    	jGenerator.writeStringField(TaskField.PROXY.getField(), task.getProxy());
		    	jGenerator.writeStringField(TaskField.ACCOUNT.getField(), task.getProxy());
		    	jGenerator.writeStringField(TaskField.PROFILE.getField(), task.getProfile());
		    	jGenerator.writeStringField(TaskField.PRODUCT.getField(), task.getProductUrl());
		
		    	jGenerator.writeEndObject(); // }
			}
			jGenerator.writeEndArray();
			jGenerator.close();
		} catch (IOException e) {
			System.out.println("Error with writing JSON file at " + TASK_OUTPUT_PATH);
			e.printStackTrace();
			return -1;
		}
		return 1;
	}

}
