package com.appstore.service;

import java.util.List;

import com.appstore.entity.App;

public interface AppService {
	public App readApp(App appObj);
	public List<App> readRecomApps(List<String> appIDs);
	public List<App> readTopApps(int topN);
}
