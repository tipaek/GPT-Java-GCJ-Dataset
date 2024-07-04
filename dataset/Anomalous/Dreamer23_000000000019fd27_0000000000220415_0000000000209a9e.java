import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        try (Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)))) {
            String[] settings = in.nextLine().split(" ");
            int t = Integer.parseInt(settings[0]);
            int b = Integer.parseInt(settings[1]);
            for (int c = 1; c <= t; ++c) {
                processCase(in, b);
            }
        }
    }

    private static void processCase(Scanner in, int bytes) {
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= 10; i++) {
            System.out.println(i);
            sb.append(in.nextLine());
        }
        System.out.println(sb.toString());
        in.nextLine();
    }
}