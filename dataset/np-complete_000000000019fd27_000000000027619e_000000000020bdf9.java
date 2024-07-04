import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;

public class Solution {

        public static void main(String[] args) {
                Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
                String T = in.nextLine();
                int t = Integer.parseInt(T);
                
                for (int i = 1; i <= t; i++) {
                        String N = in.nextLine();
                        int n = Integer.parseInt(N);
                        
                        ArrayList<Interval> requests = new ArrayList<Interval>();
                        
                        ArrayList<Integer> C = new ArrayList<Integer>();
                        ArrayList<Integer> J = new ArrayList<Integer>();
                        
                        Boolean allCompatible = true;
                        String outputString = "";
                        
                        for(int j = 0; j < n; j++) {
                                String req = in.nextLine();
                                
                                int start = Integer.parseInt(req.split(" ")[0]);
                                int end = Integer.parseInt(req.split(" ")[1]);
                                Interval request = new Interval(start, end);
                                requests.add(request);
                        }
                        
                        C.add(0);
                        for(int j = 1; j < n; j++) {
                                Boolean compatible = true;
                                Interval next = requests.get(j);
                                for(int k = 0; k < C.size(); k++) {
                                        Interval toCheck = requests.get(C.get(k));
                                        if(next.startTime >= toCheck.finishTime || next.finishTime <= toCheck.startTime) {
                                                continue;
                                        } else {
                                                compatible = false;
                                                break;
                                        }
                                }
                                
                                if(compatible) {
                                        C.add(j);
                                } else {
                                        J.add(j);
                                }
                        }
                        
                        for(int j = 1; j < J.size(); j++) {
                                Boolean compatible = true;
                                Interval next = requests.get(J.get(j));
                                for(int k = 0; k < j; k++) {
                                        Interval toCheck = requests.get(J.get(k));
                                        if(next.startTime >= toCheck.finishTime || next.finishTime <= toCheck.startTime) {
                                                continue;
                                        } else {
                                                compatible = false;
                                                break;
                                        }
                                }
                                allCompatible = compatible;
                        }
                        
                        if(allCompatible) {
                                int cPointer = 0;
                                int jPointer = 0;
                                
                                ArrayList<String> letters = new ArrayList<String>();
                                while(true) {
                                        if(cPointer >= C.size()) {
                                                for(int j = jPointer; j < J.size(); j++) {
                                                        letters.add("J");
                                                }
                                                break;
                                        }
                                        
                                        if(jPointer >= J.size()) {
                                                for(int j = cPointer; j < C.size(); j++) {
                                                        letters.add("C");
                                                }
                                                break;
                                        }
                                        
                                       if(C.get(cPointer) < J.get(jPointer)) {
                                               letters.add("C");
                                               cPointer++;
                                       } else {
                                               letters.add("J");
                                               jPointer++;
                                       }
                                }
                                
                                StringBuilder sb = new StringBuilder();
                                for (String s : letters)
                                {
                                    sb.append(s);
                                }
                                outputString = sb.toString();
                        } else {
                                outputString = "IMPOSSIBLE";
                        }
                        
                        System.out.println("Case #" + i + ": " + outputString);
                }
                in.close();
        }
}

class Interval {
    int startTime;
    int finishTime;
    
    public Interval(int start, int finish) {
        this.startTime = start;
        this.finishTime = finish;
    }
}
