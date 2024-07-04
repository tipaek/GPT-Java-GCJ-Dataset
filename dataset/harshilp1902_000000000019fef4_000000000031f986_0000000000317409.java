import java.util.*;
import java.io.*;
public class Solution {
  public static void main(String[] args) {
    Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    int  t=sc.nextInt();
        int test=1;
        while(t>0){
            int x,y;
            x=sc.nextInt();
            y=sc.nextInt();
            String s=sc.next();
            int c=0;
            boolean fin=false;
            for(int i=0;i<s.length();i++){
                if(s.charAt(i) == 'S')
                    y--;
                else if(s.charAt(i) == 'N')
                    y++; 
                else if(s.charAt(i) == 'W')
                    x--;
                else if(s.charAt(i) == 'E')
                    x++;
                 c++;
               
                 if(Math.abs(x)+Math.abs(y) <= c ){
                     fin=true;
                     break;
                 }      

            }
            if(fin){
                System.out.println("Case #"+ test + ": " + c);
            }
            else{
                System.out.println("Case #"+ test + ": " + "IMPOSSIBLE");
            }
            test++;
            t--;
        }
  }
}