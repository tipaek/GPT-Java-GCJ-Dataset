//package codegam2020.qualification.nestingdepth;

/**
 * tc
 * i/p:
 15
 021
 312
 4
 221
 19
 91
 193
 391
 0246891
 1986421
 0123456789
 9876543210
 01233210
 2587657894251
 252416893548
 o/p:
 0((2)1)
 (((3))1(2))
 ((((4))))
 ((22)1)
 (1((((((((9)))))))))
 (((((((((9))))))))1)
 (1((((((((9))))))3)))
 (((3((((((9))))))))1)
 0((2((4((6((8(9))))))))1)
 (1((((((((9)8))6))4))2)1)
 0(1(2(3(4(5(6(7(8(9)))))))))
 (((((((((9)8)7)6)5)4)3)2)1)0
 0(1(2(33)2)1)0
 ((2(((5(((8)7)6)5((7(8(9)))))4))2(((5))))1)
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class Solution {
    BufferedReader in;
    PrintWriter out;
    StringTokenizer tok = new StringTokenizer("");
    String opens = "(((((((((((";
    String closes = ")))))))))))";

    public static void main(String[] args) {
        new Solution().run();
    }

    public void run() {
        try {
            in = new BufferedReader(new InputStreamReader(System.in));
            out = new PrintWriter(System.out);
            solve();
            in.close();
            out.close();
        } catch (Throwable t) {
            t.printStackTrace(System.err);
            System.exit(-1);
        }
    }

    String readString() throws IOException {
        while (!tok.hasMoreTokens()) {
            tok = new StringTokenizer(in.readLine());
        }
        return tok.nextToken();
    }

    int readInt() throws IOException {
        return Integer.parseInt(readString());
    }

    long readLong() throws IOException {
        return Long.parseLong(readString());
    }

    double readDouble() throws IOException {
        return Double.parseDouble(readString());
    }
    // solution

    String getOpens(int no){
        return no>0?opens.substring(0,no):"";
    }
    String getClosess(int no){
        return no>0?closes.substring(0,no):"";
    }
    void solve() throws IOException {
        int tc = readInt();
        for (int t = 1; t <= tc; ++t) {
            char[] all = readString().toCharArray();
            StringBuilder sb = new StringBuilder();
            int rOpen = 0;
            int rClose = 0;
            int cOpen = 0;
            int previous = -1;
            String tmp="";
            for(int i=0;i<= all.length;i++){
                int  no = i==all.length?-1:all[i]-'0';
                if(previous==-1){
                    tmp+=no;
                    rOpen=no;
                    rClose=no;
                    previous=no;
                    continue;
                }
                if(previous==no){
                    tmp+=no;
                    continue;
                }
                //handle previous
                switch (no) {
                    case 0:
                        //close all pending and load tmp
                        if(rOpen>0)
                            sb.append(getOpens(rOpen));
                        rOpen=0;
                        if(tmp.length()>0)
                            sb.append(tmp);
                        if(rClose>0)
                            sb.append(getClosess(rClose));
                        rClose=0;
                        break;
                    case 1:
                        if(rOpen==0 && previous>no){
                                rOpen=0;
                        }
                        else if(rOpen>=1) {
                            sb.append(getOpens(rOpen));
                            rOpen=0;
                        }
                        else
                            rOpen=1;
                        if(tmp.length()>0)
                            sb.append(tmp);
                        if(rClose>1)
                            sb.append(getClosess(rClose-1));
                        rClose=1;
                        break;
                    case 2:
                        if(rOpen==0 && previous>-1){
                           if(previous<no)
                               rOpen=2-previous;
                        }
                        else if(rOpen>=2) {
                            sb.append(getOpens(rOpen));
                            rOpen=0;
                        }else if(rOpen<2){
                            sb.append(getOpens(rOpen));
                            cOpen+=rOpen;
                            if(previous<2) {
                                rOpen = 2 - previous;
                            }else
                                rOpen=0;
                        }
                        if(tmp.length()>0)
                            sb.append(tmp);
                        if(rClose>2) {
                            sb.append(getClosess(rClose - 2));
                        }
                        rClose=2;
                        break;
                    case 3:
                        if(rOpen==0 && previous>-1){
                            if(previous<no)
                                rOpen=3-previous;
                        }
                        else if(rOpen>=3) {
                            sb.append(getOpens(rOpen));
                            rOpen=0;
                        }else if(rOpen<3){
                            sb.append(getOpens(rOpen));
                            cOpen+=rOpen;
                            if(previous<3) {
                                rOpen = 3 - previous;
                            }else
                                rOpen=0;
                        }
                        if(tmp.length()>0)
                            sb.append(tmp);
                        if(rClose>3) {
                            sb.append(getClosess(rClose - 3));
                        }
                        rClose=3;
                        break;
                    case 4:
                        if(rOpen==0 && previous>-1){
                            if(previous<no)
                                rOpen=4-previous;
                        }
                        else if(rOpen>=4) {
                            sb.append(getOpens(rOpen));
                            rOpen=0;
                        }else if(rOpen<4){
                            sb.append(getOpens(rOpen));
                            cOpen+=rOpen;
                            if(previous<4) {
                                rOpen = 4 - previous;
                            }else
                                rOpen=0;
                        }
                        if(tmp.length()>0)
                            sb.append(tmp);
                        if(rClose>4) {
                            sb.append(getClosess(rClose - 4));
                        }
                        rClose=4;
                        break;
                    case 5:
                        if(rOpen==0 && previous>-1){
                            if(previous<no)
                                rOpen=5-previous;
                        }
                        else if(rOpen>=5) {
                            sb.append(getOpens(rOpen));
                            rOpen=0;
                        }else if(rOpen<5){
                            sb.append(getOpens(rOpen));
                            if(previous<5) {
                                rOpen = 5 - previous;
                            }else
                                rOpen=0;
                        }
                        if(tmp.length()>0)
                            sb.append(tmp);
                        if(rClose>5) {
                            sb.append(getClosess(rClose - 5));
                        }
                        rClose=5;
                        break;
                    case 6:
                        if(rOpen==0 && previous>-1){
                            if(previous<no)
                                rOpen=6-previous;
                        }
                        else if(rOpen>=6) {
                            sb.append(getOpens(rOpen));
                            rOpen=0;
                        }else if(rOpen<6){
                            sb.append(getOpens(rOpen));
                            if(previous<6) {
                                rOpen = 6 - previous;
                            }else
                                rOpen=0;
                        }
                        if(tmp.length()>0)
                            sb.append(tmp);
                        if(rClose>6) {
                            sb.append(getClosess(rClose - 6));
                        }
                        rClose=6;
                        break;
                    case 7:
                        if(rOpen==0 && previous>-1){
                            if(previous<no)
                                rOpen=7-previous;
                        }
                        else if(rOpen>=7) {
                            sb.append(getOpens(rOpen));
                            rOpen=0;
                        }else if(rOpen<7){
                            sb.append(getOpens(rOpen));
                            if(previous<7) {
                                rOpen = 7 - previous;
                            }else
                                rOpen=0;
                        }
                        if(tmp.length()>0)
                            sb.append(tmp);
                        if(rClose>7) {
                            sb.append(getClosess(rClose - 7));
                        }
                        rClose=7;
                        break;
                    case 8:
                        if(rOpen==0 && previous>-1){
                            if(previous<no)
                                rOpen=8-previous;
                        }
                        else if(rOpen>=8) {
                            sb.append(getOpens(rOpen));
                            rOpen=0;
                        }else if(rOpen<8){
                            sb.append(getOpens(rOpen));
                            if(previous<8) {
                                rOpen = 8 - previous;
                            }else
                                rOpen=0;
                        }
                        if(tmp.length()>0)
                            sb.append(tmp);
                        if(rClose>8) {
                            sb.append(getClosess(rClose - 8));
                        }
                        rClose=8;
                        break;
                    case 9:
                        if(rOpen==0 && previous>-1){
                            if(previous<no)
                                rOpen=9-previous;
                        }
                        else if(rOpen>=9) {
                            sb.append(getOpens(rOpen));
                            rOpen=0;
                        }else if(rOpen<9){
                            sb.append(getOpens(rOpen));
                            if(previous<9) {
                                rOpen = 9 - previous;
                            }else
                                rOpen=0;
                        }
                        if(tmp.length()>0)
                            sb.append(tmp);
                        if(rClose>9) {
                            sb.append(getClosess(rClose - 9));
                        }
                        rClose=9;
                        break;
                    default:
                        //last
                        if(rOpen>0)
                            sb.append(getOpens(rOpen));
                        if(tmp.length()>0)
                            sb.append(tmp);
                        if(rClose>0)
                            sb.append(getClosess(rClose));
                }
                tmp=""+no;
                previous = no;
            }
            System.out.println(String.format("Case #%s: %s",t,sb.toString()));
        }
        return;
    }
}
