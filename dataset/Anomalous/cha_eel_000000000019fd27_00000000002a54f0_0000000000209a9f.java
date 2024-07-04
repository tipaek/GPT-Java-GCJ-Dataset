import java.math.*;
import java.util.*;
import java.io.*;

public class Solution {

    static final int TEST_MODE = 10; // 0 for local testing, 1 for standard input
    static final String INPUT_FILE = "../in";
    static final int INFINITY = 1_000_000;

    static BufferedReader in;
    static PrintWriter out = new PrintWriter(System.out);

    public static void main(String[] args) throws Exception {
        if (TEST_MODE > 0) {
            in = new BufferedReader(new InputStreamReader(System.in));
        } else {
            in = new BufferedReader(new FileReader(INPUT_FILE));
        }

        int testCases = readInt();
        for (int testCase = 1; testCase <= testCases; testCase++) {
            String inputStr = in.readLine();
            int n = inputStr.length();
            
            Deque<Integer> numQueue = new ArrayDeque<>();
            Deque<String> strQueue = new ArrayDeque<>();
            
            for (char c : inputStr.toCharArray()) {
                int val = c - '0';
                numQueue.offerLast(val);
                strQueue.offerLast(String.valueOf(c));
            }

            for (int i = 9; i >= 1; i--) {
                Deque<Integer> tempNumQueue = new ArrayDeque<>();
                Deque<String> tempStrQueue = new ArrayDeque<>();
                
                while (!numQueue.isEmpty()) {
                    if (numQueue.peekFirst() < i) {
                        tempNumQueue.offerLast(numQueue.pollFirst());
                        tempStrQueue.offerLast(strQueue.pollFirst());
                    } else {
                        StringBuilder ss = new StringBuilder();
                        while (!numQueue.isEmpty() && numQueue.peekFirst() == i) {
                            numQueue.pollFirst();
                            ss.append(strQueue.pollFirst());
                        }
                        tempNumQueue.offerLast(i - 1);
                        tempStrQueue.offerLast("(" + ss + ")");
                    }
                }
                numQueue = tempNumQueue;
                strQueue = tempStrQueue;
            }

            StringBuilder result = new StringBuilder();
            while (!strQueue.isEmpty()) {
                result.append(strQueue.pollFirst());
            }
            out.printf("Case #%d: %s\n", testCase, result.toString());
        }
        out.flush();
    }

    static int readInt() throws IOException {
        return Integer.parseInt(in.readLine());
    }
}