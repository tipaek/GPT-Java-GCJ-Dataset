import java.util.Scanner;
class Solution{
public static void main(String args[]){
Scanner in = new Scanner(System.in);
int t=in.nextInt();
for(int t1=0;t1<t;t1++){
int n = in.nextInt();
int st[]=new int[n];
int et[]=new int[n];
int ind[]=new int[n];

char res[] = new char[n];
int c=0,J=0,i=0,j=0;
for(i=0;i<n;i++){
	st[i]=in.nextInt();
	et[i]=in.nextInt();
	ind[i]=i;
}
//Sorting
for(i=0;i<n;i++){
	for(j=0;j<(n-i-1);j++){
		if(st[j]>st[j+1]){
			int temp=st[j];
			st[j]=st[j+1];
			st[j+1]=temp;
			temp=et[j];
			et[j]=et[j+1];
			et[j+1]=temp;
			temp=ind[j];
			ind[j]=ind[j+1];
			ind[j+1]=temp;
		}
	}
}
//end of sorting
boolean imp=false;
for(i=0;i<n;i++){
	if(st[i]>=c){
		res[ind[i]]='C';
		c=et[i];
	}
	else if(st[i]>=J){
		res[ind[i]]='J';
		J=et[i];
	}
	else{
		imp=true;
		break;
	}
}
if(imp){
	System.out.println("Case #"+(t1+1)+": IMPOSSIBLE");
}	
else{
	String str="";
	for(i=0;i<n;i++){
		str=str+res[i];
	}
	System.out.println("Case #"+(t1+1)+": "+str);
}
}
}
}