import java.util.Scanner;

public class Solution{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for (int k = 1; k <= t; k++) {
            String str = sc.next();
            int n = str.length();
            int[] arr = new int[n];
            for (int i = 0; i < n; i++)
                arr[i] = str.charAt(i) - '0';
            int start = arr[0];
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < start; i++)
                sb.append('(');
            sb.append(str.charAt(0));
            for (int i = 1; i < n; i++) {
                int temp = 0;
                if (arr[i] < arr[i - 1]) {
                    temp = arr[i - 1] - arr[i];
                    for (int j = 0; j < temp; j++)
                        sb.append(')');
                    start -= temp;
                } else {
                    temp = arr[i] - arr[i - 1];
                    for (int j = 0; j < temp; j++)
                        sb.append('(');
                    start += temp;
                }
                sb.append(str.charAt(i));
            }
            for (int i = 0; i < start; i++)
                sb.append(')');
            System.out.println("Case #" + k + ": " + sb);

        }
    }
}
