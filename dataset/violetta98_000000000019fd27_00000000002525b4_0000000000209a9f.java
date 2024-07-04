import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        for (int q = 0; q < t; q++) {
            String s = br.readLine();
            StringBuilder sb = new StringBuilder();
            int opened = 0;

            for (int i = 0; i < s.length(); i++) {
                int d = Character.getNumericValue(s.charAt(i));
                if (d < opened) {
                    sb.append(")".repeat(opened - d));
                    opened -= opened - d;
                }
                else {
                    sb.append("(".repeat(d - opened));
                    opened += d - opened;
                }
                sb.append(s.charAt(i));
            }

            sb.append(")".repeat(opened));

            System.out.println("Case #" + (q + 1) + ": " + sb.toString());
        }
    }
}
