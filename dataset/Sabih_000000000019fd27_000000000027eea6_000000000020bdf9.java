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
           
            int currentCameronEnding = 0;
            int currentJamieEnding = end[0];

            String jobAllotment = "J";

            int valid = 0;

            for(int j=1;j<n;j++){
                if(start[j] < currentCameronEnding
                && start[j] >= currentJamieEnding){
                    jobAllotment+="J";
                    currentJamieEnding=end[j];
                }
                else if(start[j] < currentJamieEnding
                && start[j] >= currentCameronEnding){
                    jobAllotment+="C";
                    currentCameronEnding = end[j];
                }

                else if(start[j] >= currentJamieEnding
                && start[j] >= currentCameronEnding){
                    if(jobAllotment.charAt(jobAllotment.length()-1)=='C')
                    {
                        jobAllotment+=jobAllotment.charAt(jobAllotment.length()-1);
                        currentCameronEnding = end[j];
                    }
                    else{
                        jobAllotment+=jobAllotment.charAt(jobAllotment.length()-1);
                        currentJamieEnding = end[j];
                    }
                }

                else if(start[j] < currentJamieEnding
                && start[j] < currentCameronEnding){
                    valid = 1;
                    break;
                }

            }

            if(valid==1)
                jobAllotment="IMPOSSIBLE";
            
            //Print solution
            System.out.println("Case #"+(i+1)+": "+jobAllotment);
            
        }
    }
}