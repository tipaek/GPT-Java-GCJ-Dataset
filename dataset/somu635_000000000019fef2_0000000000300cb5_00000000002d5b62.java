
import java.util.ArrayList;
import java.util.Scanner;

class Solution {
  static String result;
  public static void main(String[] args) {
    // TODO Auto-generated method stub
    Scanner sc=new Scanner(System.in);
    int t=sc.nextInt();
    for(int c=1;c<=t;c++) {
      long dx=sc.nextLong(),dy=sc.nextLong();
      
      if(possible(0,0,dx,dy,new ArrayList<String>(),0)) {
          System.out.println("Case #"+c+": "+result);
      }else {
        System.out.println("Case #"+c+": IMPOSSIBLE");
      }
    }

  }
  static boolean possible(long x,long y,long dx,long dy,ArrayList<String> s,int c) {
    if(x==dx && y==dy) {
        String temp=String.join("", s);
        if(result==null)
          result=temp;
        else if(temp.length()<result.length())
          result=temp;
        return true;
    }
    boolean flag=false;
    if(Math.abs(x)<Math.abs(dx)) {
      s.add("E");
      if(possible(x+(int)Math.pow(2,c), y, dx, dy,s ,c+1))
        flag= true;
      s.remove(s.size()-1);
      
      s.add("W");
      if(possible(x-(int)Math.pow(2,c), y, dx, dy,s ,c+1))
        flag= true;
      s.remove(s.size()-1);
      
    }
    if(Math.abs(y)<Math.abs(dy)) {
      s.add("N");
      if(possible(x, y+(int)Math.pow(2,c), dx, dy,s ,c+1))
        flag= true;
      s.remove(s.size()-1);
      
      s.add("S");
      if(possible(x, y-(int)Math.pow(2,c), dx, dy,s ,c+1))
        flag= true;
      s.remove(s.size()-1);
    }
    return flag;  
  }

}
