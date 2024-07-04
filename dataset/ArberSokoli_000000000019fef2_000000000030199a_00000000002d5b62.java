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
            long imposibleX = Math.abs(x)*4;
            long imposibleY = Math.abs(y)*4;
            while(process)
            {
               long step = 1;
               long fx = 0;
               long fy = 0;
               if(fx == x && fy == y) { 
                  break;
               }
               for(int i = 31; i >= 0; i--) {
                  if(current[i] == 0) {
                     break;
                  }      
                  if(current[i] == 1) {
                     fx -= step;
                  }      
                  if(current[i] == 2) {
                     fy -= step;
                  }      
                  if(current[i] == 3) {
                     fx += step;
                  }      
                  if(current[i] == 4) {
                     fy += step;
                  }
                  step *= 2;            
               }
               if(fx == x && fy == y) { 
                  //process = false;
                  break;
               }
               if(imposibleX < step && imposibleY < step) {
                  imposible = true;
                  break;
               }
               nextCombo(current, max, min);
            }
            String answer = "";
            for(int i = 31; i >= 0; i--) {
               if(current[i] != 0) {
                  
                  if(current[i] == 1) {
                     answer +=  "W";
                  }      
                  if(current[i] == 2) {
                     answer +=  "S";
                  }      
                  if(current[i] == 3) {
                     answer +=  "E";
                  }      
                  if(current[i] == 4) {
                     answer +=  "N";
                  }
               }     
            }
            if(imposible) {
               answer = "IMPOSSIBLE";
            }
            System.out.println("Case #" + (t0 + 1) + ":" + answer);
            
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