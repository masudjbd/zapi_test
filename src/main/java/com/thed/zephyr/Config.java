package com.thed.zephyr;

import java.io.File;
import java.util.Properties;

import com.thed.zephyr.util.RestUtils;

/**
 * @author manoj.behera
 *
 */
public class Config {
	private static boolean isInit = false ;
	private static String path = null ;
	private static Properties prop = null ;
	private static String logPath = null ;
	
	public Config() {
		if (isInit) {
			return ;
		}
		init();
		
	}
	
	private void init() {
		Config.path = "/config.properties" ;
		prop = RestUtils.loadProperties(Config.path);
		if (prop == null) {
			throw new RuntimeException("Unable to load properties file: " + Config.path);
		}
		//initLog4j();
		logPath = "logs" + File.separator;
		
		isInit = true ;
	}
	
	/* Log4j appender is located at a different dir, so using programmatically initialization */
	/*private static void initLog4j() {
		try {
			Properties properties = new Properties();
			File file = CommonUtil.getPropertyFilePath("/log4j.xml");
			DOMConfigurator.configure(file.getAbsolutePath());
		} catch (Exception e) {
			RuntimeException fe = new RuntimeException("Couldn't initialize log4j.", e);
			throw fe ;
		}		
	}*/
	
	/**
	 * @param key
	 * @return the value
	 * Created by manoj.behera on 14-Nov-2016.
	 */
	public static String getValue(String key) {
		return prop.getProperty(key);
	}
	
}
