import java.util.*;
import java.io.*;


class Solution{
    public static void main(String[] args){
        Scanner s = new Scanner(System.in);
        int t = Integer.parseInt(s.nextLine());
        for(int i=0;i<t;i++){
            String st = s.nextLine();
            char[] arr = st.toCharArray();
            StringBuffer sb = new StringBuffer("Case #");
            sb.append(Integer.toString(i+1));
            sb.append(": ");
            int count = 0;
            for(int a=0;a<arr.length;a++){
                int cur = Integer.parseInt(Character.toString(arr[a]));
                if(cur == count){
                    sb.append(Character.toString(arr[a]));
                }
                if(cur>count){
                    int limit = cur-count;
                    for(int idx=0;idx<limit;idx++){
                        sb.append("(");
                        count++;
                    }
                    sb.append(Character.toString(arr[a]));
                }
                if(cur<count){
                    int limit = count-cur;
                    for(int idx=0;idx<limit;idx++){
                        sb.append(")");
                        count--;
                    }
                    sb.append(Character.toString(arr[a]));
                }
            }
            for(int idx=0;idx<count;idx++){
                sb.append(")");
            }
            System.out.println(sb);
        }

    }
}