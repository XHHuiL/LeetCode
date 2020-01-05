package Algorithm.SortAlgorithm.ExternalSort;

import java.io.*;

public class BitMapSort {

    private static class BitMap {
        /**
         * bits used to record the occurrence of each value
         * 0 means not present, 1 means present
         */
        byte[] bits;


        /**
         * @param capacity the number of data
         */
        BitMap(int capacity) {
            bits = new byte[(capacity >> 3) + 1];
        }

        void reset() {
            for (int i = 0; i < bits.length; i++) {
                bits[i] = 0;
            }
        }

        /**
         * @param num number
         * @return the index of num in bits
         */
        int getIndex(int num) {
            return num >> 3;
        }

        /**
         * @param num number
         * @return the position of num in bits[getIndex(num)]
         */
        int getPosition(int num) {
            return num & 0x7;
        }


        /**
         * set the corresponding bit of number to 1
         *
         * @param num number
         */
        void set(int num) {
            bits[getIndex(num)] |= 1 << getPosition(num);
        }


        /**
         * @param num number
         * @return whether contain current number
         */
        boolean contain(int num) {
            return (bits[getIndex(num)] & 1 << getPosition(num)) != 0;
        }
    }


    /**
     * @param input  the input path
     * @param output the output path
     * @param max    the max value of input numbers
     * @param step   the step of each data processing
     * @throws IOException if there is a exception while operating on the file
     */
    public static void sort(String input, String output, int max, int step) throws IOException {
        BitMap bits = new BitMap(step);
        int n = 0;

        while (step * n < max) {
            BufferedReader reader = new BufferedReader(new FileReader(input));
            String line;
            int value;
            bits.reset();

            int start = n * step;
            int end = start + step;
            while ((line = reader.readLine()) != null) {
                value = Integer.parseInt(line);
                if (value >= start && value < end)
                    bits.set(value-start);
            }

            BufferedWriter writer = new BufferedWriter(new FileWriter(output, true));
            for (int i = 0; i < step; i++) {
                if (bits.contain(i))
                    writer.write(i + start + "\n");
            }

            reader.close();
            writer.close();
            n++;
        }
    }

}