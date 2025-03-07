import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Solution {
    private static final String USER_DIR = System.getProperty("user.dir");
    private static final String CNAME = Solution.class.getName();
    private static final Random RAND = new Random();

    private static boolean simulate = false;
    private static int B = 0;
    private static StringBuilder SB = new StringBuilder();
    private static int askIndex = 0;

    private static String join(Iterable<?> objs, String delimiter) {
        StringBuilder sb = new StringBuilder();
        Iterator<?> it = objs.iterator();
        while (it.hasNext()) {
            sb.append(it.next().toString());
            if (it.hasNext()) sb.append(delimiter);
        }
        return sb.toString();
    }

    private static void resetSimulator() {
        askIndex = 0;
        SB.setLength(0);
        for (int i = 0; i < B; i++) {
            SB.append(RAND.nextInt(2));
        }
        System.out.format("inpt %s\n", SB.toString());
    }

    private static char ask(Scanner in, int P) {
        if (simulate) {
            if (askIndex == 0) {
                resetSimulator();
            }
            askIndex++;
            if (askIndex % 10 == 1) {
                int effect = RAND.nextInt(4);
                if (effect == 1 || effect == 3) {
                    for (int i = 0; i < B; i++) {
                        SB.setCharAt(i, SB.charAt(i) == '0' ? '1' : '0');
                    }
                    System.out.format("comp %s\n", SB.toString());
                }
                if (effect == 2 || effect == 3) {
                    SB.reverse();
                    System.out.format("reve %s\n", SB.toString());
                }
            }
            return SB.charAt(P);
        } else {
            System.out.println(P);
            System.out.flush();
            char c = in.next().charAt(0);
            if (c != '0' && c != '1') {
                throw new RuntimeException("Unexpected " + c);
            }
            return c;
        }
    }

    private static char ask(Scanner in, String s) {
        if (simulate) {
            askIndex = 0;
            System.out.format("ask  %s %c\n", s, s.equals(SB.toString()) ? 'Y' : 'N');
            System.out.format("expt %s\n", SB.toString());
            return s.equals(SB.toString()) ? 'Y' : 'N';
        } else {
            System.out.println(s);
            System.out.flush();
            return in.next().charAt(0);
        }
    }

    private static String show(List<Character> front, List<Character> back) {
        StringBuilder sb = new StringBuilder();
        for (char c : front) {
            sb.append(c);
        }
        for (int i = 0; i < B - front.size() - back.size(); i++) {
            sb.append('.');
        }
        Collections.reverse(back);
        for (char c : back) {
            sb.append(c);
        }
        Collections.reverse(back);
        return sb.toString();
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int T = simulate ? 100 : in.nextInt();
        B = simulate ? 100 : in.nextInt();

        for (int t = 1; t <= T; t++) {
            List<Character> front = new ArrayList<>();
            List<Character> back = new ArrayList<>();
            int index = 0;

            while (front.size() + back.size() < B) {
                index++;
                int h = (front.size() <= back.size()) ? front.size() : B - 1 - back.size();
                char ch = ask(in, h);

                if (index > 1 && index % 10 == 1) {
                    for (int i = 0; i < Math.min(front.size(), back.size()); i++) {
                        if (front.get(i) == back.get(i)) {
                            index++;
                            char ci = ask(in, i);
                            if (ci != front.get(i)) {
                                for (int j = 0; j < front.size(); j++) {
                                    front.set(j, front.get(j) == '0' ? '1' : '0');
                                }
                                for (int j = 0; j < back.size(); j++) {
                                    back.set(j, back.get(j) == '0' ? '1' : '0');
                                }
                                if (simulate) {
                                    System.out.format("comp %s detected\n", show(front, back));
                                }
                            }
                            break;
                        }
                    }

                    for (int i = 0; i < Math.min(front.size(), back.size()); i++) {
                        if (front.get(i) != back.get(i)) {
                            index++;
                            char ci = ask(in, i);
                            if (ci != front.get(i)) {
                                List<Character> temp = front;
                                front = back;
                                back = temp;
                                if (simulate) {
                                    System.out.format("reve %s detected\n", show(front, back));
                                }
                            }
                            break;
                        }
                    }

                    if (front.size() > back.size()) {
                        front.remove(front.size() - 1);
                    } else if (front.size() < back.size()) {
                        back.remove(back.size() - 1);
                    }
                }

                if (h >= front.size() && h <= B - 1 - back.size()) {
                    if (h == front.size()) {
                        front.add(ch);
                    } else if (h == B - 1 - back.size()) {
                        back.add(ch);
                    }
                }

                if (simulate) {
                    System.out.format("%2d %c %s %d\n", h, ch, show(front, back), askIndex);
                }
            }

            char response = ask(in, show(front, back));
            if (response != 'Y') {
                throw new RuntimeException("Not Y");
            }
        }
        in.close();
    }
}