import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static java.util.Collections.sort;

public class Main {

    private static boolean isDigit(String s) {
        try {
            Integer.parseInt(s);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    private static List<Integer> BubbleSort(List<Integer> src) {
        List<Integer> result = new ArrayList<Integer>(src);
        for (int i = 0; i < result.size() - 1; i++) {
            boolean cont = false;
            for (int x = 0; x < result.size() - i - 1; x++) {
                if (result.get(x) > result.get(x+1)) {
                    int prevX = result.get(x);
                    result.set(x, result.get(x+1));
                    result.set(x+1, prevX);
                    cont = true;
                }
            }
            if (!cont)
                break;
        }
        return result;
    }

    private static int simpleSearch(List<Integer> arr, int num) {
        for (int i = 0; i<arr.size(); i++) {
            if (arr.get(i) == num)
                return i;
        }
        return -1;
    }

    public  static int binSearch(List<Integer> arr, int num) {
        int max = arr.size();
        int min = 0;
        while (true) {
            int cur = min + ((max - min) / 2);
            int curVal = arr.get(cur);
            if (curVal < num) {
                if (cur == min)
                    break;
                min = cur;
            }
            else if (curVal > num)
                max = cur;
            else
                return cur;
        }
        return -1;
    }


    public static void main(String[] args) {
        try {
            String in;
            BufferedReader reader =  new BufferedReader(new InputStreamReader(System.in));
            //List<Integer> buff = new ArrayList<Integer>();
            List<String> buff = new ArrayList<String>();
            System.out.println("Введите элементы массива:");

            for (;;) {
            //    in = reader.readLine();
            //    if (!isDigit(in))
            //        break;
            //    buff.add(Integer.parseInt(in));
                in = reader.readLine();
                if (in.isEmpty())
                    break;
                buff.add(in);
            }

            //buff = BubbleSort(buff);
            sort(buff);

            System.out.println(buff.toString());

            //for (;;) {
            //    System.out.println("Введите значение, которое требуется найти:");
            //    in = reader.readLine();
            //    if (!isDigit(in)) {
            //        System.out.println("Ошибка, введено не число");
            //        continue;
            //    }
            //    break;
            //}
            //int index = binSearch(buff, Integer.parseInt(in));
            //if (index != -1) {
            //    System.out.println(index);
            //} else {
            //    System.out.println("Ничего не найдено");
            //}

        }
        catch (Exception e) {
            System.out.println("Error exception");
            System.out.println(e.toString());
        }
    }
}
