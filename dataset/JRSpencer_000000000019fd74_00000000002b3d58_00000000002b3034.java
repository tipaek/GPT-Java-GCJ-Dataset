import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
        for (int i = 1; i <= t; ++i) {
            int n = in.nextInt();
            String word = in.next().substring(1);
            for (int j = 1; j < n; j++) {
                String newWord = in.next().substring(1);
                if (word.contains(newWord)){
                    continue;
                }
                else if(newWord.contains(word)){
                    word = newWord;
                }
                else{
                    word = "*";
                    continue;
                }
            }
            System.out.println(String.format("Case #%d: %s", i, word));
        }
    }
}
