package utils;

import java.io.IOException;

import org.testng.annotations.Test;

import OauthMananger.AccesToken;
import io.qameta.allure.Step;
import io.qameta.allure.restassured.AllureRestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

public class SpecBuilder {
	@Step
	
    public static  RequestSpecification reqSpect() throws IOException {
    	
    	return new RequestSpecBuilder()
    	 .setBaseUri("https://api.spotify.com")
    	 .setBasePath("/v1")
    	 .addHeader("Content-Type","application/json")
    	 .addHeader("Authorization",
 				"Bearer " +AccesToken.getAccessToke())
    	 .addFilter(new AllureRestAssured())
    	 .log(LogDetail.ALL)
    	 .build();
    }
    
    @Step
    public static ResponseSpecification resSpect() {
     return new ResponseSpecBuilder()
    	  .expectContentType(ContentType.JSON)
    	  .log(LogDetail.ALL)
		  .build();
	
    }
}
