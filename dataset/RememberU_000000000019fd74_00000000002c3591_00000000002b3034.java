
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;


public class Solution {

    public static void main(String[] args) {
    //    long beginTime = System.nanoTime();
        Scanner input = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = input.nextInt();
        String[] solution = new String[testCases];
        for (int c = 0; c < testCases; c++) {
            int n = input.nextInt();
            String[] pattern = new String[n];
            for (int i = 0; i< n; i++) {
                pattern[i] = input.next();
            }
            sort(pattern);

            if(match(pattern,buildName(pattern))) solution[c] = buildName(pattern);
            else solution[c] = "*";
        }

        for (int i = 0; i < testCases; i++) {
            System.out.format("Case #%d: %s \n", i + 1, solution[i]);
        }
      //  System.err.println("Done in " + ((System.nanoTime() - beginTime) / 1e9) + " seconds.");
    }

    private static String[] sort(String[] x) {

        Arrays.sort(x, new java.util.Comparator<String>() {
            public int compare(String a, String b) {
                return a.length() - b.length();
            }
        });


        return x;
    }

    private static String buildName(String[] x) {
        int ultimul = x.length-1;
        String nameStartL=x[ultimul].substring(0, x[ultimul].indexOf('*'));
        String nameEndL=x[ultimul].substring(x[ultimul].indexOf('*')+1);

        if (nameStartL.equalsIgnoreCase(nameEndL)) return nameStartL;
        else
            return nameStartL+nameEndL;

    }

    private static boolean match(String[] x, String name) {

        for (int i = 0; i< x.length; i++) {
            String start=x[i].substring(0, x[i].indexOf('*'));
            String end=x[i].substring(x[i].indexOf('*')+1);
            if (!(name.startsWith(start) && name.endsWith(end))) return false;
        }
        return true;
    }


}




