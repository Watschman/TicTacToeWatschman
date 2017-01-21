package main.java.com.watschman.TTT.utility;

/**
 * Created by Watschman on 21.01.2017.
 */
public class PlayerO extends Player{
    char playerChar = 'O';
    String playerName = "PlayerO";
    public PlayerO(){
        super();
    }

    @Override
    public char getPlayerChar() {
        return this.playerChar;
    }

    @Override
    public String getPlayerName() {
        return this.playerName;
    }
}
