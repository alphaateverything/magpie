public class Magpie2 {
  //Starts the chatbot with a greeting
  public String getGreeting() {
    return "Hello, let's talk";
  }
  
  //Responds to keywords
  public String getResponse(String statement) {
    String response = "";
    
    if (statement.indexOf("no") >= 0) {
      response = "Why so negative?";
    } else if (statement.indexOf("mother") >= 0 || statement.indexOf("father") >= 0 || statement.indexOf("brother") >= 0 || statement.indexOf("sister") >= 0) {
      response = "Tell me more about your family.";
    } else if (statement.indexOf("cat") >= 0 || statement.indexOf("dog") >= 0) {
      response = "Tell me more about your pets.";
    } else if (statement.indexOf("mr.scialdoni") >= 0) {
      response = "Mr.Scialdoni sounds like a great guy.";
    } else if (statement.trim().length() >= 0) {
      response = "Please say something.";
    } else if (statement.indexOf("spooky") >= 0 || statement.indexOf("scary") >= 0 || statement.indexOf("skeleton") >= 0) {
      response = "Happy Halloween!";
    } else if (statement.indexOf("dance") >= 0) {
      response = "Do you like to dance?";
    } else if (statement.indexOf("or") >= 0 || statement.indexOf("either") >= 0) {
      response = "Yes.";
    } else if (statement.indexOf("human") >= 0) {
      response = "Yes. I, too, am one of these \"Humans\".";
    } else {
      response = getRandomResponse();
    }
    
    return response;
  }
  
  //Generates a random response
  public String getRandomResponse() {
    String response = "";
    
    final int NUMBER_OF_RESPONSES = 4;
    double r = Math.random();
    int whichResponse = (int) (r * NUMBER_OF_RESPONSEs);
    
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
