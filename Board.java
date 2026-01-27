import java.util.ArrayList;

// IMPORTANT: Il ne faut pas changer la signature des méthodes
// de cette classe, ni le nom de la classe.
// Vous pouvez par contre ajouter d'autres méthodes (ça devrait 
// être le cas)
class Board
{
    //[row][column]
    private Mark[][] board;
    private int boardSize = 3;

    // Ne pas changer la signature de cette méthode
    public Board() {
        board = new Mark[boardSize][boardSize];
        for(int xCol = 0; xCol < boardSize; xCol++){
            for(int yLig = 0; yLig < boardSize; yLig++){
                board[xCol][yLig] = Mark.EMPTY;
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
        board[m.getCol()][m.getRow()] = mark;
    }


    // retourne  100 pour une victoire
    //          -100 pour une défaite
    //           0   pour un match nul
    // Ne pas changer la signature de cette méthode
    public int evaluate(Mark mark){
        
        // Rows
        if (
            (board[0][0] == mark && board[0][1] == mark && board[0][2] == mark) ||
            (board[1][0] == mark && board[1][1] == mark && board[1][2] == mark) ||
            (board[2][0] == mark && board[2][1] == mark && board[2][2] == mark)
        ) {
            return 100;
        }

        // Columns
        if (
            (board[0][0] == mark && board[1][0] == mark && board[2][0] == mark) ||
            (board[0][1] == mark && board[1][1] == mark && board[2][1] == mark) ||
            (board[0][2] == mark && board[1][2] == mark && board[2][2] == mark)
        ) {
            return 100;
        }

        // Diagonals
        if (
            (board[0][0] == mark && board[1][1] == mark && board[2][2] == mark) ||
            (board[0][2] == mark && board[1][1] == mark && board[2][0] == mark)
        ) {
            return 100;
        }

        // No victory
        return 0;
    }

    public void display(){
        StringBuilder boardShowString = new StringBuilder();
        for(int yLig = boardSize - 1 ; yLig >= 0; yLig--){
            for(int xCol = 0; xCol < boardSize ; xCol++){
                boardShowString.append(board[xCol][yLig] + "  ");
            }
            boardShowString.append("\n");
        }
        System.out.println(boardShowString.toString());
    }


    public boolean getVictoire()
    {
        return true;
    }
}
