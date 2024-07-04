import java.util.*;
import java.io.*;

public class Solution {
    private static int calls = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int T = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());

        for (int counter = 1; counter <= T; counter++) {
            List<int[]> equals = new ArrayList<>();
            List<int[]> diffs = new ArrayList<>();
            calls = 0;
            char[] ansNum = new char[B + 1];

            for (int turn = 1; turn <= B / 2; turn++) {
                ansNum[turn] = queryPosition(turn, bw, br);
                ansNum[B - turn + 1] = queryPosition(B - turn + 1, bw, br);

                if (ansNum[turn] != ansNum[B - turn + 1] && diffs.isEmpty()) {
                    diffs.add(new int[]{turn, ansNum[turn]});
                } else if (equals.isEmpty()) {
                    equals.add(new int[]{turn, ansNum[turn]});
                }

                if (calls % 10 == 1) {
                    if (!equals.isEmpty() && !diffs.isEmpty()) {
                        updateArray(ansNum, equals, diffs, bw, br, turn);
                    } else if (calls != 1) {
                        int[] ind = equals.isEmpty() ? diffs.get(0) : equals.get(0);
                        updateSingle(ansNum, ind[0], bw, br, turn);
                    }
                }
            }

            bw.write(new String(ansNum, 1, B) + "\n");
            bw.flush();
            if (br.readLine().equals("N")) break;
        }

        bw.close();
        br.close();
    }

    private static char queryPosition(int position, BufferedWriter bw, BufferedReader br) throws IOException {
        bw.write(position + "\n");
        bw.flush();
        calls++;
        return br.readLine().charAt(0);
    }

    private static void updateArray(char[] ansNum, List<int[]> equals, List<int[]> diffs, BufferedWriter bw, BufferedReader br, int turn) throws IOException {
        int[] eq = equals.get(0);
        int[] diff = diffs.get(0);

        char cEq = ansNum[eq[0]];
        char cDiff = ansNum[diff[0]];

        char newEq = queryPosition(eq[0], bw, br);
        char newDiff = queryPosition(diff[0], bw, br);

        if (newDiff == cDiff && newEq != cEq) {
            complementArray(ansNum, turn);
            reverseArray(ansNum, turn);
        } else if (newEq != cEq && newDiff != cDiff) {
            complementArray(ansNum, turn);
        } else if (newEq == cEq && newDiff != cDiff) {
            reverseArray(ansNum, turn);
        }
    }

    private static void updateSingle(char[] ansNum, int index, BufferedWriter bw, BufferedReader br, int turn) throws IOException {
        char original = ansNum[index];
        char newChar = queryPosition(index, bw, br);
        if (original != newChar) {
            complementArray(ansNum, turn);
        }
    }

    private static void complementArray(char[] array, int turn) {
        for (int i = 1; i < turn; i++) {
            array[i] = toggleChar(array[i]);
            array[array.length - i] = toggleChar(array[array.length - i]);
        }
    }

    private static char toggleChar(char c) {
        return c == '0' ? '1' : '0';
    }

    private static void reverseArray(char[] array, int turn) {
        for (int i = 1; i < turn; i++) {
            char temp = array[i];
            array[i] = array[array.length - i];
            array[array.length - i] = temp;
        }
    }
}