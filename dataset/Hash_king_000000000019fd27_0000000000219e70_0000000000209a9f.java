import java.util.*;
public class Solution{
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        for(int i=0;i<t;i++){
            String s=sc.next();
            String m="";
            Stack<Character> st=new Stack<>();
            for(int j=0;j<s.length();j++){
                if(j>0&&s.charAt(j)==s.charAt(j-1))
                m+=s.charAt(j);
                else
                {
                    int tp=0;
                    if(j!=0&&s.charAt(j)>s.charAt(j-1))
                    while(tp++<s.charAt(j)-s.charAt(j-1))
                    {
                        m+='(';
                        st.push('(');
                    }
                    else{
                    //tp=0;
                    if(j!=0)
                    while(tp++<s.charAt(j-1)-s.charAt(j))
                    {
                        st.pop();
                        m+=')';
                    }
                    else
                    while(tp++<s.charAt(j)-'0')
                    {
                        m+='(';
                        st.push('(');
                    }
                }
                    m+=s.charAt(j);

                }

            }
            //int tk=0;
            while(!st.isEmpty())
             {
                 m+=')';
                 st.pop();
             }
            
            System.out.println("Case #"+(i+1)+": "+m);
            
        }


        sc.close();
    }
    
}