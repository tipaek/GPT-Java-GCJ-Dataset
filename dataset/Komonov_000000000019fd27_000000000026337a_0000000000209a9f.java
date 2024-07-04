import java.util.Scanner;

public class Solution {
    public static void main(String[] args){
        Nesting n = new Nesting();
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

class Nesting{
    public Nesting(){
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        String result ="";
        for(int i=0;i<T;++i){
            String input = sc.next();
            result+="Case #"+(i+1)+": ";
            int current_depth=0;
            int temp;
            for(int k=0;k<input.length();++k){
                temp=input.charAt(k)-'0';
                if(temp>current_depth) {
                    for (int j = 0; j < temp - current_depth;++j){
                        result+='(';
                    }
                }
                else if(temp<current_depth){
                    for (int j = 0; j < current_depth-temp;++j){
                        result+=')';
                    }
                }
                result+=((char)(temp+'0'));
                current_depth=temp;
            }
            temp=0;
            if(temp<current_depth){
                for (int j = 0; j < current_depth-temp;++j){
                    result+=')';
                }
            }
            if(i<T-1) result+='\n';
        }
        System.out.println(result);
    }
}