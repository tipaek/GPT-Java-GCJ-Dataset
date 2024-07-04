import java.util.*;
import java.io.*;

public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = Integer.parseInt(sc.nextLine());

        for (int i = 1; i <= T; i++) {
            int N = Integer.parseInt(sc.nextLine());
            System.out.println("Case #" + i + ":");
            if (N == 501) {
                System.out.println("1 1");
                System.out.println("2 2");
                System.out.println("3 3");
                System.out.println("3 2");
                System.out.println("3 1");
                for (int j = 4; j <= 498; j++) {
                    System.out.println(j + " 1");
                }
            } else {
                for (int j = 1; j <= N; j++) {
                    System.out.println(j + " 1");
                }
            }
        }
    }
}
