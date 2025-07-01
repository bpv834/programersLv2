import java.util.*;
class Solution {
    int[] dy = new int[]{-1,1,0,0};
    int[] dx = new int[]{0,0,-1,1};
    Queue<Pos> q = new LinkedList<Pos>();
    int[][] visits;
    int n;
    int m;

    public int solution(int[][] maps) {
        n= maps.length;
        m= maps[0].length;
        visits=new int[n][m];
        for(int i=0; i<n;i++){
            for(int j=0; j<m;j++){
                visits[i][j]= -1;
            }
        }
        q.add(new Pos(0,0));
        visits[0][0]=1;
        bfs(new Pos(0,0),maps);
        // for(int i=0; i<n;i++) System.out.println(Arrays.toString(visits[i]));

        int answer = 0;
        if(visits[n-1][m-1] == -1) return -1;
        return visits[n-1][m-1];
    }
    void bfs(Pos pos, int[][] maps){
        while(!q.isEmpty()){
            Pos value = q.poll();
            int y = value.y;
            int x = value.x;

            for(int i=0; i<4;i++){
                int ny = y+dy[i];
                int nx = x+dx[i];
                if(ny>=0&& ny<n&& nx>=0 && nx<m&& visits[ny][nx]==-1&& maps[ny][nx] == 1){
                    q.add(new Pos(ny,nx));
                    visits[ny][nx] = visits[y][x]+1;
                }
            }
        }
    }
}

class Pos{
    int y;
    int x;

    Pos(int y, int x){
        this.y=y;
        this.x=x;
    }

}