import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {
    static final double HEIGHT = Math.pow(10, 9) * 2;
    static final double WIDTH = Math.pow(10, 9) * 2;

    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));

        String[] conditions = in.nextLine().split(" ");
        int numberOfTestcases = Integer.parseInt(conditions[0]);
        double radius = Integer.parseInt(conditions[2]);

        for(int i = 1; i <= numberOfTestcases; i++) {
            findSolution(i, in, radius);
        }
    }

    private static void findSolution(int index, Scanner in, double radius) {
        double air = HEIGHT - radius;

        for(int x = -5; x < 6; x++) {
            for(int y = -5; y < 6; y++) {
                System.out.println(x + " " + y);

                String judgeAnswer = in.nextLine();
                System.err.println(judgeAnswer);
            }
        }
    }
}