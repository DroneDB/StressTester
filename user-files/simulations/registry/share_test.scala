package test

import scala.concurrent.duration._

import io.gatling.core.Predef._
import io.gatling.http.Predef._
import io.gatling.jdbc.Predef._

class ShareTest extends Simulation {

  	val sessionHeaders = Map("Authorization" -> "Bearer ${authToken}",
                           "Content-Type" -> "application/json")

  	val headers_3 = Map(
		"Content-Type" -> "multipart/form-data; boundary=------------------------c356e500f93c436a",
		"Proxy-Connection" -> "Keep-Alive",
		"Authorization" -> "Bearer ${authToken}")

	val headers_4 = Map(
		"Content-Type" -> "multipart/form-data; boundary=------------------------4315d6021795b690",
		"Proxy-Connection" -> "Keep-Alive",
		"Authorization" -> "Bearer ${authToken}")

	val headers_5 = Map(
		"Content-Type" -> "multipart/form-data; boundary=------------------------a06c06ed4870d616",
		"Proxy-Connection" -> "Keep-Alive",
		"Authorization" -> "Bearer ${authToken}")

	val headers_6 = Map(
		"Content-Type" -> "multipart/form-data; boundary=------------------------4db69b302e565b68",
		"Proxy-Connection" -> "Keep-Alive",
		"Authorization" -> "Bearer ${authToken}")

	val headers_7 = Map(
		"Content-Type" -> "multipart/form-data; boundary=------------------------a1d3b4d74907e6a1",
		"Proxy-Connection" -> "Keep-Alive",
		"Authorization" -> "Bearer ${authToken}")

	val headers_8 = Map(
		"Content-Type" -> "multipart/form-data; boundary=------------------------cb4ad10120f5d8c6",
		"Proxy-Connection" -> "Keep-Alive",
		"Authorization" -> "Bearer ${authToken}")

	val headers_9 = Map(
		"Content-Type" -> "multipart/form-data; boundary=------------------------844fd4fcc788f756",
		"Proxy-Connection" -> "Keep-Alive",
		"Authorization" -> "Bearer ${authToken}")

	val headers_10 = Map(
		"Content-Type" -> "multipart/form-data; boundary=------------------------7068d43b14b7ba58",
		"Proxy-Connection" -> "Keep-Alive",
		"Authorization" -> "Bearer ${authToken}")

	val headers_11 = Map(
		"Content-Type" -> "multipart/form-data; boundary=------------------------858fa73973df1ad4",
		"Proxy-Connection" -> "Keep-Alive",
		"Authorization" -> "Bearer ${authToken}")

	val headers_12 = Map(
		"Content-Type" -> "multipart/form-data; boundary=------------------------4aa94e8e0fcd5332",
		"Proxy-Connection" -> "Keep-Alive",
		"Authorization" -> "Bearer ${authToken}")

	val headers_13 = Map(
		"Content-Type" -> "multipart/form-data; boundary=------------------------c1e0ad0f7630389d",
		"Proxy-Connection" -> "Keep-Alive",
		"Authorization" -> "Bearer ${authToken}")

	val headers_14 = Map(
		"Content-Type" -> "multipart/form-data; boundary=------------------------bb4d876273c0b48c",
		"Proxy-Connection" -> "Keep-Alive",
		"Authorization" -> "Bearer ${authToken}")

	val headers_15 = Map(
		"Content-Type" -> "multipart/form-data; boundary=------------------------5426a1db5325c943",
		"Proxy-Connection" -> "Keep-Alive",
		"Authorization" -> "Bearer ${authToken}")

	val headers_16 = Map(
		"Content-Type" -> "multipart/form-data; boundary=------------------------41926352e3b6f963",
		"Proxy-Connection" -> "Keep-Alive",
		"Authorization" -> "Bearer ${authToken}")

	val headers_17 = Map(
		"Content-Type" -> "multipart/form-data; boundary=------------------------2e4a34c92b22dfd2",
		"Proxy-Connection" -> "Keep-Alive",
		"Authorization" -> "Bearer ${authToken}")

	val headers_18 = Map(
		"Content-Type" -> "multipart/form-data; boundary=------------------------6f54388c0e69ae9f",
		"Proxy-Connection" -> "Keep-Alive",
		"Authorization" -> "Bearer ${authToken}")

	val headers_19 = Map(
		"Content-Type" -> "multipart/form-data; boundary=------------------------74ec20637ad91248",
		"Proxy-Connection" -> "Keep-Alive",
		"Authorization" -> "Bearer ${authToken}")

	val headers_20 = Map(
		"Content-Type" -> "multipart/form-data; boundary=------------------------e008e9ee3abaaae1",
		"Proxy-Connection" -> "Keep-Alive",
		"Authorization" -> "Bearer ${authToken}")

	val headers_21 = Map(
		"Content-Type" -> "multipart/form-data; boundary=------------------------3eb62d77c6a9bc20",
		"Proxy-Connection" -> "Keep-Alive",
		"Authorization" -> "Bearer ${authToken}")

	val headers_22 = Map(
		"Content-Type" -> "multipart/form-data; boundary=------------------------c9ab0a7523c82c31",
		"Proxy-Connection" -> "Keep-Alive",
		"Authorization" -> "Bearer ${authToken}")

	val headers_23 = Map(
		"Content-Type" -> "multipart/form-data; boundary=------------------------c8aab1913f40824c",
		"Proxy-Connection" -> "Keep-Alive",
		"Authorization" -> "Bearer ${authToken}")

