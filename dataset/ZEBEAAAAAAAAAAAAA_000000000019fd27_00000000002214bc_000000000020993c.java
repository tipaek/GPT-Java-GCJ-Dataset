
import java.util.Scanner;
class Vestigium1{  
    static Scanner scan = new Scanner(System.in);
    public static void main(final String args[]) {
        final int all = scan.nextInt();  
        int[][] value ;
        int[] ans = new int[3];
        int[][] ansAll = new int[all][3];
        int temp[] = new int [all];

        for(int x=0;x<all;x++){    
            int test = scan.nextInt();
            temp[x]=test;
            value = new int[test][test];     
            for(int i=0; i<test; i++){              
                for(int j=0; j<test; j++){
                    value[i][j] = scan.nextInt();  
                }
            }
            ans=findAns(temp[x],value);
            ansAll[x][0]=ans[0];ansAll[x][1]=ans[1];ansAll[x][2]=ans[2];
        }
        
        for(int x=0;x<all;x++){
            System.out.println("Case #"+(x+1)+": "+ansAll[x][0]+" "+ansAll[x][1]+" "+ansAll[x][2]);
        }
        

    }

    public static int[] findAns(int test,int[][] value){
        int[] rol = new int[10];
        int[] cal = new int[10];
        int[] ans = new int[3];

        int k=0,r=0,c=0;
            for (int i = 0; i <test ; i++) {
                setZero(rol);setZero(cal);
                for(int j=0; j<test; j++){
                    if(i==j) k+=value[i][j];
                    rol[value[i][j]-1]++;
                    cal[value[j][i]-1]++;
                    
                }
                if(duplicate(rol)==1) r++;
                if(duplicate(cal)==1) c++;
            }

            ans[0]=k;
            ans[1]=r;
            ans[2]=c;
            return ans;
    }
    

    public static void setZero(int[] a){
        for(int i=0; i<10; i++){
            a[i]=0;
        }
    }

    public static int duplicate(int[] a){
        int ans=0;
        for(int i=0; i<10; i++){
            if(a[i]>1){
                ans=1;
            }
        }
        return ans;
    }
    
}