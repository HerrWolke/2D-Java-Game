package de.mrcloud.game;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class InfoUnterricht {
    static List<Double> calcTimesSmall = new ArrayList<Double>();
    static List<Double> calcTimesBig = new ArrayList<Double>();
    static int[] arrayy;

    public static void main(String[] args) {
        arrayy = genArray();
        for (int x = 0; x < 10; x++) {


            sortBigToLast(arrayy);
            sortSmallToLast(arrayy);
        }

        double totalCalcTimeBig = 0;
        double totalCalcTimeSmall = 0;

        for (double x : calcTimesSmall) {
            totalCalcTimeSmall += x;
        }

        for (double x : calcTimesBig) {
            totalCalcTimeBig += x;
        }

        System.out.println("Total time small: " + totalCalcTimeSmall);
        System.out.println("Total time big: " + totalCalcTimeBig);
    }

    public static int[] genArray() {
        final int[][] array2 = new int[1][1];
        new Thread(() -> {
            int[] array = new int[99999999];
            for (int i = 0; i < array.length; i++) {
                Random random = new Random();
                array[i] = random.nextInt(900000000) - 400000000;
            }

            array2[0] = array;

        }).start();

        return array2[0];

    }

    public static int getSmallestObject(int[] array) {
        boolean firstRun = true;
        int smallest = -20;

        for (int num : array) {


            if (!firstRun) {
                if (smallest > num)
                    smallest = num;
            } else {
                smallest = num;
                firstRun = false;
            }


        }

        return smallest;
    }

    public static int getSmallestObject2(int[] array) {
        int smallest = 0;

        for (int i = 0; i < array.length; i++) {


            if (i != 0) {
                if (smallest > array[i])
                    smallest = array[i];
            } else {
                smallest = array[i];
            }


        }

        return smallest;
    }

    public static String generateLuaTable() {
        String list = "0: Compacts  \n" +
                "1: Sedans  \n" +
                "2: SUVs  \n" +
                "3: Coupes  \n" +
                "4: Muscle  \n" +
                "5: Sports Classics  \n" +
                "6: Sports  \n" +
                "7: Super  \n" +
                "8: Motorcycles  \n" +
                "9: Off-road  \n" +
                "10: Industrial  \n" +
                "11: Utility  \n" +
                "12: Vans  \n" +
                "13: Cycles  \n" +
                "14: Boats  \n" +
                "15: Helicopters  \n" +
                "16: Planes  \n" +
                "17: Service  \n" +
                "18: Emergency  \n" +
                "19: Military  \n" +
                "20: Commercial  \n" +
                "21: Trains ";

        list = list.replaceAll("\\d*: ", "");
        String[] string = list.split("  \n");
        System.out.println(string[1]);

        String print = "";
        for (int i = 0; i < string.length - 1; i++) {
            print += String.format("\"%s\",", string[i]);
        }
        System.out.println(print);
        return null;
    }

    public static void genEnsure() {
        File file = new File("D:/DOWNLOADS/Carsss");
        String[] paths = file.list();
        for (String string : paths) {
            System.out.println("ensure " + string);
        }

    }

    public static void genXML() {
        File file = new File("D:/DOWNLOADS/2017_CHP_MegaPack_Part_2/2017 CHP MegaPack Part 2/Installation Files");
        String[] paths = file.list();
        for (String string : paths) {
            System.out.println("\"" + string + ".xml\",");
        }

    }

    public static int[] sortSmallToLast(int[] array) {
        long start = System.currentTimeMillis();
        int[] returnValue = new int[array.length];
        int smallest = 0;
        int pos = 0;
        for (int i = 0; i < array.length; i++) {
            if (i == 0) {
                smallest = array[i];
                pos = i;
            } else if (smallest > array[i]) {
                smallest = array[i];
                pos = i;
            }
            returnValue[i] = array[i];

        }
        arrayy = genArray();
        returnValue[returnValue.length - 1] = smallest;
        returnValue[pos] = array[array.length - 1];
        System.out.println("Calculation time small: " + ((System.currentTimeMillis() - start) / 1000.0));
        calcTimesSmall.add(((System.currentTimeMillis() - start) / 1000.0));
        return returnValue;
    }

    public static int[] sortBigToLast(int[] array) {
        long start = System.currentTimeMillis();
        int[] returnValue = new int[array.length];
        int biggest = 0;
        int pos = 0;
        for (int i = 0; i < array.length; i++) {
            if (i == 0) {
                biggest = array[i];
                pos = i;
            } else if (biggest < array[i]) {
                biggest = array[i];
                pos = i;
            }
            returnValue[i] = array[i];

        }

        returnValue[returnValue.length - 1] = biggest;
        returnValue[pos] = array[array.length - 1];
        System.out.println("Calculation time big: " + ((System.currentTimeMillis() - start) / 1000.0));
        calcTimesBig.add(((System.currentTimeMillis() - start) / 1000.0));
        return returnValue;
    }
}
