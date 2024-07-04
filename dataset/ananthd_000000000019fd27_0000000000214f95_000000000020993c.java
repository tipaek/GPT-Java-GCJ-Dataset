import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt();
        int[][] array = new int[100][100];

        for (int i = 1; i <= t; ++i) {
            int sum = 0;
            int badRows = 0;
            int badCols = 0;
            int arraySize = in.nextInt();
            for(int j = 0; j < arraySize; j++){
                HashSet<Integer> row = new HashSet<>();
                boolean found = false;
                for (int k = 0; k < arraySize; k++) {
                    int val = in.nextInt();
                    if(!found) {
                        if (row.contains(val)) {
                            badRows++;
                            found = true;
                        }
                    }
                    array[j][k] = val;
                    if (j == k){
                        sum+=val;
                    }
                    row.add(val);
                }
            }
            for (int j = 0; j < arraySize; j++) {
                HashSet<Integer> col = new HashSet<>();
                for (int k = 0; k < arraySize; k++) {
                    int val = array[k][j];
                    if (col.contains(val)){
                        badCols++;
                        break;
                    }
                    col.add(val);
                }
            }
//            for (int j = 0; j < array.length; j++) {
//                for (int k = 0; k < array.length; k++) {
//                    System.out.print(array[j][k]);
//                }
//                System.out.println();
//            }
            System.out.println("Case #" + i +": "+sum+" "+badRows+" "+badCols);
        }
    }
}