package com.ghostjsonconverter.service;

import java.util.ArrayList;
import java.util.List;

import com.ghostjsonconverter.dao.impl.TaskJsonDaoImpl;
import com.ghostjsonconverter.model.Profile;
import com.ghostjsonconverter.model.Task;

public class TaskService {
	
	private TaskJsonDaoImpl taskDao = new TaskJsonDaoImpl();
	
	/**
	 * Saves Tasks to JSON file.
	 * @param tasks The list of Tasks
	 * @return true if success false otherwise.
	 */
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
	
	/**
	 * Creates tasks with Profiles and product url.
	 * @param profiles Profiles to create Tasks.
	 * @param url The product URL.
	 * @return List of Tasks.
	 */
	public List<Task> createTasks(List<Profile> profiles, String url) {
		List<Task> tasks = new ArrayList<>();
		
		for (Profile profile : profiles) {
			Task task = createTask(profile.getName(), url);
			tasks.add(task);
		}
		return tasks;
	}
	
	/**
	 * Creates an individual Task with profile name and URL.
	 * @param profileName The profile name.
	 * @param url product URL.
	 * @return Task.
	 */
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
