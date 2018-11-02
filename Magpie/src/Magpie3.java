public class Magpie3 {
  //Starts the chatbot with a greeting
  public String getGreeting() {
    return "Hello, let's talk";
  }
  
  //Responds to keywords
  public String getResponse(String statement) {
    String response = "";
    
    if (findKeyword(statement, "no") >= 0) {
      response = "Why so negative?";
    } else if (findKeyword(statement, "mother") >= 0 || findKeyword(statement, "father") >= 0 || findKeyword(statement, "brother") >= 0 || findKeyword(statement, "sister") >= 0) {
      response = "Tell me more about your family.";
    } else if (findKeyword(statement, "cat") >= 0 || findKeyword(statement, "dog") >= 0) {
      response = "Tell me more about your pets.";
    } else if (findKeyword(statement, "Mr.Scialdoni") >= 0) {
      response = "He sounds like a great guy.";
    } else if (statement.trim().length() <= 0) {
      response = "Please say something.";
    } else if (findKeyword(statement, "spooky") >= 0 || findKeyword(statement, "scary") >= 0 || findKeyword(statement, "skeletons") >= 0) {
      response = "Happy Halloween!";
    } else if (findKeyword(statement, "dance") >= 0) {
      response = "Do you like to dance?";
    } else if (findKeyword(statement, "or") >= 0 || findKeyword(statement, "either") >= 0) {
      response = "Yes.";
    } else if (findKeyword(statement, "human") >= 0) {
      response = "Yes. I, too, am one of these \"Humans\".";
    } else {
      response = getRandomResponse();
    }
    
    return response;
  }
  
  private int findKeyword(String statement, String goal, int startPos)
	{
		String phrase = statement.trim();

		int psn = phrase.toLowerCase().indexOf(goal.toLowerCase(), startPos);

		
		while (psn >= 0)
		{
			
			String before = " ", after = " ";
			if (psn > 0)
			{
				before = phrase.substring(psn - 1, psn)
						.toLowerCase();
			}
			if (psn + goal.length() < phrase.length())
			{
				after = phrase.substring(
						psn + goal.length(),
						psn + goal.length() + 1)
						.toLowerCase();
			}

			// If before and after aren't letters, we've
			// found the word
			if (((before.compareTo("a") < 0) || (before
					.compareTo("z") > 0)) // before is not a
											// letter
					&& ((after.compareTo("a") < 0) || (after
							.compareTo("z") > 0)))
			{
				return psn;
			}

			
			psn = phrase.indexOf(goal.toLowerCase(),
					psn + 1);

		}

		return -1;
	}


	private int findKeyword(String statement, String goal)
	{
		return findKeyword(statement, goal, 0);
	}
  
  //Generates a random response
  public String getRandomResponse() {
    String response = "";
    
    final int NUMBER_OF_RESPONSES = 4;
    double r = Math.random();
    int whichResponse = (int) (r * NUMBER_OF_RESPONSES);
    
    if (whichResponse == 0) {
      response = "Interesting, tell me more";
    } else if (whichResponse == 1) {
      response = "Hmmm.";
    } else if (whichResponse == 2) {
      response = "Do you really think so?";
    } else if (whichResponse == 3) {
      response = "You don't say.";
    }
    
    return response;
  }
}
