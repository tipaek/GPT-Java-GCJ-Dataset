import java.util.*;
import java.io.*;
//public
 public class Solution {
    public static void main(String[] args) throws IOException{
        Scan sc = new Scan();
        Print print = new Print();
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int t = sc.scanInt();
        int t1=1;
        while(t1<=t){
            String n=sc.scanString();
            Stack<Character> s=new Stack<>();
            for(int i=0;i<n.length();i++)
                s.push(n.charAt(i));
            char c=s.pop();
            int s_pop=Character.getNumericValue(c);
            Stack<Character> fs=new Stack<>();
            while(s_pop-->0){
                fs.push(')');
            }
            fs.push(c);
            while(!s.isEmpty()){
                char pop=s.pop();
                s_pop=Character.getNumericValue(pop);
                char top=fs.pop();
                int fs_top=Character.getNumericValue(top);
                fs.push(top);
                int diff=fs_top-s_pop;
                if(diff<0) {
                    while (diff++ < 0) {
                        fs.push(')');
                    }
                }else {
                    while (diff-- > 0) {
                        fs.push('(');
                    }
                }
                fs.push(pop);

            }
//            System.out.println(fs);
            int first=Character.getNumericValue(n.charAt(0));
            while(first-->0){
                fs.push('(');
            }
            String res="";
            while(!fs.isEmpty()){
                res=res+fs.pop();
            }

            bw.write("Case #"+t1+": "+res+"\n");
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