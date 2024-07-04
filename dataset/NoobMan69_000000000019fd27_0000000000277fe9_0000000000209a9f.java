import java.util.*;
public class Solution
{
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        for(int k=0;k<t;k++)
        {
            String st=sc.next();
            String st2="";
            char ch=st.charAt(0);
            for(int i=48;i<(int)ch;i++)
                st2+='(';
            st2+=st.charAt(0);
            int count=(int)ch-48;
            
            for(int i=1;i<st.length();i++)
            {
                int diff=(int)st.charAt(i-1)-(int)st.charAt(i);
                if(diff>=0)
                {
                    for(int j=0;j<diff;j++)
                        st2+=')';
                    st2+=st.charAt(i);
                    count-=diff;
                }
                else
                {
                    for(int j=0;j<count;j++)
                        st2+=')';
                    for(int j=48;j<(int)st.charAt(i);j++)
                        st2+='(';
                    st2+=st.charAt(i);
                    count=(int)st.charAt(i)-48;
                    // System.out.println("count "+count);
                }
            }
            // System.out.println("count2 "+count);

            for(int i=0;i<count;i++)
             st2+=')';
            System.out.println("Case #"+k+": "+st2);
        }
    }
}