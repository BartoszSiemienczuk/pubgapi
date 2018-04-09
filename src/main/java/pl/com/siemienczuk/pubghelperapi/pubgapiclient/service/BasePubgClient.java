package pl.com.siemienczuk.pubghelperapi.pubgapiclient.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;
import pl.com.siemienczuk.pubghelperapi.pubgapiclient.model.PubgMatch;
import pl.com.siemienczuk.pubghelperapi.pubgapiclient.model.constants.PubgApiConstants;
import pl.com.siemienczuk.pubghelperapi.pubgapiclient.model.PubgPlayer;
import pl.com.siemienczuk.pubghelperapi.pubgapiclient.model.responses.PubgMatchResponse;
import pl.com.siemienczuk.pubghelperapi.pubgapiclient.model.responses.PubgPlayersResponse;
import pl.com.siemienczuk.pubghelperapi.pubgapiclient.service.interceptors.PubgApiHeaderInterceptor;
import pl.com.siemienczuk.pubghelperapi.pubgapiclient.service.utils.PubgApiUrlUtil;

import java.util.Collections;

@Service
public class BasePubgClient {
    private static final Logger log = LoggerFactory.getLogger(BasePubgClient.class);
    private  static String API_KEY;

    private static RestTemplate getBasicRestTemplate(){
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.setInterceptors(Collections.singletonList(new PubgApiHeaderInterceptor(API_KEY)));

        return restTemplate;
    }

    public static PubgPlayer getSinglePlayerData(String playerName, String shardId){
        RestTemplate rest = getBasicRestTemplate();
        try {
            PubgPlayersResponse resp = rest.getForObject(PubgApiUrlUtil.getSinglePlayerUrl(playerName, shardId), PubgPlayersResponse.class);
            if(resp.getData().length > 0){
                return resp.getData()[0];
            }
        } catch (HttpClientErrorException e) {
            if(e.getStatusCode() != HttpStatus.NOT_FOUND){
                throw e;
            }
        }

        //Returns null if no player found.
        return null;
    }

    public static PubgMatch getSingleMatchData(String matchId, String shardId){

        RestTemplate rest = getBasicRestTemplate();
        try {
            PubgMatchResponse resp = rest.getForObject(PubgApiUrlUtil.getSingleMatchUrl(matchId, shardId), PubgMatchResponse.class);
            if(resp.getData()!=null){
                //copy included from base response to match entity
                resp.getData().setIncluded(resp.getIncluded());
                return resp.getData();
            }
        } catch (HttpClientErrorException e) {
            if(e.getStatusCode() != HttpStatus.NOT_FOUND){
                throw e;
            }
        }

        //Returns null if no match found.
        return null;
    }

    @Value("${pubg-api-key}")
    public void setAPI_KEY(String api_key){
        API_KEY = api_key;
    }

}
