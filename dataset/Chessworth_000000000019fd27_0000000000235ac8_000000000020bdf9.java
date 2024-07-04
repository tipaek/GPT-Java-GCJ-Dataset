import java.util.*;
import java.io.*;
class Solution {
    public static int getPriority(ArrayList<Integer> arr,int start,int end){
        int priority=0;
        for (int counter = 0; counter < arr.size(); counter+=2) {
            int taskStart=arr.get(counter);
            int taskEnd=arr.get(counter+1);
            if(counter==0 && end<=taskStart){
                priority = taskStart-end;
                break;
            }
            else if(start>=taskEnd){
                if(counter==arr.size()-2){
                    priority = start-taskEnd;
                    break;
                }
                else if(end<=arr.get(counter+2)){
                    priority = (arr.get(counter+2) - end) + (start-taskEnd);
                    break;
                }
            }
            else{
                priority = 24*60;
            }
        }
        return priority;
    }
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int t = input.nextInt();
        testcase: for (int i = 1; i <= t; ++i) {
            int n = input.nextInt();
            ArrayList<Integer> jamie = new ArrayList<>();
            ArrayList<Integer> cameron = new ArrayList<>();
            StringBuilder output = new StringBuilder(1000);
            for(int j = 1; j <= n; j++){
                int startTime = input.nextInt();
                int endTime = input.nextInt();
                if(j==1){
                    jamie.add(startTime);
                    jamie.add(endTime);
                    output.append('J');
                }
                else{
                    if(getPriority(jamie,startTime,endTime)<=getPriority(cameron,startTime,endTime) && getPriority(jamie,startTime,endTime)!=24*60){
                        jamie.add(startTime);
                        jamie.add(endTime);
                        Collections.sort(jamie);
                        output.append('J');
                    }
                    else if(getPriority(jamie,startTime,endTime)==24*60 && getPriority(cameron,startTime,endTime)==24*60){
                        System.out.println("Case #"+ i +": IMPOSSIBLE");
                        continue testcase;
                    }
                    else{
                        cameron.add(startTime);
                        cameron.add(endTime);
                        Collections.sort(cameron);
                        output.append('C');
                    }
                }
            }
            System.out.println("Case #" + i + ": " + output);
        }
    }
}
