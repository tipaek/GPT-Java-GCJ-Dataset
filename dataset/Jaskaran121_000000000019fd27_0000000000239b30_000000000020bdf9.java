import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;

public class Solution {
    public static String calculate(int[][] array){
        if(array.length==0) return "IMPOSSIBLE";
        String[] result = new String[array.length];
        result[0] = "C";
        String conflictedWith = "";
        int conflicts;
        for(int i=1;i<array.length;i++){
            int start = array[i][0];
            int end = array[i][1];
            conflicts = 0;
            for(int j = i-1 ; j>=0;j--) {
                if((array[j][0]<=start && start<array[j][1]) || (array[j][0]<end && end<=array[j][1])
                || (start<array[j][0] && end>array[j][1]) || (array[j][0]==start && end==array[j][1])) {
                    conflicts++;
                    conflictedWith = result[j];
                }
                if (conflicts > 1)
                    return "IMPOSSIBLE";
            }
            if(conflicts == 0)
                result[i]="C";
            else if(conflicts == 1)
            {
                result[i] = conflictedWith == "J" ? "C" : "J";
            } else return "IMPOSSIBLE";
        }
        return Arrays.toString(result);
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
        String[] result = new String[t];
        for (int i = 0; i <t; i++) {
            int size = in.nextInt();
            int[][] array = new int[size][2];
            for(int j=0;j<size;j++){
                for(int k= 0;k<2;k++){
                    array[j][k] = in.nextInt();
                }
            }
            result[i] = calculate(array);

        }
            for(int i=1;i<=t;i++){
                System.out.print("Case #" + i + ": " + result[i-1].replaceAll("[^a-zA-Z0-9]", ""));
                if(i!=t)
                    System.out.println("");
            }
        }

    }
