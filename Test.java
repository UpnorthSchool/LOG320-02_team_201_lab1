import java.util.ArrayList;
import java.util.Scanner;
import Decoder.stringToInt;

public class Test {
   public static void main(String []args) {
      stringToInt decoderEntrer = new stringToInt();
      Board board = new Board();
      System.out.println("Svp entrer les cases que vous voulez jouer comme suit (ligne, colonne, exemple : A1,b2,c3)");
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

      while(board.getVictoire())
      {
          boolean moveValide = false;
          while(!moveValide)
          {

              System.out.println("choisir colonne et ligne.Exemple: A1 ou C3");
              String moveChoisi = myObj.nextLine().toLowerCase();

              newMoveHuman.setCol(decoderEntrer.decodeCol(moveChoisi));
              newMoveHuman.setRow(decoderEntrer.decodeLigne(moveChoisi));
              
              //verification que le move est valide
              if(board.moveValide(newMoveHuman.getCol(), newMoveHuman.getRow())){
                moveValide = true;
              }else
              {
                System.out.println("case deja prise, rejoue");
                moveValide = false;
              }
              

          }
          if(choix.equals("x") )
          {
              board.play(newMoveHuman, Mark.X);
              board.display();

              //check que victoire ou defaites
              if(board.hasWon(scoreKeeper))
              {
                break;
              }
              //TODO testing here to see available ai move, seems to be working 
              ArrayList<Move> aiPossibleNextMove= aiMachine.getAvailableCase(board);
              aiPossibleNextMove.forEach( (movePossible) -> { System.out.println(movePossible.toString());});


              

          }
          else
          {
              board.play(newMoveHuman, Mark.O);
              board.display();
              scoreKeeper = board.evaluate(Mark.O);
              if(board.hasWon(scoreKeeper))
              {
                break;
              }
          }
        }
        
   }
}