import java.util.*;
import java.io.*;

public class Solution {
    public String nests(int num) {
        String nest = "";
        if (num > 0) {
            for (int i = 0; i < num; i++) {
                nest = nest + "(";
            }
        }
        else if (num < 0) {
            for (int i = 0; i < -num; i++) {
                nest = nest + ")";
            }
        }
        return nest;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt();
        Solution solve = new Solution();

        String[] answer = new String[t];

        for (int i = 0; i < t; i++) {

            String str = in.next();

            int[] array = new int[str.length() + 1];

            for (int j = 0; j < array.length; j++) {
                if (j == array.length - 1) array[j] = -1 * ((int) str.charAt(j - 1) - 48);

                else if (j == 0) array[0] = str.charAt(j) - 48;

                else array[j] = (int) str.charAt(j) - (int) str.charAt(j - 1);

            }

            answer[i] = "";

            for (int j = 0; j < array.length; j++) {
                if (j == array.length - 1) answer[i] = answer[i] + solve.nests(array[j]);
                else answer[i] = answer[i] + solve.nests(array[j]) + str.charAt(j);
            }
        }
        
        for(int i = 0; i < t; i++){
            System.out.println("Case #" + (i+1) + ": " + answer[i]);
        }

    }
}