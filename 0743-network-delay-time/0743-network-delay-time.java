import java.util.*;
import java.io.*;

// Edge 클래스:
// 노드 간의 간선 정보를 저장합니다. node는 도착 노드, cost는 가중치(거리)입니다.
// Comparable 인터페이스를 구현하여 우선순위 큐에서 간선의 비용에 따라 정렬될 수 있도록 합니다.
class Edge implements Comparable<Edge> {
    int node, cost;

    public Edge(int node, int cost) {
        this.node = node;
        this.cost = cost;
    }

    @Override
    public int compareTo(Edge other) {
        return Integer.compare(this.cost, other.cost);
    }
}

class Solution {
    // networkDelayTime 메소드:
    // times 배열을 사용해 그래프를 인접 리스트 형태로 구성합니다.
    // dijkstra 메소드를 호출하여 출발 노드 k에서 각 노드까지의 최단 경로를 계산합니다.
    // 모든 노드에 도달할 수 있는지 확인하고, 도달할 수 없다면 -1을 반환합니다.
    // 모든 노드에 도달할 수 있다면, 최대 지연 시간을 반환합니다.
    public int networkDelayTime(int[][] times, int n, int k) {
        Map<Integer, List<Edge>> graph = new HashMap<>();

        for(int[] time : times) {
            int u = time[0];
            int v = time[1];
            int w = time[2];

            graph.putIfAbsent(u, new ArrayList<>());
            graph.get(u).add(new Edge(v, w));
        }

        int[] distances = dijkstra(graph, k, n);

        int maxDistance = 0;
        for(int i=1; i<=n; i++) {
            if(distances[i] == Integer.MAX_VALUE) {
                return -1;
            }
            maxDistance = Math.max(maxDistance, distances[i]);
        }
        return maxDistance;
    }

    // dijkstra 메소드:
    // 우선순위 큐를 사용하여 다익스트라 알고리즘을 구현합니다.
    // 시작 노드에서 다른 모든 노드까지의 최단 경로를 계산하고, 결과를 distance 배열에 저장합니다.
    // 배열 distance[i]는 노드 i까지의 최단 경로를 나타냅니다.
    private int[] dijkstra(Map<Integer, List<Edge>> graph, int start, int n) {
        int INF = Integer.MAX_VALUE;
        int[] distance = new int[n+1];
        Arrays.fill(distance, INF);

        // 시작점 초기화
        PriorityQueue<Edge> pq = new PriorityQueue<>();
        pq.add(new Edge(start, 0));
        distance[start] = 0;

        while (!pq.isEmpty()) {
            Edge cur = pq.remove();
            if(distance[cur.node] < cur.cost) {
                continue;
            }

            // 인접 노드 탐색
            if (graph.containsKey(cur.node)) {
                for (Edge next : graph.get(cur.node)) {
                    int nextCost = distance[cur.node] + next.cost;
                    if (nextCost < distance[next.node]) {
                        distance[next.node] = nextCost;
                        pq.add(new Edge(next.node, nextCost));
                    }
                }
            }
        }
        return distance;
    }
}
