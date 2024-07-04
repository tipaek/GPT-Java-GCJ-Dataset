import java.util.*;
class jobs
{
    int s;
    int e;
    char p;
}
class Main
{
	public static void main(String[] args) {
		int t;
		Scanner sc = new Scanner(System.in);
		t=sc.nextInt();
		for(int i=0 ; i<t ; i++ )
		{
		    int n = sc.nextInt();
		    jobs job[] = new jobs[n];
		    for(int j=0;j<n;j++)
		    {
    		    job[j]=new jobs();
    		    job[j].s = sc.nextInt();
    		    job[j].e = sc.nextInt();
		    }
		    int je=0,ce=0,job_done=0,job_impossible=0;
		    for(int j=0;j<n;j++)
		    {
    		    if(job[j].s>=ce)
    		    {
    		        ce=job[j].e;
    		        job[j].p='c';
    		        job_done++;
    		        continue;
    		    }
    		    if(job[j].s>=je)
    		    {
    		        je=job[j].e;
    		        job[j].p='j';
    		        job_done++;
    		        continue;
    		    }
    		   job_impossible=1;
    		   break;
		    }
		    if(job_impossible == 1)
		    {
		        System.out.print("\nCase #"+(i+1)+": IMPOSSIBLE");
		    }
		    else
		    {
		        System.out.print("\nCase #"+(i+1)+": ");
		        for(int j=0;j<n;j++)
		        {
		            System.out.print (job[j].p);
		        }
		    }
		}
		
	}
}
