import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) {
        Scanner s = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int cases = Integer.parseInt(s.nextLine());
        String[] dirs;
        char front;
        char next;
        String stem;
        HashMap<Character,Integer> pair;
        ArrayList<Character> let;
        ArrayList<Integer> num;
        String ans;
        int high;
        int at;
        for (int q = 1; q <= cases; q++) {
            pair = new HashMap<Character,Integer>();
            s.nextLine();
            for (int x = 0; x < 10000; x++) {
                stem = s.nextLine().split(" ")[1];
                front = stem.charAt(0);
                if (x > 5000) {
                    if (stem.length() > 1) {
                        if (!pair.containsKey(stem.charAt(1))) {
                            pair.put(stem.charAt(1),10000);
                        }
                    }
                }
                if (pair.containsKey(front)) {
                    pair.put(front,pair.get(front)+1);
                }
                else {
                    pair.put(front,1);
                }
            }
            let = new ArrayList<Character>();
            num = new ArrayList<Integer>();
            for (Map.Entry m : pair.entrySet()) {
                let.add((Character)m.getKey());
                num.add((Integer)m.getValue());
            }
            ans = "";
            while (num.size() > 0) {
                high = 0;
                at = -1;
                for (int x = 0; x < num.size(); x++) {
                    if (num.get(x) > high) {
                        high = num.get(x);
                        at = x;
                    }
                }
                ans = ans + let.get(at);
                let.remove(at);
                num.remove(at);
            }
            System.out.println("Case #"+q+": "+ans);
        }
    }
}