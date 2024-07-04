import java.util.*;

class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int caseCount = Integer.valueOf(sc.nextLine());
        for(int i = 0; i < caseCount; i++) {
            int patternCount = Integer.valueOf(sc.nextLine());
            String[] patterns = new String[patternCount];
            for(int j = 0; j < patternCount; j++) {
                patterns[j] = sc.nextLine();
            }
            System.out.println(solution(patterns, i));
        }
        sc.close();
    }

    public static String solution(String[] patterns, int index) {
        List<List<String>> list = new ArrayList<List<String>>();
        for(String p: patterns) {
            String[] words = p.split("[*]");
            List<String> val = new ArrayList(Arrays.asList(words));
            if(p.charAt(0) == '*') {
                val.add(0, "#");
            }
            if(p.charAt(p.length() - 1) == '*') {
                val.add("#");
            }
            list.add(val);
        } 
        
        String maxTail = "";
        String maxHead = "";
        for(int i = 0; i < list.size(); i++) {
            List<String> val = list.get(i);
            String tail = val.get(val.size() - 1);
            String head = val.get(0);
            if(tail.length() > maxTail.length()) {
                maxTail = tail;
            }

            if(head.length() > maxHead.length()) {
                maxHead = head;
            }
        }

        for(int i = 0; i < list.size(); i++) {
            List<String> val = list.get(i);
            String tail = val.get(val.size() - 1);
            String head = val.get(0);
            if(!tail.equals("#") &&
                !maxTail.substring(maxTail.length() - tail.length(), maxTail.length()).equals(tail)) {
                return "*";
            }

            if(!head.equals("#") &&
                !maxHead.substring(0, head.length()).equals(head)) {
                return "*";
            }
        }

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < list.size(); i++) {
            List<String> val = list.get(i);
            for(int j = 1; j < val.size() - 1; j++) {
                sb.append(val.get(j));
            }
        }
        String result = "";
        if(!maxHead.equals("#")) {
            result = maxHead + result;
        }

        result += sb.toString();

        if(!maxTail.equals("#")) {
            result += maxTail;
        }
        return String.format("Case #%d: %s", index + 1, result);
    }
}