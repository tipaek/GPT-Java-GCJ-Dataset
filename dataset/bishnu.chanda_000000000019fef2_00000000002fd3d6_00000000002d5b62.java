import java.util.*;
import java.io.*;

public class Solution {

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
            }  while ((c = read()) >= '0' && c <= '9');

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

    static class Rectangle {
        int blx, bly, urx, ury;

        Rectangle(int blx, int bly, int urx, int ury) {
            this.blx = blx;
            this.bly = bly;
            this.urx = urx;
            this.ury = ury;
        }
    }

    public static Rectangle getCommonRectangle(Rectangle r1, Rectangle r2) {
        Rectangle rectangle = null;

        //int lx = 0, ly = 0, ux = 0, uy = 0;

        int lx = Math.max(r1.blx, r2.blx);
        int ly = Math.max(r1.bly, r2.bly);
        int ux = Math.min(r1.urx, r2.urx);
        int uy = Math.min(r1.ury, r2.ury);

        if(lx > ux || ly > uy) {
            return null;
        }

        rectangle = new Rectangle(lx, ly, ux, uy);

        return rectangle;
    }

    static class Point {
        int x, y;
        String step = "";
        int power = 2;

        Point(int x, int y, String step, int power) {
            this.x = x;
            this.y = y;
            this.step = step;
            this.power = power;
        }
    }

    public static String solution(int x, int y) {

        String impossible = "IMPOSSIBLE";
        LinkedList<Point> queue = new LinkedList<Point>();

        queue.add(new Point(0, 1, "N", 2));
        queue.add(new Point(0, -1, "S", 2));
        queue.add(new Point(-1, 0, "W", 2));
        queue.add(new Point(1, 0, "E", 2));

        while (queue.size() != 0)
        {
            // Dequeue a vertex from queue and print it
            Point p = queue.poll();
            //System.out.println("Point::: " + p.x + ", " + p.y + " ::" + p.step);
            if(p.x == x && p.y == y) {
                return p.step;
            }
            int np = p.power*2;
            //North
            int nx =  p.x;
            int ny = p.y + p.power;
            String ns = p.step + "N";
            //System.out.println("nx: " + nx + " ny::" + ny + " steps:" + ns);
            //int maxDistance = Math.max(Math.abs(x - nx), Math.abs(y-ny));
            int maxDistance = Math.abs(y-ny);
            if(nx == x && ny == y) return ns;
            if((maxDistance >= np || y == ny ) && (Math.abs(x-nx) >= np || x == nx )) {
                queue.add(new Point(nx, ny,ns, np));
                //System.out.println("Added North");
            }

            //East
            nx =  p.x + p.power;
            ny = p.y;
            ns = p.step + "E";
            //System.out.println("nx: " + nx + " ny::" + ny + " steps:" + ns);
            if(nx == x && ny == y) return ns;
            //maxDistance = Math.max(Math.abs(x - nx), Math.abs(y-ny));
            maxDistance = Math.abs(x-nx);
            if((maxDistance >= np || x == nx) && (Math.abs(y-ny) >= np || y == ny )) {
                queue.add(new Point(nx, ny,ns, np));
                //System.out.println("Added East");
            }

            //South
            nx =  p.x;
            ny = p.y - p.power;
            ns = p.step + "S";
            //System.out.println("nx: " + nx + " ny::" + ny + " steps:" + ns);
            if(nx == x && ny == y) return ns;
            //maxDistance = Math.max(Math.abs(x - nx), Math.abs(y-ny));
            maxDistance = Math.abs(y-ny);
            if((maxDistance >= np || y == ny) && (Math.abs(x-nx) >= np || x == nx )) {
                queue.add(new Point(nx, ny,ns, np));
                //System.out.println("Added South");
            }

            //West
            nx =  p.x - p.power;
            ny = p.y;
            ns = p.step + "W";
            //System.out.println("nx: " + nx + " ny::" + ny + " steps:" + ns);
            if(nx == x && ny == y) return ns;
//            maxDistance = Math.max(Math.abs(x - nx), Math.abs(y-ny));
            maxDistance = Math.abs(x-nx);
            if((maxDistance >= np || x == nx) && (Math.abs(y-ny) >= np || y == ny )) {
                queue.add(new Point(nx, ny,ns, np));
                //System.out.println("Added West");
            }
        }

        return impossible;
    }


    public static void main(String args[]) throws Exception {


        //Scanner in = new Scanner(System.in);

        Reader in = new Reader();

        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));


        int t = in.nextInt();
        for(int i = 1; i <= t; i++) {
            int x = in.nextInt();
            int y = in.nextInt();

            String result = solution(x, y);
            System.out.println("Case #"+i+ ": " + result);
        }
        /*
        Rectangle rectangles[] = new Rectangle[n];

        for(int i = 0; i < n; i++) {
            int bx = in.nextInt();
            int by = in.nextInt();
            int ux = in.nextInt();
            int uy = in.nextInt();

            Rectangle rec = new Rectangle(bx, by, ux, uy);
            rectangles[i] = rec;
        }

        Arrays.sort(rectangles, new Comparator<Rectangle>() {
            @Override
            public int compare(Rectangle o1, Rectangle o2) {
                if(o1.blx < o2.blx) return -1;
                if(o1.blx > o2.blx) return 1;
                if(o1.bly < o2.bly) return -1;
                if(o1.bly > o2.bly) return 1;
                if(o1.urx < o2.urx) return -1;
                if(o1.urx > o2.urx) return 1;
                if(o1.ury < o2.ury) return -1;
                if(o2.ury > o2.ury) return 1;
                return 0;
            }
        });
        */


        //writer.write(x + " " + y);

        writer.flush();
        writer.close();


        in.close();
    }



}
