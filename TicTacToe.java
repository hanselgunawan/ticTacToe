import java.util.*;

public class TicTacToe {

  public static boolean checkCol(int x_coord, int[][] board) {
    return (board[0][x_coord] == board[1][x_coord]) && (board[1][x_coord] == board[2][x_coord]);
  }

  public static boolean checkRow(int y_coord, int[][] board) {
    return (board[y_coord][0] == board[y_coord][1]) && (board[y_coord][1] == board[y_coord][2]);
  }

  public static boolean checkRightDiagonal(int x_coord, int y_coord, int[][] board) {
    if(x_coord != y_coord) return false;//guard clause

    return (board[0][0] == board[1][1]) && (board[1][1] == board[2][2]);
  }

  public static boolean checkLeftDiagonal(int y_coord, int x_coord, int[][] board) {
    if(y_coord != 2 - x_coord) return false;

    return (board[0][2] == board[1][1]) && (board[1][1] == board[2][0]);
  }

  public static boolean checkWin(int x_coord, int y_coord, int[][] board) {
    return checkRow(y_coord, board) || checkCol(x_coord, board) || checkLeftDiagonal(x_coord, y_coord, board) || checkRightDiagonal(y_coord, x_coord, board);
  }

  public static void main(String[] args) {
    int[][] board = new int[3][3];
    int turn = 0;
    int winner = 0;

    while(turn < 9 && winner == 0) {
      int player_turn = turn % 2 + 1;
      Scanner sc = new Scanner(System.in);
      System.out.print("Player " + player_turn + ": ");

      String[] user_input = sc.nextLine().split(",");
      int x_coord = Integer.parseInt(user_input[0]);
      int y_coord = Integer.parseInt(user_input[1]);

      if(board[y_coord][x_coord] != 0) {
        System.out.println("That place is chosen by other player. Try other place.");
        continue;
      }
      board[y_coord][x_coord] = player_turn;
      turn++;

      if(turn >= 5 && checkWin(x_coord, y_coord, board)) {
        winner = player_turn;
        System.out.println("Player " + winner + " Wins!");
      }
    }

    if(winner == 0) System.out.println("Tie!");
  }
}
