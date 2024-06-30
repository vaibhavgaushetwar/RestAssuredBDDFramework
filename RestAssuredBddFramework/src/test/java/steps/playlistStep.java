package steps;

import static io.restassured.RestAssured.given;
import static org.testng.Assert.assertEquals;

import java.io.IOException;

import com.spotify.pojo.Playlist;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import utils.SpecBuilder;

public class playlistStep {
	RequestSpecification res;
	 Response response ;
	static String playlistid;
	@Given("Create playlist api payload")
	public void create_playlist_api_payload() throws IOException {
		Playlist reqPlayList = new Playlist();
		reqPlayList.setName(" Create 9 framework builder with rest assured23");
		reqPlayList.setDescription("Creating using spotify id222");
		reqPlayList.setPublic(false);
		 res = given(SpecBuilder.reqSpect())
				.body(reqPlayList);
	}

	@When("user calls with POST http request")
	public void user_calls_with_post_http_request() {
		response = res.when().post("users/31ae5p4og7gxwdwxnhayufn5woeu/playlists");
	    
	}

	@Then("Api call executed with status code {int}")
	public void api_call_executed_with_status_code(Integer int1) {
	   Playlist playlist = response.as(Playlist.class);
	   
	  String playlistName = playlist.getName();
	  System.out.println(playlistName);
	    playlistid = playlist.getId();
	   System.out.println("playlistid=" +playlistid);
	   response.then()
	   .spec(SpecBuilder.resSpect())
	   .assertThat()
	   .statusCode(int1);
	}

	@Given("Get a playlist payload")
	public void get_a_playlist_payload() throws IOException {
		res= given(SpecBuilder.reqSpect())
				.pathParam("pid", playlistid);
	}

	@When("user call with GET http code")
	public void user_call_with_get_http_code() {
		System.out.println("playlistid in get="+playlistid);
		res.get("playlists/{pid}")
				.then()
				 .spec(SpecBuilder.resSpect());
		
		//assert.equals(playlistid)
		
	}
	@Then("api call executed with status code {int}")
	public void api_cal_executed_with_status_code(Integer stsCode) {

		res.then()
		 .spec(SpecBuilder.resSpect())
		 .statusCode(stsCode);
		
	
		//assertEquals(response.statusCo),stsCode);
	}
	@Given("Update playlist api payload")
	public void update_playlist_api_payload() throws IOException {
		Playlist reqPlayList = new Playlist();
		reqPlayList.setName("framework update with rest assured");
		reqPlayList.setDescription("Creating using spotify id222");
		reqPlayList.setPublic(false);
		 res = given(SpecBuilder.reqSpect())
				.body(reqPlayList);
	}

	@When("user calls with PUT http request")
	public void user_calls_with_put_http_request() {
		response = res.when()
	   .put("/playlists/" +playlistid);
	}

	@Then("Api call should  executes with status code {int}")
	public void api_call_should_executes_with_status_code(Integer expectedStatusCode) {
		response.then().assertThat().statusCode(expectedStatusCode);
	}

}
