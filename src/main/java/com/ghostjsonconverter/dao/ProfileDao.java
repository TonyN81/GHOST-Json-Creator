package com.ghostjsonconverter.dao;

import java.util.List;

import com.ghostjsonconverter.model.Profile;

public interface ProfileDao {
	
	public int save(List<Profile> profiles);
}
