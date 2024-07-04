import java.util.*;
class Solution
{
    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);

        int testcases = sc.nextInt();

        for(int i=1; i<=testcases; i++){
            int num_tasks = sc.nextInt();
            int start[]  = new int[num_tasks];
            int end[]  = new int[num_tasks];
            for(int j =0; j<num_tasks;j++){
                start[j] = sc.nextInt();
                end[j] = sc.nextInt();
            }

            String res = "C";
            int c_start = start[0];
            int c_end = end[0];
            int j_start = 0;
            int j_end = 0;
            String final_res = "";
            for(int j =1; j<num_tasks;j++){
                if(start[j]>=c_end || end[j]<=c_start){
                    res=res+"C";
                    c_end = end[j];
                    c_start = start[j];
                }
                else if(start[j]>=j_end || end[j]<=j_start){
                    res=res+"J";
                    j_end = end[j];
                    j_start = start[j];
                }
                else{
                    final_res = "IMPOSSIBLE";
                    break;
                }
            }
            if(final_res.equals("")){
                final_res = res;
            }
            System.out.println("Case #"+i+": "+final_res);
        }
    }
}