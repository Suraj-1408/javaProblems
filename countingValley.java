// An avid hiker keeps meticulous records of their hikes. During the last hike that took exactly  steps, for every step it was noted if it was an uphill, , or a downhill,  step. Hikes always start and end at sea level, and each step up or down represents a  unit change in altitude. We define the following terms:

// A mountain is a sequence of consecutive steps above sea level, starting with a step up from sea level and ending with a step down to sea level.
// A valley is a sequence of consecutive steps below sea level, starting with a step down from sea level and ending with a step up to sea level.
// Given the sequence of up and down steps during a hike, find and print the number of valleys walked through.

//Sample Input 
// 8
// UDDDUDUU
public class countingValley{
     public static int valleysCount(int steps, String path) {
        // Write your code here
        int currentStep =  0;
        int valley = 0;
        for(int i = 0;i < path.length();i++){
            if(path.charAt(i)  == 'U'){
                currentStep = currentStep + 1;
            }
            else if(path.charAt(i) == 'D'){
                currentStep = currentStep - 1;
            }

            //currentStep is 0 , we are sea level & step was up , then completed on valley.
            if(currentStep == 0 && path.charAt(i) == 'U'){
                valley = valley+1;
            }
        }
        return valley;
    }

    //main
    public static void main(String[] args){
        int valleyCount = valleysCount(8,"UDDDUDUU");
        System.out.println(valleyCount);
    }
}