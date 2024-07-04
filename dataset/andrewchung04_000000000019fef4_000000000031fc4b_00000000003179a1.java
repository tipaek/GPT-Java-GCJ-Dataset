import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();

        for (int i = 0; i < t; i++) {
            int u = scanner.nextInt();
            boolean[][] ar = new boolean[10][10];
            HashMap<Character, Integer> map = new HashMap<>();
            HashMap<Integer, Character> reverse = new HashMap<>();
            String[] lonerfinder = new String[10000];
            int index = 0;

            for (int j = 0; j < 10000; j++) {
                String num = scanner.next();
                String str = scanner.next();
                lonerfinder[j] = str;
                
                if(num.length() == str.length()) {
                    if(map.containsKey(str.charAt(0))) {
                        int work = map.get(str.charAt(0));
                        for (int k = (num.charAt(0) - '0') + 1; k < 10; k++) {
                            ar[work][k] = true;
                        }
                    }
                    else {
                        map.put(str.charAt(0), index);
                        reverse.put(index, str.charAt(0));
                        index++;
                        int work = map.get(str.charAt(0));
                        for (int k = (num.charAt(0) - '0') + 1; k < 10; k++) {
                            ar[work][k] = true;
                        }
                    }
                }
            }


            Character loner = '1';

            outer: for (int j = 0; j < 10000; j++) {
                String cur = lonerfinder[j];

                for (int k = 0; k < cur.length(); k++) {
                    if(!map.containsKey(cur.charAt(k))) {
                        loner = cur.charAt(k);
                        break outer;
                    }
                }
            }

            char[] ans = new char[10];
            ArrayList<Character>[] possible = new ArrayList[10];

            for (int j = 0; j < possible.length; j++) {
                possible[j] = new ArrayList<Character>();
            }

            for (int j = 0; j < 10; j++) {
                for (int k = 0; k < 10; k++) {
                    if(!ar[j][k]) {
                        if(reverse.get(j) == null) {
                            continue;
                        }
                        else {
                            possible[k].add(reverse.get(j));
                        }

                    }
                }
            }

            int count = 0;

            while(count != 8) {
                ArrayList<Character> recent = new ArrayList<>();
                for (int j = 0; j < possible.length; j++) {
                    if(possible[j].size() == 1) {
                        count++;
                        recent.add(possible[j].get(0));
                        ans[j] = possible[j].get(0);
                    }
                }

                for (int j = 0; j < 10; j++) {
                    for (int k = 0; k < possible[j].size(); k++) {
                        for (int l = 0; l < recent.size(); l++) {
                            if(possible[j].get(k) == recent.get(l)) {
                                possible[j].remove(k);
                            }
                        }
                    }
                }
            }

            for (int j = possible.length - 1; j >= 0; j--) {
                if(possible[j].size() == 1) {
                    ans[j] = possible[j].get(0);
                    possible[j].remove(0);
                    break;
                }
            }

            for (int j = 0; j < possible.length; j++) {
                if(possible[j].size() == 1) {
                    ans[j] = loner;
                }
            }



            String returner = "";

            for (int j = 0; j < ans.length; j++) {
                returner += ans[j];
            }
            System.out.println("Case #" + (i + 1) + ": " + returner);
        }
    }
}
