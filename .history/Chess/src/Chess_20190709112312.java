package src;
// import javax.swing.*;




public class Chess {
    static String chessBoard[][]={
        {"r","n","b","q","k","b","n","r"},
        {"p","p","p","p","p","p","p","p"},
        {" "," "," "," "," "," "," "," "},
        {" "," "," "," "," "," "," "," "},
        {" "," "," "," ","K"," "," "," "},
        {" "," "," "," "," "," "," "," "},
        {"P","P","P","P","P","P","P","P"},
        {"R","N","B","Q"," ","B","N","R"}};
    static int kingPositionW, kingPositionB;
    public static void main (String[] args) {
        // JFrame window = new JFrame("Chess Tutorial");
        // window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // UserInterface ui = new UserInterface();
        // window.add(ui);
        // window.setSize(500, 500);
        // window.setVisible(true);
        System.out.println(possibleMoves());
    }
    public static String possibleMoves() {
        String list = "";
        for (int i = 0; i < 64; i++) {
            switch (chessBoard[i/8][i%8]) {
                case "P": list+=possibleP(i);
                    break;
                case "N":
                    break;
                case "B":
                    break;
                case "R":
                    break;
                case "Q":
                    break;
                case "K":
                    break;
            }
        }
        return list; //xy1,xy2, capturedpiece
    }
    public static String possibleP(int i) {
        String list = "";
        return list;
    }
    public static String possibleN(int i) {
        String list = "";
        return list;
    }
    public static String possibleB(int i) {
        String list = "";
        return list;
    }
    public static String possibleR(int i) {
        String list = "";
        return list;
    }
    public static String possibleQ(int i) {
        String list = "";
        return list;
    }
    public static String possibleK(int i) {
        String list = "", oldPiece;
        int r = i/8, c = i%8;
        for (int j = 0; j < 9; j++) {
            if (j!=4){
                try{
                    if (Character.isLowerCase(chessBoard[r-1+j/3][c-1+j%3].charAt(0)) || " ".equals(chessBoard[r-1+j/3][c-1+j%3])) {
                        oldPiece = chessBoard[r-1+j/3][c-1+j%3];
                        chessBoard[r][c] = " ";
                        chessBoard[r-1+j/3][c-1+j%3] = "K";
                        int kingTemp = kingPositionW;
                        kingPositionW = i+(j/3)*8+j%3-9;
                        if (kingSafe()) {
                            list = list+r+c+(r-1+j/3)+(c-1+j%3)+oldPiece;
                        }
                        chessBoard[r][c] = "K";
                        chessBoard[r-1+j/3][c-1+j%3] = oldPiece;
                        kingPositionW = kingTemp;
                    }
                } catch (Exception e) {}
            }
        }
        return list;
    }
    public static boolean kingSafe(){
        return true;
    }
}