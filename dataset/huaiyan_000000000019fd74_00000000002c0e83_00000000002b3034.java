import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
        for (int index = 1; index <= t; ++index) {
            int num = in.nextInt();
            String[] all = new String[num];
            for (int i = 0; i < num; i++) {
                all[i] = in.next();
            }
            System.out.println("Case #" + index + ": " + getRes(all));
        }
    }


    private static String getRes(String[] arr) {
        StringBuilder res = new StringBuilder(arr[0]);
        for (int i = 1; i < arr.length; i++) {
            String str = arr[i];
            char[] toChar = str.toCharArray();
            for (int index = 0; index < toChar.length; index++) {
                if (toChar[index] == '*') {
                    break;
                } else {
                    if (res.charAt(index) == '*') {
                        res.insert(index, toChar[index]);
                    } else if (res.charAt(index) != toChar[index]) {
                        return "*";
                    }
                }
            }

            for (int j = 0; j < toChar.length; j++) {
                if (toChar[toChar.length - 1 - j] == '*') {
                    break;
                } else {
                    if (res.charAt(res.length() - 1 - j) == '*') {
                        res.insert(res.length()  - j, toChar[toChar.length - 1- j]);
                    } else if (res.charAt(res.length() - 1 - j) != toChar[toChar.length - 1 - j]) {
                        return "*";
                    }
                }
            }
        }
        for (int i = 0; i < res.length(); i++) {
            if (res.charAt(i) == '*') {
                res.deleteCharAt(i);
                break;

            }
        }
        return res.toString();
    }

}