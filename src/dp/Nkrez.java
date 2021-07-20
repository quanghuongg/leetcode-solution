/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dp;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javafx.util.Pair;

/**
 *
 * @author huongnq2
 */
//https://oj.vnoi.info/problem/nkrez

public class Nkrez {


    public static void main(String[] args) {
        int MN = 30111;
        List<Pair<Integer, Integer>> events = new ArrayList<>();
        List<List<Integer>> endAt = new ArrayList();
        int[] f = new int[MN];

        try {

            File file = new File("/home/ubuntu/NetBeansProjects/StackLC/data.txt");

            BufferedReader b = new BufferedReader(new FileReader(file));

            String readLine = "";

            System.out.println("Reading file using Buffered Reader");
            int cout = 1;
            int nEvent = 0;
            while ((readLine = b.readLine()) != null) {
                if (cout == 1) {
                    nEvent = Integer.parseInt(readLine);
                } else {
                    String[] strs = readLine.split(" ");
                    events.add(new Pair<>(Integer.parseInt(strs[0]), Integer.parseInt(strs[1])));
                    List<Integer> temp = new ArrayList();;
                    temp.add(Integer.parseInt(strs[1]));
                    temp.add(cout);
                    endAt.add(temp);

                }
                cout++;
            }
            for (int t = 1; t <= 30000; t++) {
                f[t] = f[t - 1];
                for (int id : endAt.get(t - 1)) {
                    System.out.println("id: " + id);
                    if (id < events.size()) {
                        int tep = f[events.get(id).getKey()] + events.get(id).getValue() - events.get(id).getKey();
                        f[t] = Math.max(f[t], tep);
                    }

                }
            }

            System.out.println(f[30000]);

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
