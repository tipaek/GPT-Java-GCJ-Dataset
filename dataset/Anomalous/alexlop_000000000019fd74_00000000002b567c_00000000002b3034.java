import java.util.*;
import java.io.*;

public class Solution {

    public static void myFunction(String[] words, int caseNum) {
        Arrays.sort(words, Comparator.comparingInt(String::length));

        String longest = words[words.length - 1].substring(1);

        for (int i = 0; i < words.length - 1; i++) {
            String shortWord = words[i].substring(1);
            int start = longest.length() - shortWord.length();
            if (!shortWord.equals(longest.substring(start))) {
                System.out.println("Case #" + caseNum + ": *");
                return;
            }
        }

        System.out.println("Case #" + caseNum + ": " + longest);
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt();
        in.nextLine(); // Consume the newline character after the integer input
        for (int i = 0; i < t; i++) {
            int n = in.nextInt();
            in.nextLine(); // Consume the newline character after the integer input
            String[] words = new String[n];
            for (int k = 0; k < n; k++) {
                words[k] = in.nextLine();
            }
            myFunction(words, i + 1); // Case numbers are usually 1-based
        }
        in.close();
    }
}