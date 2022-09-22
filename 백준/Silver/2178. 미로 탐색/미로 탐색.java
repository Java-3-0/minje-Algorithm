import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	static int N, M, cnt=0;
	static int visited[][], mat[][];
	
	public static void main(String [] args) {
		
		Scanner scan= new Scanner(System.in);
		
		N= scan.nextInt();
		M= scan.nextInt();
		visited= new int[N][M];
		mat= new int[N][M];
		
		String str;
		for(int i=0; i<N; i++) {
			str= scan.next();
			for(int j=0; j<M; j++) {
				mat[i][j]= Integer.parseInt(str.charAt(j)+"");	
			}
		}
		
		bfs(0,0);
		
		System.out.println(mat[N-1][M-1]);
		
	}
	
	public static void bfs(int x, int y) {
		int[] dx= {-1, 0, 0, 1};
		int[] dy= {0, -1, 1, 0};
		int nx, ny;
		
		Queue<Integer> que= new LinkedList<Integer>();
		que.offer(x);
		que.offer(y);
		visited[x][y]=1;
		cnt++;
		
		while(!que.isEmpty()) {
			x=que.poll();
			y=que.poll();
			for(int j=0; j<4; j++) {
				nx= x+dx[j];
				ny= y+dy[j];
				if(nx>=0&&nx<N&&ny>=0&&ny<M) {
					if(mat[nx][ny]>0&&visited[nx][ny]!=1) {
						visited[nx][ny]=1;
						mat[nx][ny]= mat[x][y]+1;
						que.offer(nx);
						que.offer(ny);
					}
				}//if
			}
		}//while
		
	}//bfs
	
}