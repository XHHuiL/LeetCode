package Algorithm.Util;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

public class RandomNumberGenerator {

    /**
     * @param path  the output path
     * @param start the min random number(include)
     * @param end   the max random number(exclude)
     * @param num   the number of random numbers
     * @throws IOException if there is a exception while operating on the file
     */
    public static void generatePositiveNumber(String path, int start, int end, int num) throws IOException {
        BufferedWriter writer = new BufferedWriter(new FileWriter(path));
        Random r = new Random();
        int bound = end - start;
        for (int i = 0; i < num; i++) {
            writer.write(r.nextInt(bound) + start + "\n");
        }
        writer.close();
    }


    /**
     * shuffle the n numbers of 0 - n-1 and store them in output file
     *
     * @param path the output path
     * @param n    the max number(exclude)
     * @throws IOException if there is a exception while operating on the file
     */
    public static void generateNonRepetitivePositiveNumber(String path, int n) throws IOException {
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = i;
        }
        BufferedWriter writer = new BufferedWriter(new FileWriter(path));
        Random r = new Random();
        int index;
        int temp;
        for (int i = n - 1; i > 0; i--) {
            index = r.nextInt(i);
            temp = nums[index];
            nums[index] = nums[i];
            nums[i] = temp;
            writer.write(temp + "\n");
        }
        writer.close();
    }

}