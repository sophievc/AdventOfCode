package year2022.days;

import common.Day;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Day7 extends Day {
    public Day7(){
        super(7);
    }

    public static void main(String args[]) {
        Day d = new Day7();
        var input = d.getInputAsStringList(d.getDefaultInputName());
    }

    static int test1(List<String> input) {
        int sum = 0;
        Graph graph = new Graph();
        Map<String, Integer> folderSizes = new HashMap<>();
        for (String s: input) {
            if (s.startsWith("$")) {
                if(s.contains("cd")) {

                }
            }
        }
        return sum;
    }

    static Vertex openFolder(Graph g, String currentFolder, String folder) {
        if (folder.equals("..")) {
            return g.getAdjVertices()
        }
    }

    static class Vertex {
        String label;
        Vertex(String label) {
            this.label = label;
        }

        // equals and hashCode
    }

    static class Graph {
        private Map<Vertex, List<Vertex>> adjVertices;

        public Graph() {
            this.adjVertices = new HashMap<Vertex, List<Vertex>>();
        }

        void addVertex(String label) {
            adjVertices.putIfAbsent(new Vertex(label), new ArrayList<>());
        }

        void addEdge(String label1, String label2) {
            Vertex v1 = new Vertex(label1);
            Vertex v2 = new Vertex(label2);
            adjVertices.get(v1).add(v2);
            adjVertices.get(v2).add(v1);
        }

        List<Vertex> getAdjVertices(String label) {
            return adjVertices.get(new Vertex(label));
        }

    }

}
