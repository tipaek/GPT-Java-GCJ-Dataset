import java.util.HashSet;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for(int ii = 1 ; ii <= t; ii ++) {
            int n = sc.nextInt();
            int arr[][] = new int[n][n];
            for(int i = 0; i < n; i ++) {
                for(int j = 0; j < n; j ++) {
                    arr[i][j] = sc.nextInt();
                }
            }
            int trace = 0;
//            int r = 0;
//            int c = 0;
            HashSet<Integer> row[] = new HashSet[n];
            HashSet<Integer> col[] = new HashSet[n];
            HashSet<Integer> r = new HashSet<>();
            HashSet<Integer> c = new HashSet<>();
            for(int i = 0; i < n; i ++) {
                for(int j = 0; j < n; j ++) {
                    if(i == j) {
                        trace += arr[i][j];
                    }
                    if(i == 0) {
                        col[j] = new HashSet();
                    }
                    if(j == 0) {
                        row[i] = new HashSet();
                    }
                    if(col[j].contains(arr[i][j])) {
//                        flag = true;
                        c.add(j);
                    }
                    if(row[i].contains(arr[i][j])) {
//                        flag = true;
                        r.add(i);
                    }
                    col[j].add(arr[i][j]);
                    row[i].add(arr[i][j]);
                }
            }
            System.out.println("Case #" + ii + ": " + trace + " " + r.size() + " " + c.size());
        }
    }
}