import java.util.*;
import java.io.*;

public class Solution {

   public static void main(String[] args) throws IOException {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      StringTokenizer st = new StringTokenizer(br.readLine());
      int T = Integer.parseInt(st.nextToken());
      int B = Integer.parseInt(st.nextToken());
      for (int i = 1; i <= T; i++) {
         String answer = "";
         for (int j = 1; j <= B; j++) {
            System.out.println(j);
            int n = Integer.parseInt(br.readLine());
            answer += n;
         }   
         System.out.println(answer);
         char result = br.readLine().charAt(0);
         if (result == 'Y')
            continue;
         else
            System.exit(0);
      
      }  
   
   }



}