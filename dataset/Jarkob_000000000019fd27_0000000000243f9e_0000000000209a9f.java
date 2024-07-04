import java.util.*;
import java.io.*;
public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = Integer.valueOf(sc.nextLine());
        for (int i = 0; i < T; i++) {
            String s = sc.nextLine();
            String result = getString(s);
            System.out.printf("Case #%d: %s\n", i + 1, result);
        }
    }
    
    public static String getString(String s) {
        List<Integer> list = new ArrayList<Integer>();
        list.add(0);
        for (int i = 0; i < s.length(); i++) {
            list.add(Character.getNumericValue(s.charAt(i)));
            list.add(0);
        }
        
        boolean change;
        do {
            change = false;
            int startIndex = 0;
            int endIndex = 0;
            for (int i = 1; i < list.size() - 1; i += 2) {
                if (list.get(i) > 0) {
                    list.set(i, list.get(i) - 1);
                    endIndex += 2;
                    change = true;
                } else {
                    list.set(startIndex, list.get(startIndex) + 1);
                    list.set(endIndex, list.get(endIndex) - 1);
                    startIndex = i + 1;
                    endIndex = startIndex;
                }
            }
            list.set(startIndex, list.get(startIndex) + 1);
            list.set(endIndex, list.get(endIndex) - 1);
        } while (change);
        
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < list.size(); i++) {
            if (i % 2 == 0) {
                if (list.get(i) > 0) {
                    for (int j = 0; j < list.get(i); j++) {
                        sb.append("(");
                    }
                } else if (list.get(i) < 0) {
                    for (int j = 0; j < -list.get(i); j++) {
                        sb.append(")");
                    }
                }
            } else {
                sb.append(s.charAt(i / 2));
            }
        }
        return sb.toString();
    }
}
