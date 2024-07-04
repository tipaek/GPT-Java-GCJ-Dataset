import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            int M = Integer.parseInt(br.readLine());
            if(M <= 500) {
                for (int j = 1; j <= M; j++) {
                    System.out.println(j + " " + 1);
                }
            }
            else if(M == 501) {
                System.out.println(1 + " " + 1);
                System.out.println(2 + " " + 1);
                System.out.println(2 + " " + 2);
                for (int j = 3; j <= M; j++) {
                    System.out.println(j + " " + 1);
                }
            }
        }

    }
}
