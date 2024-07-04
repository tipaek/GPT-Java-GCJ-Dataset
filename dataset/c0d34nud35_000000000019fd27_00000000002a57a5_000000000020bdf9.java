import java.util.Scanner;
public class Solution 
{ 

    public static void main(String[] args) 
    { 
        Scanner scan = new Scanner(System.in);
        int T,N,K,start,end,ccount,jcount,flag;
        int [][] c,j,activities;
        int []temp= new int[3];
        StringBuilder order = new StringBuilder(""); 
        char letter;
        
        T=scan.nextInt();
        for(int t=0;t<T;t++){
            N=scan.nextInt();
            
            c=new int[N][2];
            j=new int[N][2];
            ccount=0;
            jcount=0;
            order= new StringBuilder(""); 
            flag=0;
            activities= new int[N][3];
            
            for(int n=0;n<N;n++){
                start=scan.nextInt();
                end=scan.nextInt();
                
                temp= new int[4];
                temp[0]=start;
                temp[1]=end;
                temp[2]=n;//original pos
                
                activities[n]=temp;
            }
            //sort by starting time
            sort(activities);
            
            for(int i=0;i<activities.length;i++){
                if(cHasTime(activities[i][0],activities[i][1],c,ccount)){
                    temp= new int[2];
                    temp[0]=activities[i][0];
                    temp[1]=activities[i][1];
                    
                    c[ccount]=temp;
                    
                    ccount++;
                    
                    order.append('C');
                    activities[i][3]='C'-'A';
                }else if(jHasTime(activities[i][0],activities[i][1],j,jcount)){
                    temp= new int[2];
                    temp[0]=activities[i][0];
                    temp[1]=activities[i][1];
                    
                    j[jcount]=temp;
                    
                    jcount++;
                    
                    order.append('J');
                    activities[i][3]='J'-'A';
                }else{
                    System.out.println("Case #"+(t+1)+": IMPOSSIBLE");
                    flag=1;
                    break;
                }
            }

            if(flag==0){
                System.out.print("Case #"+(t+1)+": ");
                for(int pos=0;pos<activities.length;pos++){
                    for(int check=0;check<activities.length;check++){
                        if(activities[check][2]==pos) {
                            //letter=char(activities[check][3]+'A');
                            System.out.print(Character.toChars(activities[check][3]+'A'));
                        }
                    }
                }
                System.out.println();
            }
        }

    } 
    
    static void sort(int [][]activities){
        int []temp;
        int n = activities.length; 
        for (int i = 0; i < n-1; i++) 
            for (int j = 0; j < n-i-1; j++) 
                if (activities[j][0] > activities[j+1][0]) 
                { 
                    temp = activities[j]; 
                    activities[j] = activities[j+1]; 
                    activities[j+1] = temp; 
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

