package Core.Report;


import Core.Helpers.DateHelper;
import com.relevantcodes.extentreports.ExtentReports;

public class ExtentManager {

    static DateHelper date = new DateHelper();
    static private ExtentReports extent;
    public static String reportFileName = date.getTodayDate("dd-MM-yyyy") + " Test Report " + System.currentTimeMillis() + ".html";
    public static String path = "src/main/resources/Reports/" + date.getTodayDate("dd-MM-yyyy") + "\\";

    public static ExtentReports getInstance() {
        if (extent == null)
            createInstance();
        return extent;
    }

    public static String getReportPath() {
        return path + reportFileName;
    }

    public static ExtentReports createInstance() {

        extent = new ExtentReports(getReportPath());
        extent.addSystemInfo("AUTHOR", "Mohammed Mohaidat");
        extent.addSystemInfo("ENVIRONMENT", "Automation Test Result");
        extent.addSystemInfo("TEST", "AUTO TEST");
        extent.addSystemInfo("POWERED BY:", "Mohammed Mohaidat");

        return extent;
    }
}
