package Algorithm.SortAlgorithm.ExternalSort;

import Algorithm.Util.RandomNumberGenerator;
import org.junit.Test;

import java.io.IOException;

public class MultiWaysMergeSortTest {

    @Test
    public void testSort() throws IOException {
        RandomNumberGenerator.generatePositiveNumber("data/multiways/in", 0,100000, 200000);
        MultiWaysMergeSort.sort("data/multiways/in", "data/multiways/out", "data/multiways/auxiliary", 20000);
    }
}