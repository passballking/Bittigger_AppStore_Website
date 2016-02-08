package com.appstore.control;

import java.util.Arrays;
import java.util.List;

import javax.annotation.Resource;

import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.appstore.entity.App;
import com.appstore.service.AppService;

@Controller
public class AppController {
	@Resource
	private AppService appServ;
	//----------Get Top 10 Apps -------------
	@RequestMapping(value = "/app", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<App>> getTopApps() {
		List<App> appList = this.getAppServ().readTopApps(10);
		if(appList == null){
			System.out.println("no apps found");
			return new ResponseEntity<List<App>>(HttpStatus.NOT_FOUND);
		}
		HttpHeaders headers = new HttpHeaders();
		return new ResponseEntity<List<App>>(appList, headers, HttpStatus.OK);
	}
	
	//----------Get Recommadation Apps -------------
	@RequestMapping(value = "/similarApp", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<App>> getRecomApps(@RequestBody App detailApp) {
		System.out.println("detailApp =" + detailApp.getTop5App());
		String appIDsString = detailApp.getTop5App();
		List<App> appList;
		if(appIDsString == null){
			appList = null;
			HttpHeaders headers = new HttpHeaders();
			return new ResponseEntity<List<App>>(appList, headers, HttpStatus.OK);
		}
		List<String> appIDs = Arrays.asList(appIDsString.substring(1, appIDsString.length() - 1).split(", "));
		System.out.println("HAHA, I get here!" + appIDs.size());
		appList = this.getAppServ().readRecomApps(appIDs);
		if(appList == null){
			System.out.println("AppController: no apps found");
			return new ResponseEntity<List<App>>(HttpStatus.NOT_FOUND);
		}
		System.out.println(appList.size() + " " + appList.size());
		HttpHeaders headers = new HttpHeaders();
		return new ResponseEntity<List<App>>(appList, headers, HttpStatus.OK);
	}
		
	public AppService getAppServ() {
		return appServ;
	}
	
	public void setAppServ(AppService appServ) {
		this.appServ = appServ;
	}	
}
