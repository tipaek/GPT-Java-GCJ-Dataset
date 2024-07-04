import java.util.*;
import java.io.*;
class Solution {
    public static int getPriority(ArrayList<Integer> arr,int start,int end){
        int priority=0;
        if(arr.isEmpty())
            return 0;
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
                priority = 24*61;
            }
        }
        return priority;
    }
    public static int ordinalIndexOf(String str, String substr, int n) {
        int pos = str.indexOf(substr);
        while (--n > 0 && pos != -1)
            pos = str.indexOf(substr, pos + 1);
        return pos;
    }
    public static String fixOverlap(ArrayList<Integer> arr1, ArrayList<Integer> arr2, int start, int end, StringBuilder out){
        //try arr1
        for(int i =0; i<arr1.size();i+=2){
            if((start > arr1.get(i) && start < arr1.get(i+1) && (i + 2 >= arr1.size() || end < arr1.get( i + 2 ) )) || (end > arr1.get(i) && end < arr1.get(i+1) && (i == 0 || start > arr1.get(i-1)))){
                int errorStart = arr1.get(i),errorEnd = arr1.get(i+1);
                int otherPriority = getPriority(arr2,errorStart,errorEnd);
                if(otherPriority != 24*61){
                    arr2.add(errorStart);
                    arr2.add(errorEnd);
                    arr1.remove(i+1);
                    arr1.remove(i);
                    arr1.add(start);
                    arr1.add(end);
                    Collections.sort(arr1);
                    Collections.sort(arr2);
                    int changeIndex = ordinalIndexOf(out.toString(),"J",i/2 +1);
                    out.replace(changeIndex,changeIndex+1,"C");
                    out.append("J");
                    return out.toString();
                }
            }
        }

        //try arr2
        for(int i =0; i<arr2.size();i+=2){
            if((start > arr2.get(i) && start < arr2.get(i+1) && (i + 2 >= arr2.size() || end < arr2.get( i + 2 ) )) || (end > arr2.get(i) && end < arr2.get(i+1) && (i == 0 || start > arr2.get(i-1)))){
                int errorStart = arr2.get(i),errorEnd = arr2.get(i+1);
                int otherPriority = getPriority(arr1,errorStart,errorEnd);
                if(otherPriority != 24*61){
                    arr1.add(errorStart);
                    arr1.add(errorEnd);
                    arr2.remove(i+1);
                    arr2.remove(i);
                    arr2.add(start);
                    arr2.add(end);
                    Collections.sort(arr1);
                    Collections.sort(arr2);
                    int changeIndex = ordinalIndexOf(out.toString(),"C",i/2 +1);
                    out.replace(changeIndex,changeIndex+1,"J");
                    out.append("C");
                    return out.toString();
                }
            }
        }
        return "";
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
                    int jamiePriority = getPriority(jamie,startTime,endTime);
                    int cameronPriority=getPriority(cameron,startTime,endTime);
                    if(jamiePriority<=cameronPriority && jamiePriority!=24*61){
                        jamie.add(startTime);
                        jamie.add(endTime);
                        Collections.sort(jamie);
                        output.append('J');
                    }
                    else if(jamiePriority==24*61 && cameronPriority==24*61){
                        StringBuilder result = new StringBuilder(fixOverlap(jamie,cameron,startTime,endTime,output));
                        if(result.toString().equals("")) {
                            System.out.println("Case #" + i + ": IMPOSSIBLE");
                            continue testcase;
                        }
                        else{
                            output = result;
                        }
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
