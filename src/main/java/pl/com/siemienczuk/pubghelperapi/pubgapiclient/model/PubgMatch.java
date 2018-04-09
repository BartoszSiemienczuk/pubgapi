package pl.com.siemienczuk.pubghelperapi.pubgapiclient.model;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import lombok.Data;
import lombok.ToString;
import pl.com.siemienczuk.pubghelperapi.pubgapiclient.model.constants.PubgApiAttributesKeys;
import pl.com.siemienczuk.pubghelperapi.pubgapiclient.model.constants.PubgApiGameModes;

import java.time.Instant;
import java.util.Arrays;
import java.util.Date;
import java.util.Map;
import java.util.Optional;

@Data
@ToString
public class PubgMatch {
    private String id;
    private String type;
    private Map<String, String> attributes;
    private PubgRelationships relationships;
    private PubgIncludedEntity[] included;

    public Date getEndingTime(){
        if(attributes.containsKey(PubgApiAttributesKeys.CREATED_AT)){
            String created_at = this.attributes.get(PubgApiAttributesKeys.CREATED_AT);
            return Date.from(Instant.parse(created_at));
        } else {
            return new Date();
        }
    }

    public int getDuration(){
        return Integer.parseInt(attributes.getOrDefault(PubgApiAttributesKeys.MATCH_DURATION, "0"));
    }

    public PubgApiGameModes getGameMode(){
        return PubgApiGameModes.getGameModeByCode(
                attributes.getOrDefault(PubgApiAttributesKeys.MATCH_GAMEMODE, "")
        );
    }

    public String getShardId(){
        return attributes.getOrDefault(PubgApiAttributesKeys.SHARD_ID, "");
    }

    public String getTelemetryDataAssetId(){
        //Telemetry is the only "assets" slot in the match relationships object.
        return relationships.getAssets().getData()[0].getId();
    }

    /**
     * Searches included objects for telemetry data asset and returns telemetry URL for this match.
     * @return String containing telemetry data URL
     */
    public String getTelemetryDataUrl(){
        Optional<PubgIncludedEntity> telemetryAsset = Arrays.stream(this.getIncluded()).filter(entity -> entity.getType().equals("asset")).findFirst();

        if(telemetryAsset.isPresent()){
            return telemetryAsset.get().getAttribute("URL");
        } else {
            return "";
        }
    }
}
