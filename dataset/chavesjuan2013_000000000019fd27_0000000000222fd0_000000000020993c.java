import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;

class Solution {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int casos = Integer.parseInt(br.readLine());
        int cant;
        HashSet<Integer> usados;
        String s[];
        int matriz[][];

        for(int k = 0; k < casos; ++k)
        {
            cant = Integer.parseInt(br.readLine());

            matriz = new int [cant][cant];
            for(int i = 0; i < cant; ++i)
            {
                s = br.readLine().split(" ");
                for(int j = 0; j < cant; ++j)
                {
                    matriz[i][j] = Integer.parseInt(s[j]);
                }
            }

            int suma = 0;

            for(int i = 0; i < cant; ++i)
            {
                suma += matriz[i][i];
            }

            int columns = 0;
            int rows = 0;

            for(int i = 0; i < cant; ++i)
            {
                usados = new HashSet<>();

                for(int j = 0; j < cant; ++j)
                {
                    if(usados.contains(matriz[i][j]))
                    {
                        rows++;
                        break;
                    }

                    usados.add(matriz[i][j]);
                }
            }

            for(int j = 0; j < cant; ++j)
            {
                usados = new HashSet<>();

                for(int i = 0; i < cant; ++i)
                {
                    if(usados.contains(matriz[i][j]))
                    {
                        columns++;
                        break;
                    }

                    usados.add(matriz[i][j]);
                }
            }

            System.out.println("Case #"+(k+1)+": "+suma+" "+rows+" "+columns);
        }
    }
}