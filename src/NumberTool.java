public class NumberTool {
    // TODO error handling, negatives, out of range and pointless values
    public void strictPrint(int size) {
        printNum(0, " ", size);
    }


    public void binaryPrint(int size) {

        if (size <= 0) {
            return;
        }

        char[] string = new char[size];
        string[0] = '0';
        binary(size, string, 1);
        string[0] = '1';
        binary(size, string , 1);
    }

    private void binary(int size, char[] currentString, int point) {
        if (size == point) {
            System.out.print(currentString);
            System.out.print(" ");
            return;
        }

        if (currentString[point - 1] == '1') {
            currentString[point] = '0';
            binary(size, currentString, point + 1);
        }

        if (currentString[point -1] == '0') {
            currentString[point] = '0';
            binary(size, currentString, point + 1);
            currentString[point] = '1';
            binary(size, currentString, point + 1);

        }
    }

    private void printNum(int start, String currentString, int limit ) {
        if(limit == 0) {
            System.out.print(currentString);
            return;
        }

        for (int x = start; x <= 9; x++) {
            String newString = currentString + x;
            printNum(x + 1, newString, limit - 1);
        }
    }


}
