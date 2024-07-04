import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class PPR {

    public static final PrintStream out = System.out;
    public static final BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    public int numCases;

    public static void main(String[] args) {
        try {
            new PPR().run();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void run() throws IOException {
        numCases = Integer.parseInt(in.readLine().trim());
        for (int i = 1; i <= numCases; i++) {
            doCase(i);
        }
    }

    public void doCase(int caseNumber) throws IOException {
        long N = Long.parseLong(in.readLine());
        char[] result = new char[(int) N];
        LinkedList<Integer> J = new LinkedList<>();
        LinkedList<Integer> C = new LinkedList<>();
        boolean isPossible = true;

        for (int i = 0; i < N; i++) {
            String[] splitArray = in.readLine().split(" ");
            int start = Integer.parseInt(splitArray[0]);
            int end = Integer.parseInt(splitArray[1]);

            if (J.isEmpty() && C.isEmpty()) {
                J.add(start);
                J.add(end);
                result[i] = 'J';
            } else if (J.isEmpty()) {
                if (C.getLast() <= start) {
                    C.addLast(start);
                    C.addLast(end);
                    result[i] = 'C';
                } else if (C.getFirst() >= end) {
                    C.addFirst(end);
                    C.addFirst(start);
                    result[i] = 'C';
                } else {
                    J.add(start);
                    J.add(end);
                    result[i] = 'J';
                }
            } else if (C.isEmpty()) {
                if (J.getLast() <= start) {
                    J.addLast(start);
                    J.addLast(end);
                    result[i] = 'J';
                } else if (J.getFirst() >= end) {
                    J.addFirst(end);
                    J.addFirst(start);
                    result[i] = 'J';
                } else {
                    C.add(start);
                    C.add(end);
                    result[i] = 'C';
                }
            } else {
                if (J.getLast() <= start) {
                    J.addLast(start);
                    J.addLast(end);
                    result[i] = 'J';
                } else if (J.getFirst() >= end) {
                    J.addFirst(end);
                    J.addFirst(start);
                    result[i] = 'J';
                } else if (C.getLast() <= start) {
                    C.addLast(start);
                    C.addLast(end);
                    result[i] = 'C';
                } else if (C.getFirst() >= end) {
                    C.addFirst(end);
                    C.addFirst(start);
                    result[i] = 'C';
                } else {
                    isPossible = false;
                    out.printf("Case #%d: IMPOSSIBLE%n", caseNumber);
                    break;
                }
            }
        }

        if (isPossible) {
            out.printf("Case #%d: %s%n", caseNumber, new String(result));
        }
    }
}