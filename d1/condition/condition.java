class Condition {
    public static void main(String[] args) {
        if (args.length > 0) {
            System.out.println("Received input:");
            for (String arg : args) {
                System.out.println(arg);
            }
        } else {
            System.out.println("No input arguments provided.");
        }
    }
}
