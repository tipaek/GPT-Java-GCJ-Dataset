import java.util.*;
public class Solution{
	
public static void main(String args[])
{
	Scanner sc=new Scanner(System.in);

	int t=Integer.parseInt(sc.nextLine());
	int tt=1;
	while(t-->0){
int flag=0;

int n=Integer.parseInt(sc.nextLine());

ArrayList<Pair>arr=new ArrayList<>();
	for(int i=0;i<n;i++)
		{String h[]=sc.nextLine().split(" ");
			arr.add(new Pair(Integer.parseInt(h[0]),1,i));
			arr.add(new Pair(Integer.parseInt(h[1]),-1,i));
		}
	Collections.sort(arr,(a,b)->(a.a-b.a==0?a.b-b.b:a.a-b.a));
	int cc=0;
	String ans[]=new String[n];
	int james=0;
	int cam=0;
	for(int i=0;i<arr.size();i++)
	{
		cc+=arr.get(i).b;
		if(cc>2){flag=1;break;}
		if(arr.get(i).b==1){if(james==0){ans[arr.get(i).c]="J";james=1;}
		else{ans[arr.get(i).c]="C";cam=1;}
	}
	else 
	{
		if(ans[arr.get(i).c].equals("J")){james=0;}
		else{cam=1;}
	}
	}
	if(flag==1){System.out.println("Case #"+tt+": Impossible");}
	else{
		StringBuilder sb=new StringBuilder();
		for(int i=0;i<n;i++){sb.append(ans[i]);}
		System.out.println("Case #"+tt+": "+sb.toString());}

	tt+=1;
}
}

}
class Pair{int a; int b;int c;
Pair(int d,int e,int f){a=d;b=e;c=f;}}