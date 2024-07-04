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
    		        job[j].p='C';
    		        job_done++;
    		        continue;
    		    }
    		    if(job[j].s>=je)
    		    {
    		        je=job[j].e;
    		        job[j].p='J';
    		        job_done++;
    		        continue;
    		    }
    		    //searching empty time for j
    		    int flag = 0;
    		    for(int k=0;k<j;k++)
    		    {
    		        int js=0,jf;
    		        if(job[k].p!='J')continue;
    		        jf=job[k].s;
    		        if((job[j].s>=js)&&(job[j].e<=jf))
    		        {
    		            job_done++;
    		            job[j].p='J';
    		            flag=1;
    		            break;
    		        }
    		        js=job[k].e;
    		    }
    		    if(flag == 1)continue;
    		    //searching empty time for c
    		    flag = 0;
    		    for(int k=0;k<j;k++)
    		    {
    		        int cs=0,cf;
    		        if(job[k].p!='C')continue;
    		        cf=job[k].s;
    		        if((job[j].s>=cs)&&(job[j].e<=cf))
    		        {
    		            job_done++;
    		            job[j].p='C';
    		            flag=1;
    		            break;
    		        }
    		        cs=job[k].e;
    		    }
    		    if(flag == 1)continue;
    		    
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
		            String s = "";
		            s = s+ job[j].p;
		            System.out.print(s);
		        }
		    }
		}
		
	}
}