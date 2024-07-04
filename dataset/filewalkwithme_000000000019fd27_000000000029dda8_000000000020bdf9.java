import java.util.*;
import java.io.*;

class Activity implements Comparable<Activity> {
    int ini;
    int end;

    @Override
    public int compareTo(Activity a) 
    {
        return this.ini-a.ini;
    }

    @Override
    public boolean equals(Object o) {
        return this.ini == ((Activity)o).ini && this.end == ((Activity)o).end;
    }

    public String toString() {
        return this.ini+":"+this.end;
    }
}

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt();  // Scanner has functions to read ints, longs, strings, chars, etc.

        for (int k = 1; k <= t; k++) {
            int n = in.nextInt();

            Integer[][] tasks = new Integer[n][2];

            for (int i=0;i<n;i++){
                tasks[i][0] = in.nextInt();
                tasks[i][1] = in.nextInt();
            }

            String res = solve(tasks);

            // System.out.println(Arrays.deepToString(tasks));
            System.out.println("Case #" + k + ": " + res );
        }
    }

    public static String solve(Integer[][] tasks){
        TreeSet<Activity> J = new TreeSet<>(); 
        TreeSet<Activity> C = new TreeSet<>(); 
        return nextValid(tasks, "", J, C);
    }

    public static String nextValid(Integer[][] tasks, String str, TreeSet<Activity> J, TreeSet<Activity> C) {
        if (str.length()>tasks.length) {
            return "IMPOSSIBLE";
        }
        // System.out.println(str);
        char[] arr = str.toCharArray();

        Activity a = new Activity();
        a.ini = tasks[arr.length][0];
        a.end = tasks[arr.length][1];

        boolean addToJ = false;
        if (J.size()==0) {
            addToJ = true;
        }

        if (!addToJ) {
            if (!J.contains(a)) {
                Activity before = J.lower(a);
                Activity after = J.higher(a);

                if (before==null) {
                    if (a.end <= after.ini) {
                        addToJ = true;
                    }
                } else {
                    if (before.end <= a.ini) {
                        if (after==null) {
                            addToJ = true;
                        } else {
                            if (a.end <= after.ini) {
                                addToJ = true;
                            }
                        }
                    }
                }
            } 
        }

        if (addToJ) {
            J.add(a);
            if (arr.length==tasks.length-1){
                return str+"J";
            }
            String res = nextValid(tasks, str+"J", J, C);
            if (!res.equals("IMPOSSIBLE")) {
                J.remove(a);
                return res;
            }
        }

        boolean addToC = false;
        if (C.size()==0) {
            addToC = true;
        }

        if (!addToC) {
            if (!C.contains(a)) {
                Activity before = C.lower(a);
                Activity after = C.higher(a);

                if (before==null) {
                    if (a.end <= after.ini) {
                        addToC = true;
                    }
                } else {
                    if (before.end <= a.ini) {
                        if (after==null) {
                            addToC = true;
                        } else {
                            if (a.end <= after.ini) {
                                addToC = true;
                            }
                        }
                    }
                }
            } 
        }

        if (addToC) {
            C.add(a);
            if (arr.length==tasks.length-1){
                return str+"C";
            }
            String res = nextValid(tasks, str+"C", J, C);
            if (!res.equals("IMPOSSIBLE")) {
                C.remove(a);
                return res;
            }
        }

        return "IMPOSSIBLE";
    }
}