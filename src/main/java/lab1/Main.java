package lab1;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    private static final DecimalFormat df = new DecimalFormat("0.00");

    public static double generateValue(int a, int R, int m) {
        double aRnMinusOne = a * R;
        double Rn = aRnMinusOne % m;
        return Rn / m;
    }

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

        for (Double d:list) {
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
        Double[] array = new Double[]{0.43, 0.35, 0.50, 0.33, 0.35, 0.45, 0.49, 0.19, 0.50, 0.11, 0.11, 0.54, 0.63, 0.01, 0.43, 0.63, 0.23, 0.01, 0.90, 0.73, 0.89, 0.18, 0.37, 0.75, 0.83, 0.66, 0.19, 0.01, 0.24, 0.03, 0.32, 0.44, 0.13, 0.51, 0.63, 0.40, 0.02, 0.28, 0.67, 0.66, 0.77, 0.89, 0.05, 0.06, 0.60, 0.44, 0.21, 0.92, 0.16, 0.51, 0.66, 0.13, 0.94, 0.07, 0.09, 0.55, 0.28, 0.24, 0.67, 0.26, 0.47, 0.15, 0.59, 0.02, 0.16, 0.44, 0.38, 0.10, 0.72, 1.00, 0.06, 0.73, 0.60, 0.28, 0.99, 0.20, 0.92, 0.14, 0.37, 0.71, 0.24, 0.68, 0.91, 0.08, 0.39, 0.13, 0.67, 0.35, 0.28, 0.93, 0.22, 0.59, 0.43, 0.19, 0.40, 0.10, 0.34, 0.08, 0.52, 0.58};

        List<Double> generatedValues = new ArrayList<>();
        int n = 50000;
        int R = 349;
        int a = 399;
        int m = 391;
        double RnMinusOne = R;
        for (int i = 0; i < n; i++) {
            double aRnMinusOne = a * RnMinusOne;
            double Rn = aRnMinusOne % m;
            double generatedValue = Rn / m;
            generatedValues.add(generatedValue);
            RnMinusOne = Rn;
        }
        //System.out.println(generatedValues);
    }
}
