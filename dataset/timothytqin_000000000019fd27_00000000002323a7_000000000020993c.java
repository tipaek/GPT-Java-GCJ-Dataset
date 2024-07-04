import java.util.*;

class Solution {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int T = scan.nextInt();
        for(int i = 0; i < T; i++) {
            int N = scan.nextInt();
            int[][] arr = new int[N][N];
            int sum = 0;
            int a = 0;
            int b = 0;
            for(int r = 0; r < N; r++) {
                Set<Integer> s = new HashSet<Integer>();
                for(int c = 0; c < N; c++) {
                    arr[r][c] = scan.nextInt();
                    s.add(arr[r][c]);
                    if(r == c)
                        sum += arr[r][c];
                }
                if(s.size() != N)
                    a++;
            }
            for(int c = 0; c < N; c++) {
                Set<Integer> s = new HashSet<Integer>();
                for(int r = 0; r < N; r++) {
                    s.add(arr[r][c]);
                }
                if(s.size() != N)
                    b++;
            }
            System.out.printf("Case #%d: %d %d %d\n", i + 1, sum, a, b);
        }
        scan.close();
    }

}