import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        int ct = 1;
        int r, s, ans;
        int[][] ar;
        List<int[]> seq;
        while (ct <= t) {
            r = sc.nextInt();
            s = sc.nextInt();
            ans = 0;
            int l = r*s;
            ar = new int[l][2];
            seq = new ArrayList();
            for (int i = 0; i < s; i++) {
                for (int j = 0; j < r; j++) {
                    int ind = (i*r)+j;
                    ar[ind][0] = j+1;
                    ar[ind][1] = i+1;
                }
            }

//            print(ar);
            int cr = r;
            while (cr > 1) {
                int indLessthancr = getIndLessthancr(ar, cr, l);
                int indEqualCr = getIndEqualcr(ar, cr, indLessthancr);
//                System.out.println(indLessthancr + " " + indEqualCr);
                if (indLessthancr != -1 && indEqualCr == -1) cr--;
                else {
                    swap(ar, indEqualCr, indLessthancr);
                    seq.add(new int[] {indEqualCr+1, indLessthancr-indEqualCr});
                    ans++;
                }
//                print(ar);
            }
            System.out.println("Case #" + ct + ": " + ans);
            printseq(seq);
            ct++;
        }
    }

    private static void printseq(List<int[]> seq) {
        for (int[] s : seq) {
            System.out.println(s[0] + " " + s[1]);
        }
    }

    private static void print(int[][] ar) {
        for (int i = 0; i < ar.length; i++) {
            System.out.print("(" + ar[i][0] + "," + ar[i][1] + ")");
        }
        System.out.println();
    }

    private static void swap(int[][] ar, int ind2, int ind1) {
        int[][] temp = new int[ind2+1][2];
        for (int i = 0; i <= ind2; i++) {
            temp[i][0] = ar[i][0];
            temp[i][1] = ar[i][1];
        }
//        print(temp);
        for (int i = 0; i < ind1-ind2; i++) {
            ar[i][0] = ar[ind2+i+1][0];
            ar[i][1] = ar[ind2+i+1][1];
        }
//        print(ar);
        int diff = ind1-ind2;
        for (int i = diff; i <= ind1; i++) {
            ar[i][0] = temp[i-diff][0];
            ar[i][1] = temp[i-diff][1];
        }
    }

    private static int getIndLessthancr(int[][] ar, int cr, int l) {
//        System.out.println("In method " + cr + " " + l);
        for (int i = l-1 ; i >= 0; i--) {
            if (ar[i][0] < cr) return i;
        }
        return -1;
    }

    private static int getIndEqualcr(int[][] ar, int cr, int start) {
        for (int i = start ; i >= 0; i--) {
            if (ar[i][0] == cr) return i;
        }
        return -1;
    }
}