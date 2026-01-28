import java.util.Scanner;
import Decoder.stringToInt;

public class Test {
   public static void main(String []args) {
      stringToInt decoderEntrer = new stringToInt();
      Board board = new Board();
      System.out.println("Svp entrer les cases que vous voulez jouer comme suit (ligne, colonne, exemple : A1,b2,c3)");
      Scanner myObj = new Scanner(System.in);
      CPUPlayer aiMachine;
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
              //TODO check que victoire ou defaite
              scoreKeeper = board.evaluate(Mark.X);
              if(scoreKeeper != Integer.MIN_VALUE)
              {
                if(scoreKeeper == 100)
                {
                  System.out.println("!! Victoire des X !! ");
                  System.out.println("PARTIE TERMINER");
                  break;  
                }else if (scoreKeeper == -100)
                {
                  System.out.println("!! VICTOIRE de L'AI !!");
                  System.out.println("PARTIE TERMINER");
                  break;
                }else if (scoreKeeper == 0)
                {
                  System.out.println("!! PARTIE NULL !!");
                  break;
                }
              }
              

          }
          else
          {
              board.play(newMoveHuman, Mark.O);
              board.display();
              scoreKeeper = board.evaluate(Mark.O);
              if(scoreKeeper != Integer.MIN_VALUE)
              {
                if(scoreKeeper == 100)
                {
                  System.out.println("!! Victoire des O !! ");
                  System.out.println("PARTIE TERMINER");
                  break;  
                }else if (scoreKeeper == -100)
                {
                  System.out.println("!! VICTOIRE de L'AI !!");
                  System.out.println("PARTIE TERMINER");
                  break;
                }else if (scoreKeeper == 0)
                {
                  System.out.println("!! PARTIE NULL !!");
                  break;
                }
              }

          }
        }
        
   }
}