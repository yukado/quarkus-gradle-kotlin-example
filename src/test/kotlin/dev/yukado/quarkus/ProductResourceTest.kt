package dev.yukado.quarkus

import io.quarkus.test.junit.QuarkusTest
import io.restassured.RestAssured.given
import org.hamcrest.CoreMatchers.equalTo
import org.junit.jupiter.api.Test

@QuarkusTest
class ProductResourceTest {

    @Test
    fun testProductEndpoint() {
        given()
            .`when`().get("/products")
            .then()
            .statusCode(200)
            .body("[0].name", equalTo("Demo Produkt"))
    }
}
