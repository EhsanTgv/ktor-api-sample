package com.taghavi

import com.taghavi.dogs.Dog
import io.ktor.http.*
import io.ktor.server.testing.*
import org.junit.Test
import kotlin.test.assertEquals

class DogsRouteTest {

    @Test
    fun testGetAllDog() {
        withTestApplication({ module() }) {
            handleRequest(HttpMethod.Get, "/dogs").apply {
                assertEquals(
                    HttpStatusCode.NotFound,
                    response.status()
                )
            }
        }
    }

    @Test
    fun testAddDog() {
        withTestApplication({ module() }) {
            handleRequest(HttpMethod.Post, "/dogs") {
                addHeader(HttpHeaders.ContentType, ContentType.Application.Json.contentType)
                setBody(Dog("Dog1").toString())
            }.apply {
                assertEquals(
                    HttpStatusCode.Created,
                    response.status()
                )
            }
        }
    }

    @Test
    fun testGetSpecificDog() {
        withTestApplication({ module() }) {
            handleRequest(HttpMethod.Get, "/dogs").apply {
                assertEquals(
                    HttpStatusCode.NotFound,
                    response.status()
                )
            }
        }
    }
}