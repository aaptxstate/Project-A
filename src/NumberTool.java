public class NumberTool {
    // TODO error handling, negatives
    private int numberOfNumbers = 0;
    public void strictPrint(int digit) {
        printNum(0, " ", digit);
    }

    private void printNum(int start, String currentString, int limit ) {
        if(limit == 0) {
            System.out.print(currentString);
            return;
        }

        for (int x = start; x <= 9; x++) {
            numberOfNumbers++;
            String newString = currentString + x;
            printNum(x + 1, newString, limit - 1);
        }
    }
}
