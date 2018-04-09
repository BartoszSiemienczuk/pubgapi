package pl.com.siemienczuk.pubghelperapi.pubgapiclient.model.responses;

import lombok.Data;
import pl.com.siemienczuk.pubghelperapi.pubgapiclient.model.PubgPlayer;

@Data
public class PubgPlayersResponse extends BasePubgJsonResponse{
    private PubgPlayer[] data;

    @Override
    public String toString() {
        return "PubgPlayersResponse{" +
                "data=" + data +
                '}';
    }
}
