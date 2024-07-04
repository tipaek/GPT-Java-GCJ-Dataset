import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.LinkedList;

public class Solution {

    static LinkedList<State> stateList;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter printWriter = new PrintWriter(new OutputStreamWriter(System.out));
        int testCases = Integer.parseInt(bufferedReader.readLine());

        for (int testCase = 1; testCase <= testCases; testCase++) {
            stateList = new LinkedList<>();
            printWriter.println("Case #" + testCase + ": ");
            int N = Integer.parseInt(bufferedReader.readLine());

            if (N == 1) {
                printWriter.println("1 1");
            } else if (N == 2) {
                printWriter.println("1 1");
                printWriter.println("2 1");
            } else if (N == 3) {
                printWriter.println("1 1");
                printWriter.println("2 1");
                printWriter.println("3 1");
            } else {
                printWriter.println("1 1");
                printWriter.println("2 1");
                printWriter.println("3 2");
                N -= 4;
                int currentRow = 3;
                while (N - currentRow >= 0) {
                    N -= currentRow;
                    printWriter.println((currentRow + 1) + " 2");
                    currentRow++;
                }
                while (N != 0) {
                    N--;
                    printWriter.println(currentRow + " 1");
                    currentRow++;
                }
            }
        }
        printWriter.close();
    }

    public static boolean dfs(int steps, int up, int down, int lastUp, int lastDown, long value, int goal) {
        if (up < 0 || down < 0 || down > up || steps > 500 || up == lastUp || down == lastDown) {
            return false;
        }
        return value == goal;
    }

    static class State {
        int x;
        int y;

        public State(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}