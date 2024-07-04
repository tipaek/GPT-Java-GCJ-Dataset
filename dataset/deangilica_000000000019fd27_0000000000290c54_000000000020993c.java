public class Vestigium{
    public int T,N;
    public ArrayList<ArrayList<ArrayList<Integer>>> matrices;
    public ArrayList<Integer> trace;
    public ArrayList<Integer> r;
    public ArrayList<Integer> c;
    
    public static void main(String[] args){
        readInput();
        solve();
        printOutput();
    }
    
    public void readInput(){
        Scanner in = new Scanner(System.in);
        T=in.nextInt();
        N=in.nextInt();
        for(int i=0; i<T;i++){
            matrices.add(new ArrayList<>());
            for(int j=0;j<N;j++){
                matrices.get(i).add(new ArrayList<>());
                for(int k=0;k<N;k++){
                    matrices.get(i).get(j).add(in.nextInt());
                }
            }
        }
    }
    
    public void solve(){
        for(int i=0; i<T;i++){
            ArrayList<ArrayList<Integer>> matrice = matrices.get(i);
            int tr=0;
            for(int j=0; j<N;j++){
                tr+=matrice.get(j).get(j);
            }
            traces.add(tr);
            int cur_r=0;
            int cur_c=0;
            for(int j=0;j<N;j++){
                boolean row_done;
                boolean col_done;
                boolean[] row_values = new boolean[N];
                boolean[] col_values = new boolean[N];
                for(int k=0; k<N;k++){
                    if(!row_done){
                        if(!row_values[matrice.get(j).get(k)-1]){
                            row_values[matrice.get(j).get(k)-1]=true;
                        }else{
                            row_done=true;
                            cur_r++;
                        }
                    }
                    if(!col_done){
                        if(!row_values[matrice.get(k).get(j)-1]){
                            row_values[matrice.get(k).get(j)-1]=true;
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
    
    public void printOutput(){
        for(int i=0; i<T;i++){
            System.out.println("Case #"+i+": "+traces.get(i)+" "+r.get(i)+" "+c.get(i));
        }
    }
}