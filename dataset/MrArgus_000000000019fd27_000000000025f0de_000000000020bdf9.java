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

            if(list.size()>2){
                for(int i=0;i<list.size()-2;i++){
                    for(int j=i+1;j<list.size()-1;j++){
                        for(int k=j+1;k<list.size();k++){
                            Cor first = list.get(i);
                            Cor second = list.get(j);
                            Cor third = list.get(k);
                            if((first.left <= second.left && first.right> second.left) && (second.left <= third.left && second.right> third.left)
                            && (first.left <= third.left && first.right> third.left)){
                                impossible = true;
                                break;
                            }
                        }
                        if(impossible)break;
                    }
                    if(impossible)break;  
                }
            }
            
            if(!impossible){
                list.get(0).setOwner(true);
                Cor current = list.get(0);
                for(int i=1;i<list.size();i++){
                    Cor next = list.get(i);
                    if(current.left <= next.left && current.right> next.left){
                        next.setOwner(!current.owner);
                    }
                    else{
                        next.setOwner(current.owner);
                    }
                }
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
            else{
                System.out.println("Case #" + t + ": IMPOSSIBLE");
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