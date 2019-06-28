package src;
import javax.swing.*;




public class Chess {
    static String chessBoard[][]={
        {"r","n","b","q","k","b","n","r"},
        {"p","p","p","p","p","p","p","p"},
        {" "," "," "," "," "," ","P"," "},
        {" "," "," "," "," "," "," "," "},
        {" "," "," "," "," "," "," "," "},
        {" "," "," "," "," "," "," "," "},
        {"P","P","P","P","P","P","P","P"},
        {"R","N","B","Q","K","B","N","R"}};
    public static void main (String[] args) {
        JFrame window = new JFrame("Title");
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        UserInterface ui = new UserInterface();
        window.add(ui);
        window.setSize(500, 500);
        window.setVisible(true);
    }
}