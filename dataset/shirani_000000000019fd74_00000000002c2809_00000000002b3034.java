
import java.util.*;


import java.io.*;

public class Solution {
    public static int findindexlongeststring(String[] x){
        int result = 0;
        int maxlength = 0;
        String longesstring = null;
        for (int i = 0; i < x.length; i++){
            if (x[i].length() > maxlength){
                maxlength = x[i].length();
                result = i;
                longesstring = x[i];
            }
        }
        return result;
    }
    public static String findword(String[] a){

        int longest = findindexlongeststring(a);
        int lengthlong = a[longest].length();
        for (int i = 0; i < a.length; i++){
            String test = a[i].substring(1);
            int testlength = test.length();
            int index = lengthlong - testlength;

            if (!test.equals(a[longest].substring(index, lengthlong))){
                return "*";
            }
        }
        return a[longest].substring(1);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int cases = Integer.parseInt(sc.nextLine());
        for (int i = 1; i <= cases; i++){
            int rows = Integer.parseInt(sc.nextLine());
            String[] aster = new String[rows];
            for (int j = 0; j < rows; j++){
                String line = sc.nextLine();
                aster[j] = line;
            }
            System.out.println("Case #" + String.valueOf(i) + ": " + findword(aster));
        }
    }
}