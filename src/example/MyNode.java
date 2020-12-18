package example;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class MyNode {
    public int id;

    public MyNode(int id) {
        this.id = id;
    }

    @Override
    public String toString()
    {
        return "" + this.id;
    }

    @Override
    public boolean equals(final Object compareObj)
    {
        if( !(compareObj instanceof MyNode) )
            return false;
        final MyNode compareWith = (MyNode) compareObj;
        return compareWith.id == this.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    /*
     * Can get rid of now using equals
     */
    static List<Integer> convertToInts(List nodes) {
        List<Integer> result = new ArrayList<>();
        for(final Object node : nodes){
            result.add( ((MyNode)node).id);
        }
        return result;
    }

}
