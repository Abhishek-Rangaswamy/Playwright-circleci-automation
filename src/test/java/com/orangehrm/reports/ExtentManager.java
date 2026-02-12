package com.orangehrm.reports;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.orangehrm.hooks.Hooks;

public class ExtentManager {

	private static ExtentReports extent;

	public static void initReport(String suiteName) {

		if (extent == null) {

			LocalDateTime now = LocalDateTime.now();
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd_MM_yyyy_HH_mm_ss");
			String timestamp = now.format(formatter);

			ExtentSparkReporter spark = new ExtentSparkReporter(
					"target/extent-reports/" + suiteName + "_" + timestamp + ".html");

			extent = new ExtentReports();
			extent.attachReporter(spark);
		}
	}

	public static ExtentReports getExtentReport() {
		return extent;
	}

	public static void flushReport() {
		if (extent != null) {
			extent.flush();
		}

	}
}
