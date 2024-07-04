import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt();
        for(int tt = 1; tt<= t; tt++){
            int u = in.nextInt();
            HashMap<Character, Integer>counter = new HashMap<>();
            for(int i = 0; i<5; i++){
                int m = in.nextInt();
                String s = in.next();
                for(int j = 0; j<s.length(); j++){
                    if(!counter.containsKey(s.charAt(j))){
                        counter.put(s.charAt(j), 1);
                    }else{
                        counter.put(s.charAt(j), counter.get(s.charAt(j))+1);
                    }
                }
            }
            TreeMap<Integer, Character> outputMap = new TreeMap<>();
            for(Map.Entry<Character, Integer> e : counter.entrySet()){
                outputMap.put(e.getValue(), e.getKey());
            }
            StringBuilder out = new StringBuilder("..........");
            int[] toChange = {0, 9, 8, 7, 6, 5, 4, 3, 2, 1};
            int i = 0;
            for(Character c : outputMap.values()){
                out.setCharAt(toChange[i], c);
                i++;
            }
            System.out.println("Case #" + tt + ": "+out.toString());
        }
    }

}
/*
1
1
3 XYZ
8 XXASDFGHJ
3 AJDSG
5 JJJJ
3 GGGGGGGG
 */