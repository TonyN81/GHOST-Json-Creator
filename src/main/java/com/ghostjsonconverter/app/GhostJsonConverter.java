package com.ghostjsonconverter.app;

import java.io.IOException;
import java.util.List;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;

import com.ghostjsonconverter.model.Profile;
import com.ghostjsonconverter.model.Task;
import com.ghostjsonconverter.service.ProfileService;
import com.ghostjsonconverter.service.TaskService;

/**
 * Hello world!
 *
 */
public class GhostJsonConverter 
{
	private static ProfileService profileService = new ProfileService();
	private static TaskService taskService = new TaskService();
	
    public static void main( String[] args ) throws IOException, EncryptedDocumentException, InvalidFormatException
    {	
    	
    	if (args == null || args.length != 2) {
    		System.out.println("Error: Must provide 2 arguments, profile size and url.");
    	}
    	// get the argument as an int to know how many profiles to create
    	final int maxProfiles = Integer.parseInt(args[0]);
        final String url = args[1];
    	
        doJsonConversion(maxProfiles, url);
        
    }
    /**
     * Do the JSON conversions -
     * @param maxProfiles the max amount of profiles to make
     * @param taskUrl
     */
    private static void doJsonConversion(int maxProfiles, String taskUrl) {
    	
    	// create some profiles
    	List<Profile> profiles = profileService.createProfiles(maxProfiles);
    	// save the profiles to json
    	profileService.saveProfilesToJson(profiles);
    	
    	//use the profiles to create tasks
    	List<Task> tasks = taskService.createTasks(profiles, taskUrl);
    	// save the tasks to json
    	taskService.saveToJson(tasks);
    }
    
}
