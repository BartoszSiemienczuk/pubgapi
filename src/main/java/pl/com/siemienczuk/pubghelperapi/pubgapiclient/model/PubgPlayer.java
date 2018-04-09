package pl.com.siemienczuk.pubghelperapi.pubgapiclient.model;

import lombok.Data;
import lombok.ToString;

import java.util.Map;

@Data
@ToString
public class PubgPlayer {
    private String id;
    private String type;
    private Map<String, String> attributes;
    private PubgRelationships relationships;


}
