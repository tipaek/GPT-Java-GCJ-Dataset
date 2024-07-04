import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws IOException {
        String[] s = reader.readline().split(" ");
        Integer testCases = Integer.parseInt(s[0]);
        Integer b = Integer.parseInt(s[1]);
        for (int k = 1; k <= testCases; k++) {
            
            Solution solution = new Solution();
            int[] result = solution.solve(b);
            StringBuilder sb = new StringBuilder();
            for (int i : result) {
                sb.append(i);
            }
            System.out.println("0001111000");
            System.out.flush();
        }
    }

    private int[] solve (int b) throws IOException {
        int eqMarker = -1;
        int diffMarker = -1;
        int[] result = new int[b];
        int i = 1;
        if (b == 10) {
            while (i <= 5) {
                System.out.println(i);
                System.out.flush();
                result[i-1] = Integer.parseInt(reader.readLine());
                i++;
            }
            i = 10;
            while (i > 5) {
                System.out.println(i);
                System.out.flush();
                result[i-1] = Integer.parseInt(reader.readLine());
                i--;
            }
        }

        return result;
    }
}

