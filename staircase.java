public class staircase{
    public static void pattern(int n){
        for(int i = 0 ;i < n;i++){
            //space print
            int j = 0;
            for(j = 0; j < n - i -1 ;j++){
                System.out.print(" ");
            }

            //Hash print
            for(int k = j; k < n ;k++){
                System.out.print("#");
            }
            System.out.println();
        }
    }

    public static void main(String[] args){
        pattern(6);
    }
}