import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));
        int t=Integer.parseInt(reader.readLine());
        StringBuffer buffer=new StringBuffer();

        for(int i=1;i<=t;i++){
            int c = 0,top=0;
            int[] arr=Arrays.asList(reader.readLine().trim().split("")).stream().mapToInt(Integer::parseInt).toArray();
            int len=arr.length;
            for(int j=0;j<len;j++) {
                c =arr[j];
                //System.out.println(top+" "+c);
                if(top<c){
                    for(int p=0;p<c-top;p++) buffer.append("(");
                    top+=(c-top);
                }else if(top>c){
                    for(int p=0;p<top-c;p++) buffer.append(")");
                    top-=(top-c);
                }
                buffer.append(String.valueOf(c));
            }
            if(top!=0){
                while(top-->0) buffer.append(")");
            }
            System.out.println("Case #"+i+": "+buffer.toString());
            buffer.setLength(0);
        }
    }
}
