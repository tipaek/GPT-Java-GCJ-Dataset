import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

import static java.lang.Integer.max;
import static java.lang.Integer.min;

public class Solution {

    public static void main(String[] args) {
//        for (int k=3;k<=9;k++) {
//            System.out.println(new Diag(k,3));
//        }
//        Diag diag = new Diag(8,3);
//        for (List<Integer> d : diag.getDiags()) {
//            for (int i=0;i<d.size(); i++) {
//                System.out.print(d.get(i)+ " ");
//            }
//            System.out.println("");
//        }
//        for (int n=2; n<= 5;n++) {
//            for (int k=n;k<=n*n;k++) {
//                Diag diag = new Diag(k,n);
//                for (List<Integer> d : diag.getDiags()) {
//                    Optional<int [][]> res = diag.findMatrix(d);
//                    if (res.isPresent()) {
//                        System.out.println("Case #"+n+","+k+": POSSIBLE");
//                        System.out.print(diag.toMatrix(res.get()));
//                        break;
//                    }
//                }
//            }
//        }
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int T = scanner.nextInt();
        for (int t=1; t<=T; t++) {
            doCase(scanner, t);
        }
    }

    public static void doCase(Scanner scanner, int t) {
        int N= scanner.nextInt();
        int K = scanner.nextInt();
        Diag diag = new Diag(K,N);
        for (List<Integer> d : diag.getDiags()) {
//            for (int i=0;i<d.size(); i++) {
//                System.out.print(d.get(i)+ ",");
//            }
//            System.out.println("");
            Optional<int [][]> res = diag.findMatrix(d);
            if (res.isPresent()) {
                System.out.println("Case #"+t+": POSSIBLE");
                System.out.print(diag.toMatrix(res.get()));
                return;
            }
        }
        System.out.println("Case #"+t+": IMPOSSIBLE");
    }
}

class Diag {
    int k, n;
    List<Integer> acc;
    List<List<Integer>> diags;
    Diag(int k, int n) {
        this.k = k; this.n = n;
        acc = new LinkedList<>();
        diags = new ArrayList<>();
        f(k,n);
    }
    private void f(int kk, int left) {
        if (left==1) {
            if (kk <= n) {
                acc.add(kk);
                diags.add(new ArrayList(acc));
                acc.remove(acc.size() - 1);
            }
            return;
        }
        for (int i=max(1,kk-(left-1)*n);i<=min(kk-left+1,n);i++) {
            acc.add(i);
            f(kk-i,left-1);
            acc.remove(acc.size()-1);
        }
    }
    public List<List<Integer>> getDiags() {
        return diags;
    }
    public Optional<int [][]> findMatrix(List<Integer> diag) {
        int mat[][] = new int[n][n];
        for (int i=0; i<n;i++) {
            mat[i][i] = diag.get(i);
        }
        try {
            g(0, 0, mat);
        } catch (IllegalArgumentException e) {
            return Optional.of(mat);
        }
        return Optional.empty();
    }
    private void g(int i, int j, int mat[][]) {
       if (i== n-1 && j==n-1) {
           //found it!!!
           throw new IllegalArgumentException();
       }
       if (i==j) {
           g(i,j+1,mat);
           return;
       }
       BitSet bitSet = new BitSet();
       for (int ii=0;ii<i;ii++) {
           bitSet.set(mat[ii][j]);
       }
       for (int jj=0;jj<j;jj++){
           bitSet.set(mat[i][jj]);
       }
       bitSet.set(mat[i][i]);
       bitSet.set(mat[j][j]);
       for (int x=1;x<=n;x++) {
           if (!bitSet.get(x)) {
               mat[i][j]=x;
               if (j==n-1) {
                   g(i+1,0,mat);
               } else {
                   g(i,j+1,mat);
               }
           }
       }
    }
    public String toMatrix(int mat[][]) {
        StringBuilder s = new StringBuilder();
        for (int i=0;i<n;i++) {
            for (int j=0;j<n;j++) {
                s.append(mat[i][j]).append(" ");
            }
            s.append("\n");
        }
        return s.toString();
    }
}

