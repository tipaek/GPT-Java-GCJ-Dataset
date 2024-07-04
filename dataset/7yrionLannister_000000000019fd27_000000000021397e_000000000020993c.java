//package quickCodeJam;

//import java.util.HashMap;
//import java.util.Scanner;

public class JustAClass {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int ii = 0;
        while(ii<n) {
            int size = s.nextInt();
            int[][] matrix = new int[size][size];
            int sum = 0;
            int badRows = 0;
            int badCols = 0;
            for(int i = 0; i < size; i++) {
            	HashMap<Integer,Integer> rowUniques = new HashMap<>();
                boolean badRow = false;
                for(int j = 0; j < size; j++) {
                    matrix[i][j] = s.nextInt();
                    if(i==j) {
                        sum += matrix[i][j];
                    }
                    badRow = badRow | rowUniques.put(matrix[i][j], 1) != null;
                }
                if(badRow) {
                    badRows++;
                }
            }
            for(int j = 0; j<size;j++) {
                HashMap<Integer,Integer> colUniques = new HashMap<>();
                boolean badCol = false;
                for(int i = 0; i < size & !badCol; i++) {
                    badCol = badCol | colUniques.put(matrix[i][j], 1) != null;
                }
                if(badCol) {
                    badCols++;
                }
            }
            System.out.println("Case #"+(1+ii)+": "+sum+" "+badRows+" "+badCols);
            ii++;
        }
    }
}