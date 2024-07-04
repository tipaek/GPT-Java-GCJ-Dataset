import java.util.Scanner;
class Main {

    public static void main(String[] args) {
        int m [][];
        Scanner scan = new Scanner(System.in);
        System.out.println("Ingrese el numero de casos de prueba");
        int T= scan.nextInt();
        
        for(int cont=0;cont<T;cont++){
            System.out.println("numero N");
            int N = scan.nextInt();
            m=new int [N][N];
            
            testCase(m,N,cont);
           
            
        }

    }
    public static int testCase(int m[][], int N, int cont){
        Scanner scan=new Scanner(System.in);
        int tem=0;
        for(int i = 0; i < N ; i++){
            for(int j = 0; j < N ; j++){
                tem=scan.nextInt();
                if(tem<=N && tem>0){
                    m[i][j]=tem;
                    //System.out.print(tem);
                }
                else{
                    System.err.print( tem + ": ERROR: numero tiene que ser dentro del rango de 1 y " + N);
                    System.out.println();
                    System.err.print("Perdiste un turno, por que no se si acabar el programa o volver a reescribir el dato mal escrito, en fin, no esta explicado que accion debe tomarse, yo tomo la q me combiene xD");
                    System.out.println();
                    return 0;
                }
            }
        }
        int rpt[]=traceCFCC(m);
        System.out.print("Caso #"+(cont+1)+": "+rpt[0]+" "+rpt[1]+" "+ rpt[2]);
        System.out.println();
        
        return 1;
       
    }
    public static int [] traceCFCC(int m[][]){
        int trace=0;
        int contF=0;
        int contC=0;
        int exit=0;
        int base=0; 
      
        for(int i=0;i<m.length;i++)
        {
            for (int j = 0;j<m.length;j++){
                if(i==j){
                    trace+=m[i][j];
                }
                //cont of equal elements in each row
                if (j>base){
                    int tempf=j;
                    while (tempf>base){
                        if (m[i][j]==m[i][tempf-1])
                        {
                            contF=contF+1;
                            base=m.length+1;
                        }
                        tempf=tempf-1; 
                    }
                }
                //Change of index 
                if(j>exit){
                    int tempc=j;
                    while(tempc>exit){
                        if(m[j][i]==m[tempc-1][i]){
                            contC=contC+1;
                            exit=m.length+1;
                        }
                        tempc=tempc-1;
                    }
                    
                }
            }
            //Condicionals
            exit=0;
            base=0;
        }
        int devolver [] = {trace,contF,contC};
        return devolver;
    }
}
