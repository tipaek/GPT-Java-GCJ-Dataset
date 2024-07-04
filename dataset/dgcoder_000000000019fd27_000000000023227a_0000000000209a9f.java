import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {

    public static void main(String[] args)throws Exception{

        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int T=Integer.valueOf(br.readLine());

        for(int t=1;t<=T;t++){
            String result=getNested(br.readLine());
            System.out.format("Case #%d: %s\n",t,result);
        }
        br.close();
    }
    public static String getNested(String s){

        StringBuilder result=new StringBuilder();
        int lb=0;
        for(int i=0;i<s.length();i++){
            char ch=s.charAt(i);
            int value=Integer.valueOf(s.substring(i,i+1));
            if(i==0){
                for(int j=0;j<value;j++)
                    result.append('(');
                lb=value;
            }
            else if (value < lb) {
                for (int j = 0; j < lb - value; j++)
                    result.append(')');
                lb = value;

            }else if (value > lb) {
                for (int j = 0; j < value - lb; j++)
                    result.append('(');
                lb = value;
            }
            result.append(ch);
        }

        for(int j=0;j<lb;j++)
            result.append(')');

        return result.toString();
    }
}
