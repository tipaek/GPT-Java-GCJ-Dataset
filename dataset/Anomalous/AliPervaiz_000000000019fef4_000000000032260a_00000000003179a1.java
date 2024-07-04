import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Solution {

    public static class Letter implements Comparable<Letter> {
        char character;
        long frequency;

        public Letter(char character, long frequency) {
            this.character = character;
            this.frequency = frequency;
        }

        @Override
        public int compareTo(Letter other) {
            return Long.compare(other.frequency, this.frequency);
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader inputReader = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter outputWriter = new PrintWriter(System.out);
        int testCases = Integer.parseInt(inputReader.readLine());

        for (int t = 1; t <= testCases; t++) {
            outputWriter.print("Case #" + t + ": ");
            int U = Integer.parseInt(inputReader.readLine());
            long[] frequencies = new long[26];
            boolean[] isFirstCharacter = new boolean[26];

            for (int i = 0; i < 10000; i++) {
                StringTokenizer tokenizer = new StringTokenizer(inputReader.readLine());
                long Q = Long.parseLong(tokenizer.nextToken());
                String R = tokenizer.nextToken();
                isFirstCharacter[R.charAt(0) - 'A'] = true;

                for (int c = 0; c < R.length(); c++) {
                    frequencies[R.charAt(c) - 'A'] += Math.pow(10, R.length() - c - 1);
                }
            }

            PriorityQueue<Letter> priorityQueue = new PriorityQueue<>();
            StringBuilder answer = new StringBuilder();

            for (int i = 0; i < 26; i++) {
                if (frequencies[i] != 0) {
                    if (!isFirstCharacter[i]) {
                        answer.append((char) ('A' + i));
                    } else {
                        priorityQueue.add(new Letter((char) ('A' + i), frequencies[i]));
                    }
                }
            }

            for (int i = 0; i < 9; i++) {
                answer.append(priorityQueue.poll().character);
            }

            outputWriter.println(answer.toString());
        }

        outputWriter.flush();
        outputWriter.close();
    }
}