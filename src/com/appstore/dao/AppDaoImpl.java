package com.appstore.dao;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.appstore.entity.App;

public class AppDaoImpl implements AppDao{
	@Resource
	private SessionFactory sessionFactory;
	
	public Session getSession() {
		return this.sessionFactory.getCurrentSession();
	}
	
	
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}


	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	@Override
	public App createApp(App appObj) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public App deleteApp(App appObj) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public App updateApp(App appObj) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public App readApp(App appObj) {
		// TODO Auto-generated method stub
		return (App) this.getSession().get(App.class, appObj.getAppid());
	}

	@Override
	public List<App> readAppByCatalog(String catalogID) {
		// TODO Auto-generated method stub
		
		return null;
	}

	@Override
	public List<App> readAppByUser(String userID) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<App> readTopApps(int topN) {
		System.out.println("how about here?");
		// TODO Auto-generated method stub
		if(topN == 0){
			return null;
		}
		Criteria crit = this.getSession().createCriteria(App.class);
		crit.setMaxResults(topN);
		List<App> res = crit.list();
		return res;
	}

	@Override
	public List<App> readRecomApps(List<String> appIDs) {
		List<App> apps = new ArrayList<App>();
		if(appIDs == null || appIDs.size() == 0){
			return null;
		}
		for(String appID : appIDs){
			apps.add((App) this.getSession().get(App.class, appID));
		}
		return apps;
		
	}
	

}
