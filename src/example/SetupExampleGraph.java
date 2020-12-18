package example;

import au.com.seasoft.ham.GenericGraph;
import au.com.seasoft.ham.InteropEdge;
import au.com.seasoft.ham.InteropNode;
import com.syncleus.dann.graph.Graph;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * From Clojure should be able to create a GenericGraph and add to it the nodes and edges that also easily
 * created in Clojure. We can have a function that does this (by reading the Clojure data structure)
 * when given a ::gr/graph, returning a GenericGraph,
 * which is enough to create an InteropHAM (needs a Graph).
 */
class SetupExampleGraph {

    private GenericGraph graph;
//    {:12 {}
//     :11 {:12 10}
//     :10 {:12 3}
//     :4  {:2 4}
//     :7  {:6 1 :8 11}
//     :1  {:3 5}
//     :8  {:9 20}
//     :9  {:10 17 :11 5}
//     :2  {:1 10}
//     :5  {:6 9 :7 3}
//     :3  {:5 6 :8 2}
//     :6  {}}
    SetupExampleGraph() {
        InteropNode node1 = new InteropNode( 1);
        InteropNode node2 = new InteropNode( 2);
        InteropNode node3 = new InteropNode( 3);
        InteropNode node4 = new InteropNode( 4);
        InteropNode node5 = new InteropNode( 5);
        InteropNode node6 = new InteropNode( 6);
        InteropNode node7 = new InteropNode( 7);
        InteropNode node8 = new InteropNode( 8);
        InteropNode node9 = new InteropNode( 9);
        InteropNode node10 = new InteropNode( 10);
        InteropNode node11 = new InteropNode( 11);
        InteropNode node12 = new InteropNode( 12);
        graph = GenericGraph.create();
        graph.addNode( node1);
        graph.addNode( node2);
        graph.addNode( node3);
        graph.addNode( node4);
        graph.addNode( node5);
        graph.addNode( node6);
        graph.addNode( node7);
        graph.addNode( node8);
        graph.addNode( node9);
        graph.addNode( node10);
        graph.addNode( node11);
        graph.addNode( node12);
        graph.addEdge( new InteropEdge( node11, node12));
        graph.addEdge( new InteropEdge( node10, node12));
        graph.addEdge( new InteropEdge( node4, node2));
        graph.addEdge( new InteropEdge( node7, node6));
        graph.addEdge( new InteropEdge( node7, node8));
        graph.addEdge( new InteropEdge( node1, node3));
        graph.addEdge( new InteropEdge( node8, node9));
        graph.addEdge( new InteropEdge( node9, node10));
        graph.addEdge( new InteropEdge( node9, node11));
        graph.addEdge( new InteropEdge( node2, node1));
        graph.addEdge( new InteropEdge( node5, node6));
        graph.addEdge( new InteropEdge( node5, node7));
        graph.addEdge( new InteropEdge( node3, node5));
        graph.addEdge( new InteropEdge( node3, node8));
    }

    public Graph getGraph() {
        return graph;
    }
}
