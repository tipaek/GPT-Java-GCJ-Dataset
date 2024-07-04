import java.util.Scanner;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
	public static void main(String[] args) {
      try (Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)))) {
         
         int[] current = new int[32]; 
         int[] max = new int[32]; 
         int[] min = new int[32];
         int t = Integer.parseInt(sc.nextLine());
         for(int t0 = 0; t0 < t; t0++) {
            String[] s = sc.nextLine().split(" ");
            long x = Long.parseLong(s[0]);
            long y = Long.parseLong(s[1]);
            for(int i = 0; i < 32; i++) {
               max[i] = 4;
               min[i] = 1;
               current[i] = 0;
            }
            boolean process = true;
            boolean imposible = false;
            long imposibleX = Math.abs(x)*2;
            long imposibleY = Math.abs(y)*2;
            long step1 = 1;
            for(int i = 31; i >= 0; i--) {
               step1 *= 2;  
               if(imposibleX < step1 && imposibleY < step1) {
                  break;
               }          
            }
            String answer = "";
            long step = step1/4;
            long fx = x;
            long fy = y;
            while(process)
            {
               if(Math.abs(fx) > Math.abs(fy)) {
                  if(fx > 0) {
                     answer = "E" + answer;
                     fx -= step;
                  }
                  else {
                     answer =  "W" + answer;
                     fx += step;                     
                  }
               }
               else {
                  if(fy > 0) {
                     answer = "N" + answer;
                     fy -= step;
                  }
                  else {
                     answer =  "S" + answer;
                     fy += step;                     
                  }
               }
               if(step <= 1) {
                  break;
               }
               step /= 2;
            }
            step = step1/2;
            if(fx == 0 && fy == 0){
               process = false;
            }
            else {
               fx = x;
               fy = y;
               answer = "";
            }
            while(process)
            {
               if(Math.abs(fx) > Math.abs(fy)) {
                  if(fx > 0) {
                     answer = "E" + answer;
                     fx -= step;
                  }
                  else {
                     answer =  "W" + answer;
                     fx += step;                     
                  }
               }
               else {
                  if(fy > 0) {
                     answer = "N" + answer;
                     fy -= step;
                  }
                  else {
                     answer =  "S" + answer;
                     fy += step;                     
                  }
               }
               if(step <= 1) {
                  break;
               }
               step /= 2;
            }
            step = step1;
            if(fx == 0 && fy == 0){
               process = false;
            }
            else {
               fx = x;
               fy = y;
               answer = "";
            }
            while(process)
            {
               if(Math.abs(fx) > Math.abs(fy)) {
                  if(fx > 0) {
                     answer = "E" + answer;
                     fx -= step;
                  }
                  else {
                     answer =  "W" + answer;
                     fx += step;                     
                  }
               }
               else {
                  if(fy > 0) {
                     answer = "N" + answer;
                     fy -= step;
                  }
                  else {
                     answer =  "S" + answer;
                     fy += step;                     
                  }
               }
               if(step <= 1) {
                  break;
               }
               step /= 2;
            }
            if(fx != 0 || fy != 0){
               imposible = true;
            }
            if(imposible) {
               answer = "IMPOSSIBLE";
            }
            System.out.println("Case #" + (t0 + 1) + ": " + answer);
            
         }
      }
	}
   private static int[] nextCombo(int[] current, int[] max, int[] min) {
      for(int i = current.length - 1; i >= 0; i--) {
         if(current[i] < max[i]) {
            current[i]++;
            break;
         }
         else {
            current[i] = min[i];
         }
      }
      return current;
   }
   private static boolean nextComboCheck(int[] current, int[] max) {
      for(int i = 0; i < current.length; i++) {
         if(current[i] < max[i]) {
            return true;
         }
      }
      return false;
   }
}