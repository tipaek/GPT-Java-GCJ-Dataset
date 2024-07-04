import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int t = input.nextInt();
        input.nextLine(); // Consume newline after reading integer

        for (int i = 0; i < t; i++) {
            int n = input.nextInt();
            input.nextLine(); // Consume newline after reading integer

            List<Character> beginning = new ArrayList<>();
            List<Character> end = new ArrayList<>();
            List<Character> any = new ArrayList<>();
            boolean works = true;

            for (int k = 0; k < n; k++) {
                String temp = input.nextLine();
                int starCount = (int) temp.chars().filter(ch -> ch == '*').count();

                if (temp.charAt(0) != '*') {
                    StringBuilder beginTest = new StringBuilder();
                    for (char ch : temp.toCharArray()) {
                        if (ch == '*') break;
                        beginTest.append(ch);
                    }

                    int counter1 = 0, counter2 = 0;
                    while (counter1 < beginning.size() && counter2 < beginTest.length()) {
                        if (!Objects.equals(beginning.get(counter1), beginTest.charAt(counter2))) {
                            works = false;
                            break;
                        }
                        counter1++;
                        counter2++;
                    }

                    if (counter2 < beginTest.length()) {
                        beginning.clear();
                        for (char ch : beginTest.toString().toCharArray()) {
                            beginning.add(ch);
                        }
                    }
                }

                if (temp.charAt(temp.length() - 1) != '*') {
                    StringBuilder endTest = new StringBuilder();
                    int h = temp.length() - 1;
                    while (h >= 0 && temp.charAt(h) != '*') {
                        endTest.insert(0, temp.charAt(h));
                        h--;
                    }

                    int counter1 = end.size() - 1, counter2 = endTest.length() - 1;
                    while (counter1 >= 0 && counter2 >= 0) {
                        if (!Objects.equals(end.get(counter1), endTest.charAt(counter2))) {
                            works = false;
                            break;
                        }
                        counter1--;
                        counter2--;
                    }

                    if (counter2 >= 0) {
                        end.clear();
                        for (char ch : endTest.toString().toCharArray()) {
                            end.add(ch);
                        }
                    }
                }

                if (!works) {
                    System.out.println("Case #" + (i + 1) + ": *");
                    break;
                }

                if (starCount >= 2) {
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
                for (char ch : beginning) result.append(ch);
                for (char ch : any) result.append(ch);
                for (char ch : end) result.append(ch);

                System.out.println("Case #" + (i + 1) + ": " + result);
            }
        }
    }
}