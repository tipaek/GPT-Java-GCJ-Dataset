import java.util.Scanner;
class Solution
{
    public static void main(String args[])
    {
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        for(int i=0;i<t;i++)
        {
            int n=sc.nextInt();
            int s[]=new int[n];
            int e[]=new int[n];
            String sa=new String();
            for(int j=0;j<n;j++)
            {
                s[j]=sc.nextInt();
                e[j]=sc.nextInt();
            }
	  
	    for(int l=0;l<n;l++)
	    {
		int min_ind=l;
		for(int m=l+1;m<n;m++)
		{
			if(s[m]<s[min_ind])
				min_ind=m;
		}
		int temp=s[l];
		s[l]=s[min_ind];
		s[min_ind]=temp;
		temp=e[l];
		e[l]=e[min_ind];
		e[min_ind]=temp;
	    }
			
            int flgc=0,flgj=0,c=0,dcc=0,dcj=0,uns=0;
            for(int j=0;j<=1440;j++)
            {
		
		if(j==e[dcc])
                flgc=0;
                if(j==e[dcj])
                flgj=0;
		if(c<n)
		{
                if(j==s[c])
                {
                    if(flgc==0)
                    {
                        flgc=1;
                        dcc=c;
                        sa+="C";
                        if(c<n)
                        c++;
                    }
                    else if(flgj==0)
                    {
                        flgj=1;
                        dcj=c;
                        sa+="J";
                        if(c<n)
                        c++;
                    }
                    else
                    {
                        System.out.println("Case #"+(i+1)+": IMPOSSIBLE");
                        break;
                    }
                }
		}

                
                if(flgc==0&&flgj==0&&c==n)
                {
                    System.out.println("Case #"+(i+1)+": "+sa);
                    break;
                }
            }
            
        }
    }
}