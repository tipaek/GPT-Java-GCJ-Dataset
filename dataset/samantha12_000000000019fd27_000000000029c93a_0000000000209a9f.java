import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Solution{
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt();
        for (int i = 1; i <= t; ++i) {
            String s = in.next();
            char[] chars = s.toCharArray();
            String s1 = getSP2(chars);
            System.out.println(String.format("Case #%d: %s", i, s1));
        }
    }

    private static String getSP2(char[] chars) {
        List<Character> s = new LinkedList<>();
        if(chars[0] != '0') {
            appendChar(chars[0], s);
        }else {
            s.add(chars[0]);
        }
        for(int i = 1; i < chars.length; i ++) {
            if(chars[i] != '0' && chars[i] == chars[i - 1]) {
                int p = chars[0] - '0';
                s.add(s.size() - p, chars[i]);
            } else if(chars[i] != '0') {
                appendChar(chars[i], s);
            }else {
                s.add(chars[i]);
            }
        }

        Stack<Character> stack = new Stack<>();
        for(int i = 0; i < s.size(); i++ ) {
            if(stack.isEmpty()) {
                stack.add(s.get(i));
            }else if(s.get(i).equals('(') && stack.peek().equals(')')) {
                stack.pop();
            }else {
                stack.add(s.get(i));
            }
        }
        StringBuilder sp = new StringBuilder();
        List<Character> characters = new ArrayList<>(stack);
        characters.forEach(c-> sp.append(c.charValue()));
        return sp.toString();
    }
    private static void appendChar(char aChar, List<Character> s) {
        int p = aChar - '0';
        for(int i = 0; i < p; i++) {
            s.add('(');
        }
        s.add(aChar);
        for(int i = 0; i < p; i++) {
            s.add(')');
        }
    }

    private static String getSP(char[] chars) {
        StringBuilder sp = new StringBuilder();
        if(chars[0] == '1') {
            sp.append('(');
            sp.append(chars[0]);
            sp.append(')');
        }else {
            sp.append(chars[0]);
        }
        for(int i = 1; i < chars.length; i ++) {
            if(chars[i] == '1' && chars[i - 1] == '1') {
                sp.insert(sp.length()-2, chars[i]);
            } else if(chars[i] == '1' && chars[i - 1] == '0') {
                sp.append('(');
                sp.append(chars[i]);
                sp.append(')');
            }else {
                sp.append(chars[i]);
            }
        }
        return sp.toString();
    }
}
