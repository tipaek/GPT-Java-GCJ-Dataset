import java.lang.*;
import java.util.*;
public class Solution{
    public static void main(String args[]){
        Scanner sc= new Scanner(System.in);
        int testcase=sc.nextInt();
        for(int test=0;test<testcase;test++){
            int n= sc.nextInt();
            int[][]start=new int[n][3];
            for(int i=0;i<n;i++){
                start[i][0]=sc.nextInt();
                start[i][1]=sc.nextInt();
                start[i][2]=i;
            }
            for(int i=0;i<start.length;i++){
                for(int j=0;j<start.length;j++){
                    if(start[i][0]<start[j][0]){
                        int temp=start[i][0];
                        start[i][0]=start[j][0];
                        start[j][0]=temp;
                        temp=start[i][1];
                        start[i][1]=start[j][1];
                        start[j][1]=temp;
                        temp=start[i][2];
                        start[i][2]=start[j][2];
                        start[j][2]=temp;
                        
                    }
                }
            }
            System.out.print("Case #"+Integer.toString(test+1)+": ");
            int[] ans=fn(start);
            String sol="";
            int temp=0;
                for(int x=0;x<ans.length;x++){
                    if(ans[x]==0){
                        sol=sol+"C";
                    }else if(ans[x]==1){
                        sol=sol+"J";
                    }else{
                        temp=1;
                        System.out.println("IMPOSSIBLE");
                        break;
                    }
                }
                if(temp==0){
                System.out.println(sol);
                }
                
        }
    }
    public static int[] fn(int[][]start){
        int[] ans= new int[start.length];
        int c=0;
        int j=0;
        for(int i=0;i<start.length;i++){
            if(start[i][0]>=c){
                c=start[i][1];
                ans[start[i][2]]=0;
            }else if(start[i][0]>=j){
                j=start[i][1];
                ans[start[i][2]]=1;
            }else{
                ans[start[i][2]]=2;
                return ans;
            }
        }
        return ans;
    }
}