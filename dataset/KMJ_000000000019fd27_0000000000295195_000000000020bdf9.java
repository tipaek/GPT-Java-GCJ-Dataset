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
           StringBuilder allocation = new StringBuilder();
           for(int j=0;j<N;j++)
           {
               int start = in.nextInt();
               int finish = in.nextInt();
               if(CCount<N && checkSchedule(CTimes,CCount,start,finish))
               {
                   CTimes[CCount][0]=start;
                   CTimes[CCount][1]=finish;
                   CCount++;
                   allocation.append("C");
               }
               else if(JCount<N && checkSchedule(JTimes,JCount,start,finish))
               {
                   JTimes[JCount][0]=start;
                   JTimes[JCount][1]=finish;
                   JCount++;
                   allocation.append("J");
               }
               else
               {
                   allocation = new StringBuilder();
                   break;
               }  
           }
           
           System.out.println("Case #"+i+": "+((allocation.length()==0)?"IMPOSSIBLE":allocation));
        }
    }
    
   public static boolean checkSchedule(int time[][],int size,int start,int finish)
   {
       for(int i=0;i<size;i++)
       {
           if(time[i][1]>start && time[i][0]<finish)
               return false;
       }
       
       return true;
   }
}
