import java.util.Scanner;

public class Solution {
    static Scanner s = new Scanner(System.in);
    public static void main(String []args){
        int t = s.nextInt();
        int a = s.nextInt();
        int b = s.nextInt();
        for(int i=1; i<=t; i++){
            encuentraSolucion();
        }
    }
    public static void encuentraSolucion(){
        int x1 = 1000000000/3;
        int y1 = -1000000000;
        boolean yaBuscar = false;
        for(int j=0; j<10; j++){
            y1 = y1 + 200000000;
            System.out.println(x1+" "+y1);
            System.out.flush();
            String respuesta = s.next();
            if( respuesta.equals("CENTER") ){
                return;
            }
            else if( respuesta.equals("HIT") ){
                yaBuscar = true;
                break;
            }
        }
        if(!yaBuscar){
            x1 = -1000000000 / 3;
            for(int j=0; j<10; j++){
                y1 = y1 + 200000000;
                System.out.println(x1+" "+y1);
                System.out.flush();
                String respuesta = s.next();
                if( respuesta.equals("CENTER") ){
                    return;
                }
                else if( respuesta.equals("HIT") ){
                    break;
                }
            }
        }
        int izquierda, derecha;
        int x_a = -1000000000;
        int x_b = x1;
        while(true){
            int promedio = (x_a + x_b) / 2;
            System.out.println(promedio+" "+y1);
            System.out.flush();
            String respuesta = s.next();
            if( respuesta.equals("CENTER") ){
                return;
            }
            else if( respuesta.equals("HIT") ){
                x_b = promedio; 
            }
            else {
                x_a = promedio;
            }
            if( x_a + 1 == x_b ){
                break;
            }
        }
        int x_c = x1;
        int x_d = 1000000000;
        while(true){
            int promedio = (x_c + x_d) / 2;
            System.out.println(promedio+" "+y1);
            System.out.flush();
            String respuesta = s.next();
            if( respuesta.equals("CENTER") ){
                return;
            }
            else if( respuesta.equals("HIT") ){
                x_c = promedio; 
            }
            else {
                x_d = promedio;
            }
            if( x_c + 1 == x_d ){
                break;
            }
        }
        System.out.println(x_a+" "+y1);
        System.out.flush();
        String respuesta = s.next();
        if( respuesta.equals("HIT") ){
            izquierda = x_a;
        }
        else if( respuesta.equals("CENTER")){
            return;
        }
        else{
            izquierda = x_b;
        }
        System.out.println(x_d+" "+y1);
        System.out.flush();
        respuesta = s.next();
        if( respuesta.equals("HIT") ){
            derecha = x_d;
        }
        else if( respuesta.equals("CENTER")){
            return;
        }
        else{
            derecha = x_c;
        }
        ///////
        int centroX = (izquierda + derecha) / 2;
        ///////
        int y_a = -1000000000;
        int y_b = y1;
        while(true){
            int promedio = (y_a + y_b) / 2;
            System.out.println(x1+" "+promedio);
            System.out.flush();
            respuesta = s.next();
            if( respuesta.equals("CENTER") ){
                return;
            }
            else if( respuesta.equals("HIT") ){
                y_b = promedio; 
            }
            else {
                y_a = promedio;
            }
            if( y_a + 1 == y_b ){
                break;
            }
        }
        int y_c = y1;
        int y_d = 1000000000;
        while(true){
            int promedio = (y_c + y_d) / 2;
            System.out.println(x1+" "+promedio);
            System.out.flush();
            respuesta = s.next();
            if( respuesta.equals("CENTER") ){
                return;
            }
            else if( respuesta.equals("HIT") ){
                y_c = promedio; 
            }
            else {
                y_d = promedio;
            }
            if( y_c + 1 == y_d ){
                break;
            }
        }
        System.out.println(x1+" "+y_d);
        System.out.flush();
        respuesta = s.next();
        if( respuesta.equals("HIT") ){
            izquierda = y_a;
        }
        else if( respuesta.equals("CENTER")){
            return;
        }
        else{
            izquierda = y_b;
        }
        System.out.println(x1+" "+y_c);
        System.out.flush();
        respuesta = s.next();
        if( respuesta.equals("HIT") ){
            derecha = y_d;
        }
        else if( respuesta.equals("CENTER")){
            return;
        }
        else{
            derecha = y_c;
        }
        int promedioY = (izquierda + derecha) / 2;
        System.out.println(centroX+" "+promedioY);
        String basura = s.next();
        
        
    }
}