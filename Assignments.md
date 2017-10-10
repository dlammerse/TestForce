Assignments
==================

##### Exercise 1
a) Create step 'And I travel to Utrecht'. The background color of
the step will turn into brown box, this means that there is no java
connected to this step. Use Alt + Enter, choose 'Create step definition',
choose NS (com.capgemini.steps).<br/>
b) Check the generated java code, remove the auto generated `throw new PendingException();`.
This exception is generated to make sure that you understand java  code a bit
before you can run a successful execution.<br/>
c) Use firefox to navigate to `https://www.ns.nl/producten/s/enkele-reis`
and open firepath to identify the the selector for the From field on the NS website.<br/>
d) In IntelliJ use copy paste from the `iTravelFromAmsterdam()` method, change
the CSS selector to selector you found in firepath.<br/>
e) Is the `.sendKeys()` the right method to use here.<br/>
f) Right-click on scenario naam 'travel from Amsterdam to Utrecht' and choose 'Run Scenario:..'


<br/><br/>
*NOTE: You will learn the most from finding things out yourself. If you
are stuck and don't know the answer, try to google it. Try to use words
like cucumber, selenium or java to find your answer. Next exersises will be
less descriptive. Remember it is not about finishing the exercises first
it's about learning as much as possible.*<br/><br/>

##### Exercise 2
a) Create new steps for every field on the webpage. <br/>
b) For every step copy paste the findElement, change the selector, use
 the correct interaction. <br/>
c) If an unique selector is difficult to find check if CheatSheet.docx can help you.


##### Exercise 3
a) Add ticket to shopping cart and check if the price is what you expect.<br/>
b) Use smart waits if elements are not immediately available<br/>
c) You can use Assert.assertEquals() to verify if the shown price is correct.

##### Exercise 4
Parameterize input and output data in steps

##### Exercise 5
a) Create a second scenario in the same feature file<br/>
b) Reuse steps from the first scenario<br/>
c) Execute the second scenario

##### Exercise 6
Use Scenario Outlines to execute scenario several times with different data (visit https://docs.cucumber.io/docs/gherkin.html for an example)

##### Exercise 7
Make a scenario that navigates back and forward to the shopping cart.
What issues do you face?

##### Exercise 8
Use datatables to input more lines of data in a scenario. Use a for loop
to access all the data in the table.

##### Exercise 9
Make a new feature file and test the  `http://www.deltalloyd.nl/overlijdensrisicoverzekering/` page. What new issues do you face at this page?

<br/><br/>
------------
##### Advanced exercises
a) Rename the step **I clicked accept in cookie popup** to **I click accept
 in cookie popup** and create code yourself to click on the accept button.
  First try without looking at the origal code. Sometimes the cookie popup
   does not appear, how can you solve that problem?<br/>
b) Make screenshots and save them<br/>
c) Make sure your scenario works in Firefox, Chrome and IE using the same code<br/>
d) Make an own implicit wait in the Our...Driver classes<br/>









