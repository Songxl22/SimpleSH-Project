package com.codingyun.core.util;

public class StringUtil {

    /**
     * 检查字符串是否为空
     * <p>Checks if a String is not empty (""), not null and not whitespace only.</p>
     *
     * <pre>
     * StringUtils.isNotBlank(null)      = false
     * StringUtils.isNotBlank("")        = false
     * StringUtils.isNotBlank("bob")     = true
     * </pre>
     *
     * @param str  the String to check, may be null
     * @return <code>true</code> if the String is
     *  not empty and not null and not whitespace
     * @since 2.0
     */
    public static boolean isNotBlank(String str) {
    	boolean isBlank = true;
    	if (str == null || "".equals(str.trim())) {
    		isBlank = false;
		}
        return isBlank;
    }
    
    

	public static boolean isEmpty(String str) { 
		boolean empty = false;
		if(str == null || str.trim().length() <=0){
			empty = true;
		}
		return empty;
	}
}
