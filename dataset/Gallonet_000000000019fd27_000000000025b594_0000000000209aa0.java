import java.util.*;

public class Solution {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        
        int casos = sc.nextInt();sc.nextLine();

        for (int i=1; i <= casos; i++){

            int n = sc.nextInt();
            int k = sc.nextInt();

            //La diagonal solo puede valer o la suma de todos los numeros o n*[uno de los numeros]
            //1 2 3 4
            //2 3 4 1
            //3 4 1 2
            //4 1 2 3
            //Para este caso es 8 = 4*num2
            //Y creo que esto se cumple siempre

            int inicio = 1; //Lo utilizo para imprimir la matriz si es posible
            int traza = 0;
            boolean posible = false;
            for (int j=1; j <= n; j++){
                traza += j;
                if (k == j*n){
                    posible = true;
                    inicio = j;
                    break;
                }
            }

            if (posible){
                System.out.printf("Case #%d: POSSIBLE\n",i);
                for (int j=1; j <= n ; j++){ //n lineas
                    System.out.print(inicio);
                    for (int j2=inicio+1; j2 < n+inicio; j2++){
                        System.out.print(" "+(j2-(n*((j2-1)/n))));
                    }
                    inicio--;
                    if (inicio == 0) inicio = n;
                    System.out.println();
                }
            }else{
                //Podria ser igual a la suma de todos
                if (n >2 && k == traza){ //Mayor que dos porque para 2 no se cumple
                    System.out.printf("Case #%d: POSSIBLE\n",i);
                    for (int j=1; j <= n ; j++){ //n lineas
                        System.out.print(inicio);
                        for (int j2=inicio+1; j2 < n+inicio; j2++){
                            System.out.print(" "+(j2-(n*((j2-1)/n))));
                        }
                        inicio++;
                        if (inicio > n) inicio = 1;
                        System.out.println();
                    }
                }else{
                    System.out.printf("Case #%d: IMPOSSIBLE\n",i);
                }
                
            }
            
            
            

                
        }
    
    }
}