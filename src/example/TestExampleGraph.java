package example;

import au.com.seasoft.ham.InteropEdge;
import au.com.seasoft.ham.InteropNode;
import com.syncleus.dann.graph.Graph;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/*
 * Make sure these tests are returning same results as the Clojure tests
 */
public class TestExampleGraph {

    private SetupExampleGraph graph = new SetupExampleGraph();

    private Graph getGraph() {
        return graph.getGraph();
    }

    @Test
    public void nodesWereAdded() {
        Assert.assertEquals( 12, graph.getGraph().getNodes().size());
    }

    @Test
    public void edgesWereAdded() {
        Assert.assertEquals( 14, graph.getGraph().getEdges().size());
    }

    @Test
    public void adjacentNodes() {
        InteropNode node9 = new InteropNode( 9);
        Set<Integer> expectedAdjacentNodes = new HashSet<Integer>();
        expectedAdjacentNodes.add( 8);
        expectedAdjacentNodes.add( 10);
        expectedAdjacentNodes.add( 11);
        List adjacentNodes = getGraph().getAdjacentNodes( node9);
        Assert.assertEquals( expectedAdjacentNodes, new HashSet<Integer>( InteropNode.convertToInts( adjacentNodes)));
    }

    @Test
    public void adjacentEdges() {
        InteropNode node9 = new InteropNode( 9);
        Set<InteropEdge> expectedAdjacentEdges = new HashSet<InteropEdge>();
        expectedAdjacentEdges.add( new InteropEdge(new InteropNode(9), new InteropNode(11)));
        expectedAdjacentEdges.add( new InteropEdge(new InteropNode(9), new InteropNode(10)));
        expectedAdjacentEdges.add( new InteropEdge(new InteropNode(8), new InteropNode(9)));
        Set adjacentEdges = getGraph().getAdjacentEdges( node9);
        Assert.assertEquals( expectedAdjacentEdges, adjacentEdges);
    }

    @Test
    public void traversableNodes1() {
        InteropNode node12 = new InteropNode( 12);
        List<InteropNode> expectedTraversableNodes = new ArrayList<InteropNode>();
        List traversableNodes = getGraph().getTraversableNodes( node12);
        Assert.assertEquals( expectedTraversableNodes, traversableNodes);
    }

    @Test
    public void traversableNodes2() {
        InteropNode node1 = new InteropNode( 1);
        List<InteropNode> expectedTraversableNodes = new ArrayList<InteropNode>();
        expectedTraversableNodes.add( new InteropNode( 3));
        List traversableNodes = getGraph().getTraversableNodes( node1);
        Assert.assertEquals( expectedTraversableNodes, traversableNodes);
    }

    /*
     * This test will fail if expectedTraversableNodes are added in the order 8 then 6.
     * The traversable nodes not being a set makes no sense.
     * Need to study code. May not mean there's a bug...
     */
    @Test
    public void traversableNodes3() {
        InteropNode node7 = new InteropNode( 7);
        List<InteropNode> expectedTraversableNodes = new ArrayList<InteropNode>();
        expectedTraversableNodes.add( new InteropNode( 6));
        expectedTraversableNodes.add( new InteropNode( 8));
        List traversableNodes = getGraph().getTraversableNodes( node7);
        Assert.assertEquals( expectedTraversableNodes, traversableNodes);
    }

}
