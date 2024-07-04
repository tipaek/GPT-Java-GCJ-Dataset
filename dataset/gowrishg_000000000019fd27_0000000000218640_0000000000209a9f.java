import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Scanner;

class Solution {
        public static void main(String[] args) {
            Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
            int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
            for (int i = 1; i <= t; ++i) {
                String input = in.next();
                String ans = solve(input);
                System.out.println("Case #" + i + ": " + ans);
            }
        }

        public static String solve(String input) {
            char[] inputArr = input.toCharArray();
            int[] inputArryNum = new int[inputArr.length];
            for(int i =0; i<inputArr.length; i++) {
                inputArryNum[i] = (int) inputArr[i] - (int) '0';
            }
            StringBuffer ans = new StringBuffer();
            int openParan = 0;
            for(int num: inputArryNum) {
                if(num == openParan) {
                    //ans.append(openParan(num));
                } else if(num < openParan) {
                    ans.append(closeParan(openParan - num));
                    openParan -= (openParan - num);
                } else {
                    ans.append(openParan(num - openParan));
                    openParan += (num - openParan);
                }
                ans.append(num);
            }
            ans.append(closeParan(openParan));
            return ans.toString();
        }

        public static String openParan(int count) {
            String ans = "";
            for(int i=0;i<count;i++) ans += "(";
            return ans;
        }
        public static String closeParan(int count) {
            String ans = "";
            for(int i=0;i<count;i++) ans += ")";
            return ans;
        }
    }