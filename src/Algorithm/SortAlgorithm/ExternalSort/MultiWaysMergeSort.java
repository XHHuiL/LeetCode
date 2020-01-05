package Algorithm.SortAlgorithm.ExternalSort;

import Algorithm.SortAlgorithm.SortUtil;

import java.io.*;

public class MultiWaysMergeSort {

    private static class LoserTree<T extends Comparable> {
        private int[] internalNodes;
        private int k;
        private T[] leaves;

        LoserTree(T[] leaves) {
            this.leaves = leaves;
            this.k = leaves.length;
            internalNodes = new int[k];
            for (int i = 0; i < k; i++)
                internalNodes[i] = -1;
            construct();
        }

        /**
         * @param index the index of leaf needed to adjust
         */
        void adjust(int index) {
            int winnerIndex = index;
            int parentIndex = (winnerIndex + k) / 2;

            while (parentIndex > 0) {
                if (winnerIndex >= 0 && (internalNodes[parentIndex] == -1 || leaves[winnerIndex].compareTo(leaves[internalNodes[parentIndex]]) > 0)) {
                    int loserIndex = winnerIndex;
                    winnerIndex = internalNodes[parentIndex];
                    internalNodes[parentIndex] = loserIndex;
                }
                parentIndex /= 2;
            }

            internalNodes[0] = winnerIndex;
        }

        /**
         * construct a LoserTree
         */
        void construct() {
            for (int i = k - 1; i >= 0; i--) {
                adjust(i);
            }
        }

        int getWinnerIndex() {
            return internalNodes[0];
        }

        T getValue(int index) {
            return leaves[index];
        }

        void setValue(int index, T value) {
            leaves[index] = value;
        }

    }

    private static int read(BufferedReader reader, int[] temp, int size) throws IOException {
        int count = 0;
        String line;
        while (count < size && (line = reader.readLine()) != null) {
            temp[count] = Integer.parseInt(line);
            count++;
        }
        return count;
    }

    private static void write(BufferedWriter writer, int[] temp, int num) throws IOException {
        int count = 0;
        while (count < num) {
            writer.write(temp[count] + "\n");
            count++;
        }
    }

    private static int memorySort(String input, String auxiliary, int size) throws IOException {
        int count = 0;
        BufferedReader reader = new BufferedReader(new FileReader(input));
        while (true) {
            // read data
            int[] temp = new int[size];
            for (int i = 0; i < size; i++) {
                temp[i] = Integer.MAX_VALUE;
            }
            int num = read(reader, temp, size);
            if (num == 0)
                break;

            // use internal sorting algorithm
            SortUtil.quickSort(temp);

            // create auxiliary file and store sorted data into this file
            BufferedWriter writer = new BufferedWriter(new FileWriter(auxiliary + count));
            count++;
            write(writer, temp, num);
            writer.close();
        }
        reader.close();
        return count;
    }

    private static void mergeSort(String output, String auxiliary, int num) throws IOException {
        if (num <= 0)
            return;
        // init
        BufferedWriter writer = new BufferedWriter(new FileWriter(output));
        BufferedReader[] readers = new BufferedReader[num];
        for (int i = 0; i < num; i++) {
            readers[i] = new BufferedReader(new FileReader(auxiliary + i));
        }

        // solution 1:
        mergeByLoserTree(writer, readers, num);

        // solution 2: merge based on simple selection
        // mergeBySimpleSelection(writer, readers, num);

        writer.close();
        for (BufferedReader reader : readers
        ) {
            reader.close();
        }
    }

    private static void mergeByLoserTree(BufferedWriter writer, BufferedReader[] readers, int num) throws IOException {
        // step 1: construct a LoserTree
        Integer[] firstData = new Integer[num];
        for (int i = 0; i < num; i++) {
            firstData[i] = Integer.parseInt(readers[i].readLine());
        }
        LoserTree<Integer> loserTree = new LoserTree<>(firstData);

        // step 2: merge
        int index = loserTree.getWinnerIndex();
        Integer min = loserTree.getValue(index);
        while (min < Integer.MAX_VALUE) {
            writer.write(min + "\n");
            int value;
            String line = readers[index].readLine();
            if (line == null)
                value = Integer.MAX_VALUE;
            else value = Integer.parseInt(line);
            loserTree.setValue(index, value);
            loserTree.adjust(index);

            index = loserTree.getWinnerIndex();
            min = loserTree.getValue(index);
        }
    }

    private static void mergeBySimpleSelection(BufferedWriter writer, BufferedReader[] readers, int num) throws IOException {
        int[] firstData = new int[num];
        for (int i = 0; i < num; i++) {
            firstData[i] = Integer.parseInt(readers[i].readLine());
        }
        boolean[] finished = new boolean[num];

        // merge
        String line;
        while (true) {
            int index = 0;
            while (index < num && finished[index])
                index++;
            if (index >= num)
                break;

            int min = firstData[index];
            for (int i = index + 1; i < num; i++) {
                if (!finished[i] && firstData[i] < min) {
                    min = firstData[i];
                    index = i;
                }
            }

            writer.write(min + "\n");
            line = readers[index].readLine();
            if (line == null)
                finished[index] = true;
            else
                firstData[index] = Integer.parseInt(line);
        }
    }

    /**
     * @param input
     * @param output
     * @param auxiliary
     * @param size size of each merging part
     * @throws IOException
     */
    public static void sort(String input, String output, String auxiliary, int size) throws IOException {
        int numOfAux = memorySort(input, auxiliary, size);
        mergeSort(output, auxiliary, numOfAux);
    }

}