package lab1;

import java.io.*;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.RoundingMode;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static final String PATH = "SistemAnalize";
    private static final DecimalFormat df = new DecimalFormat("0.00");

    public static int getK(Double[] array) {
        List<Double> even = new ArrayList<>();
        List<Double> odd = new ArrayList<>();
        int counter = 0;
        for (int i = 0; i < 100; i++) {
            if (i % 2 == 0) {
                even.add(array[i]);
            } else {
                odd.add(array[i]);
            }
        }

        for (int i = 0; i < 50; i++) {
            if (odd.get(i) * odd.get(i) + even.get(i) * even.get(i) < 1) {
                counter++;
            }
        }
        return counter;
    }

    public static void getRepeat(Double[] array) {
        List<Double> list = Arrays.asList(array);
        List<Double> resultList = new ArrayList<>();
        List<Double> resultList2 = new ArrayList<>();
        List<Double> resultList3 = new ArrayList<>();
        List<Double> resultList4 = new ArrayList<>();
        List<Double> resultList5 = new ArrayList<>();
        List<Double> resultList6 = new ArrayList<>();
        List<Double> resultList7 = new ArrayList<>();

        for (Double d : list) {
            if (d <= 0.14) {
                resultList.add(d);
            } else if (d >= 0.14 && d <= 0.28) {
                resultList2.add(d);
            } else if (d >= 0.28 && d <= 0.42) {
                resultList3.add(d);
            } else if (d >= 0.42 && d <= 0.56) {
                resultList4.add(d);
            } else if (d >= 0.56 && d <= 0.7) {
                resultList5.add(d);
            } else if (d >= 0.7 && d <= 0.84) {
                resultList6.add(d);
            } else if (d >= 0.84 && d <= 1) {
                resultList7.add(d);
            }
        }

        System.out.println("0 - 0.14 : " + resultList.size() + " : " + resultList);
        System.out.println("0.14 - 0.28 : " + resultList2.size() + " : " + resultList);
        System.out.println("0.28 - 0.42 : " + resultList3.size() + " : " + resultList);
        System.out.println("0.42 - 0.56 : " + resultList4.size() + " : " + resultList);
        System.out.println("0.56 - 0.7 : " + resultList5.size() + " : " + resultList);
        System.out.println("0.7 - 0.84 : " + resultList6.size() + " : " + resultList);
        System.out.println("0.84 - 1 : " + resultList7.size() + " : " + resultList);
    }

    public static void main(String[] args) {
        generateValuesWithBIAndWriteInFile();
    }

    public static List<BigDecimal> generateValues(BigDecimal R, BigDecimal a, BigDecimal m, int loopSize) {
        List<BigDecimal> generatedValues = new ArrayList<>();
        BigDecimal RnMinusOne = R;
        try (BufferedWriter writer = Files.newBufferedWriter(Path.of(PATH), StandardCharsets.UTF_8)) {
            for (int i = 0; i < loopSize; i++) {
                BigDecimal aRnMinusOne = a.multiply(RnMinusOne);
                BigDecimal Rn = aRnMinusOne.remainder(m);
                BigDecimal generatedValue = Rn.divide(m, 10, RoundingMode.DOWN);
                generatedValues.add(generatedValue);
                writer.write(generatedValue + "\n");
                RnMinusOne = Rn;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return generatedValues;
    }

    public static void generateValuesWithBIAndWriteInFile() {
        List<Integer> listOfI = new ArrayList<>();
        List<BigDecimal> generatedValues;
        int n = 32;
        BigDecimal R = BigDecimal
                .valueOf(2)
                .pow(n)
                .subtract(BigDecimal.valueOf(5));
        BigDecimal a = BigDecimal
                .valueOf(2)
                .pow(n - 2);
        BigDecimal m = BigDecimal
                .valueOf(2)
                .pow(n)
                .subtract(BigDecimal.valueOf(3));
        generatedValues = generateValues(R, a, m, 100000);
        BigDecimal Xv = generatedValues.get(99999);
        generatedValues = generateValues(R, a, m, 200000);
        for (int i = 0; i < generatedValues.size(); i++) {
            if (generatedValues.get(i).equals(Xv)) {
                listOfI.add(i);
            }
        }

        int P = listOfI.get(1) - listOfI.get(0);
        for (int i = 0; i < generatedValues.size(); i++) {
            BigDecimal xi3 = generatedValues.get(i);
            BigDecimal xi3PlusP = generatedValues.get(P + i);
            if (xi3.equals(xi3PlusP)) {
                System.out.println("i3 = " + i);
                return;
            }
        }
    }

    public static void generateValuesAndWriteInFile() {
        Path path = Paths.get(PATH);
        try (BufferedWriter writer = Files.newBufferedWriter(path, StandardCharsets.UTF_8)) {
            int n = 100000;
            int R = 349123;
            int a = 399123;
            int m = 391123;
            double RnMinusOne = R;
            for (int i = 0; i < n; i++) {
                double aRnMinusOne = a * (RnMinusOne);
                double Rn = aRnMinusOne % (m);
                double generatedValue = Rn / (m);
                writer.write(generatedValue + "\n");
                RnMinusOne = Rn;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void getP() {
        Path path = Paths.get("SistemAnalize");
        List<Integer> listOfI = new ArrayList<>();
        int n = 100000;
        int R = 349123;
        int a = 399123;
        int m = 391123;
        double RnMinusOne = R;
        double Xv = 0;
        for (int i = 0; i < n; i++) {
            double aRnMinusOne = a * RnMinusOne;
            double Rn = aRnMinusOne % m;
            double generatedValue = Rn / m;
            if (i == 99999) {
                Xv = generatedValue;
                break;
            }
        }
        System.out.println("firdt loop = " + Xv);
        for (int i = 0; i < n; i++) {
            double aRnMinusOne = a * RnMinusOne;
            double Rn = aRnMinusOne % m;
            double generatedValue = Rn / m;
            RnMinusOne = Rn;
            if (generatedValue == Xv) {
                listOfI.add(i);
                System.out.println("second loop = " + generatedValue);
            }
        }
        System.out.println(listOfI.get(1) - listOfI.get(0));

    }
}
