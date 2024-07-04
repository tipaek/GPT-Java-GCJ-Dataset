import java.util.*;
import java.io.*;

class Solution{

    public static int permut[][];
    public static int x,y;
    public static ArrayList<int[][]> list = new ArrayList<>();

    public static void main(String args[]) throws Exception{
        Scanner in = new Scanner((System.in));
        int T = in.nextInt();
        for(int t=0;t<T;t++){
            x = in.nextInt();
            y = in.nextInt();
            test(x,y,t+1);
        }
    }
    public static void test(int X, int Y, int index){
        LinkedList<Cor> list = new LinkedList<>();
        list.addLast(new Cor(0,0,'-',-1));
        Cor result = null;
        int cnt = 0;
        while(!list.isEmpty()){
            Cor top = list.getFirst();
            list.removeFirst();
            int x = top.x;
            int y = top.y;
            char type = top.type;
            int level = top.level;
            if(x == X && y==Y){
                result = top;
                break;
            }
            int nextValue = 1<<(level + 1);
            list.addLast(new Cor(x + nextValue, y,'E',level + 1, top));
            list.addLast(new Cor(x, y + nextValue,'N',level + 1, top));
            list.addLast(new Cor(x - nextValue, y,'W',level + 1, top));
            list.addLast(new Cor(x, y - nextValue,'S',level + 1, top));
            cnt++;
            if(cnt == 10000000){
                break;
            }
        }
        if(result!=null){
            String path = printPath(result);
            System.out.println("Case #"+index+": "+path);
        }
        else{
            System.out.println("Case #"+index+ ": IMPOSSIBLE");
        }
    }

    public static String printPath(Cor cor){
        StringBuilder sb = new StringBuilder();
        while(cor.parent!=null){
            sb.append(cor.type);
            cor = cor.parent;
        }
        return sb.reverse().toString();
    }

    static class Cor{
        int x;
        int y;
        char type;
        int level;
        Cor parent;

        public Cor(int x, int y, char type, int level){
            this.x = x;
            this.y = y;
            this.type = type;
            this.level = level;
        }

        public Cor(int x, int y, char type, int level, Cor parent){
            this.x = x;
            this.y = y;
            this.type = type;
            this.level = level;
            this.parent = parent;
        }

    }


}