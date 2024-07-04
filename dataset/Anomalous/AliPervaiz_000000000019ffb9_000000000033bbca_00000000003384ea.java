import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter writer = new PrintWriter(System.out);
        int testCases = Integer.parseInt(reader.readLine());

        for (int caseNumber = 1; caseNumber <= testCases; caseNumber++) {
            writer.print("Case #" + caseNumber + ": ");
            StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
            long left = Long.parseLong(tokenizer.nextToken());
            long right = Long.parseLong(tokenizer.nextToken());
            int rounds = 0;

            while (rounds + 1 <= left || rounds + 1 <= right) {
                int currentRound = ++rounds;
                if (left >= right) {
                    left -= currentRound;
                } else {
                    right -= currentRound;
                }
            }

            writer.println(rounds + " " + left + " " + right);
        }

        writer.close();
    }
}