package com.ghostjsonconverter.service;

import java.util.ArrayList;
import java.util.List;

import com.ghostjsonconverter.dao.impl.TaskJsonDaoImpl;
import com.ghostjsonconverter.model.Profile;
import com.ghostjsonconverter.model.Task;

public class TaskService {
	
	private TaskJsonDaoImpl taskDao = new TaskJsonDaoImpl();
	
	public boolean saveToJson(List<Task> tasks) {
		if (taskDao.save(tasks) < 0) {
			System.out.println("Failed to save tasks.");
			return false;
		}
		else {
			System.out.println("Successfully saved " + tasks.size() + " tasks.");
			return true;
		}
	}
	public List<Task> createTasks(List<Profile> profiles, String url) {
		List<Task> tasks = new ArrayList<>();
		
		for (Profile profile : profiles) {
			Task task = createTask(profile.getName(), url);
			tasks.add(task);
		}
		return tasks;
	}
	
	private Task createTask(String profileName, String url) {
		Task task = new Task();
		task.setAccount("");
		task.setProductUrl(url);
		task.setProfile(profileName);
		task.setProxy("");
		task.setSize("R");
		task.setUrl(url);
		return task;
	}

}
