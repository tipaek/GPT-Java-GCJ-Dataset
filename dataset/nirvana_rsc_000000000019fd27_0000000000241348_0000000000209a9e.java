import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.Arrays;

public class Solution {

    public static void main(String[] args) {
        final Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt();
        int b = in.nextInt();
        for (int k = 1; k <= t; k++) {
            int[] res = new int[b];
            for (int i = 0; i < b; i++) {
                System.out.println(i + 1);
                res[i] = in.nextInt();
            }
            StringBuilder sb = new StringBuilder();
            for (int num : res) {
                sb.append(num);
            }
            System.out.println(sb);
            if(in.nextLine() != "Y") {
                break;
            }
        }
    }
}
