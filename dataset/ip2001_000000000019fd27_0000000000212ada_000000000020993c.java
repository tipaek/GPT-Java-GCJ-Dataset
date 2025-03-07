import java.util.*;
import java.io.*;

public class Solution {

    
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int[][][] triangles = new int[scanner.nextInt()][][];

        for (int i = 0; i < triangles.length; i++) {
            int rows = scanner.nextInt();
            triangles[i] = new int[rows][rows];
            for (int j = 0; j < rows; j++) {
                for (int k = 0; k < rows; k++) {
                    triangles[i][k][j] = scanner.nextInt();

                }
            }
        }

        for (int i = 0; i < triangles.length; i++) {
            System.out.print("Case #" + (i + 1) + " ");
            printInfo(triangles[i]);
        }

    }

    public static void printInfo(int[][] triangleArray) {
        int trace = 0;
        int columnRepeat = 0;
        int rowRepeat = 0;

        for (int i = 0; i < triangleArray.length; i++) {
            trace += triangleArray[i][i];
        }


        for (int i = 0; i < triangleArray.length; i++) {
            HashMap<Integer, Integer> hashmap = new HashMap();
            for (int j = 0; j < triangleArray.length; j++) {
                if (hashmap.containsValue(triangleArray[i][j])) {
                    rowRepeat++;
                    break;

                } else {
                    hashmap.putIfAbsent(j, triangleArray[i][j]);
                }

            }
        }

        for (int i = 0; i < triangleArray.length; i++) {
            HashMap<Integer, Integer> hashmap = new HashMap();
            for (int j = 0; j < triangleArray.length; j++) {
                if (hashmap.containsValue(triangleArray[j][i])) {
                    columnRepeat++;
                    break;

                } else {
                    hashmap.putIfAbsent(i, triangleArray[j][i]);
                }

            }
        }
        
        System.out.print(trace + " " + columnRepeat +  " " + rowRepeat + "\n");
        

    }

}