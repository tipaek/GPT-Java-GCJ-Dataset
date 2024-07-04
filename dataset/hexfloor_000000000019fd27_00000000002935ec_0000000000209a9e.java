

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Solution {
    public static int[] solve(Scanner in, int[] a) {
        return solve(in, a, 0, 10);
    }

    static int[] solve(Scanner in, int[] a, int index, int hit) {
        for (int i = 0; i < hit && index <= (a.length % 2 == 1 ? a.length / 2 + 1 : a.length / 2); i++) {
            a[index] = check(in, index);
            a[a.length - 1 - index] = check(in, a.length - 1 - index);
            index++;
        }
        if (index + 1 >= a.length - 1 - index) {
            return a;
        }
        int match = match(a, index);
        int mismatch = mismatch(a, index);
        if (match == -1) { //pairs like 000...111 or 111...000 -> r+f = id; r=f;
            int mismatchNew = check(in, mismatch);
            if (a[mismatch] != mismatchNew) {
                flip(a);
            }
            check(in, mismatch);//for even numbers
            return solve(in, a, index, 8);
        }
        if (mismatch == -1) { //all numbers are same : r=id; r+f = f;
            int matchNew = check(in, match);
            if (a[match] != matchNew) {
                flip(a);
            }
            check(in, match);//for even numbers
            return solve(in, a, index, 8);
        }
        int matchNew = check(in, match);
        int mismatchNew = check(in, mismatch);
        if (a[match] != matchNew && a[mismatch] != mismatchNew) {
            flip(a);
        } else if (a[match] != matchNew && a[mismatch] == mismatchNew) {
            flip(a);
            reverse(a);

        } else if (a[match] == matchNew && a[mismatch] != mismatchNew) {
            reverse(a);
        } else {
            //same;
        }
        return solve(in, a, index, 8);
    }


    static int match(int[] a, int index) {
        return IntStream.range(0, index).filter(i -> a[i] == a[a.length - 1 - i]).findFirst().orElse(-1);
    }

    static public int mismatch(int[] a, int index) {
        return IntStream.range(0, index).filter(i -> a[i] != a[a.length - 1 - i]).findFirst().orElse(-1);
    }

    static int check(Scanner in, int j) {
        System.out.println(j + 1);
        //return checkInt(in, j);
        //fixme
        return Integer.parseInt(in.next());
    }


    static void reverse(int[] array) {
        for (int i = 0; i < array.length / 2; i++) {
            int temp = array[i];
            array[i] = array[array.length - 1 - i];
            array[array.length - 1 - i] = temp;
        }
    }

    static void flip(int[] array) {
        for (int i = 0; i < array.length / 2; i++) {
            array[i] = array[i] == 1 ? 0 : 1;
        }
    }

    static Random random = new Random();
    static int counter = 0;
    static int[] a;

    static int checkInt(Scanner in, int j) {
        int mode = random.nextInt(4);
        if (counter % 10 == 0) {
            System.out.println("array before : ");
            System.out.println(Arrays.stream(a).boxed().map(Object::toString).collect(Collectors.joining()));
            if (mode == 0) {
                flip(a);
            } else if (mode == 1) {
                reverse(a);
            } else if (mode == 2) {
                flip(a);
                reverse(a);
            }
            System.out.println("array after : ");
            System.out.println(Arrays.stream(a).boxed().map(Object::toString).collect(Collectors.joining()));
        }

        counter++;
        return a[j];
    }

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        int b = in.nextInt();
        for (int i = 1; i <= t; i++) {
            //counter = 0;
            //a = IntStream.range(0, b).map(v -> random.nextInt(2)).toArray();


            int[] res = solve(in, new int[b]);

            String result = Arrays.stream(res).boxed().map(Object::toString).collect(Collectors.joining());
            System.out.println(result);
            //System.out.println("array : ");
            //System.out.println(Arrays.stream(a).boxed().map(Object::toString).collect(Collectors.joining()));
            String judge = in.next();
            if (judge.equals("N")) {
                return;
            }
        }
    }
}