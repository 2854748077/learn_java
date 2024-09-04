package com.itranswarp.learnjava;

/**
 * Learn Java from https://www.liaoxuefeng.com/
 * 
 * @author liaoxuefeng
 */
public class Tel {

	/**
	 * 测试字符串是否是一个有效的"3~4位区号-7~8位电话"
	 */
	public static boolean isValidTel(String s) {
		// FIXME:
		return s.matches("\\d+\\-\\d+");
	}

}
