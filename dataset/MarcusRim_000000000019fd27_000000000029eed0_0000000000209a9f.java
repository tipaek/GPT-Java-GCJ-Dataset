import java.io.*;
import java.util.*;

public class Solution
{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));
        int times = Integer.parseInt(br.readLine());
        String str;
        String ans;
        ArrayList<Integer> arr = new ArrayList<Integer>();
        int counter = 0;
        for(int j = 1; j<= times; j++)
        {
            str = br.readLine();
            for(int i=0;i<ans.length();i++)
            {
                arr.add(Integer.parseInt(str.substring(i,i+1)));
            }
            str += arr.get(0);
            counter = arr.get(0);
            for(int i=0;i<counter;i++)
            {
                ans+= "(";
                ans+= arr.get(i);
            }
            for(int i=1;i<arr.size();i++)
            {
                if(arr.get(i)>arr.get(i-1))
                {
                    for(int p=0;p<(arr.get(i)-arr.get(i-1));p++)
                        ans+= "(";
                    counter = arr.get(i);
                }
                if(arr.get(i)<arr.get(i-1))
                {
                    for(int p=0;p<(arr.get(i-1)-arr.get(i));p++)
                        ans+= ")";
                    counter = arr.get(i-1);
                }
                ans+= arr.get(i);
            }
            for(int i=0;i<counter;i++)
            {
                ans+= ")";
            }
            arr.clear();
            out.println("Case #" + i +": " + ans);
        }
        out.close();
    }
}