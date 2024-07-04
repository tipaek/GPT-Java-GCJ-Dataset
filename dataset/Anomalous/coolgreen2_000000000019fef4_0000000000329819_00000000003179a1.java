import java.util.*;
import java.io.*;

public class Solution {

    static char[] answer;
    static Map<Integer, Set<Integer>> hm;
    static Set<Character> letters;
    static Set<Character> used;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(br.readLine());
        
        for (int cases = 1; cases <= T; cases++) {
            answer = new char[10];
            Arrays.fill(answer, '!');
            System.out.print("Case #" + cases + ": ");
            
            hm = new HashMap<>();
            letters = new HashSet<>();
            used = new HashSet<>();
            
            int U = Integer.parseInt(br.readLine());
            
            for (int i = 0; i < 26; i++) {
                hm.put(i, new HashSet<>(Arrays.asList(0, 1, 2, 3, 4, 5, 6, 7, 8, 9)));
            }
            
            boolean flag = false;
            for (int i = 0; i < 10000; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                int num = Integer.parseInt(st.nextToken());
                String s = st.nextToken();
                
                if (num == -1) {
                    flag = true;
                    if (s.length() > 1) {
                        hm.get(s.charAt(0) - 'A').remove(0);
                    }
                } else if (num < 10) {
                    Set<Integer> temp = new HashSet<>();
                    for (int k = 0; k <= num; k++) {
                        temp.add(k);
                    }
                    hm.get(s.charAt(0) - 'A').retainAll(temp);
                } else if ((num + "").length() > s.length() && s.length() > 1) {
                    hm.get(s.charAt(0) - 'A').remove(0);
                } else if (!((num + "").length() > s.length())) {
                    int check = Integer.parseInt((num + "").charAt(0) + "");
                    Set<Integer> temp = new HashSet<>();
                    for (int k = 1; k <= check; k++) {
                        temp.add(k);
                    }
                    if (s.length() == 1) {
                        temp.add(0);
                    }
                    hm.get(s.charAt(0) - 'A').retainAll(temp);
                }
                
                for (int k = 0; k < s.length(); k++) {
                    letters.add(s.charAt(k));
                }
                
                if (letters.size() != 10) {
                    for (int key : hm.keySet()) {
                        if (!letters.contains((char) (key + 'A'))) {
                            letters.add((char) (key + 'A'));
                        }
                        if (letters.size() == 10) {
                            break;
                        }
                    }
                }
            }
            
            if (flag) {
                StringBuilder ans = new StringBuilder();
                for (int i : hm.keySet()) {
                    if (!hm.get(i).contains(0)) {
                        ans.append((char) (i + 'A'));
                        letters.remove((char) (i + 'A'));
                        break;
                    }
                }
                for (char c : letters) {
                    ans.append(c);
                }
                System.out.println(ans);
            } else {
                for (char c : letters) {
                    if (hm.get(c - 'A').size() == 1) {
                        int help = hm.get(c - 'A').iterator().next();
                        answer[help] = c;
                        used.add(c);
                    }
                }
                if (doThing(0)) {
                    System.out.println(new String(answer));
                }
            }
        }
        pw.close();
    }

    private static boolean doThing(int i) {
        if (i == 10) {
            return true;
        }
        if (answer[i] != '!') {
            return doThing(i + 1);
        }
        for (char c : letters) {
            if (hm.get(c - 'A').contains(i) && !used.contains(c)) {
                used.add(c);
                for (Set<Integer> set : hm.values()) {
                    set.remove(i);
                }
                answer[i] = c;
                if (doThing(i + 1)) {
                    return true;
                }
                answer[i] = '!';
                used.remove(c);
                for (Set<Integer> set : hm.values()) {
                    set.add(i);
                }
            }
        }
        return false;
    }
}