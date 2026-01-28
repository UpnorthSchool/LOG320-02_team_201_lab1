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

    public void undoMove(Move moveUndo)
    {
        board[moveUndo.getCol()][moveUndo.getRow()] = Mark.EMPTY;
    }


    // retourne  100 pour une victoire
    //          -100 pour une défaite
    //           0   pour un match nul
    // Ne pas changer la signature de cette méthode
    public int evaluate(Mark mark){
        Mark adversaireXO = (mark == Mark.X) ? Mark.O : Mark.X;

        //verificationvictoire 
        if(verifierVictoire(mark))
        {
            return 100;
        }
        if(verifierVictoire(adversaireXO))
        {
            return -100;
        }

        //verification partie null
        if(partieNullCheck())
        {
            return 0;
        }


        

       
        return Integer.MIN_VALUE;
        
    }

    //display du board avec un string builder. 
    //ajustement des lignes colonne pour etre egal 
    public void display(){
        StringBuilder boardShowString = new StringBuilder();
        for(int yLig = boardSize - 1 ; yLig >= 0; yLig--){
            for(int xCol = 0; xCol < boardSize ; xCol++){
                String ajustement = (board[xCol][yLig] == Mark.EMPTY) ? "  " + board[xCol][yLig].toString() : "   " + board[xCol][yLig].toString();
                boardShowString.append(String.format("%-" + 7 + "s", ajustement));
            }
            boardShowString.append("\n");
        }
        System.out.println(boardShowString.toString());
    }


    public boolean getVictoire()
    {
        return true;
    }


    //////// serie evaluation pour le jeu mieux diviser pour meilleur comprehension du minmax
    /// apprisrecemment, possibiliter java de retourner un bool avec juste des verif,
    /// 
    public boolean verifierVictoire(Mark mark)
    {
        return
        // verification victoire  ligne horizontale  ( y ) OU vertical OU diagonal
        (board[0][0] == mark && board[0][1] == mark && board[0][2] == mark) ||
        (board[1][0] == mark && board[1][1] == mark && board[1][2] == mark) ||
        (board[2][0] == mark && board[2][1] == mark && board[2][2] == mark) ||


        // colonne vertical ( x) 
        (board[0][0] == mark && board[1][0] == mark && board[2][0] == mark) ||
        (board[0][1] == mark && board[1][1] == mark && board[2][1] == mark) ||
        (board[0][2] == mark && board[1][2] == mark && board[2][2] == mark) ||


        // Diagonals
        (board[0][0] == mark && board[1][1] == mark && board[2][2] == mark) ||
        (board[0][2] == mark && board[1][1] == mark && board[2][0] == mark);
    }

    //verifie sitableaua une case vide, si non, alors partie null
    public boolean partieNullCheck()
    {
        // retourner si la partie nest pas null
        for(int colonne = 0 ; colonne < boardSize ; colonne ++)
        {
            for(int ligne = 0 ;ligne < boardSize ; ligne ++)
            {
                if(board[colonne][ligne] == Mark.EMPTY)
                {
                    return false;
                }
            }
        }
        return true;
    }


    //verification que le mouvement est sur le board 
    public boolean moveValide(int xColPosition, int yLignePosition)
    {
        //check on board and check if case empty
        if(xColPosition > -1 && xColPosition < boardSize && yLignePosition > -1 && yLignePosition < boardSize && board[xColPosition][yLignePosition] == Mark.EMPTY)
        {
            return true;
        }
        
        return false;
        
    }

    public int getBoardSize()
    {
        return boardSize;
    }



    public boolean hasWon(int scoreKeeper)
    {
        if(scoreKeeper != Integer.MIN_VALUE)
            {
            if(scoreKeeper == 100)
            {
                System.out.println("!! Victoire du Joueur !! ");
                System.out.println("PARTIE TERMINER");
                return true;
            }else if (scoreKeeper == -100)
            {
                System.out.println("!! VICTOIRE de L'AI !!");
                System.out.println("PARTIE TERMINER");
                return true;

            }else if (scoreKeeper == 0)
            {
                System.out.println("!! PARTIE NULL !!");
                return true;
            }
            }
        return false;
    }

}
