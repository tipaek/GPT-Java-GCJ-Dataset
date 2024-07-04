import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        int numCases = s.nextInt();
        for(int caseNum=1;caseNum<=numCases;caseNum++) {
            int maxExponent = s.nextInt();

            Map<Character, List<Integer>> facts = new HashMap<>();

            for(int i=0;i<10000;i++) {
                long num = s.nextLong();
                String result = s.next();

                if(num==-1) {
                    continue;
                }

                for(char c : result.toCharArray()) {
                    if(!facts.containsKey(c)) {
                        putList(facts, c, 0, 9);
                    }
                }

                for(int exponent = 1; exponent < maxExponent; exponent++) {
                    long maxValue = (long)Math.pow(10, exponent);

                    if (num == maxValue && result.length() == exponent+1) {
                        removeFromList(facts, result.charAt(0), 0, 0);
                        removeFromList(facts, result.charAt(0), 2, 9);
                        removeFromList(facts, result.charAt(1), 1, 9);
                    }
                }

                if (num < 10 && result.length() == 1) {
                    removeFromList(facts, result.charAt(0), (int)num + 1, 9);
                }
            }

            String result = "";
            for(int i=0;i<=9; i++) {
                Character digit = null;
                for(Map.Entry<Character, List<Integer>> entry : facts.entrySet()) {
                    if(entry.getValue().size()==1 && entry.getValue().get(0)==i) {
                        System.err.printf("Found %d: %s\n", i, entry.getKey());
                        result += entry.getKey();
                        digit = entry.getKey();
                    }
                }

                if(digit != null) {
                    final int blah = i;
                    facts.remove(digit);
                    for(List<Integer> list : facts.values()) {
                        list.removeIf(l->l==blah);
                    }
                }
            }

            System.out.printf("Case #%d: %s\n", caseNum, result);
        }
    }

    private static void removeFromList(Map<Character, List<Integer>> facts, char key, int lower, int upper) {
        List<Integer> list = facts.computeIfAbsent(key, k -> new ArrayList<>());
        list.removeIf(current -> current >= lower && current <= upper);
    }

    private static void putList(Map<Character, List<Integer>> facts, char key, int lower, int upper) {
        List<Integer> list = facts.computeIfAbsent(key, k -> new ArrayList<>());
        for(int i=lower; i<=upper;i++) {
            list.add(i);
        }
    }


}
