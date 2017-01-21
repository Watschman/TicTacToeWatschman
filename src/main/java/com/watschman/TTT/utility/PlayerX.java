package main.java.com.watschman.TTT.utility;

/**
 * Created by Watschman on 21.01.2017.
 */
public class PlayerX extends Player{
    char playerChar = 'X';
    String playerName = "PlayerX";
    public PlayerX(){
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
