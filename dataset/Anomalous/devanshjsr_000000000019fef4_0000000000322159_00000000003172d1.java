import java.util.*;

public class Solution {

    public static void main(String[] args) {
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
                } else {
                    counts.set(index, counts.get(index) + 1);
                    if (counts.get(index) == d) {
                        result = 0;
                        break;
                    }
                }
            }

            if (result == 0) {
                System.out.printf("Case #%d: %d%n", caseNumber, result);
            } else {
                if (d == 2) {
                    System.out.printf("Case #%d: 1%n", caseNumber);
                } else {
                    ArrayList<Long> temp = new ArrayList<>();
                    for (int i = 0; i < angles.size(); i++) {
                        if (counts.get(i) == 2) {
                            temp.add(angles.get(i));
                        }
                    }

                    for (Long angle : temp) {
                        for (Long a : angles) {
                            if (a > angle) {
                                result = 1;
                                break;
                            }
                        }
                        if (result == 1) {
                            break;
                        }
                    }

                    if (result == 1) {
                        System.out.printf("Case #%d: 1%n", caseNumber);
                    } else {
                        Collections.sort(angles);
                        long quotient = 0;

                        if (angles.get(0) > 0) {
                            quotient = angles.get(angles.size() - 1) / angles.get(0);
                        }

                        if (quotient >= 2) {
                            System.out.printf("Case #%d: 1%n", caseNumber);
                        } else {
                            System.out.printf("Case #%d: 2%n", caseNumber);
                        }
                    }
                }
            }

            t--;
            caseNumber++;
        }
        sc.close();
    }
}