package pl.com.siemienczuk.pubghelperapi.proxyserver.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.com.siemienczuk.pubghelperapi.proxyserver.model.Player;
import pl.com.siemienczuk.pubghelperapi.pubgapiclient.model.PubgPlayer;
import pl.com.siemienczuk.pubghelperapi.pubgapiclient.service.BasePubgClient;

@RestController
@RequestMapping({"/api/{shard}/player"})
public class PlayerDataController {
    @GetMapping(path={"/{name}"})
    public ResponseEntity<Player> getPlayer(
            @PathVariable("name") String playerName,
            @PathVariable("shard") String shardId){
        PubgPlayer pubgPlayer = BasePubgClient.getSinglePlayerData(playerName, shardId);
        if(pubgPlayer == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        Player responsePlayer = new Player(pubgPlayer);

        return new ResponseEntity<>(responsePlayer, HttpStatus.OK);
    }
}
