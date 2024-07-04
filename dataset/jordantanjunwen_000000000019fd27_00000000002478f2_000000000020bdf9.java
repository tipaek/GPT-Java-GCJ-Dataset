import java.io.IOException;
import java.util.*;

public class Solution {
    static void arrangeSchedule(Integer[][] arr, int pos) {
       List<List<Integer>> cameronSchedule = new ArrayList<List<Integer>>();
       List<List<Integer>> jamieSchedule = new ArrayList<List<Integer>>();
       List<Integer> tempInt=new ArrayList<Integer>();
       boolean overLapping1,overLapping2;
       String output="";
                   
        for(int i=0;i<arr.length;i++){
            overLapping1=false;
            overLapping2=false;
            
            if(cameronSchedule.size()>0){
               for(int j=0;j<cameronSchedule.size();j++){
                   if(isOverlapping(arr[i][0],arr[i][1],cameronSchedule.get(j).get(0),cameronSchedule.get(j).get(1))){
                       overLapping1=true;
                       break;
                   }
                }
            }
           
           if(overLapping1 && jamieSchedule.size()>0){
               for(int k=0;k<jamieSchedule.size();k++){
                   if(isOverlapping(arr[i][0],arr[i][1],jamieSchedule.get(k).get(0),jamieSchedule.get(k).get(1))){
                       overLapping2=true;
                       break;
                   }
               }
           }
           
           if(overLapping1==true && overLapping2==true){
               output="IMPOSSIBLE";
               break;
           }else{
                tempInt.clear();
                tempInt.add(arr[i][0]);
                tempInt.add(arr[i][1]);
               if(!overLapping1){
                   output+="C";
                   cameronSchedule.add(tempInt);
               }else{
                   output+="J";
                   jamieSchedule.add(tempInt);
               }
           }
        }
        
        System.out.println("Case #"+pos+": "+output);
    }
    /**
   static boolean isOverlapping(int start1, int end1, int start2, int end2){
    int totalRange = Math.max(end1, end2) - Math.min(start1, start2);
    int sumOfRanges = (end1 - start1) + (end2 - start2);
    
    if (sumOfRanges > totalRange) { 
        return true;
    }
    **/
    static boolean isOverlapping(int start1, int end1, int start2, int end2){
     return start1 < end2 && start2 < end1;
}

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
         int n = scanner.nextInt();

       for(int h=1;h<=n;h++){

        int d = scanner.nextInt();
        Integer[][] arr = new Integer[d][2];

        for (int i = 0; i < d; i++) {

            for (int j = 0; j < 2; j++) {
                arr[i][j] = scanner.nextInt();
            }
        }
        arrangeSchedule(arr, h);
        }
        scanner.close();
    }
}
