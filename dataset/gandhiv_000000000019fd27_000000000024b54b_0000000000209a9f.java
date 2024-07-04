import java.util.*;
public class Solution
{
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n1 = sc.nextInt();
		int i1;
		for(i1=1;i1<=n1;i1++){
		    String s = sc.next();
		    int i,j,num;
		    boolean flag = true;
		    char c = s.charAt(0);
		    List<Character> li = new ArrayList<Character>();
		    for(i=0;i<s.length();i++){
		        num = Character.getNumericValue(c);
		        if(flag==true && c==s.charAt(i)){
		            for(j=0;j<num;j++){
		                li.add('(');
		            }
		            li.add(c);
		            flag = false;
		        }
		        else if(flag==false && c==s.charAt(i)){
		            li.add(c);
		        }
		        if(c!=s.charAt(i)){
		            for(j=0;j<num;j++){
		                li.add(')');
		            }
		            c = s.charAt(i);
		            num = Character.getNumericValue(c);
		            for(j=0;j<num;j++){
		                li.add('(');
		            }
		            li.add(c);
		        }
		        if(i==s.length()-1){
		            for(j=0;j<num;j++){
		                li.add(')');
		            }
		        }
		    }
		    int n = li.size();
		    char[] ar = new char[n];
		    i=0;
		    for(char x:li){
		        ar[i++]=x;
		    }
		    for(i=1;i<n;i++){
		        if(ar[i]=='(' && ar[i-1]==')')
		            ar[i] = ar[i-1] = 'x';
		    }
		    System.out.print("Case #"+i1+": ");
		    for(i=0;i<n;i++){
		        if(ar[i]!='x')
		        System.out.print(ar[i]);
		    }
		    System.out.println();
		}
	}
}