import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

class Pair {
    int first;
    int second;

    Pair(int first, int second) {
        this.first = first;
        this.second = second;
    }
}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        for (int tt = 1; tt <= t; tt++) {
            String[] st = br.readLine().split(" ");
            int x = Integer.parseInt(st[0]);
            int y = Integer.parseInt(st[1]);
            String s = st[2];

            ArrayList<Pair> positions = new ArrayList<>();
            positions.add(new Pair(x, y));

            int n = s.length();
            int[] stepCost = new int[n + 1];
            int[] distanceCost = new int[n + 1];
            stepCost[0] = 0;

            int currentX = x;
            int currentY = y;

            for (int i = 0; i < n; i++) {
                stepCost[i + 1] = i + 1;

                switch (s.charAt(i)) {
                    case 'N':
                        currentY += 1;
                        break;
                    case 'S':
                        currentY -= 1;
                        break;
                    case 'E':
                        currentX += 1;
                        break;
                    case 'W':
                        currentX -= 1;
                        break;
                }

                positions.add(new Pair(currentX, currentY));
            }

            for (int i = 0; i < positions.size(); i++) {
                Pair pos = positions.get(i);
                distanceCost[i] = Math.abs(pos.first) + Math.abs(pos.second);
            }

            int result = Integer.MAX_VALUE;
            for (int i = 0; i <= n; i++) {
                if (distanceCost[i] <= stepCost[i]) {
                    result = Math.min(result, stepCost[i]);
                }
            }

            if (result == Integer.MAX_VALUE) {
                System.out.println("Case #" + tt + ": IMPOSSIBLE");
            } else {
                System.out.println("Case #" + tt + ": " + result);
            }
        }
    }
}