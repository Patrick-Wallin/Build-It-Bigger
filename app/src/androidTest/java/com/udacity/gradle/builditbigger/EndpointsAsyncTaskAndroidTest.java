package com.udacity.gradle.builditbigger;

import android.content.Context;
import android.support.test.InstrumentationRegistry;
import android.support.test.internal.util.AndroidRunnerParams;
import android.support.test.runner.AndroidJUnit4;
import android.util.Pair;

import junit.framework.Assert;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.model.InitializationError;

import java.util.concurrent.ExecutionException;

import static org.junit.Assert.assertEquals;

/**
 * Created by piwal on 3/14/2017.
 */


public class EndpointsAsyncTaskAndroidTest  {
    @Test
    public void testNonEmptyString() {
        EndpointsAsyncTask endpointsAsyncTask = (EndpointsAsyncTask) new EndpointsAsyncTask(null).execute(new Pair<Context,String>(InstrumentationRegistry.getTargetContext(),"test"));
        String result = "";
        try {
            result = endpointsAsyncTask.get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

        Assert.assertTrue("Result is null", result != null);
        Assert.assertTrue("Result is empty", !result.isEmpty());
        //Assert.assertTrue(result != null && && result.trim().length() > 0 && !result.isEmpty());
    }
}
