/**
 * Created by manoj.behera on 22-Nov-2016.
 */
package com.thed.zephyr.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

import org.json.JSONArray;
import org.json.JSONObject;

/**
 * @author manoj.behera 22-Nov-2016
 *
 */
public class CommonUtils {

	public static String convertListToCSVString(List<Long> list) {
		// The string builder used to construct the string
		StringBuilder commaSepValueBuilder = new StringBuilder();

		// Looping through the list
		for (int i = 0; i < list.size(); i++) {
			// append the value into the builder
			commaSepValueBuilder.append(list.get(i));

			// if the value is not the last element of the list
			// then append the comma(,) as well
			if (i != list.size() - 1) {
				commaSepValueBuilder.append(",");
			}
		}
		return commaSepValueBuilder.toString();
	}

	public static List<String> getDataListFromJsonArray(JSONArray array, String key) {
		List<String> list = new ArrayList<>();
		for (int i = 0; i < array.length(); i++) {
			JSONObject json = array.getJSONObject(i);
			list.add(json.get(key).toString());
		}
		return list;
	}
	public static List<Long> getDataListOfLongFromJsonArray(JSONArray array, String key) {
		List<Long> list = new ArrayList<>();
		for (int i = 0; i < array.length(); i++) {
			JSONObject json = array.getJSONObject(i);
			list.add(json.getLong(key));
		}
		return list;
	}

	public static List<String> getDataListFromJsonArray(List<String> list, String key) {
		List<String> list1 = new ArrayList<>();
		for (int i = 0; i < list.size(); i++) {
			JSONObject json = new JSONObject(list.get(i));
			list1.add(json.get(key).toString());
		}
		return list1;
	}

	public static List<Long> getListAsLong(List<String> list, String key) {
		List<Long> list1 = new ArrayList<>();
		for (int i = 0; i < list.size(); i++) {
			JSONObject json = new JSONObject(list.get(i));
			list1.add(json.getLong(key));
		}
		return list1;
	}

	public static List<Long> convertToList(JSONArray jArray){
		List<Long> listdata = new ArrayList<Long>(); 
		if (jArray != null) { 
			   for (int i=0;i<jArray.length();i++){ 
			    listdata.add(jArray.getLong(i));
			   } 
		} 
		return listdata;
	}

	// public static void compareArrayList(JSONArray array1, JSONArray array2){
	// for (int i = 0; i < array1.length(); i++) {
	// if(array1.has){
	//
	// }
	// }
	// }
	public static String dateConversion(String date, String dateFormat) throws ParseException {
		SimpleDateFormat formatter = new SimpleDateFormat(dateFormat);
		Date returnDate = formatter.parse(date);
		return formatter.format(returnDate);
	}
	public static Long getStatusId(){
		 Random random = new Random();
		 List<Long> status = new ArrayList();
		 status.add(1l);
		 status.add(2l);
		 status.add(3l);
		 status.add(4l);
		 return status.get(random.nextInt(status.size()));
	 }
	public static Integer getStatusId(String status1, String status2){
		 Random random = new Random();
		 List<Integer> status = new ArrayList();
		 if(status1.equals("unexecuted")){
			 status.add(-1);
		 }
		 if(status2.equals("default")){
			 status.add(1);
			 status.add(2);
			 status.add(3);
			 status.add(4);
		 }
		 return status.get(random.nextInt(status.size()));
	 }
	 public static Long getStatusId(String status1, String status2, String status3){
		 Random random = new Random();
		 List<Long> status = new ArrayList();
		 if(status1.equals("unexecuted")){
			 status.add(-1l);
		 }
		 if(status2.equals("default")){
			 status.add(1l);
			 status.add(2l);
			 status.add(3l);
			 status.add(4l);
		 }
		 if(status3.equals("custom")){
			 status.add(5l);
		 }
		 return status.get(random.nextInt(status.size()));
	 }
}
