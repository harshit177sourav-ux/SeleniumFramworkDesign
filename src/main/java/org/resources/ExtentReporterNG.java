package org.resources;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import java.io.File;

public class ExtentReporterNG {
    public static ExtentReports getReportObject(){
        //Step 1: Store the path in variable where we need to store the Reports
        String path = System.getProperty("user.dir") + File.separator + "reports" + File.separator + "index.html";
        //Step 2: Create object of ExtentSparkReporter passing the path in the constructor
        ExtentSparkReporter extentSparkReporter = new ExtentSparkReporter(path);
        //Info: We can use methods of the objects to config various parameters
        extentSparkReporter.config().setReportName("Test Results");
        extentSparkReporter.config().setDocumentTitle("DocumentTitle Test");

        //Step 3: Now we need create the ExtentReporter and attach the extentSparkReporter object;
        ExtentReports extentReports = new ExtentReports();
        extentReports.attachReporter(extentSparkReporter);

        return extentReports;

    }
}
