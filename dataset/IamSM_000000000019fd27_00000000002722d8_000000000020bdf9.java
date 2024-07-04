import java.util.*;
class Solution{
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int no_of_prob=sc.nextInt();
		int x=0;
		for(int a=0;a<no_of_prob;a++){
			int flag=0;
			int no_of_jobs = sc.nextInt();
			int assigned[]=new int[no_of_jobs];
			int start_job[]=new int[no_of_jobs];
			int end_job[]=new int[no_of_jobs];
			for(int i=0;i<no_of_jobs;i++){
				start_job[i]=sc.nextInt();
				end_job[i]=sc.nextInt();
			}

			/*for sorting the list*/
			HashMap<Integer,Integer> h=new HashMap<>();
			for(int i=0;i<no_of_jobs;i++)
				h.put(start_job[i],end_job[i]);
			int start_clone[] = new int[no_of_jobs];
			for(int i=0;i<no_of_jobs;i++)
				start_clone[i]=start_job[i];
			Arrays.sort(start_job);
			for(int i=0;i<no_of_jobs;i++){
				end_job[i]=h.get(start_job[i]);
			}
			/*sorting completed*/

			assigned[0]=1;//1=c 2=j
			for(int i=1;i<no_of_jobs;i++){
				for(int j=i-1;j>=0;j--){
					if(is_free(2,i,start_job,end_job,assigned))
						assigned[i]=2;
					else if(is_free(1,i,start_job,end_job,assigned))
						assigned[i]=1;
					/*else if(is_free(1,i,start_job,end_job,assigned))
						assigned[i]=1;
					else if(is_free(2,i,start_job,end_job,assigned))
						assigned[i]=2;*/
					else{
						flag=100;
						break;
					}
					/*if(assigned[i-1]==1 && end_job[i-1]>start_job[i] && is_free(2,i,start_job,end_job,assigned))
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
					}*/
				}
			}
			for(int i=0;i<no_of_jobs;i++)
				if(start_job[i]==start_clone[x]){
					System.out.print("Case #"+(a+1)+": ");
					x++;
				}
			x=0;
			if(flag==100)
				System.out.print("IMPOSSIBLE");
			else{
				for(int i=0;i<no_of_jobs;i++)
					if(assigned[i]==1)
						System.out.print("C");
					else
						System.out.print("J");
			}
			System.out.println();
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