package com.baeldung.restassured;

<<<<<<< HEAD
import static com.github.tomakehurst.wiremock.client.WireMock.aResponse;
import static com.github.tomakehurst.wiremock.client.WireMock.configureFor;
import static com.github.tomakehurst.wiremock.client.WireMock.get;
import static com.github.tomakehurst.wiremock.client.WireMock.stubFor;
import static com.github.tomakehurst.wiremock.client.WireMock.urlEqualTo;
=======
import com.github.fge.jsonschema.SchemaVersion;
import com.github.fge.jsonschema.cfg.ValidationConfiguration;
import com.github.fge.jsonschema.main.JsonSchemaFactory;
import com.github.tomakehurst.wiremock.WireMockServer;
import com.github.tomakehurst.wiremock.client.WireMock;
import io.restassured.module.jsv.JsonSchemaValidator;
import org.junit.Ignore;
import org.junit.Test;

import static com.github.tomakehurst.wiremock.client.WireMock.*;
>>>>>>> upstream/master
import static io.restassured.RestAssured.get;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;
import static io.restassured.module.jsv.JsonSchemaValidatorSettings.settings;
import static org.hamcrest.Matchers.*;
import static org.hamcrest.Matchers.equalTo;
<<<<<<< HEAD
import static org.hamcrest.Matchers.hasItems;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.github.fge.jsonschema.SchemaVersion;
import com.github.fge.jsonschema.cfg.ValidationConfiguration;
import com.github.fge.jsonschema.main.JsonSchemaFactory;
import com.github.tomakehurst.wiremock.WireMockServer;
=======
import static org.hamcrest.xml.HasXPath.hasXPath;

>>>>>>> upstream/master

public class RestAssuredTest {

	private WireMockServer wireMockServer = new WireMockServer();
	private static final String EVENTS_PATH = "/events?id=390";
	private static final String APPLICATION_JSON = "application/json";
	private static final String GAME_ODDS = getEventJson();

	@Before
	public void before() throws Exception {
		System.out.println("Setting up!");
		wireMockServer.start();
		configureFor("localhost", 8080);
		stubFor(get(urlEqualTo(EVENTS_PATH)).willReturn(
				aResponse().withStatus(200)
						.withHeader("Content-Type", APPLICATION_JSON)
						.withBody(GAME_ODDS)));
	}

	@Test
	public void givenUrl_whenCheckingFloatValuePasses_thenCorrect() {
		get("/events?id=390").then().assertThat()
				.body("odd.ck", equalTo(12.2f));
	}

	private WireMockServer wireMockServer = new WireMockServer();
	private static final String EVENTS_PATH = "/events?id=390";
	private static final String APPLICATION_JSON = "application/json";

	private static final String GAME_ODDS = "" +
			"{" +
			"  \"id\": 390," +
			"  \"data\": {" +
			"    \"countryId\": 35," +
			"    \"countryName\": \"Norway\"," +
			"    \"leagueName\": \"Norway 3\"," +
			"    \"status\": 0," +
			"    \"sportName\": \"Soccer\"," +
			"    \"time\": \"2016-06-12T12:00:00Z\"" +
			"  }," +
			"  \"odds\": [" +
			"    {" +
			"      \"price\": \"1.30\"," +
			"      \"status\": 0," +
			"      \"ck\": \"1\"," +
			"      \"name\": \"1\"" +
			"    }," +
			"    {" +
			"      \"price\": \"5.25\"," +
			"      \"status\": 0," +
			"      \"ck\": \"X\"," +
			"      \"name\": \"X\"" +
			"    }" +
			"  ]" +
			"}";


	@Test
	public void givenUrl_whenSuccessOnGetsResponse_andJsonHasRequiredKV_thenCorrect()  {

		wireMockServer.start();
		configureFor("localhost", 8080);

		stubFor(WireMock.get(urlEqualTo(EVENTS_PATH)).willReturn(aResponse()
				.withStatus(200)
				.withHeader("Content-Type", APPLICATION_JSON)
				.withBody(GAME_ODDS)));

		get("/events?id=390").then().statusCode(200).assertThat()
<<<<<<< HEAD
				.body("id", equalTo("390"));
=======
							 .body("id", equalTo(390));
>>>>>>> upstream/master

		wireMockServer.stop();
	}


