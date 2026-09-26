import javax.swing.*;
import java.awt.*;
import java.util.Random;


public class TicTacToeGUI {

    int moves=0;

    public static boolean finish=false;

    Random r = new Random();

    JFrame frame = new JFrame("Tic Tac Toe");

    JButton[][] buttons = new JButton[3][3];

    char [][] ttt={{' ','|',' ','|',' '},
          {'-','+','-','+','-'},
          {' ','|',' ','|',' '},
          {'-','+','-','+','-'},
          {' ','|',' ','|',' '}};

    public TicTacToeGUI() {

        // Making the window a 3×3 grid.
        frame.setLayout(new GridLayout(3, 3));

        // Creating 9 buttons.
        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {

                JButton button = new JButton("");
                button.setFont(new Font("Arial", Font.BOLD, 60));
                int position = row * 3 + col + 1;

                button.addActionListener(e -> {
                    if (isFree(ttt, position)){

                        pos(ttt, position, "player");
                        moves++;
                        button.setText("X");
                        button.setEnabled(false);

                        if (checkWin(ttt)) {
                            JOptionPane.showMessageDialog(frame, "Player has won!");
                            disableBoard();
                            return;
                        }

                        if(moves==9){
                            JOptionPane.showMessageDialog(frame,"It's a draw.");
                            disableBoard();
                            return;
                        }    
                        cpuMove();
                    }

                });

                buttons[row][col] = button;

                frame.add(button);
            }
        }

        frame.setSize(400, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    public static void pos(char[][] ttt, int n, String s){
        char c='A';
        if(s.equalsIgnoreCase("player")){c='X';}
        else if(s.equalsIgnoreCase("Cpu")){c='O';}
        switch(n){
            case 1: ttt[0][0]=c; break;
            case 2: ttt[0][2]=c; break;
            case 3: ttt[0][4]=c; break;
            case 4: ttt[2][0]=c; break;
            case 5: ttt[2][2]=c; break;
            case 6: ttt[2][4]=c; break;
            case 7: ttt[4][0]=c; break;
            case 8: ttt[4][2]=c; break;
            case 9: ttt[4][4]=c; break;
        }
    }
    public static boolean isFree(char [][] ttt, int n){
        switch(n){
            case 1: return ttt[0][0]==' '; 
            case 2: return ttt[0][2]==' '; 
            case 3: return ttt[0][4]==' '; 
            case 4: return ttt[2][0]==' '; 
            case 5: return ttt[2][2]==' '; 
            case 6: return ttt[2][4]==' '; 
            case 7: return ttt[4][0]==' '; 
            case 8: return ttt[4][2]==' '; 
            case 9: return ttt[4][4]==' ';
            default: return false;
        }
    }

    public void cpuMove(){

        int n;
        do{
            n = r.nextInt(9) + 1;
        }while(!isFree(ttt, n));

        pos(ttt, n, "cpu");
        moves++;

        int r=(n-1)/3 , c=(n-1)%3;
        buttons[r][c].setText("O");
        buttons[r][c].setEnabled(false);     
        
        if (checkWin(ttt)){
            JOptionPane.showMessageDialog(frame, "CPU has won!");
            disableBoard();
        }

        if(moves==9){
            JOptionPane.showMessageDialog(frame,"It's a draw.");
            disableBoard();
        } 
    }

    public void disableBoard(){
        for(int row = 0; row < 3; row++){
            for(int col = 0; col < 3; col++){
                buttons[row][col].setEnabled(false);
            }
        }
    }

    public static void print(char [][] ttt){
        for(int r = 0 ; r < ttt.length ; r++){
            for(int c = 0 ; c < ttt[r].length; c++){
                System.out.print(ttt[r][c]);
            }
            System.out.println();
        }
    }

    public static boolean checkWin(char[][] ttt){
        win(ttt); return finish;
    }

    public static void win(char[][] ttt){
        winr(ttt);
        winc(ttt);
        wind(ttt);
    }

    public static void winr(char [][] ttt){
        char c='A';
        boolean f=false;
        if(ttt[0][0]!=' ' && ttt[0][0]==ttt[0][2] &&ttt[0][2]==ttt[0][4]){f=true;c=ttt[0][0];}
        else if(ttt[2][0]!=' ' && ttt[2][0]==ttt[2][2] &&ttt[2][2]==ttt[2][4]){f=true;c=ttt[2][0];}
        else if(ttt[4][0]!=' ' && ttt[4][0]==ttt[4][2] &&ttt[4][2]==ttt[4][4]){f=true;c=ttt[4][0];}
        if(f){print(ttt);System.out.println(c+" has won the game.");finish=true;}
    }

    public static void winc(char [][] ttt){
        char c='A';
        boolean f=false;
        if(ttt[0][0]!=' ' && ttt[0][0]==ttt[2][0] &&ttt[2][0]==ttt[4][0]){f=true;c=ttt[0][0];}
        else if(ttt[0][2]!=' ' && ttt[0][2]==ttt[2][2] &&ttt[2][2]==ttt[4][2]){f=true;c=ttt[0][2];}
        else if(ttt[0][4]!=' ' && ttt[0][4]==ttt[2][4] &&ttt[2][4]==ttt[4][4]){f=true;c=ttt[0][4];}
        if(f){print(ttt);System.out.println(c+" has won the game.");finish=true;}
    }

    public static void wind(char [][] ttt){
        char c='A';
        boolean f=false;
        if(ttt[0][0]!=' ' && ttt[0][0]==ttt[2][2] &&ttt[2][2]==ttt[4][4]){f=true;c=ttt[0][0];}
        else if(ttt[0][4]!=' ' && ttt[0][4]==ttt[2][2] &&ttt[2][2]==ttt[4][0]){f=true;c=ttt[0][4];}
        if(f){print(ttt);System.out.println(c+" has won the game.");finish=true;}
     }

    public static void main(String[] args) {
        new TicTacToeGUI();
    }
}