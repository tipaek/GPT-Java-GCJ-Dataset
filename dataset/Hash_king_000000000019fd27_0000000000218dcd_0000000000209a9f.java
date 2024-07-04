import java.util.*;
public class Solution{
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        for(int i=0;i<t;i++){
            String s=sc.next();
            String m="";
            for(int j=0;j<s.length();j++){
                if(j>0&&s.charAt(j)==s.charAt(j-1))
                m+=s.charAt(j);
                else
                {
                    int tp=0;
                    if(j!=0)
                    while(tp++<s.charAt(j-1)-'0')
                    m+=')';
                    tp=0;
                    while(tp++<s.charAt(j)-'0')
                    m+='(';
                    m+=s.charAt(j);

                }

            }
            int tk=0;
            while(tk++<s.charAt(s.length()-1)-'0')
            m+=')';
            
            System.out.println("Case #"+(i+1)+": "+m);
            
        }


        sc.close();
    }
    
}