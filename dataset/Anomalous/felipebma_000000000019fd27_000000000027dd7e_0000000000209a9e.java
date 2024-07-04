import java.util.Scanner;

class D {

    static Scanner in = new Scanner(System.in);
    static int left, right;

    public static void main(String[] args) {
        int nCases = in.nextInt();
        int b = in.nextInt();
        
        for (int i = 0; i < nCases; i++) {
            solve(b);
            if (in.next().equals("N")) {
                return;
            }
        }
    }

    static void solve(int size) {
        int[] ans = new int[size];
        Integer[] equals = new Integer[2];
        Integer[] different = new Integer[2];
        left = 0;
        right = size - 1;

        initializeEdges(ans, equals, different, size);
        
        while (right >= left) {
            if (equals[0] != null && different[0] != null) {
                resolveBoth(ans, equals, different);
            } else if (equals[0] != null) {
                resolveEquals(ans, equals, different);
            } else {
                resolveDifferent(ans, equals, different);
            }
        }

        System.out.println(arrayToString(ans));
    }

    static void initializeEdges(int[] ans, Integer[] equals, Integer[] different, int size) {
        for (int i = 0; i < 5; i++) {
            ans[left++] = ask(left);
        }
        for (int i = 0; i < 5; i++) {
            ans[right--] = ask(right);
            if (ans[size - 1 - right] == ans[right + 1]) {
                equals[0] = size - 1 - right;
                equals[1] = right + 1;
            } else {
                different[0] = size - 1 - right;
                different[1] = right + 1;
            }
        }
    }

    static int ask(int pos) {
        System.out.println(pos + 1);
        return in.nextInt();
    }

    static void resolveBoth(int[] ans, Integer[] equals, Integer[] different) {
        int askE = ask(equals[0]);
        int askD = ask(different[0]);

        if (askE == ans[equals[0]] && askD != ans[different[0]]) {
            reverse(ans);
        } else if (askE != ans[equals[0]] && askD == ans[different[0]]) {
            reverse(ans);
            invert(ans);
        } else if (askE != ans[equals[0]]) {
            invert(ans);
        }

        fillNextFour(ans);
    }

    static void resolveEquals(int[] ans, Integer[] equals, Integer[] different) {
        if (ask(equals[0]) != ans[equals[0]]) {
            invert(ans);
        }
        ask(equals[0]);
        fillNextFour(ans);
        updateDifferent(ans, different);
    }

    static void resolveDifferent(int[] ans, Integer[] equals, Integer[] different) {
        if (ask(different[0]) != ans[different[0]]) {
            reverse(ans);
        }
        ask(different[0]);
        fillNextFour(ans);
        updateEquals(ans, equals);
    }

    static void fillNextFour(int[] ans) {
        for (int i = 0; i < 4; i++) {
            ans[left + i] = ask(left + i);
            ans[right - i] = ask(right - i);
        }
        left += 4;
        right -= 4;
    }

    static void updateDifferent(int[] ans, Integer[] different) {
        for (int i = 0; i < 4; i++) {
            if (ans[left + i] != ans[right - i]) {
                different[0] = left + i;
                different[1] = right - i;
            }
        }
    }

    static void updateEquals(int[] ans, Integer[] equals) {
        for (int i = 0; i < 4; i++) {
            if (ans[left + i] == ans[right - i]) {
                equals[0] = left + i;
                equals[1] = right - i;
            }
        }
    }

    static void reverse(int[] ans) {
        for (int i = 0; i < ans.length / 2; i++) {
            swap(ans, i, ans.length - 1 - i);
        }
        int temp = left;
        left = ans.length - 1 - right;
        right = ans.length - 1 - temp;
    }

    static void swap(int[] ans, int a, int b) {
        int temp = ans[a];
        ans[a] = ans[b];
        ans[b] = temp;
    }

    static void invert(int[] ans) {
        for (int i = 0; i < ans.length; i++) {
            ans[i] = (ans[i] + 1) % 2;
        }
    }

    static String arrayToString(int[] arr) {
        StringBuilder sb = new StringBuilder();
        for (int num : arr) {
            sb.append(num);
        }
        return sb.toString();
    }
}