import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int testCases = Integer.parseInt(reader.readLine());

        for (int t = 1; t <= testCases; t++) {
            int U = Integer.parseInt(reader.readLine());

            int[][] frequency = new int[16][10];
            Map<Character, Integer> charToIndex = new HashMap<>();
            Map<Integer, Character> indexToChar = new HashMap<>();
            int currentIndex = 0;

            for (int i = 0; i < 10000; i++) {
                StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
                long M = Long.parseLong(tokenizer.nextToken());
                String R = tokenizer.nextToken();
                char firstChar = R.charAt(0);

                if (!charToIndex.containsKey(firstChar)) {
                    charToIndex.put(firstChar, currentIndex);
                    indexToChar.put(currentIndex, firstChar);
                    currentIndex++;
                }

                if (currentIndex == 9) {
                    for (char c : R.toCharArray()) {
                        if (!charToIndex.containsKey(c)) {
                            charToIndex.put(c, currentIndex);
                            indexToChar.put(currentIndex, c);
                            currentIndex++;
                        }
                    }
                }

                frequency[R.length() - 1][charToIndex.get(firstChar)]++;
            }

            StringBuilder result = new StringBuilder();
            boolean[] used = new boolean[10];

            for (int i = 15; i >= 0; i--) {
                PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> -a[0]));

                for (int j = 0; j < 10; j++) {
                    pq.add(new int[]{frequency[i][j], j});
                }

                while (!pq.isEmpty()) {
                    int[] entry = pq.poll();
                    if (entry[0] == 0) {
                        if (i == 0) {
                            if (!used[entry[1]]) {
                                result.insert(0, indexToChar.get(entry[1]));
                                break;
                            }
                        } else {
                            break;
                        }
                    } else if (!used[entry[1]]) {
                        result.append(indexToChar.get(entry[1]));
                        used[entry[1]] = true;
                    }
                }
            }

            System.out.println("Case #" + t + ": " + result);
        }
    }
}