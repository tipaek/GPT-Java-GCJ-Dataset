import java.util.*;
import java.lang.*;

public class Solution{

    public static void printArray(int[] arr){
        int n = arr.length;
        for(int i=0;i<n;i++){
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static String paranthesize(String str){

        StringBuffer sb = new StringBuffer();
        int remaining = 0;
        sb.append(str);
        int[] nest = new int[str.length()];
        int n = str.length();
        for(int i=0;i<str.length();i++){
            nest[i] = str.charAt(i) - '0';
            if(nest[i] > 0){
                remaining++;
            }
        }
        while(remaining > 0){
            int idx = 0;    //StringBuffer index
            int nidx = 0;   //Number index
            int size = sb.length();
            boolean terminate = false;
            int open = -1;
            int close = -1;
            //Place opening paranthesis
            while(true){
                if(idx >= size){
                    terminate = true;
                    break;
                }
                if(sb.charAt(idx) == '('){
                    idx++;
                    continue;
                }
                if(sb.charAt(idx) == ')'){
                    idx++;
                    continue;
                }
                if(nest[nidx] == 0){
                    idx++;
                    nidx++;
                    continue;
                }
                if(nest[nidx] > 0){
                    open = idx;
                    //idx++;
                    break;
                }
            }

            if(terminate)
                break;
            
            //Place closing paranthesis
            while(true){
                if(idx >= size){
                    close = idx + 1;
                    terminate = true;
                    break;
                }
                if(sb.charAt(idx) == '('){
                    idx++;
                    continue;
                }
                if(sb.charAt(idx) == ')'){
                    idx++;
                    continue;
                }
                if(nest[nidx] == 0){
                    close = idx + 1;
                    break;
                }
                if(nest[nidx] > 0){
                    nest[nidx]--;
                    idx++;
                    if(nest[nidx] == 0)
                        remaining--;
                    nidx++;
                }
            }

            sb.insert(open, '(');
            sb.insert(close, ')');
            //System.out.println("Placing paranthesis at index " + open + " and " + close);
            //System.out.print("Nest : \t");
            //printArray(nest);
            //System.out.println("After this pass : " + sb.toString());
        } 
        return sb.toString();
    }
    
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        int tc = Integer.parseInt(scan.nextLine());
        for(int t = 1; t <= tc; t++){
            String s = scan.nextLine();
            System.out.println("Case #" + t + ": " + paranthesize(s));
        }
    }
    
}