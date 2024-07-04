import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.lang.invoke.MethodHandles;
import java.util.*;

public class Solution {
    private static final String USER_DIR = System.getProperty("user.dir");
    private static final String CNAME = MethodHandles.lookup().lookupClass().getName();
    private static final Random RAND = new Random();

    private static boolean simulate = false;
    private static int B = 0;
    private static final StringBuilder SB = new StringBuilder();
    private static int askIndex = 0;

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
            int B = SB.length();
            if (askIndex % 10 == 1) {
                int effect = RAND.nextInt(4);
                if (effect == 1 || effect == 3) {
                    for (int i = 0; i < B; i++) {
                        SB.setCharAt(i, SB.charAt(i) == '0' ? '1' : '0');
                    }
                    System.out.format("comp %s\n", SB.toString());
                }
                if (effect == 2 || effect == 3) {
                    for (int i = 0; i < B / 2; i++) {
                        char temp = SB.charAt(i);
                        SB.setCharAt(i, SB.charAt(B - 1 - i));
                        SB.setCharAt(B - 1 - i, temp);
                    }
                    System.out.format("reve %s\n", SB.toString());
                }
            }
            return SB.charAt(P);
        } else {
            System.out.println(P + 1);
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
                    handleComplementationAndReversal(in, front, back);
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
                System.err.format("%2d %c %s %d\n", h, ch, show(front, back), askIndex);
            }

            char response = ask(in, show(front, back));
            if (response != 'Y') {
                throw new RuntimeException("Not Y");
            }
        }
        in.close();
    }

    private static void handleComplementationAndReversal(Scanner in, List<Character> front, List<Character> back) {
        for (int i = 0; i < Math.min(front.size(), back.size()); i++) {
            if (front.get(i) == back.get(i)) {
                askAndComplement(in, front, back, i);
                break;
            }
        }
        for (int i = 0; i < Math.min(front.size(), back.size()); i++) {
            if (front.get(i) != back.get(i)) {
                askAndReverse(in, front, back, i);
                break;
            }
        }
        adjustFrontAndBackSizes(front, back);
    }

    private static void askAndComplement(Scanner in, List<Character> front, List<Character> back, int i) {
        askIndex++;
        char ci = ask(in, i);
        if (ci != front.get(i)) {
            complementList(front);
            complementList(back);
            if (simulate) {
                System.out.format("comp %s detected\n", show(front, back));
            }
        }
    }

    private static void askAndReverse(Scanner in, List<Character> front, List<Character> back, int i) {
        askIndex++;
        char ci = ask(in, i);
        if (ci != front.get(i)) {
            List<Character> temp = new ArrayList<>(front);
            front.clear();
            front.addAll(back);
            back.clear();
            back.addAll(temp);
            if (simulate) {
                System.out.format("reve %s detected\n", show(front, back));
            }
        }
    }

    private static void complementList(List<Character> list) {
        for (int j = 0; j < list.size(); j++) {
            list.set(j, list.get(j) == '0' ? '1' : '0');
        }
    }

    private static void adjustFrontAndBackSizes(List<Character> front, List<Character> back) {
        if (front.size() > back.size()) {
            front.remove(front.size() - 1);
        } else if (front.size() < back.size()) {
            back.remove(back.size() - 1);
        }
    }
}