import java.util.Scanner;

public class Solution {
    public static void main (String[] args ) {
        Scanner in = new Scanner(System.in);
        int c = in.nextInt();

        for (int i = 0; i < c; i++) {
            int a = in.nextInt();
            in.nextLine();
            boolean possible = true;
            String first = "J";
            String[] time = new String[1441];
            StringBuilder order = new StringBuilder();
            for (int j = 0; j < a; j++) {
                boolean firstWorks = true;
                boolean other = false;
                String[] startEnd = in.nextLine().split(" ");
                int start = Integer.parseInt(startEnd[0]);
                int end = Integer.parseInt(startEnd[1]);
                if (start == 1440 && end == 1440) {
                    if (time[1440].equals("C")) {
                        first = "J";
                    } else if (time[1440].equals("J")) {
                        first = "C";
                    } else if (time.equals("CJ") || time.equals("JC")) {
                        order.setLength(0);
                        order.append("IMPOSSIBLE");
                        break;
                    }
                } else {
                    if (time[start + 1] == null || time[start + 1].equals("C")) {
                        first = "J";
                    } else if (time[start + 1].equals("J")) {
                        first = "C";
                    } else {
                        order.setLength(0);
                        order.append("IMPOSSIBLE");
                        break;
                    }
                    for (int m = start; m <= end; m++) {
                        if (m == start) {
                            if (time[m] != null && time[m + 1] != null && time[m + 1].equals(first)) {
                                firstWorks = false;
                            } else if (time[m] != null && time[m].equals(first.equals("J") ? "C" : "J")) {
                                other = true;
                            } else {
                                continue;
                            }
                        } else if (time[m] == null || (!time[m].equals("JC") && !time[m].equals("CJ")) ||
                                (!time[m].equals(first.equals("J") ? "JJ" : "CC")) ||
                                (!time[m].equals("JCJ") || time[m].equals("CJC"))) {
                            if (time[m] != null && time[m].equals(first.equals("J") ? "C" : "J")) {
                                other = true;
                            } else if (time[m] != null) {
                                firstWorks = false;
                            } else {
                                continue;
                            }
                            if (other && !firstWorks) {
                                order.setLength(0);
                                order.append("IMPOSSIBLE");
                                possible = false;
                                break;
                            }
                        } else {
                            order.setLength(0);
                            order.append("IMPOSSIBLE");
                            possible = false;
                            break;
                        }
                    }
                }
                if (!possible) break;
                if (!firstWorks) first = first.equals("J")? "C" : "J";
                for (int k = start; k <= end; k++) {
                    if (time[k] == null) {
                        time[k] = first;
                    } else {
                        time[k] += first;
                    }
                }
                order.append(first);
            }
            int caseNum = i + 1;
            System.out.println("Case #" + caseNum + ": " + order);
        }
    }
}
