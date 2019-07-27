package com.study.config;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ConfigLoadListener implements ServletContextListener {
	private final static Logger logger = LogManager.getLogger(ServletContextListener.class);

	private final static String CONFIG_FILE = "properties/config.properties";
	private static Properties config;

	@Override
	public void contextInitialized(ServletContextEvent paramServletContextEvent) {
		// properties 파일 로드
		InputStream in = null;
		try {
			ClassLoader loader = Thread.currentThread().getContextClassLoader();
    	    if (loader != null) in = loader.getResourceAsStream(CONFIG_FILE);
    	    if (in == null) in = ClassLoader.getSystemResourceAsStream(CONFIG_FILE);

    	    Properties props = new Properties();
			props.load(in);

            config = props;

            System.out.println("config definition load.. success!!!");

		} catch (Exception exception) {
			throw new RuntimeException("config.properties loading failure!", exception);
		} finally {
			if (in != null) {
				try {
					in.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}

	@Override
	public void contextDestroyed(ServletContextEvent paramServletContextEvent) {
		if (config != null) config.clear();
		config = null;
	}

	public static String getProperty(String key) {
		return config.getProperty(key);
	}

}
