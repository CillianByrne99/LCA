public class DAG {
    private int Vertices; //number of vertices in Graph
    private int Edges; //number of Edges in Graph
    private int[][] adj; //2D adjacancy matrix for vertex v
    private int[] in; //in degree of vertex v
    private int[] out; //out degree of vertex v
    private int[] visited; //vertices that have been visited

    public DAG(int Vertices) {
        if(Vertices < 0) {
            throw new IllegalArgumentException(" 0 vertices");
        }
        else {
            this.Vertices = Vertices;
            this.Edges = 0;
            in = new int[Vertices];
            out = new int[Vertices];
            visited = new int[Vertices];
            adj = new int[Vertices][Vertices];
            for(int i = 0; i < Vertices; i++) {
                for(int j = 0; j < Vertices; j++) {
                    adj[i][j] = 0; 
                }
            }
        }
    }

    public int vertices() {
        return this.Vertices;
    }

    public int edges() {
        return this.Edges;
    }

    public boolean validate(int v) {
        if(v < 0 || v >= Vertices) {
            return false;
        }
        return true;
    }

    public void addEdge(int v, int w) {
        if(validate(v) && validate(w)) {
            adj[v][w] = 1;
            in[w]++;
            out[v]++;
            Edges++;
        }
    }

    public void removeEdge(int v, int w) {
        if(validate(v) && validate(w)) {
            adj[v][w] = 0;
            in[w]--;
            out[v]--;
            Edges--;
        }
    }

    public int outDegreeVertex(int v) {
        if(validate(v)) {
            return out[v];
        }
        return -1;
    }

    public int inDegreeVertex(int v) {
        if(validate(v)) {
            return in[v];
        }
        return -1;
    }

    public int[] adj(int v) {
        if(validate(v)) {
            int[] temp = new int[out[v]];
            int counter = 0;
            for(int i = 0; i < Vertices; i++) {
                if(adj[v][i]==1) {
                    temp[counter] = i;
                    counter++;
                }
            }
            return temp;
        }
        return new int[0];
    } 

    public boolean hasCycle() {
        int counter = 0;
        for(int i = 0; i < Vertices; i++) {
            visited[counter] = i;
            for(int j = 0; j < Vertices; j++) {
                for(int k = 0; k < Vertices; k++) {
                    if(visited[k]==j && adj[i][j]==1) {
                        return true;
                    }
                }
            }
            counter++;
        }
        return false;
    }

    public int findLCA(int v, int w) {
        if(validate(v)==true && validate(w)==false && Edges > 0 && hasCycle()==false) {
            return LCAUtility(v,w);
        }
        else {
            return LCAUtility(v,w);
        }
    }

    public int LCAUtility(int v, int w) {
        int[] array1 = new int[Edges];
        int[] array2  = new int[Edges];
        boolean[] bool1 = new boolean[Vertices];
        boolean[] bool2 = new boolean[Vertices];
        int x = 0;
        int y = 0;
        array1[x] = v;
        array2[y] = w;
        for(int i = 0; i < Vertices; i++) {
            bool1[i] = false;
            bool2[i] = false;
        }
        for(int i = 0; i < Vertices; i++) {
            bool1[i] = true;
            bool2[i] = true;
            for(int j = 0; j < Vertices; j++) {
                if(adj[i][j] == 1 && bool1[i]) {
                    x++;
                    array1[x] = 1;
                    bool1[j] = true;
                }
                if(adj[i][j] == 1 && bool2[i]) {
                    y++;
                    array2[y] = 1;
                    bool2[j] = true;
                }
                if(array2[y] == array1[x]) {
                    return array2[y];
                }
            }
        }
        return -1; 
    }
}