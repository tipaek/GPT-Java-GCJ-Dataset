import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter writer = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        
        int numCases = Integer.parseInt(reader.readLine());
        for (int caseN = 1; caseN <= numCases; caseN++) {
            int numActs = Integer.parseInt(reader.readLine());
            Act[] actSort = new Act[numActs * 2];
            for (int i = 0; i < numActs; i++) {
                StringTokenizer st = new StringTokenizer(reader.readLine());
                int start = Integer.parseInt(st.nextToken());
                int end = Integer.parseInt(st.nextToken());
                actSort[i * 2] = new Act(true, start, i);
                actSort[i * 2 + 1] = new Act(false, end, i);
            }
            
            char[] actPars = new char[numActs];
            int[] pars = new int[2];
            Arrays.fill(pars, -1);
            Arrays.sort(actSort);
            boolean pos = true;
            for (Act act : actSort) {
                if (act.start) {
                    if (pars[0] == -1) {
                        pars[0] = act.id;
                        actPars[act.id] = 'C';
                    } else if (pars[1] == -1) {
                        pars[1] = act.id;
                        actPars[act.id] = 'J';
                    } else {
                        pos = false;
                        writer.println("Case #" + caseN + ": IMPOSSIBLE");
                        break;
                    }
                } else {
                    if (pars[0] == act.id) {
                        pars[0] = -1;
                    } else {
                        pars[1] = -1;
                    }
                }
            }
            if (!pos) {
                continue;
            }
            
            writer.print("Case #" + caseN + ": ");
            writer.println(actPars);
        }
        reader.close();
        writer.close();
    }
    
    private static class Act implements Comparable<Act> {
        public boolean start;
        public int time;
        public int id;
        
        public Act(boolean s, int t, int i) {
            start = s;
            time = t;
            id = i;
        }
        
        public int compareTo(Act other) {
            if (time != other.time) {
                return time - other.time;
            }
            if (start && !other.start) {
                return 1;
            }
            return -1;
        }
    }
}