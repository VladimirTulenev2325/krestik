import java.util.Scanner;

public class TicTacToe {
    private char[][] board;
    private char currentPlayer;

    public TicTacToe() {
        board = new char[3][3];
        currentPlayer = 'X';
        initializeBoard();
    }

    private void initializeBoard() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                board[i][j] = '-';
            }
        }
    }

    private void printBoard() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }

    private boolean isBoardFull() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i][j] == '-') {
                    return false;
                }
            }
        }
        return true;
    }

    private boolean hasPlayerWon() {
        // Проверка строк и столбцов
        for (int i = 0; i < 3; i++) {
            if (board[i][0] == currentPlayer && board[i][1] == currentPlayer && board[i][2] == currentPlayer) {
                return true;
            }
            if (board[0][i] == currentPlayer && board[1][i] == currentPlayer && board[2][i] == currentPlayer) {
                return true;
            }
        }

        // Проверка диагоналей
        if (board[0][0] == currentPlayer && board[1][1] == currentPlayer && board[2][2] == currentPlayer) {
            return true;
        }
        if (board[0][2] == currentPlayer && board[1][1] == currentPlayer && board[2][0] == currentPlayer) {
            return true;
        }

        return false;
    }

    public void playGame() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Игра начинается! Координаты клетки должны быть от 1 до 3.");
        System.out.println("Игровое поле имеет следующую структуру:");
        System.out.println("1 2 3");
        System.out.println("4 5 6");
        System.out.println("7 8 9");
        System.out.println();

        int moves = 0;

        while (!hasPlayerWon() && !isBoardFull()) {
            System.out.println("Ход игрока " + currentPlayer + ". Введите номер клетки:");
            int move = scanner.nextInt();

            int row = (move - 1) / 3;
            int col = (move - 1) % 3;

            if (board[row][col] == '-') {
                board[row][col] = currentPlayer;
                printBoard();
                moves++;

                if (hasPlayerWon()) {
                    System.out.println("Игрок " + currentPlayer + " победил!");
                } else if (isBoardFull()) {
                    System.out.println("Ничья!");
                } else {
                    currentPlayer = (currentPlayer == 'X') ? 'O' : 'X';
                }
            } else {
                System.out.println("Некорректный ход. Попробуйте еще раз.");
            }
        }

        if (!hasPlayerWon() && isBoardFull()) {
            System.out.println("Ничья!");
        }

        scanner.close();
    }

    public static void main(String[] args) {
        TicTacToe game = new TicTacToe();
        game.playGame();
    }
}