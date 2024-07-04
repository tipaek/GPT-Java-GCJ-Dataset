import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt();
        for (int i = 1; i <= t; ++i) {
           int N = in.nextInt();
           int JTimes[][] = new int[N][2];
           int CTimes[][] = new int[N][2];
           int JCount = 0;
           int CCount = 0;
           String allocation = "";
           for(int j=0;j<N;j++)
           {
               int start = in.nextInt();
               int finish = in.nextInt();
               if(checkSchedule(CTimes,CCount,start,finish))
               {
                   CTimes[CCount][0]=start;
                   CTimes[CCount][1]=finish;
                   CCount++;
                   allocation+="C";
               }
               else if(checkSchedule(JTimes,JCount,start,finish))
               {
                   JTimes[JCount][0]=start;
                   JTimes[JCount][1]=finish;
                   JCount++;
                   allocation+="J";                   
               }
               else
               {
                   allocation = "";
                   break;
               }  
           }
           
           System.out.println("Case #"+i+": "+((allocation.isEmpty())?"IMPOSSIBLE":allocation));
        }
    }
    
   public static boolean checkSchedule(int time[][],int size,int start,int finish)
   {
       for(int i=0;i<size;i++)
       {
           if(time[0][1]>start && time[0][0]<finish)
               return false;
       }
       
       return true;
   }
}
