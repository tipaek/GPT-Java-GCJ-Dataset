import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Jojstepersan
 */
public class Solution {

    static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    public static void main(String[] args) throws Exception {
        int t = Integer.valueOf(in.readLine());
        for (int i = 0; i < t; i++) {
            String number = in.readLine();
            String result = "";
            int left = 0;
            int n = Integer.valueOf(number.charAt(0) + "");
            left += n;
            for (int k = 0; k < left; k++) {
                result += "(";
            }
            result += n + "";
            int before = n;
            for (int j = 1; j < number.length(); j++) {
                n = Integer.valueOf(number.charAt(j) + "");
                if (n == before) {
                    result += n + "";
                } else if (n < before) {
                    left -= n;
                    for (int k = 0; k < left; k++) {
                        result += ")";
                    }
                    result += n + "";
                    left = n;
                } else if (n > before) {
                    left = Math.abs(left - n);
                    for (int k = 0; k < left; k++) {
                        result += "(";
                    }
                    left = n;
                    result += n;
                }
                before = n;
            }
            for (int k = 0; k < left; k++) {
                result += ")";
            }
            System.out.printf("Case #%d: %s\n", i + 1, result);
        }
    }
}