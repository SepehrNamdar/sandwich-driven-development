# **Sandwich Driven Development**

### Step 7 - Make your Domain Model Immutable

One of the hardest bugs to detect is when you have side effects. 
An Immutable Domain Model can help you to avoid this kind of bugs.
One of the aims of Sandwich Pattern is also to make it easier to have an Immutable Domain Model.

### What is Immutability ?

When two or more external elements can modify the state of an object after it is created, this object is not Immutable. So an Immutable object is an object that will not change after it is created.

### What to do ?

Try to clean up your Domain Model (ex: Remove dead code) and make your Domain Objects Immutable (ex: get rid of setters).