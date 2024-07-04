import java.util.*;
import java.io.*;
public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int n=sc.nextInt(),s;
        ArrayList<String> ar = new ArrayList<String>();
        for (int i = 0; i < n; i++) {
            s=sc.nextInt();
            int [][]sh = new int[s][2];
            for (int j = 0; j < sh.length; j++) {
                sh[j][0]=sc.nextInt();
                sh[j][1]=sc.nextInt();
            }
            ar.add(getshed(s,sh));
        }
        for (int i = 0; i < ar.size(); i++) {
            System.out.println("Case #"+(i+1)+": "+ar.get(i));
        }
    }
    public static String getshed(int s,int [][]sh) {
        int max=Integer.MIN_VALUE;
        for (int i = 0; i < sh.length; i++) {
            max=Math.max(max, sh[i][1]);
        }
        int []time = new int[max+1];
        for (int i = 0; i < sh.length; i++) {
            for (int j = sh[i][0]; j < sh[i][1]; j++) {
                time[j]++;
            }
        }
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < sh.length; i++) {
            if(time[sh[i][0]]>2)
            return "IMPOSSIBLE";
            else if(i==2)
            sb.append('C');
            else if(time[sh[i][0]]==1||time[sh[i][1]-1]==1)
            sb.append('C');
            else if(time[sh[i][0]]==2||time[sh[i][1]-1]==2)
            sb.append('C');
        }
        return sb.toString();
    }
}