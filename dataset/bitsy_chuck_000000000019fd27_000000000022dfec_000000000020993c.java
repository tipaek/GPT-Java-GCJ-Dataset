//
//                       "8,        .m8"
//                        I8Im    ,mI8"
//                        ,8I""I8,mI8m
//             "I8mm,    ,I8    I8 "I8,          ,m"
//                "I88I88I8m ,I8"   "I8""==mm ,mI8"
//        ___    ,mI8"    "8I8"      I8,  ,mI8I8"
//   .,mI8I8I8I8I88,      ,m8"      ,I8I8I8I888"
// "I8Im,       "I88,    ,8"      ,II8"     "88,
//    `"I8,        "I8, ,8"     ,I8"         "I8,
//       "I8m       "I888      ,I8"           "I8,
//         "8m        "I8      88"              "I8,
//          I8,        I8      88                 "I8,
//           88,       I8,     "I8                 "I8
//           "I8,      "I8,     "I8,                I8;.
//            "I8,      "I8,      "I8        .,mmmI8888888m,.
//              I8,      "I8,      I8,  .mI8I88"""". .. "I8888
//              "I8,      "I8      mI8I88"". . . . . .,m8"   "8
//               I8m,  __ ;I8   ,II88" . . . . .,;miI88"
//               "I88I8I88I88,,I88" . . . ,mmiiI8888"
//                ,I8". . ."I8I8". . . mi888888888"
//              ,I8 . . . .,I88I. . .i88888888888"
//             I8. . . .,mII88Ima. .i88888888888"
//            ,8"..,mI88I88I88I8Imi888888888888"
//            I8.,I8I"""        ""II88888888888
//           ;I8I8"                  ""I8888888
//           ""                         "I88888
//                                        "I888
//                                         "I88,
//                                          "I88
//                                           "88,
//                                            I88,              ______   __
//                           ______           "I88__        .mI88I88I88I88I88,
//                      .,mI88I88I88, ,mI88,   I88"""     ,mI8". . . . "I8,..8,
//                    ,I888' . . . "I88.\ "8,  I88      ,I8". . . .  / :;I8 \ 8,
//                  .mI8' . . .  / .:"I8.\ 88  "88,    ,8". . .  / .;mI8I8I8,\ 8
//                 ,I8'. . .  / . .:;,I8I8I888  I88   ,8". .  / .:mI8"'   "I8,:8
//                ,I8'. . . / . .:;,mI8"  `"I88 I88   I8. .  / .m8"         "I8I
//               ,I8 . .  / . .:;,mI8"      "I88888   88,.  / ,m8            "8'
//               I8'. .  / . .;,mI8"          "II888 ,I8I8,.,I8"
//               I8 . . / . .,mI8"              I8888888' """
//               `I8,.  / ;,mI8"                 II888
//                "I8I, /,mI8"                 __I888
//                  "I8888"                   """I88
//                    ""                         I88
//                                               I88__
//                                               I88"""
//                                               I88
//                                               I88
//                                             __I88
//                                            """I88
//                                               I88
//                                               I88
//                                               I88__
//                                               I88"""
//                                               I88
//                                        BITSY  ___  CHUCK


import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;
import java.util.*;
import java.io.*;


class Solution
{
	static class Reader
	{
		final private int BUFFER_SIZE = 1 << 16;
		private DataInputStream din;
		private byte[] buffer;
		private int bufferPointer, bytesRead;

		public Reader()
		{
			din = new DataInputStream(System.in);
			buffer = new byte[BUFFER_SIZE];
			bufferPointer = bytesRead = 0;
		}

		public Reader(String file_name) throws IOException
		{
			din = new DataInputStream(new FileInputStream(file_name));
			buffer = new byte[BUFFER_SIZE];
			bufferPointer = bytesRead = 0;
		}

		public String readLine() throws IOException
		{
			byte[] buf = new byte[64]; // line length
			int cnt = 0, c;
			while ((c = read()) != -1)
			{
				if (c == '\n')
					break;
				buf[cnt++] = (byte) c;
			}
			return new String(buf, 0, cnt);
		}

		public int nextInt() throws IOException
		{
			int ret = 0;
			byte c = read();
			while (c <= ' ')
				c = read();
			boolean neg = (c == '-');
			if (neg)
				c = read();
			do
			{
				ret = ret * 10 + c - '0';
			} while ((c = read()) >= '0' && c <= '9');

			if (neg)
				return -ret;
			return ret;
		}

		public long nextLong() throws IOException
		{
			long ret = 0;
			byte c = read();
			while (c <= ' ')
				c = read();
			boolean neg = (c == '-');
			if (neg)
				c = read();
			do {
				ret = ret * 10 + c - '0';
			}
			while ((c = read()) >= '0' && c <= '9');
			if (neg)
				return -ret;
			return ret;
		}

		public double nextDouble() throws IOException
		{
			double ret = 0, div = 1;
			byte c = read();
			while (c <= ' ')
				c = read();
			boolean neg = (c == '-');
			if (neg)
				c = read();

			do {
				ret = ret * 10 + c - '0';
			}
			while ((c = read()) >= '0' && c <= '9');

			if (c == '.')
			{
				while ((c = read()) >= '0' && c <= '9')
				{
					ret += (c - '0') / (div *= 10);
				}
			}

			if (neg)
				return -ret;
			return ret;
		}

		private void fillBuffer() throws IOException
		{
			bytesRead = din.read(buffer, bufferPointer = 0, BUFFER_SIZE);
			if (bytesRead == -1)
				buffer[0] = -1;
		}

		private byte read() throws IOException
		{
			if (bufferPointer == bytesRead)
				fillBuffer();
			return buffer[bufferPointer++];
		}

		public void close() throws IOException
		{
			if (din == null)
				return;
			din.close();
		}
	}
  static int getC(ArrayList<ArrayList<Integer>> ar, int n){
    ArrayList<Integer> col= new ArrayList<>();

    int k=0;
    for(int i=0;i<ar.size();i++){
      col.add(ar.get(i).get(n));
    }
    Integer[] c= new Integer[ar.size()];
    c=col.toArray(c);
    Arrays.sort(c);
    //System.out.println(Arrays.toString(c));
    for(int i=0;i<c.length-1;i++){
      // System.out.printf("c[%d]==c[%d+1] %d, %d\n",i, i, c[i], c[i+1]);
      if(c[i]==c[i+1]){
        k++;
        break;
      }
      }
    return k;
  }
	public static void main(String[] args) throws IOException
	{
		Reader in=new Reader();
		int test=in.nextInt();
    for(int testtt=1;testtt<=test;testtt++){
      int n=in.nextInt();
      ArrayList<ArrayList<Integer>> ar= new ArrayList<>();
      int trace=0;
      for(int i=0;i<n;i++){
        ar.add(new ArrayList<>());
        for(int j=0;j<n;j++){
          int temp=in.nextInt();
          if(i==j)
            trace+=temp;
          ar.get(i).add(temp);
        }
      }
      int r=0, c=0;
      for(int i=0;i<n;i++){
        //ArrayList<Integer>row=ar.get(i);
        Integer []row= new Integer[n];
        row= ar.get(i).toArray(row);
        Arrays.sort(row);
        //Collections.sort(row);
        //
        for(int j=0;j<n-1;j++){
          if(row[j]==row[j+1]){
            r++;
            break;
          }
        }
      }
      for(int i=0;i<n;i++){
        int temp=getC(ar, i);
        // System.out.println("at i: "+i+" --> "+temp);
        c+=temp;
      }
      System.out.printf("Case #%d: %d %d %d\n",testtt, trace, r, c);
    }
	}
}
