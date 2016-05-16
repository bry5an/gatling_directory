
import scala.concurrent.duration._

import io.gatling.core.Predef._
import io.gatling.http.Predef._
import io.gatling.jdbc.Predef._

class PerfPerformance1 extends Simulation {

	val httpProtocol = http
		.baseURL("https://f2-registry-performance.kingsmensoftware.com")
		.inferHtmlResources(BlackList(), WhiteList())
		.acceptHeader("*/*")
		.acceptEncodingHeader("gzip, deflate, sdch")
		.acceptLanguageHeader("en-US,en;q=0.8")
		.userAgentHeader("Mozilla/5.0 (Macintosh; Intel Mac OS X 10_11_4) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/50.0.2661.94 Safari/537.36")

	val headers_0 = Map(
		"Accept" -> "text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,*/*;q=0.8",
		"Cache-Control" -> "max-age=0",
		"Upgrade-Insecure-Requests" -> "1")

	val headers_1 = Map(
		"Accept" -> "image/webp,image/*,*/*;q=0.8",
		"Cache-Control" -> "max-age=0",
		"If-Modified-Since" -> "Mon, 16 May 2016 19:23:54 GMT",
		"If-None-Match" -> "a94967ca8afd11:0")

	val headers_3 = Map(
		"Accept" -> "application/json, text/javascript, */*; q=0.01",
		"Cache-Control" -> "max-age=0",
		"X-Requested-With" -> "XMLHttpRequest")

	val headers_4 = Map(
		"Accept" -> "application/json, text/plain, */*",
		"Cache-Control" -> "max-age=0")

	val headers_5 = Map("Accept" -> "application/json, text/plain, */*")

	val headers_8 = Map(
		"Accept" -> "image/webp,image/*,*/*;q=0.8",
		"If-Modified-Since" -> "Mon, 16 May 2016 19:23:54 GMT",
		"If-None-Match" -> "a94967ca8afd11:0")

	val headers_9 = Map(
		"Cache-Control" -> "max-age=0",
		"Origin" -> "https://mdc-performance.kingsmensoftware.com")

	val headers_12 = Map(
		"Cache-Control" -> "max-age=0",
		"If-Modified-Since" -> "Mon, 16 May 2016 19:23:54 GMT",
		"If-None-Match" -> "e2cb7ca8afd11:0",
		"Origin" -> "https://mdc-performance.kingsmensoftware.com")

	val headers_14 = Map("X-Requested-With" -> "XMLHttpRequest")

	val headers_21 = Map(
		"Accept" -> "text/css,*/*;q=0.1",
		"If-Modified-Since" -> "Mon, 16 May 2016 19:08:49 GMT",
		"If-None-Match" -> "10c5f460a6afd11:0")

	val headers_22 = Map(
		"If-Modified-Since" -> "Mon, 16 May 2016 19:08:49 GMT",
		"If-None-Match" -> "10c5f460a6afd11:0")

	val headers_25 = Map(
		"Accept" -> "image/webp,image/*,*/*;q=0.8",
		"If-Modified-Since" -> "Mon, 16 May 2016 19:23:54 GMT",
		"If-None-Match" -> "7e737ca8afd11:0")

    val uri2 = "https://mdc-performance.kingsmensoftware.com"

