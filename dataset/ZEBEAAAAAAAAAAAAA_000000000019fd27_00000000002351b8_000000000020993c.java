import java.util.Scanner;
public class first {
    static Scanner scan = new Scanner(System.in);
    public static void main(final String args[]) {
        int casee = scan.nextInt();
        int[][] ans = new int[casee][3];
        int k=0,r=0,c=0;
        int[][] value;
        int size;
        for(int a=0; a<casee; a++){
            k=0;r=0;c=0;
            size = scan.nextInt();
            value = new int[size][size];
            //รับค่า
            for(int i=0; i<size; i++){              
                for(int j=0; j<size; j++){
                    value[i][j] = scan.nextInt();  
                }
            }
            //หาค่า
            int[] rol={0,0,0,0,0,0,0,0,0,0};
            int[] cal={0,0,0,0,0,0,0,0,0,0};
            for(int i=0; i<size; i++){
                for(int j=0; j<size; j++){
                    if(i==j) k+=value[i][j];
                    rol[value[i][j]-1]++;
                    cal[value[j][i]-1]++;
                }
                if(duplicate(rol)==1) r++;
                if(duplicate(cal)==1) c++;
            }
            ans[a][0]=k;
            ans[a][1]=r;
            ans[a][2]=c;
        }

        for(int a=0; a<casee; a++){
            System.out.println("Case #"+(a+1)+": "+ans[a][0]+" "+ans[a][1]+" "+ans[a][2]);
        }
    }
    public static int duplicate(int[] a){
        int ans=0;
        for(int i=0; i<10; i++){
            if(a[i]>1) ans=1;
        }
        return ans;
    }
}