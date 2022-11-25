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

//      1. 모든 vertex 의 indegree 수를 센다
//      2. 큐에 indegree 가 0인 vertex 삽입
//      3. 큐에서 vertex 를 꺼내 연결된(나가는 방향) edge 제거
//      4. 3번으로 인해 indegree 가 0 이 된 vertex 를 큐에 삽입
//      5. 큐가 빌 때까지 3-4 반복

    public static List<Integer> topologicalSortIndegree(IGraph graph){
        //<vertex, indegree 갯수>
        Map<Integer, Integer> indegreeCounter = graph.getIndegrees();
        Queue<Integer> queue = new LinkedList<>();
        List<Integer> result = new LinkedList<>();

        for (int v : graph.getVertexes()) {
            int count = indegreeCounter.getOrDefault(v, 0);
            if(count == 0){
                queue.offer(v);
            }
        }
        while (!queue.isEmpty()) {
            int node = queue.poll();
            result.add(node);

            for (int nn : graph.getNodes(node)) {
                if(indegreeCounter.containsKey(nn)){
                    int count = indegreeCounter.get(nn);
                    if(count -1 == 0){
                        queue.offer(nn);
                    }
                    indegreeCounter.put(nn, count - 1);
                }
            }
        }
        return result;
    }

    public static List<Integer> topologicalSort(IGraph graph){
        List<Integer> result = new ArrayList<>();
        Stack<Integer> stack = new Stack<>();
        Set<Integer> visited = new HashSet<>();

        Set<Integer> vertexes = graph.getVertexes();
        for(Integer vertex : vertexes){
            if(!visited.contains(vertex)){
                // dfs
                topologicalSort(graph, vertex, visited, stack);
            }
        }
        while(stack.size() > 0){
            result.add(stack.pop());
        }
        return result;
    }

    private static void topologicalSort(IGraph graph, int vertex, Set<Integer> visited, Stack<Integer> stack){
        visited.add(vertex);
        List<Integer> nodes = graph.getNodes(vertex);
        for(Integer n : nodes){
            if(!visited.contains(n)){
                topologicalSort(graph, n, visited, stack);
            }
        }
        stack.push(vertex);
    }

    /**
    * 다익스트라 최단거리 알고리즘
    * @param graph
    * @param src 출발노드
    * @param dst 도착노드
    * @return 출발 노드로부터 도착 노드까지의 최단거리
    */

    public static int dijkstraShortestPath(IGraph graph, int src, int dst){
        int size = 0;
        for (int n : graph.getVertexes()) {
            if(size<n){
                size = n+1;
            }
        }

        // distance 배열을 노드 크기만큼 초기화
        int[] dist = new int[size];
        for(int i =0 ; i < dist.length; i++){
            dist[i] = Integer.MAX_VALUE; // distance 값을 INF 초기화
        }
        dist[src] = 0; // 시작노드의 distance 는 0
        //<vertex, distance>
        //distance를 기준으로하는 minheap
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> {
            return a[1] - b[1];
        });
        pq.add(new int[]{src, 0});
        while(!pq.isEmpty()){
            int[] top = pq.poll();
            int vertex = top[0];
            int distance = top[1];

            if(dist[vertex] < distance){
                continue;
            }
            for(int node: graph.getNodes(vertex)){
                if(dist[node] > dist[vertex] + graph.getDistance(vertex, node)){
                    dist[node] = dist[vertex] + graph.getDistance(vertex, node);
                    pq.add(new int[]{node, dist[node]});
                }
            }
        }
        return dist[dst];
    }
}
