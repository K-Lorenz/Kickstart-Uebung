
import java.util.Arrays;
import java.util.Scanner;

public class TTTgame {
    static char[][] board = {{' ', ' ', ' '}, {' ', ' ', ' '}, {' ', ' ', ' '}};
    static Integer[] zahl= {0, 1, 2};

    static char currentPlayer = 'X';

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            printBoard();
            System.out.println("Spieler " + currentPlayer + ", bitte gib die Spalte und die Zeile (0-2) deines Zuges an:");
            int row;
            int col;
            col = checkNum(scanner.next());
            row = checkNum(scanner.next());
            while(!Arrays.asList(zahl).contains(col)||!Arrays.asList(zahl).contains(row) || board[row][col] != ' ' ){
                System.out.println("Ungültige Eingabe!");
                System.out.println("Spieler " + currentPlayer + ", bitte gib die Spalte und die Zeile (0-2) deines Zuges an:");
                col = checkNum(scanner.next());
                row = checkNum(scanner.next());
            }
            board[row][col] = currentPlayer;

            if (checkForWin()) {
                printBoard();
                System.out.println("Spieler " + currentPlayer + " gewinnt!");
                break;
            }

            if (checkForTie()) {
                printBoard();
                System.out.println("Unentschieden!");
                break;
            }

            currentPlayer = (currentPlayer == 'X') ? 'O' : 'X';
        }
    }

    public static void printBoard() {
        for (int i = 0; i < 3; i++) {
            System.out.println(" " + board[i][0] + " | " + board[i][1] + " | " + board[i][2]);
            if (i != 2) {
                System.out.println("---|---|---");
            }
        }
        System.out.println();
    }
    public static int checkNum(String checkForNum){
        int num;
        try{
            num = Integer.parseInt(checkForNum);
        }catch (Exception e){
            num = -1;
        }
        return num;
    }

    public static boolean checkForWin() {
        // Check rows
        for (int i = 0; i < 3; i++) {
            if (board[i][0] == currentPlayer && board[i][1] == currentPlayer && board[i][2] == currentPlayer) {
                return true;
            }
        }

        // Check columns
        for (int i = 0; i < 3; i++) {
            if (board[0][i] == currentPlayer && board[1][i] == currentPlayer && board[2][i] == currentPlayer) {
                return true;
            }
        }

        // Check diagonals
        if (board[0][0] == currentPlayer && board[1][1] == currentPlayer && board[2][2] == currentPlayer) {
            return true;
        }
        if (board[0][2] == currentPlayer && board[1][1] == currentPlayer && board[2][0] == currentPlayer) {
            return true;
        }

        return false;
    }

    public static boolean checkForTie() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i][j] == ' ') {
                    return false;
                }
            }
        }
        return true;
    }
}
