import java.util.*;
import java.io.*;
public class Solution{
    public static void main(String[]abc){
        //FastReader in=new FastReader();
        Scanner in=new Scanner(System.in);
        PrintWriter out=new PrintWriter(new OutputStreamWriter(System.out));
        int t=in.nextInt(),Case=1;
        int[][]a=new int[101][101];
        while(t-->0){
            int trace=0,r=0,c=0;
            int n=in.nextInt();
            for(int i=0;i<n;i++){
                for(int j=0;j<n;j++)
                    a[i][j]=in.nextInt();
            }
            for(int i=0;i<n;i++){
                HashSet<Integer>row=new HashSet<>(),col=new HashSet<>();
                trace+=a[i][i];
                for(int j=0;j<n;j++){
                    if(row.contains(a[i][j]))
                    {
                        r++;
                        break;
                    }
                    row.add(a[i][j]);
                }
                for(int j=0;j<n;j++){
                    if(col.contains(a[j][i]))
                    {
                        c++;

                        break;
                    }
                    col.add(a[j][i]);
                }
            }
            out.println("Case #"+(Case++)+": "+trace+" "+r+" "+c);
        }
        out.flush();
    }
}