import java.util.Scanner;
import java.util.ArrayList;

public class Solution {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        int runs = Integer.parseInt(console.nextLine());
        
        for (int run = 1; run <= runs; run++) {
            System.out.print("Case #" + run + ": ");
            int num = Integer.parseInt(console.nextLine());
            int[] starts = new int[num];
            int[] ends = new int[num];
            
            for (int i = 0; i < num; i++) {
                starts[i] = console.nextInt();
                ends[i] = console.nextInt();
            }
            console.nextLine(); // Consume the remaining newline
            
            ArrayList<String> cTimes = new ArrayList<>();
            ArrayList<String> jTimes = new ArrayList<>();
            StringBuilder answer = new StringBuilder();
            
            for (int i = 0; i < num; i++) {
                boolean canUseC = true;
                boolean canUseJ = true;
                
                for (String time : cTimes) {
                    int cStart = Integer.parseInt(time.split(" ")[0]);
                    int cEnd = Integer.parseInt(time.split(" ")[1]);
                    if (!(ends[i] <= cStart || starts[i] >= cEnd)) {
                        canUseC = false;
                        break;
                    }
                }
                
                for (String time : jTimes) {
                    int jStart = Integer.parseInt(time.split(" ")[0]);
                    int jEnd = Integer.parseInt(time.split(" ")[1]);
                    if (!(ends[i] <= jStart || starts[i] >= jEnd)) {
                        canUseJ = false;
                        break;
                    }
                }
                
                String interval = starts[i] + " " + ends[i];
                
                if (canUseC && !answer.toString().equals("IMPOSSIBLE")) {
                    cTimes.add(interval);
                    answer.append("C");
                } else if (canUseJ) {
                    jTimes.add(interval);
                    answer.append("J");
                } else {
                    answer = new StringBuilder("IMPOSSIBLE");
                }
            }
            
            System.out.println(answer.toString());
        }
        
        console.close();
    }
}