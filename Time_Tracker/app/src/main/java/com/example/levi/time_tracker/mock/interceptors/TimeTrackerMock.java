package com.example.levi.time_tracker.mock.interceptors;

import android.net.Uri;

import com.example.levi.time_tracker.network.NetworkConfig;
import com.example.levi.time_tracker.repository.MemoryRepository;
import com.example.levi.time_tracker.utils.GsonHelper;
import okhttp3.Headers;
import okhttp3.Request;
import okhttp3.Response;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.sql.Date;

import static com.example.levi.time_tracker.mock.interceptors.MockHelper.makeResponse;

public class TimeTrackerMock {
	public static Response process(Request request) {
		Uri uri = Uri.parse(request.url().toString());

		String responseString;
		int responseCode = 200;
		Headers headers = request.headers();

		String path = uri.getPath();

		if( request.method().equals("POST") && (path.equals(NetworkConfig.ENDPOINT_PREFIX + "TimeInterval") || path.equals(NetworkConfig.ENDPOINT_PREFIX + "Process")))
		{
			responseString = "";
		} else if(request.method().equals("DELETE") && path.startsWith(NetworkConfig.ENDPOINT_PREFIX + "Process/"))
		{
			responseString = "";
		} else if(request.method().equals("GET") && path.startsWith(NetworkConfig.ENDPOINT_PREFIX + "Processes" ))
		{
			MemoryRepository memoryRepository = new MemoryRepository();
			memoryRepository.open(null);
			responseString = GsonHelper.getGson().toJson(memoryRepository.getProcesses());

		} else if(request.method().equals("GET") &&  path.startsWith(NetworkConfig.ENDPOINT_PREFIX + "TimeIntervals" ))
		{
			Gson gson=  new GsonBuilder().setDateFormat(GsonHelper.DATE_FORMAT).create();
			String[] split = path.split("/");
			Date parsedDate = gson.fromJson(split[split.length-1], Date.class);
			MemoryRepository memoryRepository = new MemoryRepository();
			memoryRepository.open(null);
			responseString = GsonHelper.getGson().toJson(memoryRepository.GetTimeIntervals(parsedDate));
		}else {
			responseString = "ERROR";
			responseCode = 503;
		}

		return makeResponse(request, headers, responseCode, responseString);
	}
}
