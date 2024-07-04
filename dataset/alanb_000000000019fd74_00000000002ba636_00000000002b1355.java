import java.io.FileNotFoundException;
import java.util.Scanner;

class Solution {//rename to solution
    public static void main(String[] args) throws FileNotFoundException {
        Scanner scan = new Scanner(System.in);
        int T = scan.nextInt();
        for(int t = 0; t < T; t++){
            int r = scan.nextInt();
            int c = scan.nextInt();
            Dancer[][] dancers = new Dancer[r][c];
            for(int i = 0; i < r; i++){
                for(int j = 0; j < c; j++){
                    dancers[i][j] = new Dancer(scan.nextInt());
                }
            }//setup dancers
            for(int i = 0; i < r; i++){
                for(int j = 0; j < c; j++){
                    if(i-1>=0)
                        dancers[i][j].u = dancers[i-1][j];
                    else {
                        dancers[i][j].u = new Dancer(0);
                        dancers[i][j].u.deleted=true;
                    }
                    if(j-1>=0)
                        dancers[i][j].l = dancers[i][j-1];
                    else {
                        dancers[i][j].l = new Dancer(0);
                        dancers[i][j].l.deleted=true;
                    }
                    if(i+1<r)
                        dancers[i][j].d = dancers[i+1][j];
                    else {
                        dancers[i][j].d = new Dancer(0);
                        dancers[i][j].d.deleted=true;
                    }
                    if(j+1<c)
                        dancers[i][j].r = dancers[i][j+1];
                    else {
                        dancers[i][j].r = new Dancer(0);
                        dancers[i][j].r.deleted=true;
                    }
                }
            }
            long total = 0;
            boolean updated = true;
            while(updated){
                updated = false;
                for(int i = 0; i < r; i++){
                    for(int j = 0; j < c; j++) {
                        dancers[i][j].update();
                        if(dancers[i][j].toDelete)
                            updated = true;
                    }
                }
                for(int i = 0; i < r; i++){
                    for(int j = 0; j < c; j++) {
                        if(!dancers[i][j].deleted)
                            total+=dancers[i][j].s;
                        if(dancers[i][j].toDelete) {
                            dancers[i][j].delete();
                        }
                    }
                }
            }
            System.out.println("Case #" + (t+1) + ": " + total);
        }
        scan.close();
    }
}
class Dancer{
    public int s;
    public Dancer u;
    public Dancer d;
    public Dancer l;
    public Dancer r;
    public boolean toDelete = false;
    public boolean deleted = false;
    public Dancer(int s) {
        this.s = s;
    }
    public void update(){
        if(deleted) return;
        double total = -0.01;
        int toDivide = 0;
        if(!u.deleted) {
            total += u.s;
            toDivide++;
        }
        if(!d.deleted) {
            total += d.s;
            toDivide++;
        }
        if(!l.deleted) {
            total += l.s;
            toDivide++;
        }
        if(!r.deleted) {
            total += r.s;
            toDivide++;
        }
        if(toDivide != 0) {
            total /= toDivide;
            if (s < total) {
                toDelete = true;
            }
        }
    }
    public void delete(){
        toDelete = false;
        deleted = true;
        u.d = d;
        d.u = u;
        l.r = r;
        r.l = l;
    }
}