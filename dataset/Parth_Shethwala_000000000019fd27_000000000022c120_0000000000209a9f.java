import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws Exception{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int test=Integer.parseInt(br.readLine());
        int count=1;
        while(test-->0) {
            String str=br.readLine();
            StringBuffer sb=new StringBuffer(str);
           
            if(sb.charAt(0)=='1') {
                sb.insert(0, '(');
            }
            for(int i=1;i<sb.length()-1;i++) {
                if(sb.charAt(i)=='0'&&sb.charAt(i+1)=='1')
                    sb.insert(i+1,'(');
                else if(sb.charAt(i)=='1'&&sb.charAt(i+1)=='0')
                    sb.insert(i+1,')');
            }
            if(sb.charAt(sb.length()-1)=='1') 
                sb.insert(sb.length(), ')');
            
            System.out.println("Case #"+(count++)+": "+sb);
            }
            
        
        
    }
}

        
