package pl.com.siemienczuk.pubghelperapi.pubgapiclient.service.interceptors;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpRequest;
import org.springframework.http.MediaType;
import org.springframework.http.client.ClientHttpRequestExecution;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.http.client.ClientHttpResponse;
import pl.com.siemienczuk.pubghelperapi.pubgapiclient.model.constants.PubgApiConstants;

import java.io.IOException;
import java.util.Collections;

public class PubgApiHeaderInterceptor implements ClientHttpRequestInterceptor {
    private String API_KEY = "";

    public PubgApiHeaderInterceptor(String api_key) {
        this.API_KEY = api_key;
    }

    @Override
    public ClientHttpResponse intercept(HttpRequest httpRequest, byte[] bytes, ClientHttpRequestExecution clientHttpRequestExecution) throws IOException {
        httpRequest.getHeaders().setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
        System.out.println("API KEY = " + API_KEY);
        httpRequest.getHeaders().add("Authorization", "Bearer " + API_KEY);

        return clientHttpRequestExecution.execute(httpRequest, bytes);
    }
}
