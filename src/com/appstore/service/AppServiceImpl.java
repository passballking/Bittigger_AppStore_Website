package com.appstore.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.transaction.annotation.Transactional;

import com.appstore.dao.AppDao;
import com.appstore.entity.App;

public class AppServiceImpl implements AppService {
	@Resource
	private AppDao appDao;
	@Override
	public App readApp(App appObj) {
		// TODO Auto-generated method stub
		return appDao.readApp(appObj);
	}
	
	@Override
	@Transactional
	public List<App> readRecomApps(List<String> appIDs) {
		// TODO Auto-generated method stub
		return appDao.readRecomApps(appIDs);
	}

	@Override
	@Transactional
	public List<App> readTopApps(int topN) {
		// TODO Auto-generated method stub
		return appDao.readTopApps(topN);
	}

	public AppDao getAppDao() {
		return appDao;
	}

	public void setAppDao(AppDao appDao) {
		this.appDao = appDao;
	}

	
}