	val scn = scenario("PerfPerformance1")
		.exec(http("Initial Site Load")
			.get(uri2 + "/")
			.headers(headers_0)
			.resources(http("Background PNG")
			.get(uri2 + "/AppCompiled/Content/images/mybg.png")
			.headers(headers_1),
			// .check(status.is(304))
            http("Pattern PNG")
			.get(uri2 + "/AppCompiled/Content/images/pattern/overlay-pattern.png")
			.headers(headers_1),
			// .check(status.is(304))
            http("Security Assertion")
			.get(uri2 + "/dataapi/data/SecurityAssertion")
			.headers(headers_3),
            http("ConfigurationItems")
			.get(uri2 + "/dataapi/data/ConfigurationItems?$orderby=Value&")
			.headers(headers_4),
            http("request_5")
			.get(uri2 + "/dataapi/data/Screens?$filter=((ControlPointName%20ne%20null)%20and%20(PermissionNeededId%20ne%20null))%20and%20(IsDeleted%20eq%20false)&$select=Id%2CStateName%2CControlPointName%2CPermissionNeeded%2FAlternateValue&")
			.headers(headers_5),
            http("request_6")
			.get(uri2 + "/dataapi/data/Dashboards?$filter=(ApplicationUser_Id%20eq%200)%20and%20((IsActive%20eq%20true)%20and%20(IsDeleted%20eq%20false))&$orderby=Title&")
			.headers(headers_5)
			.check(status.is(401)),
            http("NavigationPanel Load")
			.get(uri2 + "/PageComponents/NavigationPanel/1d380486-ac55-4cab-978d-4039ff9d142a")
			.headers(headers_5),
            http("WFC Logo")
			.get(uri2 + "/AppCompiled/Content/images/wf-logo_sm.png")
			.headers(headers_8),
			// .check(status.is(304))
            http("fontawesome-webfont")
			.get(uri2 + "/AppCompiled/fonts/fontawesome-webfont.woff2?v=4.4.0")
			.headers(headers_9)
			.check(status.is(404)),
            http("glyphicons-halflings-regular")
			.get(uri2 + "/AppCompiled/fonts/glyphicons-halflings-regular.woff2")
			.headers(headers_9)
			.check(status.is(404)),
            http("request_11")
			.get(uri2 + "/dataapi/data/Messages?$filter=((((MessageType_Id%20eq%20guid%27bf7fbdb3-c127-4fae-8d56-cf79894d41b2%27)%20and%20(DisplayType_Id%20eq%20guid%27cf68c43f-8e3c-4829-8a5a-f9f6119d69a0%27))%20and%20(StartDate%20le%20datetime%272016-05-16T20%3A34%3A43.866Z%27))%20and%20(EndDate%20ge%20datetime%272016-05-16T20%3A34%3A43.866Z%27))%20and%20((IsActive%20eq%20true)%20and%20(IsDeleted%20eq%20false))&$orderby=StartDate&$select=Id%2CTitle%2CSubject%2CFrom%2CTo%2CBody%2CStartDate%2CEndDate&")
			.headers(headers_5),
            http("request_12")
			.get(uri2 + "/AppCompiled/fonts/glyphicons-halflings-regular.woff")
			.headers(headers_12),
			// .check(status.is(304))
            http("request_13")
			.get(uri2 + "/AppCompiled/fonts/fontawesome-webfont.woff?v=4.4.0")
			.headers(headers_12)))
		.pause(3)
		// Search WFC
		.exec(http("Search W")
			.get(uri2 + "/api/Securities/GetCount?searchTerm=w")
			.headers(headers_14)
			.resources(http("Get W")
			.get(uri2 + "/api/Securities/GetAutoComplete?searchTerm=w")
			.headers(headers_14),
            http("Search WF")
			.get(uri2 + "/api/Securities/GetCount?searchTerm=wf")
			.headers(headers_14),
            http("Get WF")
			.get(uri2 + "/api/Securities/GetAutoComplete?searchTerm=wf")
			.headers(headers_14),
            http("Search WFC")
			.get(uri2 + "/api/Securities/GetCount?searchTerm=wfc")
			.headers(headers_14),
            http("Get WFC")
			.get(uri2 + "/api/Securities/GetAutoComplete?searchTerm=wfc")
			.headers(headers_14)))
		.pause(1)
		.exec(http("Click WFC")
			.get("/F2AppManifests/EquityQuote/?params=%5B%7B%22appId%22%3A%22com_wellsfargo_mdc_equity_quote%22%2C%22manifestUrl%22%3A%22https%3A%2F%2Ff2-registry-performance.kingsmensoftware.com%2FF2AppManifests%2FEquityQuote%2F%22%2C%22views%22%3A%5B%22home%22%2C%22settings%22%2C%22about%22%5D%2C%22context%22%3A%7B%22symbol%22%3A%22WFC%22%7D%2C%22minGridSize%22%3A12%2C%22instanceId%22%3A%22da1ed97b-12eb-1236-4701-f028ee7ecdab%22%7D%5D&_=1463430883073"))
		.pause(1)
		.exec(http("Load WFC CSS")
			.get("/AppCompiled/F2Apps/EquityQuote/app.css")
			.headers(headers_21)
			.resources(http("Load WFC JS")
			.get(uri1 + "/AppCompiled/F2Apps/EquityQuote/appclass.js")
			.headers(headers_22),
			// .check(status.is(304))
            http("request_23")
			.get(uri1 + "/AppCompiled/F2Apps/Common/common.js")
			.headers(headers_22),
			// .check(status.is(304))
            http("request_24")
			.get(uri1 + "/api/Equities?callback=jQuery221004943347636345141_1463430883074&symbol=WFC&_=1463430883075"),
            http("request_25")
			.get(uri2 + "/AppCompiled/Content/images/ajax-loader.gif")
			.headers(headers_25)))

	// setUp(scn.inject(atOnceUsers(1)))
	setUp(scn.inject(constantUsersPerSec(10) during(30 seconds)))
	.protocols(httpProtocol)
}