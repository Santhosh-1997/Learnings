package org.example.DSA.Graphs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.*;

public class UndirectedCyclic {
    public static void main(String[] args) {
        int V = 6;
        List<Integer>[] adj = new ArrayList[V];

        for (int i = 0; i < V; i++) {
            adj[i] = new ArrayList<>();
        }

        adj[0].addAll(Arrays.asList(1, 3));
        adj[1].addAll(Arrays.asList(0, 2, 4));
        adj[2].addAll(Arrays.asList(1, 5));
        adj[3].addAll(Arrays.asList(0, 4));
        adj[4].addAll(Arrays.asList(1, 3, 5));
        adj[5].addAll(Arrays.asList(2, 4));

        boolean[] visitedArray = new boolean[V];
        boolean ans = false;

        for(int i=0; i<V; i++){
            if(!visitedArray[i]){
                //ans = bfs(visitedArray, adj, i);
                ans = dfs(visitedArray, adj, new int[]{i, -1});
                if(ans)
                    break;
            }
        }
        System.out.println(ans);
    }

    static boolean bfs(boolean[] visitedArr, List<Integer>[] adj, int node){
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{node, -1});
        visitedArr[node] = true;

        while(!queue.isEmpty()){
            int n = queue.size();
            for(int i=0; i<n; i++){
                int[] temp = queue.poll();
                int currentNode = temp[0];
                int parent = temp[1];

                for(int childNodes : adj[currentNode]){
                    if(!visitedArr[childNodes]){
                        visitedArr[childNodes] = true;
                        queue.offer(new int[]{childNodes, currentNode});
                    }else if(childNodes != parent){
                        return true;
                    }
                }
            }
        }

        return false;
    }

    static boolean dfs(boolean[] visitedArr, List<Integer>[] adj, int[] current){
        int node = current[0];
        int parent = current[1];

        visitedArr[node] = true;
        for(int n : adj[node]){
            if(!visitedArr[n]){
                if(dfs(visitedArr, adj, new int[]{n, node}))
                    return true;
            }else if(n != parent){
                return true;
            }
        }

        return false;
    }
}
