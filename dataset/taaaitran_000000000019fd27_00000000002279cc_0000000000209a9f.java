/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.util.*;
import java.io.*;

/**
 *
 * @author lap13310
 */
public class Solution {

    public static void main(String[] args) throws FileNotFoundException {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int numTest = in.nextInt();  // Scanner has functions to read ints, longs, strings, chars, etc.
        in.nextLine();
        for (int n = 1; n <= numTest; ++n) {
            String s = in.nextLine();
            String ret = "";
            int len = s.length();
            int prevNum = 0;
            for (int i = 0; i < len; i++) {
                int number = Integer.parseInt(s.charAt(i) + "");
                ret = verify(ret, prevNum, number);
                prevNum = number;
                if (i == len - 1) {
                    for (int j = 0; j < number; j++) {
                        ret += ')';
                    }
                }
            }
            System.out.println("Case #" + n + ": " + ret);
        }
    }

    static String verify(String ret, int prevNum, int curentNum) {
        int diff = curentNum - prevNum;
        if (diff < 0) {
            for (int i = 0; i < Math.abs(diff); i++) {
                ret += ')';
            }
            ret += curentNum;
        } else if (diff > 0) {
            for (int i = 0; i < Math.abs(diff); i++) {
                ret += '(';
            }
            ret += curentNum;
        } else {
            ret += curentNum;
        }
        return ret;
    }
}
