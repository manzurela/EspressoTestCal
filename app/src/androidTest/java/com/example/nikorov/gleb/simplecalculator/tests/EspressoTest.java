package com.example.nikonorov.gleb.simplecalculator.tests;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.action.ViewActions.click;

import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.withText;

import android.support.test.espresso.matcher.ViewMatchers;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
//import android.support.test.rule.ActivityTestRule;


import com.example.nikonorov.gleb.simplecalculator.MainActivity;
import com.example.nikonorov.gleb.simplecalculator.R;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import org.junit.runner.RunWith;

@RunWith(AndroidJUnit4.class)
public class EspressoTest {

    //Launch App
    @Rule
    public ActivityTestRule<MainActivity> mainActivityRule = new ActivityTestRule<>(MainActivity.class);

    @Test
    public void addNumbers(){
        onView(withId(R.id.sixButton)).perform(click());
        onView(withId(R.id.adButton)).perform(click());
        onView(withId(R.id.nineButton)).perform(click());
        onView(withId(R.id.equalsButton)).perform(click());

        //Result is 15
        onView(withId(R.id.outputLabel)).check(matches(withText("15")));



    }

}


