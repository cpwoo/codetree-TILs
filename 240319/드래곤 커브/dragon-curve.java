import java.io.*;
import java.util.*;

public class Main {
    static int[] dx = new int[]{1,0,-1,0};
    static int[] dy = new int[]{0,-1,0,1};

    static boolean[][] arr = new boolean[101][101];

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());

        while (n-- > 0) {
            st = new StringTokenizer(br.readLine(), " ");
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            int g = Integer.parseInt(st.nextToken());

            arr[x][y] = true;

            List<Integer> move = new ArrayList<>();
            move.add(d);

            while (g-- > 0) {
                int L = move.size();
                for (int i=L-1; i>=0; i--) {
                    move.add((move.get(i)+1)%4);
                }
            }

            for (Integer m : move) {
                int nx = x+dx[m];
                int ny = y+dy[m];
                arr[nx][ny] = true;
                x = nx; y = ny;
            }
        }

        int ret = 0;
        for (int i=0; i<100; i++) {
            for (int j=0; j<100; j++) {
                if (arr[i][j] && arr[i+1][j] && arr[i][j+1] && arr[i+1][j+1]) ret++;
            }
        }

        System.out.println(ret);
    }
}