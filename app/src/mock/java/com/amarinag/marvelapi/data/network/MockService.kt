package com.amarinag.marvelapi.data.network

import com.amarinag.marvelapi.R
import com.amarinag.marvelapi.data.network.model.MarvelApiResponse
import com.amarinag.marvelapi.utils.AppResources
import com.google.gson.GsonBuilder
import dagger.hilt.android.scopes.ViewModelScoped
import javax.inject.Inject

@ViewModelScoped
class MockService @Inject constructor(private val appResources: AppResources) : MarvelApiService {
//    private val mockDispatcher: Dispatcher = object : Dispatcher() {
//        override fun dispatch(request: RecordedRequest): MockResponse {
//            return when (request.path) {
//                "characters" -> MockResponse()
//                    .setResponseCode(200)
//                    .setBody("Felipe")
//                "characters/{characterId}" -> MockResponse()
//                    .setResponseCode(200)
//                    .setBody(appResources.getRawFile(R.raw.get_by_id))
//                else -> MockResponse().setResponseCode(500)
//            }
//        }
//
//    }


    override suspend fun getAllCharacter(offset: Int): MarvelApiResponse {
//        Log.e("MockWebService", "Start")
//        val server = MockWebServer().apply {
//            this.dispatcher = mockDispatcher
//        }
//        try {
//            server.enqueue(
//                MockResponse()
//                    .setBody("Felipe")
//            )
//            server.start()
//            Log.e("MockWebService", "Enqueque")
//            val responseStr = appResources.getRawFile(R.raw.get_all)
//            Log.e("MockWebService", "response $responseStr")
//            val request = server.takeRequest(30, TimeUnit.SECONDS)
//            Log.e("MockWebService", "takeRequest")
//            Log.e("MockWebService", "request -> ${request?.body.toString()}")
//        } catch (ex: Exception) {
//            Log.e("MockWebService", "${ex.localizedMessage}", ex)
//
//        } finally {
//            server.shutdown()
//        }
        // TODO: 20220306 Fix MockWebServer problem
        return GsonBuilder().create()
            .fromJson(appResources.getRawFile(R.raw.get_all), MarvelApiResponse::class.java)
    }

    // TODO: 20220306 Fix MockWebServer problem
    override suspend fun getCharacterById(characterId: Long): MarvelApiResponse {
        return GsonBuilder().create()
            .fromJson(appResources.getRawFile(R.raw.get_by_id), MarvelApiResponse::class.java)
    }
}