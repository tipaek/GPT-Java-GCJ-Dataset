
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Dave
 */
public class Solution {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = Integer.parseInt(input.nextLine());
        String[] lines = new String[n];
        for (int i = 0; i < n; i++) {
            lines[i] = input.nextLine();
        }
        Solution sol = new Solution();
        for (int i = 0; i < n; i++) {
            System.out.println(sol.solve(lines[i], i + 1));
        }
    }

    public String solve(String S, int Case) {
        String newS = "";
        int count = 0;
        for (char c : S.toCharArray()) {
            int x = Character.getNumericValue(c);
            if (x < count) {
                while (x < count) {
                    newS += ")";
                    count--;
                }
            } else if (x > count){
                while (x > count) {
                    newS += "(";
                    count ++;
                }
            }
            newS += c;
        }
        while(count-- > 0){
            newS += ")";
        }
        return String.format("Case #%d: %s", Case, newS);
    }
}
