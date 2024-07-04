
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by ayush1 on 04-04-2020.
 */
class Solution {
    static void append_open(StringBuilder st,int num)
    {
        for (int i = 0; i < num; i++) {
            st.append('(');
        }
    }
    static void append_close(StringBuilder st,int num)
    {
        for (int i = 0; i < num; i++) {
            st.append(')');
        }
    }
    public static void main(String args[])throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int test = Integer.parseInt(br.readLine());
        int n,open,count,last,curr;
        StringBuilder st = new StringBuilder();
        String s;
        char ch[];
        for (int i = 1; i <=test ; i++) {
            st.delete(0,st.length());
            ch = br.readLine().toCharArray();
            n = ch.length;
            open=0;
            count=0;
            if(ch[0]=='0')
                st.append(0);
            else
            {
                count = ch[0]-48;
                append_open(st,count);
                open = count;
                st.append(count);
            }
            last = count;
            for (int j = 1; j < n; j++) {
                curr = ch[j]-48;
                if(last<curr){
                    count = curr-open;
                    append_open(st,count);
                    open+=count;
                }
                else if(last>curr)
                {
                    count = open-curr;
                    append_close(st,count);
                    open-=count;
                }
                st.append(curr);
                last = curr;
            }
            append_close(st,open);
            System.out.printf("Case #%d: %s\n",i,st.toString());
        }
    }
}
