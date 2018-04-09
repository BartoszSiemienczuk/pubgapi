package pl.com.siemienczuk.pubghelperapi.proxyserver.model;

import lombok.Data;
import lombok.ToString;
import pl.com.siemienczuk.pubghelperapi.pubgapiclient.model.PubgMatch;
import pl.com.siemienczuk.pubghelperapi.pubgapiclient.model.constants.PubgApiGameModes;

import java.util.Date;

@Data
@ToString
public class Match {
    private String id;
    private String type;
    private PubgApiGameModes gameMode;
    private int duration;
    private Date endTime;
    private String shardId;
    private String telemetryUrl;

    public Match(PubgMatch pubgMatch){
        this.id = pubgMatch.getId();
        this.type = pubgMatch.getType();
        this.gameMode = pubgMatch.getGameMode();
        this.duration = pubgMatch.getDuration();
        this.shardId = pubgMatch.getShardId();
        this.endTime = pubgMatch.getEndingTime();
        this.telemetryUrl = pubgMatch.getTelemetryDataUrl();
    }
}
