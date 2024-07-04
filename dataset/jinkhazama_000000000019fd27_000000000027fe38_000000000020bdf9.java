import java.util.*;
class Solution {
	public static void main (String[] args) {
	    Scanner sc=new Scanner(System.in);
		int t=sc.nextInt();
		for(int q=1;q<=t;q++){
		   int n=sc.nextInt();
		   int srt[]=new int[n];
		   int end[]=new int[n];
		   for(int i=0;i<n;i++){
		       srt[i]=sc.nextInt();
		       end[i]=sc.nextInt();
		       
		   }
		   for(int i=0;i<n-1;i++){
		       for(int j=0;j<n-1-i;j++){
		           if(srt[j]>srt[j+1]){
		               int t1=srt[j];
		               srt[j]=srt[j+1];
		               srt[j+1]=t1;
		               
		               int t2=end[j];
		               end[j]=end[j+1];
		               end[j+1]=t2;
		           }
		       }
		   }
		   int curr=0;//ie c=0,j=1
		   String res="";
		   for(int i=0;i<n;i++){
		       int s=srt[i],e=end[i];
		       res+= (curr==0) ? 'C' : 'J';
		       if(i+1<n && srt[i+1]>s && srt[i+1]<e){
		           curr= (curr==0) ? 1 : 0;
		       }
		       if(i+2<n && srt[i+2]>s && srt[i+2]<e && srt[i+2]>srt[i+1] && srt[i+2]<end[i+1]){
		           res="IMPOSSIBLE";
		           break;
		       }
		   }
		    System.out.println("Case #"+q+":"+" "+res);
		}
	}
}