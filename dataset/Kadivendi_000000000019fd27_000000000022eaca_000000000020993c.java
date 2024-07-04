import java.util.*;
public class Solution {

    public static void main(String[] args) {
       Scanner sc=new Scanner(System.in);
       int t=sc.nextInt();
        int ch=0;
       while(t-->0){
                int n=sc.nextInt();
                HashSet<Integer> temp=new HashSet();
                int[][] arr=new int[n][n];
                int sum=0;
                int r=0;
                int c=0;
                for(int i=0;i<n;i++)
                {
                    for(int j=0;j<n;j++)
                    {
                        arr[i][j]=sc.nextInt();
                        temp.add(arr[i][j]);
                    }
                    if(temp.size()!=n)
                            r++;
                    temp.clear();
                    sum=sum+arr[i][i];
                }
                for(int i=0;i<n;i++)
                {
                    for(int j=0;j<n;j++)
                    {
                        temp.add(arr[j][i]);
                    }
                    if(temp.size()!=n)
                            c++;
                    temp.clear();
                }
                ch++;
                System.out.println("Case #"+ch+": "+sum+" "+r+" "+c);
       }

    }
}

