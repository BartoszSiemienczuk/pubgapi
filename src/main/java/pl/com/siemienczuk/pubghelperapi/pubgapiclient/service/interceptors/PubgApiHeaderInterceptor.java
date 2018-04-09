package pl.com.siemienczuk.pubghelperapi.pubgapiclient.service.interceptors;

import org.springframework.http.HttpRequest;
import org.springframework.http.MediaType;
import org.springframework.http.client.ClientHttpRequestExecution;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.http.client.ClientHttpResponse;
import pl.com.siemienczuk.pubghelperapi.pubgapiclient.model.constants.PubgApiConstants;

import java.io.IOException;
import java.util.Collections;

public class PubgApiHeaderInterceptor implements ClientHttpRequestInterceptor {
    @Override
    public ClientHttpResponse intercept(HttpRequest httpRequest, byte[] bytes, ClientHttpRequestExecution clientHttpRequestExecution) throws IOException {
        httpRequest.getHeaders().setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
        httpRequest.getHeaders().add("Authorization", "Bearer " + PubgApiConstants.API_KEY);

        return clientHttpRequestExecution.execute(httpRequest, bytes);
    }
}
