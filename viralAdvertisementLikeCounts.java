
public class viralAdvertisementLikeCounts
{
    public static int viralAdvertisement(int n){
        int sharedTo = 5;
        int likes = 0;
        for(int i = 0; i < n;i++){
            int dayLike = (sharedTo/2);
            System.out.println("Each day Like:"+dayLike);
            likes = likes + dayLike;
            sharedTo = dayLike * 3;
            System.out.println("Day:"+i+" sharedTo:"+sharedTo);
        }
        return likes;
    }
    
	public static void main(String[] args) {
		//System.out.println("Hello World");
		int totalLiked = viralAdvertisement(3);
		System.out.println("Total Liked:"+totalLiked);
	}
}
