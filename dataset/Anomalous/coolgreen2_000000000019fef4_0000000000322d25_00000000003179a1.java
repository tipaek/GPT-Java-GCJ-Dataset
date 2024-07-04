import java.util.*;
import java.io.*;

public class Solution {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(br.readLine());

        for (int cases = 1; cases <= T; cases++) {
            System.out.print("Case #" + cases + ": ");
            Map<Integer, Set<Integer>> digitPossibilities = new HashMap<>();
            Set<Character> letters = new HashSet<>();
            int U = Integer.parseInt(br.readLine());

            initializeDigitPossibilities(digitPossibilities);

            boolean unknownFlag = false;

            for (int i = 0; i < 10000; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                int num = Integer.parseInt(st.nextToken());
                String s = st.nextToken();

                if (num == -1) {
                    unknownFlag = true;
                    if (s.length() > 1) {
                        digitPossibilities.get(s.charAt(0) - 'A').remove(0);
                    }
                } else {
                    updateDigitPossibilities(digitPossibilities, num, s);
                }

                for (int k = 0; k < s.length(); k++) {
                    letters.add(s.charAt(k));
                }
            }

            if (unknownFlag) {
                handleUnknownCase(digitPossibilities, letters);
            } else {
                handleKnownCase(digitPossibilities, letters);
            }
        }

        pw.close();
    }

    private static void initializeDigitPossibilities(Map<Integer, Set<Integer>> digitPossibilities) {
        for (int i = 0; i < 26; i++) {
            Set<Integer> possibilities = new HashSet<>();
            for (int j = 0; j < 10; j++) {
                possibilities.add(j);
            }
            digitPossibilities.put(i, possibilities);
        }
    }

    private static void updateDigitPossibilities(Map<Integer, Set<Integer>> digitPossibilities, int num, String s) {
        if (num < 10) {
            Set<Integer> temp = new HashSet<>();
            for (int k = 0; k <= num; k++) {
                temp.add(k);
            }
            digitPossibilities.get(s.charAt(0) - 'A').retainAll(temp);
        } else if ((num + "").length() > s.length() && s.length() > 1) {
            digitPossibilities.get(s.charAt(0) - 'A').remove(0);
        } else if (!((num + "").length() > s.length())) {
            int check = Integer.parseInt((num + "").charAt(0) + "");
            Set<Integer> temp = new HashSet<>();
            for (int k = 1; k <= check; k++) {
                temp.add(k);
            }
            digitPossibilities.get(s.charAt(0) - 'A').retainAll(temp);
        }
    }

    private static void handleUnknownCase(Map<Integer, Set<Integer>> digitPossibilities, Set<Character> letters) {
        StringBuilder answer = new StringBuilder();
        for (int i : digitPossibilities.keySet()) {
            if (!digitPossibilities.get(i).contains(0)) {
                answer.append((char) (i + 'A'));
                letters.remove(answer.charAt(0));
                break;
            }
        }
        for (char c : letters) {
            answer.append(c);
        }
        System.out.println(answer);
    }

    private static void handleKnownCase(Map<Integer, Set<Integer>> digitPossibilities, Set<Character> letters) {
        char[] answer = new char[10];
        Queue<Character> queue = new LinkedList<>(letters);
        int count = 0;

        while (!queue.isEmpty()) {
            char currentChar = queue.peek();
            Set<Integer> possibleDigits = digitPossibilities.get(currentChar - 'A');

            if (possibleDigits.size() == 1 || count > 11) {
                int digit = possibleDigits.iterator().next();
                answer[digit] = currentChar;
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
        System.out.println(new String(answer));
    }
}