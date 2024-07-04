import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(in.readLine());
        int T = Integer.parseInt(st.nextToken());
        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());

        boolean found;
        for (int i = 0; i < T; i++) {
            found = false;
            for (int x = -5; x <= 5 && !found; x++) {
                for (int y = -5; y <= 5 && !found; y++) {
                    System.out.println(x + " " + y);
                    String res = in.readLine();
                    if (res.equals("CENTER")) {
                        found = true;
                    }
                }
            }
        }
    }
}
