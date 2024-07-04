import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(reader.readLine());
        StringBuilder result = new StringBuilder();

        for (int t = 1; t <= T; t++) {
            result.append("Case #").append(t).append(":\n");
            int N = Integer.parseInt(reader.readLine());
            result.append("1 1\n");
            int sum = 1, position = 1;

            while (sum + position <= N) {
                sum += position;
                result.append((position + 1)).append(" ").append(2).append("\n");
                position++;
            }

            while (sum < N) {
                sum++;
                result.append(position).append(" ").append(1).append("\n");
                position++;
            }
        }

        System.out.print(result);
    }
}