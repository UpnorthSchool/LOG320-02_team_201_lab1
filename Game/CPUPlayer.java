package Game;
import java.util.ArrayList;

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

    // Le constructeur reçoit en paramètre le
    // joueur MAX (X ou O)
    public CPUPlayer(Mark cpu){
        setCpuMark(cpu);
        setCpuMark((cpu == Mark.X) ? Mark.O : Mark.X);
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

        //TODO modifier ceici puisque ajout de fonctionpour cheker case vide a ete fait
        ArrayList<Move> nextMoves = new ArrayList<>();
        for(int r = 0; r < 3; r++){
            for(int c = 0; c < 3; c++){
                if (board.getBoard()[r][c] == Mark.EMPTY){
                    nextMoves.add(new Move(r, c));
                }
            }
        }
        return nextMoves;
    }

    // Retourne la liste des coups possibles.  Cette liste contient
    // plusieurs coups possibles si et seuleument si plusieurs coups
    // ont le même score.
    public ArrayList<Move> getNextMoveAB(Board board){
        numExploredNodes = 0;

        //todo
        return new ArrayList<>();
    }

    public void setMovePossibleUncheck(Board board)
    {
        movePossibleUncheck = board.getAvailableCase();
    }

    public ArrayList<Move> getMovePossibleUncheck()
    {
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
