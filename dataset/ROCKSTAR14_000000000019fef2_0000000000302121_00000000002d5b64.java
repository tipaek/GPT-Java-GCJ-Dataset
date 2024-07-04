import java.util.ArrayList;
import java.util.Scanner;

public class Solution {
    static class Pair {
        int a , b;
        Pair(int a , int b) {
            this.a = a;
            this.b = b;
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for (int q=1;q<=t;q++) {
            System.out.print("Case #" + q + ": ");
            int r = sc.nextInt();
            int s = sc.nextInt();
            ArrayList<Pair> a = new ArrayList<>();
            for (int i=r;i>1;i--) {
                ArrayList<Pair> p = path(i,s,a);
            }
            System.out.println(a.size());
            for (int i=0;i<a.size();i++) {
                System.out.println(a.get(i).a + " " + a.get(i).b);
            }
        }
    }
    private static ArrayList<Pair> path(int r , int s ,ArrayList<Pair> list) {
        for (int i=1;i<s;i++) {
            Pair p = new Pair(r,(s-1)*r - i);
            list.add(p);
        }
        return list;
    }
}
