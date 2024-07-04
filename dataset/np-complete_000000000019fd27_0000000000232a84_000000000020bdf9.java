import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class Solution {

        public static void main(String[] args) {
                Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
                String T = in.nextLine();
                int t = Integer.parseInt(T);
                
                for (int i = 1; i <= t; i++) {
                        String N = in.nextLine();
                        int n = Integer.parseInt(N);
                        
                        HashMap<Integer, ArrayList<Interval>> byStart = new HashMap<Integer, ArrayList<Interval>>();
                        int[] starts = new int[n];
                        HashMap<Integer, Integer> startIndices = new HashMap<Integer, Integer>();
                        
                        Interval[] requests = new Interval[n];
                        String outputString = "";
                        ArrayList<Integer> jamie = new ArrayList<Integer>();
                        ArrayList<Integer> cameron = new ArrayList<Integer>();
                        
                        for(int j = 0; j < n; j++) {
                                String req = in.nextLine();
                                
                                int start = Integer.parseInt(req.split(" ")[0]);
                                int end = Integer.parseInt(req.split(" ")[1]);
                                Interval request = new Interval(start, end);
                                ArrayList<Interval> reqsAtStart = new ArrayList<Interval>();
                                if(byStart.containsKey(start)) {
                                        reqsAtStart = byStart.get(start);
                                        if(reqsAtStart.size() == 2) {
                                                outputString = "IMPOSSIBLE";
                                                break;
                                        }
                                }
                                reqsAtStart.add(request);
                                byStart.put(start, reqsAtStart);
                                starts[j] = start;
                                startIndices.put(start, j);
                        }
                        
                        if(outputString != "IMPOSSIBLE") {
                                Arrays.parallelSort(starts);
                                
                                for(int j = 0; j < starts.length; j++) {
                                        Interval nextRequest = byStart.get(starts[j]).get(0);
                                        requests[j] = nextRequest;
                                        if(byStart.get(starts[j]).size() == 2) {
                                                ++j;
                                                nextRequest = byStart.get(starts[j]).get(1);
                                                requests[j] = nextRequest;
                                        }
                                }
                                
                                jamie.add(0);
                                
                                char last = 'J';
                                for(int j = 1; j < starts.length; j++) {
                                        int currentStart = starts[j];
                                        int previousStart = starts[j-1];
                                        
                                        if(currentStart == previousStart) {
                                                if(last == 'C') {
                                                        outputString = "IMPOSSIBLE";
                                                        break;
                                                } else {
                                                        cameron.add(j);
                                                        last = 'C';
                                                }
                                        } else {
                                                Interval currentRequest = requests[j];
                                                Interval previousRequest = requests[jamie.get(jamie.size() - 1)];
                                                
                                                if(currentRequest.startTime < previousRequest.finishTime) {
                                                        cameron.add(j);
                                                        last = 'C';
                                                } else {
                                                        jamie.add(j);
                                                        last = 'J';
                                                }
                                        }
                                }
                        }
                        
                        if(outputString != "IMPOSSIBLE") {
                                for(int j = 1; j < cameron.size(); j++) {
                                        Interval currentRequest = requests[cameron.get(j)];
                                        Interval previousRequest = requests[cameron.get(j-1)];
                                        
                                        if(currentRequest.startTime < previousRequest.finishTime) {
                                                outputString = "IMPOSSIBLE";
                                                break;
                                        }
                                }
                        }
                        
                        if(outputString != "IMPOSSIBLE") {
                                if(jamie.size() == 0) {
                                        for(int j = 0; j < n; j++) {
                                                outputString = outputString + "C";
                                        }
                                } else if(cameron.size() == 0) {
                                        for(int j = 0; j < n; j++) {
                                                outputString = outputString + "J";
                                        }
                                } else {
                                        ArrayList<Integer> J = new ArrayList<Integer>();
                                        ArrayList<Integer> C = new ArrayList<Integer>();
                                        for(int j = 0; j < jamie.size(); j++) {
                                                J.add(startIndices.get(requests[jamie.get(j)].startTime));
                                        }
                                        
                                        for(int j = 0; j < cameron.size(); j++) {
                                                C.add(startIndices.get(requests[cameron.get(j)].startTime));
                                        }
                                        J.sort(null);
                                        C.sort(null);

                                        int jPointer = 0;
                                        int cPointer = 0;
                                        char last = 'N';
                                        while(true) {
                                                if(J.get(jPointer) == C.get(cPointer)) {
                                                        if(last == 'J') {
                                                                outputString = outputString + "J";
                                                                last = 'J';
                                                                jPointer++;
                                                        } else {
                                                                outputString = outputString + "C";
                                                                last = 'C';
                                                                cPointer++;
                                                        }
                                                } else if(J.get(jPointer) < C.get(cPointer)) {
                                                        outputString = outputString + "J";
                                                        last = 'J';
                                                        jPointer++;
                                                } 
                                                else {
                                                        outputString = outputString + "C";
                                                        last = 'C';
                                                        cPointer++;
                                                }
                                                
                                                if(jPointer >= jamie.size()) {
                                                        for(int j = cPointer; j < cameron.size(); j++) {
                                                                outputString = outputString + "C";
                                                        }
                                                        break;
                                                }
                                                
                                                if(cPointer >= cameron.size()) {
                                                        for(int j = jPointer; j < jamie.size(); j++) {
                                                                outputString = outputString + "J";
                                                        }
                                                        break;
                                                }
                                        }
                                }
                        }
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
