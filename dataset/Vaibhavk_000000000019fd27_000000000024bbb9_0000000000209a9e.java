import java.util.*;
import java.io.*;
public class Solution{
  public static void main(String args[]) {
    Scanner input = new Scanner(System.in);
    int T = input.nextInt();
    int B=input.nextInt();
    int count=0,cnt=0;
    for(int j=0;j<T;j++){
    String bt="";
    for (int ks = 1; ks <= B; ks++) {
      {System.out.println(ks);
        String ch=input.next();
      if(ch.equals("N")){
          break;
      }else{bt+=ch;}
    }
    }
    System.out.println(bt);
    String rs=input.next();
    if(rs.equals("Y")){continue;
    }
    
        
    }
    
  }
}
