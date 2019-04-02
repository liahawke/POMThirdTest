package com.testswithpom.projectpom.base;

import java.io.File;
import java.io.IOException;
import org.apache.commons.io.FileUtils;
import org.junit.rules.TestWatcher;
import org.junit.runner.Description;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class RunTestRule extends TestWatcher {

    // Instance of BaseClass
    private BaseClass testClass;

    /**
     * Constructor
     *
     * @param testClass
     */
    public RunTestRule(BaseClass testClass) {
        this.testClass = testClass;
    }

    @Override
    protected void finished(Description description) {
        testClass.getDriver().quit();
    }

    /**
     * Make screenshot and make driver.quit()
     *
     * @param e
     * @param description
     */
    @Override
    protected void failed(Throwable e, Description description) {
        String baseDir = "src/main/resources/screenshots";
        File directory = new File(baseDir);
        if (!directory.exists()) {
            directory.mkdir();
        }
        String className = description.getTestClass().getSimpleName();
        String methodName = description.getMethodName();
        String screenshotName =
                baseDir
                        + "/"
                        + className
                        + "-"
                        + methodName
                        + "-"
                        + testClass.getDateTime()
                        + ".png";
        File targetFile = new File(screenshotName);
        try {
            FileUtils.copyFile(
                    ((TakesScreenshot) testClass.getDriver()).getScreenshotAs(OutputType.FILE),
                    targetFile);
        } catch (IOException e1) {
            e1.printStackTrace();
            testClass.error(e1.getMessage());
        }
        testClass.error(e.getMessage());
        testClass.getDriver().quit();
    }
}
