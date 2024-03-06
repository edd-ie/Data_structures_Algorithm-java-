public class MazeSolver {
    private final int[][] maze;


    public MazeSolver(int[][] maze){
        this.maze = maze;
    }

    public String draw(){
        String draw = "";

        for (int[] row : maze) {
            for (int x = 0; x < maze.length; x++) {
                if (row[x] == 0) draw += "[*]";
                else draw += "   ";
            }
            draw += "\n";
        }

        return draw;
    }
    public String draw(int[][] map){
        String draw = "";

        for (int[] row : map) {
            for (int x = 0; x < map.length; x++) {
                if (row[x] == 0) draw += "[*]";
                else {
                    if (row[x] > 9) draw += row[x] + " ";
                    else draw += " " + row[x] + " ";
                }
            }
            draw += "\n";
        }

        return draw;
    }

    public int[][] distanceMap(){
        int[][] map = new int[this.maze.length][this.maze[0].length];
        int[] home = new int[2];

        for(int x = 0; x < this.maze.length; x++){
            for(int y = 0; y < this.maze[x].length; y++){
                if(this.maze[x][y] == 0) map[x][y] = this.maze[x][y];
                else{
                    if(x == 0){
                        home[1] = y;
                    }
                    int value = Math.abs(home[0]-x)+Math.abs(home[1]-y);
                    map[x][y] = value == 0 ? 1 : value; // Manhattan distance
                }
            }
        }

        return map;
    }

    public int[][] floodFill(int x, int y, int endX, int endY){
        if(x == endX && y == endY) return maze;
        int min = this.maze[x][y];

        if(x > 0 && maze[x-1][y] != 0)
            min = Math.min(min, this.maze[x-1][y]);

        if(x < this.maze.length-1 && maze[x+1][y] != 0)
            min = Math.min(min, this.maze[x+1][y]);

        if(y > 0 && maze[x][y-1] != 0)
            min = Math.min(min, this.maze[x][y-1]);

        if(y < this.maze[x].length-1 && maze[x][y+1] != 0)
            min = Math.min(min, this.maze[x][y+1]);


        if(this.maze[x][y] <= min){
            this.maze[x][y] = min+1;

            if(x > 0 && maze[x-1][y] != 0)
                floodFill(x-1, y, endX, endY);

            if(x < this.maze.length-1 && maze[x+1][y] != 0)
                floodFill(x+1, y, endX, endY);

            if(y > 0 && maze[x][y-1] != 0)
                floodFill(x, y-1, endX, endY);

            if(y < this.maze[x].length-1 && maze[x][y+1] != 0)
                floodFill(x, y+1, endX, endY);
        }


        return maze;
    }
}
