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
        return this.ini == ((Activity)o).ini;
    }
}

public class Solution {


    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt();  // Scanner has functions to read ints, longs, strings, chars, etc.

        for (int k = 1; k <= t; k++) {
            int n = in.nextInt();

            StringBuilder res = new StringBuilder();
            boolean impossible = false;

            TreeSet<Activity> J = new TreeSet<>(); 
            TreeSet<Activity> C = new TreeSet<>(); 
            for (int i=0; i<n; i++){
                Activity a = new Activity();
                a.ini = in.nextInt();
                a.end = in.nextInt();

                if (impossible) {
                    continue;
                }

                if (J.size()==0) {
                    J.add(a);
                    res.append('J');
                    continue;
                }

                if (C.size()==0) {
                    C.add(a);
                    res.append('C');
                    continue;
                }

                // J and C have at least one element

                if (!J.contains(a)) {
                    Activity before = J.lower(a);
                    Activity after = J.higher(a);

                    if (before==null) {
                        if (a.end <= after.ini) {
                            J.add(a);
                            res.append('J');
                            continue;
                        }
                    } else {
                        if (before.end <= a.ini) {
                            if (after==null) {
                                J.add(a);
                                res.append('J');
                                continue;
                           } else {
                                if (a.end <= after.ini) {
                                    J.add(a);
                                    res.append('J');
                                    continue;
                                }
                            }
                        }
                    }
                } 

                if (!C.contains(a)) {
                    Activity before = C.lower(a);
                    Activity after = C.higher(a);

                    if (before==null) {
                        if (a.end <= after.ini) {
                            C.add(a);
                            res.append('C');
                            continue;
                        }
                    } else {
                        if (before.end <= a.ini) {
                            if (after==null) {
                                C.add(a);
                                res.append('C');
                                continue;
                           } else {
                                if (a.end <= after.ini) {
                                    C.add(a);
                                    res.append('C');
                                    continue;
                                }
                            }
                        }
                    }
                } 

                // System.out.println("imp: "+i+" a.ini: "+a.ini+" a.end: "+a.end);
                res.setLength(0);
                res.append("IMPOSSIBLE");
                impossible=true;
            }

            System.out.println("Case #" + k + ": " + res.toString());
        }
    }
}