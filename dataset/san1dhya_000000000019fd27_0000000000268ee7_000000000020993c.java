import java.util.HashSet;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        //insert code here
    Scanner  sc=new Scanner(System.in);
    int t=sc.nextInt();
    for(int x=1;x<=t;x++){
        int n=sc.nextInt();
        long a[][]=new  long[n][n];
        int r=0,c=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                a[i][j]=sc.nextLong();
            }
        }
        for(int i=0;i<n;i++){
            HashSet<Long> hs=new HashSet<>();
            for(int j=0;j<n;j++){
            if(hs.contains(a[i][j]))
            {
                r++;
                break;
            }
            else
                hs.add(a[i][j]);
            }
        }
        for(int i=0;i<n;i++){
            HashSet<Long> hs=new HashSet<>();
            for(int j=0;j<n;j++){
                if(hs.contains(a[j][i]))
                {
                    c++;
                    break;
                }
                else
                    hs.add(a[j][i]);
            }
        }
        long pro=0;
        for(int i=0;i<n;i++){
            pro+=a[i][i];
        }
       System.out.println("Case #"+x+": "+pro+" "+r+" "+c);
    }
    }
}
