public class electronicShopItem
{
    static int getMoneySpent(int[] keyboards, int[] drives, int b) {
        /* Write your code here*/
        int currentItemPrice = 0;
        int maxItemPrice = -1;  //by default -1 , if item price matches budget
        for(int i = 0; i < keyboards.length;i++){
            int keyboardItemPrice = keyboards[i];
            for(int j = 0 ;j < drives.length;j++){
                currentItemPrice = keyboardItemPrice + drives[j];
                
                if(currentItemPrice <= b && currentItemPrice > maxItemPrice){
                    maxItemPrice = currentItemPrice;
                }
            }
        }
        return maxItemPrice;
    }
	public static void main(String[] args) {
		//System.out.println("Hello World");
		int[] keyboard = {4};
		int[] drives = {5};
		
		int maxItemPurchase = getMoneySpent(keyboard,drives,1);
		System.out.println("MaxPrice Item Purchase:"+maxItemPurchase);
	}
}
