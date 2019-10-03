import java.util.Random;
import java.util.Scanner;

public class BattleShipApp {

    private int[][] board;
    private int size;
    private int shipCount;

    public BattleShipApp(int size) {
        this.size = size;
        shipCount = 3;
        board = new int[this.size][this.size]; //make the board square
        emptyBoard();
        generateShipPositions();
    }

    private void generateShipPositions() {
        Random random = new Random();
        for (int i = 0; i < shipCount; i++){
            int x = random.nextInt(size);   //limits ships to boundaries of board
            int y = random.nextInt(size);   //limits ships to boundaries of board
            board[x][y] = 1;
        }
    }

    private boolean fire(int x, int y){
        if(board[y][x] == 1) { //board represented in memory in opposite way from [x][y]
            board[y][x] = 0;
            System.out.println("You sunk a battleship!");
            shipCount--;
            return true;
        }
        System.out.println("You missed");
        return false;
    }

    private void emptyBoard() {
        for (int i = 0; i < size; i++){
            for (int j = 0; j < size; j++){
                board[i][j] = 0;
            }
        }
    }

    public void play() {
        Scanner scanner = new Scanner(System.in);
        displayBoard();
        while(!gameOver()){
            System.out.println("X Coordinate: ");
            int x = scanner.nextInt();
            System.out.println("Y Coordinate: ");
            int y = scanner.nextInt();
            fire(x,y);
            displayBoard();
        }
        System.out.println("You won!");
    }

    private boolean gameOver() {
        return shipCount == 0;      //if shipCount > 0, this will return false.
    }

    private void displayBoard() {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                System.out.print(board[i][j] + "|");
            }
            System.out.println();
        }
    }
}
