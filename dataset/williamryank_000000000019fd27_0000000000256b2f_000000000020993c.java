import java.util.*;

public class Vestigium {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int tc = sc.nextInt();
        for(int i = 0; i < tc; i++) {

            int res = 0;
            int r = 0;
            int c = 0;
            int N = sc.nextInt();
            ArrayList<HashSet<Integer>> colSet = new ArrayList<>();
            boolean flags[] = new boolean[N];

            for(int j = 0; j < N; j++) {
                colSet.add(new HashSet<Integer>());
            }
            
            for(int j = 0; j < N; j++) {
                HashSet<Integer> rowSet = new HashSet<>();
                boolean flag = true;

                for(int k = 0; k < N; k++) {
                    int val = sc.nextInt();

                    if (j == k) {
                        res += val;
                    }

                    if (colSet.get(k).contains(val) && !flags[k]) {
                        c++;
                        flags[k] = true;
                    } else {
                        colSet.get(k).add(val);
                    }

                    if (rowSet.contains(val) && flag) {
                        r++;
                        flag = false;
                    } else {
                        rowSet.add(val);
                    }
                    
                }
            }
            System.out.printf("Case #%d: %d %d %d\n", i, res, r, c);
        }
    }
}

