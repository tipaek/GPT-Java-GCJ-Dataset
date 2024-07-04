import java.util.HashSet;
import java.util.Scanner;

public class Solution {
    public static void print(int[][] square, int size){
        for(int i = 0; i < size; i ++){
            for(int j = 0; j < size; j ++){
                System.out.print(square[i][j] + " ");
            }
            System.out.println("");
        }

    }

    public static void process(int[][] square, int size, int testCase){
        int trace = 0;
        int repeatRow = 0;
        int repeatCol = 0;
        HashSet<Integer> takenRow = new HashSet<>();
        HashSet<Integer> takenCol = new HashSet<>();
        int orgRow;
        int orgCol;

        //trace
        for(int a = 0; a < size; a ++){
            trace = trace + square[a][a];
        }

        //row
        for(int i = 0; i < size; i ++){
            for(int j = 0; j < size; j ++){
                orgRow = takenRow.size();
                takenRow.add(square[i][j]);

                if(takenRow.size() == orgRow){
                    repeatRow ++;
                    j = size;
                }
            }
            takenRow = new HashSet<>();
        }
        //col
        for(int i = 0; i < size; i ++){
            for(int j = 0; j < size; j ++){
                orgCol = takenCol.size();

                takenCol.add(square[j][i]);

                if(takenCol.size() <= orgCol){
                    repeatCol ++;
                    j = size;
                }
            }
            takenCol = new HashSet<>();
        }

        System.out.println("Case " + "#" + testCase + ": " + trace + " " + repeatRow + " " + repeatCol);

    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int T = Integer.parseInt(input.next());
        int size;
        int[][] square;


        for(int i = 0; i < T; i ++){
            size = Integer.parseInt(input.next());
            square = new int[size][size];

            //fill in square
            for(int row = 0; row < size; row ++){
                for(int col = 0; col < size; col ++){
                    square[row][col] = Integer.parseInt(input.next());
                }
            }
            process(square, size, i);
        }


    }
}