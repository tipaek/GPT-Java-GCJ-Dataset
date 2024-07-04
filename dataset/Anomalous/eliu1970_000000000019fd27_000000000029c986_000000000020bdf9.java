import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));
        int nn = Integer.parseInt(br.readLine());

        for (int n = 1; n <= nn; n++) {
            String str = br.readLine();
            StringBuilder result = new StringBuilder();
            int nump = 0;

            for (int index = 0; index < str.length(); index++) {
                int x = Character.getNumericValue(str.charAt(index));
                for (int i = 0; i < x; i++) {
                    result.append("(");
                    nump++;
                }
                result.append(x);
            }

            out.println("Case #" + n + ": " + result.toString());
        }
        out.close();
    }

    public static void sortbyColumn(int[][] arr) {
        Arrays.sort(arr, new Comparator<int[]>() {
            @Override
            public int compare(final int[] entry1, final int[] entry2) {
                if (entry1[0] == entry2[0]) {
                    return entry2[1] - entry1[1];
                }
                return entry1[0] - entry2[0];
            }
        });
    }
}