import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        StringBuilder sb = new StringBuilder();

        for (int tc = 1; tc <= t; tc++) {
            StringBuilder res = new StringBuilder();

            String s = br.readLine().trim();
            int[] split = new int[s.length() + 2];
            split[0] = 0;
            split[split.length - 1] = 0;

            for(int i = 0; i < split.length - 2; i++){
                split[i + 1] = s.charAt(i) - '0';
            }

            for (int i = 1; i < split.length - 1; i++) {
                for(int j = 0; j < split[i] - split[i -1];j++){
                    res.append("(");
                }
                res.append(split[i]);
                for(int j = 0; j < split[i] - split[i + 1]; j++){
                    res.append(")");
                }
            }

            sb.append("Case #").append(tc).append(": ").append(res).append("\n");
        }
        System.out.println(sb.toString());
    }
}
