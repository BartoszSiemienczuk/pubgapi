package pl.com.siemienczuk.pubghelperapi.pubgapiclient.service.utils;

import pl.com.siemienczuk.pubghelperapi.pubgapiclient.model.constants.PubgApiConstants;

public class PubgApiUrlUtil {

    public static String getSinglePlayerUrl(String playerName, String shardId){
        String url = PubgApiConstants.API_URL_SINGLE_PLAYER_BY_NAME + playerName;
        url = insertShardId(url, shardId);

        return url;
    }


    public static String getSingleMatchUrl(String matchId, String shardId){
        String url = PubgApiConstants.API_URL_MATCH + matchId;
        url = insertShardId(url, shardId);

        return url;
    }

    private static String insertShardId(String sourceUrl, String shardId){
        return sourceUrl.replace(PubgApiConstants.REGION_PLACEHOLDER, shardId);
    }
}
