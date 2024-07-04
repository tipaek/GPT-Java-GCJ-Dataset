import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.TreeSet;

public class Solution {

    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(reader.readLine());
        int testCaseNum = 0;
        while(T != 0) {
            T--;
            testCaseNum++;
            int N = Integer.parseInt(reader.readLine());
            int[][] datas = new int[N][N];
            for(int i = 0; i < N; i++) {
                String[] bufs = reader.readLine().split(" ");
                for(int j = 0; j < N; j++) {
                    datas[i][j] = Integer.parseInt(bufs[j]);
                }
            }
            int K = calcuK(datas, N);
            int R = calcuR(datas, N);
            int C = calcuC(datas, N);
            System.out.println("Case #" + testCaseNum + ": "  + K + " " + R + " " + C);
        }
    }

    public static int calcuK(int[][] datas, int N) {
        int sum = 0;
        for(int i = 0; i < N; i++) {
            sum += datas[i][i];
        }
        return sum;
    }

    public static int calcuR(int[][] datas, int N) {
        int r = 0;
        for(int row = 0; row < N; row++) {
            TreeSet<Integer> sets = new TreeSet<>();
            boolean isNoRepeat = true;
            for(int col = 0; col < N; col++) {
                if(sets.contains(datas[row][col])) {
                    isNoRepeat = false;
                    break;
                } else {
                    sets.add(datas[row][col]);
                }
            }
            if(!isNoRepeat) {
                r++;
            }
        }
        return r;
    }

    public static int calcuC(int[][] datas, int N) {
        int c = 0;
        for(int col = 0; col < N; col++) {
            TreeSet<Integer> sets = new TreeSet<>();
            boolean isNoRepeat = true;
            for(int row = 0; row < N; row++) {
                if(sets.contains(datas[row][col])) {
                    isNoRepeat = false;
                    break;
                } else {
                    sets.add(datas[row][col]);
                }
            }
            if(!isNoRepeat) {
                c++;
            }
        }
        return c;
    }
 }
