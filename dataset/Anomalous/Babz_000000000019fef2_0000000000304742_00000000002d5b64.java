import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();
        
        for (int testCase = 1; testCase <= testCases; testCase++) {
            int r = scanner.nextInt();
            int s = scanner.nextInt();
            int count = 0;
            List<String> shuffles = new ArrayList<>();
            
            if (r >= s) {
                int lastShuffle = s;
                for (int i = r * (s - 1); i >= s; i--) {
                    count++;
                    shuffles.add(String.format("%d %d", i, lastShuffle));
                    if (count % (s - 1) == 0) {
                        lastShuffle--;
                    }
                }
            } else {
                int start = (r - 1) * s;
                int firstShuffle = r;
                for (int i = start; i >= r; i--) {
                    count++;
                    shuffles.add(String.format("%d %d", firstShuffle, i));
                    if (count % r == 0) {
                        firstShuffle--;
                    }
                }
            }
            
            System.out.println("Case #" + testCase + ": " + count);
            shuffles.forEach(System.out::println);
        }
    }
}