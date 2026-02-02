package Game;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

import Game.Decoder.stringToInt;

public class Test {
   public static void main(String []args) {
      stringToInt decoderEntrer = new stringToInt();
      Board board = new Board();
      System.out.println("Svp entrer les cases que vous voulez jouer comme suit (x,y), exemple : A1,b2,c3)");
      Scanner myObj = new Scanner(System.in);
      CPUPlayer aiMachine = new CPUPlayer(null);
      Move newMoveHuman = new Move();
      //tant que min value game is ongoing;
      int scoreKeeper = Integer.MIN_VALUE;



      boolean playerChoice = false;
      String choix = "";

      while (!playerChoice) {
          System.out.println("Voulez-vous jouer les X ou les O?");
          choix = myObj.nextLine().toLowerCase();  // lecture du texte tapé par le joueur
          aiMachine = choix.equals("x") ? new CPUPlayer(Mark.O) : new CPUPlayer(Mark.X);
          playerChoice = true;
          System.out.println("UNE ENTRÉE INVALIDE VOUS REDEMANDERA D'ENTRER UNE LOCATION");


      }
      
      board = new Board();
      if(aiMachine.getCpuMark() == Mark.X)
      {
        cpuMovePlay(board, aiMachine);
      }

      while(board.getVictoire())
      {
          boolean moveValide = false;
          while(!moveValide)
          {

              board.display();
              System.out.println("choisir colonne et ligne.Exemple: A1 ou C3");
              String moveChoisi = myObj.nextLine().toLowerCase();

              newMoveHuman.setCol(decoderEntrer.decodeCol(moveChoisi));
              newMoveHuman.setRow(decoderEntrer.decodeLigne(moveChoisi));
              
              //verification que le move est valide
              if(board.moveValide(newMoveHuman.getCol(), newMoveHuman.getRow())){
                moveValide = true;
              }else
              {
                System.out.println("Case Invalide !! ");
                moveValide = false;
              }
              

          }
          if(choix.equals("x") )
          {
              board.play(newMoveHuman, Mark.X);

              //check que victoire ou defaites
              scoreKeeper = board.evaluate(Mark.X);
              if(board.hasWon(scoreKeeper))
              {
                break;
              }else
              {              
                cpuMovePlay(board, aiMachine);
                if (board.hasWon(board.evaluate(Mark.X))) break;
              }



          }
          else
          {
              //TODO testing here to see available ai move, seems to be working, 
              board.play(newMoveHuman, Mark.O);
              scoreKeeper = board.evaluate(Mark.O);
              if(board.hasWon(scoreKeeper))
              {
                break;
              }else
              {
                cpuMovePlay(board, aiMachine);
                if (board.hasWon(board.evaluate(Mark.O))) break;
              }

          }
        }

        board.display();
        
   }
   public static void cpuMovePlay(Board board, CPUPlayer aiMachine)
   {
    ArrayList<Move> aiPossibleNextMove= aiMachine.getNextMoveMinMax(board);
    //test display pour les moves possible qui ont le meme score 
    aiPossibleNextMove.forEach( (movePossible) -> { System.out.print(movePossible.toString() +" ; ");});
    System.out.println(aiMachine.getNumOfExploredNodes());
    //joue un move random de la liste 
    int random = ThreadLocalRandom.current().nextInt(0, aiPossibleNextMove.size());
    board.play(aiPossibleNextMove.get(random), aiMachine.getCpuMark());
   }


   
}