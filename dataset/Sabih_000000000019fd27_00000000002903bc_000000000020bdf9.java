import java.io.*;
import java.util.*;
class Solution
{
    
    // static void printCameron(int cameron[]){
    //     for(int i=0;i<cameron.length;i++){
    //         System.out.print(cameron[i]+" ");
    //     }
    //     System.out.println();
    // }
    // static void printJamie(int jamie[]){
    //     for(int i=0;i<jamie.length;i++){
    //         System.out.print(jamie[i]+" ");
    //     }
    //     System.out.println();
    // }
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
           
            
            String ans = "";
            String jobAllotment[] = new String[n];
            int toCompareStart = start[0];
            int toCompareEnd = end[0];
            int valid = 0;
            jobAllotment[0] = "J";
            int c = 0;
            int toCompareStartC = 0;
            int toCompareEndC = 0;
            int startIndexC = 0;
            for(int j=1;j<n;j++){
                if((start[j] > toCompareStart && start[j] <toCompareEnd)
                ||(end[j]>toCompareStart && end[j]<toCompareEnd)||
                (start[j] > toCompareStart && end[j]<toCompareEnd)){
                    jobAllotment[j]="C";
                    c=c+1;
                    if(c==1){
                        toCompareStartC = start[j];
                        toCompareEndC = end[j];
                        startIndexC = j;
                    }
                }
                else{
                    jobAllotment[j]="J";
                }



                // else if(start[j] < currentJamieEnding
                // && start[j] < currentCameronEnding){
                //     valid = 1;
                //     break;
                // }
            }

            for(int j=startIndexC+1;j<n;j++){
                if(jobAllotment[j]=="C"){
                    if((start[j] > toCompareStartC && start[j] <toCompareEndC)
                    ||(end[j]>toCompareStartC && end[j]<toCompareEndC)||
                    (start[j] > toCompareStartC && end[j]<toCompareEndC)){
                        valid = 1;
                        break;
                    }
                }
            }


            if(valid==1)
                ans = "IMPOSSIBLE";
            else
            {
                for(int j=0;j<n;j++){
                    ans+=jobAllotment[j];
                }
            }
            
            //Print solution
            System.out.println("Case #"+(i+1)+": "+ans);
            
        }
    }
}