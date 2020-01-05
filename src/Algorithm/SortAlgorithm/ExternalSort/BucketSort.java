package Algorithm.SortAlgorithm.ExternalSort;

import java.io.*;

public class BucketSort {

    /**
     * @param input the input path
     * @param output the output path
     * @param max the max value of input numbers
     * @param step the step of each data processing
     * @throws IOException if there is a exception while operating on the file
     */
    public static void sort(String input, String output, int max, int step) throws IOException {
        int[] bucket = new int[step];
        int n = 0;

        while (step * n < max) {
            // the (n+1)th scan
            BufferedReader reader = new BufferedReader(new FileReader(input));
            String line;
            int value;

            for (int i = 0; i < step; i++) {
                bucket[i] = 0;
            }

            int start = n * step;
            int end = start + step;
            while ((line = reader.readLine()) != null) {
                value = Integer.parseInt(line);
                if (value >= start && value < end)
                    bucket[value - start]++;
            }

            BufferedWriter writer = new BufferedWriter(new FileWriter(output, true));
            for (int i = 0; i < step; i++) {
                int num = bucket[i];
                value = i + start;
                while (num > 0) {
                    writer.write(value + "\n");
                    num--;
                }
            }
            reader.close();
            writer.close();
            n++;
        }
    }

}