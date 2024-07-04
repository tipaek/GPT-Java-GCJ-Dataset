import java.io.*;
import java.util.*;



public class Solution {
    public static void main(String[] Args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int n=in.nextInt();
        for(int i=1;i<=n;i++){
            int actividades = in.nextInt();
            Lista lista =null;
            for(int j =0;j<actividades;j++){
                if(j==0){
                    lista=new Lista(in.nextInt(),in.nextInt(),j);
                }else{
                    lista.meter(in.nextInt(),in.nextInt(),j);
                }
            }
            String[] solucion = new String[actividades];


            Interval cameron= null;
            Interval jhon =null;
            String sol="";
            for(int j=0;j<actividades;j++){
                int[] aux = lista.get(j);
                int a=aux[0];
                int b=aux[1];
                int posicion=aux[2];
                if(j==0){
                    cameron = new Interval(a,b);
                    solucion[posicion]="C";
                }else{
                    boolean puedecameron= cameron.union(a,b);
                    if(puedecameron){
                        solucion[posicion]="C";
                    }else{
                        if(jhon==null){
                            jhon = new Interval(a,b);
                            solucion[posicion]="J";
                        }else{
                            boolean puedejhon = jhon.union(a,b);
                            if(puedejhon){
                                solucion[posicion]="J";
                            }else{
                                sol="IMPOSSIBLE";
                                break;
                            }
                        }
                    }
                }

            }
            if(sol.equals("IMPOSSIBLE")){
                System.out.println("Case #"+i+": "+sol);
            }else{
                sol="";
                for(int q=0;q<actividades;q++){
                    sol=sol+solucion[q];
                }
                System.out.println("Case #"+i+": "+sol);
            }

        }
    }
}
class Lista{
    private ArrayList<int[]> inter = new ArrayList<>();

    public Lista(int a,int b,int c){
        int[] aux = new int[3];
        aux[0]=a;
        aux[1]=b;
        aux[2]=c;
        this.inter.add(aux);
    }

    public int[] get(int i){
        return(this.inter.get(i));
    }

    public boolean meter(int a, int b,int c){
        int [] aux= new int[3];
        aux[0]=a;
        aux[1]=b;
        aux[2]=c;
        int m=-1;
        for(int i=0;i<this.inter.size();i++){
            int[] megaux = this.inter.get(i);
            if(megaux[0]>a){
                m=i;
                break;
            }
        }
        if(m==-1){
            this.inter.add(this.inter.size(),aux);
        }else{
            this.inter.add(m,aux);
        }

        return true;
    }
}

class Interval{
    private ArrayList<int[]> inter = new ArrayList<>();

    public Interval(int a,int b){
        int[] aux = new int[2];
        aux[0]=a;
        aux[1]=b;
        this.inter.add(aux);
    }


    public boolean union(int a,int b){
        int elmay=-1;
        boolean encontrado =false;
        boolean primero=true;
        int[] menor= new int[2];
        int[] mayor= new int[2];
        for(int i=0;i<this.inter.size();i++){
            int[] aux= this.inter.get(i);
            if(aux[1]>a){
                elmay=i;
                encontrado=true;
                mayor=aux;
                if(i!=0){
                    primero=false;
                    menor=this.inter.get(i-1);
                }
                break;
            }
        }

        if(encontrado==false){
            int[] megaux=new int[2];
            megaux[0]=a;
            megaux[1]=b;
            this.inter.add(this.inter.size(),megaux);
            return true;
        }
        else if(encontrado== true && primero==true){
            if(b<=inter.get(0)[0]){
                int[] megaux=new int[2];
                megaux[0]=a;
                megaux[1]=b;
                this.inter.add(0,megaux);
                return true;
            }else return false;
        }else{
            if(menor[1]<=a && mayor[0]>=b){
                int[] megaux=new int[2];
                megaux[0]=a;
                megaux[1]=b;
                this.inter.add(elmay,megaux);
            }else return false;
        }
        return false;
    }
}

