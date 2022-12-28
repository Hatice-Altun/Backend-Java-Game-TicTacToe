package com.altun.Java;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        // Step 1: Create the board
        // Step 2: Give the player the opportunity to choose: X or O
        // Step 3: Check if a player has won
        // Step 4: Give an other player the opportunity to play as : O
        // Step 5: Check if the player has won
        // Step 6: Repeat all steps from 2 to step 5
        System.out.println("Welcome");

        String[] board = new String[9];

        for(int i = 0; i < 9; i++){
            board[i] = Integer.toString(i);
            System.out.println(board[i]);
        }

        // Display the board
        printBoard(board);

        Player playerA = new Player("Cross", "X");
        Player playerB = new Player("Circle", "O");

        Player currentPlayer = playerA;
        boolean hasWon = false;

        while (hasWon == false) {
            System.out.println("\n Enter a number from 0 through 9 to put an " + currentPlayer.getName() + " on the board.");

            Scanner userInput = new Scanner(System.in);
            int selectedField = userInput.nextInt();

            board[selectedField] = currentPlayer.getToken();

            // Display board
            printBoard(board);

            hasWon = hasPlayerWon(board, currentPlayer.getToken());

            // Switch Player
            currentPlayer = switchPlayer(currentPlayer, playerA, playerB);
        }

        System.out.println("  Congratulations! " + currentPlayer.getName() + " you won!");
    }

    public static void printBoard(String[] board) {
        // Display the board
        for (int i = 0; i < board.length; i++){
            System.out.print(board[i]);
            boolean isEndOfRow = (i + 1) % 3 == 0;
            boolean isLastField = i == 8;

            if (isEndOfRow == false){
                System.out.print(" | ");
            }
            if (isEndOfRow && !isLastField){
                System.out.println("\n _________");
            }
        }

    }

    public static Player switchPlayer(Player currentPlayer, Player PlayerA, Player PlayerB) {
        if (currentPlayer.getToken() == "X"){
            return PlayerB;
        }
        else {
            return PlayerA;
        }
    }

    public static boolean hasPlayerWon(String[] board, String currentPlayer) {
        // Horizontal options to win
        if (board[0] == currentPlayer && board[1] == currentPlayer && board[2] == currentPlayer){
            return true;
        }
        if (board[3] == currentPlayer && board[4] == currentPlayer && board[5] == currentPlayer){
            return true;
        }
        if (board[6] == currentPlayer && board[7] == currentPlayer && board[8] == currentPlayer){
            return true;
        }

        // Vertical options to win
        if (board[0] == currentPlayer && board[3] == currentPlayer && board[6] == currentPlayer){
            return true;
        }
        if (board[1] == currentPlayer && board[4] == currentPlayer && board[7] == currentPlayer){
            return true;
        }
        if (board[2] == currentPlayer && board[5] == currentPlayer && board[8] == currentPlayer){
            return true;
        }

        // Diagonal options to win
        if (board[0] == currentPlayer && board[4] == currentPlayer && board[8] == currentPlayer){
            return true;
        }
        if (board[6] == currentPlayer && board[4] == currentPlayer && board[2] == currentPlayer){
            return true;
        }

    return false;
    }
}

