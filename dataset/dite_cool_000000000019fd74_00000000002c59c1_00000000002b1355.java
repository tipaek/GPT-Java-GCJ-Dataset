import java.util.*;

class Dancer{
    int skill;
    int row;
    int column;
    ArrayList<Integer> cnrow;
    ArrayList<Integer> cncol;
    boolean eliminated;
    
    public Dancer(int skill,int row,int column){
        this.skill=skill;
        this.row = row;
        this.column = column;
        cnrow = new ArrayList<Integer>();
        cncol = new ArrayList<Integer>();
        eliminated = false;
    }
    
}
public class Solution{
    public static void main(String args[]){
        int T=0,R=0,C=0,current=0,prev=Integer.MIN_VALUE;
        Scanner sc = new Scanner(System.in);
        T = sc.nextInt();
        for(int t=0;t<T;t++){
                int total=0;
            R = sc.nextInt();
            C = sc.nextInt();
            Dancer[][] d = new Dancer[R][C];
            for(int i=0;i<R;i++){
                for(int j=0;j<C;j++){
                    int skill = sc.nextInt();
                    d[i][j] = new Dancer(skill,i,j);
                }
            }
            compass_neighbour(d,R,C);
            current = roundinterest(d,R,C);
            total+=current;
            while(true){
                prev=current;
                eliminate(d,R,C);
                compass_neighbour(d,R,C);
                current = roundinterest(d,R,C);
                if(current==prev){
                    break;
                }
                total+=current;
            }
            System.out.println("Case #"+ (t+1) + ": " + total);
        }
        
    }
    
    public static void compass_neighbour(Dancer[][] d,int R,int C){
        for(int i=0;i<R;i++){
            for(int j=0;j<C;j++){
                if(!d[i][j].eliminated){
                    d[i][j].cnrow.clear();
                    d[i][j].cncol.clear();
                    for(int z=(d[i][j].row)-1;z>=0;z--){
            if(d[z][d[i][j].column].eliminated == false){
                d[i][j].cnrow.add(z);
                d[i][j].cncol.add(d[i][j].column);
                break;
            }
        }
        for(int z=(d[i][j].row)+1;z<R;z++){
            if(d[z][d[i][j].column].eliminated == false){
                d[i][j].cnrow.add(z);
                d[i][j].cncol.add(d[i][j].column);
                break;
            }
        }
        for(int z=(d[i][j].column)-1;z>=0;z--){
            if(d[d[i][j].row][z].eliminated == false){
                d[i][j].cnrow.add(d[i][j].row);
                d[i][j].cncol.add(z);
                break;
            }
        }
        for(int z=(d[i][j].column)+1;z<C;z++){
            if(d[d[i][j].row][z].eliminated == false){
                d[i][j].cnrow.add(d[i][j].row);
                d[i][j].cncol.add(z);
                break;
            }
        }
                }
                
            }
        }
    }
    
    public static void eliminate(Dancer[][] d,int R,int C){
        double avg=0;
        for(int i=0;i<R;i++){
            for(int j=0;j<C;j++){
                avg = avg_skill(d,d[i][j].cnrow,d[i][j].cncol);
                if(d[i][j].skill<avg){
                    d[i][j].eliminated = true;
                }
            }
        }
        
    }
    public static double avg_skill(Dancer[][] d,ArrayList<Integer> row,ArrayList<Integer> col){
        double avg=0;
        for(int i=0,j=0; (i<row.size()) && (j<col.size());i++,j++){
            avg+= d[row.get(i)][col.get(j)].skill;
            
        }
        if(row.size()!=0)
            {avg/=row.size();}
        return avg;
    }
    public static int roundinterest(Dancer[][] d,int R,int C){
        int val=0;
        for(int i=0;i<R;i++){
            for(int j=0;j<C;j++){
                if(d[i][j].eliminated==false){
                    val+=d[i][j].skill;
                }
            }
        }
        return val;
    }
    
}