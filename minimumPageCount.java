public class minimumPageCount{

    //function to count minimum turns required.
    public static int minimumPageTurn(int n, int p){

        int pageCountFromStart = p/2;
        int pageCountFromEnd = (n/2) - (p/2);

        int minimumPageCountRequired  = (pageCountFromStart > pageCountFromEnd)?pageCountFromEnd:pageCountFromStart;

        return minimumPageCountRequired;
    }

    //main
    public static void main(String[] args){
        int minimumTurns = minimumPageTurn(6,2);
        System.out.println(minimumTurns);
    }

}