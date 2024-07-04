import java.util.ArrayList;
import java.util.Scanner;

public class Vestigium{
    public static int T;
    public static ArrayList<ArrayList<ArrayList<Integer>>> matrices;
    public static ArrayList<Integer> N;
    public static ArrayList<Integer> traces;
    public static ArrayList<Integer> r;
    public static ArrayList<Integer> c;
    
    public static void main(String[] args){
    	matrices=new ArrayList<>();
    	traces= new ArrayList<>();
    	N=new ArrayList<>();
    	r=new ArrayList<>();
    	c=new ArrayList<>();
        readInput();
        solve();
        printOutput();
    }
    
    public static void readInput(){
        Scanner in = new Scanner(System.in);
        T=in.nextInt();
        for(int i=0; i<T;i++){
            N.add(in.nextInt());
            matrices.add(new ArrayList<>());
            int cur_N = N.get(i);
			for(int j=0;j<cur_N;j++){
                matrices.get(i).add(new ArrayList<>());
                for(int k=0;k<cur_N;k++){
                    matrices.get(i).get(j).add(in.nextInt());
                }
            }
        }
    }
    
    public static void solve(){
        for(int i=0; i<T;i++){
            ArrayList<ArrayList<Integer>> matrice = matrices.get(i);
            int cur_N = N.get(i);
            int tr=0;
            for(int j=0; j<cur_N;j++){
                tr+=matrice.get(j).get(j);
            }
            traces.add(tr);
            int cur_r=0;
            int cur_c=0;
            for(int j=0;j<cur_N;j++){
                boolean row_done=false;
                boolean col_done=false;
                boolean[] row_values = new boolean[cur_N];
                boolean[] col_values = new boolean[cur_N];
                for(int k=0; k<cur_N;k++){
                    if(!row_done){
                        if(!row_values[matrice.get(j).get(k)-1]){
                            row_values[matrice.get(j).get(k)-1]=true;
                        }else{
                            row_done=true;
                            cur_r++;
                        }
                    }
                    if(!col_done){
                        if(!col_values[matrice.get(k).get(j)-1]){
                        	col_values[matrice.get(k).get(j)-1]=true;
                        }else{
                            col_done=true;
                            cur_c++;
                        }
                    }
                    if(row_done && col_done){
                        break;
                    }
                }
            }
            r.add(cur_r);
            c.add(cur_c);
        }
    }
    
    public static void printOutput(){
        for(int i=0; i<T;i++){
            System.out.println("Case #"+i+": "+traces.get(i)+" "+r.get(i)+" "+c.get(i));
        }
    }
}