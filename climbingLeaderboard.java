import java.util.ArrayList;
import java.util.List;
import java.util.HashMap;
public class climbingLeaderboard
{   
    public static List<Integer> score(List<Integer> ranked , List<Integer> player){
        //storing all uniques ranks.
        List<Integer> unique  = new ArrayList();
        unique.add(ranked.get(0));
        for(int i = 1; i < ranked.size();i++){
            //since ranked are already sorted. adjacent would be
            if(unique.get(unique.size()-1) != ranked.get(i)){
                unique.add(ranked.get(i));
            }
        }
        
        HashMap<Integer,Integer> map = new HashMap();
        //inserts element into hashmap - scores are key and values are ranked.
        int r = 0;
        for(int i = 0;i < ranked.size();i++){
            int value = ranked.get(i);
            if(!map.containsKey(value)){
                r++;
                map.put(value,r);
            }
        }
        
        List<Integer> playerRank = new ArrayList();
        for(int j = 0;j < player.size();j++){
            int gameScore = player.get(j);
            if(gameScore >= ranked.get(0)){
                    playerRank.add(1);
                    continue;
            }
            for(int k = 1;k < unique.size();k++){
                if(gameScore > unique.get(k) && gameScore < unique.get(k-1)){
                    //fetch the value i.e rank of that score.
                    if(map.containsKey(unique.get(k))){
                        int rank = map.get(unique.get(k-1)) + 1;
                        playerRank.add(rank);
                        break;
                    }
                }else if(gameScore == unique.get(k)){
                    if(map.containsKey(unique.get(k))){
                        int rank = map.get(unique.get(k));
                        playerRank.add(rank);
                        break;
                    }
                }else if(gameScore > unique.get(k) && gameScore == unique.get(k-1)){
                    int rank = map.get(unique.get(k-1));
                    playerRank.add(rank);
                    break;
                }else if((k == unique.size()-1) && unique.get(unique.size()-1) > gameScore){
                    int rank = map.get(unique.get(k)) + 1;
                    playerRank.add(rank);
                    break;
                }
            }
        }
        return playerRank;
    }
	public static void main(String[] args) {
	    ArrayList<Integer> scores = new ArrayList();
	    scores.add(100);
	    scores.add(100);
	    scores.add(50);
	    scores.add(40);
	    scores.add(40);
	    scores.add(20);
	    scores.add(10);
	   // scores.add(100);
	   // scores.add(90);
	   // scores.add(90);
	   // scores.add(80);
	   // scores.add(75);
	   // scores.add(60);
	    ArrayList<Integer> playerScores = new ArrayList();
	    playerScores.add(5);
	    playerScores.add(25);
	    playerScores.add(50);
	    playerScores.add(120);
	   // playerScores.add(50);
	   // playerScores.add(65);
	   // playerScores.add(77);
	   // playerScores.add(90);
	   // playerScores.add(102);
	    List<Integer> result = score(scores,playerScores);
	    System.out.println(result);
	}
}
