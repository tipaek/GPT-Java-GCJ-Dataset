package solution;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Solver {

    public Solver(String args[], boolean isMocked) throws IOException {
        File file = new File(args[0]);
        List<String> realArgs = new ArrayList<String>();

        BufferedReader br = new BufferedReader(new FileReader(file));

        String st;
        while ((st = br.readLine()) != null) { realArgs.add(st); }

        new Solver(realArgs.toArray(new String[]{}));
    }

    public Solver(String agrs[]) {

    }
}