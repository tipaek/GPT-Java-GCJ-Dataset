import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

class Solution {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int casos = Integer.parseInt(br.readLine());

        for(int i = 0; i < casos; ++i)
        {
            int cant = Integer.parseInt(br.readLine());
            ArrayList<actividad> temp = new ArrayList<>();
            ArrayList<pair> aux = new ArrayList<>();

            for(int j = 0; j < cant; ++j)
            {
                String nums[] = br.readLine().split(" ");
                temp.add(new actividad(Integer.parseInt(nums[0]),Integer.parseInt(nums[1]), j));
                aux.add(new pair(Integer.parseInt(nums[0]), 1));
                aux.add(new pair(Integer.parseInt(nums[1]),0));
            }

            Collections.sort(temp, new Comparator<actividad>() {
                        @Override
                        public int compare(actividad o1, actividad o2) {
                            if(o1.s != o2.s)
                                return o1.s - o2.s;
                            return o1.f - o2.f;
                        }
                    }
            );

            Collections.sort(aux, new Comparator<pair>() {
                @Override
                public int compare(pair o1, pair o2) {
                    if(o1.a != o2.a)
                        return o1.a - o2.a;
                    return o1.b - o2.b;
                }
            });


            int cont = 0;
            boolean sePuede = true;

            for(int k = 0; k < aux.size() && sePuede; ++k)
            {
                if(aux.get(k).b == 0)
                    cont--;
                else
                    cont++;

                if(cont>2)
                    sePuede = false;
            }

            temp.get(0).responsable = "C";

            actividad cameronCurrent = temp.get(0);

            for(int k = 1; k < cant &&sePuede; ++k)
            {
                if(overlap(cameronCurrent, temp.get(k)))
                {
                    temp.get(k).responsable = "J";
                }
                else
                {
                    temp.get(k).responsable = "C";
                    cameronCurrent = temp.get(k);
                }
            }

            Collections.sort(temp, new Comparator<actividad>() {
                        @Override
                        public int compare(actividad o1, actividad o2) {
                            return o1.id - o2.id;
                        }
                    }
            );

            String res="";
            if(sePuede)
            {
                for(int l = 0; l < cant; ++l)
                {
                    res += temp.get(l).responsable;
                }
            }
            else {
                res = "IMPOSSIBLE";
            }

            System.out.println("Case #"+(i+1)+": "+res);
        }
    }

    static boolean overlap(actividad a1, actividad a2)
    {
        if(a2.f <= a1.s || a1.f <= a2.s)
            return  false;
        return true;
    }

    static class actividad{
        int s, f, id;
        String responsable;

        public actividad(int s, int f, int id) {
            this.s = s;
            this.f = f;
            this.id = id;
        }
    }

    static class pair{
        public pair(int a, int b) {
            this.a = a;
            this.b = b;
        }
        int a, b;
    }
}