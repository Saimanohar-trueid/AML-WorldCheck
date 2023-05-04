package com.aml.worldCheck.service;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.json.JSONException;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.aml.worldCheck.entity.AmlDataCheck;
import com.aml.worldCheck.entity.WorldCheckCallAPIEntity;
import com.aml.worldCheck.model.AmlDataCheckModel;
import com.aml.worldCheck.model.WorldCheckCallAPI;
import com.aml.worldCheck.repository.AmlDataCheckRepository;

@Service
public class AmlDataCheckService {

	private static final Logger logger = LoggerFactory.getLogger(AmlDataCheckService.class);

	@Autowired
	private AmlDataCheckRepository repository;

	@Value("${aml.spring.url}")
	private String URL;

	public AmlDataCheckModel checkData(WorldCheckCallAPI callServcie) {

		logger.info("inside checkData method");

		// String callResponse = callApi(callServcie);
		AmlDataCheck data = new AmlDataCheck();
		AmlDataCheckModel model = new AmlDataCheckModel();
		/*
		 * if(callResponse != null) data = repository.save(checkData);
		 */

		String callResponse = addRequestDatainDB(callServcie);

		model.setReturnValue(callResponse);

		return model;
	}

	public String callApi(WorldCheckCallAPI callData) {

		logger.info("inside callApi method");

		String inputLine;
		StringBuffer response = new StringBuffer();

		URL obj;
		try {
			obj = new URL(URL);

			HttpURLConnection con = (HttpURLConnection) obj.openConnection();

			con.setRequestMethod("POST");
			con.setRequestProperty("Content-Type", "application/json");
			/*
			 * con.addRequestProperty("client_id", "springboot-keycloak");
			 * con.addRequestProperty("username", "trueid");
			 * con.addRequestProperty("password", "trueid123");
			 * con.addRequestProperty("grant_type", "password");
			 * con.addRequestProperty("client_secret",
			 * "6082fa34-e1ba-457c-8052-7ef10b4a83aa");
			 */

			JSONObject jsonOthr = new JSONObject(callData.getN_ar());
			JSONObject jsonEn = new JSONObject(callData.getN_en());

			String urlParameters = "id=" + callData.getId() + "&n-ar=" + jsonOthr + "&n-en=" + jsonEn + "&dob="
					+ callData.getDob() + "&country=" + callData.getCountry();

			System.out.println("urlParameters " + urlParameters);
			logger.info("urlParameters  " + urlParameters);

			// Send post request
			con.setDoOutput(true);
			DataOutputStream wr = new DataOutputStream(con.getOutputStream());
			wr.writeBytes(urlParameters);
			wr.flush();
			wr.close();

			int responseCode = con.getResponseCode();
			System.out.println("Response Code : " + responseCode);

			BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));

			while ((inputLine = in.readLine()) != null) {
				response.append(inputLine);
			}
			in.close();

			System.out.println(response.toString());

			// JSONObject json = new JSONObject(response.toString());
			// String accessToken = json.getString("access_token");

			// print result
			// System.out.println("accessToken "+accessToken);

		} catch (IOException e) {
			e.printStackTrace();
		}

		return response.toString();
	}

	public String addRequestDatainDB(WorldCheckCallAPI callData) {

		JSONObject jsonVal = new JSONObject(callData);
		Long id = null;
		String ar_name1 = "", ar_name2 = "", ar_name3 = "", en_name1 = "",
				en_name2 = "", en_name3 = "", dob = "", country = "";

		WorldCheckCallAPIEntity apiEntity = new WorldCheckCallAPIEntity();

		try {
			if (jsonVal.has("id")) {
				id = jsonVal.getLong("id");
			}
			JSONObject jsonAr = new JSONObject(callData.getN_ar());
			JSONObject jsonEn = new JSONObject(callData.getN_en());

			if (jsonVal.has("n_ar")) {
				if (jsonAr.length() > 0) {
					if ((jsonAr.has("name1") && jsonAr.has("name2") && jsonAr.has("name3"))) {
						ar_name1 = jsonAr.getString("name1");
						ar_name2 = jsonAr.getString("name2");
						ar_name3 = jsonAr.getString("name3");
					}
				}
			}

			if (jsonVal.has("n_en")) {

				if (jsonEn.length() > 0) {
					if (jsonEn.has("name1") && jsonEn.has("name2") && jsonEn.has("name3")) {
						en_name1 = jsonEn.getString("name1");
						en_name2 = jsonEn.getString("name2");
						en_name3 = jsonEn.getString("name3");
					}
				}
			}

			if (jsonVal.has("dob")) {
				dob = jsonVal.getString("dob");
			}

			if (jsonVal.has("country")) {
				country = jsonVal.getString("country");
			}

			// adding the request data into entity object

			apiEntity.setId(id);

			if ((ar_name1 != null && !"null".equals(ar_name1))&& (ar_name2 != null && !"null".equals(ar_name1)) && (ar_name3 != null && !"null".equals(ar_name1))) {
				apiEntity.setN_ar("Y");
				apiEntity.setAr_name1(ar_name1);
				apiEntity.setAr_name2(ar_name2);
				apiEntity.setAr_name3(ar_name3);
			} else {
				apiEntity.setN_ar("N");
			}
			if ((en_name1 != null && !"null".equals(en_name1))&& (en_name2 != null && !"null".equals(en_name2)) && (en_name3 != null && !"null".equals(en_name3))) {
				apiEntity.setN_en("Y");
				apiEntity.setEn_name1(en_name1);
				apiEntity.setEn_name2(en_name2);
				apiEntity.setEn_name3(en_name3);
			} else {
				apiEntity.setN_en("N");
			}

			apiEntity.setDob(dob);
			apiEntity.setCountry(country);
			apiEntity.setMakerstamp(new Date(System.currentTimeMillis()));

			if (!"".equals(apiEntity))
				repository.save(apiEntity);

		} catch (JSONException e) {
			e.printStackTrace();
		}

		return "Record inserted !!!!";
	}

}
