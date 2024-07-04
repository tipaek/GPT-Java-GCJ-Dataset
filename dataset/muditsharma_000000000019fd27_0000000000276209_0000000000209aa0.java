import java.util.*;
public class Solution{
	public static int[] nextPermutation(int[] nums) {
        int i,j;
        for(i=nums.length-2;i>-1 && nums[i]>=nums[i+1];i--){
            
        }
        if(i>-1){
            for(j=nums.length-1;nums[j]<=nums[i];j--){
            
            }
            int temp=nums[i];
            nums[i]=nums[j];
            nums[j]=temp;
        }
        int ptr1=i+1,ptr2=nums.length-1;
        while(ptr1<ptr2){
            int t=nums[ptr1];
            nums[ptr1]=nums[ptr2];
            nums[ptr2]=t;
            ptr1++;
            ptr2--;
        }
        return nums;
    }

	public static int[] rotateArray(int [] arr){
		int newArr[]=new int[arr.length];
		int x=arr[arr.length-1];
		for(int i=arr.length-1;i>0;i--){
			newArr[i]=arr[i-1];
		}
		newArr[0]=x;
		return newArr;
	}
	public static void main(String args[]){
		Scanner sc=new Scanner(System.in);
		int t=sc.nextInt();
		int cases=1;
		while(cases<=t){
			int n=sc.nextInt();
			int k=sc.nextInt();
			int arr[][]=new int[n][n];
			for(int i=1;i<=n;i++){
				arr[0][i-1]=i;
			}
			//System.out.println(Arrays.toString(arr[0]));
			for(int i=1;i<n;i++){
				arr[i]=rotateArray(arr[i-1]).clone();
			}
			//System.out.println(Arrays.deepToString(arr));
			int nums[]=arr[0].clone();
			boolean sol=false;
			do{
				//System.out.println(Arrays.toString(nums));
				int sum=0;
				for(int i=0;i<n;i++){
					sum+=arr[i][nums[i]-1];
				}
				//System.out.println(sum);
				if(sum==k){
					sol=true;
					break;
				}
				nums=nextPermutation(nums).clone();
			}while(!Arrays.equals(nums,arr[0]));
			if(sol){
				int ans[][]=new int[n][n];
				for(int i=0;i<n;i++){
					ans[i]=arr[nums[i]-1].clone();
				}
				System.out.println("Case #" + cases + ": POSSIBLE");
				for(int i=0;i<n;i++){
					for(int j=0;j<n;j++){
						System.out.print(ans[i][j]+" ");
					}
					System.out.println();
				}
			}
			else{
				System.out.println("Case #" + cases + ": IMPOSSIBLE");
			}
			cases++;
		}
		
	}
}