
import scala.concurrent.duration._

import io.gatling.core.Predef._
import io.gatling.http.Predef._
import io.gatling.jdbc.Predef._

class MDCperformance extends Simulation {

	val httpProtocol = http
		.baseURL("https://mdc-performance.kingsmensoftware.com")
		.inferHtmlResources()
		.acceptHeader("*/*")
		.acceptEncodingHeader("gzip, deflate, br")
		.acceptLanguageHeader("en-US,en;q=0.5")
		.userAgentHeader("Mozilla/5.0 (Macintosh; Intel Mac OS X 10.11; rv:45.0) Gecko/20100101 Firefox/45.0")

	val headers_0 = Map("Accept" -> "text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8")

	val headers_1 = Map("Accept" -> "image/png,image/*;q=0.8,*/*;q=0.5")

	val headers_3 = Map(
		"Accept" -> "application/json, text/javascript, */*; q=0.01",
		"X-Requested-With" -> "XMLHttpRequest")

	val headers_4 = Map("Accept" -> "application/json, text/plain, */*")

	val headers_9 = Map(
		"Accept" -> "application/font-woff2;q=1.0,application/font-woff;q=0.9,*/*;q=0.8",
		"Accept-Encoding" -> "identity")

	val headers_17 = Map("X-Requested-With" -> "XMLHttpRequest")

    val uri1 = "https://mdc-performance.kingsmensoftware.com:443"

	val scn = scenario("MDCperformance")
		// Site Load
		.exec(http("request_0")
			.get("/")
			.headers(headers_0)
			.resources(http("request_1")
			.get(uri1 + "/AppCompiled/Content/images/pattern/overlay-pattern.png")
			.headers(headers_1),
			// .check(status.is(304))
            http("request_2")
			.get(uri1 + "/AppCompiled/Content/images/mybg.png")
			.headers(headers_1),
			// .check(status.is(304))
            http("request_3")
			.get(uri1 + "/dataapi/data/SecurityAssertion")
			.headers(headers_3),
            http("request_4")
			.get(uri1 + "/dataapi/data/ConfigurationItems?$orderby=Value&")
			.headers(headers_4),
            http("request_5")
			.get(uri1 + "/dataapi/data/Messages?$filter=((((MessageType_Id%20eq%20guid%27bf7fbdb3-c127-4fae-8d56-cf79894d41b2%27)%20and%20(DisplayType_Id%20eq%20guid%27cf68c43f-8e3c-4829-8a5a-f9f6119d69a0%27))%20and%20(StartDate%20le%20datetime%272016-05-04T13%3A30%3A01.418Z%27))%20and%20(EndDate%20ge%20datetime%272016-05-04T13%3A30%3A01.418Z%27))%20and%20((IsActive%20eq%20true)%20and%20(IsDeleted%20eq%20false))&$orderby=StartDate&$select=Id%2CTitle%2CSubject%2CFrom%2CTo%2CBody%2CStartDate%2CEndDate&")
			.headers(headers_4),
            http("request_6")
			.get(uri1 + "/dataapi/data/Dashboards?$filter=(ApplicationUser_Id%20eq%20guid%27626ca629-ab51-4be5-ab18-eef82bfcc70d%27)%20and%20((IsActive%20eq%20true)%20and%20(IsDeleted%20eq%20false))&$orderby=Title&")
			.headers(headers_4),
            http("request_7")
			.get(uri1 + "/AppCompiled/Content/images/wf-logo_sm.png")
			.headers(headers_1),
			// .check(status.is(304))
            http("request_8")
			.get(uri1 + "/PageComponents/NavigationPanel")
			.headers(headers_4),
            http("request_9")
			.get(uri1 + "/AppCompiled/fonts/fontawesome-webfont.woff2?v=4.4.0")
			.headers(headers_9)
			.check(status.is(404)),
            http("request_10")
			.get(uri1 + "/AppCompiled/fonts/glyphicons-halflings-regular.woff2")
			.headers(headers_9)
			.check(status.is(404))))
		.pause(6)
		// Equities
		.exec(http("request_11")
			.get("/dataapi/data/WidgetDataSources?$filter=Id%20eq%20guid%2774818ed2-5f09-e611-82d5-002170ba297c%27&$expand=Fields&")
			.headers(headers_4)
			.resources(http("request_12")
			.get(uri1 + "/AppCompiled/Content/Default/sprite.png")
			.headers(headers_1),
            http("request_13")
			.get(uri1 + "/AppCompiled/Content/Default/loading-image.gif")
			.headers(headers_1),
            http("request_14")
			.get(uri1 + "/api/DynamicData?%24format=json&DataSourceId=74818ed2-5f09-e611-82d5-002170ba297c&%24top=25&%24orderby=Name&%24count=true")
			.headers(headers_3)))
		.pause(6)
		// Futures
		.exec(http("request_15")
			.get("/dataapi/data/WidgetDataSources?$filter=Id%20eq%20guid%27af99efbf-470a-e611-82d6-002170ba297c%27&$expand=Fields&")
			.headers(headers_4)
			.resources(http("request_16")
			.get(uri1 + "/api/DynamicData?%24format=json&DataSourceId=af99efbf-470a-e611-82d6-002170ba297c&%24top=25&%24orderby=SortOrder%2CName&%24filter=contains(tolower(NameForSearching)%2C%27continuous%27)&%24count=true")
			.headers(headers_3)))
		.pause(6)
		// WFC Search
		.exec(http("request_17")
			.get("/api/Securities/GetCount?searchTerm=w")
			.headers(headers_17)
			.resources(http("request_18")
			.get(uri1 + "/api/Securities/GetAutoComplete?searchTerm=w")
			.headers(headers_17),
            http("request_19")
			.get(uri1 + "/api/Securities/GetCount?searchTerm=wf")
			.headers(headers_17),
            http("request_20")
			.get(uri1 + "/api/Securities/GetAutoComplete?searchTerm=wf")
			.headers(headers_17),
            http("request_21")
			.get(uri1 + "/api/Securities/GetCount?searchTerm=wfc")
			.headers(headers_17),
            http("request_22")
			.get(uri1 + "/api/Securities/GetAutoComplete?searchTerm=wfc")
			.headers(headers_17)))

	// setUp(scn.inject(atOnceUsers(1)))
	setUp(scn.inject(constantUsersPerSec(1) during(30 seconds)))
	.protocols(httpProtocol)
}