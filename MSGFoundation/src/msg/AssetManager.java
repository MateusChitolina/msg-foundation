package msg;

public class AssetManager
{

  public static void manageInvestment ()
  //
  // modifies an investment.
  //
  {
  	long start = System.currentTimeMillis();
    try
    {
	char	      option = '0';	                // # of field to be changed
	boolean	      done = false;		        // terminates while-loop
	boolean	      found = false;		        // tells if investment is found
	char	      c;			        // character entered by user
	String        input;                            // buffer for line of characters
	char	      choice;	                        // user's choice
        Investment    investment = new Investment();    // investment to be modified
		long start2 = 0;
	while (!found && !done)
	{
            System.out.println ("Please enter the number of the investment to be" +
                                " updated (12 digits): ");
            input = "123456789123";

	    found = investment.find (input);

	    if (!found)
	    {
		System.out.println ("Investment " + input + " was not found.");
		System.out.println ("Would you like to enter another investment idn?");

		choice = UserInterface.getChar();

		if (choice == 'n')
		{
		  done = true;
		}
              }
	}

	if (!found)
	{
	    return;
	}
	boolean secondVez = false;
		long elapsed = 0;

		long tempo2 = 0;
	while (!done)
	{
		while (!done)
		{
			UserInterface.clearScreen ();

			System.out.println ("\t           UPDATE INVESTMENTS\n\n");
			System.out.println ("\t MARTHA STOCKTON GREENGAGE FOUNDATION\n\n");
			System.out.println ("\t        1. Update investment name\n");
			System.out.println ("\t        2. Update expected return\n");
			System.out.println ("\t        3. Exit to investment menu\n\n");
			System.out.println ("Enter your choice and press <ENTER>: ");

			try
			{
				if (secondVez)
				{
					choice = '3';
				}
				else
				{
					secondVez = true;
					choice = '1';
				}


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
				  done = true;
				  break;

				default:
				  System.out.println ("\n\nNot a valid choice\n");
				  UserInterface.pressEnter();
				  break;
			     }
			 }
			catch (Exception e)
			{
			    System.out.println ("***** Error: AssetManager.manageInvestment() *****");
			    System.out.println ("\t" + e);
			}

			if (!done)
			{
		            investment.print ();
				elapsed = System.currentTimeMillis() - start;
		            UserInterface.pressEnter();
					start2 = System.currentTimeMillis();

			}
		}
	}

	investment.save ();
	tempo2 = System.currentTimeMillis() - start2;
	System.out.println(elapsed + tempo2);
    }
    catch (Exception e)
    {
	    System.out.println ("***** Error: AssetManager.manageInvestment() () *****");
	    System.out.println ("\t" + e);
    }

  }  // manageInvestment

//----------------------------------------------------------------------------------------------------------------------------------------------------

  public static void manageMortgage ()
  //
  // modifies a mortgage.
  //
  {
	  long start = System.currentTimeMillis();
	  long elapsed = 0;
	  long start2 = 0;
    try
    {
	char	      option = '0';		    // # of field to be changed
	boolean	      done = false;		    // terminates while-loop
	boolean	      found = false;		    // tells if mortgage is found
	char	      c;			    // character entered by user
	String        input;                        // buffer for line of characters
	char	      choice;             	    // user's choice
        Mortgage      mortgage = new Mortgage();    // mortgage to be modified

	while (!found && !done)
	{
	  System.out.println ("Please enter the number of the mortgage to be updated (12 digits): ");
          input = "123456789123";

	  found = mortgage.find (input);

	  if (!found)
	  {
		System.out.println ("Mortgage " + input + " was not found.");
		System.out.println ("Would you like to enter another mortgage?");

		choice = UserInterface.getChar();

		if (choice == 'n')
		{
		  done = true;
		}
	  }
	}

	if (!found)
	{
	  return;
	}

		boolean secondVez = false;

	while (!done)
	{
	  while (!done)
	  {
		UserInterface.clearScreen ();

		System.out.println ("\t           UPDATE MORTGAGES\n\n");
		System.out.println ("\t MARTHA STOCKTON GREENGAGE FOUNDATION\n\n");
		System.out.println ("\t        1. Update mortgagee name\n");
		System.out.println ("\t        2. Update price of home\n");
		System.out.println ("\t        3. Update date mortgage issued\n");
		System.out.println ("\t        4. Update current weekly income\n");
		System.out.println ("\t        5. Update property tax\n");
		System.out.println ("\t        6. Update insurance premium\n");
		System.out.println ("\t        7. Update mortgage balance\n");
		System.out.println ("\t        8. Exit to mortgage menu\n\n");
		System.out.println ("Enter your choice and press <ENTER>: ");

		try
		{

			if (secondVez)
			{
				choice = '8';
			}
			else
			{
				secondVez = true;
				choice = '1';
			}

			switch (choice)
			{
	                    case '1':
				mortgage.updateMortgageeName();
			        break;

	                    case '2':
				mortgage.updatePrice();
				break;

			    case '3':
				mortgage.updateDate();
			        break;

			    case '4':
				mortgage.updateWeeklyIncome();
				break;

			    case '5':
				mortgage.updatePropertyTax();
				break;

			    case '6':
				mortgage.updateInsurancePremium();
				break;

			    case '7':
				mortgage.updateBalance();
				break;

		            case '8':

		            case '\n':
				done = true;
				break;

			    default:
				System.out.println ("\n\nNot a valid choice\n");
				UserInterface.pressEnter();
				break;
			  }
			}
			catch (Exception e)
			{
				System.out.println ("***** Error: AssetManager.manageMortgage () *****");
				System.out.println ("\t" + e);
			}

			if (!done)
		        {

				mortgage.print ();
					elapsed = System.currentTimeMillis() - start;
				UserInterface.pressEnter();
					start2 = System.currentTimeMillis();
			}
		    }
		}

		mortgage.save ();
		long tempo2 = System.currentTimeMillis() - start2;
		System.out.println(elapsed + tempo2);
            }

    catch (Exception e)
    {
	System.out.println ("***** Error: AssetManager.manageMortgage () *****");
	System.out.println ("\t" + e);
    }

  }  // manageMortgage

//----------------------------------------------------------------------------------------------------------------------------------------------------




}