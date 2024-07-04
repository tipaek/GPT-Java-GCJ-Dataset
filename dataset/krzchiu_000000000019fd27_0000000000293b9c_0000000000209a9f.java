import java.util.*;
public class Solution{ 
  public static void main(String[] args)             {
    Scanner sc = new Scanner(System.in);
    int N = sc.nextInt();
    sc.nextLine();
    for(int qq = 1; qq <= N; qq++){
      String s = sc.nextLine();
      StringBuilder sb = new StringBuilder();
      boolean b = false;
      for(int i = 0; i < s.length(); i++){
      	if(!b && s.charAt(i)=='1') {
      		sb.append("(1");
      		b = true;
      	}
      	else if(b && s.charAt(i) == '0') {
      		sb.append(")0");
      		b = false;
      	}
      	else sb.append(s.charAt(i));
      }
      if(b)sb.append(")");
      
      System.out.println("Case #"+qq+": "+sb.toString());

	  }
	}
}