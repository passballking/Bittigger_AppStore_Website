package com.appstore.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "app_info")
public class App {
	private String appid;
	private int score;
	private String title;
	private String url;
	private String thumbnail_url;
	private String intro;
	private String developer;
	private String top5App;
	

	@Id
	public String getAppid() {
		return appid;
	}
	public void setAppid(String appid) {
		this.appid = appid;
	}
	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getThumbnail_url() {
		return thumbnail_url;
	}
	public void setThumbnail_url(String thumbnail_url) {
		this.thumbnail_url = thumbnail_url;
	}
	public String getIntro() {
		return intro;
	}
	public void setIntro(String intro) {
		this.intro = intro;
	}
	public String getDeveloper() {
		return developer;
	}
	public void setDeveloper(String developer) {
		this.developer = developer;
	}
	public String getTop5App() {
		return top5App;
	}
	public void setTop5App(String top5App) {
		this.top5App = top5App;
	}
	
	@Override
	public String toString() {
		return "App [appid=" + appid + ", score=" + score + ", title=" + title
				+ ", url=" + url + ", thumbnail_url=" + thumbnail_url
				+ ", intro=" + intro + ", developer=" + developer
				+ ", top5App=" + top5App + "]";
	}
}
