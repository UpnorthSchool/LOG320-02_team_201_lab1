import java.util.ArrayList;

// IMPORTANT: Il ne faut pas changer la signature des méthodes
// de cette classe, ni le nom de la classe.
// Vous pouvez par contre ajouter d'autres méthodes (ça devrait 
// être le cas)
class Board
{
    //[row][column]
    private Mark[][] board;

    // Ne pas changer la signature de cette méthode
    public Board() {
        board = new Mark[3][3];
        for(int r = 0; r < 3; r++){
            for(int c = 0; c < 3; c++){
                board[r][c] = Mark.EMPTY;
            }
        }
    }

    public Mark[][] getBoard(){
        return board;
    }

    // Place la pièce 'mark' sur le plateau, à la
    // position spécifiée dans Move
    // Ne pas changer la signature de cette méthode
    public void play(Move m, Mark mark){
        board[m.getRow()][m.getCol()] = mark;
    }


    // retourne  100 pour une victoire
    //          -100 pour une défaite
    //           0   pour un match nul
    // Ne pas changer la signature de cette méthode
    public int evaluate(Mark mark){
        Mark player;
        Mark opponent;
        boolean won;
        boolean lost;

        if(mark == Mark.X){
            player = Mark.X;
            opponent = Mark.O;
        } else if (mark == Mark.O) {
            player = Mark.O;
            opponent = Mark.X;
        } else{
            return -1;
        }

        won = hasWon(player);
        lost = hasWon(opponent);
        if(won && lost){
            return 0;
        } else if(won){
            return 100;
        } else if(lost){
            return -100;
        } else {
            return 0;
        }
    }

    public boolean hasWon(Mark mark){
        //rows
        for(int r = 0; r < 3; r++){
            if(board[r][0]==mark && board[r][1]==mark && board[r][2]==mark){
                return true;
            }
        }
        //columns
        for(int c = 0; c < 3; c++){
            if(board[0][c]==mark && board[1][c]==mark && board[2][c]==mark){
                return true;
            }
        }
        //diagonals
        if(board[0][0]==mark && board[1][1]==mark && board[2][2]==mark){
                return true;
        }
        if(board[2][0]==mark && board[1][1]==mark && board[0][2]==mark){
                return true;
        }

        //or else
        return false;
    }

    public void display(){
        for(int r = 0; r < 3; r++){
            for(int c = 0; c < 3; c++){
                if(board[r][c] == Mark.EMPTY){
                    System.out.print(r+" "+c);
                }else{
                    System.out.print(" "+board[r][c].toString()+" ");
                }
                if(c != 2){
                    System.out.print("|");
                }
            }
            System.out.println();
        }
    }
}
