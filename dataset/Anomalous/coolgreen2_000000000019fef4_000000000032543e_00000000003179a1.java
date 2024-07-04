import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(br.readLine());
        
        for (int cases = 1; cases <= T; cases++) {
            System.out.print("Case #" + cases + ": ");
            Map<Integer, Set<Integer>> digitMap = new HashMap<>();
            Set<Character> letters = new HashSet<>();
            int U = Integer.parseInt(br.readLine());
            
            for (int i = 0; i < 26; i++) {
                digitMap.put(i, new HashSet<>(Arrays.asList(0, 1, 2, 3, 4, 5, 6, 7, 8, 9)));
            }
            
            boolean flag = false;
            for (int i = 0; i < 10000; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                int num = Integer.parseInt(st.nextToken());
                String s = st.nextToken();
                
                if (num == -1) {
                    flag = true;
                    if (s.length() > 1) {
                        digitMap.get(s.charAt(0) - 'A').remove(0);
                    }
                } else if (num < 10) {
                    Set<Integer> temp = new HashSet<>();
                    for (int k = 0; k <= num; k++) {
                        temp.add(k);
                    }
                    digitMap.get(s.charAt(0) - 'A').retainAll(temp);
                } else if (String.valueOf(num).length() > s.length() && s.length() > 1) {
                    digitMap.get(s.charAt(0) - 'A').remove(0);
                } else if (!(String.valueOf(num).length() > s.length())) {
                    int check = Integer.parseInt(String.valueOf(num).charAt(0) + "");
                    Set<Integer> temp = new HashSet<>();
                    for (int k = 1; k <= check; k++) {
                        temp.add(k);
                    }
                    digitMap.get(s.charAt(0) - 'A').retainAll(temp);
                }
                
                for (char c : s.toCharArray()) {
                    letters.add(c);
                }
            }
            
            if (flag) {
                StringBuilder ans = new StringBuilder();
                for (int i : digitMap.keySet()) {
                    if (!digitMap.get(i).contains(0)) {
                        ans.append((char) (i + 'A'));
                        letters.remove(ans.charAt(0));
                        break;
                    }
                }
                for (char c : letters) {
                    ans.append(c);
                }
                System.out.println(ans);
            } else {
                char[] ans = new char[10];
                Queue<Character> queue = new LinkedList<>(letters);
                int count = 0;
                
                while (!queue.isEmpty()) {
                    if (digitMap.get(queue.peek() - 'A').size() == 1 || count > 11) {
                        int help = digitMap.get(queue.peek() - 'A').iterator().next();
                        
                        for (char c : letters) {
                            if (digitMap.get(c - 'A').contains(help)) {
                                if (c != queue.peek() && digitMap.get(c - 'A').size() == 1) {
                                    continue;
                                } else {
                                    digitMap.get(c - 'A').remove(help);
                                }
                            }
                        }
                        
                        ans[help] = queue.remove();
                        count = 0;
                    } else {
                        queue.add(queue.remove());
                        count++;
                    }
                }
                System.out.println(new String(ans));
            }
        }
        pw.close();
    }
}