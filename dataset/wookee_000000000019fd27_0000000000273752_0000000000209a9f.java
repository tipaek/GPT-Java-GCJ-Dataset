import java.io.*;

public class Solution {

    public static void main(String[] args) throws IOException {
        solution();
    }

    public static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int testCaseCnt = Integer.parseInt(br.readLine());

        for (int t = 1; t <= testCaseCnt; t++) {

            String str = br.readLine();
            int size = str.length();

            StringBuilder result = new StringBuilder();

            int depth = 0;
            for (int i = 0; i < str.length(); i++) {
                StringBuilder sb = new StringBuilder();
                sb.append(str.charAt(i));

                int num = str.charAt(i) - '0';
                while (depth > num) {
                    sb.insert(0, ")");
                    depth--;
                }
                while (depth < num) {
                    sb.insert(0, "(");
                    depth++;
                }
                result.append(sb);
            }
            while (depth > 0) {
                result.append(")");
                depth--;
            }

            System.out.printf("Case #%d: %s\n", t, result);
        }
        bw.close();
        br.close();
    }

    private static void print(int[][] map) {
        for (int[] ints : map) {
            for (int j = 0; j < map.length; j++) {
                System.out.printf("%d ", ints[j]);
            }
            System.out.println();
        }
    }


}
