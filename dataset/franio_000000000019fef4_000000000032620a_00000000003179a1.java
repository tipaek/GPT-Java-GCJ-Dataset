package com.company;


import java.util.*;
import java.util.stream.Collectors;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long t = scanner.nextLong();
        for (long i = 0; i < t; i++) {
            // nie wykorzystalem jak zawezic
            int U = scanner.nextInt();
            long max = Long.parseLong(String.join("", Collections.nCopies(U, "9")));
            DString dString = new DString();
            for (long j = 0; j < 10000; j++) {
                long Q = scanner.nextLong();
                String R = scanner.next();
                if (Q == -1) {
                    dString.add(R, max);
                }
                dString.add(R, Q);
            }
            String s = dString.hasAll();
            sout(i, s);
        }
        scanner.close();
    }

    private static void sout(long x, String k) {
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
//        for(long i = 0; i < 10; i ++) {
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

    public void add(String R, long Q) {
        String qString = Long.toString(Q);
        boolean first = true;
        //warunek nie moze byc 0 w jednej cyfrze
        for (char c : R.toCharArray()) {
            if (allChars.size() < 10) {
                allChars.add(c);
            }
            if (first) {
                possibilities.get(0).canBe.put(c, false);
                first = false;
                if (R.length() == qString.length()) {
                    //bardziej zawezic wykorzystujac kolejne liczby
                    int firstVal = Integer.parseInt(String.valueOf(qString.charAt(0)));
                    for (int i = firstVal + 1; i <= 9; i++) {
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