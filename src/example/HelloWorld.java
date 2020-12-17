package example;

public class HelloWorld {
    private static MyHAM ham;

    private static void debug(String msg) {
        System.out.println(msg);
    }

    private static void alignUntilAligned() {
        int maxAligns = 200;
        int counter = 0;
        do {
            ham.align();
            counter += 1;
            debug( "aligned " + counter + " times");
        }
        while (!ham.isAligned() && counter < maxAligns);
    }

    public static void main(String[] args) {
        debug("Hello World, run HAM from here");
        MyGraph graph = new MyGraph();
        ham = new MyHAM(graph, 2);
        alignUntilAligned();
    }
}
