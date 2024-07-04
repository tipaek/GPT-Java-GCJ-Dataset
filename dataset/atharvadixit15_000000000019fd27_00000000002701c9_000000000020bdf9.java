import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        // write your code here
        Scanner sc = new Scanner(System.in);
        int t=sc.nextInt();
        for(int q=0;q<t;q++)
        {

            int n= sc.nextInt();
            
            //storing start and end time in this array
            int[][]activities= new int[n][2];
            
            for(int i=0;i<n;i++){
                activities[i][0]=sc.nextInt();
                activities[i][1]=sc.nextInt();
            }
            
            //copy the original array and then sorting it, i am not sorting the original arry because when gving the output 
            //we need to  retain the order in which they were submited to us
            int[][] sorted= activities.clone();
            //sorted activities according to their start time
            Arrays.sort(sorted, new StartComparator());
            
            //in this map i am creating pairs of format "strat-time"+"-"+"endtime" and assigning value of "C" or "J"
            //basically creating pairs of tasks and storing which task is allocated to whomm..
            HashMap<String,String> assign= new HashMap<>();
            
            //this variable tells us when will Cammeron get free by
            int c=0;
            
            //this varibale teells u when will Jamie get free by, at start both of them are free
            int j=0;
            
            //flag used to detect impossble condition
            boolean impossible=false;
            
            //looping through all activities
            for(int i=0;i<n;i++){
            
            
                //Cameron is free at the time of start of this task
                if(c<=sorted[i][0]){
                    //camerron will be busy till this job completion
                    c=sorted[i][1];
                    
                    //assign this job to Cameeron
                    assign.put(sorted[i][0]+"-"+sorted[i][1],"C");
                }
                //Jamie is free at the time of start of this task
                else if(j<=sorted[i][0]){
                    j=sorted[i][1];
                    assign.put(sorted[i][0]+"-"+sorted[i][1],"J");
                }
                //if both of them are busy, then this is a impossible situation to solve
                // set a flag which tells that we are exiting the loop due to impossible situation and break;
                else{
                    impossible=true;
                    break;
                }
            }
            // check if exited due to impossible situation
            if(impossible){
                System.out.println("Case #"+(q+1)+": IMPOSSIBLE");
                continue;
            }
            String ans="";
            HashMap<String,Integer>done= new HashMap<>();
            //loop over assigned tasks and check to whom it was assigned and prepare the ans String;
            //it might happen that there are 2 tasks with same start and end time, then we should chek if already thyere was any task with same start and end time
            // if so allocate i to camerron because the duplicate task would hacve got allopcated to Jamie, for this stuff i am using done hashMap
            for(int i=0;i<n;i++){
                if(done.containsKey(activities[i][0]+"-"+activities[i][1])){
                    ans=ans+"C";
                }
                else
                    ans=ans+assign.get(activities[i][0]+"-"+activities[i][1]);
                done.put(activities[i][0]+"-"+activities[i][1],1);
            }
            System.out.println("Case #"+(q+1)+": "+ans);
        }
    }
    static class StartComparator implements Comparator<int[]>
    {
        public int compare(int[] c1, int[] c2)
        {
            return c1[0]-c2[0];
        }
    }

}