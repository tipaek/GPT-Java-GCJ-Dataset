

import java.util.*;
import java.util.stream.Collectors;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        for (int i = 0; i < t; i++) {
            // nie wykorzystalem jak zawezic
            int U = scanner.nextInt();
            String max = Collections.nCopies(U, "9").stream().collect(Collectors.joining( ));
            DString dString = new DString();
            for (int j = 0; j < 10000; j++) {
                String Q = scanner.next();
                String R = scanner.next();
                if (Q.equals("-1")) {
                    dString.add(R, max);
                }
                dString.add(R, Q);
            }
            String s = dString.hasAll();
            sout(i, s);
        }
        scanner.close();
    }

    private static void sout(int x, String k) {
        System.out.println("Case #" + (x + 1) + ": " + k);
    }
}

class DString {
    Map<Integer, MyChar> possibilities = new HashMap();
    Set<Character> allChars = new HashSet<>();

    DString() {
        for (int i = 0; i <= 9; i++) {
            possibilities.put(i, new MyChar());
        }
    }

    public String hasAll() {
//        for(int i = 0; i < 10; i ++) {
//            MyChar myChar = possibilities.get(i);
//            if(myChar.canBe.keySet().size() < 9) {
//                return "NO";
//            }
//        }
        char[] tmp = new char[10];
        while (allChars.size() > 0) {
            for (int i = 0; i < 10; i++) {
                MyChar myChar = possibilities.get(i);
                if (myChar.canBe.size() + 1 == allChars.size()) {
                    char ctmp = 0;
                    for (char c : allChars) {
                        if (myChar.canBe.get(c) == null) {
                            tmp[i] = c;
                            ctmp = c;
                        }
                    }
                    if (ctmp != 0) {
                        allChars.remove(ctmp);
                    }

                }
            }
        }
        StringBuilder s = new StringBuilder();
        for (char c : tmp) {
            s.append(c);
        }
        return s.toString();
    }

    public void add(String R, String Q) {

        boolean first = true;
        //warunek nie moze byc 0 w jednej cyfrze
        for (char c : R.toCharArray()) {
            if (allChars.size() < 10) {
                allChars.add(c);
            }
            if (first) {
                possibilities.get(0).canBe.put(c, false);
                first = false;
                if (R.length() == Q.length()) {
                    //bardziej zawezic wykorzystujac kolejne liczby
                    for (int i = Integer.parseInt(String.valueOf(Q.charAt(0))) + 1; i <= 9; i++) {
                        possibilities.get(i).canBe.put(c, false);
                    }
                }
            }
        }
    }
}

class MyChar {
    Map<Character, Boolean> canBe = new HashMap<>();
}
