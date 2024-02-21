public class MazeSolver {
    private final int[][] maze;

    public MazeSolver(int[][] maze){
        this.maze = maze;
    }

    public String draw(){
        String draw = "";

        for(int i = 0; i < maze.length;i++){
            for(int x = 0; x < maze.length;x++){
                if(maze[i][x] == 0) draw+="[*]";
                else draw+="   ";
            }
            draw+="\n";
        }

        return draw;
    }
    public String draw(int[][] map){
        String draw = "";

        for(int i = 0; i < map.length;i++){
            for(int x = 0; x < map.length;x++){
                if(map[i][x] == 0) draw+="[*]";
                else{
                    if(map[i][x] > 9) draw += map[i][x]+" ";
                    else draw += " " + map[i][x] + " ";
                }
            }
            draw+="\n";
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
                    map[x][y] = value == 0 ? -1 : value; // Manhattan distance
                }
            }
        }

        return map;
    }
}
