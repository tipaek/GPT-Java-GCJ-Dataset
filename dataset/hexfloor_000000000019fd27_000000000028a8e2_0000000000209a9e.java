
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Solution {
    public static Data solve(Scanner in, Data data) {
        return solve(in, data, 10);
    }

    static Data solve(Scanner in, Data data, int hit) {
        for (int i = 0; i < hit && data.left <= data.right; i++) {
            if (data.left <= data.a.length - 1 - data.right) {
                data.a[data.left] = check(in, data.left);
                data.left++;
            } else {
                data.a[data.right] = check(in,data.right);
                data.right--;
            }
        }
        if (data.left > data.right) {
            return data;
        }
        int match =data.match();
        int mismatch = data.mismatch();
        if (match == -1) { //pairs like 000...111 or 111...000 -> r+f = id; r=f;
            int leftNew = check(in, mismatch);
            if (data.a[mismatch] != leftNew) {
                data.flip();
            }
            return solve(in, data, 9);
        }
        if (mismatch == -1 ){ //all numbers are same : r=id; r+f = f;
            int leftNew = check(in, match);
            if (data.a[match] != leftNew) {
                data.flip();
            }
            return solve(in, data, 9);
        }
        int matchNew = check(in, match);
        int mismatchNew = check(in, mismatch);
        if (data.a[match] != matchNew && data.a[mismatch] != mismatchNew){
            data.flip();
        } else if (data.a[match] != matchNew && data.a[mismatch] == mismatchNew) {
            data.reverse();
        }  else if (data.a[match] == matchNew && data.a[mismatch] != mismatchNew) {
            data.reverse();
            data.flip();
        } else {
            //same;
        }
        return solve(in, data, 8);
    }

    static class Data {
        int []a;
        int left;
        int right;

        public Data(int[] a) {
            this.a = a;
            this.left = 0;
            this.right = a.length -1;
        }
        public void reverse() {
            IntStream.range(0, Math.min(left, a.length - 1 -right)).forEach(i -> swap(a, i, a.length - 1 - i));
            if (left < a.length - 1 - right) {
                a[left] = a[a.length - 1 - right];
                left++;
                right--;

            } else if (a.length -1 - right < left) {
                a[a.length - 1 - right] = a[left];
                left--;
                right++;
            }
        }
        public void flip(){
            IntStream.range(0, left).forEach(i -> a[i] = flip(a[i]));
            IntStream.range(right + 1, a.length).forEach(i -> a[i] = flip(a[i]));
        }
        private int flip(int i) {
            return i==1 ? 0 : 1;
        }
        private void swap(int []a, int i, int j){
            int temp = a[i];
            a[i] = a[j];
            a[j] = temp;
        }
        public int match() {
            return IntStream.range(0, Math.min(left, a.length - 1 - right)).filter(i -> a[i] == a[a.length - 1 - i]).findFirst().orElse(-1);
        }
        public int mismatch() {
            return IntStream.range(0, Math.min(left, a.length - 1 - right)).filter(i -> a[i] != a[a.length - 1 - i]).findFirst().orElse(-1);
        }
    }


    static int check(Scanner in, int j){
        System.out.println(j + 1);
        return Integer.parseInt(in.next());
    }



    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        int b = in.nextInt();
        for (int i = 1; i <= t; i++) {
            Data data = solve(in, new Data(new int[b]));
            String result = Arrays.stream(data.a).boxed().map(Object::toString).collect(Collectors.joining());
            System.out.println(result);

            String judge = in.next();
            if (judge.equals("N")) {
                return;
            }
        }
    }
}