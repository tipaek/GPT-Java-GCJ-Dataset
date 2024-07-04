import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        for (int i = 1; i <= t; ++i) {
            String str = br.readLine();

            int arr[] = new int[str.length() + 1];
            for (int j = 0 ; j < str.length() ; j++) {
                char ch = str.charAt(j);

                int num = Integer.parseInt(ch + "");
                arr[j] += num;
                arr[j + 1] -= num;
            }

            StringBuilder stringBuilder = new StringBuilder();
            for (int j = 0 ; j < str.length() ; j++) {
                stringBuilder.append(buildBrackets(arr[j]));
                stringBuilder.append(str.charAt(j));
            }
            stringBuilder.append(buildBrackets(arr[str.length()]));

            System.out.println("Case #" + i + ": " + stringBuilder.toString());
        }
    }

    private static String buildBrackets(int num) {
        StringBuilder stringBuilder = new StringBuilder();
        if (num > 0) {
            for (int i = 0 ; i < num ; i++) {
                stringBuilder.append("(");
            }
        } else {
            for (int i = 0 ; i < -num ; i++) {
                stringBuilder.append(")");
            }
        }

        return stringBuilder.toString();
    }
}