package Algorithm.SortAlgorithm.ExternalSort;

import Algorithm.Util.RandomNumberGenerator;
import org.junit.Test;

import java.io.IOException;

public class BitMapSortTest {

    @Test
    public void testSort() throws IOException {
        RandomNumberGenerator.generateNonRepetitivePositiveNumber("data/bitmap/in", 200000);
        BitMapSort.sort("data/bitmap/in", "data/bitmap/out", 200000, 100000);
    }
}