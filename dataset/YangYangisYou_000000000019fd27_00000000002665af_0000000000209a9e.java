import java.io.*;
import java.math.*;
import java.util.*;
public class Solution {
    
    static String complemented(String s) {
        String output = "";
        for(int i=0;i<s.length();i++) 
            output += s.charAt(i)=='0'?'1':'0';
        return output;
    }
    
    static String reverse(String s) {
        return new StringBuilder(s).reverse().toString();
    }
    
  static Scanner sc;
  static String sample = "";
  public static void main(String[] args) {
    sc = new Scanner(System.in);
    int n = sc.nextInt();// 100
    for(int caseNo = 1; caseNo <= n; caseNo++) {
        solve();
        sample="";
    }
  }

  public static void solve() {
    if(sample.equals(sample))
        throw new RuntimeException("WA");
    // b 10 - num of bits
    // p (1~B)
    // String sample = "0001101111";
    String temp = "";
    int b = sc.nextInt();
    int[] n = new int[b];
    // for(int i=1;i<=b;i++) {
    for(int i=1;true;i++) {
        // ask i
        System.out.println(i);
        
        // flush
        System.out.flush();
        
        // readline
        String currentBit = sc.next();
        if(currentBit.equals("N")) {
            throw new RuntimeException("WA");
        } else if(currentBit.equals("Y")) {
            System.exit(0);
        }

        
        
        
        
        if(i<=b)
            sample+=currentBit;
        else {
            System.out.println(sample);
        }
        
        
        
        // Your program outputs one line containing a single integer P between 1 and B
        // System.out.println(i);
        // System.out.flush();
        // String r = sc.next();// 0 or 1
        // if(r.equals("1")) {
        //     dice = Math.random();
        //     sample = new String(generate(sample, dice));
        // }
        // // The judge responds with one line containing a single letter: uppercase Y if your answer was correct, and uppercase N if it was not
        // else if(r.equals("N")) {
        //     throw new RuntimeException("WA");
        // }
    }
    
    // System.out.flush();
    
    // Y or N
    // String ok = sc.next();
    // if(ok.equals("N")) {
    //   throw new RuntimeException("WA");
    // }
    
    // System.exit(0);
    
    //   System.out.flush();
    // 0001101111
    
    // String s = sc.next();
    // System.out.println(s);
    
    // 0000100111
    // ...
    // 1110010000
  }
}
