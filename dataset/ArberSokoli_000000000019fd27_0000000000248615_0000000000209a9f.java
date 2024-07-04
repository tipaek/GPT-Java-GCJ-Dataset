import java.util.Scanner;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
	public static void main(String[] args) {
      try (Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)))) {
         int t = Integer.parseInt(sc.nextLine());
         for(int t0 = 0; t0 < t; t0++) {
            String[] s = sc.nextLine().split("");
            String answer = "";
            int count = 0;
            for(int i = 0; i < s.length; i++) {
               int n = Integer.parseInt(s[i]);
               if(count < n) {
                  for(int j = count; j < n; j++) {
                     answer += "(";
                     count++;
                  }
               }
               else if(count > n) {
                  for(int j = count; j > n; j--) {
                     answer += ")";
                     count--;
                  }
               }
               answer += n;
            }
            for(int j = count; j > 0; j--) {
               answer += ")";
            }
            
            System.out.println("Case #" + (t0 + 1) + ": " + answer);
         }
      }
	}
}