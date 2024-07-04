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
            console.nextLine();  // Consume the newline character
            
            ArrayList<String> CTimes = new ArrayList<>();
            ArrayList<String> JTimes = new ArrayList<>();
            StringBuilder answer = new StringBuilder();
            
            for (int start = 0; start < starts.length; start++) {
                boolean canUseC = true;
                boolean canUseJ = true;
                
                for (String time : CTimes) {
                    int testStart = Integer.parseInt(time.split(" ")[0]);
                    int testEnd = Integer.parseInt(time.split(" ")[1]);
                    if ((testStart <= starts[start] && testEnd > starts[start]) || 
                        (testStart < ends[start] && testEnd >= ends[start]) || 
                        (testStart < starts[start] && testEnd > ends[start]) || 
                        (testStart >= starts[start] && testEnd <= ends[start])) {
                        canUseC = false;
                        break;
                    }
                }
                
                for (String time : JTimes) {
                    int testStart = Integer.parseInt(time.split(" ")[0]);
                    int testEnd = Integer.parseInt(time.split(" ")[1]);
                    if ((testStart <= starts[start] && testEnd > starts[start]) || 
                        (testStart < ends[start] && testEnd >= ends[start]) || 
                        (testStart < starts[start] && testEnd > ends[start]) || 
                        (testStart >= starts[start] && testEnd <= ends[start])) {
                        canUseJ = false;
                        break;
                    }
                }
                
                String add = starts[start] + " " + ends[start];
                if (canUseC && !answer.toString().equals("IMPOSSIBLE")) {
                    CTimes.add(add);
                    answer.append("C");
                } else if (canUseJ && !answer.toString().equals("IMPOSSIBLE")) {
                    JTimes.add(add);
                    answer.append("J");
                } else {
                    answer = new StringBuilder("IMPOSSIBLE");
                }
            }
            System.out.println("Case #" + run + ": " + answer);
        }
        console.close();
    }
}