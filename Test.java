import java.util.Scanner;

public class Test {
   public static void main(String []args) {
        Board board = new Board();
        CPUPlayer cpu = new CPUPlayer(Mark.O);

        Scanner scanner = new Scanner(System.in);
        System.out.println("TicTacToe!");
        board.display();
      //board.play(new Move(0,0),Mark.O);
      //board.play(new Move(1,0),Mark.X);
      //board.play(new Move(2,0),Mark.O);
      //board.play(new Move(0,1),Mark.X);
      //board.play(new Move(1,1),Mark.O);
      //board.play(new Move(2,1),Mark.X);
      //board.play(new Move(0,2),Mark.O);
      //board.play(new Move(1,2),Mark.X);
      //board.play(new Move(2,2),Mark.O);
      for(int i = 0; i < 5; i++){
        System.out.println("Entrer une rangée:  ");
        int r = scanner.nextInt(); 
        System.out.println("Entrer une colonne:  ");
        int c = scanner.nextInt();
        board.play(new Move(r,c),Mark.X);
        board.play(cpu.getNextMoveMinMax(board).get(0),Mark.O);
        board.display();
      }
        
   }
}