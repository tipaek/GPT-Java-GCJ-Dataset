import java.util.*;

public class Solution{
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        int t = sc.nextInt();
        for(int i=1;i<=t;i++){
            int n = sc.nextInt();
            int arr[] = new int[24*60+1];
            int end[] = new int[24*60+1];
            int act=1;
            for(int j=0;j<n;j++){
                int s = sc.nextInt();
                int e = sc.nextInt();
                arr[s]=act;
                end[e]=act++;
            }
            String result = "";
            boolean first =  false;
            int firstAct = 0;
            int secondAct = 0;
            boolean second =  false;
            for(int j=0;j<arr.length;j++){
                if(end[j] > 0){ // any activity ending
                    if(firstAct == end[j]){
                        first = false;
                        firstAct = 0;
                    }else if(secondAct == end[j]){
                        second = false;
                        secondAct = 0;
                    }
                }
                if(arr[j]>0){ // any activity starting
                    if(first && second){
                        result = "IMPOSSIBLE";
                        break;
                    }
                    if(!first){
                        first = true;
                        firstAct = arr[j];
                        result+="C";
                    }else{
                        second = true;
                        secondAct = arr[j];
                        result+="J";
                    }
                }
            }
            System.out.println("Case #"+i+": "+result);
        }
    }
}