package com.consolebasedapp;

import java.util.Scanner;

public class TicTacToe {

    static char[][] board = new char[3][3];
    static char player = 'X';
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        System.out.println("================================");
        System.out.println("       TIC TAC TOE GAME");
        System.out.println("================================");
        System.out.println("Player 1: X");
        System.out.println("Player 2: O");

        // Initialize the board
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                board[i][j] = ' ';
            }
        }

        while (true) {

            printBoard();

            System.out.println("==================");
            System.out.println("Player " + player + ", it's your turn.");

            System.out.println("Please choose row (0-2):");
            int row = scanner.nextInt();

            System.out.println("Please choose column (0-2):");
            int col = scanner.nextInt();

            // Validate player move
            if (row < 0 || row > 2 || col < 0 || col > 2
                    || board[row][col] != ' ') {

                System.out.println("Invalid move! Please choose again.");
                continue;
            }

            board[row][col] = player;

            // Check winner
            if (checkWinner()) {

                System.out.println("Congratulations! Player "
                        + player + " wins the game!");

                printBoard();
                break;
            }

            // Check draw
            if (isBoardFull()) {

                System.out.println("Game Over! Match Draw!");

                printBoard();
                break;
            }

            // Switch player
            player = (player == 'X') ? 'O' : 'X';
        }

        System.out.println("Thanks for playing Tic Tac Toe!");
        scanner.close();
    }

    // Checks whether the board is full
    private static boolean isBoardFull() {

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {

                if (board[i][j] == ' ') {
                    return false;
                }
            }
        }

        return true;
    }

    // Checks winning conditions
    private static boolean checkWinner() {

        // Check rows
        for (int i = 0; i < board.length; i++) {

            if (board[i][0] == player &&
                board[i][1] == player &&
                board[i][2] == player) {

                return true;
            }
        }

        // Check columns
        for (int i = 0; i < board.length; i++) {

            if (board[0][i] == player &&
                board[1][i] == player &&
                board[2][i] == player) {

                return true;
            }
        }

        // Check diagonal
        if (board[0][0] == player &&
            board[1][1] == player &&
            board[2][2] == player) {

            return true;
        }

        // Check reverse diagonal
        if (board[0][2] == player &&
            board[1][1] == player &&
            board[2][0] == player) {

            return true;
        }

        return false;
    }

    // Displays the game board
    private static void printBoard() {

        System.out.println("+---+---+---+");

        for (int i = 0; i < board.length; i++) {

            System.out.print("| ");

            for (int j = 0; j < board[i].length; j++) {

                System.out.print(board[i][j] + " | ");
            }

            System.out.println();
            System.out.println("+---+---+---+");
        }
    }
}
