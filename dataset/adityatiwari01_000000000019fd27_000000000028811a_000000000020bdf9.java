import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		if(sc.hasNext()) {
			int T = sc.nextInt();
			for(int i=0;i<T;i++) {
				int N = sc.nextInt();
				int AT[] = new int[N];
				int ET[] = new int[N];
				int job[] = new int[N];
				boolean flag[] = new boolean[N];
				int index[] = new int[N]; 
				for(int j=0;j<N;j++) {
					index[j] = j;
					AT[j] = sc.nextInt();
					ET[j] = sc.nextInt();
					flag[j] = false;
				}
				sort(AT,ET,index);
				job[0] = 1;
				flag[0] = true;
				int cindex=0;
				int jindex=-1;
				for(int j=1;j<AT.length;j++) {
					if(AT[j]>=ET[cindex]) {
						job[j] = 1;
						flag[j] = true;
						cindex = j;
					}
					else if(jindex==-1||AT[j]>=ET[jindex]) {
						job[j] = 2;
						flag[j] = true;
						jindex = j;
					}
				}
				if(areAllTrue(flag)) {
					sort(index, job, AT);
					for(int j=0;j<job.length;j++) {
						if(job[j]==1)
							System.out.print("C");
						else
							System.out.print("J");
					}
					System.out.println();
				}else
					System.out.println("IMPOSSIBLE");
			}
		}
	}
	
	static boolean areAllTrue(boolean[] array)
	{
	    for(boolean b : array) if(!b) return false;
	    return true;
	}
	
	static void sort(int AT[], int ET[], int index[]) {
		int n = AT.length;  
        int temp = 0;  
         for(int i=0; i < n; i++){  
             for(int j=1; j < (n-i); j++){  
                    if(AT[j-1] > AT[j]){  
                            temp = AT[j-1];  
                            AT[j-1] = AT[j];  
                            AT[j] = temp;  
                            
                            temp = ET[j-1];  
                            ET[j-1] = ET[j];  
                            ET[j] = temp; 
                            
                            temp = index[j-1];  
                            index[j-1] = index[j];  
                            index[j] = temp; 
                    }  
                          
             }  
         }
	}

}
