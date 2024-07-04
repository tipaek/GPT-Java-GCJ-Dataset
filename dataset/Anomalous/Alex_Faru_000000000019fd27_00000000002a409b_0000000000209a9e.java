import java.io.*;
import java.util.*;

public class Solution {
    public static int calls = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int T = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());

        for (int t = 0; t < T; t++) {
            List<int[]> equals = new ArrayList<>();
            List<int[]> dif = new ArrayList<>();
            char[] ansNum = new char[B + 1];
            calls = 0;

            for (int turn = 1; turn <= B / 2; turn++) {
                ansNum[turn] = queryAndReadResponse(bw, br, turn);
                ansNum[B - turn + 1] = queryAndReadResponse(bw, br, B - turn + 1);

                if (calls % 10 == 1) {
                    if (!equals.isEmpty() && !dif.isEmpty()) {
                        update(ansNum, equals, dif, bw, br, turn);
                    } else if (calls != 1) {
                        int[] ind = equals.isEmpty() ? dif.get(0) : equals.get(0);
                        update2(ansNum, ind[0], bw, br, turn);
                    }
                }

                if (ansNum[turn] != ansNum[B - turn + 1]) {
                    if (dif.isEmpty()) {
                        dif.add(new int[]{turn, ansNum[turn]});
                    }
                } else {
                    if (equals.isEmpty()) {
                        equals.add(new int[]{turn, ansNum[turn]});
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

    private static char queryAndReadResponse(BufferedWriter bw, BufferedReader br, int index) throws IOException {
        bw.write(index + "\n");
        bw.flush();
        calls++;
        return br.readLine().charAt(0);
    }

    private static void update(char[] ansNum, List<int[]> equals, List<int[]> dif, BufferedWriter bw, BufferedReader br, int turn) throws IOException {
        int[] ee = equals.get(0);
        int[] dd = dif.get(0);
        char cE = ansNum[ee[0]];
        char cD = ansNum[dd[0]];

        char cEE = queryAndReadResponse(bw, br, ee[0]);
        char cDD = queryAndReadResponse(bw, br, dd[0]);

        if (cDD == cD && cEE != cE) {
            complement(ansNum, turn);
            reverse(ansNum, turn);
        } else if (cEE != cE && cDD != cD) {
            complement(ansNum, turn);
        } else if (cEE == cE && cDD != cD) {
            reverse(ansNum, turn);
        }
    }

    private static void update2(char[] ansNum, int index, BufferedWriter bw, BufferedReader br, int turn) throws IOException {
        char c1 = ansNum[index];
        char c2 = queryAndReadResponse(bw, br, index);
        if (c1 != c2) {
            complement(ansNum, turn);
        }
    }

    private static void complement(char[] ansNum, int turn) {
        for (int i = 1; i < turn; i++) {
            ansNum[i] = (ansNum[i] == '0') ? '1' : '0';
            ansNum[ansNum.length - i] = (ansNum[ansNum.length - i] == '0') ? '1' : '0';
        }
    }

    private static void reverse(char[] ansNum, int turn) {
        for (int i = 1; i < turn; i++) {
            char temp = ansNum[i];
            ansNum[i] = ansNum[ansNum.length - i];
            ansNum[ansNum.length - i] = temp;
        }
    }
}