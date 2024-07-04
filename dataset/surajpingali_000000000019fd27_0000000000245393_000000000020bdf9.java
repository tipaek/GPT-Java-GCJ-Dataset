import java.util.*;
class Solution{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int t=sc.nextInt();
        for(int in=1;in<=t;in++){
            int n=sc.nextInt();
            int[][]arr = new int[n][2];
            for(int i=0;i<n;i++){
                arr[i][0]=sc.nextInt();
                arr[i][1]=sc.nextInt();
            }
            
            int[] res = new int[(24*60)+1];
            String ans = "";
            int flag=0;
            xyz:
            for(int i=0;i<n;i++){
                int k=-1;
                if(res[arr[i][0]]==0){k=1;ans+='C';}
                else if(res[arr[i][0]]==1){
                    k=2;ans+='J';
                }
                else{ k=1;ans+='C';}
                
                for(int j=arr[i][0];j<arr[i][1];j++){
                    res[j]+=k;
                    if(res[j]>3){flag=1;break xyz;}
                }
            }
            
            if(flag == 1){
                System.out.println("Case #"+in+": "+"IMPOSSIBLE");
            }
            else{
                System.out.println("Case #"+in+": "+ans);
            }
        }
    }
}