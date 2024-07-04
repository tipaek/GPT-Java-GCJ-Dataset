import java.util.*;
class Solution{
	/*static int assigned[]=new int[100];
	static int start_job[]=new int[100];
	static int end_job[]=new int[100];*/
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int no_of_prob=sc.nextInt();
		for(int a=0;a<no_of_prob;a++){
			int flag=0;
			int no_of_jobs = sc.nextInt();
			int assigned[]=new int[100];
			int start_job[]=new int[100];
			int end_job[]=new int[100];
			for(int i=0;i<no_of_jobs;i++){
				start_job[i]=sc.nextInt();
				end_job[i]=sc.nextInt();
			}
			assigned[0]=1;//1=c 2=j
			for(int i=1;i<no_of_jobs;i++){
				if(assigned[i-1]==1 && end_job[i-1]>start_job[i] && is_free(2,i,start_job,end_job,assigned))
					assigned[i]=2;
				else if(assigned[i-1]==2 && end_job[i-1]>start_job[i] && is_free(1,i,start_job,end_job,assigned))
					assigned[i]=1;
				else if(assigned[i-1]==1 && end_job[i-1]<=start_job[i] && is_free(1,i,start_job,end_job,assigned))
					assigned[i]=1;
				else if(assigned[i-1]==2 && end_job[i-1]<=start_job[i] && is_free(2,i,start_job,end_job,assigned))
					assigned[i]=2;
				else{
					flag=100;
					break;
				}
			}
			if(flag==100)
				System.out.println("IMPOSSIBLE");
			else
				for(int i=0;i<no_of_jobs;i++)
					if(assigned[i]==1)
						System.out.println("C");
					else
						System.out.println("J");
		}
	}
	static boolean is_free(int to_whom_assigned, int ite,int [] start_job, int [] end_job, int[] assigned){
		int index=-1;
		for(int i=0;i<ite;i++){
			if(assigned[i]==to_whom_assigned)
				index=i;
		}
		if(index!=-1)
			if(end_job[index]<=start_job[ite])
				return true;
			else
				return false;
		return true;
	}
}