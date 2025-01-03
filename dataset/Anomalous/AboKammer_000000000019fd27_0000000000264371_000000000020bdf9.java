import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.next());
        
        for (int i = 0; i < n; i++) {
            int n1 = Integer.parseInt(sc.next());
            String[] intervals = new String[n1];
            String result = "";
            ArrayList<String> assignments = new ArrayList<>(Collections.nCopies(n1, ""));
            
            for (int j = 0; j < n1; j++) {
                intervals[j] = sc.next() + " " + sc.next();
            }
            
            boolean impossible = false;
            
            for (int j = 0; j < n1 && !impossible; j++) {
                for (int k = j + 1; k < n1 && !impossible; k++) {
                    String[] interval1 = intervals[j].split(" ");
                    String[] interval2 = intervals[k].split(" ");
                    int start1 = Integer.parseInt(interval1[0]);
                    int end1 = Integer.parseInt(interval1[1]);
                    int start2 = Integer.parseInt(interval2[0]);
                    int end2 = Integer.parseInt(interval2[1]);
                    
                    boolean overlap = (start1 < end2 && end1 > start2) || (start2 < end1 && end2 > start1);
                    
                    if (overlap) {
                        if (assignments.get(j).isEmpty()) {
                            if (assignments.get(k).isEmpty()) {
                                assignments.set(j, "C");
                                assignments.set(k, "J");
                            } else if (assignments.get(k).equals("J")) {
                                assignments.set(j, "C");
                            } else if (assignments.get(k).equals("C")) {
                                assignments.set(j, "J");
                            }
                        } else if (assignments.get(j).equals("C")) {
                            if (assignments.get(k).isEmpty()) {
                                assignments.set(k, "J");
                            } else if (assignments.get(k).equals("C")) {
                                result = "IMPOSSIBLE";
                                impossible = true;
                            }
                        } else if (assignments.get(j).equals("J")) {
                            if (assignments.get(k).isEmpty()) {
                                assignments.set(k, "C");
                            } else if (assignments.get(k).equals("J")) {
                                result = "IMPOSSIBLE";
                                impossible = true;
                            }
                        }
                    } else {
                        if (assignments.get(j).isEmpty()) {
                            assignments.set(j, "C");
                        }
                        if (assignments.get(k).isEmpty()) {
                            assignments.set(k, "C");
                        }
                    }
                }
            }
            
            if (result.isEmpty()) {
                for (String assignment : assignments) {
                    result += assignment;
                }
            }
            
            System.out.println("Case #" + (i + 1) + ": " + result);
        }
        
        sc.close();
    }
}