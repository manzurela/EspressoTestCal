package com.example.nikonorov.gleb.simplecalculator.tests;




import android.content.Context;
import android.content.Intent;
import android.support.test.InstrumentationRegistry;
import android.support.test.runner.AndroidJUnit4;
import android.support.test.uiautomator.By;
import android.support.test.uiautomator.UiDevice;
import android.support.test.uiautomator.Until;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertThat;

@RunWith(AndroidJUnit4.class)
public class uiAutomatorTest {



        private static final String BASIC_SAMPLE_PACKAGE
                = "com.example.nikonorov.gleb.simplecalculator";
        private static final int LAUNCH_TIMEOUT = 10000;
        private static final String STRING_TO_BE_TYPED = "UiAutomator";
        private UiDevice mDevice;


    @Before
    public void startMainActivityFromHomeScreen() {
        // Initialize UiDevice instance
        mDevice = UiDevice.getInstance(InstrumentationRegistry.getInstrumentation());

        // Start from the home screen
        mDevice.pressHome();

        // Wait for launcher
        final String launcherPackage = mDevice.getLauncherPackageName();
        assertThat(launcherPackage, notNullValue());
        mDevice.wait(Until.hasObject(By.pkg(launcherPackage).depth(0)),
                LAUNCH_TIMEOUT);
        // Launch the app
        Context context = InstrumentationRegistry.getContext();
        final Intent intent = context.getPackageManager()
                .getLaunchIntentForPackage(BASIC_SAMPLE_PACKAGE);
        // Clear out any previous instances
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
        context.startActivity(intent);

        // Wait for the app to appear
        mDevice.wait(Until.hasObject(By.pkg(BASIC_SAMPLE_PACKAGE).depth(0)),
                LAUNCH_TIMEOUT);
    }




    @Test
    public void addingNubmers() throws InterruptedException {

        mDevice.findObject(By.res("com.example.nikonorov.gleb.simplecalculator:id/nineButton")).click();
        Thread.sleep(2000);
        mDevice.findObject(By.res("com.example.nikonorov.gleb.simplecalculator:id/adButton")).click();
        mDevice.findObject((By.res("com.example.nikonorov.gleb.simplecalculator:id/sixButton"))).click();
        Thread.sleep(2000);
        mDevice.findObject(By.res("com.example.nikonorov.gleb.simplecalculator:id/equalsButton")).click();
        Thread.sleep(5000);

        mDevice.findObject(By.res("com.example.nikonorov.gleb.simplecalculator:id/outputLabel")).equals("15");


    }




    @After
    public void tearDown() throws InterruptedException {
        Thread.sleep(5000);

    }

}
