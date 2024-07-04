import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(br.readLine());
        int t = Integer.parseInt(tokenizer.nextToken());
        int n = Integer.parseInt(tokenizer.nextToken());

        if (n == 10) {
            for (int testCase = 0; testCase < t; testCase++) {
                int[] array = new int[n];
                for (int i = 0; i < n; i++) {
                    System.out.println(i + 1);
                    array[i] = Integer.parseInt(br.readLine());
                }
                StringBuilder result = new StringBuilder();
                for (int value : array) {
                    result.append(value);
                }
                System.out.println(result.toString());
            }
        }
    }
}