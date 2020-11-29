# **Sandwich Driven Development**

### Step 4 - Add a new business rule using Temporal Coupling :

In all projects the business rules change and as a Software Developer we should try to find a simple and maintainable solution.

#### Temporal Coupling

Temporal Coupling is when the lines of code should be executed in some order, otherwise something wrong will happen.
For example, you should first open a document to be able to modify it.

#### Business Rule

We ask you to ensure that the Recruiter will be saved before the Interview object. In other word the code should prevent you if the Recruiter will be saved after the Interview. Try to find a way to implement this new business rule in your code using Temporal Coupling.