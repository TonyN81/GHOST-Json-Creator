package com.ghostjsonconverter.dao;

import java.util.List;

import com.ghostjsonconverter.model.Task;

public interface TaskDao {
	
	public int save(List<Task> tasks);
}
