import java.io.*;
import java.util.*;

public class Solution3 {

        public static void main (String[]args) {

            class Dancer {
                public int x;
                public int y;
                private int number;
                public double avg;

                // Constructor
                public Dancer(int x, int y, int[][] board) {
                    this.x = x;
                    this.y = y;
                    this.number = board[x][y];
                    this.avg = calAvg(x, y, board);
                }
            }


            Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
            String arg = scanner.nextLine();


            int t = Integer.parseInt(arg);
            int[] sums = new int[t];

            String[][] inputCollector = new String[t][];

            for (int i = 0; i < t; i++) {
                String nextLine = scanner.nextLine();
                String[] lineParsed = nextLine.split(" ");
                int[] array = Arrays.stream(lineParsed).mapToInt(Integer::parseInt).toArray();
                Dancer[][] board = new Dancer[array[0]][array[1]];
                int[][] boardInt = new int[array[0]][array[1]];

                for (int k = 0; k < array[0]; k++) { //create board
                    nextLine = scanner.nextLine();
                    lineParsed = nextLine.split(" ");
                    array = Arrays.stream(lineParsed).mapToInt(Integer::parseInt).toArray();
                    boardInt[k] = array.clone();
                }


                int r = board.length;
                int c = board[0].length;

                int sum = 0;
                int oldval = 0;
                int newVal = -1;
                while (true){
                    oldval = newVal;
                    
                    for (int p=0; p<r; p++ ) {
                        for (int j = 0; j < r; j++) {
                            board[p][j] = new Dancer(p, j,boardInt);
                        }
                    }


                    newVal = sumUp(boardInt);
                    if (oldval == newVal){
                        break;
                    } else {
                        sum = sum + newVal;
                        for (int p = 0; p < r; p++) {
                            for (int j = 0; j < r; j++) {
                                if (board[p][j].avg > board[p][j].number) {
                                    boardInt[p][j] = -1;
                                }
                            }
                        }
                    }
                }
                sums[i] = sum;
            }





            for (int i = 0; i < t; i++) {
                //body of solution:
                int caseNum = i+1;
                System.out.println("Case #" + (caseNum) + ": " + sums[i]);

            }
        }

    private static int sumUp(int[][] boardInt) {
        int r = boardInt.length;
        int c = boardInt[0].length;
            int sum = 0;
        for (int p=0; p< r; p++ ) {
            for (int j = 0; j < r; j++) {
                if (boardInt[p][j] != -1) {
                    sum = sum + boardInt[p][j];
                }
            }
        }
        return sum;
    }


    private static double calAvg(int x, int y, int[][] board) {
        int counter = 0;
        int sum = 0;
        double avg = -1;

        int r = board.length;
        int c = board[0].length;
        int a = x;
        int b = y;

        int i=1;
        int j=0;
        a = a + i;
        b = b + j;
        while (a < r && b <c){
            if (board[a][b] != -1){
                counter ++;
                sum += board[x + i][x+j];
            } else {
                a += i;
                b += j;
            }
        }

        i= -1;
        j=0;
        a = a + i;
        b = b + j;
        while (0 <= a && 0<=b && a < r  && b <c){
            if (board[a][b] != -1){
                counter ++;
                sum += board[x + i][x+j];
            } else {
                a += i;
                b += j;
            }
        }

        i=0;
        j=1;
        a = a + i;
        b = b + j;
        while (a < r && b <c){
            if (board[a][b] != -1){
                counter ++;
                sum += board[x + i][x+j];
            } else {
                a += i;
                b += j;
            }
        }

        i=0;
        j= -1;
        a = a + i;
        b = b + j;
        while (a < r && b <c){
            if (board[a][b] != -1){
                counter ++;
                sum += board[x + i][x+j];
            } else {
                a += i;
                b += j;
            }
        }








        if (counter != 0){
            avg = sum / counter;
        }

        return avg;
    }


}
