import java.util.Scanner;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();
        
        for (int caseNumber = 1; caseNumber <= testCases; caseNumber++) {
            int activities = scanner.nextInt();
            boolean impossible = false;
            StringBuilder result = new StringBuilder();
            
            Parent ja = new Parent();
            Parent ca = new Parent();
            
            for (int j = 0; j < activities; j++) {
                int start = scanner.nextInt();
                int end = scanner.nextInt();
                
                if (impossible) {
                    continue;
                }
                
                if ((start >= ja.end || start < ja.start) && (end > ja.end || end <= ja.start)) {
                    ja.setTimes(start, end);
                    result.append("J");
                } else if ((start >= ca.end || start < ca.start) && (end > ca.end || end <= ca.start)) {
                    ca.setTimes(start, end);
                    result.append("C");
                } else {
                    result = new StringBuilder("IMPOSSIBLE");
                    impossible = true;
                }
            }
            
            System.out.println("Case #" + caseNumber + ": " + result);
        }
        
        scanner.close();
    }
    
    static class Parent {
        int start = 0;
        int end = 0;
        
        public void setTimes(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }
}