import java.io.*;
import java.util.*;
import java.math.BigInteger;

public class Solution {
    
    public static void main(String args[]) throws IOException {
        Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        PrintWriter pw = new PrintWriter(System.out);
        int t = sc.nextInt();
        
        for (int k=1;k<=t;k++) {
            int u=sc.nextInt();
            char arr[] = new char[10];
            for(int i=0;i<10;i++)
                arr[i]='A';
            for(int i=0;i<10000;i++){
                char[] q=sc.next().toCharArray();
                char[] r=sc.next().toCharArray();
                if(q[0]=='-'){
                    continue;
                }
                for(int j=0;j<q.length;j++){
                    arr[q[j]-'0']=r[j];
                }
            }

            pw.println("Case #"+k+": "+new String(arr));
            
        }
        pw.close();

    }

  
}


