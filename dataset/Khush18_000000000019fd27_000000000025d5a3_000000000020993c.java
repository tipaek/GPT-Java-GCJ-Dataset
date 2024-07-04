import java.util.*;
import java.io.*;
public class Solution
{
    public static void main (String args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        for (int i=0;i<t;i++){
            int n = Integer.parseInt(br.readLine());
            ArrayList<ArrayList<Integer>> a = new ArrayList<ArrayList<Integer>>();
            for(int j=0;j<n;j++){
                StringTokenizer s = new StringTokenizer(br.readLine());
                ArrayList<Integer> b = new ArrayList<Integer>();
                for(int k=0;k<n;k++){
                    b.add(Integer.parseInt(s.nextToken()));
                }
                a.add(b);
            }
            System.out.println(a.get(0).get(2));
        }
    }
    
}