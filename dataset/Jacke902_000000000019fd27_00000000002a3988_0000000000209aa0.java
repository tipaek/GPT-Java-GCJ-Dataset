import java.util.*;

public class Solution {

    public static void main (String args[]) {

        Scanner scan = new Scanner(System.in);
        int numberOfCases = scan.nextInt();
        //start each case
        int counter = 1;
        scan.nextLine();
        while ( counter <= numberOfCases) {
            Boolean checkTrace = null;

            String numbers[] = scan.nextLine().split(" ");

            int n = Integer.parseInt(numbers[0]);
            int trace = Integer.parseInt(numbers[1]);
            if(n<2) {
                checkTrace = false;
            } else {
                if (n == 2) {
                    if (trace != n && trace != (n * n)) {
                        checkTrace = false;
                    }
                }

                if (checkTrace == null && n == 3) {
                    if (trace == n || trace == (n * n)) {
                        checkTrace = true;
                    } else {
                        int sumatoria = 0;
                        for (int i = 1; i <= n; i++) {
                            sumatoria += i;
                        }
                        if (sumatoria == trace) {
                            checkTrace = true;
                        }
                    }
                }

                if (checkTrace == null && n > 3) {

                    if (trace < n || trace > (n * n)) {
                        checkTrace = false;
                    } else {
                        if (trace == n || trace == (n * n)) {
                            checkTrace = true;
                        } else {
                            int sumatoria = 0;
                            for (int i = 1; i <= n; i++) {
                                int allEquals = i * n;
                                int minusEquals = i * (n - 2);
                                int minimumPossible = 2;
                                int maximumPossible = n * 2;
                                if (allEquals == trace) {
                                    checkTrace = true;
                                    break;
                                }

                                if (trace > (minusEquals + minimumPossible - 1) && trace < (minusEquals + maximumPossible + 1)) {
                                    checkTrace = true;
                                    break;
                                }
                                sumatoria += i;
                            }
                            if (sumatoria == trace) {
                                checkTrace = true;
                            }
                        }
                    }
                }
            }
            String text = checkTrace?"POSSIBLE":"IMPOSSIBLE";
            System.out.println("Case #"+counter+": "+text);
            counter++;
        }
    }
}

