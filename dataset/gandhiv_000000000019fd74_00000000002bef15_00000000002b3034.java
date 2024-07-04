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
		    TreeSet<String> ts = new TreeSet<>(li);
		    li = new ArrayList<>(ts);
		    String[] arr = new String[li.size()];
		    i=0;
		    for(String x:li){
		        arr[i++]=x;
		    }
		    for (i=1; i<li.size(); i++) 
            { 
                String temp = arr[i]; 
                int j = i - 1; 
                while (j >= 0 && temp.length() < arr[j].length()) 
                { 
                    arr[j+1] = arr[j]; 
                    j--; 
                } 
                arr[j+1] = temp; 
            }
		    boolean f = true;
		    for(i=1;i<li.size() && f == true;i++){
		        if(!arr[i].contains(arr[i-1]))
		            f = false;
		    }
		    System.out.print("Case #"+i1+": ");
		    if(f == true)
		        System.out.println(arr[i-1]);
		    else    System.out.println("*");
		}
	}
}