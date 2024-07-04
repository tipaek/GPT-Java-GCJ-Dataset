
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        int t=0;
        Scanner s=new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        t=s.nextInt();
        StringBuilder builder=new StringBuilder();
        for (int i = 1; i <=t ; i++) {
            int x=s.nextInt(),y=s.nextInt();
            String st=s.next();
            int flag=0;
            for (int j = 0; j <st.length() ; j++) {
                if(st.charAt(j)=='N')
                    y++;
                if(st.charAt(j)=='E')
                    x++;
                if(st.charAt(j)=='S')
                    y--;
                if(st.charAt(j)=='W')
                    x--;
                if(poss(x,y,j+1)){
                    flag=1;
                    int a=j+1;
                    builder.append("Case #"+i+": "+a).append("\n");
                    break;
                }
            }
            if (flag==0)
                builder.append("Case #"+i+": IMPOSSIBLE").append("\n");
        }
        System.out.println(builder);
    }
    private static boolean poss(int x,int y,int d){
        if(Math.abs(x)+Math.abs(y)>d)
            return false;
        return true;
    }
}
