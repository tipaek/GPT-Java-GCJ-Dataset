import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String args[])
    {
        FastReader sc=new FastReader();
        int t=sc.nextInt();
        int i=0,j=0,k=0;
        for (int testcase=0;testcase<t;testcase++)
        {
            int x=sc.nextInt();
            int y=sc.nextInt();
            if (x%2!=0 && y%2!=0)
            {
                System.out.println("Case #"+(testcase+1)+": "+"IMPOSSIBLE");
                continue;
            }
            boolean POSSIBLE=true;
            int curx=0;
            int cury=0;

            int xdist=Math.abs(x-curx);
            int ydist=Math.abs(y-cury);
            int tempdistx=xdist;
            int tempdisty=ydist;
            String direction="";
            if (x%2!=0)
            {
                if (ydist==0 || xdist<ydist)
                {
                    if (x<0)
                    {
                        direction+="W";
                        curx-=1;
                    }
                    else
                    {
                        curx=curx+1;
                        direction+="E";
                    }
                }
                else if (ydist<xdist)
                {
                    if (x<0)
                    {
                        direction+="E";
                        curx+=1;
                    }
                    else
                    {
                        curx=curx-1;
                        direction+="W";
                    }
                }
                else
                    POSSIBLE=false;
            }
            else if (y%2!=0)
            {
                if(xdist==0||ydist<xdist)
                {
                    if (y<0)
                    {
                        direction+="S";
                        cury-=1;
                    }
                    else
                    {
                        cury=cury+1;
                        direction+="N";
                    }

                }
                else if (xdist<ydist)
                {
                    if (y<0)
                    {
                        direction+="N";
                        cury+=1;
                    }
                    else
                    {
                        cury=cury-1;
                        direction+="S";
                    }
                }
                else
                    POSSIBLE=false;

            }
             xdist=Math.abs(x-curx);
             ydist=Math.abs(y-cury);
             tempdistx=xdist;
             tempdisty=ydist;


            if (tempdistx<tempdisty)
            {
                while (tempdistx>1)
                {
                    if (tempdistx%2==0)
                    {
                        if (x<0)
                        {
                            direction+="W";
                        }
                        else
                            direction+="E";
                        tempdistx=tempdistx/2;
                    }
                    else
                    {
                        POSSIBLE=false;
                        break;
                    }
                    if (tempdisty%2==0)
                    {
                        tempdisty=tempdisty/2;
                    }
                    else
                    {
                        POSSIBLE=false;
                        break;
                    }

                }

                while (tempdisty>1)
                {
                    if (tempdisty%2==0)
                    {
                        if (y<0)
                        {
                            direction+="S";
                        }
                        else
                            direction+="N";
                        tempdisty=tempdisty/2;
                    }
                    else
                    {
                        POSSIBLE=false;
                        break;
                    }
                }

            }
            else if (tempdisty<tempdistx)
            {
                while (tempdisty>1)
                {
                    if (tempdisty%2==0)
                    {
                        if (y<0)
                        {
                            direction+="S";
                        }
                        else
                            direction+="N";
                        tempdisty=tempdisty/2;
                    }
                    else
                    {
                        POSSIBLE=false;
                        break;
                    }
                    if (tempdistx%2==0)
                    {
                        tempdistx=tempdistx/2;
                    }
                    else
                    {
                        POSSIBLE=false;
                        break;
                    }

                }

                while (tempdistx>1)
                {
                    if (tempdistx%2==0)
                    {
                        if (x<0)
                        {
                            direction+="W";
                        }
                        else
                            direction+="E";
                        tempdistx=tempdistx/2;
                    }
                    else
                    {
                        POSSIBLE=false;
                        break;
                    }
                }
            }
            else
            {
                POSSIBLE=false;
            }


            if (POSSIBLE)
                System.out.println("Case #"+(testcase+1)+": "+direction);
            else
                System.out.println("Case #"+(testcase+1)+": "+"IMPOSSIBLE");




        }


    }



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
}
