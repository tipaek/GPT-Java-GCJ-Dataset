import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int t = input.nextInt();
        input.nextLine(); // Consume the newline

        for (int i = 0; i < t; i++) {
            int n = input.nextInt();
            input.nextLine(); // Consume the newline

            List<Character> beginning = new ArrayList<>();
            List<Character> end = new ArrayList<>();
            List<Character> any = new ArrayList<>();
            boolean works = true;

            for (int k = 0; k < n; k++) {
                String temp = input.nextLine();
                if (!works) {
                    continue;
                }

                int numStars = 0;
                for (char c : temp.toCharArray()) {
                    if (c == '*') {
                        numStars++;
                    }
                }

                if (temp.charAt(0) != '*') {
                    StringBuilder begintest = new StringBuilder();
                    for (char c : temp.toCharArray()) {
                        if (c == '*') {
                            break;
                        }
                        begintest.append(c);
                    }

                    int counter1 = 0;
                    int counter2 = 0;
                    while (counter1 < beginning.size() && counter2 < begintest.length()) {
                        if (beginning.get(counter1) != begintest.charAt(counter2)) {
                            works = false;
                            break;
                        }
                        counter1++;
                        counter2++;
                    }

                    if (!works) {
                        System.out.println("Case #" + (i + 1) + ": *");
                        continue;
                    }

                    if (counter2 < begintest.length()) {
                        beginning.clear();
                        for (char c : begintest.toString().toCharArray()) {
                            beginning.add(c);
                        }
                    }
                }

                if (temp.charAt(temp.length() - 1) != '*') {
                    StringBuilder endtest = new StringBuilder();
                    for (int h = temp.length() - 1; h >= 0; h--) {
                        if (temp.charAt(h) == '*') {
                            break;
                        }
                        endtest.insert(0, temp.charAt(h));
                    }

                    int counter1 = end.size() - 1;
                    int counter2 = endtest.length() - 1;
                    while (counter1 >= 0 && counter2 >= 0) {
                        if (end.get(counter1) != endtest.charAt(counter2)) {
                            works = false;
                            break;
                        }
                        counter1--;
                        counter2--;
                    }

                    if (!works) {
                        System.out.println("Case #" + (i + 1) + ": *");
                        continue;
                    }

                    if (counter2 >= 0) {
                        end.clear();
                        for (char c : endtest.toString().toCharArray()) {
                            end.add(c);
                        }
                    }
                }

                if (numStars >= 2) {
                    int firstPos = temp.indexOf('*');
                    int lastPos = temp.lastIndexOf('*');

                    for (int h = firstPos + 1; h < lastPos; h++) {
                        if (temp.charAt(h) != '*') {
                            any.add(temp.charAt(h));
                        }
                    }
                }
            }

            if (works) {
                StringBuilder result = new StringBuilder();
                for (char c : beginning) {
                    result.append(c);
                }
                for (char c : any) {
                    result.append(c);
                }
                for (char c : end) {
                    result.append(c);
                }
                System.out.println("Case #" + (i + 1) + ": " + result);
            }
        }

        input.close();
    }
}