import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner scan = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int tests = scan.nextInt();
        int B = scan.nextInt();
        for (int test = 1; test <= tests; test++) {
            int[] array = new int[B];
            Arrays.fill(array, -1);
            for (int i = 0; i < 10; i++) {
                System.out.println(i+1);
                System.out.flush();
                array[i] = scan.nextInt();
            }
            Arrays.stream(array).forEach(System.out::print);
            System.out.println();
            if (scan.next().equals("N")) break;
        }
    }
}