import java.util.HashSet;
import java.io.*;
public class Solution
{
    public static void main(String args[]) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int t = Integer.parseInt(br.readLine().trim());
        for(int i=1; i<=t; i++)
        {
            int n = Integer.parseInt(br.readLine().trim());
            int trace = 0;
            HashSet<Integer> repRow = new HashSet<>(), repCol = new HashSet<>();
            HashSet<Integer>[] colAr = new HashSet[n];
            HashSet<Integer> rowVal = new HashSet<>();
            String str[];
            for(int row=0; row<n; row++)
            {
                str = br.readLine().trim().split("\\s+");
                for(int col=0; col<n; col++)
                {
                    if(row==0)
                        colAr[col] = new HashSet<>();
                    int num = Integer.parseInt(str[col]);
                    if(row==col)
                    {
                        trace += num;
                    }
                    if(rowVal.contains(num))
                        repRow.add(row);
                    if(colAr[col].contains(num))
                        repCol.add(col);
                    rowVal.add(num);
                    colAr[col].add(num);
                }
                rowVal.clear();
            }
            bw.write("Case #"+i+": "+trace+" "+repRow.size()+" "+repCol.size()+"\n");
        }
        
        br.close();
        bw.close();
    }
}