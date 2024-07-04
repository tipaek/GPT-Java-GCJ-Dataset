import java.math.*;
import java.util.*;
import java.lang.*;
import java.io.*;


class Solution {
    static class FastReader {
        BufferedReader br;
        StringTokenizer st;

        public FastReader() {
            br = new BufferedReader(new
                    InputStreamReader(System.in));
        }

        String next() {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }

        long nextLong() {
            return Long.parseLong(next());
        }

        double nextDouble() {
            return Double.parseDouble(next());
        }

        String nextLine() {
            String str = "";
            try {
                str = br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }
    }

    public static void main(String[] args) {
        FastReader sc = new FastReader();

        int t,n;
        t=sc.nextInt();
        for(int i=0;i<t;i++)
        {
            n=sc.nextInt();
            int m[][]=new int[n][2];
            for(int j=0;j<n;j++)
            {
                m[j][0]=sc.nextInt();
                m[j][1]=sc.nextInt();
            }

            TreeMap<Integer, Integer> mp1=new TreeMap<>();
            TreeMap<Integer, Integer> mp2=new TreeMap<>();
            TreeMap<Integer, Integer> mp3=new TreeMap<>();

            mp1.put(m[0][0],m[0][1]);

            int x=0;
            int flag=0;
            for(int j=1;j<n;j++)
            {
                if(!mp1.containsKey(m[j][0])) {
                    mp1.put(m[j][0], m[j][1]);
                    x = check(mp1);
                    if(x==m[j][0]||x!=-1)
                    {
                        if(mp2.containsKey(m[j][0]))
                        {
                            flag=1;
                            break;
                        }
                        else {
                            mp2.put(m[j][0], m[j][1]);
                            x = check(mp2);
                            if (x == m[j][0]||x!=-1) {
                                flag = 1;
                                break;
                            } else if (x == -1) {
                                mp1.remove(m[j][0]);
                            }
                        }
                    }
                    else if(x==-1)
                    {
                        if(!mp2.containsKey(m[j][0])) {
                            mp2.put(m[j][0], m[j][1]);
                            x = check(mp2);
                            if (x == -1) {
                                mp2.remove(m[j][0]);
                                mp1.remove(m[j][0]);
                                if(!mp3.containsKey(m[j][0]))
                                    mp3.put(m[j][0], m[j][1]);
                                else
                                    mp1.put(m[j][0],m[j][1]);
                            } else if (x == m[j][0]||x!=-1) {
                                mp2.remove(m[j][0]);
                            }
                        }
                    }
                }
                else
                {
                    if(!mp2.containsKey(m[j][0]))
                    {
                        mp2.put(m[j][0], m[j][1]);
                        x = check(mp2);
                        if(x==m[j][0]||x!=-1)
                        {
                            flag=1;
                            break;
                        }
                    }
                    else
                    {
                        flag=1;
                        break;
                    }
                }

            }

            for(Integer key : mp3.keySet())
            {
                int val = mp3.get(key);
                mp1.put(key, val);
                int z=check(mp1);
                if(z==key)
                {
                    mp1.remove(key);
                    mp2.put(key,val);
                    if(check(mp2)!=-1)
                    {
                        flag=1;
                        break;
                    }
                   // mp3.remove(key);
                }
            }

            if(flag==1)
                System.out.println("Case #"+(i+1)+": IMPOSSIBLE");
            else
            {
                String s="J";
                for(int j=1;j<n;j++)
                {
                    if(mp1.containsKey(m[j][0]))
                        s=s+"J";
                    else
                        s=s+"C";
                }

                System.out.println("Case #"+(i+1)+": "+s);
            }
        }




    }

    static int check(TreeMap<Integer,Integer> mp)
    {
        int k2=0,v2=0;
        for(Integer key : mp.keySet())
        {
            int k1=key;
            int v1=mp.get(k1);
            if(k2<k1&&v2>k1)
                return k1;
            k2=k1;
            v2=v1;
        }
        return -1;
    }
}