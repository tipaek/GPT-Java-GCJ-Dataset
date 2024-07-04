import java.util.Scanner;
import java.util.ArrayList;
import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        Scanner console = new Scanner(System.in);
        PrintWriter writer = new PrintWriter(System.out);
        
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
            
            ArrayList<String> cTimes = new ArrayList<>();
            ArrayList<String> jTimes = new ArrayList<>();
            StringBuilder answer = new StringBuilder();
            
            for (int start = 0; start < starts.length; start++) {
                boolean useC = true;
                boolean useJ = true;
                
                for (String time : cTimes) {
                    int testStart = Integer.parseInt(time.split(" ")[0]);
                    int testEnd = Integer.parseInt(time.split(" ")[1]);
                    if ((testStart <= starts[start] && testEnd > starts[start]) ||
                        (testStart < ends[start] && testEnd >= ends[start]) ||
                        (testStart < starts[start] && testEnd > ends[start]) ||
                        (testStart >= starts[start] && testEnd <= ends[start])) {
                        useC = false;
                        break;
                    }
                }
                
                for (String time : jTimes) {
                    int testStart = Integer.parseInt(time.split(" ")[0]);
                    int testEnd = Integer.parseInt(time.split(" ")[1]);
                    if ((testStart <= starts[start] && testEnd > starts[start]) ||
                        (testStart < ends[start] && testEnd >= ends[start]) ||
                        (testStart < starts[start] && testEnd > ends[start]) ||
                        (testStart >= starts[start] && testEnd <= ends[start])) {
                        useJ = false;
                        break;
                    }
                }
                
                String add = starts[start] + " " + ends[start];
                if (useC && !answer.toString().equals("IMPOSSIBLE")) {
                    cTimes.add(0, add);
                    answer.append("C");
                } else if (useJ && !answer.toString().equals("IMPOSSIBLE")) {
                    jTimes.add(0, add);
                    answer.append("J");
                } else {
                    answer = new StringBuilder("IMPOSSIBLE");
                    break;
                }
            }
            
            writer.println("Case #" + run + ": " + answer.toString());
            writer.flush();
        }
        
        writer.close();
        console.close();
    }
}