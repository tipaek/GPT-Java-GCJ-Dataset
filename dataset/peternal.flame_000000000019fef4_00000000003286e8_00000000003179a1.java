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
            for(int i = 0; i<10000; i++){
                long m = in.nextLong();
                String s = in.next().trim();
                if(!counter.containsKey(s.charAt(0))){
                    counter.put(s.charAt(0), 100);
                }else{
                    counter.merge(s.charAt(0), 100, Integer::sum);
                }
                for(int j = 0; j<s.length(); j++){
                    if(!counter.containsKey(s.charAt(j))){
                        counter.put(s.charAt(j), 1);
                    }else{
                        counter.merge(s.charAt(j), 1, Integer::sum);
                        //counter.put(s.charAt(j), counter.get(s.charAt(j))+1);
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
//            String solution = "";
//            for(Character c: outputMap.values()){
//                solution += c;
//            }
//            System.out.print("Case #" + tt + ": ");
//            System.out.print(solution.charAt(0));
//            for(int i = 9; i>0; i--){
//                System.out.print(solution.charAt(i));
//            }
//            System.out.println();
        }
    }

}