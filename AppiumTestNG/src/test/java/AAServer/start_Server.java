package AAServer;

import java.io.IOException;

import org.testng.annotations.BeforeSuite;

import Resources.base;

public class start_Server extends base{

	@BeforeSuite
	public static void startServer() throws IOException, InterruptedException {
		Runtime.getRuntime().exec("cmd /c start cmd.exe /K "+startServerBatFilePath+"");
		Thread.sleep(8000);
		    }
	}

