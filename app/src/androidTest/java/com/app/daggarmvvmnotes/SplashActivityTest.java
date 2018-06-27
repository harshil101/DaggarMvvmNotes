package com.app.daggarmvvmnotes;

import android.support.test.filters.LargeTest;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.test.suitebuilder.annotation.SmallTest;
import android.util.Log;
import android.view.View;

import com.app.daggarmvvmnotes.activities.SplashActivity;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.*;
@RunWith(AndroidJUnit4.class)
@LargeTest
public class SplashActivityTest {
    @Rule
    public ActivityTestRule<SplashActivity> mActivityRule = new ActivityTestRule<>(SplashActivity.class);
    private SplashActivity mActivity;
    @Before
    public void setUp() throws Exception {
        mActivity = mActivityRule.getActivity();
    }
    @Test
    public void testLaunch(){
        View view = mActivity.findViewById(R.id.logoText);
        assertNotNull(view);
        Log.d("TAG", "testLaunch: ");
    }
    @After
    public void tearDown() throws Exception {
        mActivity = null;
    }
}