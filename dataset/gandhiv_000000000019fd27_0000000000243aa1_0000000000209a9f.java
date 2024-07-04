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
		    char c = '0';
		    for(i=0;i<s.length();i++){
		        if(s.charAt(i)!=c ){
		            if(c!='0')
		                li.add(')');
		            c = s.charAt(i);
		            li.add('(');
		        }
		        li.add(c);
		    }
		    if(c!='0')
		        li.add(')');
		    System.out.print("Case #"+i1+": ");
		    for(char x:li){
		        System.out.print(x);
		    }
		    System.out.println();
		}
	}
}
