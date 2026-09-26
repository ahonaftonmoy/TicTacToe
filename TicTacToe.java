//khela sesh kora baki
import java.util.Scanner;
import java.util.Random;
public class TicTacToe{
     public static boolean finish=false;
     public static void main(String [] args){
          
          Scanner sc = new Scanner(System.in);
          Random r=new Random();
          //boolean finish=false;
          int m=0;
          char [][] ttt={{' ','|',' ','|',' '},
          {'-','+','-','+','-'},
          {' ','|',' ','|',' '},
          {'-','+','-','+','-'},
          {' ','|',' ','|',' '}};
          while(true){
          print(ttt);
          System.out.println("Enter your position(1-9):");
          int n;
          do {n=sc.nextInt();}
          while(!isFree(ttt,n));
          m++;
          pos(ttt,n,"player");

          if(checkWin(ttt)){ break;}

          if(m==9){print(ttt);System.out.println("The game ended in a draw."); break;}


          int n1;
          do{n1=r.nextInt(9)+1;}
          while(!isFree(ttt, n1));
          m++;
          pos(ttt,n1,"cpu");
          
          if(checkWin(ttt)) {break;}
          if(m==9){print(ttt);System.out.println("The game ended in a draw."); break;}

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
}