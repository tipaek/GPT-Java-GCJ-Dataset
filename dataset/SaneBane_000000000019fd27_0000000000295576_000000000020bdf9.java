/* package codechef; // don't place package name! */

import java.util.*;
import java.lang.*;
import java.io.*;

//public
 public class Solution 
{
    static class Interval{
    int start,end;
    Interval(){
        start=0;
        end=0;
    }
    Interval( int s,int e){
        start =s;
        end=e;
    }
    }

    public static HashMap<String,Character> eraseOverlapIntervals(Interval[] intervals,char var){
//    erase or return non overlapping
    sortIntervalByEndValue(intervals);
    int intervalsRemoved=0;
    int lastValidIntervalIndex=0,prv=0;
    HashMap<String,Character> res=new HashMap<>();
    char ar[]=new char[intervals.length];
    for(int i=1;i<intervals.length;i++){
//        inc count of interval removed
        if(overlaps(intervals[lastValidIntervalIndex],intervals[i])) {
            intervalsRemoved++;

        }
        else{
//            index interval which don't overlap
            //            ar[i]=var;
//            if(x[lastValidIntervalIndex]=='\0') {
                String mapStr = String.valueOf(intervals[lastValidIntervalIndex].start) + "," + String.valueOf(intervals[lastValidIntervalIndex].end);
                ar[lastValidIntervalIndex] = var;
                res.put(mapStr, var);
                prv = lastValidIntervalIndex;
                lastValidIntervalIndex = i;
//            }

        }

    }
    if(!overlaps(intervals[prv],intervals[lastValidIntervalIndex])) {
        String mapStr=String.valueOf(intervals[lastValidIntervalIndex].start)+","+String.valueOf(intervals[lastValidIntervalIndex].end);
        res.put(mapStr,var);
        ar[lastValidIntervalIndex] = var;
    }
//    return intervalsRemoved;
//        System.out.println(Arrays.toString(ar));
        return res;
    }

    public static boolean overlaps(Interval i1,Interval i2){
//        how to deterimne if two intervals intersect
        if(i1.end>i2.start)
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
        BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
        int t=sc.scanInt(),size=1000001;
        int t1=1;
        while(t1<=t) {
        int n=sc.scanInt();

        Interval[] intervals=new Interval[n];
        for(int i=0;i<n;i++){
            intervals[i]=new Interval(sc.scanInt(),sc.scanInt());
        }
            System.out.println();
            char C='J';
//            char ar[]=eraseOverlapIntervals(intervals,C);
//            System.out.println(Arrays.toString(ar));
            char ar[]=new char[n];
            Interval[] temp=Arrays.copyOf(intervals,intervals.length);
            HashMap<String,Character> res=eraseOverlapIntervals(intervals,C);
//            System.out.println(res);
//            for(int i=0;i<n;i++) {
//                String mapStr=String.valueOf(intervals[i].start)+","+String.valueOf(intervals[i].end);
//                ar[i] = (char)res.get(mapStr);
//            }
            Iterator hmIterator = res.entrySet().iterator();
            while (hmIterator.hasNext()){
                Map.Entry mapElement = (Map.Entry)hmIterator.next();
//                System.out.println(mapElement.getKey());
                String str[]=String.valueOf(mapElement.getKey()).split(",");
//                System.out.println(Arrays.toString(str));
                int start1=Integer.parseInt(str[0]);
                int end1=Integer.parseInt(str[1]);

//                System.out.println(start1+"  "+end1);
                int x=0;
                for(int i=0;i<temp.length;i++){

                    if(start1==temp[i].start&&end1==temp[i].end){
                        ar[i]='J';
                        x++;
                    }
                }
            }
            char ar2[]=new char[n];
            C='C';
            List<Interval> li=new ArrayList<>();
            int k=0;
            for(int i=0;i<temp.length;i++){
                if(ar[i]=='\0'){
                    k=i;
                    li.add(temp[i]);}
            }
            Interval[] next=new Interval[li.size()];
            for(int i=0;i<li.size();i++)
                next[i]=li.get(i);
            if(!li.isEmpty()) {
                if (li.size() == 1)
                    ar2[k] = 'C';
                else {
                    res = eraseOverlapIntervals(next, C);

                    Iterator hmI = res.entrySet().iterator();
                    while (hmI.hasNext()) {
                        Map.Entry mapElement = (Map.Entry) hmI.next();
//                System.out.println(mapElement.getKey());
                        String str[] = String.valueOf(mapElement.getKey()).split(",");
//                System.out.println(Arrays.toString(str));
                        int start1 = Integer.parseInt(str[0]);
                        int end1 = Integer.parseInt(str[1]);

//                System.out.println(start1+"  "+end1);
                        int x = 0;
                        for (int i = 0; i < temp.length; i++) {

                            if (start1 == temp[i].start && end1 == temp[i].end) {
                                ar2[i] = 'C';
                                x++;
                            }
                        }
                    }
                }
            }
//            System.out.println(Arrays.toString(ar));
//            System.out.println(Arrays.toString(ar2));
//            System.out.println("------------------------");



            String ans="";
            for(int i=0;i<intervals.length;i++){
                if(ar[i]=='\0'&&ar2[i]=='\0'){
//                    System.out.println();
                    bw.write("Case #"+t1+": IMPOSSIBLE"+"\n");
                    ans="";
                    break;
                }
                if(ar[i]=='J')
                    ans+=ar[i];
                if(ar2[i]=='C')
                    ans+=ar2[i];
            }
            if(!ans.equals(""))
                bw.write("Case #"+t1+": "+ans+"\n");
//            System.out.println("Case #"+t1+": "+k+" "+r+" "+c);
        t1++;
        }
        bw.close();
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
