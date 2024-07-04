import java.util.*;

class D{

    static Scanner in = new Scanner(System.in);
    static int left, right;

    public static void main(String args[]) {
        int nCases = in.nextInt(), b = in.nextInt();
        for (int i = 0; i < nCases; i++) {
            solve(i, b);
            String str = in.next();
            if(str.equals("N")) return;
        }
    }

    static void solve(int nCase, int size) {
        int[] ans = new int[size];
        Integer[] equals = new Integer[2], different = new Integer[2];
        left = 0;
        right = size - 1;
        while (left < 5) {
            ans[left] = ask(left);
            left++;
        }
        while (right > size - 6) {
            ans[right] = ask(right);
            if (ans[size - 1 - right] == ans[right]) {
                equals[0] = size - 1 - right;
                equals[1] = right;
            } else {
                different[0] = size - 1 - right;
                different[1] = right;
            }
            right--;
        }
        while (right >= left) {
            if (equals[0] != null && different[0] != null) {
                resolveOk(ans, equals, different);
            } else if (equals[0] != null) {
                resolveEquals(ans, equals, different);
            } else {
                resolveDifferent(ans, equals, different);
            }
        }

        StringBuilder aux = new StringBuilder();
        for (int i : ans)
            aux.append(i);
        System.out.println(aux.toString());
    }

    static int ask(int pos) {
        System.out.println(pos + 1);
        return in.nextInt();
    }

    static void resolveOk(int[] ans, Integer[] equals, Integer[] different) {
        int askE = ask(equals[0]), askD = ask(different[0]);
        if(askE==ans[equals[0]] && askD!=ans[different[0]]){
            reverse(ans);
        }else if(askE!=ans[equals[0]] && askD==ans[different[0]]){
            reverse(ans);
            invert(ans);
        }else if(askE!=ans[equals[0]]){
            invert(ans);
        }
        for (int i = 0; i < 4; i++) {
            ans[left + i] = ask(left + i);
            ans[right - i] = ask(right - i);
        }
        left += 4;
        right -= 4;
    }

    static void resolveEquals(int[] ans, Integer[] equals, Integer[] different) {
        if (ask(equals[0]) != ans[equals[0]]) {
            invert(ans);
        }
        ask(equals[0]);
        for (int i = 0; i < 4; i++) {
            ans[left + i] = ask(left + i);
            ans[right - i] = ask(right - i);
            if (ans[left + i] != ans[right - i]) {
                different[0] = left + i;
                different[1] = right - i;
            }
        }
        left += 4;
        right -= 4;

    }

    static void resolveDifferent(int[] ans, Integer[] equals, Integer[] different) {
        if (ask(different[0]) != ans[different[0]]) {
            reverse(ans);
        }
        ask(different[0]);
        for (int i = 0; i < 4; i++) {
            ans[left + i] = ask(left + i);
            ans[right - i] = ask(right - i);
            if (ans[left + i] == ans[right - i]) {
                equals[0] = left + i;
                equals[1] = right - i;
            }
        }
        left += 4;
        right -= 4;
    }

    static void reverse(int[] ans) {
        for (int i = 0; i < ans.length / 2; i++) {
            swap(ans, i, ans.length - 1 - i);
        }
        int aux = left;
        left = ans.length - 1 - right;
        right = ans.length - 1 - aux;
    }

    static void swap(int[] ans, int a, int b) {
        int aux = ans[a];
        ans[a] = ans[b];
        ans[b] = aux;
    }

    static void invert(int[] ans) {
        for (int i = 0; i < ans.length; i++) {
            ans[i] = (ans[i] + 1) % 2;
        }
    }
}