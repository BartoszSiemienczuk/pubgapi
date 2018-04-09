package pl.com.siemienczuk.pubghelperapi.pubgapiclient.model.responses;

import lombok.Data;
import lombok.ToString;
import pl.com.siemienczuk.pubghelperapi.pubgapiclient.model.PubgIncludedEntity;
import pl.com.siemienczuk.pubghelperapi.pubgapiclient.model.PubgMatch;
import pl.com.siemienczuk.pubghelperapi.pubgapiclient.model.PubgPlayer;

@Data
@ToString
public class PubgMatchResponse extends BasePubgJsonResponse{
    private PubgMatch data;
    private PubgIncludedEntity[] included;
}
