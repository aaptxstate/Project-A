import java.util.LinkedList;

public class Dictionary extends LinkedList<Definition> {
    public void query(String query) {
        int i = definitionIndex(query);
        if (i != -1) {
            Definition queryObject = get(i);
            System.out.println(query + " definitons:");
            for (int x = 0; x < queryObject.definitions.length; x++){
                System.out.println("\t" + queryObject.definitions[x]);
            }
        } else {
            System.out.println("Sorry, not found.");
        }
    }

    private int definitionIndex(String query) {
        Definition temp;
        for (int x = 0; x < size(); x++) {
            temp = get(x);
            if (temp.name.equals(query)) {
                return x;
            }
        }
        return -1;
    }

}
