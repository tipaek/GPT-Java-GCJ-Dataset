import java.io.*;
import java.util.*;



public class Solution {
    public static void main(String[] Args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int n=in.nextInt();
        for(int i=1;i<=n;i++){
            int actividades = in.nextInt();
            Interval cameron= null;
            Interval jhon =null;
            String sol="";
            for(int j=0;j<actividades;j++){
                int a=in.nextInt();
                int b=in.nextInt();
                if(j==0){
                    cameron = new Interval(a,b);
                    sol=sol+"C";
                }else{
                    boolean puedecameron= cameron.union(a,b);
                    if(puedecameron){
                        sol=sol+"C";
                    }else{
                        if(jhon==null){
                            jhon = new Interval(a,b);
                            sol=sol+"J";
                        }else{
                            boolean puedejhon = jhon.union(a,b);
                            if(puedejhon){
                                sol=sol+"J";
                            }else{
                                sol="IMPOSSIBLE";
                                break;
                            }
                        }
                    }
                }

            }
            System.out.println("Case #"+i+": "+sol);
        }
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

