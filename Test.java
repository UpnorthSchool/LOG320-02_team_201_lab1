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




      boolean playerChoice = false;
      String choix = "";

      while (!playerChoice) {
          System.out.println("Voulez-vous jouer les X ou les O?");
          choix = myObj.nextLine().toLowerCase();  // lecture du texte tapé par le joueur
          aiMachine = choix.equals("x") ? new CPUPlayer(Mark.O) : new CPUPlayer(Mark.X);
          playerChoice = true;
          System.out.println("une entrée invalide vous redemandera d'entrer une location");

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
              if(newMoveHuman.getCol() != -1 && newMoveHuman.getRow() != -1)
              {
                moveValide = true;
              }
              
              //TODO verifier mouvement valide ici avant de jouer : case bien dans tableau + case non prise
              //System.out.println("case deja prise, rejoue");

          }
          if(choix.equals("x") )
          {
              board.play(newMoveHuman, Mark.X);
              board.display();
              //TODO check que victoire ou defaite
              if(board.evaluate(Mark.X) == 100)
              {
                System.out.println("Une victoire des X ");
                System.out.println("partie terminer");
                break;  
              }

          }
          else
          {
              board.play(newMoveHuman, Mark.O);
              board.display();
              if(board.evaluate(Mark.O) == 100)
              {
                System.out.println("Une victoire des O ");
                System.out.println("partie terminer");
                break;  
              }

          }
        }
        
   }
}