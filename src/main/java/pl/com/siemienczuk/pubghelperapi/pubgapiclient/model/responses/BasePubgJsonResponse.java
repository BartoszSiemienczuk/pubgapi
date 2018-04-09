package pl.com.siemienczuk.pubghelperapi.pubgapiclient.model.responses;

import com.fasterxml.jackson.databind.node.ObjectNode;
import lombok.Data;

import java.util.Map;

@Data
public class BasePubgJsonResponse {
    private Map<String, String> links;
    private ObjectNode meta;
}
