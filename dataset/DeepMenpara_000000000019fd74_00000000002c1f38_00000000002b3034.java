import sun.applet.resources.MsgAppletViewer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Solution{
    public static void main(String args[]) {

        FastReader sc = new FastReader();
        int t = sc.nextInt();
        int titer=0;
        int i=0,j=0,k=0;

        String temp="";
        char star=42;
        for (titer=0;titer<t;titer++)
        {
            List<String> strlist = new ArrayList<String>();
            int n=sc.nextInt();
            String finalstr="";
            String strarr[]=new String[n];
            int start=0;
            int end=0;
            String endstring="";
            String startstring="";
            String startstrarr[]=new String[n];
            String endstrarr[]=new String[n];
            int maxstartstrlenind=-1;
            int maxendstrlenind=-1;
            int maxindex=0;
            int maxstar=0;
            for (i=0;i<n;i++)
            {
                strarr[i]=sc.nextLine();
                strarr[i] = strarr[i].replaceAll("\\s+","");
                int indexcount=0;
                int lastind=0;
                boolean incstart=true;
                boolean incend=true;
                int index = strarr[i].indexOf("*");
                if(index>0)
                {
                    if (maxstartstrlenind==-1)
                    {
                        maxstartstrlenind=0;
                    }
                    startstring=strarr[i].substring(0,index);
                    startstrarr[start]=startstring;
                    if (startstring.length()>startstrarr[maxstartstrlenind].length())
                    {
                        maxstartstrlenind=start;
                    }
                    start++;
                    incstart=false;
                }
                while(index >= 0) {
                    lastind=index;
                    index = strarr[i].indexOf("*",index+1);
                    indexcount++;
                }

                if ((lastind!=strarr[i].length()-1))
                {
                    if (maxendstrlenind==-1)
                    {
                        maxendstrlenind=0;
                    }
                    endstring=strarr[i].substring(lastind+1);
                    endstrarr[end]=endstring;
                    if (endstring.length()>endstrarr[maxendstrlenind].length())
                    {
                        maxendstrlenind=end;
                    }
                    end++;
                    incend=false;
                }
                String temparr[]=strarr[i].split("\\*");
                for (j=0;j<temparr.length;j++)
                {
                    if (j==0 && !incstart)
                    {

                    }
                    else if (j==temparr.length-1 && !incend)
                    {

                    }
                    else
                    {
                        if ((!strlist.contains(temparr[j])))
                            strlist.add(temparr[j]);
                    }
                }
                if (indexcount>maxstar)
                {
                    maxstar=indexcount;
                    maxindex=i;
                }
            }
            boolean endbool=true;
            boolean startbool=true;
            for (k=0;k<start;k++)
            {
                if (k!=maxstartstrlenind)
                {
                    if (!(startstrarr[maxstartstrlenind].indexOf(startstrarr[k])>=0))
                    {
                        //System.out.println(startstrarr[maxstartstrlenind]+"============"+startstrarr[k]);
                        startbool=false;
                    }
                }
            }

            for (k=0;k<end;k++)
            {
                if (k!=maxendstrlenind)
                {
                    if (endstrarr[maxendstrlenind]!=null && !(endstrarr[maxendstrlenind].indexOf(endstrarr[k])>=0))
                    {
                        endbool=false;
                    }
                }
            }


            //System.out.println(startbool+"============"+endbool);
            if (startbool && endbool)
            {
                if (maxstartstrlenind!=-1 && startstrarr[maxstartstrlenind]!=null)
                    finalstr+=startstrarr[maxstartstrlenind]+"X";

                String loopstrs[]=strarr[maxindex].split("\\*");
                int liindexer=0;
                for (k=0;k<loopstrs.length;k++)
                {
                    if (liindexer<strlist.size() && strlist.get(liindexer)=="")
                    {
                        while (liindexer<strlist.size() && strlist.get(liindexer)!="")
                        {
                            liindexer++;
                        }
                    }
                    if (liindexer<strlist.size() && strlist.get(liindexer)!="")
                    {
                        if (k==loopstrs.length-1)
                        {
                            while (liindexer<strlist.size())
                            {
                                finalstr+=strlist.get(liindexer)+temp;
                                liindexer++;
                            }
                        }
                        else
                        {
                            finalstr+=strlist.get(liindexer);
                            liindexer++;
                        }


                    }
                    else
                    {

                            finalstr+=temp;

                    }

                }
                if (maxendstrlenind!=-1 && endstrarr[maxendstrlenind]!=null)
                    finalstr+="X"+endstrarr[maxendstrlenind];
                System.out.println("Case #"+(titer+1)+": "+finalstr);
            }
            else
            {
                System.out.println("Case #"+(titer+1)+": *");
            }





        }

        //System.out.println("Case #"+(test+1)+": "+sum+" "+unirow+" "+unicol);

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


