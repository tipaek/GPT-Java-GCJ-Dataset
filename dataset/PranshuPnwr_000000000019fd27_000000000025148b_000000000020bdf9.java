import java.util.Arrays;
import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scn=new Scanner(System.in);
		int t =scn.nextInt();
		int k=1;
		while(t-->0){
			int n=scn.nextInt();
			pair []p =new pair[n];
			int [] a= new int[n];
		 int [][]arr =new int[n][2];
			for(int i=0;i<n;i++){
				arr[i][0]=scn.nextInt();
				arr[i][1]=scn.nextInt();
				p[i]=new pair(arr[i][0],i);
				a[i]=arr[i][1];
			}
			Arrays.sort(p);
			Arrays.sort(a);
			int i=1;
			int j=0;
			int count=0;
			boolean flag=false;
			char [] c=new char[n];
			c[p[0].idx]='C';
			boolean w=true;
			int e=arr[p[0].idx][1];
			while(i<n||j<n){
			//	System.out.println(count);
				
				if(count>=2){
					flag=true;
					break;
				}
				if(i<n &&p[i].val<a[j]){
					if(p[i].val>=e){
						c[p[i].idx]='C';
						e=arr[p[i].idx][1];
					}else{
						c[p[i].idx]='J';
					}
					count++;
					i++;
				}else{
					count--;
					j++;
				}
			}
			if(count>0){
				System.out.println("Case #"+k+": "+"IMPOSSIBLE");
		     	  
			}else{
				StringBuilder sb=new StringBuilder();
				for( i=0;i<n;i++){
					sb.append(c[i]);
				}
				System.out.println("Case #"+k+": "+sb);
		     	  
			}
			k++;
		  
		}

	}
	public static class pair implements Comparable<pair>{
		int val;
		int idx;
		public pair(int val ,int idx){
			this.val=val;
			this.idx=idx;
		}
		public int compareTo(pair o){
			return this.val-o.val;
		}
	}

}