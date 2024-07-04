import java.util.*;

/* Name of the class has to be "Main" only if the class is public. */
 class Solution {

	private static class pair implements Comparable<pair> {
		int st, en;
		

		public pair(int i, int j) {

			st = i;
			en = j;
			
		}

		@Override
		public int compareTo(pair o) {
			if(st==o.st) {
				return en-o.en;
			}
			
			return st-o.st;
		}
	}
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int t = s.nextInt();
		int p=1;
		while(p<=t){
		    int n=s.nextInt();
		    pair[] a=new pair[n];
		    HashMap<pair,Integer> h=new HashMap<>();
		    for(int i=0;i<n;i++){
		        
		        a[i]=new pair(s.nextInt(),s.nextInt());
		        h.put(a[i],i);
		    }
		    Arrays.sort(a);
		    int d1=-1,d2=-1,flag=0;
		    char ans[]=new char[n];
		    for(int i=0;i<n;i++){
		        if(d1<=a[i].st){
		            d1=a[i].en;
		            ans[h.get(a[i])]='C';
		        }
		        else if(d2<=a[i].st){
		            d2=a[i].en;
		            ans[h.get(a[i])]='J';
		        }
		        else{
		            flag=1;
		            break;
		        }
		    }
		    if(flag==1)
		    System.out.println("Case #"+p+": IMPOSSIBLE");
		    else{
		        System.out.print("Case #"+p+": ");
		        for(int i=0;i<n;i++)
		        System.out.print(ans[i]);
		        System.out.println();
		    }
		    p++;
		}
	}
 }