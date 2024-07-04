import java.util.*;
class Solution
{
    public static String cj(int A[],int B[],int n)
    {
        char c[] = new char[n];
        c[0] = 'C';
        int cend = B[0];
        int jend = 0;
        for(int i = 1;i<n;i++)
        {
            if(A[i]>=cend)
            {
                c[i] = 'C';
                cend = B[i];
            }
            else if(A[i]>=jend)
            {
                c[i] = 'J';
                jend = B[i];
            }
            else
            {
                String s = "IMPOSSIBLE";
                return s;
            }
        }
        String s = new String(c);
        return s;
    }
    public static void main(String args[])
    {
        int n,t,test_case = 1;
        Scanner sc = new Scanner(System.in);
        t = sc.nextInt();
        while(t>0)
        {
            n = sc.nextInt();
            int A[] = new int[n];
            int B[] = new int[n];
            int C[] = new int[n];
            HashMap<Integer,Integer> map = new HashMap<Integer,Integer>();
            for(int i =0;i<n;i++)
            {
                A[i] = sc.nextInt();
                C[i] = sc.nextInt();
                map.put(A[i],i);
            }
            Arrays.sort(A);
            for(int i =0;i<n;i++)B[i] = C[map.get(A[i])];
            String s = cj(A,B,n);
            System.out.println("Case #"+(test_case++)+": "+s);
            t--;
        }
    }
}
/*#include <iostream>
#include <bits/stdc++.h>
using namespace std;
int main()
{
    int n,t,test_case=1;
    cin>>t;
    while(t--)
    {
        cin>>n;
        int *start = new int[n];
        int *end = new int[n];
        for(int i =0;i<n;i++)
        {
            cin>>start[i]>>end[i];
        }
        
    }
    return 0;
}
*/