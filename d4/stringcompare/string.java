import java.util.function.Predicate;
class StringCompare{
    public static String LargerString(String str1, String str2, Predicate <String> StringLength){
        return StringLength.test(str1) ? str1 : str2;
    }

    public static void main(String[] args) {
        String str1 = "sohila";
        String str2 = "soso";


        Predicate <String> compLen=s-> s.length() > 5;


    
        String result = LargerString(str1, str2, compLen);
        System.out.println("larger string is: " + result);
    }

    @Override
    public String toString() {
        return "StringCompare []";
    }

}