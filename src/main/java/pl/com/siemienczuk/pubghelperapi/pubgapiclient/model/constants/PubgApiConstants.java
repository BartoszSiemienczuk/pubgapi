package pl.com.siemienczuk.pubghelperapi.pubgapiclient.model.constants;

public abstract class PubgApiConstants {
    public static final String REGION = PubgApiRegionShards.PC_EUROPE;
    public static final String API_KEY = "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJqdGkiOiI3NDcxOWRjMC0xOTYwLTAxMzYtNzA1My01NWRjYjUxYTg4ZWIiLCJpc3MiOiJnYW1lbG9ja2VyIiwiaWF0IjoxNTIyNzU1MDgwLCJwdWIiOiJibHVlaG9sZSIsInRpdGxlIjoicHViZyIsImFwcCI6InB1YmdoZWxwZXIiLCJzY29wZSI6ImNvbW11bml0eSIsImxpbWl0IjoxMH0.0FFoR7KcxThOqj32L4_IOJQnHqIURDaaJ1jwCMX8gfo";

    public static final String BASE_API_URL = "https://api.playbattlegrounds.com/shards/"+REGION+"/";
    public static final String API_URL_PLAYERS = BASE_API_URL + "players";
    public static final String API_URL_SINGLE_PLAYER_BY_NAME = API_URL_PLAYERS + "?filter[playerNames]=";

    public static final String API_URL_MATCH = BASE_API_URL + "matches/";
}
