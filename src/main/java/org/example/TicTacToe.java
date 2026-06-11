package org.example;

import java.util.Scanner;

public class TicTacToe {
    private Player player1;
    private Player player2;
    private Player currentPlayer;
    private Board board;

    public TicTacToe() {
        player1 = new Player('X');
        player2 = new Player('O');
        currentPlayer = player1;
        board = new Board();
    }

    public Board getBoard() {
        return board;
    }

    public Player getCurrentPlayer() {
        return currentPlayer;
    }

    public void reset() {
        board.clear();
        currentPlayer = player1;
    }

    public void start() {
        Scanner sc = new Scanner(System.in);
        do {
            reset();
            playRound(sc);
            System.out.print("Play again? (y/n): ");
        } while (sc.nextLine().trim().equalsIgnoreCase("y"));
        System.out.println("Thanks for playing!");
        sc.close();
    }

    private void playRound(Scanner sc) {
        while (!hasWinner() && !board.isFull()) {
            System.out.println("Current Player: " + currentPlayer.getMarker());
            board.print();

            int x = readCoordinate(sc, "row (0-2): ");
            if (x == -1) continue;
            int y = readCoordinate(sc, "column (0-2): ");
            if (y == -1) continue;

            if (!board.isCellEmpty(x, y)) {
                System.out.println("Cell already taken, try again.");
                continue;
            }
            board.place(x, y, currentPlayer.getMarker());
            if (!hasWinner()) {
                switchCurrentPlayer();
            }
        }
        board.print();
        if (hasWinner()) {
            System.out.println("Player " + currentPlayer.getMarker() + " wins!");
        } else {
            System.out.println("It's a draw!");
        }
    }

    private int readCoordinate(Scanner sc, String prompt) {
        System.out.print(prompt);
        String input = sc.nextLine().trim();
        int value;
        try {
            value = Integer.parseInt(input);
        } catch (NumberFormatException e) {
            System.out.println("Invalid input: " + input + ". Enter 0, 1, or 2.");
            return -1;
        }
        if (value < 0 || value > 2) {
            System.out.println("Out of range: " + value + ". Enter 0, 1, or 2.");
            return -1;
        }
        return value;
    }

    public void switchCurrentPlayer() {
        currentPlayer = (currentPlayer == player1) ? player2 : player1;
    }

    public boolean hasWinner() {
        char[][] c = board.getCells();
        char m = currentPlayer.getMarker();
        for (int i = 0; i < 3; i++) {
            if (c[i][0] == m && c[i][1] == m && c[i][2] == m) return true;
            if (c[0][i] == m && c[1][i] == m && c[2][i] == m) return true;
        }
        if (c[0][0] == m && c[1][1] == m && c[2][2] == m) return true;
        if (c[0][2] == m && c[1][1] == m && c[2][0] == m) return true;
        return false;
    }

    public static void main(String[] args) {
        new TicTacToe().start();
    }
}