import java.util.Scanner;
import java.util.ArrayList;
public class Solution{
    public static void main(String[] args){
        Scanner console = new Scanner(System.in);
        int runs = Integer.parseInt(console.nextLine());
        for(int run = 1; run <= runs; run++){
            int num = Integer.parseInt(console.nextLine());
            int[] starts = new int[num];
            int[] ends = new int[num];
            for(int i = 0; i<num; i++){
                starts[i] = console.nextInt();
                ends[i] = console.nextInt();
            }
            console.nextLine();
            ArrayList<String> CTimes = new ArrayList<>();
            ArrayList<String> JTimes = new ArrayList<>();
            String answer = "";
            for(int start = 0; start<starts.length; start++){
                boolean useC = true;
                boolean useJ = true;
                for(String time: CTimes){
                    int testStart = Integer.parseInt(time.substring(0, time.indexOf(" ")));
                    int testEnd = Integer.parseInt(time.substring(time.indexOf(" ") +1));
                    if(((testStart<=starts[start] && testEnd>starts[start])    ||       (testStart<ends[start] && testEnd>=ends[start]) )    ||     (testStart<starts[start] && testEnd>ends[start])     ||     (testStart>starts[start] && testEnd<ends[start])){                     //Write conditionals
                        useC = false;
                    }
                }
                for(String time: JTimes){
                    int testStart = Integer.parseInt(time.substring(0, time.indexOf(" ")));
                    int testEnd = Integer.parseInt(time.substring(time.indexOf(" ") +1));
                    if(((testStart<=starts[start] && testEnd>starts[start])    ||       (testStart<ends[start] && testEnd>=ends[start]) )    ||     (testStart<starts[start] && testEnd>ends[start])  ||     (testStart>starts[start] && testEnd<ends[start])){                       //Write Conditionals
                        useJ = false;
                    }
                }
                String add = starts[start] + " " + ends[start];
                if(useC && !answer.equals("IMPOSSIBLE")){
                    CTimes.add(0, add);
                    answer += "C";
                }
                else if(useJ && !answer.equals("IMPOSSIBLE")){
                    JTimes.add(0, add);
                    answer += "J";
                }
                else{
                    answer = "IMPOSSIBLE";
                }
            }
            System.out.println("Case #" + run + ": " + answer);
        }
    }
}