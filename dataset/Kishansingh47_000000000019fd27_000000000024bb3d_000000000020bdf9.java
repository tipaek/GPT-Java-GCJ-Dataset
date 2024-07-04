import java.util.*;
import java.lang.*;
import java.io.*;

class Solution
{
	static int findImpossible(int arr[], int dep[], int n) 
	{ 
		Arrays.sort(arr); 
		Arrays.sort(dep); 
		int plat_needed = 1, result = 1; 
		int i = 1, j = 0; 
		while (i < n && j < n) 
		{ 
			if (arr[i] < dep[j]) 
			{ 
				plat_needed++; 
				i++; 
				if (plat_needed > result) {
					result = plat_needed;
				}
				else{
				}
			} 
			else
			{ 
				plat_needed--; 
				j++; 
			} 
		} 
		return result; 
	} 
	public static void main (String[] args) throws java.lang.Exception
	{
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		StringBuilder sb = new StringBuilder();
		int cse = 1;
		while(t-->0){
			int n = sc.nextInt();
			int s[] = new int[n];
			int e[] = new int[n];
			for(int i=0;i<n;i++) {
				s[i]=sc.nextInt();
				e[i]=sc.nextInt();
			}
			int s1[] = s.clone();
			int e1[] = e.clone();
			char op[] = new char[n];
			Arrays.fill(op,'A');
			op[0]='C';
			HashMap<Integer, ArrayList<Integer>> hmap= new HashMap<Integer, ArrayList<Integer>>();
			if(findImpossible(s1,e1,n)>2)
				System.out.println("Case #"+cse+": IMPOSSIBLE");
			else {
				for(int i=0;i<n;i++) {
					ArrayList<Integer> al = new ArrayList<Integer>();
					for(int j=0;j<n;j++) {
						if(s[i]<e[j] && ((s[j]<e[i]) & j!=i)) {
							al.add(j);
						}
					}
					hmap.put(i, al);
				}
				for(int i=0;i<n;i++) {
					ArrayList<Integer> temp = new ArrayList<Integer>();
					temp = hmap.get(i);
					for(int j=0;j<temp.size();j++) {
						if(op[i]=='C' && op[temp.get(j)]=='A')
							op[temp.get(j)]='J';
						else if(op[i]=='F' && op[temp.get(j)]=='A')
							op[temp.get(j)]='C';
					}
				}
				for(int i=0;i<n;i++) {
					if(op[i]=='A')
						op[i]='C';
				}
				System.out.println("Case #"+cse+": "+String.valueOf(op));
			}
			cse++;
		}
		sc.close();
	}
}