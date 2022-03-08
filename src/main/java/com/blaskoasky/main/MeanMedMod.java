package com.blaskoasky.main;

import java.io.*;
import java.util.*;

public class MeanMedMod {

    public List<Integer> read(String path) {
        try {
            File file = new File(path);
            FileReader fr = new FileReader(file);
            BufferedReader reader = new BufferedReader(fr);

            var line = " ";
            String[] tempArr;

            List<Integer> listInt = new ArrayList<>();

            while ((line = reader.readLine()) != null) {
                tempArr = line.split(";");

                for (int i = 0; i < tempArr.length; i++) {
                    if (i == 0) {

                    } else {
                        var temp = tempArr[i];
                        var intTemp = Integer.parseInt(temp);
                        listInt.add(intTemp);
                    }

                }
            }
            reader.close();
            return listInt;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public void write(String savePlace) {

        Menu menu = new Menu();

        try {
            File file = new File(savePlace);
            if (file.createNewFile()) {
                System.out.println("File saved disini -> " + savePlace);
            }
            FileWriter writer = new FileWriter(file);
            BufferedWriter bwr = new BufferedWriter(writer);

            bwr.write("Berikut Hasil Pengolahan Nilai:\n");
            bwr.write(" \n");
            bwr.write("Berikut hasil sebaran data nilai\n");

            // MEAN
            bwr.write("Mean   : " + String.format("%.2f", mean(read(menu.csvPath))));
            bwr.write("\n");

            // MEDIAN
            bwr.write("Median : " + median(read(menu.csvPath)) + "\n");

            // MODUS
            bwr.write("Modus  : " + mode(read(menu.csvPath)) + "\n");
            bwr.write("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\nRian Tampan :)");


            bwr.flush();
            bwr.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void writeMod(String saveMod) {

        Menu menu = new Menu();

        try {
            File file = new File(saveMod);
            if (file.createNewFile()) {
                System.out.println("File saved disini ->: " + saveMod);
            }
            FileWriter writer = new FileWriter(file);
            BufferedWriter bwr = new BufferedWriter(writer);
            var hMap = freq(read(menu.csvPath));

            bwr.write("Berikut Hasil Pengolahan Nilai:\n");
            bwr.write(" \n");
            bwr.write("Nilai\t\t\t\t" + "|\t\t" + "Frekuensi" + "\n");
            bwr.write("5" + "\t\t\t\t\t" + "|\t\t" + hMap.get(5) + "\n");
            bwr.write("6" + "\t\t\t\t\t" + "|\t\t" + hMap.get(6) + "\n");
            bwr.write("7" + "\t\t\t\t\t" + "|\t\t" + hMap.get(7) + "\n");
            bwr.write("8" + "\t\t\t\t\t" + "|\t\t" + hMap.get(8) + "\n");
            bwr.write("9" + "\t\t\t\t\t" + "|\t\t" + hMap.get(9) + "\n");
            bwr.write("10" + "\t\t\t\t\t" + "|\t\t" + hMap.get(10) + "\n");
            bwr.write("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\nRian Tampan :)");


            bwr.flush();
            bwr.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    // RUMUS
    private double mean(List<Integer> list) {
        return list.stream()
                .mapToDouble(d -> d)
                .average()
                .orElse(0.0);
    }

    private double median(List<Integer> numArray) {
        Arrays.sort(new List[]{numArray});
        double median;
        if (numArray.size() % 2 == 0)
            median = ((double) numArray.get(numArray.size() / 2) + (double) numArray.get(numArray.size() / 2 - 1)) / 2;
        else
            median = (double) numArray.get(numArray.size() / 2);
        return median;
    }

    private int mode(List<Integer> array) {
        HashMap<Integer, Integer> hm = new HashMap<>();
        int max = 1;
        int temp = 0;

        for (Integer integer : array) {

            if (hm.get(integer) != null) {

                int count = hm.get(integer);
                count++;
                hm.put(integer, count);

                if (count > max) {
                    max = count;
                    temp = integer;
                }
            } else
                hm.put(integer, 1);
        }
        return temp;
    }

    public Map<Integer, Integer> freq(List<Integer> array) {
        Set<Integer> distinct = new HashSet<>(array);
        Map<Integer, Integer> mMap = new HashMap<>();

        for (Integer s : distinct) {
            mMap.put(s, Collections.frequency(array, s));
        }
        return mMap;
    }
}
