import java.util.*;
import java.io.*;  

public class Solution{
    public static class pair{
        int x;
        int y;
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t=Integer.parseInt(br.readLine());
        int u=1;
        while(t-->0){
            String line=br.readLine();
            String[] strs=line.trim().split("");
            int[] arr=new int[line.length()];
            for(int i=0;i<arr.length;i++){
                arr[i]=Integer.parseInt(strs[i]);
            }
            // System.out.println("Heelo");
            StringBuffer sb=new StringBuffer();
            int val=arr[0];
            for(int i=0;i<val;i++){
                sb.append("(");
            }
            sb.append(val+"");
            int pos=val;
            for(int i=0;i<val;i++){
                sb.append(")");
            }
            for(int i=1;i<arr.length;i++){
                val=arr[i];
                if(val>arr[i-1]){
                    int diff=val-arr[i-1];
                    pos++;
                    for(int j=0;j<diff;j++){
                        sb.insert(pos,"(");
                        pos++;
                    }
                    int v=pos;
                    sb.insert(pos,val+"");
                    pos++;
                    for(int j=0;j<diff;j++){
                        sb.insert(pos,")");
                        pos++;
                    }
                    pos=v;
                }else if(val<arr[i-1]){
                    int diff=arr[i-1]-val;
                    pos=pos+diff+1;
                    sb.insert(pos,val+"");
                }else{
                    pos++;
                    sb.insert(pos,val+"");
                }
            }
            System.out.println("Case #"+u+": "+sb);
            u++;
        }
    }
}
