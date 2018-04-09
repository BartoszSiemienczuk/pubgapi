package pl.com.siemienczuk.pubghelperapi.pubgapiclient.model;

import com.fasterxml.jackson.databind.JsonNode;
import lombok.Data;

import java.util.Map;

/**
 * Wrapper for PUBG API "included" JSON objects
 * eg. participants and rosters in a match.
 * They all have the same basic structure, just different attributes.
 */
@Data
public class PubgIncludedEntity {
    private String type;
    private String id;
    Map<String, JsonNode> attributes;

    public String getAttribute(String attributeKey){
        if(this.attributes.containsKey(attributeKey) == false){
            return "";
        }

        return this.attributes.get(attributeKey).textValue();

    }
}
