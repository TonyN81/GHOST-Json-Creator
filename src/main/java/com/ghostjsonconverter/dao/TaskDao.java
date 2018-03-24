package com.ghostjsonconverter.dao;

import java.util.List;

import com.ghostjsonconverter.model.Task;

public interface TaskDao {
	
	/**
	 * Save tasks to some form of persistence.
	 * @param tasks The list of tasks
	 * @return 1 if successful and -1 if unsuccessful.
	 */
	public int save(List<Task> tasks);
}
