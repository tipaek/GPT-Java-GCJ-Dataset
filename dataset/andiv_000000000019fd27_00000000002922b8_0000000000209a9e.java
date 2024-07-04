
import java.io.BufferedReader;

import java.io.IOException;
import java.io.InputStreamReader;

import java.util.Scanner;

public class Solution {

    public static void main(String[] args) throws IOException {

        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt();
        int b = in.nextInt();
        in.nextLine();
        for (int i = 1; i <= t; ++i) {
            if (b == 10) {
                char[] result = new char[10];
                for (int j = 0; j < 10; j++) {
                    System.out.println(j + 1);
                    int res = in.nextInt();
                    result[j] = (char) ('0' + res);
                }
                in.nextLine();
                System.out.println(new String(result));
                String answer = in.nextLine();
                if ("N".equals(answer)) return;
            }

            return;
        }
    }

}