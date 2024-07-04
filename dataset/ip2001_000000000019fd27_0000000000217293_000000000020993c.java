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
            if (i != triangles.length - 1) {
                System.out.print("\n");
            }

        }

    }

    public static void printInfo(int[][] triangleArray) {
        int trace = 0;
        int columnRepeat = 0;
        int rowRepeat = 0;

        for (int i = 0; i < triangleArray.length; i++) {
            trace += triangleArray[i][i];
        }

        
        for(int i = 0; i < triangleArray.length; i++){
            HashMap<Integer, Integer> hashMap = new HashMap<>();
            for(int j = 0; j < triangleArray.length; j++){
                if(hashMap.containsValue(triangleArray[i][j])){
                    columnRepeat++;
                    break;
                } else {
                    hashMap.put(j, triangleArray[i][j]);
                }
                               
                
            }
            
        }
        
        
        
        for(int j = 0; j < triangleArray.length; j++){
            HashMap<Integer, Integer> hashMap = new HashMap<>();
            for(int i = 0; i < triangleArray.length; i++){
                if(hashMap.containsValue(triangleArray[i][j])){
                    rowRepeat++;
                    break;
                } else{
                    hashMap.put(i, triangleArray[i][j]);
                }
                
                
                
                
            }
            
            
        }



        System.out.print(trace + " " + rowRepeat + " " + columnRepeat);

    }

}
