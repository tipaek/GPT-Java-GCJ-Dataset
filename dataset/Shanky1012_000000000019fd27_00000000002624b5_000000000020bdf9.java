import java.util.*;

public class Solution {
//    public static long MIN(long a,long b,long c)
//    {
//        if (a < b && a<c)
//            return a;
//        else if (b < a && b < c)
//            return b;
//        else
//            return c;
//    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        int l = 0;
        while (t-- > 0){
            l++;
            int n = sc.nextInt();
            int[] s = new int[n];
            int[] e = new int[n];
            ArrayList<ArrayList<Integer>> timeInterval = new ArrayList<>();
            for (int i=0;i<n;i++){
                s[i] = sc.nextInt();
                e[i] = sc.nextInt();
                ArrayList<Integer> temp = new ArrayList<>();
                temp.add(s[i]);
                temp.add(e[i]);
                temp.add(i);
                timeInterval.add(temp);
            }
            Collections.sort(timeInterval, new Comparator<ArrayList<Integer>>() {
                @Override
                public int compare(ArrayList<Integer> o1, ArrayList<Integer> o2) {
                    if (o1.get(0).equals(o2.get(0))){
                        return o1.get(1).compareTo(o2.get(1));
                    }
                    return o1.get(0).compareTo(o2.get(0));
                }
            });
            int prevendtimeJ = 0;
            int prevendtimeC = 0;
            Map<Integer,Character> mp = new HashMap<>();
            ArrayList<Integer> index = new ArrayList<>();
            String ans = "";
            for (ArrayList<Integer> res :timeInterval){
                if (prevendtimeC <= res.get(0)) {
                    prevendtimeC = res.get(1);
                    mp.put (res.get(2),'C');
                    index.add(res.get(2));
                }
                else if (prevendtimeJ <= res.get(0)){
                    prevendtimeJ = res.get(1);
                    mp.put (res.get(2),'J');
                    index.add(res.get(2));
                }
                else {
                    ans = "IMPOSSIBLE";
                    break;
                }
            }
            Collections.sort(index);
            if (ans.equals("IMPOSSIBLE"))
               System.out.println("Case #" + l + ": " + ans);
            else {
                for (int x:index)
                    ans += mp.get(x);
                System.out.println("Case #" + l + ": " + ans);
            }
        }
    }
}
