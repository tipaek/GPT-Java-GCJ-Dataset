
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int t = s.nextInt();
        int x = 1;
        while (t-- != 0) {
            String str=s.next();
            StringBuilder ans=new StringBuilder();
            int len=str.length();
            int first=-1,end=-1;
            for(int i=0;i<len;i++){
                if(str.charAt(i)=='0')
                {   if(first!=-1){
                    ans.append("("+str.substring(first,i)+")");
                    first=-1;
                   }
                   ans.append(str.charAt(i));
                   end=i;
                }
                else{
                    
                    if(first==-1){
                        first=i;
                    }
                     
                    
                }
            }
            if(first!=-1){
                ans.append("("+str.substring(end+1,len)+")");
            }
            System.out.println("Case #"+x+": "+ans.toString());
            x++;
        }
    }
}
