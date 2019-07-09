package src;
// import javax.swing.*;




public class Chess {
    static String chessBoard[][]={
        {"r","n","b","q","k","b","n","r"},
        {"p","p","p","p","p","p","p","p"},
        {" "," "," "," "," "," "," "," "},
        {" "," "," "," "," "," "," "," "},
        {" "," "," "," "," "," "," "," "},
        {" "," "," "," "," "," "," "," "},
        {"P","P","P","P","P","P","P","P"},
        {"R","N","B","Q","K","B","N","R"}};
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
                case "N": list+=possibleN(i);
                    break;
                case "B": list+=possibleB(i);
                    break;
                case "R": list+=possibleR(i);
                    break;
                case "Q": list+=possibleQ(i);
                    break;
                case "K": list+=possibleK(i);
                    break;
            }
        }
        return list; //oldrow(0-7)oldcolumn(0-7), newrow(0-7)newcolumn(0-7), capturedpiece
    }
    public static String possibleP(int i) {
        String list = "";
        return list;
    }
    public static String possibleN(int i) {
        String list = "", oldPiece;
        int r = i/8, c = i%8;
        for (int j=-2; j<=2; j++) {
            for (int k=-2; k<=2; k++) {
                if (Math.abs(j*k)==2){
                    try {
                        if (" ".equals(chessBoard[r+j][c+k]) || Character.isLowerCase(chessBoard[r+j][c+k].charAt(0))) {
                            oldPiece=chessBoard[r+j][c+k];
                            chessBoard[r][c] = " ";
                            chessBoard[r+j][c+k] = "N";
                            if (kingSafe()) {
                                list = list+r+c+(r+j)+(c+k)+oldPiece;
                            }
                            chessBoard[r][c] = "N";
                            chessBoard[r+j][c+k]=oldPiece;
                        }
                    } catch (Exception e) {}
                }
            }
        }
        return list;
    }
    public static String possibleB(int i) {
        String list = "", oldPiece;
        int r = i/8, c = i%8;
        int temp = 1;
        for (int j=-1; j<=1; j++) {
            for (int k=-1; k<=1; k++) {
                if (Math.abs(j*k)==1) {
                    try {
                        while(" ".equals(chessBoard[r+temp*j][c+temp*k]))
                        {
                            oldPiece=chessBoard[r+temp*j][c+temp*k];
                            chessBoard[r][c] = " ";
                            chessBoard[r+temp*j][c+temp*k] = "B";
                            if (kingSafe()) {
                                list = list+r+c+(r+temp*j)+(c+temp*k)+oldPiece;
                            }
                            chessBoard[r][c] = "B";
                            chessBoard[r+temp*j][c+temp*k]=oldPiece;
                            temp++;
                        } 
                        if (Character.isLowerCase(chessBoard[r+temp*j][c+temp*k].charAt(0))) {
                            oldPiece=chessBoard[r+temp*j][c+temp*k];
                            chessBoard[r][c] = " ";
                            chessBoard[r+temp*j][c+temp*k] = "B";
                            if (kingSafe()) {
                                list = list+r+c+(r+temp*j)+(c+temp*k)+oldPiece;
                            }
                            chessBoard[r][c] = "B";
                            chessBoard[r+temp*j][c+temp*k]=oldPiece;
                        }
                    }catch (Exception e) {}
                    temp = 1;
                }
            }
        }
        return list;
    }
    public static String possibleR(int i) {
        String list = "", oldPiece;
        int r = i/8, c = i%8;
        int temp = 1;
        for (int j=-1; j<=1; j++) {
            for (int k=-1; k<=1; k++) {
                if (j*k == 0){
                    try {
                        while(" ".equals(chessBoard[r+temp*j][c+temp*k]))
                        {
                            oldPiece=chessBoard[r+temp*j][c+temp*k];
                            chessBoard[r][c] = " ";
                            chessBoard[r+temp*j][c+temp*k] = "R";
                            if (kingSafe()) {
                                list = list+r+c+(r+temp*j)+(c+temp*k)+oldPiece;
                            }
                            chessBoard[r][c] = "R";
                            chessBoard[r+temp*j][c+temp*k]=oldPiece;
                            temp++;
                        } 
                        if (Character.isLowerCase(chessBoard[r+temp*j][c+temp*k].charAt(0))) {
                            oldPiece=chessBoard[r+temp*j][c+temp*k];
                            chessBoard[r][c] = " ";
                            chessBoard[r+temp*j][c+temp*k] = "R";
                            if (kingSafe()) {
                                list = list+r+c+(r+temp*j)+(c+temp*k)+oldPiece;
                            }
                            chessBoard[r][c] = "R";
                            chessBoard[r+temp*j][c+temp*k]=oldPiece;
                        }
                    }catch (Exception e) {}
                    temp = 1;
                }
            }
        }
        return list;
    }
    public static String possibleQ(int i) {
        String list = "", oldPiece;
        int r = i/8, c = i%8;
        int temp = 1;
        for (int j=-1; j<=1; j++) {
            for (int k=-1; k<=1; k++) {
                try {
                    while(" ".equals(chessBoard[r+temp*j][c+temp*k]))
                    {
                        oldPiece=chessBoard[r+temp*j][c+temp*k];
                        chessBoard[r][c] = " ";
                        chessBoard[r+temp*j][c+temp*k] = "Q";
                        if (kingSafe()) {
                            list = list+r+c+(r+temp*j)+(c+temp*k)+oldPiece;
                        }
                        chessBoard[r][c] = "Q";
                        chessBoard[r+temp*j][c+temp*k]=oldPiece;
                        temp++;
                    } 
                    if (Character.isLowerCase(chessBoard[r+temp*j][c+temp*k].charAt(0))) {
                        oldPiece=chessBoard[r+temp*j][c+temp*k];
                        chessBoard[r][c] = " ";
                        chessBoard[r+temp*j][c+temp*k] = "Q";
                        if (kingSafe()) {
                            list = list+r+c+(r+temp*j)+(c+temp*k)+oldPiece;
                        }
                        chessBoard[r][c] = "Q";
                        chessBoard[r+temp*j][c+temp*k]=oldPiece;
                    }
                }catch (Exception e) {}
                temp = 1;
            }
        }
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
        //add castling later
        return list;
    }
    public static boolean kingSafe(){
        //bishop/queen
        int temp = 1;
        for (int j=-1; j<=1; j++) {
            for (int k=-1; k<=1; k++) {
                if (Math.abs(j*k)==1) {
                    try {
                        while(" ".equals(chessBoard[kingPositionW/8+temp*j][kingPositionW%8+temp*k])) 
                        {
                            temp++;
                        }
                        if ("b".equals(chessBoard[kingPositionW/8+temp*j][kingPositionW%8+temp*k]) ||
                                "q".equals(chessBoard[kingPositionW/8+temp*j][kingPositionW%8+temp*k])) {
                            return false;
                        }
                    } catch (Exception e) {}
                    temp=1;
                }
            }
        }
        //rook/queen
        for (int j=-1; j<=1; j++) {
            for (int k=-1; k<=1; k++) {
                if (j*k==0) {
                    try {
                        while(" ".equals(chessBoard[kingPositionW/8+temp*j][kingPositionW%8+temp*k])) 
                        {
                            temp++;
                        }
                        if ("r".equals(chessBoard[kingPositionW/8+temp*j][kingPositionW%8+temp*k]) ||
                                "q".equals(chessBoard[kingPositionW/8+temp*j][kingPositionW%8+temp*k])) {
                            return false;
                        }
                    } catch (Exception e) {}
                    temp=1;
                }
            }
        }
        //knight
        for (int j=-2; j<=2; j++) {
            for (int k=-2; k<=2; k++) {
                if (Math.abs(j*k) == 2) {
                    try {
                        if ("n".equals(chessBoard[kingPositionW/8+j][kingPositionW%8+k])) {
                            return false;
                        }
                    } catch (Exception e) {}
                    temp=1;
                }
                
        return true;
    }
}