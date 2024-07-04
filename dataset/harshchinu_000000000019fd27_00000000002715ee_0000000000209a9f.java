class Solution {
    public void moveZeroes(int[] nums) {
        int[] temp=new int[nums.length];
        int n=nums.length;
        int i,k;
        for(i=0,k=0;k<n;k++) {
            if(nums[k]==0) 
                continue;
            temp[i++]=nums[k];
        }
        for(;i<n;i++)
            temp[i]=0;
        for(i=0;i<n;i++)
            nums[i]=temp[i];
        
    }
}