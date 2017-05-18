package com.cn.core.config;

public class JProperties {
	/*private String zkNodes;//zookeeper字符串、使用逗号隔开
	private String kkBrokes;//kafka字符串、使用逗号隔开	
	private String dmpAdverTopic;//广告主topic
	private String dmpTaskTopic;//任务topic
	private String dmpGroup;//dmp
	private String rdNodes;//redis节点字符串*/
	
	private String filters;//不拦截的servlet请求

	public String getFilters() {
		return filters;
	}

	public void setFilters(String filters) {
		this.filters = filters;
	}

	@Override
	public String toString() {
		return "JProperties [filters=" + filters + "]";
	}
	
	
}
