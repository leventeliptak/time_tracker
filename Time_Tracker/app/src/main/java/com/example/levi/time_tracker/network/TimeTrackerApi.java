package com.example.levi.time_tracker.network;

import com.example.levi.time_tracker.network.CollectionFormats.*;

import retrofit2.Call;
import retrofit2.http.*;

import okhttp3.RequestBody;

import com.example.levi.time_tracker.model.Process;
import com.example.levi.time_tracker.model.TimeInterval;
import java.util.Date;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public interface TimeTrackerApi {

    /**
     * Create a new instance of the TimeInterval and persist it into the data source.
     *
     * @param data Model instance data
     * @return Call<Void>
     */

    @PUT("Process")
    Call<Void> timeIntervalUpdate(
            @Body Process data
    );


    /**
     * Remove a concrete Process from data source.
     *
     * @param name
     * @return Call<Void>
     */

    @DELETE("Process/{name}")
    Call<Void> processRemove(
            @Path("name") String name
    );


    /**
     * Get all processes
     *
     * @return Call<List<Process>>
     */

    @GET("Processes")
    Call<List<Process>> processGetAll();



    /**
     * Create a new instance of the TimeInterval and persist it into the data source.
     *
     * @param data Model instance data
     * @return Call<Void>
     */

    @PUT("TimeInterval")
    Call<Void> timeIntervalCreate(
            @Body TimeInterval data
    );


    /**
     * Get all TimeIntervals for a date.
     *
     * @param date Model instance data
     * @return Call<List<TimeInterval>>
     */

    @GET("TimeIntervals/{date}")
    Call<List<TimeInterval>> getStatictics(
            @Path("date") Date date
    );


}
