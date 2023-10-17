// a * b / (a + 2)
public class Lab1 {

    public static void main(String[] args) {
        try {
            int a = 1;
            int b = 1;
            int nA = 2;
            int nB = 2;

            System.out.println(calculate(a, b, nA, nB, true));

        } catch (Exception e) {
            System.out.println(e);
        }
    }
    
    private static int calculate(int a, int b, int nA, int nB, boolean doThrow) throws Exception{
        checkInput(a, nA);
        checkInput(b, nB);


        int ans = 0;
        for(; a <= nA; a++){
            for(int tempB = b; tempB <= nB; tempB++){
                ans += calculateInnerFormula(a, tempB, doThrow);
            }
        }

        return ans;
    }

    private static int calculateInnerFormula(int a, int b, boolean doThrow) throws Exception{
        // O2 = /;
        int upperPart = a * b;

        // O1 = +; C = 2;
        int VARIANT = 2;
        int lowerPart = a + VARIANT;

        if(lowerPart == 0){
            if (doThrow) {
                throw new Exception("U got an Infinity");
            }

            return 0;
        }

        return upperPart / lowerPart;
    }

    private static void checkInput(int i, int nI) throws Exception{
        if(i > nI){
            throw new Exception("Review ur input");
        }
    }
}