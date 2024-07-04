import java.util.*;
import java.io.*;
import java.util.stream.Collectors;

public class Solution {

    private static final Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));

    private final int b;
    private final int testCase;
    private int queries = 0;

    public Solution(int testCase, int b) {
        this.b = b;
        this.testCase = testCase;
    }

    private int askPosition(int n) {
        printLine(n);
        String p = in.nextLine();
        queries++;
        return Integer.parseInt(p);
    }

    private void complement(int a[]) {
        for (int i=0;i<a.length;i++) {
            if (a[i] != -1) {
                a[i] = (a[i]+1) % 2;
            }
        }
    }

    private void reverse(int a[]) {
        int mid = a.length / 2;

        for (int i=0;i<mid;i++) {
            int t = a[i];
            a[i] = a[a.length - i - 1];
            a[a.length - i - 1] = t;
        }
    }

    private boolean match(int a[], int start, int mid, int end) {
        return a[0] == start && a[a.length/2] == mid && a[a.length-1] == end;
    }

    private int getNextPosition(int a[]) {
        if (a[0] == -1) {
            return 0;
        } else if (a[(a.length-1)/2] == -1) {
            return (a.length-1)/2;
        } else if (a[a.length-1] == -1) {
            return a.length-1;
        } else {
            for (int i = 0; i < a.length; i++) {
                if (a[i] == -1) {
                    return i;
                }
            }
        }

        return -1;
    }

    private void printLine(Object o) {
        System.out.println(o);
        System.out.flush();
    }

    private void solve() {
        int a[] = new int[b];
        boolean done = false;

        Arrays.fill(a, -1);

        int cnt = 1;
        int i = 0;

        while (getNextPosition(a) != -1 && queries < 150) {
            if (queries > 1 && queries % 10 == 1) {
                int start = askPosition(1);
                int mid = askPosition(b / 2);
                int end = askPosition(b);

                int a1[] = a.clone();
                reverse(a1);

                int a2[] = a.clone();
                complement(a2);

                int a3[] = a.clone();
                reverse(a3);
                complement(a3);

                if (match(a1, start, mid, end)) {
                    a = a1;
                } else if (match(a2, start, mid, end)) {
                    a = a2;
                } else if (match(a3, start, mid, end)) {
                    a = a3;
                }
            } else {
                int nextIndex = getNextPosition(a);
                if (nextIndex == -1) {
                    break;
                }

                int p = askPosition(nextIndex+1);
                a[nextIndex] = p;
            }
        }

        while (getNextPosition(a) != -1) {
            int index = getNextPosition(a);
            if (Math.random() < 0.5) {
                a[index] = 0;
            } else {
                a[index] = 1;
            }
        }

        printLine(toString(a));

        String feedback = in.nextLine();

        if ("N".equals(feedback)) {
            System.exit(0);
        }
    }

    private String toString(int a[]) {
        return Arrays.stream(a).mapToObj(String::valueOf).collect(Collectors.joining(""));
    }

    public static void main(String[] args) {
        int t = in.nextInt();
        int b = in.nextInt();
        in.nextLine();

        for (int i = 1; i <= t; ++i) {
            new Solution(i, b).solve();
        }

        in.close();
        
        System.exit(0);
    }
}