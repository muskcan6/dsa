class Solution {
    int[][] dirs = new int[][] { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };

    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        // can be solved using bfs and dfs both

        // dfs

        solve(image, sr, sc, color, image[sr][sc]);
        return image;
    }

    public void solve(int[][] image, int sr, int sc, int color, int oc) {
        if (sr < 0 || sc < 0 || sr >= image.length || sc >= image[0].length || image[sr][sc] == color || image[sr][sc] != oc) return;

        image[sr][sc] = color;

        for (int d[] : dirs) {
            int nr = d[0] + sr, nc = d[1] + sc;
            solve(image, nr, nc, color, oc);
        }
    }
}
