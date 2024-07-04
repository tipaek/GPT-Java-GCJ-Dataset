package sk.liptak;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = scanner.nextInt();
        for (int i = 0; i < t; i++) {
            int x = scanner.nextInt();
            int y = scanner.nextInt();

            String tour = scanner.next();

            int px = 0;
            int py = 0;

            boolean possible = false;

            for (int j = 0; j < tour.length(); j++) {
                char c = tour.charAt(j);

                    switch (c) {
                        case 'W':
                            px--;
                            break;
                        case 'E':
                            px++;
                            break;
                        case 'N':
                            py--;
                            break;
                        case 'S':
                            py++;
                            break;
                    }

                int cc = Math.abs(x-px) + Math.abs(y-py);
                if (cc <= j + 1) {
                    System.out.println("Case #" + (i + 1) + ": " + (j + 1));
                    possible = true;
                    break;
                }
            }

            if (!possible)
                System.out.println("Case #" + (i + 1) + ": " + "IMPOSSIBLE");
        }

    }
}
