import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();
        
        for (int t = 1; t <= testCases; t++) {
            int numShifts = scanner.nextInt();
            Shift[] shifts = new Shift[numShifts];
            int[] timeSlots = new int[24 * 60 + 1];
            
            for (int j = 0; j < numShifts; j++) {
                int start = scanner.nextInt();
                int end = scanner.nextInt();
                shifts[j] = new Shift(start, end);
                
                for (int k = start; k < end; k++) {
                    timeSlots[k]++;
                }
            }
            
            boolean impossible = false;
            for (int count : timeSlots) {
                if (count > 2) {
                    impossible = true;
                    break;
                }
            }
            
            if (impossible) {
                System.out.println("Case #" + t + ": IMPOSSIBLE");
            } else {
                Arrays.sort(shifts, Comparator.comparingInt(s -> s.start));
                StringBuilder result = new StringBuilder();
                int cameronEnd = 0, jamieEnd = 0;
                
                for (Shift shift : shifts) {
                    if (shift.start >= cameronEnd) {
                        result.append('C');
                        cameronEnd = shift.end;
                    } else if (shift.start >= jamieEnd) {
                        result.append('J');
                        jamieEnd = shift.end;
                    } else {
                        System.out.println("Case #" + t + ": IMPOSSIBLE");
                        result.setLength(0);
                        break;
                    }
                }
                
                if (result.length() > 0) {
                    System.out.println("Case #" + t + ": " + result.toString());
                }
            }
        }
        
        scanner.close();
    }
    
    static class Shift {
        int start, end;
        
        Shift(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }
}