package tictactoe;
import java.util.Scanner;
public class TicTacToe {

    private char[][] board; {
	board = new char[3][3];			
	}
	private char player; {
	player = 'X';			
	}
   
    public static void main(String[] args) {
       
       Scanner in = new Scanner(System.in);
       TicTacToe game = new TicTacToe();
       System.out.println("Welcome to Tic-tac-toe");
       System.out.println("Enter coordinates for your move following the X and O prompts");
       
       while(!game.stalemate()) 
       {
              game.printBoard();
              System.out.print(game.getPlayer() + ":");

              //Loop while the method play does not return true when given their move.
              //Body of loop should ask for a different move
              while(!game.play(in.next()))
              {
                    System.out.println("Illegal move. Enter your move.");
                    System.out.print(game.getPlayer() + ":");
               }
              //If the game is won, call break;
              if(game.won())
                  break;

              //Switch the turn
              game.switchTurn();

        }
        game.printBoard();
        if(game.won())
        {
            System.out.println("Player "+game.getPlayer()+" Wins!!!!");
        } 
        else 
        {
            System.out.println("Stalemate");
        }
    }
    
    public TicTacToe(){
        for (int i=0; i<3; i ++) {
            for (int j =0; j<3; j++) {
                    board[i][j]= ' ';
            }
        }
    }
    
    public boolean play(String position){
        int row,col;					
								
            if (position.charAt(0) =='A')		
                row = 0;
            else if (position.charAt(0) =='B')
                row = 1;
            else if (position.charAt(0)== 'C')
                row = 2;
            else
                    return false;

            if (position.charAt(1) =='1')		
                col = 0;
            else if (position.charAt(1) =='2')
                col = 1;
            else if (position.charAt(1)== '3')
                col = 2;
            else 
                return false;

            if (board[row][col]==' ') 	
                board[row][col] = player;
            else
                return false;

        return true;
    }   
    
    public void switchTurn(){
        
	if (player == 'X'){	
            player ='O';
	}
        else
            player = 'X';
    }
    
    public char getPlayer() {
        return player;
	}
    
    public boolean won(){
        if( board[0][0]!=' ' &&  board [0][0]==board[0][1] && board [0][1]== board [0][2]
            || board[1][0]!=' ' && board [1][0]==board[1][1] && board [1][1]== board [1][2]
            || board[2][0]!=' ' &&  board [2][0]==board[2][1] && board [2][1]== board [2][2]		
            || board[0][0]!=' ' && board [0][0]==board[1][0] && board [1][0]== board [2][0]
            || board[0][1]!=' ' && board [0][1]==board[1][1] && board [1][1]== board [2][1]	
            || board[0][2]!=' ' && board [0][2]==board[1][2] && board [1][2]== board [2][2]
            || board[0][0]!=' ' && board [0][0]== board [1][1] && board [1][1]== board [2][2]
            || board[0][2]!=' ' && board [0][2]== board [1][1] && board [1][1]== board [2][0] ) 
            return true;
        else
            return false;	
    }
    
    public boolean stalemate(){
        for (int i=0; i<3; i++) {
            for (int j =0; j<3; j++) {
                    if (board[i][j]==' ')
                       return false;
            }
    }
     return true;  
    }
    
    public void printBoard(){
        System.out.println();
        System.out.println("\t   1 2 3");
        System.out.println("\t A "+board[0][0]+"|"+board[0][1]+"|"+board[0][2]);
        System.out.println("\t  ------");
        System.out.println("\t B "+board[1][0]+"|"+board[1][1]+"|"+board[1][2]);
        System.out.println("\t  "+"------");
        System.out.println("\t C "+board[2][0]+"|"+board[2][1]+"|"+board[2][2]); 
     }
    
}