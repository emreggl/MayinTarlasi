import java.util.Random;
import java.util.Scanner;

public class MayinTarlasi {
    int rowNumber, colNumber, size, success = 0;
    int[][] map;
    int[][] board;
    boolean game = true;

    Random rand = new Random();
    Scanner scan = new Scanner(System.in);

    MayinTarlasi(int rowNumber, int colNumber) {
        this.rowNumber = rowNumber;
        this.colNumber = colNumber;
        this.size = rowNumber * colNumber;
        this.map = new int[rowNumber][colNumber];
        this.board = new int[rowNumber][colNumber];
    }

    public void run() {
        prepareGame();
        System.out.println("Oyun başladı!");

        while (game) {
            printMap(board);
            System.out.print("Satır Girin: ");
            int row = scan.nextInt();
            System.out.print("Sütun Girin: ");
            int col = scan.nextInt();

            if (row < 0 || row >= rowNumber || col < 0 || col >= colNumber) {
                System.out.println("Geçersiz koordinat! Lütfen tekrar girin.");
                continue;
            }

            if (map[row][col] == -1) {
                System.out.println("Game Over!");
                game = false;
                break;
            } else {
                check(row, col);
                success++;
                if (success == size - (size / 4)) {
                    System.out.println("Tebrikler! Oyunu kazandınız!");
                    break;
                }
            }
        }
    }

    public void check(int r, int c) {
        if (board[r][c] == 0) {
            int mines = 0;
            if ((c < colNumber - 1) && (map[r][c + 1] == -1)) mines++;
            if ((r < rowNumber - 1) && (map[r + 1][c] == -1)) mines++;
            if ((r > 0) && (map[r - 1][c] == -1)) mines++;
            if ((c > 0) && (map[r][c - 1] == -1)) mines++;

            board[r][c] = (mines == 0) ? -2 : mines;
        }
    }

    public void prepareGame() {
        int count = 0;
        while (count < (size / 4)) {
            int randRow = rand.nextInt(rowNumber);
            int randCol = rand.nextInt(colNumber);
            if (map[randRow][randCol] != -1) {
                map[randRow][randCol] = -1;
                count++;
            }
        }
    }

    public void printMap(int[][] arr) {
        for (int[] row : arr) {
            for (int cell : row) {
                System.out.print((cell == -1 ? "* " : cell == -2 ? "- " : cell + " "));
            }
            System.out.println();
        }
    }
}
