import java.util.*;
import java.io.*;

class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int T = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        int counter = 1;

        char[] ansNum = new char[B + 1];
        List<int[]> equals = new ArrayList<>();
        List<int[]> dif = new ArrayList<>();
        int calls = 0;

        while (counter <= T) {
            int turn = 1;

            while (turn <= B / 2) {
                // Query the first position
                bw.write(turn + "\n");
                bw.flush();
                char cc = br.readLine().charAt(0);
                ansNum[turn] = cc;
                calls++;

                if (calls % 10 == 1) {
                    if (!equals.isEmpty() && !dif.isEmpty()) {
                        update(ansNum, equals, dif, bw, br, turn);
                    } else if (calls != 1) {
                        int[] ind = equals.isEmpty() ? dif.get(0) : equals.get(0);
                        update2(ansNum, ind[0], bw, br, turn);
                    }
                }

                // Query the symmetric position
                bw.write((B - turn + 1) + "\n");
                bw.flush();
                char cs = br.readLine().charAt(0);
                ansNum[B - turn + 1] = cs;
                calls++;

                if (cs != cc && dif.isEmpty()) {
                    dif.add(new int[]{turn, cc});
                } else if (equals.isEmpty()) {
                    equals.add(new int[]{turn, cc});
                }

                turn++;
            }

            String ans = new String(ansNum, 1, B);
            bw.write(ans + "\n");
            bw.flush();
            String feedback = br.readLine();
            if (feedback.equals("N")) {
                break;
            }
            counter++;
        }

        bw.close();
        br.close();
    }

    public static void update(char[] ansNum, List<int[]> equals, List<int[]> dif, BufferedWriter bw, BufferedReader br, int turn) throws IOException {
        int[] ee = equals.get(0);
        int[] dd = dif.get(0);
        char cE = ansNum[ee[0]];
        char cD = ansNum[dd[0]];

        bw.write(ee[0] + "\n");
        bw.flush();
        char cEE = br.readLine().charAt(0);

        bw.write(dd[0] + "\n");
        bw.flush();
        char cDD = br.readLine().charAt(0);

        if (cDD == cD && cEE != cE) {
            complement(ansNum, turn);
            reverse(ansNum, turn);
        } else if (cEE != cE && cDD != cD) {
            complement(ansNum, turn);
        } else if (cEE == cE && cDD != cD) {
            reverse(ansNum, turn);
        }
    }

    public static void update2(char[] ansNum, int index, BufferedWriter bw, BufferedReader br, int turn) throws IOException {
        char c1 = ansNum[index];
        bw.write(index + "\n");
        bw.flush();
        char c2 = br.readLine().charAt(0);
        if (c1 != c2) {
            complement(ansNum, turn);
        }
    }

    public static void complement(char[] ansNum, int turn) {
        for (int i = 1; i < turn; i++) {
            ansNum[i] = (ansNum[i] == '0') ? '1' : '0';
            ansNum[ansNum.length - i] = (ansNum[ansNum.length - i] == '0') ? '1' : '0';
        }
    }

    public static void reverse(char[] ansNum, int turn) {
        for (int i = 1; i < turn; i++) {
            char temp = ansNum[i];
            ansNum[i] = ansNum[ansNum.length - i];
            ansNum[ansNum.length - i] = temp;
        }
    }
}