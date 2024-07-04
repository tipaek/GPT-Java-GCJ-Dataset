import java.util.*;
import java.io.*;

class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int T = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());

        for (int counter = 1; counter <= T; counter++) {
            char[] ansNum = new char[B + 1];
            List<int[]> equals = new ArrayList<>();
            List<int[]> dif = new ArrayList<>();

            for (int turn = 1; turn <= B / 2; turn++) {
                queryAndStore(turn, ansNum, bw, br);
                if (turn % 10 == 1) {
                    handleSpecialTurn(ansNum, equals, dif, bw, br, turn);
                }
                queryAndStore(B - turn + 1, ansNum, bw, br);
                updateLists(ansNum, equals, dif, turn);
            }

            String ans = new String(ansNum, 1, B);
            bw.write(ans + "\n");
            bw.flush();

            if (br.readLine().equals("N")) {
                break;
            }
        }

        bw.close();
        br.close();
    }

    private static void queryAndStore(int index, char[] ansNum, BufferedWriter bw, BufferedReader br) throws IOException {
        bw.write(index + "\n");
        bw.flush();
        ansNum[index] = br.readLine().charAt(0);
    }

    private static void handleSpecialTurn(char[] ansNum, List<int[]> equals, List<int[]> dif, BufferedWriter bw, BufferedReader br, int turn) throws IOException {
        if (!equals.isEmpty() && !dif.isEmpty()) {
            update(ansNum, equals, dif, bw, br);
        }
        if (turn != 1) {
            int[] ind = equals.isEmpty() ? dif.get(0) : equals.get(0);
            update2(ansNum, ind[0], bw, br);
        }
    }

    private static void updateLists(char[] ansNum, List<int[]> equals, List<int[]> dif, int turn) {
        char cc = ansNum[turn];
        char cs = ansNum[ansNum.length - turn];

        if (cs != cc && dif.isEmpty()) {
            dif.add(new int[]{turn, cc});
        } else if (equals.isEmpty()) {
            equals.add(new int[]{turn, cc});
        }
    }

    private static void update(char[] ansNum, List<int[]> equals, List<int[]> dif, BufferedWriter bw, BufferedReader br) throws IOException {
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
            complementAndReverse(ansNum);
        } else if (cEE != cE && cDD != cD) {
            complement(ansNum);
        } else if (cEE == cE && cDD != cD) {
            reverse(ansNum);
        }
    }

    private static void update2(char[] ansNum, int index, BufferedWriter bw, BufferedReader br) throws IOException {
        char c1 = ansNum[index];
        bw.write(index + "\n");
        bw.flush();
        char c2 = br.readLine().charAt(0);
        if (c1 != c2) {
            complement(ansNum);
        }
    }

    private static void complement(char[] arr) {
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (arr[i] == '0') ? '1' : '0';
        }
    }

    private static void reverse(char[] arr) {
        for (int i = 0, j = arr.length - 1; i < j; i++, j--) {
            char temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }
    }

    private static void complementAndReverse(char[] arr) {
        complement(arr);
        reverse(arr);
    }
}