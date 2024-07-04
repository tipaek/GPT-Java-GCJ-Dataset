import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
        for (int i = 1; i <= t; ++i) {
            int n = in.nextInt();
            String[] strings = new String[n];

            for (int j = 0; j < n; j++) {
                strings[j] = in.next().substring(1);
            }
            String word = strings[0];
            for (int j = 1; j < n; j++) {
                String newWord = strings[j];
                if (word.endsWith(newWord)){
                    continue;
                }
                else if(newWord.endsWith(word)){
                    word = newWord;
                }
                else{
                    word = "*";
                }
            }
            System.out.println(String.format("Case #%d: %s", i, word));
        }
    }
}
