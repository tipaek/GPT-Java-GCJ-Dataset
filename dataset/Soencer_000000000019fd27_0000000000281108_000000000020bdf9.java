import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt();

        for (int k = 0; k < t; k++) {
            int numAct = in.nextInt();
            if (numAct == 0) {
                System.out.println("Case #"+(k+1)+": ");
                continue;
            }
            int[] start = new int[numAct];
            int[] end = new int[numAct];
            boolean[] cameron = new boolean[numAct];
            ArrayList<Integer> endTimes = new ArrayList<Integer>();
            boolean printed = false;

            for (int i = 0; i < numAct; i++) {
                start[i] = in.nextInt();
                end[i] = in.nextInt();
            }

            int[] unsort = start.clone();
            int[] sortStart = new int[numAct];
            int[] sortEnd = new int[numAct];
            int[] indexOf = new int[numAct];
            boolean[] set = new boolean[numAct];

            for (int j = 0; j < numAct; j++) { // sorting
                int min = 0;
                boolean good = false;
                for (int i = numAct-1; i >= 0; i--) {
                    if (!set[i]) {
                        min = unsort[i];
                        indexOf[j] = i;
                        good = true;
                    }
                }

                if (!good) break;

                for (int i = 1; i < numAct; i++) {
                    if (!set[i] && unsort[i] < min) {
                        min = unsort[i];
                        indexOf[j] = i;
                    }
                }
                sortStart[j] = start[indexOf[j]];
                sortEnd[j] = end[indexOf[j]];
                set[indexOf[j]] = true;
            }

            for (int i = 0; i < numAct-1; i++) { // check for triples
                for (int j = 0; j < endTimes.size(); j++) {
                    if (sortStart[i] < endTimes.get(j) && sortStart[i+1] < endTimes.get(j)
                        && sortStart[i+1] < sortEnd[i]) { 
                        System.out.println("Case #"+(k+1)+": IMPOSSIBLE");
                        printed = true;
                        break;
                    }
                }
                if(printed) break;
                endTimes.add(sortEnd[i]);
            }
            if(printed) continue;

            endTimes = new ArrayList<Integer>(); // assign
            cameron[indexOf[0]] = true;
            endTimes.add(sortEnd[0]);
            for (int i = 1; i < numAct; i++) {
                cameron[indexOf[i]] = cameron[indexOf[i-1]];
                for (int j = 0; j < endTimes.size(); j++) {
                    if (sortStart[i] < endTimes.get(j)) {
                        if (sortStart[i] >= sortEnd[i-1]) {
                            cameron[indexOf[i]] = cameron[indexOf[i-1]];
                            break;
                        } else {
                            cameron[indexOf[i]] = !cameron[indexOf[i-1]];
                            break;
                        }
                    } else {
                        endTimes.remove(j);
                        j--;
                    }
                }
                endTimes.add(sortEnd[i]);
            }

            if (!printed) {
                System.out.print("Case #"+(k+1)+": ");
                for (int i = 0; i < cameron.length; i++) {
                    if (cameron[i]) System.out.print("C");
                    else System.out.print("J");
                }
                System.out.println("");
            }
        }
    }
}