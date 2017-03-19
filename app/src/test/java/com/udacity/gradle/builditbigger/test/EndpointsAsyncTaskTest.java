package com.udacity.gradle.builditbigger.test;

import android.content.Context;
import android.support.test.InstrumentationRegistry;
import android.util.Pair;

import com.udacity.gradle.builditbigger.EndpointsAsyncTask;

import junit.framework.Assert;

import org.junit.Test;

import java.util.concurrent.ExecutionException;

/**
 * Created by piwal on 3/16/2017.
 */

public class EndpointsAsyncTaskTest {
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


    }
}
