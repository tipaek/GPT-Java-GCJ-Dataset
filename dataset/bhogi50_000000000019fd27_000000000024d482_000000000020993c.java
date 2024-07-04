import java.util.*;
import java.io.*;
class prog1{
    public static void main(String args[]){
        Scanner s=new Scanner(System.in);
        int n=s.nextInt();
        for(int i=0;i<n;i++){
            int p=s.nextInt();
            ArrayList<ArrayList<Integer>> a=new ArrayList<ArrayList<Integer>>(p);
            for(int l=0;l<p;l++){
                ArrayList<Integer> b=new ArrayList<>();
                for(int k=0;k<p;k++){
                    b.add(s.nextInt());
                }
                a.add(b);
            }
            int sum=0,c1=0,c2=0;
            for(int l=0;l<p;l++){
                sum+=a.get(l).get(l);
            }
            for(int l=0;l<p;l++){
                int f=0;
                for(int k=0;k<p;k++){
                    for(int m=0;m<p;m++){
                        if(k==m){
                            continue;
                        }
                        if(a.get(l).get(k)==a.get(k).get(m)){
                            c1+=1;
                            f=1;
                            break;
                        }
                    }
                    if(f==1){
                        break;
                    }
                }
            }
            System.out.println(sum+''+c1);
        }
    }
}