/* package codechef; // don't place package name! */

import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
public class Solution
{
    static class Interval{
    int start,end;
    String s;
    Interval(){
        start=0;
        end=0;
        s="";
    }
    Interval( int s1,int e,String c){
        start =s1;
        end=e;
        s=c;
    }
    }

//        1
//        8
//        99 150
//        1 100
//        100 301
//        2 5
//        150 250
//        360 480
//        420 540
//        600 660

    public static boolean overlaps(Interval i1,Interval i2){
//        how to deterimne if two intervals intersect
//        a.start < b.end && b.start < a.end;
//        if(i1.start<i2.end && i2.start<i1.end)
//            return true;
//        if(i1.start<i2.end&&i1.start>i2.start)
//            return true;
//        if(i1.end<i2.end&&i1.end>i2.start)
//            return true;
//        if(i2.start<i1.end&&i2.start>i1.start)
//            return true;
//        if(i2.end<i1.end&&i2.end>i1.start)
//            return true;
//        return false;
//        If ( NOT (EndA <= StartB or StartA >= EndB)
        if(!(i1.end <= i2.start || i1.start>=i2.end))
            return true;
        return false;

    }


    public static void sortIntervalByEndValue(Interval[] intervals){
    Arrays.sort(intervals, new Comparator<Interval>() {
        @Override
        public int compare(Interval i1, Interval i2) {
//            how we determine which one is bigger?
//            what to do when the intervals have same end value
            return i1.end-i2.end;
        }
    });
    }








    public static void main (String[] args) throws java.lang.Exception
    {
        Scan sc=new Scan();
        Print print=new Print();
//        BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
        int t=sc.scanInt(),size=1000001;
        int t1=1;
        while(t1<=t) {
        int n=sc.scanInt();


        Interval[] intervals=new Interval[n];
        for(int i=0;i<n;i++){
            intervals[i]=new Interval(sc.scanInt(),sc.scanInt(), "");
        }
         Interval[] old=Arrays.copyOf(intervals,intervals.length);
        if(n<=2){
            if(!overlaps(intervals[0],intervals[1]))
                System.out.println("Case #"+t1+": CC");
        }
        else {
            char c[]=new char[n];
            c[0]='C';
            intervals[0].s="C";

//            System.out.println();
//            for(int i=0;i<intervals.length;i++){
            int l=0;
            List<Interval> li=new ArrayList<>();
            li.add(intervals[0]);
                for(int j=0;j<intervals.length;j++){
                    if(intervals[j].s.isEmpty()){
                        if(!overlaps(intervals[l],intervals[j])) {
                                int flag=0;
                                for (int p = 0; p < li.size(); p++) {
                                    if(overlaps(intervals[j],li.get(p)))
                                        flag++;
                                                    
                                }
                            if(flag==0){
                                intervals[j].s = "C";
//                            System.out.println(intervals[j].start+" "+intervals[j].end);
                                li.add(intervals[j]);
                            }

                        }
                    }
                }
//            for(int i=0;i<intervals.length;i++){
//System.out.print("["+intervals[i].start+" "+intervals[i].end+" "+intervals[i].s+"]  ");
//            }
            for(int j=0;j<intervals.length;j++){
                if(intervals[j].s.isEmpty()){
                    l=j;
                    break;
                }
            }
            li=new ArrayList<>();
            li.add(intervals[l]);
            intervals[l].s="J";
//            System.out.println(li.get(0).start);
            for(int j=l;j<intervals.length;j++) {
                if (intervals[j].s.isEmpty()) {
//                    if (!overlaps(intervals[l], intervals[j]))
//                        intervals[j].s = "J";

                    if (!overlaps(intervals[l], intervals[j])) {
                        int flag = 0;
                        for (int p = 0; p < li.size(); p++) {
                            if (overlaps(intervals[j], li.get(p)))
                                flag++;

                        }
                        if (flag == 0){
                            intervals[j].s = "J";
                        li.add(intervals[j]);
                        }
//                        intervals[j].s = "C";
//                        System.out.println(intervals[j].start+" "+intervals[j].end);
//                        li.add(intervals[j]);
                    }
                }
            }

            int res=0;
            for(int i=0;i<intervals.length;i++){
                if(intervals[i].s.isEmpty()){
                    System.out.println("Case #"+t1+": IMPOSSIBLE");
                    res=-1;
                    break;
                }
            }
            if(res==0){
                System.out.print(("Case #"+t1+": "));
                for(int i=0;i<intervals.length;i++){
                    System.out.print(intervals[i].s);
                }
                System.out.println();
//                bw.write("\n");
            }

//            for(int i=0;i<intervals.length;i++){
//System.out.print("["+intervals[i].start+" "+intervals[i].end+" "+intervals[i].s+"]  ");
//            }
        }
        t1++;
        }

    }


    static class Print
    {
        private final OutputStream out;
        /*public Print(OutputStream outputStream)
        {
            writer=new PrintWriter(new BufferedWriter(new OutputStreamWriter(outputStream)));
        }*/
        public Print()
        {
            this.out=System.out;
        }
        public void print(String str)throws IOException
        {
            //buf=str.getBytes();
            for (int i = 0; i < str.length(); i++)
            {
			/*if (i != 0)
			out.write(' ');*/
                out.write(str.charAt(i));
            }
        }
        public void printLine(String str)throws IOException
        {
            print(str);
            out.write('\n');
        }
        public void close()throws IOException
        {
            out.close();
        }
    }


    static class Scan
    {
        private byte[] buf=new byte[1024];
        private int index;
        private InputStream in;
        private int total;
        public Scan()
        {
            in=System.in;
        }
        public int scan()throws IOException
        {
            if(total<0)
                throw new InputMismatchException();
            if(index>=total)
            {
                index=0;
                total=in.read(buf);
                if(total<=0)
                    return -1;
            }
            return buf[index++];
        }
        public int scanInt()throws IOException
        {
            int integer=0;
            int n=scan();
            while(isWhiteSpace(n))
                n=scan();
            int neg=1;
            if(n=='-')
            {
                neg=-1;
                n=scan();
            }
            while(!isWhiteSpace(n))
            {
                if(n>='0'&&n<='9')
                {
                    integer*=10;
                    integer+=n-'0';
                    n=scan();
                }
                else throw new InputMismatchException();
            }
            return neg*integer;
        }
        public double scanDouble()throws IOException
        {
            double doub=0;
            int n=scan();
            while(isWhiteSpace(n))
                n=scan();
            int neg=1;
            if(n=='-')
            {
                neg=-1;
                n=scan();
            }
            while(!isWhiteSpace(n)&&n!='.')
            {
                if(n>='0'&&n<='9')
                {
                    doub*=10;
                    doub+=n-'0';
                    n=scan();
                }
                else throw new InputMismatchException();
            }
            if(n=='.')
            {
                n=scan();
                double temp=1;
                while(!isWhiteSpace(n))
                {
                    if(n>='0'&&n<='9')
                    {
                        temp/=10;
                        doub+=(n-'0')*temp;
                        n=scan();
                    }
                    else throw new InputMismatchException();
                }
            }
            return doub*neg;
        }
        public String scanString()throws IOException
        {
            StringBuilder sb=new StringBuilder();
            int n=scan();
            while(isWhiteSpace(n))
                n=scan();
            while(!isWhiteSpace(n))
            {
                sb.append((char)n);
                n=scan();
            }
            return sb.toString();
        }
        private boolean isWhiteSpace(int n)
        {
            if(n==' '||n=='\n'||n=='\r'||n=='\t'||n==-1)
                return true;
            return false;
        }
    }

}
