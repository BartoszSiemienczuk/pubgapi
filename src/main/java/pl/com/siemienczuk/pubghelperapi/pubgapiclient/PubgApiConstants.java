package pl.com.siemienczuk.pubghelperapi.pubgapiclient;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public abstract class PubgApiConstants {
    public static final String REGION = "pc-eu";
    @Value("${pubg-api-key")
    public static String API_KEY;

    public static final String BASE_API_URL = "https://api.playbattlegrounds.com/shards/"+REGION+"/";
    public static final String API_URL_PLAYERS = BASE_API_URL + "players";
    public static final String API_URL_SINGLE_PLAYER_BY_NAME = API_URL_PLAYERS + "?filter[playerNames]=";
}
