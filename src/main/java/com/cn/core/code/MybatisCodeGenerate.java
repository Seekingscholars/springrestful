package com.cn.core.code;

import java.io.File;

import org.apache.commons.lang.StringUtils;

public class MybatisCodeGenerate {
	private static String basePath = null;
	private String fileCharset = "utf-8";
	private String sourcePath = "src/main/java/";
	
	String packageName = "";
	String entityName = "";
	String tableName = "";
	boolean generateDao = false;
	
	public void generate(){
		if(StringUtils.isBlank(packageName)){
			packageName = entityName.toLowerCase();
		}
		CodeTemplate ct = new CodeTemplate(packageName, entityName, tableName);
		
		if (basePath == null || basePath.trim().length() == 0) {
            basePath = System.getProperty("user.dir");
        }
        if (basePath == null || basePath.trim().length() == 0) {
            System.err.println("[ERROR] 请配置basePath。");
            return;
        }
        if (!basePath.endsWith(File.separator)) {
            basePath = basePath + File.separator;
        }
        
        System.out.println(basePath);
        sourcePath = basePath + sourcePath;
        System.out.println(sourcePath);
        
        //生成实体
        String entityPath = sourcePath + ct.getEntityPackage().replace(".", File.separator) + File.separator
        	+ ct.getEntityName() + ".java";
        GenerateUtil.writeText(new File(entityPath), ct.entity(), fileCharset);
        
       
        if(generateDao){
        	//生成Dao
	        String daoPath = sourcePath + ct.getDaoPackage().replace(".", File.separator) + File.separator
	        	+ ct.getDaoName() + ".java";
	        GenerateUtil.writeText(new File(daoPath), ct.dao(), fileCharset);
	        
	        //生成DaoImpl
	        String daoImplPath = sourcePath + ct.getDaoImplPackage().replace(".", File.separator) + File.separator
	        	+ ct.getDaoImplName() + ".xml";
	        GenerateUtil.writeText(new File(daoImplPath), ct.daoImpl(), fileCharset);
	        
	        //生成Service
        	String servicePath = sourcePath + ct.getServicePackage().replace(".", File.separator) + File.separator
        	+ ct.getServiceName() + ".java";
        	GenerateUtil.writeText(new File(servicePath), ct.service(), fileCharset);
        	
        	//生成ServiceImpl
        	String serviceImplPath = sourcePath + ct.getServiceImplPackage().replace(".", File.separator) + File.separator
        	+ ct.getServiceImplName() + ".java";
        	GenerateUtil.writeText(new File(serviceImplPath), ct.serviceImpl(), fileCharset);
        }else{
        	//生成Service
        	String servicePath = sourcePath + ct.getServicePackage().replace(".", File.separator) + File.separator
        	+ ct.getServiceName() + ".java";
        	GenerateUtil.writeText(new File(servicePath), ct.service(), fileCharset);
        	
        	//生成ServiceImpl
        	String serviceImplPath = sourcePath + ct.getServiceImplPackage().replace(".", File.separator) + File.separator
        	+ ct.getServiceImplName() + ".java";
        	GenerateUtil.writeText(new File(serviceImplPath), ct.serviceImpl(), fileCharset);
        }
        
        //生成Controller
        String controllerPath = sourcePath + ct.getControllerPackage().replace(".", File.separator) + File.separator
        	+ ct.getControllerName() + ".java";
        GenerateUtil.writeText(new File(controllerPath), ct.controller(), fileCharset);
        
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

	public boolean isGenerateDao() {
		return generateDao;
	}

	public void setGenerateDao(boolean generateDao) {
		this.generateDao = generateDao;
	}
}
