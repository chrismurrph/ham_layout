package au.com.seasoft.ham;

import com.syncleus.dann.graph.Graph;
import com.syncleus.dann.graph.drawing.hyperassociativemap.HyperassociativeMap;
import com.syncleus.dann.math.Vector;

import java.util.Map;

/**
 * Can be called from Clojure to layout a graph.
 * Sometimes the HAM comes back not aligned. So on Clojure side we will use core.async and spin up say 20 of
 * these using alts! to get back the first one that comes back aligned.
 * What I have seen is that it is better to try again rather than have a high value for maxAligns.
 * I want to assume that there's no tuning that needs to be done for the number of nodes/edges.
 * From experience of my simple graph if it gets the alignment done soon or not at all.
 * By 500 or still won't be done by 10,000.
 * The HyperassociativeMap can be made to use futures (so multi-threading) for the alignment of each node. We
 * don't use this feature as it is only about performance.
 * If after 20 alignment doesn't happen then just tell the user 'sorry' via the UI.
 */
public class InteropHAM extends HyperassociativeMap {

    private static void debug(String msg) {
        System.out.println(msg);
    }

    public static HyperassociativeMap attemptToAlign(HyperassociativeMap ham, int maxAligns, boolean silent) {
        int counter = 0;
        do {
            ham.align();
            counter += 1;
        }
        while (!ham.isAligned() && counter < maxAligns);
        if(!silent) {
            if(ham.isAligned()) {
                debug("Aligned after " + counter + " times, " + ham.alignedMetrics());
            } else {
                debug("Not able to align graph after " + counter + " times, " + ham.alignedMetrics());
            }
        }
        return ham;
    }

    public static void displayCoords(Map<Object, Object> coords) {
        for (Map.Entry<Object, Object> entry : coords.entrySet()) {
            debug(String.format("%02d", ((InteropNode) entry.getKey()).getId()) +
                    " " + entry.getValue());
        }
    }

    private InteropHAM(Graph graph, int dimensions) {
        super(graph, dimensions);
    }

    public static HyperassociativeMap create(Graph graph, int dimensions) {
        return new InteropHAM( graph, dimensions);
    }
}
