import java.util.Scanner;

class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for (int i = 0; i < t; i++) {
            String s = in.next();
            StackProcessor st = new StackProcessor();
            int[] c = new int[s.length()];

            for (int j = 0; j < s.length(); j++) {
                c[j] = Character.getNumericValue(s.charAt(j));
            }

            int openCount = 0;
            int closeCount = 0;

            for (int j = 0; j < s.length() - 1; j++) {
                if (c[j] > c[j + 1]) {
                    while (openCount - closeCount != c[j]) {
                        st.push("(");
                        openCount++;
                    }
                    st.push(String.valueOf(c[j]));
                    while (openCount - closeCount != c[j + 1]) {
                        st.push(")");
                        closeCount++;
                    }
                } else if (c[j] <= c[j + 1]) {
                    while (openCount - closeCount != c[j]) {
                        st.push("(");
                        openCount++;
                    }
                    st.push(String.valueOf(c[j]));
                }
            }

            if (s.length() == 1) {
                for (int k = 0; k < c[0]; k++) {
                    st.push("(");
                }
                st.push(String.valueOf(c[0]));
                for (int k = 0; k < c[0]; k++) {
                    st.push(")");
                }
            } else {
                if (c[s.length() - 1] > c[s.length() - 2]) {
                    while (openCount - closeCount != c[s.length() - 1]) {
                        st.push("(");
                        openCount++;
                    }
                    st.push(String.valueOf(c[s.length() - 1]));
                    while (openCount - closeCount != 0) {
                        st.push(")");
                        closeCount++;
                    }
                } else {
                    st.push(String.valueOf(c[s.length() - 1]));
                    while (openCount - closeCount != 0) {
                        st.push(")");
                        closeCount++;
                    }
                }
            }

            System.out.print("Case #" + (i + 1) + ": ");
            st.print();
        }
    }
}

class StackProcessor {
    private int top;
    private final int max = 1000;
    private final String[] stackArray;

    StackProcessor() {
        top = -1;
        stackArray = new String[max];
    }

    void push(String x) {
        if (top >= max - 1) {
            System.out.println("Stack Overflow");
        } else {
            stackArray[++top] = x;
        }
    }

    void print() {
        for (int i = 0; i <= top; i++) {
            System.out.print(stackArray[i]);
        }
        System.out.println();
    }
}