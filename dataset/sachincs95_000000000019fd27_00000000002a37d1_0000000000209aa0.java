


import java.io.*;


class Solution
{
	static int flag = 0;
	public static void permute(int ar[], int k, int ksum, int t){
		if(flag == 1){
			return;
		}
		if(k==ar.length){
			int sum = 0;
			for (int i = 0; i < ar.length; i++) 
            {
                sum += (ar[i]+i)%(ar.length) + 1;
            }
            
            // for (int i = 0; i < ar.length; i++) 
            // {
            //     System.out.print(" [" + ar[i] + "] ");
            // }
            // System.out.println();
            // System.out.println("Sum = "+sum);
            // System.out.println("Ksum = "+ksum);
            if(ksum==sum){
            	System.out.println("Case #"+t+": POSSIBLE");
            	for(int i=0;i<ar.length;i++){
            		int j=0;
            		for(j=0;j<ar.length-1;j++){
            			System.out.print(((ar[i]+j)%(ar.length) + 1)+" ");
            		}
            		System.out.print(((ar[i]+j)%(ar.length) + 1));
            		System.out.println();
            	}
            	flag = 1;
            }
           
		}
		else{
			for(int i=k; i<ar.length;i++){
				int temp = ar[k];
				ar[k] = ar[i];
				ar[i] = temp;
				
				permute(ar,k+1,ksum,t);
				
				temp = ar[k];
				ar[k] = ar[i];
				ar[i] = temp;
			}
		}
	}
	
	public static void main (String[] args) throws java.lang.Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int test = Integer.parseInt(br.readLine());
		
		for(int t=1;t<=test;t++){
			flag = 0;
			String s[] = br.readLine().split(" ");
			int n=Integer.parseInt(s[0]);
			int ksum=Integer.parseInt(s[1]);
			
			int perm[] = new int[n];
			for(int i=0;i<n;i++){
				perm[i] = i;
			}
			// System.out.println("Case #"+t+": "+flag);
		
			permute(perm,0,ksum,t);
			
			// System.out.println("Case #"+t+": "+flag);
			if(flag==0){
				System.out.println("Case #"+t+": IMPOSSIBLE");
			}
			
		}
	}
}