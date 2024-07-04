import java.util.ArrayList;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean[] c = new boolean[1440];
        boolean[] j = new boolean[1440];
        ArrayList<String> schedule = new ArrayList<>();
        
        int cases = sc.nextInt();
        
        for (int i = 0; i < cases; i++) {
            int numTasks = sc.nextInt();
            schedule.clear();
            System.out.print("Case #" + (i + 1) + ": ");
            
            for (int t = 0; t < 1440; t++) {
                c[t] = false;
                j[t] = false;
            }
            
            boolean possible = true;
            
            for (int p = 0; p < numTasks; p++) {
                int start = sc.nextInt();
                int end = sc.nextInt();
                boolean cAvailable = true;
                boolean jAvailable = true;
                
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
            
            if (!possible) {
                System.out.println("IMPOSSIBLE");
            } else {
                for (String task : schedule) {
                    System.out.print(task);
                }
                System.out.println();
            }
        }
        sc.close();
    }
}