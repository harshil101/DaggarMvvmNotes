package com.app.daggarmvvmnotes.activities;

import android.support.test.filters.LargeTest;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.view.View;
import android.widget.EditText;

import com.app.daggarmvvmnotes.R;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.closeSoftKeyboard;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.hasErrorText;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.junit.Assert.*;
@RunWith(AndroidJUnit4.class)
@LargeTest
public class CreateNoteActivityTest {
    @Rule
    public ActivityTestRule<CreateNoteActivity> mActivityRule = new ActivityTestRule<>(CreateNoteActivity.class);
    private CreateNoteActivity mActivity;
    @Before
    public void setUp() throws Exception {
        mActivity = mActivityRule.getActivity();
    }

    @After
    public void tearDown() throws Exception {
        mActivity = null;
    }

    @Test
    public void ensureTextChangesWork() {
        // Type text and then press the button.
        onView(withId(R.id.noteHeading))
                .perform(typeText("HELLO"), closeSoftKeyboard());
        onView(withId(R.id.noteHeading)).perform(click());

        // Check that the text was changed.
        onView(withId(R.id.noteHeading)).check(matches(withText("Lalala")));
    }

    @Test
    public void changeText_newActivity() {
        // Type text and then press the button.
        onView(withId(R.id.noteHeading)).perform(typeText("NewText"),
                closeSoftKeyboard());
        onView(withId(R.id.save)).perform(click());

        // This view is in a different Activity, no need to tell Espresso.
        onView(withId(R.id.noteHeading)).check(matches(withText("NewText")));
    }

    @Test
    public void onClick() {
        EditText view = mActivity.findViewById(R.id.noteHeading);
        assertNotNull(view);
        // Check that the text was changed.
        onView(withId(R.id.noteHeading)).check(matches(withText("NewText")));
    }
}