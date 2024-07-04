import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) {
        int T;
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        T = scanner.nextInt();
        for(int z = 1 ;z <= T; z++) {
            int N;
            N = scanner.nextInt();

            int blogEil = 0;
            int blogStulp = 0;
            int sum = 0;
            ArrayList<ArrayList<Integer>> rows = new ArrayList<ArrayList<Integer>>();
            ArrayList<ArrayList<Integer>> columns = new ArrayList<ArrayList<Integer>>();

            for(int i = 0 ; i<N;i++){
                rows.add(new ArrayList<Integer>());
                columns.add(new ArrayList<Integer>());
            }

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    rows.get(i).add(j + 1);
                    columns.get(i).add(j + 1);
                }
            }

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    int num = scanner.nextInt();
                    if(i==j){
                        sum+=num;
                    }
                    if (rows.get(i).contains(num)) {
                        rows.get(i).remove((Integer) num);
                    }
                    if (columns.get(j).contains(num)) {
                        columns.get(j).remove((Integer)num);
                    }
                }
            }

            for (int i = 0; i < N; i++) {
                if (!rows.get(i).isEmpty()) {
                    blogEil++;
                }
                if (!columns.get(i).isEmpty()) {
                    blogStulp++;
                }
            }

            System.out.println("Case #"+z +": "+sum+" "+blogEil+" "+blogStulp );
        }
    }
}
