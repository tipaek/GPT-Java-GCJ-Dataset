import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Solution {

    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(in.readLine());

        for (int t = 1; t <= T; t++) {
            int U = Integer.parseInt(in.readLine());
            int[][] count = new int[16][10];
            HashMap<Character, Integer> charToIndexMap = new HashMap<>();
            HashMap<Integer, Character> indexToCharMap = new HashMap<>();
            int currentIndex = 0;

            for (int x = 0; x < 10000; x++) {
                StringTokenizer st = new StringTokenizer(in.readLine());
                long M = Long.parseLong(st.nextToken());
                String R = st.nextToken();
                char firstChar = R.charAt(0);

                if (!charToIndexMap.containsKey(firstChar)) {
                    charToIndexMap.put(firstChar, currentIndex);
                    indexToCharMap.put(currentIndex, firstChar);
                    currentIndex++;
                }

                if (currentIndex == 9) {
                    for (int i = 0; i < R.length(); i++) {
                        char currentChar = R.charAt(i);
                        if (!charToIndexMap.containsKey(currentChar)) {
                            charToIndexMap.put(currentChar, currentIndex);
                            indexToCharMap.put(currentIndex, currentChar);
                            currentIndex++;
                        }
                    }
                }

                count[R.length() - 1][charToIndexMap.get(firstChar)]++;
            }

            StringBuilder D = new StringBuilder();
            boolean[] used = new boolean[10];

            for (int i = 15; i >= 0; i--) {
                PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> b[0] - a[0]);

                for (int j = 0; j < 10; j++) {
                    pq.add(new int[]{count[i][j], j});
                }

                while (!pq.isEmpty()) {
                    int[] top = pq.poll();
                    if (top[0] == 0) {
                        if (i == 0 && !used[top[1]]) {
                            D.insert(0, indexToCharMap.get(top[1]));
                        }
                        break;
                    }

                    if (!used[top[1]]) {
                        D.append(indexToCharMap.get(top[1]));
                        used[top[1]] = true;
                    }
                }
            }

            System.out.println("Case #" + t + ": " + D.toString());
        }
    }
}