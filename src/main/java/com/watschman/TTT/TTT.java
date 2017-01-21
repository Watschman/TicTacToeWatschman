package main.java.com.watschman.TTT;

import main.java.com.watschman.TTT.utility.LogHelper;
import main.java.com.watschman.TTT.utility.Player;
import main.java.com.watschman.TTT.utility.PlayerO;
import main.java.com.watschman.TTT.utility.PlayerX;

import java.awt.*;
import java.io.Console;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.Scanner;

/**
 * Created by Watschman on 21.01.2017.
 */
public class TTT {
    public static char a = ' ';
    public static char b = ' ';
    public static char c = ' ';
    public static char d = ' ';
    public static char e = ' ';
    public static char f = ' ';
    public static char g = ' ';
    public static char h = ' ';
    public static char i = ' ';
    public static boolean win = false;
    public static int turn = 0;
    public static Scanner scanner = new Scanner(System.in);

    TTT(){
        PlayerX playerX = new PlayerX();
        PlayerO playerO = new PlayerO();
        LogHelper.log(" Original build in Python by Rikirie");
        LogHelper.log(" Rewrote in Java by Watschman");
        LogHelper.log(" ");
        LogHelper.log(" Players may choose cells a,b,c,d,e,f,g,h,i in order to choose where to place their piece.");
        LogHelper.log(" Starting with a on the first cell on the left");
        LogHelper.log(" ");
        draw();
        while (!win){
            if(turn % 2 == 0){
                turnPlayer(playerX);
                decideWin(playerX);
            } else {
                turnPlayer(playerO);
                decideWin(playerO);
            }
            if (turn == 9){
                LogHelper.log(" Draw - No Winner");
                win = true;
            }
            turn++;
        }
    }
    void draw(){
        drawLine(a, b, c);
        drawLine();
        drawLine(d, e, f);
        drawLine();
        drawLine(g, h, i);
    }
    void drawLine(char one, char two, char three){
        LogHelper.log(" " + one + " | " + two + " | " + three);
    }
    void drawLine(){
        LogHelper.log(" - + - + -");
    }
    void decideWin(Player player){
        if(doesWin(player.getPlayerChar())) {
            LogHelper.log(" " + player.getPlayerName() + " wins!");
            win = true;
        }
    }
    void turnPlayer(Player player){
        LogHelper.log(" " + player.getPlayerName() + ", it is your turn");
        System.out.print(" " + player.getPlayerName() + " selects cell: ");
        char choice = scanner.next().charAt(0);
        switch (choice){
            case 'a':
                a = player.getPlayerChar();
                break;
            case 'b':
                b = player.getPlayerChar();
                break;
            case 'c':
                c = player.getPlayerChar();
                break;
            case 'd':
                d = player.getPlayerChar();
                break;
            case 'e':
                e = player.getPlayerChar();
                break;
            case 'f':
                f = player.getPlayerChar();
                break;
            case 'g':
                g = player.getPlayerChar();
                break;
            case 'h':
                h = player.getPlayerChar();
                break;
            case 'i':
                i = player.getPlayerChar();
                break;
            default:
                turn--;
                break;
        }
        draw();
    }
    boolean doesWin(char winChar) {
        return a == winChar && b == winChar && c == winChar || d == winChar && e == winChar && f == winChar || g == winChar && h == winChar && i == winChar || a == winChar && d == winChar && g == winChar || b == winChar && e == winChar && h == winChar || c == winChar && f == winChar && i == winChar || a == winChar && e == winChar && i == winChar || c == winChar && e == winChar && g == winChar;
    }
    public static void main(String[] args)throws IOException, InterruptedException, URISyntaxException {
    Console console = System.console();
        if(console == null && !GraphicsEnvironment.isHeadless()){
            String filename = TTT.class.getProtectionDomain().getCodeSource().getLocation().toString().substring(6);
            Runtime.getRuntime().exec(new String[]{"cmd","/c","start","cmd","/k","java -jar \"" + filename + "\""});
        }else{
            TTT.run(new String[0]);
        }
    }
    private static void run(String[] strings) {
        new TTT();
    }
}
