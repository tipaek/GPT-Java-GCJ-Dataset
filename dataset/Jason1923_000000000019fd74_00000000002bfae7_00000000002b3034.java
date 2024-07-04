import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int tests = Integer.parseInt(in.nextLine()); // # of test cases
        for (int t = 1; t <= tests; t++) {
            // Create String array
            int n = Integer.parseInt(in.nextLine());
            StringBuilder[] strings = new StringBuilder[n];
            for (int i = 0; i < n; i++)
                strings[i] = new StringBuilder(in.nextLine());

            // Create buckets
            int count = 0;
            int maxStar = 0;
            for (StringBuilder str : strings) {
                for (int i = 0; i < str.length(); i++) {
                    if (str.charAt(i) == '*')
                        count++;
                }
                if (count > maxStar)
                    maxStar = count;
                count = 0;
            }
            StringBuilder[] buckets = new StringBuilder[maxStar + 1];
            Arrays.fill(buckets, new StringBuilder(""));

            // Solve
            for (StringBuilder str : strings) {
                // First bucket
                String substring = str.substring(0, str.indexOf("*"));
                str.delete(0, str.indexOf("*") + 1);
                if (buckets[0].toString().contains(substring))
                    buckets[0] = buckets[0]; // Do nothing
                else if (substring.contains(buckets[0].toString()))
                    buckets[0] = new StringBuilder(substring);
                else {
                    System.out.println("*");
                    return; // Not possible
                }

                // Middle buckets
                int idx = 1;
                while (str.indexOf("*") != -1) {
                    substring = str.substring(0, str.indexOf("*"));
                    str.delete(0, str.indexOf("*") + 1);
                    buckets[idx] = new StringBuilder(buckets[idx] + substring);
                    idx++;
                }

                // Last bucket
                substring = str.substring(0, str.length());
                if (buckets[maxStar].toString().contains(substring))
                    buckets[maxStar] = buckets[maxStar]; // Do nothing
                else if (substring.contains(buckets[maxStar].toString()))
                    buckets[maxStar] = new StringBuilder(substring);
                else {
                    System.out.println("*");
                    return; // Not possible
                }
            }

            for (StringBuilder str : buckets)
                System.out.print(str);
            System.out.println();
        }
    }
}