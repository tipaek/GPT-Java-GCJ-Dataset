import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();
        
        for (int caseNumber = 1; caseNumber <= testCases; caseNumber++) {
            int r = scanner.nextInt();
            int s = scanner.nextInt();
            int count = 0;
            List<String> shuffles = new ArrayList<>();
            
            if (r >= s) {
                int lastShuffle = r == s ? s - 1 : s;
                int decrement = r * (s - 1);
                int limit = s;
                int modValue = s - 1;
                
                for (int i = decrement; i >= limit; i--) {
                    count++;
                    shuffles.add(String.format("%d %d", i, lastShuffle));
                    if (count % modValue == 0) {
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
            
            System.out.println("Case #" + caseNumber + ": " + count);
            shuffles.forEach(System.out::println);
        }
    }
}