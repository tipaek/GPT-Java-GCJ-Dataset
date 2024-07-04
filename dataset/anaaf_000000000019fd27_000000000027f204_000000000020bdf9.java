import java.util.*;
import java.io.*;
import java.lang.*;
public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt(); 

        for (int k = 1; k <= t; k++) {
            int activities = in.nextInt();

            ArrayList<ArrayList<Integer>> C = new ArrayList<ArrayList<Integer>>();
            ArrayList<ArrayList<Integer>> J = new ArrayList<ArrayList<Integer>>();
            ArrayList<ArrayList<Integer>> slots = new ArrayList<ArrayList<Integer>>();
            String outputStr = "";
            int cCount = 0;
            int jCount = 0;

            for (int i = 0; i < activities; i++) {
                int start = in.nextInt();
                int stop = in.nextInt();
                slots.add(new ArrayList<>(Arrays.asList(start, stop)));
            }


            for (int i = 0; i < activities; i++) {
                boolean insertion = false;
                if (i == 0) {
                    ArrayList<Integer> temp = slots.get(0);
                    C.add(new ArrayList<>(Arrays.asList(temp.get(0), temp.get(1))));
                    outputStr = outputStr + "C";
                    insertion = true;
                } else {
                    ArrayList<Integer> current = slots.get(i);
                    int currentStart = current.get(0);
                    int currentEnd = current.get(1);

                        for (int c = 0; c < C.size(); c++) {
                            ArrayList<Integer> ctemp = C.get(c);
                            if (!insertion) {
                                if (currentEnd < ctemp.get(0) || currentEnd == ctemp.get(0)) {
                                    C.add(new ArrayList<>(Arrays.asList(current.get(0), current.get(1))));
                                    outputStr = outputStr + "C";
                                    insertion = true;
                                } else if ( currentStart > ctemp.get(1) ||  currentStart == ctemp.get(1)) {
                                    C.add(new ArrayList<>(Arrays.asList(current.get(0), current.get(1))));
                                    outputStr = outputStr + "C";
                                    insertion = true;
                                }
                            }
                        }

                        if (insertion == false) {
                              if (J.isEmpty()) {
                                J.add(new ArrayList<>(Arrays.asList(current.get(0), current.get(1))));
                                outputStr = outputStr + "J";
                                insertion = true;
                            }
                            for (int j = 0; j <J.size(); j++) {
                                ArrayList<Integer> jtemp = J.get(j);
                                if (!insertion) {
                                    if (currentEnd < jtemp.get(0) || currentEnd == jtemp.get(0)) {
                                        J.add(new ArrayList<>(Arrays.asList(current.get(0), current.get(1))));
                                        outputStr = outputStr + "J";
                                        insertion = true;
                                    } else if ( currentStart > jtemp.get(1) ||  currentStart == jtemp.get(1)) {
                                        J.add(new ArrayList<>(Arrays.asList(current.get(0), current.get(1))));
                                        outputStr = outputStr + "J";
                                        insertion = true;
                                    }
                                }
                            }
                        }


                        if (insertion == false) {
                            outputStr = "IMPOSSIBLE";
                               i = activities;
                        }


                    }


                }
                
                  System.out.println("Case #" + k + ":"  +  " " + outputStr);
                
            }

        }
    }
