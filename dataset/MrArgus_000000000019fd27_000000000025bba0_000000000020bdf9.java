import java.util.*;
import java.io.*;

class Solution{
    public static void main(String args[]) throws Exception{
        Scanner in = new Scanner((System.in));
        int T = in.nextInt();
        for(int t=0;t<T;t++){
            int n = in.nextInt();
            ArrayList<Cor> list = new ArrayList<>();
            for(int i=0;i<n;i++){
                list.add(new Cor(in.nextInt(), in.nextInt(), i));
            }
            Collections.sort(list);
            for(int i=0;i<list.size();i++){
                list.get(i).setFlag(true);
            }
            boolean impossible = false;


            list.get(0).setOwner(true);
            for(int i=0;i<list.size()-1;i++){
                int cnt = 0;
                for(int j=i+1;j<list.size();j++){
                    Cor current = list.get(i);
                    Cor next = list.get(j);
                    if(current.left <= next.left && current.right> next.left){
                        next.setOwner(!current.owner);
                        cnt++;
                    }
                    else{
                        next.setOwner(current.owner);
                    }
                }
                if(cnt == list.size()-1){
                    impossible = true;
                }
            }

            if(impossible){
                System.out.println("Case #" + t + ": IMPOSSIBLE");
            }
            else{
                Collections.sort(list);
                System.out.print("Case #" + t  +": ");
                for(int i=0;i<list.size();i++){
                    if(list.get(i).owner){
                        System.out.print("J");
                    }
                    else{
                        System.out.print("C");
                    }
                }
                System.out.println();
            }
        }
    }

    static class Cor implements Comparable<Cor>{

        public int left;
        public int right;
        public int index;
        public boolean owner;
        public boolean flag;

        public void setFlag(boolean flag) {
            this.flag = flag;
        }

        public void setOwner(boolean owner) {
            this.owner = owner;
        }

        public Cor(int left, int right, int index){
            this.left = left;
            this.right = right;
            this.index = index;
        }

        @Override
        public int compareTo(Cor cor) {
            if(cor.flag){
                return this.index - cor.index;
            }
            if(cor.left == this.left){
                return this.right - cor.right;
            }
            return this.left - cor.left;
        }

    }
}