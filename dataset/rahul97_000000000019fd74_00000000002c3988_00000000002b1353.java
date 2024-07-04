// package normal;
import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) {
        try (Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)))) {
            int t = in.nextInt();
            in.nextLine();
            for (int i = 1; i <= t; ++i) {
                int m = in.nextInt();
                System.out.println("Case #" + i + ": " + extracted(m));
                if (i != t) {
                    in.nextLine();
                }
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    private static String extracted(Integer n) {
        StringBuilder str  = new StringBuilder();
        ArrayList<String> ans = new ArrayList<>();
        Integer sum = 0;
        Integer r = 0;
        Integer c = 0;
        ans.add((r+1)+ " " + (c+1));
        sum = 1;
        boolean reach = false;
        while(sum < n) {
                if (((r % 2 == 0 && r == c) || (r % 2 != 0 && c == 0)) && !reach) {
                    if (n < (r*r + sum)) {
                        // print("reached");
                        reach = true;
                    } else {
                        if (c!=0) {
                            r++;
                            c++;
                            // print("turning c++ r++");
                        } else {
                            // print("turning r++");
                            r++;
                        }
                     }
                } else {
                    if (r % 2 == 0) {
                        // print("c++");
                        c++;
                    } else {
                        // print("c--");
                        c--;
                    }
                }
                if (reach) {
                    if (r==c) {
                        r++;
                        c++;
                    } else if (c==0) {
                        r++;
                    }
                }
                // print(r + " "+ c);
            // println(r + " "+c + " "+nCr(r,c));
            sum += nCr(r,c);
            // println(sum);
            ans.add((r+1)+ " " + (c+1));
        }
        for (String s :  ans) {
            str.append("\n");
            str.append(s);
        }
        return str.toString();
    }
    private static void print(int[] nums) {
        for (int i = 0; i< nums.length;i++) {
            print(nums[i]);
        }
        System.out.println();
    }
    private static void println(int nums) {
        System.out.println(nums+" ");
    }
    private static void print(int nums) {
        System.out.print(nums+" ");
    }
    private static void println(String nums) {
        System.out.println(nums+" ");
    }
    private static void print(String nums) {
        System.out.print(nums + " ");
    }

    static int nCr(int n, int r) 
    { 
        return fact(n) / (fact(r) * 
                      fact(n - r)); 
    } 
    static int fact(int n) 
    { 
        int res = 1; 
        for (int i = 2; i <= n; i++) 
            res = res * i; 
        return res; 
    } 
}