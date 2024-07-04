import java.io.*;
import java.util.*;

class Solution{
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        int T = input.nextInt();
        for(int c = 1; c <= T; c++){
            String S = input.next();
            char[] arr = S.toCharArray();
            StringBuilder sb = new StringBuilder();
            for(int i = 0; i < arr.length; i++){
                if((i == 0 && arr[i] == '1') || (i != 0 &&arr[i-1] == '0' && arr[i] == '1'))
                    sb.append("(");
                else if(i != 0 && arr[i] == '0' && arr[i-1] == '1')
                    sb.append(")");
        
            
				sb.append(arr[i]);
				//System.out.println(sb.toString());
            }
            if(arr[arr.length-1] == '1') sb.append(")");
            System.out.println("Case #"+c+": "+sb.toString());
        }
    }
}