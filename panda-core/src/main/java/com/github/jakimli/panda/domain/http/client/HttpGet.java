package com.github.jakimli.panda.domain.http.client;

import com.github.jakimli.panda.domain.http.HttpContext;

import javax.ws.rs.client.SyncInvoker;

public class HttpGet extends AbstractHttpClient implements HttpClient {

    @Override
    public void send(HttpContext context) {
        request(context, SyncInvoker::get);
    }
}