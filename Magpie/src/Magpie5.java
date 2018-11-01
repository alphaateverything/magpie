public class Magpie5
{
/**
* Get a default greeting
* @return a greeting
*/
public String getGreeting()
{
return "Hello, let's talk.";
}
/**
* Gives a response to a user statement
*
* @param statement
* the user statement
* @return a response based on the rules given
*/
public String getResponse(String statement)
{
String response = "";
if (statement.length() == 0)
{
response = "Say something, please.";
}
else if (findKeyword(statement, "no") >= 0)
{
response = "Why so negative?";
}
else if (findKeyword(statement, "mother") >= 0

|| findKeyword(statement, "father") >= 0
|| findKeyword(statement, "sister") >= 0
|| findKeyword(statement, "brother") >= 0)

{
response = "Tell me more about your family.";
}
// Responses which require transformations
else if (findKeyword(statement, "I want to", 0) >= 0)
{
response = transformIWantToStatement(statement);
}

// Part of student solution
else if (findKeyword(statement, "I want", 0) >= 0)
{
response = transformIWantStatement(statement);
}
else
{
// Look for a two word (you &lt;something&gt; me)
// pattern
int psn = findKeyword(statement, "you", 0);
if (psn >= 0

&& findKeyword(statement, "me", psn) >=

0)

{
response = transformYouMeStatement(statement);
}
else
{
// Part of student solution
// Look for a two word (I &lt;something&gt; you)
// pattern
psn = findKeyword(statement, "i", 0);
if (psn >= 0

&& findKeyword(statement, "you",

psn) >= 0)

{
response =

transformIYouStatement(statement);
}
else
{
response = getRandomResponse();
}
}
}
return response;
}
/**
* Take a statement with &quot;I want to &lt;something&gt;.&quot; and transform it
into
* &quot;What would it mean to &lt;something&gt;?&quot;
* @param statement the user statement, assumed to contain &quot;I want to&quot;
* @return the transformed statement
*/
private String transformIWantToStatement(String statement)
{
// Remove the final period, if there is one
statement = statement.trim();
String lastChar = statement.substring(statement

.length() - 1);
if (lastChar.equals("."))
{

statement = statement.substring(0, statement

.length() - 1);

}
int psn = findKeyword (statement, "I want to", 0);
String restOfStatement = statement.substring(psn + 9).trim();
return "What would it mean to " + restOfStatement + "?";
}
/**
* Take a statement with "I want &lt;something&gt;." and transform it into
* &quot;Would you really be happy if you had &lt;something&gt;?&quot;
* @param statement the user statement, assumed to contain &quot;I want&quot;
* @return the transformed statement
*/
private String transformIWantStatement(String statement)
{
// Remove the final period, if there is one
statement = statement.trim();
String lastChar = statement.substring(statement

.length() - 1);
if (lastChar.equals("."))
{
statement = statement.substring(0, statement

.length() - 1);

}
int psn = findKeyword (statement, "I want", 0);
String restOfStatement = statement.substring(psn + 6).trim();
return "Would you really be happy if you had " +

restOfStatement + "?";
}
/**
* Take a statement with &quot;you &lt;something&gt; me&quot; and transform it into
* &quot;What makes you think that I &lt;something&gt; you?&quot;
* @param statement the user statement, assumed to contain &quot;you&quot;
followed by "me&quot;
* @return the transformed statement
*/
private String transformYouMeStatement(String statement)
{
// Remove the final period, if there is one
statement = statement.trim();
String lastChar = statement.substring(statement

.length() - 1);
if (lastChar.equals("."))
{
statement = statement.substring(0, statement

.length() - 1);

}
int psnOfYou = findKeyword (statement, "you", 0);
int psnOfMe = findKeyword (statement, "me", psnOfYou + 3);
String restOfStatement = statement.substring(psnOfYou + 3,

psnOfMe).trim();

return "What makes you think that I " + restOfStatement + "

you?";
}
/**
* Take a statement with &quot;I &lt;something&gt; you&quot; and transform it into
* &quot;Why do you &lt;something&gt; me?&quot;
* @param statement the user statement, assumed to contain &quot;I&quot;
followed by &quot;you&quot;
* @return the transformed statement
*/
private String transformIYouStatement(String statement)
{
// Remove the final period, if there is one
statement = statement.trim();
String lastChar = statement.substring(statement

.length() - 1);
if (lastChar.equals("."))
{
statement = statement.substring(0, statement

.length() - 1);

}
int psnOfI = findKeyword (statement, "I", 0);
int psnOfYou = findKeyword (statement, "you", psnOfI);
String restOfStatement = statement.substring(psnOfI + 1,

psnOfYou).trim();

return "Why do you " + restOfStatement + " me?";
}

/**
* Search for one word in phrase. The search is not case
* sensitive. This method will check that the given goal
* is not a substring of a longer string (so, for
* example, &quot;I know&quot; does not contain &quot;no&quot;).
*
* @param statement
* the string to search
* @param goal
* the string to search for
* @param startPos
* the character of the string to begin the
* search at
* @return the index of the first occurrence of goal in
* statement or -1 if it&#39;s not found
*/
private int findKeyword(String statement, String goal,

int startPos)

{
String phrase = statement.trim().toLowerCase();
goal = goal.toLowerCase();
// The only change to incorporate the startPos is in

// the line below
int psn = phrase.indexOf(goal, startPos);
// Refinement--make sure the goal isn&#39;t part of a
// word
while (psn >= 0)
{
// Find the string of length 1 before and after
// the word
String before = " ", after = " ";
if (psn > 0)
{
before = phrase.substring(psn - 1, psn);
}
if (psn + goal.length() < phrase.length())
{
  after = phrase.substring(

  psn + goal.length(),
  psn + goal.length() + 1);

  }
  // If before and after aren&#39;t letters, we&#39;ve
  // found the word
  if (((before.compareTo("a") < 0) || (before

  .compareTo("z") > 0)) // before is not

  a
  // letter

  && ((after.compareTo("a") < 0) ||

  (after

  .compareTo("z") > 0)))

  {
  return psn;
  }
  // The last position didn&#39;t work, so let&#39;s find
  // the next, if there is one.
  psn = phrase.indexOf(goal, psn + 1);
  }
  return -1;
  }
  /**
  * Search for one word in phrase. The search is not case sensitive.
  * This method will check that the given goal is not a substring of a
  longer string
  * (so, for example, &quot;I know&quot; does not contain &quot;no&quot;). The search
  begins at the beginning of the string.
  * @param statement the string to search
  * @param goal the string to search for
  * @return the index of the first occurrence of goal in statement or -
  1 if it&#39;s not found
  */
  private int findKeyword(String statement, String goal)
  {

  return findKeyword (statement, goal, 0);
  }

  /**
  * Pick a default response to use if nothing else fits.
  * @return a non-committal string
  */
  private String getRandomResponse ()
  {
  Random r = new Random ();
  return randomResponses [r.nextInt(randomResponses.length)];
  }
  private String [] randomResponses = {"Interesting, tell me more",

  "Hmmm.",
  "Do you really think so?",
  "You don't say."

  };
}
