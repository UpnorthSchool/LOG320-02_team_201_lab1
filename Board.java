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
        return 100;
    }
}
