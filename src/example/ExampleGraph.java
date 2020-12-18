package example;

import com.syncleus.dann.graph.Graph;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ExampleGraph implements Graph {

    private Set<MyNode> nodes = new HashSet<MyNode>();
    private Set<MyEdge> edges = new HashSet<MyEdge>();

    public ExampleGraph() {
        MyNode node1 = new MyNode( 1);
        MyNode node2 = new MyNode( 2);
        MyNode node3 = new MyNode( 3);
        MyNode node4 = new MyNode( 4);
        MyNode node5 = new MyNode( 5);
        MyNode node6 = new MyNode( 6);
        MyNode node7 = new MyNode( 7);
        MyNode node8 = new MyNode( 8);
        MyNode node9 = new MyNode( 9);
        MyNode node10 = new MyNode( 10);
        MyNode node11 = new MyNode( 11);
        MyNode node12 = new MyNode( 12);
        nodes.add( node1);
        nodes.add( node2);
        nodes.add( node3);
        nodes.add( node4);
        nodes.add( node5);
        nodes.add( node6);
        nodes.add( node7);
        nodes.add( node8);
        nodes.add( node9);
        nodes.add( node10);
        nodes.add( node11);
        nodes.add( node12);
        edges.add( new MyEdge( node11, node12));
        edges.add( new MyEdge( node10, node12));
        edges.add( new MyEdge( node4, node2));
        edges.add( new MyEdge( node7, node6));
        edges.add( new MyEdge( node7, node8));
        edges.add( new MyEdge( node1, node3));
        edges.add( new MyEdge( node8, node9));
        edges.add( new MyEdge( node9, node10));
        edges.add( new MyEdge( node9, node11));
        edges.add( new MyEdge( node2, node1));
        edges.add( new MyEdge( node5, node6));
        edges.add( new MyEdge( node5, node7));
        edges.add( new MyEdge( node3, node5));
        edges.add( new MyEdge( node3, node8));
    }

    @Override
    public Set getNodes() {
        return nodes;
    }

    @Override
    public Set getEdges() {
        return edges;
    }

    /*
     * The other end of all the edges associated with the given node
     */
    @Override
    public List getAdjacentNodes(Object obj) {
        List<MyNode> result = new ArrayList<MyNode>();
        MyNode node = (MyNode)obj;
        for(final MyEdge edge : edges){
            if(edge.sourceNode.id == node.id) {
                result.add( edge.targetNode);
            }
            if(edge.targetNode.id == node.id) {
                result.add( edge.sourceNode);
            }
        }
        return result;
    }

    /*
     * Edge where given is either the source or the target
     */
    @Override
    public Set getAdjacentEdges(Object obj) {
        Set<MyEdge> result = new HashSet<MyEdge>();
        MyNode node = (MyNode)obj;
        for(final MyEdge edge : edges){
            if(edge.sourceNode.id == node.id) {
                result.add( edge);
            }
            if(edge.targetNode.id == node.id) {
                result.add( edge);
            }
        }
        return result;
    }

    /*
     * Go thru all the edges where the given node is the source node, and grab the target node.
     * Can traverse to the target node.
     */
    @Override
    public List getTraversableNodes(Object obj)
    {
        List<MyNode> result = new ArrayList<MyNode>();
        MyNode node = (MyNode)obj;
        for(final MyEdge edge : edges){
            if(edge.sourceNode.id == node.id) {
                result.add( edge.targetNode);
            }
        }
        return result;
    }

    /*
     * All the edges that the given node leads in.
     * Not used so not worth having/testing
     */
    @Override
    public Set getTraversableEdges(Object obj) {
        Set<MyEdge> result = new HashSet<MyEdge>();
        MyNode node = (MyNode)obj;
        for(final MyEdge edge : edges){
            if(edge.sourceNode == node) {
                result.add( edge);
            }
        }
        return result;
    }
}
