import java.io.*;
import java.util.*;
class Solution
{
    public static void main(String args[]) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        for(int i=0;i<t;i++){
            int n = Integer.parseInt(br.readLine());
            int start[] = new int[n];
            int end[] = new int[n];
            int f = 0;
            for(int j=0;j<n;j++){
                String inputs = br.readLine();
                String x[] = inputs.split(" ");
                start[j] = Integer.parseInt(x[0]);
                end[j] = Integer.parseInt(x[1]);
            }
            
            //Assuming Cameron starts the job
            int cameronAct[] = new int[n];
            int jamieAct[] = new int[n];
            
            //Sorting the starting and ending points
            int s = 0, e = 0;
            for(int j=0;j<n;j++){
                for(int k=0;k<n-1;k++){
                    if(start[k]>start[k+1]){
                        s = start[k];
                        start[k] = start[k+1];
                        start[k+1] = s;
                        
                        e = end[k];
                        end[k] = end[k+1];
                        end[k+1] = e;
                    }
                }
            }
            String allotment="C";
            cameronAct[0] = end[0];
            int valid = 0;
            for(int j=1;j<n;j++){
                if(start[j] < cameronAct[j-1]
                &&(start[j]>=jamieAct[j-1])){
                    // System.out.println("I am alloting job to jamie");
                    //Give job to jamie
                    allotment+="J";
                    jamieAct[j] = end[j];
                    cameronAct[j] = cameronAct[j-1];
                }
                else if(start[j]<jamieAct[j-1]
                &&(start[j] >= cameronAct[j-1])){
                    // System.out.println("I am alloting job to Cameron");
                    //Give job to cameron
                    allotment+="C";
                    jamieAct[j] = jamieAct[j-1];
                    cameronAct[j] = end[j];
                }
                else if(start[j]>=cameronAct[j-1]
                && start[j]>=jamieAct[j-1]){
                    // System.out.println("I am alloting job to jamie or Cameron");
                    if(allotment.charAt(allotment.length()-1)=='C')
                        allotment+="J";
                    else if(allotment.charAt(allotment.length()-1)=='J')
                        allotment+="C";
                }
                else if(start[j]<cameronAct[j-1]
                && start[j]<jamieAct[j-1]){
                    // System.out.println("Overlapping");
                    valid = 1;
                    break;
                }
            }
            
            if(valid==1)
                allotment="IMPOSSIBLE";
            else{
                char g[] = allotment.toCharArray();
                for(int j=0;j<g.length;j++){
                    if(g[j]=='C')
                        g[j] = 'J';
                    else if(g[j]=='J')
                        g[j] = 'C';
                }
                allotment = String.valueOf(g);
            }
            
            //Print solution
            System.out.println("Case #"+(i+1)+": "+allotment);
            
        }
    }
}