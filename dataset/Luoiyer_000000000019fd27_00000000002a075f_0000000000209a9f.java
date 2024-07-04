import java.util.*;
import java.io.*;
public class Solution {
      public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testNum =  in.nextInt();
        in.nextLine();
        for(int i = 1; i <= testNum; i++){
            char[] test = in.nextLine().toCharArray();
            String result = "";
            // beginning (
            int n = Character.getNumericValue(test[0]);
            for(int k = 0; k < n; k++){
                result += "(";
            }
            for(int j = 1; j < test.length; j++){
                char toAdd = test[j - 1] < test[j] ? '(' : ')';
                int n = Math.abs(test[j - 1] - test[j]);
                result += test[j - 1];
                for(int k = 0; k < n; k++){
                    result += toAdd;
                }
            }
            // closing )
            result += test[test.length-1];
            int n = Character.getNumericValue(test[test.length-1]);
            for(int k = 0; k < n; k++){
                result += ")";
            }
            System.out.println("Case #" + i + ": " + result);
        }
    }
}