import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution {
    
    public static void main(String[] args) {
        
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = Integer.valueOf(in.nextLine());
        
        for (int i = 1; i <= t; ++i) {
            String message = null;
            int n = Integer.valueOf(in.nextLine());
            String[] inputs = new String[n];
            for(int j=0; j<n;j++) {
                inputs[j]=in.nextLine();
            }
            message = new Solution().findMyString(inputs);
            if(message.indexOf("IMPOSSIBLE")!=-1) {
                message = "IMPOSSIBLE";
            }
            System.out.println("Case #" + i + ": " +message);
        }
    }
    
    private String findMyString(String[] inputs) {
        List<int[]> cList = new ArrayList<int[]>();
        List<int[]> jList = new ArrayList<int[]>();
        StringBuilder outputList = new StringBuilder();
        
        for(String str: inputs) {
            String[] slots = str.split(" ");
            int[] arr = new int[2];
            arr[0] = Integer.valueOf(slots[0]);
            arr[1] = Integer.valueOf(slots[1]);
            boolean isInConflictWithC = false;
            boolean isInConflictWithJ = false;
            if(cList.isEmpty()) {
                cList.add(arr);
                outputList.append("C");
            } else {
                for(int i=0; i<cList.size(); i++) {
                    int[] temp = cList.get(i);
                    if((arr[0] >= temp[0] && arr[0] < temp[1])  || (arr[1] > temp[0] && arr[1] <= temp[1])) {
                        isInConflictWithC = true;
                    }
                }
                if(!isInConflictWithC){
                    cList.add(arr);
                    outputList.append("C");
                } else {
                    isInConflictWithJ = checkIfInConflictWithJAndAdd(jList, arr, outputList);
                    if(isInConflictWithC && isInConflictWithJ) {
                        outputList.append("IMPOSSIBLE");
                        break;
                    }
                }
            }
            
        }
        return outputList.toString();
    }
    
    private boolean checkIfInConflictWithJAndAdd(List<int[]> jList, int[] arr, StringBuilder outputList) {
        boolean isInConflictWithJ = false;
        for(int i=0; i<jList.size(); i++) {
            int[] temp = jList.get(i);
            if((arr[0] >= temp[0] && arr[0] < temp[1]) || (arr[1] > temp[0] && arr[1] <= temp[1])) {
                isInConflictWithJ = true;
                return true;
            } 
        }
        if(!isInConflictWithJ){
            jList.add(arr);
            outputList.append("J");
        }
        return isInConflictWithJ;
    }
    
}