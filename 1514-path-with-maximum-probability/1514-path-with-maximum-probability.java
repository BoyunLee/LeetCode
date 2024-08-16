import java.util.*;

class Edge implements Comparable<Edge> {
    int node;
    double prob;
    public Edge(int node, double prob) {
        this.node = node;
        this.prob = prob;
    }

    @Override
    public int compareTo(Edge other) {
        // 가장 큰 값을 우선 순위로 해주기 위해 other.prob, this.prob 사용
        return Double.compare(other.prob, this.prob);
    }
}

class Solution {
    // 다익스트라 (min(cost+cost) => max(prob*prob))
    public double maxProbability(int n, int[][] edges, double[] succProb, int start_node, int end_node) {
        // 초기설정
            // 인접리스트 변환
        Map<Integer, List<Edge>> graph = new HashMap<>();
        for(int i=0; i<n; i++) {
            graph.put(i, new ArrayList<>());
        }

        for(int i=0; i<edges.length; i++) {
            int u = edges[i][0];
            int v = edges[i][1];
            double w = succProb[i];
            graph.get(u).add(new Edge(v, w));
            graph.get(v).add(new Edge(u, w));
        }

        // prods 배열 초기화
        double[] probs = new double[n];
        Arrays.fill(probs, 0.0);
        
        // 다익스트라 진행
        // 시작점 예약
        Queue<Edge> pq = new PriorityQueue<>();
        pq.add(new Edge(start_node, 1.0));
        probs[start_node] = 1.0;

        while(!pq.isEmpty()) {
            // 방문
            Edge cur = pq.remove();

            // 예약
            for (Edge next : graph.get(cur.node)) {
                double nextProb = probs[cur.node] * next.prob;
                if (nextProb > probs[next.node]) {
                    pq.add(new Edge(next.node, nextProb));
                    probs[next.node] = nextProb;
                }
            }
        }
        return probs[end_node];
    }
}