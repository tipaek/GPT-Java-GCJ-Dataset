import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Solution {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int cases = Integer.parseInt(reader.readLine());
        for (int cc = 0; cc < cases; cc++) {
            int t = Integer.parseInt(reader.readLine());

            String word = "";
            for (int i = 0; i < t; i++) {
                String line = reader.readLine().substring(1);
                if (word == null) continue;

                if (line.endsWith(word)) {
                    word = line;
                } else if (!word.endsWith(line)) {
                    word = null;
                }
            }

            System.out.printf("Case #%d: %s%n", cc + 1, word == null ? "*" : word);
        }
    }
}
