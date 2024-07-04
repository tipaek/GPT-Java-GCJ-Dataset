import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner reader = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = reader.nextInt();
        for (int i = 1; i <= testCases; i++) {
            long N = reader.nextLong();

            System.out.println("Case #" + i + ":");
            if (N == 1){
                System.out.println((N) + " " + (N));
                continue;
            }
            System.out.println((N - 1) + " " + (N - 1));
            System.out.println((N) + " " + (N - 1));
        }
    }
}