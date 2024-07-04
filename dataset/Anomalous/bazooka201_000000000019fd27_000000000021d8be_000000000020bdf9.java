import java.util.Scanner;
import java.util.ArrayList;

public class Solution {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        int runs = Integer.parseInt(console.nextLine());
        
        for (int run = 1; run <= runs; run++) {
            int num = Integer.parseInt(console.nextLine());
            int[] starts = new int[num];
            int[] ends = new int[num];
            
            for (int i = 0; i < num; i++) {
                starts[i] = console.nextInt();
                ends[i] = console.nextInt();
            }
            console.nextLine(); // Consume the remaining newline
            
            ArrayList<String> CTimes = new ArrayList<>();
            ArrayList<String> JTimes = new ArrayList<>();
            StringBuilder answer = new StringBuilder();
            
            for (int i = 0; i < num; i++) {
                boolean useC = isAvailable(CTimes, starts[i], ends[i]);
                boolean useJ = isAvailable(JTimes, starts[i], ends[i]);
                
                if (useC && answer.length() != 0 && !answer.toString().equals("IMPOSSIBLE")) {
                    CTimes.add(0, formatTime(starts[i], ends[i]));
                    answer.append("C");
                } else if (useJ && answer.length() != 0 && !answer.toString().equals("IMPOSSIBLE")) {
                    JTimes.add(0, formatTime(starts[i], ends[i]));
                    answer.append("J");
                } else {
                    answer = new StringBuilder("IMPOSSIBLE");
                }
            }
            
            System.out.println("Case #" + run + ": " + answer);
        }
    }
    
    private static boolean isAvailable(ArrayList<String> times, int start, int end) {
        for (String time : times) {
            int testStart = Integer.parseInt(time.split(" ")[0]);
            int testEnd = Integer.parseInt(time.split(" ")[1]);
            
            if ((start != end && (testStart <= start && testEnd > start) || (testStart < end && testEnd >= end)) 
                    || (testStart < start && testEnd > end)) {
                return false;
            }
        }
        return true;
    }
    
    private static String formatTime(int start, int end) {
        return start + " " + end;
    }
}