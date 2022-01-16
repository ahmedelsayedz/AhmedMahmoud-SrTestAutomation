package restAssured;

import io.restassured.response.Response;
import org.json.JSONArray;
import org.testng.Assert;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.given;

public class TrellaApiTest {
    String url = "https://case-api.trella.app";
    String endPoint = "/marketplace";

    @Test
    public void testViewListOfAvailableShipments(){
        /**
         * [TRELLA-1] As a carrier, I should be able to view a list of available shipments
         * with all their details to be able to bid on them
         **/

        Response res = given().
            header("Authorization", "ahmed.m.elsayed82@gmail.com").
        when().
            get(url + endPoint).
        then().
            extract().
            response();

        JSONArray jsonArray = new JSONArray(res.body().asString());
        Assert.assertEquals(res.statusCode(), 200);
        Assert.assertEquals(res.contentType(), "application/json; charset=utf-8");
        Assert.assertEquals(jsonArray.length(), 7);
        for (int i = 0; i < jsonArray.length(); i++) {
            Assert.assertEquals(jsonArray.getJSONObject(i).length(), 6);
        }
    }

    @Test
    public void testFilterShipmentsLngLat(){
        /**
         * [TRELLA-2] As a carrier, I should be able to filter the shipments using
         * longitude and latitude to view the shipments close to my location
         * */

        Response res = given().
            header("Authorization", "ahmed.m.elsayed82@gmail.com").
            param("lng", "30").
            param("lat", "30").
        when().
            get(url + endPoint).
        then().extract().response();

        JSONArray jsonArray = new JSONArray(res.body().asString());
        Assert.assertEquals(res.statusCode(), 200);
        Assert.assertEquals(res.contentType(), "application/json; charset=utf-8");
        Assert.assertEquals(jsonArray.length(), 3);
        for (int i = 0; i < jsonArray.length(); i++) {
            Assert.assertEquals(jsonArray.getJSONObject(i).length(), 6);
        }
    }
}


