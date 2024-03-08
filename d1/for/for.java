class Print {
    public static void main(String[] args) {

        if (args.length != 2) {
            System.out.println("Please provide two arguments: a number and a string.");
            return;
        }

  
        int number;
        try {
            number = Integer.parseInt(args[0]);
        } catch (NumberFormatException e) {
            System.out.println("The first argument must be a valid number.");
            return;
        }


        String str = args[1];


        for (int i = 0; i < number; i++) {
            System.out.println(str);
        }
    }
}
