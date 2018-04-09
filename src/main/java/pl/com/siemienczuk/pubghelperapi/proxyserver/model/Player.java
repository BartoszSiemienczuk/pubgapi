package pl.com.siemienczuk.pubghelperapi.proxyserver.model;

import com.fasterxml.jackson.databind.ser.Serializers;
import lombok.Data;
import lombok.ToString;
import pl.com.siemienczuk.pubghelperapi.pubgapiclient.model.PubgId;
import pl.com.siemienczuk.pubghelperapi.pubgapiclient.model.PubgMatch;
import pl.com.siemienczuk.pubghelperapi.pubgapiclient.model.PubgPlayer;
import pl.com.siemienczuk.pubghelperapi.pubgapiclient.service.BasePubgClient;

import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
@ToString
public class Player {
    private String id;
    private String name;
    private Date createdAt;
    private Date updatedAt;
    private String shardId;
    private List<String> matchIds;
    private List<Match> matches;

    public Player(PubgPlayer sourceData){
        this.id = sourceData.getId();
        this.name = sourceData.getAttributes().getOrDefault("name","");
        this.createdAt = Date.from(Instant.parse(sourceData.getAttributes().get("createdAt")));
        this.updatedAt = Date.from(Instant.parse(sourceData.getAttributes().get("updatedAt")));
        this.shardId = sourceData.getAttributes().getOrDefault("shardId", "");

        this.matchIds = new ArrayList<>();
        this.matches = new ArrayList<>();
        PubgId[] matchesData = sourceData.getRelationships().getMatches().getData();
        for (PubgId aMatchesData : matchesData) {
            this.matchIds.add(aMatchesData.getId());
            PubgMatch matchObject = BasePubgClient.getSingleMatchData(aMatchesData.getId());
            if(matchObject!=null){
                this.matches.add(
                    new Match(matchObject)
                );
            }
        }
    }
}
