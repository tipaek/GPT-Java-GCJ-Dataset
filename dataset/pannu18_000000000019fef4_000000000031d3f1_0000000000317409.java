//package code;

import java.util.Scanner;


public class Solution {

  public static void main(String[] args) {
 
  Scanner s=new Scanner(System.in);
  int t=s.nextInt();
  int q=1;
  while(t-->0){
    int x=s.nextInt();
    int y=s.nextInt();
    String a=s.next();
   // int a[]=new int[n];
    int ans=-1;
    int n=a.length();
    int d=0,e=0;
    if(x==0&&y==0)
    ans=0;
    if(ans<0){
    for(int i=0;i<n;i++){
    //  a[i]=s.nextInt();
      if(a.charAt(i)=='S')
      {
        y--;
      }
      else if(a.charAt(i)=='N'){
        y++;
      }else if(a.charAt(i)=='E'){
        x++;
      }else{
        x--;
      }
      //int r=(int)Math.sqrt(x*x+y*y);
     // double u=Math.sqrt(x*x+y*y);
     int r=Math.abs(x)+Math.abs(y);
      if(r<=i+1)
      {
        ans=i+1;
        break;
      }
      }}
      
   if(ans>-1)
    System.out.println("case: #"+q+": "+ans);
    else
    System.out.println("case: #"+q+": IMPOSSIBLE");
    q++;
  }
  //System.out.println(t);
  
  }
}
