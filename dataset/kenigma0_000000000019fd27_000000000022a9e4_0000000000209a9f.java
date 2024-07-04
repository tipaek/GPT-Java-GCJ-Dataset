
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution{
    public static void main(String []args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int not = Integer.parseInt(br.readLine());
        int ii = 1;
        while (not-- != 0) {
            String input = br.readLine();
            int n = input.length();
            int[] arr = new int[n];
            int[] current = new int[n];
            for (int i = 0; i < n; i++) {
                char ch = input.charAt(i);
                arr[i] = ch -'0';
                current[i] = arr[i];
            }
            System.out.println("Case #"+ii+": "+function(arr,current,0,n - 1));
            ii++;
        }
    }
    static StringBuilder function(int[] arr, int[] current, int start, int end) {
        StringBuilder sb = new StringBuilder();
        if (start > end) {
            return sb;
        }
        else if (start == end) {
            for (int i = 0; i < current[start]; i++) {
                sb.append('(');
            }
            sb.append(arr[start]);
            for (int i = 0; i < current[start]; i++) {
                sb.append(')');
            }
            current[start] = 0;
            return sb;
        }

        int min = Integer.MAX_VALUE;
        int index = 0;
        for (int i = start; i <= end; i++) {
            if (current[i] < min) {
                min = current[i];
                index = i;
            }
        }
        for (int i = start; i <= end; i++) {
            current[i] -= min;
        }
        for (int i = 0; i < min; i++) {
            sb.append('(');
        }
        sb.append(function(arr, current, start, index - 1));
        sb.append(arr[index]);
        sb.append(function(arr, current, index + 1, end));
        for (int i = 0; i < min; i++) {
            sb.append(')');
        }
        return sb;
    }
}