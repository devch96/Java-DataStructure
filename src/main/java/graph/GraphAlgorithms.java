package graph;

import stack.IStack;
import stack.MyStack;

import java.util.*;

public class GraphAlgorithms {
    public static List<Integer> bfs(IGraph iGraph, int from){
        List<Integer> result = new ArrayList<>();
        Set<Integer> visited = new HashSet<>();
        Queue<Integer> queue = new LinkedList<>();
        
        queue.add(from);
        visited.add(from);
        while (!queue.isEmpty()) {
            Integer next = queue.poll();
            result.add(next);
            for(Integer n : iGraph.getNodes(next)){
                if(!visited.contains(n)){
                    queue.add(n);
                    visited.add(n);
                }
            };
        }
        return result;
    }

    public static List<Integer> dfs(IGraph iGraph, int from){
        List<Integer> result = new ArrayList<>();
        Set<Integer> visited = new HashSet<>();
        Stack<Integer> stack = new Stack<>();

        stack.push(from);
        visited.add(from);
        while(stack.size()>0){
            Integer next = stack.pop();
            result.add(next);
            for(Integer n : iGraph.getNodes(next)){
                if (!visited.contains(n)) {
                    stack.push(n);
                    visited.add(n);
                }
            }
        }
        return result;
    }
}
