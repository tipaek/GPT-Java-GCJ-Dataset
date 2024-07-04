import java.util.*;
import java.io.*;

class Solution{

    public static int permut[][];
    public static int k,n;
    public static ArrayList<int[][]> list = new ArrayList<>();

    public static void main(String args[]) throws Exception{
        Scanner in = new Scanner((System.in));
        int T = in.nextInt();
        for(int t=0;t<T;t++){
            n = in.nextInt();
            String s[] = new String[n];
            String result = "";
            for(int i=0;i<n;i++){
                s[i] = in.next();
                if(result.length()<s[i].length()){
                    result = s[i];
                }
            }
            result=result.substring(1,result.length());
            boolean flag = false;
            for(int i=n-1;i>=0;i--){
                String top = s[i];
                int k = result.length()-1;
                for(int j=top.length()-1;j>=0;j--){
                    if(k>=0 && top.charAt(j)!='*' && top.charAt(j)!=result.charAt(k--)){
                        flag = true;
                        break;
                    }
                }
            }
            System.out.print("Case #"+(t+1)+": ");
            if(flag){
                System.out.println("*");
            }
            else{
                System.out.println(result);
            }
            
        }
    }

}
