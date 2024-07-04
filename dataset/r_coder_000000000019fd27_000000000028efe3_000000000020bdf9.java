
import java.util.Scanner;

public class Solution {
    
    public static void main(String [] argv){
        Scanner scanner = new Scanner(System.in);
        int numberOfTestCases = scanner.nextInt();
        for(int i = 0; i< numberOfTestCases; i++){
            int n = scanner.nextInt();
            boolean flag = true;
            String output = "";
            int cEnd=0,jEnd=0;
            for(int j=0; j<n; j++){
                int start = scanner.nextInt();
                int end = scanner.nextInt();
                if(flag){
                    if(start<cEnd && start<jEnd){
                        output = "IMPOSSIBLE";
                        flag=false;
                    }
                    else if(start >= cEnd){
                        output += "C";
                        cEnd = end;
                    }
                    else{
                        output += "J";
                        jEnd = end;
                    }
                }
            }
            System.out.println("Case #"+(i+1)+": "+output);
        }
    }
}