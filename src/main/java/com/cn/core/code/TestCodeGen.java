package com.cn.core.code;

import com.cn.core.code.MybatisCodeGenerate;

/**
 * 自动生成代码
 * 包含Entiy、Service、Controller、Dao（可选）
 */
public class TestCodeGen {
	/**
	 * 自动生成代码
	 * 生成之前需要修改实体名称、数据库表名称
	 */
	public static void main(String[] args) {
		//实体名称(生成之前需要修改)
		String entityName = "DemoBlob";
		
		//实体对应的数据库表名称(生成之前需要修改)
		String tableName = "tbl_blob";
		
		//包名称(为空时自动取实体名称的小写)
		String packageName = "blobs";
		//是否生成Dao(无需Dao则false)
		boolean generateDao = false;
		
		MybatisCodeGenerate gen = new MybatisCodeGenerate();
		gen.setPackageName(packageName);
		gen.setEntityName(entityName);
		gen.setTableName(tableName);
		gen.setGenerateDao(generateDao);
        gen.generate();
	}
}
