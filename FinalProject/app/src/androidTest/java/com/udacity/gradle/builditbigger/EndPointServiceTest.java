package com.udacity.gradle.builditbigger;


import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.rule.ActivityTestRule;

import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(AndroidJUnit4.class)
public class EndPointServiceTest implements Displayable {
    private ActivityTestRule<MainActivity> mActivityTestRule = new ActivityTestRule<>(MainActivity.class);

    @Test
    public void verifyAsyncTask() {
        EndpointService endpointService = new EndpointService(mActivityTestRule.getActivity(), this);
        endpointService.execute();
    }

    public void display(String msg) {
        assert msg != null && msg.trim().length() > 0;
    }
}
