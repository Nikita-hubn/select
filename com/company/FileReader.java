package com.company;
import java.io.*;
import java.util.*;

/**
  чтобы программа работала, в файл необходимо ввести три строчки:
  1. номер статистики;
  2. длину массива;
  3. сам массив (числа через пробел)
  основной код реализован в классе Logical

 */
public class FileReader {

    public static void process(InputReader in, PrintWriter out) {
        int k = in.nextInt();
        int length = in.nextInt();

        int[] arr = new int[length];
        for(int i =0; i < length; i++){
            arr[i] = in.nextInt();
        }

        out.println("Данной статистике соответсвует следующий элемент:");
        int j = Logical.select(arr, 0, length-1, k);
        out.println(j);
    }




    public static void main(String[] args) {
        InputStream inputStream;
        OutputStream outputStream;
        try {
            inputStream = new FileInputStream("input1.txt");
            outputStream = new FileOutputStream("output.txt");
        } catch (Exception e) {
            inputStream = System.in;
            outputStream = System.out;
        }

        InputReader in = new InputReader(inputStream);
        PrintWriter out = new PrintWriter(outputStream);

        process(in, out);
        out.close();
    }

    static class InputReader {
        public BufferedReader reader;
        public StringTokenizer tokenizer;

        public InputReader(InputStream stream) {
            reader = new BufferedReader(new InputStreamReader(stream), 32768);
            tokenizer = null;
        }

        public String nextToken() {
            while (tokenizer == null || !tokenizer.hasMoreTokens()) {
                try {
                    tokenizer = new StringTokenizer(reader.readLine());
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
            return tokenizer.nextToken();
        }

        public int nextInt() {
            return Integer.parseInt(nextToken());
        }

        public long nextLong() {
            return Long.parseLong(nextToken());
        }

        public double nextDouble() {
            return Double.parseDouble(nextToken());
        }
    }
}
