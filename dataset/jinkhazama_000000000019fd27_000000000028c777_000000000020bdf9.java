/*package whatever //do not write package name here */


import java.util.*;
class Solution {
	public static void main (String[] args) {
	    Scanner sc=new Scanner(System.in);
		int t=sc.nextInt();
		for(int q=1;q<=t;q++){
		   int n=sc.nextInt();
		   int srt[]=new int[n];
		   int end[]=new int[n];
		   int index[]=new int[n];
		   int g=0;
		   char car[]=new char[n];
		   for(int i=0;i<n;i++){
		       srt[i]=sc.nextInt();
		       end[i]=sc.nextInt();
		       index[i]=g++;
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
		               
		               int t3=index[j];
		               index[j]=index[j+1];
		               index[j+1]=t3;
		           }
		       }
		   }
		   int curr=0;//ie c=0,j=1
		   String res="";
		   int flag=0;
		   int c_end=0,j_end=0;
		   for(int i=0;i<n;i++){
		       int s=srt[i],e=end[i];
		       int zep=index[i];
		       //System.out.println(zep);
		       //car[zep]=
		       char ch1;
		       if(curr==0){
		           if(s>=c_end){
		               ch1='C';
		               c_end=e;
		           }
		           else{
		               if(s<j_end)
		                  flag=1;
		               ch1='J';
		               j_end=e;
		           }
		       }
		       else{
		           if(s>=j_end){
		               ch1='J';
		               j_end=e;
		           }
		           else{
		               if(s<c_end)
		                  flag=1;
		               ch1='C';
		               c_end=e;
		           }
		       }
		       //System.out.println(ch1);
		       car[zep]=ch1;
		      // car[zep]=(curr==0) ? 'C' : 'J';
		      // if(i+1<n && srt[i+1]==s )
		          //  curr= (curr==0) ? 1 : 0;
		       if(i+1<n && srt[i+1]>=s && srt[i+1]<e){
		           curr= (curr==0) ? 1 : 0;
		       }
		       if(i+2<n && srt[i+2]>s && srt[i+2]<e && srt[i+2]>srt[i+1] && srt[i+2]<end[i+1]){
		           //res="IMPOSSIBLE";
		           flag=1;
		           break;
		       }
		   }
		   if(flag==1){
		       res="IMPOSSIBLE";
		   }
		   else{
		   for(int i=0;i<n;i++){
		       res=res+car[i];
		   }}
		    System.out.println("Case #"+q+":"+" "+res);
		}
	}
}