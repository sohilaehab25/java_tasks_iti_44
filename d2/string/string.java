import java.util.*;
import java.util.Scanner;



class WordCount{
    public static void main(String[] args) {
        String statement = "hi sohila welcome sohila";
        String targetWord = "sohila";
        System.out.println("method1 : " + countWordBySplit(targetWord, statement));
        System.out.println("method2 : " + countWordByIndexOf(targetWord, statement));



    }

    public static int countWordBySplit(String targetWord,String statment) {

        String [] words = statment.split("\\s+");
        int count = 0;
        for (String word : words) {
            if (word.equalsIgnoreCase(targetWord)) {
                count++;
            }
        }

        return count;
        //return word.length;
    }

    public static int countWordByIndexOf(String targetWord,String statement) {
        int count = 0;
        int index = 0;

        while ((index = statement.toLowerCase().indexOf(targetWord.toLowerCase(), index)) != -1) {
            count++;
            index += targetWord.length();
        }

        return count;
    }

};



class Tokeniser {
        public static void main(String[] args) {
            StringTokenizer str = new StringTokenizer("welcome to ITI", " ");
            
            while (str.hasMoreTokens()) {
                System.out.println(str.nextToken());
            }
        }
    }






 class IPAddress{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter an IP address (IPv4):");
        String ipAddress = scanner.nextLine();

        if (isValidIPAddress(ipAddress)) {
            System.out.println("Valid IP address: " + ipAddress);
        } else {
            System.out.println("Invalid IP address: " + ipAddress);
        }

        scanner.close();
    }

    public static boolean isValidIPAddress(String ipAddress) {
        String[] ip_address = ipAddress.split("\\.");

        if (ip_address.length != 4) {
            return false;
        }

        for (String addresses : ip_address) {
            try {
                int value = Integer.parseInt(addresses);
                if (value < 0 || value > 255) {
                    return false;
                }
            } catch (NumberFormatException e) {
                return false; 
                // Not a valid integer
            }
        }

        return true;
    }
}

    
