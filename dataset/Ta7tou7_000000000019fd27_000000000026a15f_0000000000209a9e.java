import java.util.Arrays;
import java.util.EnumSet;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        int b = sc.nextInt();
        for (int x = 1; x <= t; x++) {
           solve(b, sc);
        }
    }

    private static void solve(int b, Scanner sc) {
        int count = 1;
        int half = b >> 1;
        int[] content = new int[b];

        for (int i = 0; i < half; i++, count+=2) {
            if (count%10 == 1 && count > 1) {
                fluctuation(content, half, sc);
                count += 2;
            }
            int req = i+1;
            System.out.println(req);
            int ans = sc.nextInt();
            int req2 = content.length - i;
            System.out.println(req2);
            int ans2 = sc.nextInt();
            content[req-1] = ans;
            content[req2-1] = ans2;
        }

        String res = Arrays.stream(content)
                .mapToObj(String::valueOf)
                .collect(Collectors.joining());
        System.out.println(res);
        if("N".equals(sc.next())) System.exit(1);
    }

    private static void fluctuation(int[] b, int half, Scanner sc) {
        int l = b.length;
        int i0 = 1, i1 = i0;
        if(b[0] == b[l-1]) {
            for (int i = 1; i < half; i++) {
                if(b[i] != b[l-1-i]) {
                    i1 = i+1;
                    break;
                }
            }
        }

        else {
            for (int i = 1; i < half; i++) {
                if(b[i] == b[l-1-i]) {
                    i1 = i+1;
                    break;
                }
            }
        }

        System.out.println(i0);
        int after = sc.nextInt();
        EnumSet<Action> possibles1 = Action.possible(i0, after, b);
        System.out.println(i1);
        after = sc.nextInt();
        EnumSet<Action> possibles2 = Action.possible(i1, after, b);
        possibles1.retainAll(possibles2);
        Action action = possibles1.stream()
                .findAny()
                .orElse(Action.NONE);
        for (int i = 0; i < half; i++) {
            int res0 = action.apply(i, b);
            int res1 = action.apply(b.length-1-i, b);
            b[i] = res0;
            b[b.length-1-i] = res1;
        }
    }

    enum Action {
        NONE {
            @Override
            int apply(int i, int[] b) {
                return b[i];
            }
        }, REVERSE {
            @Override
            int apply(int i, int[] b) {
                return b[b.length-1-i];
            }
        }, COMPLEMENTARY {
            @Override
            int apply(int i, int[] b) {
                return 1-b[i];
            }
        }, REVERSE_COMPLEMENTARY {
            @Override
            int apply(int i, int[] b) {
                return 1- b[b.length-1-i];
            }
        };
        abstract int apply(int index, int[] bits);
        static EnumSet<Action> possible(int i, int after, int[] b) {
            return EnumSet.allOf(Action.class).stream()
                    .filter(action -> action.apply(i-1, b) == after)
                    .collect(Collectors.toCollection(() -> EnumSet.noneOf(Action.class)));
        }
    }
}
