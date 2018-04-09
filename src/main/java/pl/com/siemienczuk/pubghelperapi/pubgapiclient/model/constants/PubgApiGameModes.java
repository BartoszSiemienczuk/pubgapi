package pl.com.siemienczuk.pubghelperapi.pubgapiclient.model.constants;

public enum PubgApiGameModes {
    SOLO_FPP("Solo FPP", "solo-fpp"),
    SOLO_TPP("Solo TPP", "solo"),
    DUO_FPP("Duos FPP", "duo-fpp"),
    DUO_TPP("Duos TPP", "duo"),
    SQUAD_FPP("Squads FPP", "squad-fpp"),
    SQUAD_TPP("Squads TPP", "squad"),
    EVENT("Special event", "");

    private String name;
    private String apiCode;

    PubgApiGameModes(String name, String apiCode) {
        this.name = name;
        this.apiCode = apiCode;
    }

    public String getName() {
        return name;
    }

    public String getApiCode() {
        return apiCode;
    }

    public static PubgApiGameModes getGameModeByCode(String gamemode_code){
        for(PubgApiGameModes gamemode: PubgApiGameModes.values()){
            if(gamemode.getApiCode().equals(gamemode_code)){
                return gamemode;
            }
        }

        return PubgApiGameModes.EVENT;
    }
}
