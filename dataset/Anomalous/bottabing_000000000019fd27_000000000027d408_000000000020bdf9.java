import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCount = scanner.nextInt();
        
        for (int test = 1; test <= testCount; test++) {
            int totalEvents = scanner.nextInt();
            Map<Integer, Integer> events = new HashMap<>();
            
            for (int i = 0; i < totalEvents; i++) {
                events.put(scanner.nextInt(), scanner.nextInt());
            }
            
            List<Map.Entry<Integer, Integer>> sortedEvents = new ArrayList<>(events.entrySet());
            sortedEvents.sort(Map.Entry.comparingByKey());
            
            StringBuilder schedule = new StringBuilder();
            boolean cameronBusy = false, jamieBusy = false, impossible = false;
            int cameronEnd = 0, jamieEnd = 0;
            
            for (Map.Entry<Integer, Integer> event : sortedEvents) {
                int start = event.getKey();
                int end = event.getValue();
                
                if (cameronEnd <= start) {
                    cameronBusy = false;
                }
                if (jamieEnd <= start) {
                    jamieBusy = false;
                }
                
                if (!cameronBusy) {
                    cameronBusy = true;
                    cameronEnd = end;
                    schedule.append("C");
                } else if (!jamieBusy) {
                    jamieBusy = true;
                    jamieEnd = end;
                    schedule.append("J");
                } else {
                    impossible = true;
                    break;
                }
            }
            
            if (impossible) {
                System.out.println("Case #" + test + ": IMPOSSIBLE");
            } else {
                System.out.println("Case #" + test + ": " + schedule.toString());
            }
        }
        
        scanner.close();
    }
}