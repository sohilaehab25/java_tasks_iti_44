import java.util.*;

class WordDictionary {
    //enter variable from type char as key and string as value
    private Map<Character, TreeSet<String>> words;

    //put the value beside the key through for loop
    public WordDictionary() {
        words = new HashMap<>();
        for (char c = 'a'; c <= 'z'; c++) {
            words.put(c, new TreeSet<>());
        }
    }

    //grouping for all word starts with the same letter by charat(0) 
    public void addWord(String word) {
        char firstChar = Character.toLowerCase(word.charAt(0));
        if (words.containsKey(firstChar)) {
            words.get(firstChar).add(word);
        }
    }
//printing all key and values
    public void printAll() {
        for (char c = 'a'; c <= 'z'; c++) {
            TreeSet<String> wordSet = words.get(c);
            if (wordSet != null && !wordSet.isEmpty()) {
                System.out.println(c + ": " + wordSet);
            }
        }
    }

    //searching about spesfic value
    public void printLetter(char letter) {
        char lowerCaseLetter = Character.toLowerCase(letter);
        if (words.containsKey(lowerCaseLetter)) {
            System.out.println(words.get(lowerCaseLetter));
        }
    }
}

 class Main {
    public static void main(String[] args) {
        WordDictionary wd = new WordDictionary();
        wd.addWord("apple , apple, ant");
        wd.addWord("banana");
        wd.addWord("orange");
        wd.addWord("donkey, dog");
        wd.addWord("cat");
        wd.printAll();

        //searching about spescfic letetr
        wd.printLetter('d');
    }
}
