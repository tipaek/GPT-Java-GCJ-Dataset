import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution {


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
            return Long.parseUnsignedLong(next());
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




    // Driver code
    public static void main(String args[]) {
        FastReader fr = new FastReader();

        int testcases = fr.nextInt();
        for (int l = 0; l < testcases; l++) {


            int i=fr.nextInt();
            int j=fr.nextInt();

            Queue<Node> queue=new LinkedList<>();
            ( queue).add(new Node(0,0,0));
            StringBuilder sb=new StringBuilder();
            while(!queue.isEmpty()){
                Node cur=queue.poll();

               // System.out.println(cur.x+":"+cur.y+":"+cur.level);
                if(cur.level>7){
                    break;
                }
                int x=cur.x;
                int y=cur.y;
                if(cur.x==i&&cur.y==j){
                    //found solution
                    buildSolution(cur,sb);
                    break;
                }
                int pow=(int)Math.pow(2,cur.level);
                //if(pow>Math.abs(i*j*i*j*i*j*i*j))
                //    break;
                Node north=new Node(x,y+pow,cur.level+1,cur,'N');
                Node south=new Node(x,y-pow,cur.level+1,cur,'S');
                Node east=new Node(x+pow,y,cur.level+1,cur,'E');
                Node west=new Node(x-pow,y,cur.level+1,cur,'W');
                queue.add(north);
                queue.add(south);
                queue.add(east);
                queue.add(west);

            }
            sb=sb.reverse();
            if(sb.length()==0){

                System.out.println("Case #" + (l + 1) + ": IMPOSSIBLE");

            }else
                System.out.println("Case #" + (l + 1) + ": "+sb);

        }


    }

    static void buildSolution(Node cur,StringBuilder sb){
        if(cur.ch=='\0')
            return;
        sb.append(cur.ch);
        buildSolution(cur.parent,sb);
    }

    static class Node{
        int x;
        int y;
        int level;
        char ch;
        Node parent;
        Node(int x,int y,int level){
            this.x=x;
            this.y=y;
            this.level=level;
            parent=null;
            ch='\0';
        }
        Node(int x,int y,int level,Node parent,char ch){
            this.x=x;
            this.y=y;
            this.level=level;
            this.parent=parent;
            this.ch=ch;
        }

    }

}




