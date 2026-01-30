package Game;
import java.util.ArrayList;

import Game.Algorythme.MinMax;

// IMPORTANT: Il ne faut pas changer la signature des méthodes
// de cette classe, ni le nom de la classe.
// Vous pouvez par contre ajouter d'autres méthodes (ça devrait 
// être le cas)
public class CPUPlayer
{

    // Contient le nombre de noeuds visités (le nombre
    // d'appel à la fonction MinMax ou Alpha Beta)
    // Normalement, la variable devrait être incrémentée
    // au début de votre MinMax ou Alpha Beta.
    private int numExploredNodes;
    private Mark cpuMARK;
    private Mark opponentMARK;
    private ArrayList<Move> movePossibleUncheck = new ArrayList<>();
    public MinMax miniMax = new MinMax();

    // Le constructeur reçoit en paramètre le
    // joueur MAX (X ou O)
    public CPUPlayer(Mark cpu){
        setCpuMark(cpu);
        setOpponentMark((cpu == Mark.X) ? Mark.O : Mark.X);
    }

    // Ne pas changer cette méthode
    public int  getNumOfExploredNodes(){
        return numExploredNodes;
    }

    // Retourne la liste des coups possibles.  Cette liste contient
    // plusieurs coups possibles si et seuleument si plusieurs coups
    // ont le même score.
    public ArrayList<Move> getNextMoveMinMax(Board board)
    {
        numExploredNodes = 0;

        for(Move move : getMovePossibleUncheck(board))
        {
            //simule les moves un a un
            board.play(move, cpuMARK);
            //simule le coup adverse(commence par min)
            int score = miniMax.minMax(board, getOpponentMark());
            //enleve le move fait et en essai un autre
            board.undoMove(move);
        }


        //changer ce que sa retourne
        return getMovePossibleUncheck(board);
    }

    // Retourne la liste des coups possibles.  Cette liste contient
    // plusieurs coups possibles si et seuleument si plusieurs coups
    // ont le même score.
    public ArrayList<Move> getNextMoveAB(Board board){
        numExploredNodes = 0;

        //todo
        return new ArrayList<>();
    }


    //check for empty case in board 
    public ArrayList<Move> getMovePossibleUncheck(Board board)
    {
        movePossibleUncheck = board.getAvailableCase();
        return movePossibleUncheck;
    }








    //////getter setter
    /// 
    /// 
    public void setCpuMark(Mark cpu)
    {
        cpuMARK = cpu;
    }

    public Mark getCpuMark()
    {
        return cpuMARK;
    }
     public void setOpponentMark(Mark opponent)
    {
        opponentMARK = opponent;
    }

    public Mark getOpponentMark()
    {
        return opponentMARK;
    }
}
