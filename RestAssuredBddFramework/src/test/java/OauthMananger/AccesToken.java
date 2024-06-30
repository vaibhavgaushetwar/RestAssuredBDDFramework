package OauthMananger;

import java.io.IOException;
import java.util.HashMap;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import utils.ConfigReader;

import static io.restassured.RestAssured.given;
public class AccesToken {
  public static String getAccessToke() throws IOException {
	  ConfigReader cr = new ConfigReader();
	  //  HashMap(String ,String) hasmap= new HashMap(String ,String);
	  HashMap<String,String>	 hasmap =new HashMap<String,String>();
	  hasmap.put("grant_type", "refresh_token");
	  hasmap.put("refresh_token", cr.readConfigData("refreshtoken"));
	  hasmap.put("client_id", cr.readConfigData("client_id"));
	  hasmap.put("client_secret", cr.readConfigData("client_secret"));
	  
	  RestAssured.baseURI="https://accounts.spotify.com";
	   Response response = given()
	 .contentType(ContentType.URLENC)
	 .formParams(hasmap)
	 .when()
	 .post("/api/token")
	 .then()
	 .extract()
	 .response();
	   JsonPath jp=response.jsonPath();
	      String accesToken=jp.getString("access_token");
	      if(response.statusCode()!=200) {
	    	  throw new RuntimeException("failed to generate access token");
	      }
	      return accesToken;
          
  }
}
