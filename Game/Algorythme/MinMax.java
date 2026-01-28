package Game.Algorythme;

import Game.*;

public class MinMax {
    public int minMax(Board board, Mark minMaxMark)
    {
        int scoreSortie = board.evaluate(minMaxMark);
       //condition de sortie iciii
       if(scoreSortie == 100 || scoreSortie == -100 || scoreSortie == 0) return scoreSortie;


       //TODO reste de lalgorythme ! 
       return 99;
    }

}
