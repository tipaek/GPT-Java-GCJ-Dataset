/*package whatever //do not write package name here */

import java.util.*;

class Solution {
	public static void main (String[] args) {

          Scanner s=new Scanner(System.in);
          int t=s.nextInt();
          int k=1;
          while(t-->0){
              String a=s.next();
              String b="";
              int c=0;
              for(int i=0;i<a.length();i++)
              {
                  String h=a.charAt(i)+"";
                  int d=Integer.parseInt(h);
                  if(d==c)
                  {
                      b+=a.charAt(i);
                  }else if(d>c){
                      for(int j=0;j<d-c;j++){
                          b+="(";
                      }
                      b+=a.charAt(i);
                  }else{
                      for(int j=0;j<c-d;j++)
                      b+=")";
                      b+=a.charAt(i);
                  }
                  c=d;
              }
              for(int i=0;i<c;i++)
                 b+=")";
              System.out.println("Case #"+k+": "+b);//tr+" "+r+" "+c);
              k++;
          }
          
	}
}