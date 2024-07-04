import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int T = in.nextInt();
        for(int i = 1; i <= T; i++) {
            int x = in.nextInt();
            int y = in.nextInt();
            boolean isXNegative = x < 0;
            boolean isYNegative = y < 0;
            x = Math.abs(x);
            y = Math.abs(y);

            StringBuilder xBit = new StringBuilder();
            StringBuilder yBit = new StringBuilder();

            while(x > 0) {
                xBit.append(x % 2);
                x /= 2;
            }

            while(y > 0) {
                yBit.append(y % 2);
                y /= 2;
            }

            // cleaning

            while(xBit.length() > yBit.length()) yBit.append('0');
            while(xBit.length() < yBit.length()) xBit.append('0');

            int size = xBit.length();

            boolean isImpossible = false;

            Queue<Integer> negativeIdx = new LinkedList<>();

            for(int j = 0; j < size; j++) {
                if(xBit.charAt(j) == yBit.charAt(j)) {
                    if(xBit.charAt(j) == '0') break;
                    if(j == 0) {
                        isImpossible = true;
                        break;
                    } else {
                        if(xBit.charAt(j - 1) == '1') {
                            if(j + 1 > xBit.length() - 1) {
                                negativeIdx.add(j - 1);
                                xBit.append('1');
                                xBit.setCharAt(j, '0');
                            } else if(xBit.charAt(j + 1) == '0') {
                                negativeIdx.add(j - 1);
                                xBit.setCharAt(j + 1, '1');
                                xBit.setCharAt(j, '0');
                            } else {
                                isImpossible = true;
                                break;
                            }
                        } else if (yBit.charAt(j - 1) == '1') {
                            if(j + 1 > yBit.length() - 1) {
                                negativeIdx.add(j - 1);
                                yBit.append('1');
                                yBit.setCharAt(j, '0');
                            } else if(yBit.charAt(j + 1) == '0') {
                                negativeIdx.add(j - 1);
                                yBit.setCharAt(j + 1, '1');
                                yBit.setCharAt(j, '0');
                            } else {
                                isImpossible = true;
                                break;
                            }
                        } else {
                            isImpossible = true;
                            break;
                        }
                    }
                }
            }

            if(isImpossible) {
                System.out.printf("Case #%d: IMPOSSIBLE\n", i);
                break;
            }

            while(xBit.length() > yBit.length()) yBit.append('0');
            while(xBit.length() < yBit.length()) xBit.append('0');

            StringBuilder result = new StringBuilder();

            for(int j = 0; j < xBit.length(); j++) {
                boolean isNegative = false;
                if(!negativeIdx.isEmpty() && negativeIdx.peek() == j) {
                    negativeIdx.remove();
                    isNegative = true;
                }
                if(xBit.charAt(j) == '1') {
                    if(isNegative) result.append(isXNegative ? 'E' : 'W');
                    else result.append(isXNegative ? 'W' : 'E');
                } else if(yBit.charAt(j) == '1') {
                    if(isNegative) result.append(isYNegative ? 'N' : 'S');
                    else result.append(isYNegative ? 'S' : 'N');
                }
            }

            System.out.printf("Case #%d: %s\n", i, result);
        }
    }
}
