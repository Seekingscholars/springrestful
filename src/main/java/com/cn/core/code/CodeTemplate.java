package com.cn.core.code;

import org.apache.commons.lang.StringUtils;

public class CodeTemplate {

	private String packageName = "";
	private String entityName = "";
	private String tableName = "";
	
	private String entityPackage = "";
	private String servicePackage = "";
	private String serviceImplPackage = "";
	private String controllerPackage = "";
	private String daoPackage = "";
	private String daoImplPackage = "";
	
	private String serviceName = "";
	private String serviceImplName = "";
	private String controllerName = "";
	private String daoName = "";
	private String daoImplName = "";
	
	public CodeTemplate(String packageName, String entityName, String tableName) {
		this.packageName = packageName;
		this.entityName = entityName;
		this.tableName = tableName;
		entityPackage = String.format("com.cn.%s.entity", packageName);
		servicePackage = String.format("com.cn.%s.service", packageName);
		serviceImplPackage = String.format("com.cn.%s.service.impl", packageName);
		controllerPackage = String.format("com.cn.%s.controller", packageName);
		daoPackage = String.format("com.cn.%s.dao", packageName);
		daoImplPackage = String.format("com.cn.%s.dao.impl", packageName);

		serviceName = String.format("%sService", entityName);
		serviceImplName = String.format("%sServiceImpl", entityName);
		controllerName = String.format("%sController", entityName);
		daoName = String.format("%sDao", entityName);
		daoImplName = String.format("%sDaoImpl", entityName);
	}
	
	public String entity(){
		StringBuilder sb = new StringBuilder();
		sb.append("package ").append(entityPackage).append(";\n");
		sb.append("import javax.persistence.Entity;\n");
		sb.append("/**\n *\n */\n");
		sb.append("@Entity\n");
		sb.append("public class ").append(entityName).append(" {\n");
		sb.append("\n");
		
		sb.append("}");
		return String.format(sb.toString(), tableName, entityName);
	}	
	
	public String service(){
		StringBuilder sb = new StringBuilder();
		sb.append("package ").append(servicePackage).append(";\n");
		sb.append("import ").append(entityPackage).append(".").append(entityName).append(";\n");
		sb.append("/**\n *\n */\n");
		sb.append("public interface %s {\n");
		sb.append("\n");
		
		sb.append("}");
		return String.format(sb.toString(), serviceName, entityName, entityName);
	}
	
	public String serviceImpl(){
		StringBuilder sb = new StringBuilder();
		sb.append("package ").append(serviceImplPackage).append(";\n");
		sb.append("import org.springframework.stereotype.Service;\n");
		sb.append("import ").append(entityPackage).append(".").append(entityName).append(";\n");
		sb.append("import ").append(servicePackage).append(".").append(serviceName).append(";\n");
		sb.append("/**\n *\n */\n");
		sb.append("@Service(\"/").append(serviceName.toLowerCase()).append("\")\n");
		sb.append("public class ").append(serviceImplName).append(" implements ").append(serviceName).append(" {\n");
		sb.append("\n");
		
		sb.append("}");
		return String.format(sb.toString(), entityName);
	}
	
	public String controller(){
		String serviceNameUncapitalize = StringUtils.uncapitalize(serviceName);
		StringBuilder sb = new StringBuilder();
		sb.append("package ").append(controllerPackage).append(";\n");
		sb.append("import java.util.HashMap;\n");
		sb.append("import java.util.List;\n");
		sb.append("import java.util.ArrayList;\n");
		sb.append("import org.springframework.beans.factory.annotation.Autowired;\n");
		sb.append("import org.springframework.stereotype.Controller;\n");
		sb.append("import org.springframework.ui.ModelMap;\n");
		sb.append("import org.springframework.web.bind.annotation.PathVariable;\n");
		sb.append("import org.springframework.web.bind.annotation.RequestMapping;\n");
		sb.append("import org.springframework.web.bind.annotation.RequestMethod;\n");
		sb.append("import org.springframework.web.bind.annotation.ResponseBody;\n");
		sb.append("import org.springframework.web.servlet.ModelAndView;\n");
		sb.append("import com.cn.core.utils.AjaxResult;\n");
		sb.append("import ").append(entityPackage).append(".").append(entityName).append(";\n");
		sb.append("import ").append(servicePackage).append(".").append(serviceName).append(";\n");
		sb.append("/**\n *\n */\n");
		sb.append("@Controller\n");
		sb.append("@RequestMapping(\"/").append(entityName.toLowerCase()).append("\")\n");
		sb.append("public class ").append(controllerName).append(" {\n");
		sb.append("\n");
		sb.append("\t@Autowired\n");
		sb.append("\t").append(serviceName).append(" ").append(serviceNameUncapitalize).append(";\n\n");
		
		//初始化页面
		sb.append("/**\n *\n */\n");
		sb.append("\t@RequestMapping(method=RequestMethod.GET)\n");
		sb.append("\tpublic ModelAndView index () {\n");
		sb.append("\t\tModelMap model = new ModelMap();\n");
		sb.append("\t\tList list = new ArrayList();\n");
		sb.append("\t\tmodel.addAttribute(\"list\",list);\n");
		sb.append("\t\treturn new ModelAndView(\"user/index\",model);\n");
		sb.append("\t}\n\n");
		
		//跳转保存页面
		sb.append("/**\n *\n */\n");
		sb.append("\t@RequestMapping(method=RequestMethod.GET,value=\"add\")\n");
		sb.append("\tpublic void add() {\n");
		sb.append("\t\tSystem.out.println(\"默认跳转...\")\n");
		sb.append("\t}\n\n");
		
		//保存
		sb.append("/**\n *\n */\n");
		sb.append("\t@RequestMapping(method=RequestMethod.POST,value=\"save\")\n");
		sb.append("\tpublic ModelAndView addEntity(").append(entityName).append(" ").append(entityName.toLowerCase()).append(") {\n");
		sb.append("\t\t").append(serviceNameUncapitalize).append(".").append("").append("\n");
		sb.append("\t\tif(null != ").append(entityName.toLowerCase()).append(") {\n");
		sb.append("\t\t\t").append(serviceNameUncapitalize).append(".").append("").append("\n");
		sb.append("\t\t\t").append(serviceNameUncapitalize).append(".").append("").append("\n");
		sb.append("\t\t}\n");
		sb.append("\t}\n\n");
		
		sb.append("}");
		return sb.toString();
	}
	