	val headers_25 = Map(
		"Content-Type" -> "multipart/form-data; boundary=------------------------63c98398fa0bb22b",
		"Proxy-Connection" -> "Keep-Alive",
		"Authorization" -> "Bearer ${authToken}")


	val httpProtocol = http.baseUrl("https://192.168.1.105:44359")
		
	val scn = scenario("share_test")
    /*
    .exec(http("get_organizations")
        .get("/orgs")
        .headers(sessionHeaders)
      )
    */
		.exec(http("login")
			  .post("/users/authenticate")
			  .formParam("username", "admin")
			  .formParam("password", "password")
        .check(jsonPath("$..token").exists.saveAs("authToken"))
      )    
    .exec(http("init")
			  .post("/share/init")
			  .headers(sessionHeaders)
			  .formParam("tag", "")
			  .formParam("password", "")
        .check(jsonPath("$..token").exists.saveAs("sessionToken"))
      )
    .exec(http("upload_1")
			  .post("/share/upload/${sessionToken}")
			  .headers(headers_3)
			  .body(RawFileBody("./resources/registry/share/0003_request.dat"))
      )    
	.exec(http("upload_2")
			  .post("/share/upload/${sessionToken}")
			  .headers(headers_4)
			  .body(RawFileBody("./resources/registry/share/0004_request.dat"))
      )
    .exec(http("upload_3")
			  .post("/share/upload/${sessionToken}")
			  .headers(headers_5)
			  .body(RawFileBody("./resources/registry/share/0005_request.dat"))
      )
    .exec(http("upload_4")
			  .post("/share/upload/${sessionToken}")
			  .headers(headers_6)
			  .body(RawFileBody("./resources/registry/share/0006_request.dat"))
      )
    .exec(http("upload_5")
			  .post("/share/upload/${sessionToken}")
			  .headers(headers_7)
			  .body(RawFileBody("./resources/registry/share/0007_request.dat"))
      )
    .exec(http("upload_6")
			  .post("/share/upload/${sessionToken}")
			  .headers(headers_8)
			  .body(RawFileBody("./resources/registry/share/0008_request.dat"))
      )
    .exec(http("upload_7")
			  .post("/share/upload/${sessionToken}")
			  .headers(headers_9)
			  .body(RawFileBody("./resources/registry/share/0009_request.dat"))
      )
    .exec(http("upload_8")
			  .post("/share/upload/${sessionToken}")
			  .headers(headers_10)
			  .body(RawFileBody("./resources/registry/share/0010_request.dat"))
      )
    .exec(http("upload_9")
			  .post("/share/upload/${sessionToken}")
			  .headers(headers_11)
			  .body(RawFileBody("./resources/registry/share/0011_request.dat"))
      )
    .exec(http("upload_10")
			  .post("/share/upload/${sessionToken}")
			  .headers(headers_12)
			  .body(RawFileBody("./resources/registry/share/0012_request.dat"))
      )
    .exec(http("upload_11")
			  .post("/share/upload/${sessionToken}")
			  .headers(headers_13)
			  .body(RawFileBody("./resources/registry/share/0013_request.dat"))
      )
    .exec(http("upload_12")
			  .post("/share/upload/${sessionToken}")
			  .headers(headers_14)
			  .body(RawFileBody("./resources/registry/share/0014_request.dat"))
      )
    .exec(http("upload_13")
			  .post("/share/upload/${sessionToken}")
			  .headers(headers_15)
			  .body(RawFileBody("./resources/registry/share/0015_request.dat"))
      )
    .exec(http("upload_14")
			  .post("/share/upload/${sessionToken}")
			  .headers(headers_16)
			  .body(RawFileBody("./resources/registry/share/0016_request.dat"))
      )
    .exec(http("upload_15")
			  .post("/share/upload/${sessionToken}")
			  .headers(headers_17)
			  .body(RawFileBody("./resources/registry/share/0017_request.dat"))
      )
    .exec(http("upload_16")
			  .post("/share/upload/${sessionToken}")
			  .headers(headers_18)
			  .body(RawFileBody("./resources/registry/share/0018_request.dat"))
      )
    .exec(http("upload_17")
			  .post("/share/upload/${sessionToken}")
			  .headers(headers_19)
			  .body(RawFileBody("./resources/registry/share/0019_request.dat"))
      )
    .exec(http("upload_18")
			  .post("/share/upload/${sessionToken}")
			  .headers(headers_20)
			  .body(RawFileBody("./resources/registry/share/0020_request.dat"))
      )
    .exec(http("upload_19")
			  .post("/share/upload/${sessionToken}")
			  .headers(headers_21)
			  .body(RawFileBody("./resources/registry/share/0021_request.dat"))
      )
    .exec(http("upload_20")
			  .post("/share/upload/${sessionToken}")
			  .headers(headers_22)
			  .body(RawFileBody("./resources/registry/share/0022_request.dat"))
      )
    .exec(http("upload_21")
			  .post("/share/upload/${sessionToken}")
			  .headers(headers_23)
			  .body(RawFileBody("./resources/registry/share/0023_request.dat"))
      )
    .exec(http("upload_22")
			  .post("/share/upload/${sessionToken}")
			  .headers(headers_25)
			  .body(RawFileBody("./resources/registry/share/0025_request.dat"))
      )

    .exec(http("commit")
			  .post("/share/commit/${sessionToken}")
			  .headers(sessionHeaders))
            
	setUp(scn.inject(rampUsers(30).during(60.seconds)).protocols(httpProtocol))
}