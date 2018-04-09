package pl.com.siemienczuk.pubghelperapi.pubgapiclient.model.constants;

public class PubgApiConstants {
    public static final String DEFAULT_REGION = "pc-eu";
    public static final String REGION_PLACEHOLDER = "{shard}";

    public static final String BASE_API_URL = "https://api.playbattlegrounds.com/shards/"+ REGION_PLACEHOLDER +"/";
    public static final String API_URL_PLAYERS = BASE_API_URL + "players";
    public static final String API_URL_SINGLE_PLAYER_BY_NAME = API_URL_PLAYERS + "?filter[playerNames]=";

    public static final String API_URL_MATCH = BASE_API_URL + "matches/";

}
