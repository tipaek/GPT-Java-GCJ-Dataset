import java.util.*;
import java.lang.*;

class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int T = in.nextInt(); in.nextLine();
        ArrayList<String> responses = new ArrayList<>();
        char openedParenthesis = '(', closedParenthesis = ')';

        for(int i = 0; i < T; i++) {
            String s = in.nextLine();
            char[] numbers = s.toCharArray();
            int length = numbers.length;
            StringBuilder S = new StringBuilder();

            if(length == 1) {
                for(int open = 0; open < Character.getNumericValue(numbers[0]); open++)
                    S.append(openedParenthesis);
                S.append(numbers[0]);
                for(int close = 0; close < Character.getNumericValue(numbers[0]); close++)
                    S.append(closedParenthesis);
            } else {
                for (int j = 0; j < length - 1; j++) {
                    int number = Character.getNumericValue(numbers[j]), nextNumber = Character.getNumericValue(numbers[j + 1]);
                    if (j == 0) {
                        int open = 0;
                        while (open < number) {
                            S.append(openedParenthesis);
                            open++;
                        }
                        S.append(number);
                    }
                    if (number > nextNumber) {
                        int diff = number - nextNumber, closed = 0;
                        while (closed < diff) {
                            S.append(closedParenthesis);
                            closed++;
                        }
                        S.append(nextNumber);
                    } else if (number < nextNumber) {
                        int diff = nextNumber - number, open = 0;
                        while (open < diff) {
                            S.append(openedParenthesis);
                            open++;
                        }
                        S.append(nextNumber);
                    } else {
                        S.append(nextNumber);
                    }
                }

                int closed = 0;
                while (closed < Character.getNumericValue(numbers[length - 1])) {
                    S.append(closedParenthesis);
                    closed++;
                }
            }

            responses.add(S.toString());
        }

        for(int i = 0; i < T; i++){
            System.out.println("Case #" + (i + 1) + ": " + responses.toArray()[i]);
        }
    }
}
