import java.util.*;

public class TicTacToe {

  public static boolean checkCol(int coord, int[][] board) {
    return (board[0][coord] == board[1][coord]) && (board[1][coord] == board[2][coord]);
  }

  public static boolean checkRow(int coord, int[][] board) {
    return (board[coord][0] == board[coord][1]) && (board[coord][1] == board[coord][2]);
  }

  public static boolean checkRightDiagonal(int[][] board) {
    return (board[0][0] == board[1][1]) && (board[1][1] == board[2][2]);
  }

  public static boolean checkLeftDiagonal(int[][] board) {
    return (board[0][2] == board[1][1]) && (board[1][1] == board[2][0]);
  }

  public static void main(String[] args) {
    int[][] board = new int[3][3];
    int turn = 0;
    int winner = 0;

    while(turn<9 && winner == 0) {
      int player_turn = turn%2+1;
      Scanner sc = new Scanner(System.in);
      System.out.print("Player "+ player_turn + ": ");

      String[] user_input = sc.nextLine().split(",");
      int x_coord = Integer.parseInt(user_input[0]);
      int y_coord = Integer.parseInt(user_input[1]);

      board[y_coord][x_coord] = player_turn;

      if(turn >= 4) {
          if(y_coord == x_coord) {
            if(y_coord == 1 && x_coord == 1) {
              if(checkCol(x_coord, board) || checkRow(y_coord, board) ||
                checkRightDiagonal(board) || checkLeftDiagonal(board)) {
                winner = player_turn;
                System.out.println("Player " + winner + " Wins!");
              }
            }
            else
            {
              if(checkCol(x_coord, board) || checkRow(y_coord, board) ||
                checkRightDiagonal(board)) {
                winner = player_turn;
                System.out.println("Player " + winner + " Wins!");
            }
          }
        } else if ((y_coord == 0 && x_coord == board[0].length-1) || (y_coord == board[0].length-1 && x_coord == 0)) {
          if(checkCol(x_coord, board) || checkRow(y_coord, board) ||
            checkLeftDiagonal(board)) {
            winner = player_turn;
            System.out.println("Player " + winner + " Wins!");
          }
        } else {
          if(checkCol(x_coord, board) || checkRow(y_coord, board)) {
            winner = player_turn;
            System.out.println("Player " + winner + " Wins!");
          }
        }
      }

      turn++;
    }
  }
}

