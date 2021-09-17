package com.maxsch.data.di

import android.content.Context
import android.content.SharedPreferences
import android.util.Log
import com.apollographql.apollo.ApolloClient
import com.apollographql.apollo.Logger
import com.maxsch.data.datasource.AuthTokenDataSource
import com.maxsch.data.datasource.AuthTokenDataSourceImpl
import com.maxsch.data.interceptor.AuthorizationInterceptor
import com.maxsch.data.repository.AuthTokenRepositoryImpl
import com.maxsch.data.repository.LaunchRepositoryImpl
import com.maxsch.data.repository.LoginRepositoryImpl
import com.maxsch.domain.repository.AuthTokenRepository
import com.maxsch.domain.repository.LaunchRepository
import com.maxsch.domain.repository.LoginRepository
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

private val SHARED_PREFS_NAME = "shared_prefs"

val dataModule = module {
//    factory(qualifier = named("MockInterceptor")) {
//        GqlMockInterceptor()
//    }

    factory<Interceptor> {
        AuthorizationInterceptor(get())
    }

    factory {
        OkHttpClient.Builder()
            .addInterceptor(HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))
            .addInterceptor(get())
            .build()
    }

    single<SharedPreferences> {
        androidContext().getSharedPreferences(SHARED_PREFS_NAME, Context.MODE_PRIVATE)
    }

    single<AuthTokenDataSource> {
        AuthTokenDataSourceImpl(get())
    }

    single {
        ApolloClient.builder()
            .logger(object : Logger {
                override fun log(priority: Int, message: String, t: Throwable?, vararg args: Any) {
                    Log.e("apollo log", "$message ${args.map { it.toString() }}")
                }
            })
            .serverUrl("https://apollo-fullstack-tutorial.herokuapp.com")
            .okHttpClient(get())
            .build()
    }

    single<LaunchRepository> {
        LaunchRepositoryImpl(get())
    }

    single<AuthTokenRepository> {
        AuthTokenRepositoryImpl(get())
    }

    single<LoginRepository> {
        LoginRepositoryImpl(get())
    }
}