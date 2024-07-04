import java.util.*;
import java.io.*;
public class Solution {
    
    public static void main (String args[]) {
        
        int startTimes[];
        int finishTimes[];
        
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int T = in.nextInt();
        ArrayList<ArrayList<String>> result = new ArrayList<ArrayList<String>>();
        
        for (int i = 0; i < T; i++) {
            
            int N = in.nextInt();
            startTimes = new int[N];
            finishTimes = new int[N];
            int startCount = 0;
            int FinishCount = 0;
            
            int ceiling = (int)Math.ceil((double)N/2);
            
            for (int j = 0; j < (N * 2); j++) {
                int M = in.nextInt();
                
                if ( (j % 2) == 0) {
                    startTimes[startCount] = M;
                    startCount++;
                    
                } else {
                    finishTimes[FinishCount] = M;
                    FinishCount++;
                }
            }
            
            // If a End Time is Greater than More than Half
            // Of the Start times. THen IMPOSSIBLE
                ArrayList<String> Stringresults = new ArrayList<String>();
                result.add(Stringresults);
                boolean possible = true;
                for (int n = 0; n < N; n++) {
                    int count = 0;
                    if (possible == true)
                    for (int k = 0; k < N; k++) {
                        //count = 0;
                        if ((k != n) && (finishTimes[n ] > startTimes[k])) {
                            
                            // Does the start time overlap with the end time?
                            if (finishTimes[k] > startTimes[n])
                            count++;
                            //System.out.println("Finish: " + finishTimes[n] + " Starttimes: "+ startTimes[k]);
                        }
                        //System.out.println(count);
                        if (count >= ceiling) {
                            Stringresults.add("IMPOSSIBLE");
                            possible = false;
                            //System.out.println("Ceiling: " + ceiling + " " + "IMpossible");
                            break;
                            
                        }
                    }
                }
                if (possible == true) {
                    // Allocate Cases
                    int prev = 0;
                    int CcurrentStart = -1;
                    int CcurrentEnd = -1;
                    
                    int JcurrentStart = -1;
                    int JcurrentEnd = -1;
                    
                    // Create a Backlog of Arrays
                    int backlogC[] = new int[N];
                    int backlogJ[] = new int[N];
                    for (int n = 0; n < N; n++) {
                        // Do each case One by One
                        int count = 0;
                        int count2 = 0;
                        if (n == 0) {
                            Stringresults.add("C");
                            CcurrentStart = startTimes[n];
                            CcurrentEnd = finishTimes[n];
                        } else {
                            if ((CcurrentStart >= startTimes[n] && CcurrentStart >= finishTimes[n]) ||
                                (CcurrentStart <= startTimes[n] && (CcurrentEnd <= finishTimes[n] && CcurrentEnd <= startTimes[n]) ||
                                    CcurrentEnd <= startTimes[n])) {
                                        int check = 0;
                                        
                                        for (int a = 0; a < (N - 1); a += 2) {
                                            if ((backlogC[a] >= startTimes[n] && backlogC[a] >= finishTimes[n]) ||
                                (backlogC[a] <= startTimes[n] && (backlogC[a+1] <= finishTimes[n] && backlogC[a+1] <= startTimes[n]) ||
                                    CcurrentEnd <= startTimes[n])) {
                                        Stringresults.add("J");
                                JcurrentStart = startTimes[n];
                                JcurrentEnd = finishTimes[n];
                                check = 1;
                                backlogJ[count] = startTimes[n];
                                count++;
                                backlogJ[count] = finishTimes[n];
                                count++;
                                    }
                                    
                                        }
                                        if (check == 0) {
                                Stringresults.add("C");
                                CcurrentStart = startTimes[n];
                                CcurrentEnd = finishTimes[n];
                                backlogC[count] = startTimes[n];
                                count++;
                                backlogC[count] = finishTimes[n];
                                count++;
                                        }
                                } else if ((JcurrentStart >= startTimes[n] && CcurrentStart >= finishTimes[n]) || JcurrentStart == - 1 ||
                             (JcurrentStart <= startTimes[n] && (JcurrentEnd <= finishTimes[n]  && JcurrentEnd <= startTimes[n] ) ||
                              JcurrentStart <= startTimes[n])) {
                                  int check = 0;
                                        
                                        for (int a = 0; a < (N - 1); a += 2) {
                                            if ((backlogJ[a] >= startTimes[n] && backlogJ[a] >= finishTimes[n]) ||
                                (backlogJ[a] <= startTimes[n] && (backlogJ[a+1] <= finishTimes[n] && backlogJ[a+1] <= startTimes[n]) ||
                                backlogJ[a] <= startTimes[n])) {
                                    Stringresults.add("C");
                                CcurrentStart = startTimes[n];
                                CcurrentEnd = finishTimes[n];
                                backlogC[count] = startTimes[n];
                                count++;
                                backlogC[count] = finishTimes[n];
                                count++;
                                    }
                                    
                                        }
                                        if (check == 0) {
                                Stringresults.add("J");
                                JcurrentStart = startTimes[n];
                                JcurrentEnd = finishTimes[n];
                                backlogJ[count] = startTimes[n];
                                count++;
                                backlogJ[count] = finishTimes[n];
                                count++;
                                        }
                                            
                                        }
                            
                        }
                    }
                }
                //if it is not impossible
                // Allocate cases
                
            }
            for (int m = 0; m < T; m++) {
                    System.out.print("Case #" + (m + 1) + ": ");
                    for (int b = 0; b < result.get(m).size(); b++) {
                        System.out.print(result.get(m).get(b));
                    }
                    System.out.println();
                }
            
        }
        
    }