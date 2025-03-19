class Tester {
    int count(int[][] map) {
        if (map.length == 0) return 0;
        int islandCount = 0;

        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[i].length; j++) {
                if (map[i][j] == 1) { // Found unvisited land
                    islandCount++;
                    markIsland(map, i, j); // Mark all connected land
                }
            }
        }
        return islandCount;
    }

    void markIsland(int[][] map, int x, int y) {
        // Boundary check and avoid revisiting
        if (x < 0 || x >= map.length || y < 0 || y >= map[x].length || map[x][y] != 1) {
            return;
        }

        map[x][y] = 2; // Mark as visited

        // Explore all 4 directions
        markIsland(map, x + 1, y); // Down
        markIsland(map, x - 1, y); // Up
        markIsland(map, x, y + 1); // Right
        markIsland(map, x, y - 1); // Left
    }

    void printer(int[][] arr){
        System.out.println();
        for(int[] x : arr){
            for(int y : x){
                System.out.print(y+" ");
            }
            System.out.println();
        }
        System.out.println();
    }

    public static void main(String[] args) {
        System.out.println("Try programiz.pro");

        Tester m = new Tester();
        int[][] a = {{1,0,0},{1,1,0},{1,1,1}};
        int[][] b = {{0,1,0},{1,1,0},{0,0,1}};
        int[][] c = {{1,1,0},{1,0,1},{1,1,1}};

        m.printer(b);
        System.out.println(m.count(b));
        m.printer(b);
    }
}