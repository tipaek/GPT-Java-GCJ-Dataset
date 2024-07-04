import java.util.Iterator;
import java.util.Scanner;
import java.util.TreeSet;

public class Solution {
    public static void main(String[] args){
        Parents p = new Parents();
    }
}
//class Latin_Matrix {
//    public Latin_Matrix(){
//        Scanner sc = new Scanner(System.in);
//        int T = sc.nextInt();
//        String[] result = new String[T];
//        int temp;
//        for(int i=0;i<T;++i){
//            int N = sc.nextInt();
//            boolean[][] columns = new boolean[N][N];
//            boolean[] columns_repeat = new boolean[N];
//
//            int row_r=0;
//            int col_r=0;
//            int V =0;
//            for(int j=0;j<N;++j){
//                boolean row_repeat=false;
//                boolean[] row = new boolean[N];
//
//                for(int k=0;k<N;++k){
//                    temp=sc.nextInt();
//                    if(j==k) V+=temp;
//                    if(row[temp-1] && !row_repeat) row_repeat=true;
//                    row[temp-1]=true;
//                    if(columns[k][temp-1] && !columns_repeat[k]) columns_repeat[k]=true;
//                    columns[k][temp-1]=true;
//                }
//                if(row_repeat) row_r++;
//            }
//            for(int j=0;j<N;++j){
//                if(columns_repeat[j]) col_r++;
//            }
//            result[i]="Case #"+(i+1)+": "+V+" "+row_r+" "+col_r;
//        }
//        int sum_length=0;
//        for(int i=0;i<T;++i){
//            sum_length+=result[i].length()+1;
//        }
//        sum_length--;
//        char[] output_chars = new char[sum_length];
//        int output_index=0;
//        for(int i=0;i<T;++i){
//            for(int j=0;j<result[i].length();++j, output_index++){
//                output_chars[output_index]=result[i].charAt(j);
//            }
//            if(i<T-1) output_chars[output_index++]='\n';
//        }
//        System.out.println(new String(output_chars));
//    }
//}

//class Nesting{
//    public Nesting(){
//        Scanner sc = new Scanner(System.in);
//        int T = sc.nextInt();
//        String result ="";
//        for(int i=0;i<T;++i){
//            String input = sc.next();
//            result+="Case #"+(i+1)+": ";
//            int current_depth=0;
//            int temp;
//            for(int k=0;k<input.length();++k){
//                temp=input.charAt(k)-'0';
//                if(temp>current_depth) {
//                    for (int j = 0; j < temp - current_depth;++j){
//                        result+='(';
//                    }
//                }
//                else if(temp<current_depth){
//                    for (int j = 0; j < current_depth-temp;++j){
//                        result+=')';
//                    }
//                }
//                result+=((char)(temp+'0'));
//                current_depth=temp;
//            }
//            temp=0;
//            if(temp<current_depth){
//                for (int j = 0; j < current_depth-temp;++j){
//                    result+=')';
//                }
//            }
//            if(i<T-1) result+='\n';
//        }
//        System.out.println(result);
//    }
//}

class Parents{
    public Parents(){
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
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
                System.out.println("Case #"+(i+1)+": IMPOSSIBLE");
            }
            else{
                System.out.println(print_shedule(tree, i+1));
            }
        }
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