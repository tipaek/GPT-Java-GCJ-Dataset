import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);

        int testCases = scanner.nextInt();
        int caseNumber = 1;

        while (testCases > 0) {
            int n = scanner.nextInt();
            int d = scanner.nextInt();

            int result = -1;
            ArrayList<Long> angles = new ArrayList<>();
            ArrayList<Long> counts = new ArrayList<>();

            for (int i = 0; i < n; i++) {
                long angle = scanner.nextLong();
                int index = angles.indexOf(angle);

                if (index < 0) {
                    angles.add(angle);
                    counts.add(1L);
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
                    for (int i = 0; i < counts.size(); i++) {
                        if (counts.get(i) == 2) {
                            temp.add(angles.get(i));
                        }
                    }

                    for (Long angle : temp) {
                        for (Long ang : angles) {
                            if (ang > angle) {
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
                        if ((angles.get(angles.size() - 1) / angles.get(0)) >= 2) {
                            System.out.println("Case #" + caseNumber + ": 1");
                        } else {
                            System.out.println("Case #" + caseNumber + ": 2");
                        }
                    }
                }
            }

            testCases--;
            caseNumber++;
        }
        scanner.close();
    }
}