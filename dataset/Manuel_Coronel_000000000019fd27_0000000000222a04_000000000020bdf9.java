import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

class clase implements Comparable {

    int incio;
    int fin;
    String nombre;
    int id;

    public clase(int incio, int fin, int id) {
        this.incio = incio;
        this.fin = fin;
        this.id = id;
    }

    @Override
    public int compareTo(Object t) {
        clase otro = (clase) t;
        if (this.fin < otro.fin) {
            return -1;
        }

        if (this.fin > otro.fin) {
            return 1;
        }

        if (this.incio < otro.incio) {
            return -1;
        }

        if (this.incio > otro.incio) {
            return 1;
        }

        return 0;

    }

}

public class Solution {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int casos = sc.nextInt();
        for (int z = 1; z <= casos; z++) {

            int num = sc.nextInt();
            clase vec[] = new clase[num];
            for (int i = 0; i < num; i++) {
                int inicio = sc.nextInt();
                int fin = sc.nextInt();

                vec[i] = new clase(inicio, fin, i);
            }

            Arrays.sort(vec);

            int c = 0;
            int j = 0;
            boolean impo = false;
            for (int i = 0; i < num; i++) {
                if (c <= vec[i].incio) {
                    c = vec[i].fin;
                    vec[i].nombre = "C";
                } else {
                    if (j <= vec[i].incio) {
                        j = vec[i].fin;
                        vec[i].nombre = "J";
                    } else {
                        impo = true;
                        break;
                    }

                }

            }
            String rta = "";

            if (impo) {
                rta = "IMPOSSIBLE";
            } else {
                for (int i = 0; i < num; i++) {
                    for (int k = 0; k < num; k++) {
                        if (vec[k].id == i) {
                            rta += vec[k].nombre;
                        }

                    }
                }
            }
            System.out.println("Case #" + z + ": " + rta);

        }
    }
}
