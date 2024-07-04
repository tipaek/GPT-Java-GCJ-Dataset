    import java.util.*;
    class Solution
    {
        public static String partner(int s[], int f[], int n) 
        { 
            ArrayList<Integer> x = new ArrayList<Integer>();
            ArrayList<Integer> y = new ArrayList<Integer>();
            
            for(int i=0;i<n;i++)
            {
                x.add(s[i]);
                y.add(f[i]);
            }
            ArrayList<Integer> xx = new ArrayList<Integer>(x);
            Collections.sort(x);
            
            for(int i=0;i<n;i++)
            {
                int l=x.indexOf(s[i]);
                f[l]=y.get(i);
            }
            int i, j; 
            i = 0; 
            char a[]=new char[n];
            a[0]='J';
            for (j = 1; j < n; j++) 
            { 
                if (x.get(j) >= f[i]) 
                {
                //    int l=x.indexOf(s[j]);
                    a[j]='J';
                    i = j; 
                } 
            }
            int c=0;
            for(int k=0;k<n;k++)
            {
                if(a[k]=='J')
                    c++;
            }
            if(c==1)
                return "IMPOSSIBLE";
            for(int k=0;k<n;k++)
            {
                if(a[k]!='J')
                    a[k]='C';
            }
            char b[]=new char[n];
            for(int k=0;k<n;k++)
            {
                b[k]=a[xx.indexOf(x.get(k))];
            }
            return new String(b);
        }
        public static void main(String s[])
        {
            Scanner sc = new Scanner(System.in);
            int t=sc.nextInt();
            int x=1;
            while(x++<=t)
            {
                int n=sc.nextInt();
                int a[]=new int[n];
                int b[]=new int[n];
                for(int i=0;i<n;i++)
                {
                    a[i]=sc.nextInt();
                    b[i]=sc.nextInt();
                }
                System.out.println("Case #"+(x-1)+": "+partner(a,b,n));
            }
        }
    }