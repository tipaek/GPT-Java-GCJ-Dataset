import java.util.*;
import java.io.*;

public class Solution {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(br.readLine());
        
        for (int cases = 1; cases <= T; cases++) {
            System.out.print("Case #" + cases + ": ");
            HashMap<Integer, HashSet<Integer>> digitConstraints = new HashMap<>();
            HashSet<Character> uniqueLetters = new HashSet<>();
            int U = Integer.parseInt(br.readLine());
            
            // Initialize digit constraints
            for (int i = 0; i < 26; i++) {
                HashSet<Integer> digits = new HashSet<>();
                for (int j = 0; j < 10; j++) {
                    digits.add(j);
                }
                digitConstraints.put(i, digits);
            }
            
            boolean invalidCase = false;
            
            for (int i = 0; i < 10000; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                int num = Integer.parseInt(st.nextToken());
                String s = st.nextToken();
                
                if (num == -1) {
                    invalidCase = true;
                    if (s.length() > 1) {
                        digitConstraints.get(s.charAt(0) - 'A').remove(0);
                    }
                } else if (num < 10) {
                    HashSet<Integer> validDigits = new HashSet<>();
                    for (int k = 0; k <= num; k++) {
                        validDigits.add(k);
                    }
                    digitConstraints.get(s.charAt(0) - 'A').retainAll(validDigits);
                } else if ((num + "").length() > s.length() && s.length() > 1) {
                    digitConstraints.get(s.charAt(0) - 'A').remove(0);
                } else if (!((num + "").length() > s.length())) {
                    int firstDigit = Integer.parseInt((num + "").charAt(0) + "");
                    HashSet<Integer> validDigits = new HashSet<>();
                    for (int k = 0; k <= firstDigit; k++) {
                        validDigits.add(k);
                    }
                    digitConstraints.get(s.charAt(0) - 'A').retainAll(validDigits);
                }
                
                for (int k = 0; k < s.length(); k++) {
                    uniqueLetters.add(s.charAt(k));
                }
            }
            
            if (invalidCase) {
                StringBuilder answer = new StringBuilder();
                for (int i : digitConstraints.keySet()) {
                    if (!digitConstraints.get(i).contains(0)) {
                        answer.append((char) (i + 'A'));
                        uniqueLetters.remove(answer.charAt(0));
                        break;
                    }
                }
                for (char c : uniqueLetters) {
                    answer.append(c);
                }
                System.out.println(answer);
            } else {
                char[] answer = new char[10];
                Queue<Character> queue = new LinkedList<>(uniqueLetters);
                int count = 0;
                
                while (!queue.isEmpty()) {
                    char current = queue.peek();
                    if (digitConstraints.get(current - 'A').size() == 1 || count > 11) {
                        int assignedDigit = digitConstraints.get(current - 'A').iterator().next();
                        answer[assignedDigit] = current;
                        queue.poll();
                        for (char c : uniqueLetters) {
                            digitConstraints.get(c - 'A').remove(assignedDigit);
                        }
                        count = 0;
                    } else {
                        queue.add(queue.poll());
                        count++;
                    }
                }
                System.out.println(new String(answer));
            }
        }
        pw.close();
    }
}