import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Solution {
    public static boolean check(int start, int end, int[] st, int[] et,int len){
        boolean flag=true;
        //System.out.println(len+" "+st[0]+" "+et[0]);
        for(int i=0;i<len;i++){
            //System.out.println(st[i]+" "+et[i]+" "+start+" "+end);
            if((st[i] <=start && et[i]>start) || (st[i] <end && et[i]>=end) )
                flag=false;
            else
                flag=true;
        }
        return flag;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));
        int t=Integer.parseInt(reader.readLine());
        StringBuffer buffer=new StringBuffer();
        for(int i=1;i<=t;i++){
            int n=Integer.parseInt(reader.readLine());
            int[] ce=new int[1000];
            int[] ct=new int[1000];
            int[] je=new int[1000];
            int[] jt=new int[1000];
            int cl=0,jl=0;
            while(n-->0){
                int[] se=Arrays.asList(reader.readLine().trim().split(" ")).stream().mapToInt(Integer::parseInt).toArray();
                if(check(se[0],se[1],ce,ct,cl)){
                    buffer.append("C");
                    ce[cl]=se[0];ct[cl]=se[1];
                    cl++;
                }
                else if(check(se[0],se[1],je,jt,jl)){
                    buffer.append("J");
                    int l=je.length;
                    je[jl]=se[0];jt[jl]=se[1];
                    jl++;
                }
                else{
                    //System.out.println(buffer.toString());
                    buffer.setLength(0);
                    buffer.append("IMPOSSIBLE");
                    break;
                }
            }
            System.out.println("Case #"+i+": "+buffer.toString());
            buffer.setLength(0);
        }
    }
}
