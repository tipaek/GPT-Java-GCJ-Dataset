import java.util.*;

class Solution {
	public static void main (String[] args) {
		Scanner sc=new Scanner(System.in);
		int t=sc.nextInt();
		int l=1;
		while(l<=t)
		{
		    String s=sc.next();
		  String temp="";
		  int j=0;
		  for(int i=0;i<s.length();i++)
		  {
		      if(s.charAt(i)=='1')
		      {
		          temp+="(";
		          while(i<s.length()&&s.charAt(i)=='1')
		          {
		              temp+=Character.toString(s.charAt(i));
		              i++;
		          }
		          temp+=")";
		          i--;
		      }
		      else
		      temp+=Character.toString(s.charAt(i));
		  }
		    System.out.println("Case #"+l+": "+temp);
		    l++;
		}
	}
}