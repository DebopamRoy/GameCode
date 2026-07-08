import java.util.Scanner;

public class TicTacToe {
    Scanner sc;
    private char[][] board;
    private int r, c;
    private char player;
    private int[] winCells;

    TicTacToe() {
        sc = new Scanner(System.in);
        board = new char[3][3];
        r = 0;
        c = 0;
        player = 'X';
        winCells = new int[3];
    }

    public void input() {
        System.out.printf("Player %c : Enter the coordinates : ", player);
        while (true) {
            r = sc.nextInt();
            c = sc.nextInt();
            if (board[r][c] != 'X' && board[r][c] != 'O')
                break;
            System.out.println("Space Occupied");
        }
        board[r][c] = player;
    }

    public boolean checkWin() {
        int i;
        for (i = 0; i < 3; winCells[i] = r * 3 + i, i++)
            if (board[r][i] != player)
                break;
        if (i == 3)
            return true;
        for (i = 0; i < 3; winCells[i] = i * 3 + c, i++)
            if (board[i][c] != player)
                break;
        if (i == 3)
            return true;
        if (r == c) {
            for (i = 0; i < 3; winCells[i] = i * 3 + i, i++)
                if (board[i][i] != player)
                    break;
            if (i == 3)
                return true;
        }
        if (r + c == 2) {
            for (i = 0; i < 3; winCells[i] = i * 3 + 2 - i, i++)
                if (board[i][2 - i] != player)
                    break;
            if (i == 3)
                return true;
        }
        return false;
    }

    public void gameTick() {
        for (int i = 1; i <= 9; i++) {
            input();
            showBoard(false);
            if (checkWin()) {
                showBoard(true);
                displayWin();
            }
            player = player == 'X' ? 'O' : 'X';
        }
        System.out.println("Game Drawn");
    }

    public void showBoard(boolean isWon) {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                boolean found = false;
                if (isWon)
                    for (int f = 0; f < 3; f++)
                        if (winCells[f] == i * 3 + j) {
                            found = true;
                            break;
                        }
                System.out.print(found ? "[" : " ");

                if (board[i][j] == 'X' || board[i][j] == 'O')
                    System.out.print(board[i][j]);
                else
                    System.out.print(" ");

                System.out.print((found ? "]" : " "));
                if (j < 2)
                    System.out.print("|");
            }
            if (i < 2)
                System.out.println("\n---+---+---");
        }
        System.out.println();
    }

    public void displayWin() {
        System.out.printf("Player %c Won!", player);
        System.exit(0);
    }

    public static void main(String[] args) {
        TicTacToe ttt = new TicTacToe();
        ttt.gameTick();
    }
}
