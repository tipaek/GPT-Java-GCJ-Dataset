import javafx.util.Pair;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Solution {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        for(int j = 1; j<=T; j++){
            String str = parentingPartneringReturns(br);
            System.out.format("Case #%d: %s\n", j, str);
        }
    }

    public static String parentingPartneringReturns(BufferedReader br) throws IOException {
        class Appointment {
            char assignment;
            int start;
            int end;

            public int getStart() {
                return start;
            }
        }
        int N = Integer.parseInt(br.readLine());

        List<Appointment> initialAppointments = new ArrayList<>();

        for(int i=0; i<N; i++){
            String[] appointment = br.readLine().split(" ");
            Appointment newAppointment = new Appointment();
            newAppointment.start = Integer.parseInt(appointment[0]);
            newAppointment.end = Integer.parseInt(appointment[1]);
            initialAppointments.add(newAppointment);
        }
        List<Appointment> appointments = initialAppointments.stream().sorted(Comparator.comparing(Appointment::getStart)).collect(Collectors.toList());

        Appointment cameron = null;
        Appointment jamie = null;
        if(appointments.size()>0){
            cameron = appointments.get(0);
            cameron.assignment = 'C';
        }
        if(appointments.size()>1) {
            jamie = appointments.get(1);
            jamie.assignment = 'J';
        }
        for(int i=2; i<appointments.size(); i++){

            Appointment current = appointments.get(i);
            if(cameron.end <= current.start){
                cameron = current;
                cameron.assignment = 'C';
            }
            else if(jamie.end <= current.start){
                jamie = current;
                jamie.assignment='J';
            }
            else{
                return "IMPOSSIBLE";
            }
        }

        StringBuilder stringBuilder = new StringBuilder();
        for(Appointment appointment : initialAppointments) {
            stringBuilder.append(appointment.assignment);
        }

        return stringBuilder.toString();
    }

    public static String nestingDepths(BufferedReader br) throws IOException {
        StringBuilder stringBuilder = new StringBuilder();
        int prev = 0;
        String str = br.readLine();

        for(int i=0; i<str.length(); i++){
            int current = str.charAt(i) - '0';
            for(int k=prev; k!=current;){
                if(k<current){
                    stringBuilder.append("(");
                    k++;
                }else{
                    stringBuilder.append(")");
                    k--;
                }
            }
            stringBuilder.append(current);
            prev = current;
        }
        for(;prev>0;prev--)
            stringBuilder.append(")");
        return stringBuilder.toString();
    }

    public static String vestigium(BufferedReader br) throws IOException {
        int N = Integer.parseInt(br.readLine());

        int trace = 0;
        int r = 0;
        int c = 0;

        int[][] matrix = new int[N][N];

        for (int i = 0; i < N; i++) {
            matrix[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            trace += matrix[i][i];
            if (Arrays.stream(matrix[i]).distinct().toArray().length < N) {
                r++;
            }
        }
        for (int i = 0; i < N; i++) {
            final int column = i;
            if (Arrays.stream(matrix).mapToInt(row -> row[column]).distinct().toArray().length < N) {
                c++;
            }
        }
        return String.format("%d %d %d", trace, r, c);
    }
}
