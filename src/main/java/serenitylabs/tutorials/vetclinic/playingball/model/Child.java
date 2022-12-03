package serenitylabs.tutorials.vetclinic.playingball.model;

public class Child {

    public void goPlay(Game game) {
        Player gameToPlay = gameCalled(game);
        gameToPlay.play();
    }

    private Player gameCalled(Game game) {
        Player player;
        switch (game) {
            case Football:
                player = new PlayFootball();
                break;
            case Tennis:
                player = new PlayTennis();
                break;
            case Cricket:
                player = new PlayCricket();
                break;
            case Handball:
                player = new PlayHandball();
                break;
            case Hockey:
                player = new PlayHockey();
                break;
            default:
                throw new UnknownGameException("Unknown game: " + game);
        }
        return player;
    }
}
