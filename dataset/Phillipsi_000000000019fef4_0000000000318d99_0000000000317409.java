import java.util.*;
import java.io.*;
public class Solution {
    public static void main(String[] args) {
        try{
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            StringTokenizer st = new StringTokenizer(br.readLine());
            int t = Integer.parseInt(st.nextToken());
            for(int i = 1; i<=t; i++){
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                String route = st.nextToken();
                if (x ==0 && y == 0){
                  System.out.println("Case #" + i + ": " + 0);
                  
                }
                boolean notImpossible = false;
                for(int j = 0; j<route.length(); j++){
                  if(route.charAt(j) == 'E'){
                     x++;
                  }else if(route.charAt(j) == 'W'){
                     x--;
                  }else if(route.charAt(j) == 'N'){
                     y++;
                  }else if(route.charAt(j) == 'S'){
                     y--;
                  }
                  if(Math.abs(x)+Math.abs(y) <= j+1){
                     System.out.println("Case #" + i + ": " + (j+1));
                     notImpossible = true;
                     break;
                  }
                }
                if(!notImpossible)
                  System.out.println("Case #" + i + ": IMPOSSIBLE");   
            }
        }catch(IOException e){
            return;
        }
    }
    
}