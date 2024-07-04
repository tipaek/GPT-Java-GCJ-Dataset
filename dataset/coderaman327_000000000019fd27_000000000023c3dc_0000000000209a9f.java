import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Solution {
    public static void main(String[] args) throws java.io.IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int t=Integer.parseInt(br.readLine());
        for(int k=1;k<=t;++k)
        {
            String str=br.readLine();
            int len=str.length();
            int counter=0;
            ArrayList<Character> ans=new ArrayList<>();
            for(int i=0;i<len;++i)
            {
                int ele=Integer.parseInt(str.substring(i,i+1));
                //System.out.println(ele);
                if(ele>=counter)
                {
                    int local =ele-counter;
                    for(int j=0;j<local;j++) {
                        ans.add('(');
                        counter++;
                    }
                }
                else {
                    int local=counter-ele;
                    for(int j=0;j<local;j++) {
                        ans.add(')');
                        counter--;
                    }
                }
                char digit=(char)(ele+48);
                ans.add(digit);
                //System.out.println(digit);
            }
            for(int i=0;i<counter;++i)
                ans.add(')');
            //String result=ans.toString();
            int length=ans.size();
            System.out.print("Case #"+k+": ");
            for(int i=0;i<length;i++)
                System.out.print(ans.get(i));
            System.out.println();
        }
    }
}
