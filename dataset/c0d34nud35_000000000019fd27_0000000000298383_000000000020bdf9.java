import java.util.*;
// Java program to print all permutations of a 
// given string. 
public class Solution 
{ 

    public static void main(String[] args) 
    { 
        Scanner scan = new Scanner(System.in);
        int T,N,K,start,end,ccount,jcount,flag;
        int [][] c,j;
        int []temp;
        String order;
        
        T=scan.nextInt();
        for(int t=0;t<T;t++){
            N=scan.nextInt();
            
            c=new int[N][2];
            j=new int[N][2];
            ccount=0;
            jcount=0;
            order= new String("");
            flag=0;
            
            for(int n=0;n<N;n++){
                start=scan.nextInt();
                end=scan.nextInt();
                //System.out.println("test");
                if(cHasTime(start,end,c,ccount)){
                    //System.out.println("test");
                    temp=new int[2];
                    temp[0]=start;
                    temp[1]=end;
                    
                    c[ccount]=temp;
                    
                    ccount++;
                    
                    order+='C';
                }else if(jHasTime(start,end,j,jcount)){
                    temp=new int[2];
                    temp[0]=start;
                    temp[1]=end;
                    
                    j[jcount]=temp;
                    
                    jcount++;
                    
                    order+='J';
                }else{
                    System.out.println("Case #"+(t+1)+": IMPOSSIBLE");
                    flag=1;
                    break;
                }
            }
            
            if(flag==0){
                System.out.println("Case #"+(t+1)+": "+order);
            }
        }

    } 
    
    static boolean cHasTime(int start, int end, int [][]c,int ccount){
        for(int i=0;i<ccount;i++){
            if( (start>c[i][0] && start<c[i][1]) || (end>c[i][0] && end<c[i][1]) || (start<c[i][0] && end>c[i][1]) ){
                return false;
            }
        }
        return true;
    }
    
    static boolean jHasTime(int start, int end, int [][]j,int jcount){
        for(int i=0;i<jcount;i++){
            if( (start>j[i][0] && start<j[i][1]) || (end>j[i][0] && end<j[i][1]) || (start<j[i][0] && end>j[i][1]) ){
                return false;
            }
        }
        return true;
    }

} 

