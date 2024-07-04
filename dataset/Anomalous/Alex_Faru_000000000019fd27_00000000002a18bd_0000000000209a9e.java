import java.util.*;
import java.io.*;

class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int T = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        
        for (int t = 1; t <= T; t++) {
            char[] ansNum = new char[B + 1];
            List<int[]> equals = new ArrayList<>();
            List<int[]> dif = new ArrayList<>();
            int calls = 0;
            
            for (int turn = 1; turn <= B / 2; turn++) {
                // First query
                bw.write(turn + "\n");
                bw.flush();
                char cc = br.readLine().charAt(0);
                ansNum[turn] = cc;
                calls++;
                handleSpecialCase(ansNum, equals, dif, bw, br, calls, turn);
                
                // Second query
                bw.write((B - turn + 1) + "\n");
                bw.flush();
                char cs = br.readLine().charAt(0);
                ansNum[B - turn + 1] = cs;
                calls++;
                if (cs != cc) {
                    dif.add(new int[]{turn, cc});
                } else {
                    equals.add(new int[]{turn, cc});
                }
            }
            
            // Output the result
            bw.write(new String(ansNum, 1, B) + "\n");
            bw.flush();
            if (br.readLine().equals("N")) {
                break;
            }
        }
        
        bw.close();
        br.close();
    }
    
    private static void handleSpecialCase(char[] ansNum, List<int[]> equals, List<int[]> dif, BufferedWriter bw, BufferedReader br, int calls, int turn) throws IOException {
        if (calls % 10 == 1 && calls != 1) {
            if (!equals.isEmpty() && !dif.isEmpty()) {
                update(ansNum, equals, dif, bw, br, turn);
            } else if (!equals.isEmpty() || !dif.isEmpty()) {
                int[] ind = equals.isEmpty() ? dif.get(0) : equals.get(0);
                update2(ansNum, ind[0], bw, br, turn);
            }
        }
    }
    
    private static void update(char[] ansNum, List<int[]> equals, List<int[]> dif, BufferedWriter bw, BufferedReader br, int turn) throws IOException {
        int[] ee = equals.get(0);
        int[] dd = dif.get(0);
        char cE = ansNum[ee[0]];
        char cD = ansNum[dd[0]];
        
        // Query equal index
        bw.write(ee[0] + "\n");
        bw.flush();
        char cEE = br.readLine().charAt(0);
        
        // Query different index
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
    
    private static void update2(char[] ansNum, int index, BufferedWriter bw, BufferedReader br, int turn) throws IOException {
        char c1 = ansNum[index];
        bw.write(index + "\n");
        bw.flush();
        char c2 = br.readLine().charAt(0);
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