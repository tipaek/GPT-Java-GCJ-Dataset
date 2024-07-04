import java.util.*;
import java.io.*;
public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
        for(int k = 0; k < t; k++){
            int size = in.nextInt();
        int repRow = 0;
        int repCol = 0;
        int trace = 0;
        int[][] arr = new int[size][size];
        for (int i = 0; i < size; i++){
            boolean rowBool = false;
            HashMap<Integer, Integer> rowCheck = new HashMap<>();
            for(int j = 0; j < size; j++){
                int temp = in.nextInt();
                arr[i][j] = temp;
                if(i == j){
                    trace += temp;
                }
                if(!rowBool){
                    if(rowCheck.containsKey(temp)){
                        repRow += 1;
                        rowBool = true;
                    }else{
                        rowCheck.put(temp, 1);
                    }
                }
            }
        }

        for(int i = 0; i < size; i++){
            HashMap<Integer, Integer> colCheck = new HashMap<>();
            for(int j = 0; j < size; j++){
                int temp = arr[j][i];
                if(colCheck.containsKey(temp)){
                    repCol +=1;
                    break;
                }else{
                    colCheck.put(temp,1);
                }
            }
        }
        int c1 = k + 1;
        System.out.println("Case #" + c1 + ": " + trace + " " + repRow + " " + repCol);
        }
    }
}