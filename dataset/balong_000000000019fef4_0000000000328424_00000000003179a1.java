import java.util.*;
import java.io.*;

class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        solve(in);
    }


    public static void solve(Scanner scanner) {

        int numberOfCase = Integer.parseInt(scanner.nextLine());

        for (int ca = 1; ca <= numberOfCase; ca++) {
            int U = Integer.parseInt(scanner.nextLine());
            HashMap<Character,Boolean> alphabet = new HashMap<Character, Boolean>();
            HashSet<Character> nonZero = new HashSet<Character>();
            HashMap<Character, Long> count = new HashMap<Character, Long>();

            for (int i = 0; i < 10000; i++) {
                
                String caseStr = scanner.nextLine().trim();
                if (caseStr == null || caseStr.compareTo("") == 0 || caseStr.compareTo("-1") == 0) {
                    
                    continue;
                }
                String[] pair = caseStr.split(" ");

                long number = Long.parseLong(pair[0]);
                if (number == (long)-1) {
                    continue;
                }
                
                String erpStr = pair[1];
                for (int index = 0; index < erpStr.length(); index++) {
                    char c = erpStr.charAt(index);
                    if (index == 0) nonZero.add(c);
                    count.put(c, count.getOrDefault(c, (long)0) + 1);
                    alphabet.put(c, false);
                }
            }
            char zero = 'a';
            for (Character c : alphabet.keySet()) {
                if (!nonZero.contains(c)) {
                    alphabet.put(c, true);
                    zero = c;
                }
            }

            String alp = "" + zero;
            for (int i = 1; i <= 9; i++) {
                long max = 0;
                char curC = zero;
                for (Character c : alphabet.keySet()) {
                    if (alphabet.get(c)) {
                        continue;
                    }
                    if (count.get(c) > max) {
                        max = count.get(c);
                        curC = c;
                    }
                }
                alp = alp +  curC;
                alphabet.put(curC, true);
            }
            System.out.println("Case #" + ca + ": " + alp);
            
        }
        
    }
}

