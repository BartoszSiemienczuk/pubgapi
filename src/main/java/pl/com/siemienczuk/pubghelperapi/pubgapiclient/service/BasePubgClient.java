package pl.com.siemienczuk.pubghelperapi.pubgapiclient.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;
import pl.com.siemienczuk.pubghelperapi.pubgapiclient.model.PubgMatch;
import pl.com.siemienczuk.pubghelperapi.pubgapiclient.model.constants.PubgApiConstants;
import pl.com.siemienczuk.pubghelperapi.pubgapiclient.model.PubgPlayer;
import pl.com.siemienczuk.pubghelperapi.pubgapiclient.model.responses.PubgMatchResponse;
import pl.com.siemienczuk.pubghelperapi.pubgapiclient.model.responses.PubgPlayersResponse;
import pl.com.siemienczuk.pubghelperapi.pubgapiclient.service.interceptors.PubgApiHeaderInterceptor;

import java.util.Collections;

public class BasePubgClient {
    private static final Logger log = LoggerFactory.getLogger(BasePubgClient.class);


    public static RestTemplate getBasicRestTemplate(){
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.setInterceptors(Collections.singletonList(new PubgApiHeaderInterceptor()));

        return restTemplate;
    }

    public static PubgPlayer getSinglePlayerData(String playerName){
        RestTemplate rest = getBasicRestTemplate();
        try {
            PubgPlayersResponse resp = rest.getForObject(PubgApiConstants.API_URL_SINGLE_PLAYER_BY_NAME + playerName, PubgPlayersResponse.class);
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

    public static PubgMatch getSingleMatchData(String matchId){

        RestTemplate rest = getBasicRestTemplate();
        try {
            PubgMatchResponse resp = rest.getForObject(PubgApiConstants.API_URL_MATCH + matchId, PubgMatchResponse.class);
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



}
