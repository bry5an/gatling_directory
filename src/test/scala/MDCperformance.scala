
import scala.concurrent.duration._

import io.gatling.core.Predef._
import io.gatling.http.Predef._
import io.gatling.jdbc.Predef._

class TickerTest extends Simulation {

	val httpProtocol = http
		.baseURL("https://mdc-performance.kingsmensoftware.com")
		.inferHtmlResources()
		.acceptHeader("*/*")
		.acceptEncodingHeader("gzip, deflate, br")
		.acceptLanguageHeader("en-US,en;q=0.5")
		.userAgentHeader("Mozilla/5.0 (Macintosh; Intel Mac OS X 10.11; rv:46.0) Gecko/20100101 Firefox/46.0")

	val headers_0 = Map("Accept" -> "text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8")

	val headers_1 = Map("Accept" -> "image/png,image/*;q=0.8,*/*;q=0.5")

	val headers_3 = Map(
		"Accept" -> "application/json, text/javascript, */*; q=0.01",
		"X-Requested-With" -> "XMLHttpRequest")

	val headers_4 = Map("Accept" -> "application/json, text/plain, */*")

	val headers_10 = Map(
		"Accept" -> "application/font-woff2;q=1.0,application/font-woff;q=0.9,*/*;q=0.8",
		"Accept-Encoding" -> "identity")

	val headers_15 = Map("X-Requested-With" -> "XMLHttpRequest")

	val headers_22 = Map("Accept" -> "text/css,*/*;q=0.1")

    val uri1 = "https://f2-registry-performance.kingsmensoftware.com:443"
    val uri2 = "https://mdc-performance.kingsmensoftware.com:443"

