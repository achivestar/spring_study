package study.config;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class ConfigLoadListener implements ServletContextListener {
	private final static String CONFIG_FILE = "properties/config.properties";

	private static Properties config;

	public void contextDestroyed(ServletContextEvent arg0) {
		if (config != null) config.clear();
		config = null;
	}

	public void contextInitialized(ServletContextEvent arg0) {
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

	public static String getProperty(String key) {
		return config.getProperty(key);
	}

}
