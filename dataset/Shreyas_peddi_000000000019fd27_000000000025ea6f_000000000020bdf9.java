import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        int t=sc.nextInt();
        for(int q=0;q<t;q++)
        {

            int n= sc.nextInt();
            
            
            int[][]activities= new int[n][2];
            
            for(int i=0;i<n;i++){
                activities[i][0]=sc.nextInt();
                activities[i][1]=sc.nextInt();
            }
            int[][] sorted= activities.clone();
            
            Arrays.sort(sorted, new StartComparator());
            HashMap<String,String> assign= new HashMap<>();
            int c=0;
            int j=0;
            boolean impossible=false;
            for(int i=0;i<n;i++){
            if(c<=sorted[i][0]){
                   c=sorted[i][1];
                   assign.put(sorted[i][0]+"-"+sorted[i][1],"C");
                }
               else if(j<=sorted[i][0]){
                    j=sorted[i][1];
                    assign.put(sorted[i][0]+"-"+sorted[i][1],"J");
                }
                else{
                    impossible=true;
                    break;
                }
            }
            
            if(impossible){
                System.out.println("Case #"+(q+1)+": IMPOSSIBLE");
                continue;
            }
            String ans="";
            HashMap<String,Integer>done= new HashMap<>();
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