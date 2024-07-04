
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
            int n = sc.nextInt();
            for(int k = 1;k<=n;k++){
                int h = sc.nextInt();
                  int sx=0,ex=0,sy=0,ey=0,count=0;
                  String ans="";
                  for(int i=1;i<=h;i++){
                      int a = sc.nextInt();
                      int b = sc.nextInt();
                      if(sx==0&&ex==0){
                          sx = a;
                          ex = b;
                          ans = ans+"C";
                          count++;
                      }
                      else if(sy==0&&ey==0){
                          sy=a;
                          ey=b;
                          count++;
                          ans = ans+"J";
                      }
                      else if(a>=ex){
                          ex = b;
                          ans = ans+"C";
                          count++;
                      }
                      else if(a>=ey){
                          ey = b;
                          count++;
                          ans = ans+"J";
                      }
                     if(b<sx){
                         sx = a;
                         ans = ans+"C";
                         count++;
                     }
                     if(b<sy){
                         sy = a;
                         ans = ans+"J";
                         count++;
                     }
                  }
                  if(h==count){
                      System.out.println("Case #"+k+": "+ans);
                  }
                  else
                      System.out.println("Case #"+k+": IMPOSSIBLE");
            }
    }
}
