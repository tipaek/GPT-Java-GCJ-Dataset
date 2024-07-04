import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer data = new StringTokenizer(input.readLine());
        int t = Integer.parseInt(data.nextToken()),
            b = Integer.parseInt(data.nextToken());

        for(int i = 0; i < t; i++) {
            int[] guess = new int[b];
            int correct = 1;
            for(int j = 1; j <= 150; j++) {
                if(correct > b) break;
                System.out.println(correct);
                int resp = Integer.parseInt(input.readLine());
                guess[correct-1] = resp;
                if(j % 10 != 1) correct++;
            }
            for (int v : guess) System.out.print(v);
            System.out.println();
        }

    }

}
