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
                        HashMap<Integer, ArrayList<Integer>> startIndices = new HashMap<Integer, ArrayList<Integer>>();
                        
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
                                
                                ArrayList<Integer> indicesAtStart = new ArrayList<Integer>();
                                if(startIndices.containsKey(start)) {
                                        indicesAtStart = startIndices.get(start);
                                }
                                indicesAtStart.add(j);
                                startIndices.put(start, indicesAtStart);
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
                                
                                char current = 'C';
                                cameron.add(0);
                                for(int j = 1; j < n; j++) {
                                        // Check compatibility with previous
                                        if(requests[j].startTime < requests[j-1].finishTime) {
                                                if(current == 'J') {
                                                        // Not compatible with last task assigned to J
                                                        // Check if it is compatible with the last task assigned to C
                                                        Interval cLast = null;
                                                        if(cameron.size() > 0) {
                                                                cLast = requests[cameron.get(cameron.size()-1)];
                                                        }
                                                        if(cLast != null) {
                                                                if(requests[j].startTime < cLast.finishTime) {
                                                                        // Not compatible with last tasks of J or C
                                                                        outputString = "IMPOSSIBLE";
                                                                        break;
                                                                }
                                                        }
                                                        current = 'C';
                                                        cameron.add(j);
                                                } else {
                                                        // Not compatible with last task assigned to C
                                                        // Check if it is compatible with the last task assigned to J
                                                        Interval jLast = null;
                                                        if(jamie.size() > 0) {
                                                                jLast = requests[jamie.get(jamie.size()-1)];
                                                        }
                                                        if(jLast != null) {
                                                                if(requests[j].startTime < jLast.finishTime) {
                                                                        // Not compatible with last tasks of J or C
                                                                        outputString = "IMPOSSIBLE";
                                                                        break;
                                                                }
                                                        }
                                                        current = 'J';
                                                        jamie.add(j);
                                                }
                                        } else {
                                                if(current == 'J') {
                                                        jamie.add(j);
                                                } else {
                                                        cameron.add(j);
                                                }
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
                                        char[] letters = new char[n];
                                        
                                        int jPointer = 0;
                                        int cPointer = 0;
                                        ArrayList<Integer> toAdd= new ArrayList<Integer>();
                                        int indexToAdd = -1;
                                        for(int j = 0; j <n; j++) {
                                                if(cPointer < cameron.size() && j == cameron.get(cPointer)) {
                                                        toAdd = startIndices.get(requests[cameron.get(cPointer)].startTime);
                                                        indexToAdd = toAdd.remove(0);
                                                        letters[indexToAdd] = 'C';
                                                        cPointer++;
                                                } else {
                                                        toAdd = startIndices.get(requests[jamie.get(jPointer)].startTime);
                                                        indexToAdd = toAdd.remove(0);
                                                        letters[indexToAdd] = 'J';
                                                        jPointer++;
                                                }
                                        }
                                        outputString = new String(letters);
                                }
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