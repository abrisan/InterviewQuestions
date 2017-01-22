import java.util.*;

import static java.lang.System.out;

public class GraphExercises {
    private static class Node{
        int data;

        Node(int data) {this.data = data;}

        public int hashCode(){
            return new Integer(data).hashCode();
        }

        public boolean equals(Object o){
            if(!(o instanceof Node)) return false;
            return o.hashCode() == this.hashCode();
        }
        public String toString() { return String.valueOf(this.data); }
    }

    public static List<List<Node>> dfs(Map<Node, List<Node>> graph, List<Node> visited, Node target, Node current){
        if(current.equals(target)) {
            List<List<Node>> ret = new ArrayList<>();
            ret.add(new ArrayList<>(Collections.singleton(target)));
            return ret;
            }
        visited.add(current);
        List<Node> neighbours = graph.get(current);
        if(neighbours == null) return new ArrayList<>();
        List<List<Node>> ret = new ArrayList<>();
        for(Node n : neighbours){
            if(!visited.contains(n)){
                List<List<Node>> rec = dfs(graph, visited, target, n);
                for(List<Node> l : rec){
                    l.add(current);
                }
                ret.addAll(rec);
            }
        }
        return ret;
    }

    public static boolean bfs(Map<Node, List<Node>> graph, List<Node> visited, Node target, Node start){

        Queue<Node> q = new ArrayDeque<>(Collections.singleton(start));

        while(!q.isEmpty()){
            Node front = q.poll();
            if(front.equals(target)){
                out.println(q);
                return true;
            }
            List<Node> ns = graph.get(front);
            if(ns == null) continue;
            for(Node n : ns){
                if(!visited.contains(n)) q.offer(n);
                visited.add(n);
            }
        }

        return false;

    }

    public static void main(String[] args){
        HashMap<Node, List<Node>> graph = new HashMap<Node, List<Node>>();
        Scanner stdin = new Scanner(System.in);
        int N = stdin.nextInt();
        for(int i = 0 ; i < N ; ++i){
            int source = stdin.nextInt();
            int dest = stdin.nextInt();
            Node n1 = new Node(source);
            Node n2 = new Node(dest);
            List<Node> ns = graph.get(n1);
            if(ns == null){
                graph.put(n1, new ArrayList<>(Collections.singleton(n2)));
            }else{
                ns.add(n2);
                graph.replace(n1, ns);
            }
        }
        Node start = new Node(1);
        Node end = new Node(4);
        List<List<Node>> paths = dfs(graph, new ArrayList<>(), end, start);
        boolean exists = bfs(graph, new ArrayList<>(), end, start);
        out.println(exists);
        paths.stream().forEach(out::println);
        // out.println(graph);
        stdin.close();
    }



}

