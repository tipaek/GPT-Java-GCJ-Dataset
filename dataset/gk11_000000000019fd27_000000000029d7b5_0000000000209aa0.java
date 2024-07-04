import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

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
            if (diag.isLatin(d)) {
                System.out.println("Case #"+t+": POSSIBLE");
                System.out.print(diag.toMatrix(d));
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
        for (int i=kk/left;i<=min(k-left+1,n);i++) {
            acc.add(i);
            f(kk-i,left-1);
            acc.remove(acc.size()-1);
        }
    }
    public List<List<Integer>> getDiags() {
        return diags;
    }
    public boolean isLatin(List<Integer> diag) {
        boolean seen[] = new boolean[n];
        for (int i=0;i<n;i++) {
            int x =diag.get(i)-1-i;
            if (x<0) {
                x+=n;
            }
            if (seen[x]) {
                return false;
            }
            seen[x]=true;
        }
        return true;
    }
    public String toMatrix(List<Integer> diag) {
        StringBuilder s = new StringBuilder();
        for (int i=0;i<n;i++) {
            int x=diag.get(i)-1-i;
            if (x<0) {
                x+=n;
            }
            for (int j=0;j<n;j++) {
                s.append(x+1).append(" ");
                x++;
                if (x==n) {
                    x=0;
                }
            }
            s.append("\n");
        }
        return s.toString();
    }
//    public String toString() {
//        StringBuilder s = new StringBuilder();
//        for (int i=0;i<n;i++) {
//            s.append(diag[i]).append(",");
//        }
//        return s.toString();
//    }
}
