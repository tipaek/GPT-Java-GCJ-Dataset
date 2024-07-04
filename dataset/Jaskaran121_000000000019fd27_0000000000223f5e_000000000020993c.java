import java.util.*;
import java.io.*;

public class Solution {

    public static String numOfRows(int[][] array){
        int trace = 0,count_rows =0,count_cols=0;
        HashSet<Integer> hashSet;
        HashSet<Integer> hashSet1;
        for(int j=0;j<array.length;j++){
            hashSet = new HashSet<Integer>();
            hashSet1 = new HashSet<Integer>();
            for(int k= 0;k<array.length;k++){
                hashSet.add(array[j][k]);
                hashSet1.add(array[k][j]);
                if(j == k)
                    trace = trace + array[j][k];
            }
            if(hashSet.size() !=array.length) count_rows++;
            if(hashSet1.size() !=array.length) count_cols++;
        }
        return trace + " " +count_rows + " "+ count_cols + "";
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
        String[] result = new String[t];
        for (int i = 0; i <t; i++) {
            int size = in.nextInt();
            int[][] array = new int[size][size];
            for(int j=0;j<size;j++){
                for(int k= 0;k<size;k++){
                    array[j][k] = in.nextInt();
                }
            }
            result[i] = numOfRows(array);
        }
        
        for(int i=1;i<=t;i++){
            System.out.println("Case #" + i + ": " + result[i-1]);
            if(i!=t)
                System.out.println("");
        }
    }
}