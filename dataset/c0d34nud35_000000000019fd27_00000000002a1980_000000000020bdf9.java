import java.util.Scanner;
public class Solution 
{ 

    public static void main(String[] args) 
    { 
        Scanner scan = new Scanner(System.in);
        int T,N,K,start,end,ccount,jcount,flag;
        int [][] c,j;
        int []temp;
        StringBuilder order = new StringBuilder(""); 
        
        T=scan.nextInt();
        for(int t=0;t<T;t++){
            N=scan.nextInt();
            
            c=new int[N][2];
            j=new int[N][2];
            ccount=0;
            jcount=0;
            order= new StringBuilder(""); 
            flag=0;
            
            for(int n=0;n<N;n++){
                start=scan.nextInt();
                end=scan.nextInt();

                if(cHasTime(start,end,c,ccount)){
                    temp=new int[2];
                    temp[0]=start;
                    temp[1]=end;
                    
                    c[ccount]=temp;
                    
                    ccount++;
                    
                    order.append('C');
                }else if(jHasTime(start,end,j,jcount)){
                    temp=new int[2];
                    temp[0]=start;
                    temp[1]=end;
                    
                    j[jcount]=temp;
                    
                    jcount++;
                    
                    order.append('J');
                }
            }
            
        }

    } 
    
    static boolean cHasTime(int start, int end, int [][]c,int ccount){
        for(int i=0;i<ccount;i++){
            if((start>c[i][0] && start <c[i][1]) || (end>c[i][0] && end <c[i][1]) ){
                return false;
            }
        }
        return true;
    }
    
    static boolean jHasTime(int start, int end, int [][]j,int jcount){
        for(int i=0;i<jcount;i++){
            if((start>j[i][0] && start <j[i][1]) || (end>j[i][0] && end <j[i][1]) ){
                return false;
            }
        }
        return true;
    }

} 
