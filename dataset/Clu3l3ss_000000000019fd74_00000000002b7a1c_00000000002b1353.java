import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            int N = Integer.parseInt(br.readLine());
            System.out.println("Case #" + (i + 1) + ":");
            if(N <= 500) {
                for (int j = 1; j <= N; j++) {
                    System.out.println(j + " " + 1);
                }
            }
            else if(N == 501) {
                System.out.println(1 + " " + 1);
                System.out.println(2 + " " + 1);
                System.out.println(2 + " " + 2);
                for (int j = 3; j <= N; j++) {
                    System.out.println(j + " " + 1);
                }
            }
        }

    }
}
