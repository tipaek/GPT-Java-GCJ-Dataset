import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;
import javafx.util.Pair;

/**
 *
 * @author arabtech
 */
public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for (int z = 0; z < t; z++) {
            int n = sc.nextInt();
            StringBuilder ans = new StringBuilder();
            int cEnd=0;
            int jEnd=0;
            ArrayList<Pair<Integer, Integer>> list = new ArrayList<>();
            HashMap<Integer, Pair<Integer, Integer>> indexMap = new HashMap<>();
            HashMap<Pair<Integer, Integer>, Character> charMap = new HashMap<>();
            boolean valid=true;
            for (int i = 0; i < n; i++) {
                int first = sc.nextInt();
                int second = sc.nextInt();
                Pair<Integer, Integer> p =new Pair<>(first,second);
                indexMap.put(i, p);
                list.add(p);
            }
            Collections.sort(list,(a,b)->a.getKey()-b.getKey());
            for(int i=0; i<list.size();i++){
                Pair p = list.get(i);
                if((int)p.getKey() >= cEnd){
                    cEnd= Math.max(cEnd, (int) p.getValue());
                    charMap.put(p, 'C');
                    continue;
                }
                else if((int)p.getKey() >= jEnd){
                    jEnd= Math.max(jEnd, (int) p.getValue());
                    charMap.put(p, 'J');
                    continue;
                }
                else{
                    valid = false;
                }
            }
            if(!valid){
                System.out.println("Case #" + (z + 1) + ": IMPOSSIBLE");
            }
            else{
                for(int i=0;i<n;i++){
                    Pair p =indexMap.get(i);
                    ans.append(charMap.get(p));
                }
                System.out.println("Case #" + (z + 1) + ": " + ans.toString());
            }
            
        }

    }

}