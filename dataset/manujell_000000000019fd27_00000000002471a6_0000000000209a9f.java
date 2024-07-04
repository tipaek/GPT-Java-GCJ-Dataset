import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Solution {

    public static void main(String[] args) throws IOException {
        nestingDepths();
    }

    public static void nestingDepths() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        for(int j = 1; j<=T; j++){
            int prev = 0;
            String str = br.readLine();

            for(int i=0; i<str.length(); i++){
                int current = str.charAt(i) - '0';
                for(int k=prev; k!=current;){
                    if(k<current){
                        System.out.print("(");
                        k++;
                    }else{
                        System.out.print(")");
                        k--;
                    }
                }
                System.out.print(current);
                prev = current;
            }
            for(;prev>0;prev--)
                System.out.print(")");
            System.out.println();
        }
    }

    public static void vestigium() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        for(int j = 1; j<=T; j++) {
            int N = Integer.parseInt(br.readLine());

            int trace = 0;
            int r = 0;
            int c = 0;
            boolean[][] xUsed = new boolean[N][N];
            boolean[][] yUsed = new boolean[N][N];

            int[][] matrix = new int[N][N];

            for (int i = 0; i < N; i++) {
                matrix[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
                trace += matrix[i][i];
                if (Arrays.stream(matrix[i]).distinct().toArray().length < N) {
                    r++;
                }
            }
            for (int i = 0; i < N; i++) {
                final int column = i;
                if (Arrays.stream(matrix).mapToInt(row -> row[column]).distinct().toArray().length < N) {
                    c++;
                }
            }
            System.out.format("Case #%d: %d %d %d\n", j, trace, r, c);
        }
    }
}
