import java.util.*;

class Pair {
    int x;
    int y;

    Pair(int x , int y) {
        this.x = x;
        this.y = y;
    }
}

class sortByX implements Comparator<Pair> {
    public int compare (Pair w1 , Pair w2) {
        return w1.x - w2.x;
    }
}

public class Solution {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int t= s.nextInt();
        for (int q=1;q<=t;q++) {
            int n = s.nextInt();
            Map<Integer,Integer> map = new HashMap<>();
            ArrayList<Pair> list = new ArrayList<>();
            ArrayList<Pair> ar = new ArrayList<>();
            for (int i=0;i<n;i++) {
                int a = s.nextInt();
                int b =s.nextInt();
                Pair p = new Pair(a,b);
                list.add(p);
                ar.add(p);
            }
            Collections.sort(list,new sortByX());
            for (int i=0;i<n;i++) {
                for (int j=0;j<n;j++) {
                    if (ar.get(i).equals(list.get(j)))
                        map.put(j,i);
                }
            }
            char [] arr = new char[n];
            int ct = 0 , jt = 0;
            for (int i=0;i<list.size();i++) {
                Pair p = list.get(i);
                int in = map.get(i);
                if (p.x >= ct) {
                    ct = p.y;
                    arr[in] = 'C';
                } else if (p.x >= jt) {
                    jt = p.y;
                    arr[in] = 'J';
                } else break;
            }
            String ans = "";
            for (int i=0;i<n;i++) {
                if (arr[i] != 'C' && arr[i] != 'J') break;
                ans = ans + arr[i];
            }
            if (ans.length() != n) System.out.println("Case #" + q + ": IMPOSSIBLE");
            else System.out.println("Case #" + q + ": " + ans);
        }
    }
}