	public String dao(){
		StringBuilder sb = new StringBuilder();
		sb.append("package ").append(daoPackage).append(";\n");
		sb.append("/**\n *\n */\n");
		sb.append("public interface %s {\n");
		sb.append("\n");
		sb.append("}");
		return String.format(sb.toString(), daoName);
	}
	
	public String daoImpl(){
		StringBuilder sb = new StringBuilder();
		sb.append("<?xml version=\"1.0\" encoding=\"UTF-8\" ?> \n");
		sb.append("<!DOCTYPE mapper PUBLIC \"-//mybatis.org//DTD Mapper 3.0//EN\" \"http://mybatis.org/dtd/mybatis-3-mapper.dtd\" > \n");
		sb.append("<mapper namespace=\"").append(daoPackage).append(".").append(daoName).append("\"> \n");
		//数据库字段与java entity映射关系
		sb.append("\t<resultMap id=\"BaseResultMap\" type=\"").append(entityPackage).append(".").append(entityName).append("\"> \n");
		
		sb.append("\t</resultMap>\n");
		//sql吐出的字段->
		sb.append("\t<sql id=\"Base_Column_List\" >\n");
		sb.append("\t\t a,b,c \n");
		sb.append("\t</sql>\n");
	  
		sb.append("</mapper>");
		return sb.toString();
	}	
	

	public String getPackageName() {
		return packageName;
	}

	public void setPackageName(String packageName) {
		this.packageName = packageName;
	}

	public String getEntityName() {
		return entityName;
	}

	public void setEntityName(String entityName) {
		this.entityName = entityName;
	}

	public String getTableName() {
		return tableName;
	}

	public void setTableName(String tableName) {
		this.tableName = tableName;
	}	

	public String getServiceName() {
		return serviceName;
	}

	public void setServiceName(String serviceName) {
		this.serviceName = serviceName;
	}

	public String getServiceImplName() {
		return serviceImplName;
	}

	public void setServiceImplName(String serviceImplName) {
		this.serviceImplName = serviceImplName;
	}

	public String getControllerName() {
		return controllerName;
	}

	public void setControllerName(String controllerName) {
		this.controllerName = controllerName;
	}

	public String getEntityPackage() {
		return entityPackage;
	}

	public void setEntityPackage(String entityPackage) {
		this.entityPackage = entityPackage;
	}
	

	public String getServicePackage() {
		return servicePackage;
	}

	public void setServicePackage(String servicePackage) {
		this.servicePackage = servicePackage;
	}

	public String getServiceImplPackage() {
		return serviceImplPackage;
	}

	public void setServiceImplPackage(String serviceImplPackage) {
		this.serviceImplPackage = serviceImplPackage;
	}

	public String getControllerPackage() {
		return controllerPackage;
	}

	public void setControllerPackage(String controllerPackage) {
		this.controllerPackage = controllerPackage;
	}

	public String getDaoPackage() {
		return daoPackage;
	}

	public void setDaoPackage(String daoPackage) {
		this.daoPackage = daoPackage;
	}

	public String getDaoImplPackage() {
		return daoImplPackage;
	}

	public void setDaoImplPackage(String daoImplPackage) {
		this.daoImplPackage = daoImplPackage;
	}

	public String getDaoName() {
		return daoName;
	}

	public void setDaoName(String daoName) {
		this.daoName = daoName;
	}

	public String getDaoImplName() {
		return daoImplName;
	}

	public void setDaoImplName(String daoImplName) {
		this.daoImplName = daoImplName;
	}
	
	
	public static void main(String[] args) {
		String packageName = "pc.Member";
		String entityName = "Tests";
		String tableName = "tbl_tests";
		CodeTemplate ct = new CodeTemplate(packageName, entityName, tableName);
		String s1 = ct.entity();
		System.out.println(s1);
		System.out.println();
		String s2 = ct.dao();
		System.out.println(s2);
		System.out.println();
		String s3 = ct.daoImpl();
		System.out.println(s3);
		System.out.println();
		String s4 = ct.service();
		System.out.println(s4);
		System.out.println();
		String s5 = ct.serviceImpl();
		System.out.println(s5);
		System.out.println();
		String s6 = ct.controller();
		System.out.println(s6);
	}

}
