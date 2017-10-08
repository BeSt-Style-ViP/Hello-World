
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

    public class Main {
        public Main() {
        }

        private static boolean isDigit(String s) throws NumberFormatException {
            try {
                Integer.parseInt(s);
                return true;
            } catch (NumberFormatException var2) {
                return false;
            }
        }

        private static List<Integer> BubbleSort(List<Integer> src) {
            List<Integer> result = new ArrayList(src);

            for(int i = 0; i < result.size() - 1; ++i) {
                boolean cont = false;

                for(int x = 0; x < result.size() - i - 1; ++x) {
                    if (((Integer)result.get(x)).intValue() > ((Integer)result.get(x + 1)).intValue()) {
                        int prevX = ((Integer)result.get(x)).intValue();
                        result.set(x, result.get(x + 1));
                        result.set(x + 1, prevX);
                        cont = true;
                    }
                }

                if (!cont) {
                    break;
                }
            }

            return result;
        }

        public static int search(List<Integer> arr, int num) {
            for(int i = 0; i < arr.size(); ++i) {
                if (((Integer)arr.get(i)).intValue() == num) {
                    return i;
                }
            }

            return -1;
        }

        public static int binSearch(List<Integer> arr, int num) {
            int max = arr.size();
            int min = 0;

            while(true) {
                while(true) {
                    int cur = min + (max - min) / 2;
                    int curVal = ((Integer)arr.get(cur)).intValue();
                    if (curVal < num) {
                        if (cur == min) {
                            return -1;
                        }

                        min = cur;
                    } else {
                        if (curVal <= num) {
                            return cur;
                        }

                        max = cur;
                    }
                }
            }
        }

        public static void main(String[] args) {
            try {
                BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
                List<String> buff = new ArrayList();
                System.out.println("Введите элементы массива:");

                while(true) {
                    String in = reader.readLine();
                    if (in.isEmpty()) {
                        Collections.sort(buff);
                        System.out.println(buff.toString());

                        while(true) {
                            System.out.println("Введите значение, которое требуется найти:");
                            in = reader.readLine();
                            if (isDigit(in)) {
                                return;
                            }

                            System.out.println("Ошибка, введено не число.");
                        }
                    }

                    buff.add(in);
                }
            } catch (Exception var4) {
                System.out.println("Ошибка");
                System.out.println(var4.toString());
            }
        }
    }
