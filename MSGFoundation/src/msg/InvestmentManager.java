package msg;

public class InvestmentManager {

    private static boolean encerrarProcesso = false;		        // terminates while-loop
    private static boolean achouInvestimento = false;		        // tells if investment is found
    private static final Investment investment = new Investment();    // investment to be modified

    public static void manageInvestment()
    {
        try
        {
            locateInvestment();

            if (!achouInvestimento)
            {
                throw new Exception("Investment not found");
            }

            processInvestment();

            investment.save ();
        }
        catch (Exception e)
        {
            System.out.println ("***** Error: InvestmentManager.manageInvestment() () *****");
            System.out.println ("\t" + e);
        }

    }

    private static void processInvestment()
    {
        while (!encerrarProcesso)
        {
            printChoices();
            processChoice();

            if (!encerrarProcesso)
            {
                investment.print ();
                UserInterface.pressEnter();
            }
        }

    }

    private static void processChoice()
    {
        char choice;
        try
        {
            choice = UserInterface.getChar();

            switch (choice)
            {
                case '1':
                    investment.updateInvestmentName();
                    break;

                case '2':
                    investment.updateExpectedReturn();
                    break;

                case '3':
                case '\n':
                    encerrarProcesso = true;
                    break;

                default:
                    System.out.println ("\n\nNot a valid choice\n");
                    UserInterface.pressEnter();
                    break;
            }
        }
        catch (Exception e)
        {
            System.out.println ("***** Error: InvestmentManager.manageInvestment() *****");
            System.out.println ("\t" + e);
        }
    }

    private static void printChoices()
    {
        UserInterface.clearScreen ();

        System.out.println ("\t           UPDATE INVESTMENTS\n\n");
        System.out.println ("\t MARTHA STOCKTON GREENGAGE FOUNDATION\n\n");
        System.out.println ("\t        1. Update investment name\n");
        System.out.println ("\t        2. Update expected return\n");
        System.out.println ("\t        3. Exit to investment menu\n\n");
        System.out.println ("Enter your choice and press <ENTER>: ");
    }

    private static void locateInvestment()
    {
        char choice;
        while (!achouInvestimento && !encerrarProcesso)
        {
            System.out.println ("Please enter the number of the investment to be" +
                    " updated (12 digits): ");

            String input = UserInterface.getString();

            achouInvestimento = investment.find (input);

            if (!achouInvestimento)
            {
                System.out.println ("Investment " + input + " was not found.");
                System.out.println ("Would you like to enter another investment idn?");

                choice = UserInterface.getChar();

                if (choice == 'n')
                {
                    encerrarProcesso = true;
                }
            }
        }
    }
}
