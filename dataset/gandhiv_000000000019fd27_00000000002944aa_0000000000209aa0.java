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
		    ArrayList<ArrayList<String>> r1 = new ArrayList<ArrayList<String>>();
		    ArrayList<ArrayList<String>> result = new ArrayList<ArrayList<String>>();
		    r = permute(ar);
		    for(List<String> a:r){
		        i=j=0;
		        int trace = 0;
		        for(String b:a){
		            trace += Character.getNumericValue(b.charAt(j++));
		        }
		        if(trace == k){
		            r1.add(new ArrayList(a));
		        }
		        i++;
		    }
		    for(List<String> a:r1){
		        i=j=0;
		        List<Integer> lits = new ArrayList<Integer>();
		        List<Integer> lits1;
		        for(String b:a){
		            lits.add(Character.getNumericValue(b.charAt(j++)));
		        }
		        lits1 = new ArrayList<Integer>(lits);
		        Collections.sort(lits, Collections.reverseOrder());
		        boolean flag = true;
		        for(int q=0;q<lits.size() && flag==true;q++){
		            if(lits.get(q)!=lits1.get(q))
		                flag = false;
		        }
		        if(flag==true){
		            result.add(new ArrayList(a));
		        }
		    }
		    System.out.print("Case #"+i1+": ");
		    if(result.size()>0) {
		        System.out.println("POSSIBLE");
		        List<String> a = result.get(result.size()-1);
		        for(j=a.size()-1;j>=0;j--){
		            String x = a.get(j);
		            for(i=n-1;i>=0;i--){
		                System.out.print(x.charAt(i)+(i==0?"\n":" "));
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