import java.util.Scanner;
import java.util.Stack;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int T = in.nextInt();
        for (int t = 0; t < T; t++) {
            SString s = new SString(in.next());
            int[] ii = s.toIntArray();
            char[] ch = s.v.toCharArray();
            Stack<Integer> stack = s.toIntStack();

            SString r = new SString("");
            int depth = 0;
            int prevIii = 10;
            while (!stack.isEmpty()) {
                int iii = stack.pop();
                if (prevIii == iii) {
                } else {
                    if (depth == 0) {
                        //                System.out.println("bbb");
                        for (int i = iii - 1; i >= 0; i--) {
                            r.v += '(';
                            depth++;
                        }
                    } else {
                        if (depth > iii) {
                            //                    System.out.println("iii :- " + iii + "depth :- " + depth);

                            int d = depth;
                            for (int i = iii; i < d; i++) {
                                r.v += ')';
                                depth--;
                            }
                        } else if (depth < iii) {
                            //                    System.out.println("ddd" + iii + " depth " + depth);
                            int d = depth;
                            for (int i = d; i < iii; i++) {
                                //                        System.out.println("dddd" + iii);
                                r.v += '(';
                                depth++;
                            }
                        }
                    }
                }
                r.v += iii;
                prevIii = iii;
                if (stack.isEmpty()) {
                    for (int i = 0; i < iii; i++) {
                        r.v += ')';
                    }
                }
            }

            System.out.println("Case #" + (t+1) + ": " + r.v);
        }
    }
}

class SString {
    String v;

    public SString(String v) {
        this.v = v;
    }

    public Stack<Integer> toIntStack() {
        int[] ii = this.toIntArray();
        Stack<Integer> stack = new Stack<>();

        for (int i = ii.length-1; i >= 0; i--) {
            stack.push(ii[i]);
        }

        return stack;
    }

    public int[] toIntArray() {
        int[] i = new int[this.v.length()];
        int in = 0;
        for (char ch: this.v.toCharArray()) {
            i[in++] = Character.digit(ch, 10);
        }

        return i;
    }
}