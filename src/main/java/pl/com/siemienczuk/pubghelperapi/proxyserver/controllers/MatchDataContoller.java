package pl.com.siemienczuk.pubghelperapi.proxyserver.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.com.siemienczuk.pubghelperapi.proxyserver.model.Match;
import pl.com.siemienczuk.pubghelperapi.proxyserver.model.Player;
import pl.com.siemienczuk.pubghelperapi.pubgapiclient.model.PubgMatch;
import pl.com.siemienczuk.pubghelperapi.pubgapiclient.model.PubgPlayer;
import pl.com.siemienczuk.pubghelperapi.pubgapiclient.service.BasePubgClient;

@RestController
@RequestMapping({"/api/match"})
public class MatchDataContoller {

    @GetMapping(path={"/{id}"})
    public ResponseEntity<Match> getMatch(@PathVariable("id") String matchId){
        PubgMatch match = BasePubgClient.getSingleMatchData(matchId);
        if(match == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }


        Match responseMatch = new Match(match);

        return new ResponseEntity<>(responseMatch, HttpStatus.OK);
    }
}
