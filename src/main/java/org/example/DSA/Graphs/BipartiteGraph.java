package org.example.DSA.Graphs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.*;

public class BipartiteGraph {
    public static void main(String[] args) {
        int V = 4;
        List<List<Integer>> adj = new ArrayList<>();

        adj.add(Arrays.asList(1, 3)); // adj[0]
        adj.add(Arrays.asList(0, 2)); // adj[1]
        adj.add(Arrays.asList(1, 3)); // adj[2]
        adj.add(Arrays.asList(0, 2)); // adj[3]

        int[] color = new int[V];
        Arrays.fill(color, -1);

        for(int i=0; i<V; i++) {
            if (color[i] == -1) {
                color[i] = 0;
                if (bfs(adj, color, i)) {
                    System.out.println(true);
                    break;
                }
            }
        }
    }

    static boolean dfs(List<List<Integer>> adj, int color, int node, int[] colors){
        colors[node] = color;
        for(int n : adj.get(node)){
            if(colors[n] == -1){
                if(!dfs(adj, 1-color, n, colors))
                    return false;
            }else if(color == colors[n]){
                return false;
            }
        }
        return true;
    }

    static boolean bfs(List<List<Integer>> adj, int[] colors, int node){
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(node);

        while(!queue.isEmpty()){
            int n = queue.size();
            for(int i=0; i<n; i++){
                int curNode = queue.poll();
                int curColor = colors[curNode];
                int nextColor = colors[curNode] == 0 ? 1 : 0;

                for(int child : adj.get(curNode)){
                    if(colors[child] == -1){
                        colors[child] = nextColor;
                        queue.offer(child);
                    }else if(colors[child] == curColor){
                        return false;
                    }
                }
            }
        }
        return true;
    }
}
