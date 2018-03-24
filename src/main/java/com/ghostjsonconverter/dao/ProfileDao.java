package com.ghostjsonconverter.dao;

import java.util.List;

import com.ghostjsonconverter.model.Profile;

public interface ProfileDao {
	
	/**
	 * Save profiles to some form of persistence.
	 * @param profiles The list of profiles
	 * @return 1 if successful and -1 if unsuccessful.
	 */
	public int save(List<Profile> profiles);
}
