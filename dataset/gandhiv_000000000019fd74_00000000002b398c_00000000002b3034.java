import java.util.*;
public class Solution
{
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n1,i1;
		n1 = sc.nextInt();
		for(i1=1;i1<=n1;i1++){
		    int n = sc.nextInt();
		    List<String> li = new ArrayList<String>();
		    String st = "";
		    int i;
		    for(i=0;i<n;i++){
		        st = sc.next();
		        st = st.substring(1);
		        li.add(st);
		    }
		    Collections.sort(li);
		    st = li.get(0);
		    String st1 = "";
		    boolean f = true;
		    for(i=1;i<li.size();i++){
		        if(!st.contains(li.get(i)))
		            f = false;
		    }
		    System.out.print("Case #"+i1+": ");
		    if(f == true)
		        System.out.println(st);
		    else    System.out.println("*");
		}
	}
}
