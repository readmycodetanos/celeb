package com.readmycodetanos.project_temp_2019;

import android.content.Context;
import android.support.test.InstrumentationRegistry;
import android.support.test.runner.AndroidJUnit4;

import com.readmycodetanos.project_temp_2019.api.HttpApp;
import com.readmycodetanos.project_temp_2019.api.result.ContentBean;

import org.junit.Test;
import org.junit.runner.RunWith;

import retrofit2.Call;
import retrofit2.Response;

import static org.junit.Assert.assertEquals;

/**
 * Instrumented test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)
public class ExampleInstrumentedTest {
    @Test
    public void useAppContext() {
        // Context of the app under test.
        Context appContext = InstrumentationRegistry.getTargetContext();

        assertEquals("com.readmycodetanos.project_temp_2019", appContext.getPackageName());
    }


    @Test
    public void callApiTest()  {

        Call<ContentBean> contents = HttpApp.getAppService().getContents();
        Response<ContentBean> execute = null;
        try {
            execute = contents.execute();
        } catch (Exception e) {
            e.printStackTrace();
//           Log.v("TNet", execute.body());
        }
        assertEquals(true, execute.isSuccessful());
    }

}
