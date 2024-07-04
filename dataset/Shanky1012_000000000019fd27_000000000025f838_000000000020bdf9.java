import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class Solution {
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
            String ans = "";
            for (ArrayList<Integer> res :timeInterval){
                if (prevendtimeC <= res.get(0)) {
                    prevendtimeC = res.get(1);
                    ans += "C";
                }
                else if (prevendtimeJ <= res.get(0)){
                    prevendtimeJ = res.get(1);
                    ans += "J";
                }
                else {
                    ans = "IMPOSSIBLE";
                    break;
                }
            }
            System.out.println("Case #" + l + ": " + ans);
        }
    }
}
