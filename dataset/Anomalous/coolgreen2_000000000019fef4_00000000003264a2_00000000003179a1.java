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
            HashSet<Character> letters = new HashSet<>();
            int U = Integer.parseInt(br.readLine());

            initializeDigitConstraints(digitConstraints);

            boolean flag = false;
            for (int i = 0; i < 10000; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                int num = Integer.parseInt(st.nextToken());
                String s = st.nextToken();

                if (num == -1) {
                    flag = true;
                    if (s.length() > 1) {
                        removeZeroFromFirstCharacter(digitConstraints, s);
                    }
                } else if (num < 10) {
                    retainDigitsUpTo(digitConstraints, s, num);
                } else if (isLongerThan(num, s) && s.length() > 1) {
                    removeZeroFromFirstCharacter(digitConstraints, s);
                } else if (!isLongerThan(num, s)) {
                    retainDigitsUpToFirstDigit(digitConstraints, s, num);
                }

                addCharactersToSet(letters, s);
            }

            if (flag) {
                printResultWithFlag(digitConstraints, letters);
            } else {
                printResultWithoutFlag(digitConstraints, letters);
            }
        }

        pw.close();
    }

    private static void initializeDigitConstraints(HashMap<Integer, HashSet<Integer>> digitConstraints) {
        for (int i = 0; i < 26; i++) {
            digitConstraints.put(i, new HashSet<>());
            for (int j = 0; j < 10; j++) {
                digitConstraints.get(i).add(j);
            }
        }
    }

    private static void removeZeroFromFirstCharacter(HashMap<Integer, HashSet<Integer>> digitConstraints, String s) {
        digitConstraints.get(s.charAt(0) - 'A').remove(0);
    }

    private static void retainDigitsUpTo(HashMap<Integer, HashSet<Integer>> digitConstraints, String s, int num) {
        HashSet<Integer> temp = new HashSet<>();
        for (int k = 0; k <= num; k++) {
            temp.add(k);
        }
        digitConstraints.get(s.charAt(0) - 'A').retainAll(temp);
    }

    private static boolean isLongerThan(int num, String s) {
        return (num + "").length() > s.length();
    }

    private static void retainDigitsUpToFirstDigit(HashMap<Integer, HashSet<Integer>> digitConstraints, String s, int num) {
        int check = Integer.parseInt((num + "").charAt(0) + "");
        HashSet<Integer> temp = new HashSet<>();
        for (int k = 1; k <= check; k++) {
            temp.add(k);
        }
        if (s.length() == 1) {
            temp.add(0);
        }
        digitConstraints.get(s.charAt(0) - 'A').retainAll(temp);
    }

    private static void addCharactersToSet(HashSet<Character> letters, String s) {
        for (int k = 0; k < s.length(); k++) {
            letters.add(s.charAt(k));
        }
    }

    private static void printResultWithFlag(HashMap<Integer, HashSet<Integer>> digitConstraints, HashSet<Character> letters) {
        StringBuilder ans = new StringBuilder();
        for (int i : digitConstraints.keySet()) {
            if (!digitConstraints.get(i).contains(0)) {
                ans.append((char) (i + 'A'));
                letters.remove(ans.charAt(0));
                break;
            }
        }
        for (char c : letters) {
            ans.append(c);
        }
        System.out.println(ans);
    }

    private static void printResultWithoutFlag(HashMap<Integer, HashSet<Integer>> digitConstraints, HashSet<Character> letters) {
        char[] ans = new char[10];
        Queue<Character> queue = new LinkedList<>(letters);
        int count = 0;

        while (!queue.isEmpty()) {
            if (digitConstraints.get(queue.peek() - 'A').size() == 1 || count > 11) {
                int help = digitConstraints.get(queue.peek() - 'A').iterator().next();
                removeFromOtherLetters(digitConstraints, letters, queue.peek(), help);
                ans[help] = queue.poll();
                count = 0;
            } else {
                queue.add(queue.poll());
                count++;
            }
        }
        System.out.println(new String(ans));
    }

    private static void removeFromOtherLetters(HashMap<Integer, HashSet<Integer>> digitConstraints, HashSet<Character> letters, char current, int help) {
        for (char c : letters) {
            if (digitConstraints.get(c - 'A').contains(help)) {
                if (c != current && digitConstraints.get(c - 'A').size() == 1) {
                    return;
                } else {
                    digitConstraints.get(c - 'A').remove(help);
                }
            }
        }
    }
}