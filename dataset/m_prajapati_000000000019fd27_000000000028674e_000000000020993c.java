import java.util.*;

class Demo{

    public static void main(String args[]){

        Scanner sc =new Scanner(System.in);

        int t = sc.nextInt();

        for(int x=0; x<t; x++)
        {
            int n = sc.nextInt();
            int[][] m = new int[n][n];
            int countR = 0,countC = 0,sum = 0;
            boolean check;

            for(int i=0; i<n; i++)
                for(int j=0; j<n; j++)
                    m[i][j] = sc.nextInt();

            for(int i=0; i<n; i++)
                sum += m[i][i];

            for(int k=0; k<n; k++){
                check = false;
                for(int i=0; i<n-1; i++){
                    for(int j=i+1; j<n; j++){
                        if(m[k][i]==m[k][j]){
                            countR++;
                            check = true;
                            break;
                        }
                    }
                    if(check) break;
                }
            }

            for(int k=0; k<n; k++){
                check = false;
                for(int i=0; i<n-1; i++){
                    for(int j=i+1; j<n; j++){
                        if(m[i][k]==m[j][k]){
                            countC++;
                            check = true;
                            break;
                        }
                    }
                    if(check) break;
                }
            }
            System.out.println(sum+" "+countR+" "+countC);
        }
    }
}
