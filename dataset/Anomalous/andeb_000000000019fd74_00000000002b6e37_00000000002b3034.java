import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {

    public static void main(String[] args) throws IOException {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            int cases = Integer.parseInt(reader.readLine());
            for (int cc = 0; cc < cases; cc++) {
                int t = Integer.parseInt(reader.readLine());
                String word = reader.readLine().substring(1);

                for (int i = 1; i < t; i++) {
                    String line = reader.readLine().substring(1);
                    if (word == null) continue;

                    if (line.contains(word)) {
                        word = line;
                    } else if (!word.contains(line)) {
                        word = null;
                    }
                }

                System.out.printf("Case #%d: %s%n", cc + 1, word == null ? "*" : word);
            }
        }
    }
}