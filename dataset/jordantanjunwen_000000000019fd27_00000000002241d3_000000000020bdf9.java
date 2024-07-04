import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

 
    static void arrangeSchedule(int[][] arr, int pos) {
       int[][] cameronSchedule = new int[arr.length][2];
       int[][] jamieSchedule = new int[arr.length][2];
       int camSchedulePos=0,jamSchedulePos=0;
       boolean overLapping1,overLapping2;
       String output="";
        
        
        output+="C";
       cameronSchedule[0][0]=arr[0][0];
       cameronSchedule[0][1]=arr[0][1];
       camSchedulePos++;
                   
        for(int i=1;i<arr.length;i++){
            overLapping1=false;
            overLapping2=false;
            
           for(int j=0;j<cameronSchedule.length;j++){
               if(isOverlapping(arr[i][0],arr[i][1],cameronSchedule[j][0],cameronSchedule[j][1])){
                   overLapping1=true;
                   break;
               }
           }
           
           if(overLapping1 && jamieSchedule.length>0){
           for(int k=0;k<jamieSchedule.length;k++){
               if(isOverlapping(arr[i][0],arr[i][1],cameronSchedule[k][0],cameronSchedule[k][1])){
                   overLapping2=true;
               }
           }
               
           }
           
           if(overLapping1==true && overLapping2==true){
               output="IMPOSSIBLE";
               break;
           }else{
               if(!overLapping1){
                   output+="C";
                   cameronSchedule[camSchedulePos][0]=arr[i][0];
                   cameronSchedule[camSchedulePos][1]=arr[i][1];
                   camSchedulePos++;
               }else{
                   output+="J";
                   jamieSchedule[jamSchedulePos][0]=arr[i][0];
                   jamieSchedule[jamSchedulePos][1]=arr[i][1];
                   jamSchedulePos++;
               }
           }
        }
        
        System.out.println("Case #"+pos+": "+output);
    }
    
    static boolean isOverlapping(int start1, int end1, int start2, int end2) {
    return start1 <= start2 && end1 <= end2;
}

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
         int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

       for(int h=0;h<n;h++){

        int d = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
        int[][] arr = new int[d][2];

        for (int i = 0; i < d; i++) {
            String[] arrRowItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int j = 0; j < 2; j++) {
                int arrItem = Integer.parseInt(arrRowItems[j]);
                arr[i][j] = arrItem;
            }
        }
        arrangeSchedule(arr, h+1);
        }
        scanner.close();
    }
}
