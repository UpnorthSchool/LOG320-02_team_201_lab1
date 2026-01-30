package Game.Algorythme;

import Game.*;

public class MinMax {

    private Mark cpuMARK;


    //permet de tracker quel joueur joue

    public MinMax(Mark cpuMark)
    {
        this.cpuMARK = cpuMark;
    }

    public int minMax(Board board, Mark minMaxMark)
    {


       //premier tour est toujours evaluer comme les min (mentioner par le prof )
       int scoreSortie = board.evaluate(minMaxMark);
       //condition de sortie iciii
       if(scoreSortie == 100 || scoreSortie == -100 || scoreSortie == 0) return scoreSortie;

       // definition du joueur 
       boolean isMax = (minMaxMark == cpuMARK);

       int bestScore;
       if(isMax)
       { 
            bestScore = Integer.MIN_VALUE;
       }

       //TODO reste de lalgorythme ! 
       return 99;
    }

}
