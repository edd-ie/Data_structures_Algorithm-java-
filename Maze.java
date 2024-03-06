public class Maze {
    public static void main(String[] args) {
        int[][] map1 = {
                {0,0,0,1,0,0,0,0,0,0},
                {0,1,1,1,1,1,1,1,1,0},
                {0,1,0,0,0,0,1,0,1,0},
                {0,1,1,1,0,1,1,0,1,0},
                {0,1,0,1,0,1,0,0,1,0},
                {0,1,1,1,1,1,0,1,1,0},
                {0,0,0,0,0,1,0,0,0,0},
                {0,1,0,1,0,1,0,0,1,0},
                {0,1,1,1,1,1,1,1,1,0},
                {0,0,0,0,0,0,0,1,0,0}
        };


        MazeSolver maze1 = new MazeSolver(map1);
        System.out.println("\nMap 1:\n"+maze1.draw());
        System.out.println("\nDistance from entrance:\n"+maze1.draw(maze1.distanceMap()));
        System.out.println("\nFlood Fill:\n"+maze1.draw(maze1.floodFill(0,3, map1.length-1, 7)));
    }
}
