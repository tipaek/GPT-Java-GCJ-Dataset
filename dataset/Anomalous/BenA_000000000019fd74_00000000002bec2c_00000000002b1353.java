import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int numberOfCases = Integer.parseInt(scanner.nextLine());
        for (int i = 1; i <= numberOfCases; i++) {
            System.out.println("Case #" + i + ":");
            performWalk(Long.parseLong(scanner.nextLine()));
        }
    }

    public static void performWalk(long steps) {
        if (steps <= 500) {
            for (long i = 1; i <= steps; i++) {
                System.out.println(i + " 1");
            }
            return;
        }

        int s = 4;
        long lastSteps = 10;
        long totalSteps = 10;
        while (totalSteps < steps) {
            lastSteps = totalSteps;
            totalSteps += 1 + ((s * (s - 1)) / 2);
            s++;
        }
        s--;
        totalSteps = lastSteps;

        System.out.println("1 1");
        System.out.println("2 2");
        for (int i = 3; i <= s; i++) {
            System.out.println(i + " 3");
        }
        System.out.println(s + " 2");
        System.out.println(s + " 1");

        while (totalSteps < steps) {
            s++;
            System.out.println(s + " 1");
            totalSteps++;
        }
    }
}