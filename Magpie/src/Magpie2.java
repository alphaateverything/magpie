public class Magpie2 {
  //Starts the chatbot with a greeting
  public String getGreeting() {
    return "Hello, let's talk";
  }
  
  //Responds to keywords
  public String getResponse(String statement) {
    String response = "";
    
    if (statement.indexOf("no") >= 0) {
      response = "Why so negative?"
    } else if (statement.indexOf("mother") >= 0 || statement.indexOf("father") >= 0 || statement.indexOf("brother") >= 0 || statement.indexOf("sister") >= 0) {
      response = "Tell me more about your family";
    } else {
      response = getRandomResponse();
    }
    
    return response;
  }
  
  //
}
