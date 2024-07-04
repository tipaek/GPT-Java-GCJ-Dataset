import java.util.ArrayList;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Solution {

    public static class Tache implements Comparable {

        public int debut;
        public int fin;

        public Tache(int debut, int fin, int index) {
            this.debut = debut;
            this.fin = fin;
        }


        @Override
        public int compareTo(Object o)
        {
            Tache p = (Tache) o;
            if (debut > p.debut) {
                return 1;
            }
            return -1;
        }

    }
     
     public static void main(String args[]) {
        
        Scanner input = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        List<Tache> taches;

        int T = input.nextInt();
        for (int ks = 1; ks <= T; ks++) {
            int N = input.nextInt();
            taches = new ArrayList<>();
            int debut = 0;
            int fin = 0;

            for (int i = 0; i < N; i++) {
                debut = input.nextInt();
                fin = input.nextInt();

                taches.add(new Tache(debut, fin, i));
            }

            solver(taches, N, ks);
        }

    }
     
    public static String generateur(String s, int n) {
        if (s.length() == n) {
            return s + "\n";
        } else {
            return generateur(s + "0", n) + generateur(s + "1", n);
        }
    }
    
    public static boolean checkListeValide(List<Tache> tachesPersonne)
    {
        List<Tache> tachesPersonneTemp = new ArrayList<>();
        for(Tache element : tachesPersonne)
        {
            tachesPersonneTemp.add(element);
        }
        
        Collections.sort(tachesPersonneTemp);

        
        for(int i = 1; i < tachesPersonneTemp.size(); i++)
        {           
            if(tachesPersonneTemp.get(i-1).fin > tachesPersonneTemp.get(i).debut )
            {
                return false;
            }

        }
        
        return true;
    }

    public static void solver(List<Tache> taches, int N, int iteration) {
        
        List<Tache> tachesC = new ArrayList<>();
        List<Tache> tachesJ = new ArrayList<>();
        
        String resultat ="";
        
        String str = generateur("", N);
        String[] permutations = str.split("\n");
        
        for(int i = 0; i < permutations.length; i++)
        {
            tachesC = new ArrayList<>();
            tachesJ = new ArrayList<>();
            //tachesC.add(taches.get(0));
            
            resultat ="";
            
            for(int j = 0; j <permutations[i].length(); j++)
            {
                if(permutations[i].charAt(j)=='0')
                {
                    resultat +="C";
                    tachesC.add(taches.get(j));
                }
                else
                {
                    resultat +="J";
                    tachesJ.add(taches.get(j));
                }
            }

            if(checkListeValide(tachesC) && checkListeValide(tachesJ))
            {
                System.out.println("Case #" + iteration + ": "+resultat);
                return;
            }

        }
        
        System.out.println("Case #" + iteration + ": IMPOSSIBLE");

    }

}