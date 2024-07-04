import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
//        for (int k=3;k<=9;k++) {
//            System.out.println(new Diag(k,3));
//        }
//        Diag diag = new Diag(5,3);
//        System.out.println(diag);
//        while (diag.hasNext()){
//            diag.next();
//            System.out.println(diag);
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
        if (diag.isLatin()) {
            System.out.println("Case #"+t+": POSSIBLE");
            System.out.print(diag.toMatrix());
            return;
        }
        while (diag.hasNext()) {
            diag.next();
            if (diag.isLatin()) {
                System.out.println("Case #"+t+": POSSIBLE");
                System.out.print(diag.toMatrix());
                return;
            }
        }
        System.out.println("Case #"+t+": IMPOSSIBLE");
    }
}

class Diag {
    int k, n;
    int diag[];
    int reduceindex;
    Diag(int k, int n) {
        this.k = k; this.n = n;
        diag=  new int[n];
        int left=n;
        for (int i=1;i<=n;i++) {
            if (k-(left-1)>=n) {
                diag[i-1]=n;
                k-=n;
                left--;
            } else {
                diag[i-1]=k-(left-1);
                k-=k-(left-1);
                left--;
            }
        }
        reduceindex= diag[0]==1?n-1:0;
    }
    public boolean hasNext() {
        return reduceindex < n-1;
    }
    public int[] next() {
        assert reduceindex < n-1;
        assert diag[reduceindex]!=1;
        diag[reduceindex]--;
        diag[reduceindex+1]++;
        if (diag[reduceindex]==1)
            reduceindex++;
        return diag;
    }
    public boolean isLatin() {
        boolean seen[] = new boolean[n];
        for (int i=0;i<n;i++) {
            int x =diag[i]-1-i;
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
    public String toMatrix() {
        StringBuilder s = new StringBuilder();
        for (int i=0;i<n;i++) {
            int x=diag[i]-1-i;
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
    public String toString() {
        StringBuilder s = new StringBuilder();
        for (int i=0;i<n;i++) {
            s.append(diag[i]).append(",");
        }
        return s.toString();
    }
}
