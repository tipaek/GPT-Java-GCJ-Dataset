import java.util.*;
class Myclass implements Comparable<Myclass>{
	int x,y,index;
	Myclass(int x,int y,int i){
		this.x=x;
		this.y=y;
		index=i;
	}
	public int compareTo(Myclass p){
		if(x-p.x!=0)
			return x-p.x;
		else
			return y-p.y;
	}
}
public class Solution
{
    public static void main(String[] args)
    {
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        for(int k=1;k<=t;k++)
        {
            int n=sc.nextInt(),a=0,b=0,flag=0;
            Myclass timings[]=new Myclass[n];
            for(int i=0;i<n;i++)
            {
                int s=sc.nextInt(),e=sc.nextInt();
                timings[i]=new Myclass(s,e,i);
            }
            char ans[]=new char[n];
            Arrays.sort(timings);
            a=timings[0].y;
            ans[timings[0].index]='J';
            for(int i=1;i<n;i++)
            {
                int z=timings[i].index;
                if(timings[i].x>=a){
                    a=timings[i].y;
                    ans[z]='J';
                }
                else if(timings[i].x>=b){
                    b=timings[i].y;
                    ans[z]='C';
                }
                else{
                    flag=1;
                    break;
                }
            }
            System.out.print("Case #"+k+": ");
            if(flag==1)
                System.out.print("IMPOSSIBLE");
            else
            {
                int temp=ans.length;
                for(int i=0;i<temp;i++)
                {
                    System.out.print(ans[i]);
                }
            }
            System.out.println();
        }
    }
}