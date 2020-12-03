# **Sandwich Driven Development**

### Step 5 - Make your domain pure

Now thanks to Temporal Coupling you can ensure that recruiter's availabilities will be updated before planning the interview.
But, the suggested solution contains a problem. Could you recognise it ?

#### Domain Model Pureness

A pure Domain Model is a model that does not depend on any external resource or framework and its objects know only about primitive or other domain objects.
By following this definition our Domain Model is no more pure as we injected "RecruiterRepository" into it.

So how to keep our Domain Model pure and respect the new business rule of step 4 ?

###### Solution 1 : Keep "RecruiterRepository" outside of Domain layer

This solution violate Sandwich pattern

###### Solution 2 : Use a Domain Service 

The Domain Service is a part of Domain layer (reside a bit further from the center where there are Value-Objects and Entities) and has the particularity to having the right of accepting external dependencies like "RecruiterRepository" unlike Value-Objects and Entities.
So, a Domain Service could be a better solution for our problem.

The Domain Service is a good deal between impurity and the amount of complexity in Application Service. We can't make our Domain Model 100% pure as we should respect business rules.
In this solution we delegate fewer interactions with external objects which makes Domain Service more testable than Application Service.

### What to do ?

Use a Domain Service to keep your Domain Model pure respecting the Sandwich pattern.