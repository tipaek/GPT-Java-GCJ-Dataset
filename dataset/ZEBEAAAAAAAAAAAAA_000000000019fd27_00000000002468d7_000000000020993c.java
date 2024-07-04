import java.util.Scanner;
class Solution{
    static Scanner scan = new Scanner(System.in);
    public static void main(final String args[]) {
        final int casee = scan.nextInt();
        final int[][] ans = new int[casee][3];
        int k = 0, r = 0, c = 0;
        int[][] value;
        int size;
        final int[] cal = new int[11];
        final int[] rol = new int[11];

        if(casee>=1 && casee<=100){
            loop:
            for(int a=0; a<casee; a++){
                k=0;r=0;c=0;
                size = scan.nextInt();
                value = new int[size][size];
                if(size>=2 && size<=100){
                    for(int i=0; i<size; i++){              
                        for(int j=0; j<size; j++){
                            value[i][j] = scan.nextInt();
                            if(value[i][j]>=1 && value[i][j]<=size){
                                continue;
                            }else{
                                System.out.println(-1);
                                break loop;
                            }
                        }
                    } 
                      
                    for(int i=0; i<size; i++){
                        rol[10]=-1;
                        cal[10]=-1;
                        for(int f=0; f<10; f++){
                            rol[f]=0;
                            cal[f]=0;
                        }

                        for(int j=0; j<size; j++){
                            if(i==j) k+=value[i][j];
                            
                            rol[value[i][j]-1]++; 
                            if(rol[value[i][j]-1]>1) rol[10]=0;

                            cal[value[j][i]-1]++; 
                            if(cal[value[j][i]-1]>1) cal[10]=0;
                        }
                        if(rol[10]==0) r++;
                        if(cal[10]==0) c++;
                    }
                    
                    ans[a][0]=k;
                    ans[a][1]=r;
                    ans[a][2]=c;
                }
            }

            for(int a=0; a<casee; a++){
                System.out.println("Case #"+(a+1)+": "+ans[a][0]+" "+ans[a][1]+" "+ans[a][2]);
            }
        }
    }

}