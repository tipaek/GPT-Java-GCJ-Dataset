import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Solution {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < t; i++) {
            String[] input = br.readLine().split(" ");
            int x = Integer.parseInt(input[0]);
            int y = Integer.parseInt(input[1]);
            String path = input[2];
            int time = 0;
            int meetiTime = -1;

            for (int j = 0; j < path.length(); j++) {
                switch (path.charAt(j)) {
                    case 'N': y++; break;
                    case 'E': x++; break;
                    case 'S': y--; break;
                    case 'W': x--; break;
                }

                int dist = Math.abs(x) + Math.abs(y);
                time++;

                if (time >= dist) {
                    meetiTime = time;
                    break;
                }
            }

            if (meetiTime != -1) {
                sb.append("Case #").append(i + 1).append(": ").append(meetiTime).append("\n");
            } else {
                sb.append("Case #").append(i + 1).append(": IMPOSSIBLE\n");
            }
        }

        System.out.print(sb);
    }
}