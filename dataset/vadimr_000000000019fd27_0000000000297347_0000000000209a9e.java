import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws IOException {
        String[] s = reader.readLine().split(" ");
        Integer testCases = Integer.parseInt(s[0]);
        Integer b = Integer.parseInt(s[1]);
        for (int k = 1; k <= testCases; k++) {
            //String ss = reader.readLine();
            //ss = reader.readLine();
            Solution solution = new Solution();
            //int[] result = solution.solve(b);
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < 10; i++) {
                sb.append(i);
            }
            System.out.print("0000000000");
            //System.out.flush();
            //String yorn = reader.readLine();
            //if (yorn.equals("N")) {
                System.exit(1);
            //} 
        }
    }

    private int[] solve (int b) throws IOException {
        int eqMarker = -1;
        int diffMarker = -1;
        int[] result = new int[b];
        int i = 1;
        if (b == 10) {
            /*while (i <= 5) {
                System.out.print(i);
                System.out.flush();
                result[i-1] = Integer.parseInt(reader.readLine());
                i++;
            }*/
            /*i = 10;
            while (i > 5) {
                System.out.print(i);
                System.out.flush();
                result[i-1] = Integer.parseInt(reader.readLine());
                i--;
            }*/
        }

        return result;
    }
}

