package com.wlf.algorithm.datastructures.topic31;

import java.util.LinkedList;
import java.util.Queue;

/***
 * 邻接表存储。
 * 广度优先遍历的时间复杂度:
 * 最坏的情况下，所有的顶点都需要入一遍队列，每个边都遍历一边，时间复杂度为O(V+E), 一个连通图 E > V, 所以时间复杂度可以简写为O(E)
 *
 * 深度优先遍历的时间复杂度：
 * 深度优先遍历每条边 最多访问两次， 时间复杂度为O(E)
 *
 */
public class Graph {
    private int v;
    private LinkedList<Integer> adj[];
    private boolean found = false;

    public Graph(int v) {
        this.v = v;
        adj = new LinkedList[v];
        for (int index = 0; index < v; index++) {
            adj[index] = new LinkedList<>();
        }

    }

    public void addEdge(int s, int t) {
        adj[s].add(t);
        adj[t].add(s);
    }

    /*
     *  搜索从 s 到t 的最短路径
     * */
    public void bfs(int s, int t) {
        if (s == t) return;
        boolean[] visited = new boolean[v];
        visited[s] = true;
        Queue<Integer> queue = new LinkedList<Integer>();
        queue.add(s);
        int[] prev = new int[v];
        for (int index = 0; index < v; index++) {
            prev[index] = -1;
        }
        while (queue.size() != 0) {
            int w = queue.poll();
            for (int index = 0; index < adj[w].size(); index++) {
                int q = adj[w].get(index);
                if (visited[q] != true) {
                    prev[q] = w;
                    if (q == t) {
                        print(prev, s, t);
                        return;
                    }
                    visited[q] = true;
                    queue.add(q);
                }

            }

        }


    }

    /*
    *   深度优先遍历, 能搜索出一条路径，但不是最短路径。 存在回溯。
    * */
    public void dfs(int s, int t){
        found = false;
        boolean[] visited = new boolean[v];
        int[] prev = new int[v];
        for(int i=0; i < v; i++){
            prev[i] = -1;
        }
        recurDfs(s,t,visited,prev);
        print(prev,s,t);


    }

    private void recurDfs(int w, int t, boolean[] visited, int[] prev){
        if(found == true) return;
        visited[w] = true;
        if(w == t){
            found = true;
            return;
        }
        for(int i=0; i<adj[w].size(); i++){
            int q = adj[w].get(i);
            if(!visited[q]){
                prev[q] = w;
                recurDfs(q, t,visited,prev);
            }
        }
    }

    private void print(int[] prev, int s, int t) {
        if (prev[t] != -1 && t != s) {
            print(prev, s, prev[t]);
        }
        System.out.print(t + " ");

    }


    public static void main(String[] str){
        Graph graph = new Graph(8);
        graph.addEdge(0,1);
        graph.addEdge(0,3);
        graph.addEdge(1,2);
        graph.addEdge(1,4);
        graph.addEdge(3,4);
        graph.addEdge(4,5);
        graph.addEdge(4,6);
        graph.addEdge(5,7);
        graph.addEdge(6,7);

        //graph.bfs(0,6);
        graph.dfs(0,6);
    }
}
