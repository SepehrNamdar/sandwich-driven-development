# **Sandwich Driven Development**

### Step 2 - Apply the Sandwich Pattern to your Application Service :

Now that you have protected your code with Approval Tests, you can get into Refactoring a little more safely.

The aim of this step is to apply Sandwich Pattern to our Application Service.

#### What is an Application Service ?

An Application Service is the entry point of a use case of our system.
Its responsibility is to orchestrate the use case and its steps.
This is the case of PlanInterview class in our code which contains the scenario of planning an interview given a candidate and its availability.

#### How to apply Sandwich Pattern to our code ?

Applying Sandwich Pattern consist of pushing the work with shared states (generally Database) to its extremes (up and down) between which we have an immutable domain we interact with.

So let's go to our Application Service (PlanInterview) and try to identify the lines of code that interact with external layers (for example Repositories which interact with Infrastructure layer) of our system.
Then try to push them to extreme up (for reading data) and extreme down (for saving data) of your Application Service.
By doing that your domain code finds himself in Sandwich between these two parts of code and give you your Pattern.

#### What are the benefices of this Pattern ?

Separating your domain code from external interactions helps you to :
 - reach a Domain Model which is pure and isolated
 - writing the tests for your domain model easier
 - understand your use case better
 - maintain your code easier
