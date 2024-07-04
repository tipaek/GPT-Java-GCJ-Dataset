import java.util.Iterator;
import java.util.Scanner;
import java.util.TreeSet;

public class Solution {
    public static void main(String[] args){
        Parents p = new Parents();
    }
}


class Parents{
    public Parents(){
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        char[][] result = new char[T][];
        int sum_lengths=0;
        for(int i=0;i<T;++i){
            int N = sc.nextInt();
            TreeSet<Event> tree = new TreeSet<>();
            int start, end;
            for(int j=0;j<N;++j){
                start=sc.nextInt();
                end=sc.nextInt();
                tree.add(new Event(start,end,j,true));
            }
            boolean impossible=false;
            Iterator<Event> iter = tree.iterator();
            Event last_of_prev_sign = iter.next();
            Event last_of_last_sign = null;
            while(iter.hasNext() && last_of_last_sign==null){
                last_of_last_sign=iter.next();
                if(last_of_last_sign.start<last_of_prev_sign.end){
                    last_of_last_sign.C=!last_of_prev_sign.C;
                } else {
                    last_of_prev_sign=last_of_last_sign;
                    last_of_last_sign=null;
                }
            }
            while(iter.hasNext()){
                Event current = iter.next();
                if(current.start>=last_of_last_sign.end){
                    current.C=last_of_last_sign.C;
                    last_of_last_sign=current;
                }
                else{
                    if(current.start<last_of_prev_sign.end){
                        impossible=true;
                        break;
                    }
                    else{
                        current.C=!last_of_last_sign.C;
                        last_of_prev_sign=last_of_last_sign;
                        last_of_last_sign=current;
                    }
                }
            }
            if(impossible){
                String s = "Case #"+(i+1)+": IMPOSSIBLE";
                result[i]=s.toCharArray();
            }
            else{
                result[i] = print_shedule(tree, i+1);
            }
            sum_lengths+=result[i].length;
        }
        char[] output_chars = new char[sum_lengths];
        int output_index=0;
        for(int i=0;i<T;++i){
            for(int j=0;j<result[i].length;++j, output_index++){
                output_chars[output_index]=result[i][j];
            }
            if(i<T-1) output_chars[output_index++]='\n';
        }
        System.out.println(output_chars);
    }

    private char[] print_shedule(TreeSet<Event> tree, int t_id) {
        String header = "Case #"+t_id+": ";
        char[] result = new char[header.length()+tree.size()];
        for(int i=0;i<header.length();++i) result[i]=header.charAt(i);
        for(Event e : tree){
            result[header.length()+e.id]=(e.C) ? 'C' : 'J';
        }
        return result;
    }

    class Event implements Comparable {
        public int start;
        public int end;
        public int id;
        public boolean C;
        Event(int start, int end, int id, boolean C){
            this.start=start;
            this.end=end;
            this.id=id;
            this.C=C;
        }

        @Override
        public int compareTo(Object o) {
            if(o==null) return 1;
            return end-((Event)o).end;
        }
    }
}