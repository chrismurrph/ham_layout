package example;

import com.syncleus.dann.graph.drawing.hyperassociativemap.HyperassociativeMap;

import java.util.Map;

public class AlignExampleGraph {
    private static void debug(String msg) {
        System.out.println(msg);
    }

    private static HyperassociativeMap alignUntilAligned(HyperassociativeMap ham) {
        int maxAligns = 10000;
        int counter = 0;
        do {
            ham.align();
            counter += 1;
        }
        while (!ham.isAligned() && counter < maxAligns);
        debug("aligned " + counter + " times, " + ham.alignedMetrics());
        return ham;
    }

    static void displayCoords(Map<Object, Object> coords) {
        for (Map.Entry<Object, Object> entry : coords.entrySet()) {
            debug(String.format("%02d", ((MyNode) entry.getKey()).id) +
                    " " + entry.getValue());
        }
    }

    public static void main(String[] args) {
        debug("About to try and align the example graph");
        ExampleGraph graph = new ExampleGraph();
        HyperassociativeMap ham = new MyHAM(graph, 2);
        HyperassociativeMap alignedHAM = alignUntilAligned(ham);
        Map coords = alignedHAM.getCoordinates();
        displayCoords(coords);
    }
}
