import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class Solution {

    public static class Position
    {
        int x;
        int y;
        
        public Position(int x, int y)
        {
            this.x = x;
            this.y = y;
        }
    }
    public static void main(String args[]) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int T = Integer.parseInt(in.nextLine());  
        try {
            for (int ks = 1; ks <= T; ks++) {
                int r = in.nextInt();
                int c = in.nextInt();
                int[][] tab = new int[r][c];
                for (int i = 0; i < r; i++) {
                    for (int j = 0; j < c; j++) {
                        tab[i][j] = in.nextInt();
                    }
                }
                resolve(ks, r, c, tab);
            }

        } catch (NegativeArraySizeException ex) {
            System.out.println("ex: " + ex);
        }

    }

    public static double averageCompassNeighbors(int[][] tab, int r, int c, int posI, int posJ)
    {
        int haut=0;
        int bas=0;
        int gauche=0;
        int droite=0;
        int posITemp = posI;
        int posJTemp = posJ;
        int nbrNeighbors = 0;
        
        //haut
        while(posI > 0 )
        {
            
            posI--;
            if(tab[posI][posJ]>0)
            {
                haut=tab[posI][posJ];
                nbrNeighbors++;                
                break;
            }
        }
        posI = posITemp;
        //bas
        while(posI < r-1 )
        {
            
            posI++;
            if(tab[posI][posJ]>0)
            {
                bas=tab[posI][posJ];
                nbrNeighbors++;
                break;
            }
        }
        posI = posITemp;
        //gauche
        while(posJ > 0 )
        {
            posJ--;
            if(tab[posI][posJ]>0)
            {
                gauche=tab[posI][posJ];
                nbrNeighbors++;
                break;
            }            
        }
        posJ = posJTemp;
        
        //droite
        while(posJ < c-1 )
        {
            posJ++;
            if(tab[posI][posJ]>0)
            {
                droite=tab[posI][posJ];
                nbrNeighbors++;
                break;
            }
        }

        if(nbrNeighbors > 0)
        {
            return (double)(haut+bas+gauche+droite)/nbrNeighbors;
        }
        
        return 0;
    }
    
    public static void resolve(int ks, int r, int c, int[][] tab) {
        int result = 0;
        int interestLevel=0;
        int averageSkill = 0;
        int remaining = 0;
        
        List<Position> eliminations = new ArrayList<>();
        boolean isEliminationPossible = true;

        while (isEliminationPossible) {
            
            averageSkill = 0;
            for (int i = 0; i < r; i++) {
                for (int j = 0; j < c; j++) {
                    interestLevel+=tab[i][j];
                    if(tab[i][j] != 0)
                    {
                        remaining++;
                    }
                    //System.out.print(tab[i][j] + " ");
                }
                //System.out.println("");
            }

            averageSkill = interestLevel/remaining;
            
            for (int i = 0; i < r; i++) {
                for (int j = 0; j < c; j++) {
                    if(tab[i][j] != 0)
                    {
                        if(tab[i][j] < averageCompassNeighbors(tab, r, c, i, j) )
                        {
                            eliminations.add(new Position(i,j));
                            //tab[i][j] = 0;
                        }
                    }                    
                }                
            }
            
            for(Position elim : eliminations)
            {
                tab[elim.x][elim.y]=0;
            }
            
            /*
            for (int i = 0; i < r; i++) {
                for (int j = 0; j < c; j++) {
                    System.out.print(tab[i][j]+" ");
                }
                System.out.println("");
            }*/
            
            
            
            if(eliminations.size() > 0)
            {
                
                result+= interestLevel;
                interestLevel = 0;
                remaining = 0;
                eliminations.clear();
            }
            else
            {
                result+= interestLevel;                
                isEliminationPossible = false;
            }
        }

        System.out.println("Case #" + ks + ": " + result);
    }

}
