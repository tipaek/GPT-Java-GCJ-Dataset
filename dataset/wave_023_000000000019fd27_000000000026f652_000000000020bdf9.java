import java.util.*;
class Activity
{
    int start;
    int end;
    Activity(int a,int b)
    {
        start = a;
        end = b;
    }
}
class Solution
{
    public static String cj(ArrayList<Activity> A,int n)
    {
        char c[] = new char[n];
        c[0] = 'C';
        int cend = A.get(0).end;
        int jend = 0;
        for(int i = 1;i<n;i++)
        {
            if(A.get(i).start>=cend)
            {
                c[i] = 'C';
                cend = A.get(i).end;
            }
            else if(A.get(i).start>=jend)
            {
                c[i] = 'J';
                jend = A.get(i).end;
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
        int n,start,end,t,test_case = 1;
        Scanner sc = new Scanner(System.in);
        t = sc.nextInt();
        while(t>0)
        {
            n = sc.nextInt();
            ArrayList<Activity> A = new ArrayList<Activity>();
            for(int i =0;i<n;i++)
            {
                start = sc.nextInt();
                end  = sc.nextInt();
                A.add(new Activity(start,end));
            }
            Collections.sort(A, new Comparator<Activity>() {
            @Override
            public int compare(Activity a1, Activity a2) {
                if(a1.start!=a2.start)return a1.start-a2.start;
                return a1.end-a2.end;
            }
             });
            String s = cj(A,n);
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