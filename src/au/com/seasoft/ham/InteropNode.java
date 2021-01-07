package au.com.seasoft.ham;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class InteropNode {
    private int id;

    public InteropNode(int id) {
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
        if( !(compareObj instanceof InteropNode) )
            return false;
        final InteropNode compareWith = (InteropNode) compareObj;
        return compareWith.id == this.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    public int getId() {
        return id;
    }

    /*
     * If want can get rid of now using equals...
     */
    public static List<Integer> convertToInts(List nodes) {
        List<Integer> result = new ArrayList<>();
        for(final Object node : nodes){
            result.add( ((InteropNode)node).id);
        }
        return result;
    }

}
