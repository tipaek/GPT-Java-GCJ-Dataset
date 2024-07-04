import java.lang.*;
import java.util.*;
public class Solution{
    public static Map<Integer,Integer> se=new HashMap<>();
    public static Map<Integer,Integer> index=new HashMap<>();
    public static void main(String args[]){
        Scanner sc= new Scanner(System.in);
        int testcase=sc.nextInt();
        for(int test=0;test<testcase;test++){
            int n= sc.nextInt();
            se=new HashMap<>();
            index=new HashMap<>();
            int[]start=new int[n];
            for(int i=0;i<n;i++){
                start[i]=sc.nextInt();
                se.put(start[i],sc.nextInt());
                index.put(start[i],i);
            }
            Arrays.sort(start);
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
    public static int[] fn(int[]start){
        int[] ans= new int[start.length];
        int c=0;
        int j=0;
        for(int i=0;i<start.length;i++){
            if(start[i]>=c){
                c=se.get(start[i]);
                ans[index.get(start[i])]=0;
            }else if(start[i]>=j){
                j=se.get(start[i]);
                ans[index.get(start[i])]=1;
            }else{
                ans[index.get(start[i])]=2;
            }
        }
        return ans;
    }
}