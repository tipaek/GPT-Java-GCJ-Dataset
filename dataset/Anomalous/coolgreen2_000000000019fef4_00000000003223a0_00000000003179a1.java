import java.util.*;
import java.io.*;

public class Solution {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("file.txt"));
        PrintWriter pw = new PrintWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(br.readLine());
        
        for (int cases = 1; cases <= T; cases++) {
            System.out.print("Case #" + cases + ": ");
            Map<Integer, Set<Integer>> digitPossibilities = new HashMap<>();
            Set<Character> letters = new HashSet<>();
            int U = Integer.parseInt(br.readLine());

            for (int i = 0; i < 26; i++) {
                Set<Integer> possibleDigits = new HashSet<>();
                for (int j = 0; j < 10; j++) {
                    possibleDigits.add(j);
                }
                digitPossibilities.put(i, possibleDigits);
            }

            boolean unknownDigit = false;

            for (int i = 0; i < 10000; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                int num = Integer.parseInt(st.nextToken());
                String s = st.nextToken();

                if (num == -1) {
                    unknownDigit = true;
                    if (s.length() > 1) {
                        digitPossibilities.get(s.charAt(0) - 'A').remove(0);
                    }
                } else if (num < 10) {
                    Set<Integer> validDigits = new HashSet<>();
                    for (int k = 0; k <= num; k++) {
                        validDigits.add(k);
                    }
                    digitPossibilities.get(s.charAt(0) - 'A').retainAll(validDigits);
                } else if (String.valueOf(num).length() > s.length() && s.length() > 1) {
                    digitPossibilities.get(s.charAt(0) - 'A').remove(0);
                } else if (!(String.valueOf(num).length() > s.length())) {
                    int firstDigit = Integer.parseInt(String.valueOf(num).substring(0, 1));
                    Set<Integer> validDigits = new HashSet<>();
                    for (int k = 0; k <= firstDigit; k++) {
                        validDigits.add(k);
                    }
                    digitPossibilities.get(s.charAt(0) - 'A').retainAll(validDigits);
                }

                for (char c : s.toCharArray()) {
                    letters.add(c);
                }
            }

            if (unknownDigit) {
                StringBuilder ans = new StringBuilder();
                for (int i : digitPossibilities.keySet()) {
                    if (!digitPossibilities.get(i).contains(0)) {
                        ans.append((char) (i + 'A'));
                        letters.remove((char) (i + 'A'));
                        break;
                    }
                }
                for (char c : letters) {
                    ans.append(c);
                }
                System.out.println(ans.toString());
            } else {
                char[] ans = new char[10];
                Queue<Character> queue = new LinkedList<>(letters);
                int count = 0;

                while (!queue.isEmpty()) {
                    char currentChar = queue.peek();
                    if (digitPossibilities.get(currentChar - 'A').size() == 1 || count > 11) {
                        int digit = digitPossibilities.get(currentChar - 'A').iterator().next();
                        ans[digit] = currentChar;
                        queue.poll();
                        for (char c : letters) {
                            digitPossibilities.get(c - 'A').remove(digit);
                        }
                        count = 0;
                    } else {
                        queue.add(queue.poll());
                        count++;
                    }
                }
                System.out.println(new String(ans));
            }
        }
        pw.close();
    }
}