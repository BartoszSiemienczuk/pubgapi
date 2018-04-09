package pl.com.siemienczuk.pubghelperapi.pubgapiclient.model;

import lombok.Data;

/**
 * Wrapper for PUBG API "relationships" JSON object.
 * Different collections may or may not be filled depending on the main object in question.
 */
@Data
public class PubgRelationships {
    private PubgIdCollection matches;
    private PubgIdCollection assets;
    private PubgIdCollection rosters;
    private PubgIdCollection rounds;
    private PubgIdCollection spectators;
}
