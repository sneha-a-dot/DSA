class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        int originalColor = image[sr][sc];

        if (originalColor == newColor) {
            return image;
        }

        dfs(image, sr, sc, newColor, originalColor);
        return image;
    }

    void dfs(int[][] image, int sr, int sc, int newColor, int originalColor) {
        // base case: out of bounds or not the original color
        if (sr < 0 || sr >= image.length || sc < 0 || sc >= image[0].length || image[sr][sc] != originalColor) {
            return;
        }

        // mark current pixel with new color
        image[sr][sc] = newColor;

        // visit all 4 directions
        dfs(image, sr + 1, sc, newColor, originalColor); // down
        dfs(image, sr - 1, sc, newColor, originalColor); // up
        dfs(image, sr, sc + 1, newColor, originalColor); // right
        dfs(image, sr, sc - 1, newColor, originalColor); // left
    }
}
