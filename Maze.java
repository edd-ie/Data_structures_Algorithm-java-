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
        System.out.println("\nDistance 1:\n"+maze1.draw(maze1.distanceMap()));
    }
}
