package com.appstore.dao;

import java.util.List;

import com.appstore.entity.App;

public interface AppDao {
	public App createApp(App appObj);
	public App deleteApp(App appObj);
	public App updateApp(App appObj);
	public App readApp(App appObj);
	
	public List<App> readAppByCatalog(String catalogID);
	public List<App> readAppByUser(String userID);
	public List<App> readTopApps(int topN);
	
	public List<App> readRecomApps(List<String> appIDs);
}
