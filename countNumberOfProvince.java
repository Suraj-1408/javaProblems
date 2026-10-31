import java.util.Queue;
import java.util.ArrayDeque;

public class countNumberOfProvince{
    public static int findCircleNum(int[][] isConnected) {
        int row = isConnected.length;
        boolean[] visited = new boolean[row];

        int provinceCount = 0;

        for(int i = 0 ; i < row;i++){
            if(visited[i]){
                continue;
            }
            provinceCount+= 1;
            
            Queue<Integer> que = new ArrayDeque<>();
            que.offer(i);
            visited[i] = true;

            while(!que.isEmpty()){
                int currentCity = que.poll();

                for(int j = 0; j < row; j++){
                    if(isConnected[currentCity][j] == 1 && !visited[j]){
                        visited[j] = true;
                        que.offer(j);
                    }
                }
            }
        }
        return provinceCount;
    }

    //main
    public static void main(String[] args){
        int[][] cities = {{1,1,0},{1,1,0},{0,0,1}};
        int totalProvince = findCircleNum(cities);
        System.out.println("Total No of Province:"+totalProvince);
    }
}
