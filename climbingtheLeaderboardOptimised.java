import java.util.ArrayList;
import java.util.List;
import java.util.HashMap;
public class climbingtheLeaderboardOptimised
{

    //brute force.    
    // public static List<Integer> score(List<Integer> ranked , List<Integer> player){
    //     //storing all uniques ranks.
    //     List<Integer> unique  = new ArrayList();
    //     unique.add(ranked.get(0));
    //     for(int i = 1; i < ranked.size();i++){
    //         //since ranked are already sorted. adjacent would be
    //         if(unique.get(unique.size()-1) != ranked.get(i)){
    //             unique.add(ranked.get(i));
    //         }
    //     }
        
    //     HashMap<Integer,Integer> map = new HashMap();
    //     //inserts element into hashmap - scores are key and values are ranked.
    //     int r = 0;
    //     for(int i = 0;i < ranked.size();i++){
    //         int value = ranked.get(i);
    //         if(!map.containsKey(value)){
    //             r++;
    //             map.put(value,r);
    //         }
    //     }
        
    //     List<Integer> playerRank = new ArrayList();
    //     for(int j = 0;j < player.size();j++){
    //         int gameScore = player.get(j);
    //         if(gameScore >= ranked.get(0)){
    //                 playerRank.add(1);
    //                 continue;
    //         }
    //         for(int k = 1;k < unique.size();k++){
    //             if(gameScore > unique.get(k) && gameScore < unique.get(k-1)){
    //                 //fetch the value i.e rank of that score.
    //                 if(map.containsKey(unique.get(k))){
    //                     int rank = map.get(unique.get(k-1)) + 1;
    //                     playerRank.add(rank);
    //                     break;
    //                 }
    //             }else if(gameScore == unique.get(k)){
    //                 if(map.containsKey(unique.get(k))){
    //                     int rank = map.get(unique.get(k));
    //                     playerRank.add(rank);
    //                     break;
    //                 }
    //             }else if(gameScore > unique.get(k) && gameScore == unique.get(k-1)){
    //                 int rank = map.get(unique.get(k-1));
    //                 playerRank.add(rank);
    //                 break;
    //             }else if((k == unique.size()-1) && unique.get(unique.size()-1) > gameScore){
    //                 int rank = map.get(unique.get(k)) + 1;
    //                 playerRank.add(rank);
    //                 break;
    //             }
    //         }
    //     }
    //     return playerRank;
    // }


    /*optimum - NOTE - ASSUMTION THAT playerscore is always increasing.
    As ranked array is in descending order. player score is ascending order.
    therefore for each player score will traverse the ranked from last index.
    Approach is
    1)remove the duplicate from ranked array.
    2)loop player score from start index.
    3)loop ranked scores from end index UNTIL player score >= ranked.get(k).
    4)IMPORTANT - update k index by k--. SO till here we get the required rank for
    current player score.
    5)Now Add the  final rank to result by adding K+2.
    6) why K+2, first +1 is to get actual rank of score from ranked array because
    k star start from 0.
    next +1 is to added as current player score < = ranked.get(k). So therefore rank
    has to be below.
    */
    
    // public static List<Integer> score(List<Integer> ranked , List<Integer> player){
    //     //remove duplicate.
    //     List<Integer> unique = new ArrayList();
    //     unique.add(ranked.get(0));      //adding first element
    //     for(int i = 1;i < ranked.size();i++){
    //         //never use .contains() as it traverse the all element to check if 
    //         //element exist or not leading to O(n^2)
    //         //logic is
    //         //since elements are sorted, check if 
    //         //unique.get(unique.size()-1) != ranked.get(i);
    //         //if true add current ranked element.
    //         if(unique.get(unique.size() - 1) != ranked.get(i)){
    //             unique.add(ranked.get(i));
    //         }
    //     }
        
    //     //two pointer approach to get player ranks.
    //     List<Integer> playerRank = new ArrayList();
    //     int k  = unique.size() -1;  //starting from end index
    //     for(int j = 0; j < player.size();j++){
    //         int playerScore = player.get(j);
            
    //         //Now since player scores are always increasing.
    //         //therefore we traverse ranked from end and keep updating k UNTIL
    //         // playerScore >= ranked.get(k) becomes false.
    //         while(k >= 0 && playerScore >= unique.get(k)){
    //             k--;    //update the k , i.e moving to higher rank.
    //         }
    //         playerRank.add(k+2);   //+1 to get actual rank for current score in
    //         //ranked array, next +1 to place player score rank below current
    //         //ranked score.
    //     }
    //     return playerRank;
    // }
	
	
	//OPTIMUM - USING BINARY SEARCH ON UNIQUE SORTED ARRAY.
	public static List<Integer> score(List<Integer> ranked , List<Integer> player){
	    //REMOVE duplicate.
	    List<Integer> unique  = new ArrayList();
	    unique.add(ranked.get(0));  //adding first element.
	    for(int i = 1; i < ranked.size();i++){
	        if(!unique.get(unique.size() - 1).equals(ranked.get(i))){
	            unique.add(ranked.get(i));
	        }
	    }
	    
	    
	    //using BINARY search on nested unique array.
	    List<Integer> playerRank = new ArrayList();
	    
	    for(int j = 0 ; j < player.size();j++){
	        int playerScore = player.get(j);
	        int left = 0;
    	    int right = unique.size() - 1;
    	    int rank = unique.size();   //default to lower rank
	        //using binary search to get player Rank based on score.
	        while(left <= right){
	            int mid = left + (right - left)/2;
	            //check if player score is same as mid.
	            if(playerScore == unique.get(mid)){
	                right = mid - 1;
	                rank = mid;
	                break;
	            }
	            else if(playerScore < unique.get(mid)){
	                left = mid+1;
	                rank = left;
	            }
	            else{
	                right = mid -1;
	                rank = left;
	            }
	        }
	        playerRank.add(rank+1);
	    }
	    
	    return playerRank;
	}
	public static void main(String[] args) {
	    ArrayList<Integer> scores = new ArrayList();
	   // scores.add(100);
	   // scores.add(100);
	   // scores.add(50);
	   // scores.add(40);
	   // scores.add(40);
	   // scores.add(20);
	   // scores.add(10);
	    scores.add(100);
	    scores.add(90);
	    scores.add(90);
	    scores.add(80);
	    scores.add(75);
	    scores.add(60);
	    ArrayList<Integer> playerScores = new ArrayList();
	   // playerScores.add(5);
	   // playerScores.add(25);
	   // playerScores.add(50);
	   // playerScores.add(120);
	    playerScores.add(50);
	    playerScores.add(65);
	    playerScores.add(77);
	    playerScores.add(90);
	    playerScores.add(102);
	    List<Integer> result = score(scores,playerScores);
	    System.out.println(result);
	}
}
