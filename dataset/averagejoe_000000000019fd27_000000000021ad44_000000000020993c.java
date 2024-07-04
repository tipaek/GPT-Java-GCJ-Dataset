import java.util.*;

class Vestigium {

    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);

        int nCases = sc.nextInt();
        Map<Integer,Integer> map = new HashMap<>();
        
        for (int i = 0; i < nCases; i++) {
            int N = sc.nextInt();
            int[][] mat = new int[N][N];
            int rCounter = 0;
            int cCounter = 0;
            int k = 0;

            for (int r = 0; r < N; r++) {
                boolean added = false;
                for (int c = 0; c < N; c++) {
                    int num = sc.nextInt();
                    mat[r][c] = num;
                    if (r == c) k += num;
                    if (map.get(num) != null && !added ) {
                        added = true;
                        rCounter++;
                    } else {
                        map.put(num, 1);
                    } 
                }
                map.clear();
            }

            for (int c = 0; c < N; c++) {
                boolean added = false;
                for(int r = 0; r < N; r++) {
                    int num = mat[r][c];
                    if (map.get(num) != null && !added ) {
                        added = true;
                        cCounter++;
                    } else {
                        map.put(num, 1);
                    } 
                }
                map.clear();
            }

            System.out.println(String.format("Case #%d: %d %d %d", i+1, k, rCounter, cCounter));

        }
    }
}