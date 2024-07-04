import java.util.*;
import java.io.*;
public class Solution{
    public static void main(String args[]) throws Exception{
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for(int m = 1;m <= t;m++){
            int n = sc.nextInt();
            int start[] = new int[n];
            int end[] = new int[n];
            int tempArr[] = new int[n];
            String res = "";
            for(int j = 0;j < n;j++){
                    start[j] = sc.nextInt();
                    end[j] = sc.nextInt();
                    tempArr[j] = j;
                    res = res +"0";
            }
            for(int i = 0;i<n-1;i++){
                for(int j=0;j<n-1-i;j++){
                    if(start[j] >start[j+1]){
                        int temp = start[j];
                        start[j] = start[j+1];
                        start[j+1] = temp;
                        temp = end[j];
                        end[j] = end[j+1];
                        end[j+1]= temp;
                        temp = tempArr[j];
                        tempArr[j] = tempArr[j+1];
                        tempArr[j+1] = temp;
                    }
                }
            }
            char tempStore[] = new char[n];
            int c,j;
            c = end[0];
            tempStore[0] = 'C';
            j = end[1];
            tempStore[1] = 'J';
            for(int k = 2;k < n;k++){
                if(c <= start[k]){
                    c = end[k];
                    tempStore[k] = 'C';
                }
                 else if(j<=start[k]){
                    j = end[k];
                    tempStore[k] = 'J';
                }
                else{
                    res = "IMPOSSIBLE";
                    break;
                }
            }
        
            if(!res.equalsIgnoreCase("IMPOSSIBLE")){
                for(int i = 0;i<n;i++){
                    if(tempArr[i] == 0)
                        res = tempStore[i]+res.substring(tempArr[i]+1);
                    else if (tempArr[i] == n-1)
                        res = res.substring(0,tempArr[i]) + tempStore[i];
                    else
                        res = res.substring(0,tempArr[i])+tempStore[i]+res.substring(tempArr[i]+1);
            }
        }
         System.out.println("Case #" + m +": " + res);
        }
    }

}