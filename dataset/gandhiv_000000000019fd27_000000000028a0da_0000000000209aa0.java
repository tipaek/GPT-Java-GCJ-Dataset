import java.util.*;
public class Solution
{
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n1 = sc.nextInt();
		int i1;
		for(i1=1;i1<=n1;i1++){
		    int n = sc.nextInt();
		    int k = sc.nextInt();
		    int p = n+1,i,j;
		    List<Integer> li = new ArrayList<Integer>();
		    for(i=1;i<=n;i++){
		        int temp = p;
		        while(temp<=n){
		            li.add(temp);
		            temp++;
		        }
		        for(j=1;j<p;j++){
		            li.add(j);
		        }
		        p--;
		    }
		    i=1;
		    String s = "";
		    List<String> sli = new ArrayList<String>();
		    for(int x:li){
		       s+=x;
		       if(i%n==0){
		           sli.add(s);
		           s="";
		       }
		       i++;
		    }
		    String[] ar = sli.toArray(new String[0]);
		    ArrayList<ArrayList<String>> r = new ArrayList<ArrayList<String>>();
		    r = permute(ar);
		    boolean flag = false;
		    for(List<String> a:r){
		        i=j=0;
		        int trace = 0;
		        for(String b:a){
		            trace += Character.getNumericValue(b.charAt(j++));
		        }
		        if(trace == k){
		            flag = true;
		            break;
		        }
		        i++;
		    }
		    System.out.print("Case #"+i1+": ");
		    if(flag == true) {
		        System.out.println("POSSIBLE");
		        List<String> a = r.get(i);
		        for(String x:a){
		            for(i=0;i<n;i++){
		                System.out.print(x.charAt(i)+(i==n-1?"\n":" "));
		            }
		        }
		    }
		    else{
		        System.out.println("IMPOSSIBLE");
		    }
		}
	}
	public static ArrayList<ArrayList<String>> permute(String[] num) {
	    ArrayList<ArrayList<String>> result = new ArrayList<ArrayList<String>>();
	    result.add(new ArrayList<String>());
	    for (int i = 0; i < num.length; i++) {
		    ArrayList<ArrayList<String>> current = new ArrayList<ArrayList<String>>();
		    for (ArrayList<String> l : result) {
			    for (int j = 0; j < l.size()+1; j++) {
				    l.add(j, num[i]);
				    ArrayList<String> temp = new ArrayList<String>(l);
				    current.add(temp);
				    l.remove(j);
			    }
		    }
 
		    result = new ArrayList<ArrayList<String>>(current);
	    }
 
	    return result;
    }
}