	@Test
	public void givenUrl_whenJsonResponseHasArrayWithGivenValuesUnderKey_thenCorrect() {
<<<<<<< HEAD
		get("/events?id=390").then().assertThat()
				.body("odds.price", hasItems(1.30f, 5.25f, 2.70f, 1.20f));
=======

		wireMockServer.start();
		configureFor("localhost", 8080);

		stubFor(WireMock.get(urlEqualTo(EVENTS_PATH)).willReturn(aResponse()
				.withStatus(200)
				.withHeader("Content-Type", APPLICATION_JSON)
				.withBody(GAME_ODDS)));

		get("/events?id=390").then().assertThat()
							 .body("odds.price", hasItems("1.30", "5.25"));

		wireMockServer.stop();
>>>>>>> upstream/master
	}


	@Test @Ignore
	public void givenUrl_whenJsonResponseConformsToSchema_thenCorrect() {

		get("/events?id=390").then().assertThat()
				.body(matchesJsonSchemaInClasspath("event_0.json"));
	}

	@Test @Ignore
	public void givenUrl_whenValidatesResponseWithInstanceSettings_thenCorrect() {
		JsonSchemaFactory jsonSchemaFactory = JsonSchemaFactory
				.newBuilder()
				.setValidationConfiguration(
						ValidationConfiguration.newBuilder()
								.setDefaultVersion(SchemaVersion.DRAFTV4)
								.freeze()).freeze();

		get("/events?id=390")
				.then()
				.assertThat()
				.body(matchesJsonSchemaInClasspath("event_0.json").using(
						jsonSchemaFactory));

	}

	@Test @Ignore
	public void givenUrl_whenValidatesResponseWithStaticSettings_thenCorrect() {

		get("/events?id=390")
<<<<<<< HEAD
				.then()
				.assertThat()
				.body(matchesJsonSchemaInClasspath("event_0.json").using(
						settings().with().checkedValidation(false)));
	}

	@After
	public void after() throws Exception {
		System.out.println("Running: tearDown");
		wireMockServer.stop();
	}

	private static String getEventJson() {
		return Util.inputStreamToString(new RestAssuredTest().getClass()
				.getResourceAsStream("/event_0.json"));
=======
		.then()
		.assertThat()
		.body(matchesJsonSchemaInClasspath("event_0.json").using(
				settings().with().checkedValidation(false)));

	}

	@Test @Ignore
	public void givenUrl_whenCheckingFloatValuePasses_thenCorrect() {
		get("/odd").then().assertThat().body("odd.ck", equalTo(12.2f));
	}

	@Test @Ignore
	public void givenUrl_whenXmlResponseValueTestsEqual_thenCorrect() {
		post("/employees").then().assertThat()
		.body("employees.employee.first-name", equalTo("Jane"));
	}

	@Test @Ignore
	public void givenUrl_whenMultipleXmlValuesTestEqual_thenCorrect() {
		post("/employees").then().assertThat()
		.body("employees.employee.first-name", equalTo("Jane"))
		.body("employees.employee.last-name", equalTo("Daisy"))
		.body("employees.employee.sex", equalTo("f"));
	}

	@Test @Ignore
	public void givenUrl_whenMultipleXmlValuesTestEqualInShortHand_thenCorrect() {
		post("/employees")
		.then()
		.assertThat()
		.body("employees.employee.first-name", equalTo("Jane"),
				"employees.employee.last-name", equalTo("Daisy"),
				"employees.employee.sex", equalTo("f"));
	}

	@Test @Ignore
	public void givenUrl_whenValidatesXmlUsingXpath_thenCorrect() {
		post("/employees")
		.then()
		.assertThat()
		.body(hasXPath("/employees/employee/first-name",
				containsString("Ja")));

	}

	@Test @Ignore
	public void givenUrl_whenValidatesXmlUsingXpath2_thenCorrect() {
		post("/employees")
		.then()
		.assertThat()
		.body(hasXPath("/employees/employee/first-name[text()='Jane']"));

	}

	@Test @Ignore
	public void givenUrl_whenVerifiesScienceTeacherFromXml_thenCorrect() {
		get("/teachers")
		.then()
		.body("teachers.teacher.find { it.@department == 'science' }.subject",
				hasItems("math", "physics"));
	}

	@Test @Ignore
	public void givenUrl_whenVerifiesOddPricesAccuratelyByStatus_thenCorrect() {
		get("/odds").then().body("odds.findAll { it.status > 0 }.price",
				hasItems(1.30f, 1.20f));
>>>>>>> upstream/master
	}

}
