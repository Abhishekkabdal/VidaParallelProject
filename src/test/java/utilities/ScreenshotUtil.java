package utilities;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class ScreenshotUtil {

	public static String captureScreenshot(WebDriver driver, String testName) {
	    if (driver == null) {
	        System.out.println("❌ Driver is NULL - Screenshot not captured");
	        return null;
	    }

	    File screenshotDir = new File(System.getProperty("user.dir") + "/reports/screenshots");
	    if (!screenshotDir.exists()) {
	        screenshotDir.mkdirs();
	    }

	    String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
	    String fileName = testName + "_" + timeStamp + ".png";
	    String absolutePath = System.getProperty("user.dir") + "/reports/screenshots/" + fileName;
	    // ✅ Relative path for ExtentReport HTML rendering
	    String relativePath = "screenshots/" + fileName;

	    try {
	        File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
	        FileUtils.copyFile(src, new File(absolutePath));
	    } catch (IOException e) {
	        e.printStackTrace();
	        return null;
	    }

	    return relativePath; // ✅ Return relative, not absolute
	}
}
