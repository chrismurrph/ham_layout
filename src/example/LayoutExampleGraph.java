package example;

import au.com.seasoft.ham.InteropHAM;
import com.syncleus.dann.graph.drawing.hyperassociativemap.HyperassociativeMap;

import java.util.Map;
public class LayoutExampleGraph {

    public static void main(String[] args) {
        int dimensions = 2;
        int maxAligns = 1000;
        SetupExampleGraph graph = new SetupExampleGraph();
        HyperassociativeMap ham = InteropHAM.create(graph.getGraph(), dimensions);
        HyperassociativeMap alignedHAM = InteropHAM.attemptToAlign(ham, maxAligns, false);
        if(alignedHAM.isAligned()) {
            Map<Object, Object> coords = alignedHAM.getCoordinates();
            InteropHAM.displayCoords(coords);
        }
    }
}