	val scn = scenario("TickerTest")
		// Initial Site Load
		.exec(http("request_0")
			.get("/")
			.headers(headers_0)
			.resources(http("overlay-pattern png")
			.get(uri2 + "/AppCompiled/Content/images/pattern/overlay-pattern.png")
			.headers(headers_1),
            http("mybg png")
			.get(uri2 + "/AppCompiled/Content/images/mybg.png")
			.headers(headers_1),
            http("SecurityAssertion")
			.get(uri2 + "/dataapi/data/SecurityAssertion")
			.headers(headers_3),
            http("ConfigurationItems")
			.get(uri2 + "/dataapi/data/ConfigurationItems?$orderby=Value&")
			.headers(headers_4),
            http("favicon")
			.get(uri2 + "/favicon.ico")
			.headers(headers_1),
            http("Dashboard Assertion")
			.get(uri2 + "/dataapi/data/Dashboards?$filter=(ApplicationUser_Id%20eq%200)%20and%20((IsActive%20eq%20true)%20and%20(IsDeleted%20eq%20false))&$orderby=Title&")
			.headers(headers_4)
			.check(status.is(401)),
            http("PermissionNeededId?")
			.get(uri2 + "/dataapi/data/Screens?$filter=((ControlPointName%20ne%20null)%20and%20(PermissionNeededId%20ne%20null))%20and%20(IsDeleted%20eq%20false)&$select=Id%2CStateName%2CControlPointName%2CPermissionNeeded%2FAlternateValue&")
			.headers(headers_4),
            http("NavigationPanel")
			.get(uri2 + "/PageComponents/NavigationPanel/ec8d40ee-1ff1-4d0a-b16c-5582c430e68f")
			.headers(headers_4),
            http("WF-logo small png")
			.get(uri2 + "/AppCompiled/Content/images/wf-logo_sm.png")
			.headers(headers_1),
            http("glyphicons2")
			.get(uri2 + "/AppCompiled/fonts/glyphicons-halflings-regular.woff2")
			.headers(headers_10)
			.check(status.is(404)),
            http("Fontawesome-Webfont1")
			.get(uri2 + "/AppCompiled/fonts/fontawesome-webfont.woff2?v=4.4.0")
			.headers(headers_10)
			.check(status.is(404)),
            http("Messages Check")
			.get(uri2 + "/dataapi/data/Messages?$filter=((((MessageType_Id%20eq%20guid%27bf7fbdb3-c127-4fae-8d56-cf79894d41b2%27)%20and%20(DisplayType_Id%20eq%20guid%27cf68c43f-8e3c-4829-8a5a-f9f6119d69a0%27))%20and%20(StartDate%20le%20datetime%272016-05-17T14%3A10%3A28.334Z%27))%20and%20(EndDate%20ge%20datetime%272016-05-17T14%3A10%3A28.334Z%27))%20and%20((IsActive%20eq%20true)%20and%20(IsDeleted%20eq%20false))&$orderby=StartDate&$select=Id%2CTitle%2CSubject%2CFrom%2CTo%2CBody%2CStartDate%2CEndDate&")
			.headers(headers_4),
            http("glyphicons1")
			.get(uri2 + "/AppCompiled/fonts/glyphicons-halflings-regular.woff")
			.headers(headers_10),
            http("Fontawesome-Webfont2")
			.get(uri2 + "/AppCompiled/fonts/fontawesome-webfont.woff?v=4.4.0")
			.headers(headers_10)))
		.pause(3)
		// Search WFC
		.exec(http("Search 'W'")
			.get("/api/Securities/GetCount?searchTerm=w")
			.headers(headers_15)
			.resources(http("Return 'W'")
			.get(uri2 + "/api/Securities/GetAutoComplete?searchTerm=w")
			.headers(headers_15),
            http("Search 'WF'")
			.get(uri2 + "/api/Securities/GetCount?searchTerm=wf")
			.headers(headers_15),
            http("Return 'WF'")
			.get(uri2 + "/api/Securities/GetAutoComplete?searchTerm=wf")
			.headers(headers_15),
            http("Search 'WFC'")
			.get(uri2 + "/api/Securities/GetCount?searchTerm=wfc")
			.headers(headers_15),
            http("Return 'WFC'")
			.get(uri2 + "/api/Securities/GetAutoComplete?searchTerm=wfc")
			.headers(headers_15)))
		.pause(2)
		// Click WFC
		.exec(http("Click 'WFC'")
			.get(uri1 + "/F2AppManifests/EquityQuote/?params=%5B%7B%22appId%22%3A%22com_wellsfargo_mdc_equity_quote%22%2C%22manifestUrl%22%3A%22https%3A%2F%2Ff2-registry-performance.kingsmensoftware.com%2FF2AppManifests%2FEquityQuote%2F%22%2C%22views%22%3A%5B%22home%22%2C%22settings%22%2C%22about%22%5D%2C%22context%22%3A%7B%22symbol%22%3A%22WFC%22%7D%2C%22minGridSize%22%3A12%2C%22instanceId%22%3A%2225a83885-9b6f-cece-5e7d-40a420eee5b8%22%7D%5D&_=1463494227647")
			.resources(http("app.css")
			.get(uri1 + "/AppCompiled/F2Apps/EquityQuote/app.css")
			.headers(headers_22),
            http("appclass.js")
			.get(uri1 + "/AppCompiled/F2Apps/EquityQuote/appclass.js"),
            http("common.js")
			.get(uri1 + "/AppCompiled/F2Apps/Common/common.js"),
            http("ajax-loader.gif")
			.get(uri2 + "/AppCompiled/Content/images/ajax-loader.gif")
			.headers(headers_1),
            http("jQuery WFC request")
			.get(uri1 + "/api/Equities?callback=jQuery22109748590903497907_1463494227648&symbol=WFC&_=1463494227649")))

	// setUp(scn.inject(atOnceUsers(1)))
	setUp(
		scn.inject(constantUsersPerSec(2) during(30 seconds))
		// scn.inject(atOnceUsers(30))
	).protocols(httpProtocol)
}


