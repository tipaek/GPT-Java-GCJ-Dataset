import java.util.*;

public class Solution {
    private static String PATTEN = "Case #%d: %s";
    public static void main(String [] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        sc.nextLine();
        for (int p = 1; p <= t; p++) {
            int n = sc.nextInt();
            Map<Character, Integer> headCount = new HashMap<>();
            Map<Character, Integer> tailCount = new HashMap<>();
            Set<Character> set = new HashSet<>();
            for (int i =0;i<10000;i++){
                String x = sc.next();
                String s = sc.next();
                sc.nextLine();
                int c = headCount.getOrDefault(s.charAt(0), 0);
                c++;
                headCount.put(s.charAt(0), c);
                for (int j =1;j<s.length();j++){
                    int w = tailCount.getOrDefault(s.charAt(j),0);
                    w++;
                    tailCount.put(s.charAt(j),w);

                }
                set.add(s.charAt(0));
            }
            StringBuilder sb = new StringBuilder();
            for (Character c:tailCount.keySet()){
                if (!set.contains(c)){
                    sb.append(c);
                }
            }
            if (sb.length()>1){
                sb = new StringBuilder();
            }
            if (sb.length()>0){
                List<CValue> valueList = new ArrayList<>();
                for (Character c: set){
                    int x = headCount.getOrDefault(c, 0);
                    int y = tailCount.getOrDefault(c, 0);
                    valueList.add(new CValue(c, x+y));
                }
                valueList.sort(Comparator.comparing(o->-o.count));
                for (CValue cValue:valueList){
                    sb.append(cValue.c);
                }
            } else {
                List<CValue> valueList = new ArrayList<>();
                for (Character c: tailCount.keySet()){
                    int y = tailCount.getOrDefault(c, 0);
                    valueList.add(new CValue(c, y));
                }
                valueList.sort(Comparator.comparing(o->-o.count));
                for (CValue cValue:valueList){
                    sb.append(cValue.c);
                }
            }

            System.out.println(String.format(PATTEN, p, sb.toString()));
        }

    }

    static class CValue{
        Integer count;
        Character c;
        CValue(Character c, Integer count){
            this.c = c;
            this.count = count;
        }
    }
}
