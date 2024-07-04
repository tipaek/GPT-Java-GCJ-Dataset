import java.util.*;
import java.io.*;

public class Solution {
    // DO NOT MODIFY THE ARGUMENTS WITH "final" PREFIX. IT IS READ ONLY

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();
        int caseNumber = 1;

        while (t > 0) {
            int n = sc.nextInt();
            int d = sc.nextInt();

            int result = -1;
            ArrayList<Long> angles = new ArrayList<>();
            ArrayList<Long> counts = new ArrayList<>();

            for (int i = 0; i < n; i++) {
                long angle = sc.nextLong();
                int index = angles.indexOf(angle);

                if (index < 0) {
                    angles.add(angle);
                    counts.add(1L);

                    if (d == 1) {
                        result = 0;
                        break;
                    }
                } else {
                    counts.set(index, counts.get(index) + 1);
                    if (counts.get(index) == d) {
                        result = 0;
                        break;
                    }
                }
            }

            if (result == 0) {
                System.out.println("Case #" + caseNumber + ": " + result);
            } else {
                if (d == 2) {
                    System.out.println("Case #" + caseNumber + ": 1");
                } else {
                    ArrayList<Long> temp = new ArrayList<>();
                    for (int i = 0; i < angles.size(); i++) {
                        if (counts.get(i) == 2) {
                            temp.add(angles.get(i));
                        }
                    }

                    for (Long tmpAngle : temp) {
                        for (Long angle : angles) {
                            if (angle > tmpAngle) {
                                result = 1;
                                break;
                            }
                        }
                        if (result == 1) {
                            break;
                        }
                    }

                    if (result == 1) {
                        System.out.println("Case #" + caseNumber + ": 1");
                    } else {
                        Collections.sort(angles);
                        int size = angles.size();
                        long maxAngle = angles.get(size - 1);
                        long ratio = 0;
                        if (angles.get(0) > 0) {
                            ratio = maxAngle / angles.get(0);
                        }

                        if (ratio >= 2) {
                            System.out.println("Case #" + caseNumber + ": 1");
                        } else {
                            System.out.println("Case #" + caseNumber + ": 2");
                        }
                    }
                }
            }

            t--;
            caseNumber++;
        }
    }
}