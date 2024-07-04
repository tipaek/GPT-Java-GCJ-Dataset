import java.util.ArrayList;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean[] c = new boolean[1441];
        boolean[] j = new boolean[1441];
        ArrayList<String> schedule = new ArrayList<>();
        
        int cases = sc.nextInt();
        
        for (int i = 0; i < cases; i++) {
            int activities = sc.nextInt();
            schedule.clear();
            System.out.print("Case #" + (i + 1) + ": ");
            
            // Reset the availability arrays
            for (int t = 0; t < 1441; t++) {
                c[t] = false;
                j[t] = false;
            }
            
            boolean possible = true;
            for (int p = 0; p < activities; p++) {
                int start = sc.nextInt();
                int end = sc.nextInt();
                
                boolean cAvailable = true;
                boolean jAvailable = true;
                
                // Check availability for C and J
                for (int t = start; t < end; t++) {
                    if (c[t]) cAvailable = false;
                    if (j[t]) jAvailable = false;
                }
                
                if (cAvailable) {
                    schedule.add("C");
                    for (int t = start; t < end; t++) {
                        c[t] = true;
                    }
                } else if (jAvailable) {
                    schedule.add("J");
                    for (int t = start; t < end; t++) {
                        j[t] = true;
                    }
                } else {
                    possible = false;
                    break;
                }
            }
            
            if (possible) {
                for (String s : schedule) {
                    System.out.print(s);
                }
                System.out.println();
            } else {
                System.out.println("IMPOSSIBLE");
            }
        }
        
        sc.close();
    }
}