package example;

import com.syncleus.dann.graph.drawing.hyperassociativemap.HyperassociativeMap;
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

    private ExampleGraph graph = new ExampleGraph();
    private HyperassociativeMap ham = new MyHAM(graph, 2);

    @Test
    public void nodesWereAdded() {
        Assert.assertEquals( 12, graph.getNodes().size());
    }

    @Test
    public void edgesWereAdded() {
        Assert.assertEquals( 14, graph.getEdges().size());
    }

    @Test
    public void adjacentNodes() {
        MyNode node9 = new MyNode( 9);
        Set<Integer> expectedAdjacentNodes = new HashSet<Integer>();
        expectedAdjacentNodes.add( 8);
        expectedAdjacentNodes.add( 10);
        expectedAdjacentNodes.add( 11);
        List adjacentNodes = graph.getAdjacentNodes( node9);
        Assert.assertEquals( expectedAdjacentNodes, new HashSet<Integer>( MyNode.convertToInts( adjacentNodes)));
    }

    @Test
    public void adjacentEdges() {
        MyNode node9 = new MyNode( 9);
        Set<MyEdge> expectedAdjacentEdges = new HashSet<MyEdge>();
        expectedAdjacentEdges.add( new MyEdge(new MyNode(9), new MyNode(11)));
        expectedAdjacentEdges.add( new MyEdge(new MyNode(9), new MyNode(10)));
        expectedAdjacentEdges.add( new MyEdge(new MyNode(8), new MyNode(9)));
        Set adjacentEdges = graph.getAdjacentEdges( node9);
        Assert.assertEquals( expectedAdjacentEdges, adjacentEdges);
    }

    @Test
    public void traversableNodes1() {
        MyNode node12 = new MyNode( 12);
        List<MyNode> expectedTraversableNodes = new ArrayList<MyNode>();
        List traversableNodes = graph.getTraversableNodes( node12);
        Assert.assertEquals( expectedTraversableNodes, traversableNodes);
    }

    @Test
    public void traversableNodes2() {
        MyNode node1 = new MyNode( 1);
        List<MyNode> expectedTraversableNodes = new ArrayList<MyNode>();
        expectedTraversableNodes.add( new MyNode( 3));
        List traversableNodes = graph.getTraversableNodes( node1);
        Assert.assertEquals( expectedTraversableNodes, traversableNodes);
    }

    /*
     * This test will fail if expectedTraversableNodes are added in the order 8 then 6.
     * The traversable nodes not being a set makes no sense.
     * Need to study code. May not mean there's a bug...
     */
    @Test
    public void traversableNodes3() {
        MyNode node7 = new MyNode( 7);
        List<MyNode> expectedTraversableNodes = new ArrayList<MyNode>();
        expectedTraversableNodes.add( new MyNode( 6));
        expectedTraversableNodes.add( new MyNode( 8));
        List traversableNodes = graph.getTraversableNodes( node7);
        Assert.assertEquals( expectedTraversableNodes, traversableNodes);
    }

}
