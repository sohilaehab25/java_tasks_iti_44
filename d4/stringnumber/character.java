interface AlphabeticalChecker {
    boolean isAlphabetical(String str);
}

class Alphabetical implements AlphabeticalChecker {
    public boolean isAlphabetical(String str) {
        if (str == null || str.isEmpty()) {
            return false;
        }

        return str.chars().allMatch(Character::isLetter);
    }

    public static void main(String[] args) {
        Alphabetical alphabetical = new Alphabetical();
        String string = "welcomeToITI";
        System.out.println(alphabetical.isAlphabetical(string));
    }
}
