import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

class Solution {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);

        int test = sc.nextInt();
        for(int t=0; t<test; t++) {
            int n = sc.nextInt();
            int mat[][] = new int[n][n];

            for(int i=0; i<n; i++) {
                for(int j=0; j<n; j++) {
                    mat[i][j] = sc.nextInt();
                }
            }

            int trace = 0, rowsDup = 0, colsDup = 0;

            for(int i=0; i<n; i++) {
                for(int j=0; j<n; j++) {
                    if(i==j) {
                        trace += mat[i][j];
                    }
                }
            }
//            System.out.println("trace: "+ trace);

            for(int i=0; i<n; i++) {
                HashMap<Integer,Integer> hs = new HashMap<>();
                for(int j=0; j<n; j++) {
                    if(!hs.containsKey(mat[i])) {
                        hs.put(mat[i][j], 1);
                    } else {
                        hs.put(mat[i][j], hs.get(mat[i][j])+1);
                    }
                }
//                System.out.println(hs);
                if(hs.size() != n) {
                    rowsDup++;
                }
            }

//            System.out.println("Rows Dup : "+rowsDup);

            int[][] tr = new int[n][n];
            for(int i=0; i<n; i++) {
                for(int j=0; j<n; j++) {
                    tr[j][i] = mat[i][j];
                }
            }

            for(int i=0; i<n; i++) {
                HashMap<Integer,Integer> hs = new HashMap<>();
                for(int j=0; j<n; j++) {
                    if(!hs.containsKey(tr[i])) {
                        hs.put(tr[i][j], 1);
                    } else {
                        hs.put(tr[i][j], hs.get(tr[i][j])+1);
                    }
                }
//                System.out.println(hs);
                if(hs.size() != n) {
                    colsDup++;
                }
            }

//            System.out.println("COls Cup: "+ colsDup);
            System.out.println("Case #"+(t+1)+": "+ trace + " " + rowsDup + " "+ colsDup);
        }
    }
}
