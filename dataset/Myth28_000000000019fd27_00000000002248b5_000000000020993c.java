import java.util.*;
class Solution
{
public static void main(String[]args)
{
Scanner in = new Scanner(System.in);
int t = in.nextInt();
int k=1;
while(t-->0)
{
int n = in.nextInt();
int arr[][] = new int[n][n];
int sum=0;
for(int i=0;i<n;i++)
{
    for(int j=0;j<n;j++)
    {
        int e = in.nextInt();
        arr[i][j] = e;
        if(i==j)
        sum=sum+e;
    }
}

Set<Integer> s1 = new HashSet<Integer>();
Set<Integer> s2 = new HashSet<Integer>();
int r=0,c=0;
for(int i=0;i<n;i++)
{   
    for(int j=0;j<n;j++)
    {
       s1.add(arr[i][j]);
       s2.add(arr[j][i]);
    }
    if(s1.size()!=n)
    r++;
    if(s2.size()!=n)
    c++;
    s1.clear();
    s2.clear();
    
}

System.out.println("Case #"+k+": "+sum+" "+r+" "+c);
k++;
}
}
}


