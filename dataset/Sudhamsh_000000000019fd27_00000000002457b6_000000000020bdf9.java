import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import  java .util.*;
class Solution {
    public static void main(String[] agrs) throws Exception {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        int x = 1;
        Scanner sc = new Scanner(System.in);
        while (t-- > 0) {
            char a[] = new char[1440];
            Arrays.fill(a, '0');
            int n = Integer.parseInt(br.readLine().split(" ")[0]);
            String ans = "";
            boolean f = false;
            while (n-- > 0) {
                String s[] = br.readLine().split(" ");
                int y = Integer.parseInt(s[0]);
                int z = Integer.parseInt(s[1]);
                if(!f&&check(a,y,z,'J')){
                    ans=ans+'C';
                    fill(a,y,z,'J');
                }
                else if(!f&&check(a,y,z,'C')){
                    ans=ans+'J';
                    fill(a,y,z,'C');
                }
                else
                {
                    f=true;
                }
            }
            if(f)
                bw.write("Case #"+x+": IMPOSSIBLE\n");
            else
                bw.write("Case #"+x+": "+ans+"\n");
            x++;
        }
        bw.flush();
    }
    static boolean check(char[] a,int y,int z,char x)
    {
        while(y<z)
        {
            if(a[y]==x||a[y]=='K')
                return false;
            y++;
        }
        return true;
    }
    static void fill(char[] a,int y,int z,char x)
    {
        while(y<z)
        {
            if(a[y]=='0')
                a[y]=x;
            else
                a[y]='K';
            y++;
        }
    }
}

