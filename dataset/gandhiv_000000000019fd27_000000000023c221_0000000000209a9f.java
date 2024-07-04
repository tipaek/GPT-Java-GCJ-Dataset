import java.util.*;
public class Solution
{
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n1 = sc.nextInt();
		int i1;
		for(i1=1;i1<=n1;i1++){
		    String s = sc.next();
		    int i;
		    List<Character> li = new ArrayList<Character>();
		    boolean f = true;
		    for(i=0;i<s.length();i++){
		        if(s.charAt(i)=='1' && f==true){
		            li.add('(');
		            li.add(s.charAt(i));
		            f=false;
		        }
		        else if(s.charAt(i)=='0' && f==false){
		            li.add(')');
		            li.add(s.charAt(i));
		            f=true;
		        }
		        else    li.add(s.charAt(i));
		    }
		    if(f==false)
		        li.add(')');
		    System.out.print("Case #"+i1+": ");
		    for(char x:li){
		        System.out.print(x);
		    }
		    System.out.println();
		}
	}
}
