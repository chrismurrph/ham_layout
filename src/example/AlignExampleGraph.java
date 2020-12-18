package example;

import com.syncleus.dann.graph.drawing.hyperassociativemap.HyperassociativeMap;

public class AlignExampleGraph {
    private static void debug(String msg) {
        System.out.println(msg);
    }

    private static HyperassociativeMap alignUntilAligned(HyperassociativeMap ham) {
        int maxAligns = 1000;
        int counter = 0;
        do {
            ham.align();
            counter += 1;
            debug( "aligned " + counter + " times, " + ham.alignedMetrics());
        }
        while (!ham.isAligned() && counter < maxAligns);
        return ham;
    }

    public static void main(String[] args) {
        debug("About to try and align the example graph");
        ExampleGraph graph = new ExampleGraph();
        HyperassociativeMap ham = new MyHAM(graph, 2);
        HyperassociativeMap alignedHAM = alignUntilAligned(ham);
    }
}
