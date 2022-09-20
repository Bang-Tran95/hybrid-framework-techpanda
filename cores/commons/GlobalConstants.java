package commons;

public class GlobalConstants {

	// System infor
	public static final String PROJECT_PATH = System.getProperty("user.dir");
	public static final String OS_NAME = System.getProperty("os.name");
	public static final String JAVA_VERSION = System.getProperty("java.version") ;


	// App Infor User
	public static final String DEV_USER_URL = "";
	public static final String STAGING_USER_URL = "";
	public static final String LIVE_USER_URL = "";

	// App Infor Admin
	public static final String DEV_ADMIN_URL = "";
	public static final String STAGING_ADMIN_URL = "";
	public static final String LIVE_ADMIN_URL = "";

	public static final String ADMIN_USERNAME = "user01";
	public static final String ADMIN_PASSWORD = "guru99com";
	
	//Wait Infor
	public static final long SHORT_TIME = 10;
	public static final long LONG_TIME = 30;
	
	//Dowload/ Upload File
	public static final String UPLOAD_PATH = PROJECT_PATH + "/uploadFiles/";
	public static final String DOWLOAD_PATH = PROJECT_PATH + "/dowloadFiles/";
	
	// Browser Logs/ Extension
	public static final String BROWSER_LOG_PATH = PROJECT_PATH + "/browserLogs/";
	public static final String BROWSER_EXTENSION_PATH = PROJECT_PATH + "/browserExtensions/";
	
	//HTML Report Folder
	public static final String REPORTNG_SCREENSHOT_PATH = PROJECT_PATH + "/ReportNGScreenShots/";
	public static final String EXTENT_PATH = PROJECT_PATH + "/htmlExtent/";
	public static final String ALLURE_PATH = PROJECT_PATH + "/htmlAllure/";

	
	//Retry Case
	public static final int RETRY_NUMBER = 3;
	

	

}
