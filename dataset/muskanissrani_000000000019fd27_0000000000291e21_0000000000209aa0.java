import java.util.*;
import java.io.*;
public class Solution {
  public static void main(String[] args) {
        Scanner s= new Scanner(System.in);
        int n=s.nextInt();
        for(int i=0;i<n;i++){
          int w=s.nextInt(),k=0,p=0;
          List<Integer> mylist = new ArrayList<>();  
          int q=s.nextInt();
          if(q%w==0){
              System.out.println("Case #"+(i+1)+": POSSIBLE");
              k=q/w;
              while(k>=1){
                  mylist.add(k--);
                  p++;
              }k=w;
               while(p<w){
                  mylist.add(k--);p++;
              }
              p=w;
              while(p!=0){
        for(int t=0;t<w;t++)
        {
            System.out.print(mylist.get(t)+" ");
        }
        System.out.println();
        Collections.rotate(mylist, 1); 
        p--;}
        }
          else
          System.out.println("Case #"+(i+1)+": IMPOSSIBLE");
        }
  }
}