# LibraryManagementSystem
 
Assumptions :
1. Admin - Username : 123 Password : 123
2. When encountering errors, program exits
3. At places where UID is not defined. Name/Username to be used as unique identifiers
4. Discount for special deals is credited into the visitor's balance after they do applySpecialDeals()
5. 2 types of memberships available as mentioned in assignment, however visitor can buy ticket without being a basic member
   at the same price as a basic member, however once you upgrade to premium, all following tickets come at no price.
6. Once a visitor is a premium visitor, they are not charged for anything
7. Discount does not apply on membership purchase
8. Revenue is the sum from membership and ticket collection
9. If a visitor is visiting an attraction, it is trusted on the user that they beforehhand went and bought a single use ticket for that ride
10. Count of ticketed visitors is maintained but hasnt been asked to be printed anywhere, so you cannot view it but the static list exists
11. Inorder to remove an animal, you need to enter type, name correctly. space and case sensitive
12. the requisite for 2 animals in each category, once you run the program, you can add two animals in each category at runtime, havent stored them from beforehand
13. both special deals and discounts wont be applicable unless explicitly applied
14. while leaving feedback, it is assumed you will enter correct feedback

HOME_FOLDER = src

All the commands should be run on the terminal in the HOME_FOLDER unless otherwise specified.

0) Download the src code folder from Classroom and unzip.
1) mvn clean
2) mvn compile
3) mvn package
4) cd  target
5) java -cp .\A2_2022466-1.0-SNAPSHOT.jar org.example.Zoo



Description :

**Admin.java - Class Summary**

The `Admin` class is a key component of the ZOOtopia system, representing administrators responsible for managing attractions, animals, discounts, feedback, and special deals within the zoo. Here's a summary of the primary features and methods provided by the `Admin` class:

**Attributes:**

- `name`: Name of the admin.
- `age`: Age of the admin.
- `phoneNumber`: Phone number of the admin.
- `email`: Email address of the admin.
- `password`: Password for admin authentication.

**Methods:**

- `addAttraction()`: Allows administrators to add new attractions to the zoo. Admins can specify the attraction name, description, ticket price, and whether the attraction is currently open.

- `viewAttractions()`: Permits administrators to view the list of attractions in the zoo.

- `modifyAttraction()`: Enables administrators to modify existing attractions. Admins can change the name, description, ticket price, and open/close status of an attraction.

- `removeAttraction()`: Lets administrators remove an attraction from the zoo based on its name.

- `addAnimal()`: Allows administrators to add new animals to the zoo. Admins can choose the type of animal (Mammal, Amphibian, or Reptile) and specify the name and description.

- `updateAnimalDetails()`: Permits administrators to update the details of an existing animal. Admins can change the name and description of the animal based on its type.

- `removeAnimal()`: Allows administrators to remove an animal from the zoo based on its type, name, and description.

- `viewDiscount()`: Not yet implemented.

- `addDiscount()`: Enables administrators to add new discount codes to the system. Admins can define a discount code and specify the percentage discount it provides.

- `modifyDiscount()`: Allows administrators to modify an existing discount code, changing its name and percentage discount.

- `removeDiscount()`: Permits administrators to remove a discount code from the system based on its name.

- `viewFeedback()`: Enables administrators to view feedback provided by visitors to the zoo.

- `giveFeedBack()`: Not yet implemented.

- `viewAnimals()`: Not yet implemented.

- `setSpecialDeal()`: Allows administrators to set special deals for visitors based on the number of tickets they purchase. Admins can define the number of tickets required and the percentage discount to be applied.

- `removeSpecialDeal()`: Permits administrators to remove a special deal based on the number of tickets required.

- `viewSpecialDeals()`: Allows administrators to view the special deals available, including the required number of tickets and the corresponding percentage discount.

- `viewVisitorList()`: Enables administrators to view the list of visitors registered with the zoo.

This `Admin` class provides the administrative interface for managing various aspects of the zoo, including attractions, animals, discounts, feedback, and special deals. Some methods related to discounts and feedback are not yet implemented and would require further development.


**Visitor.java - Class Summary**

The `Visitor` class is a fundamental component of the ZOOtopia system, representing visitors to the zoo. It extends the `User` class and implements various interfaces for managing attractions, animals, discounts, and special deals. Below is a summary of the key features and methods provided by the `Visitor` class:

**Attributes:**

- `name`: Name of the visitor.
- `age`: Age of the visitor.
- `phoneNumber`: Phone number of the visitor.
- `email`: Email address of the visitor.
- `password`: Password for visitor authentication.
- `balance`: The available balance for the visitor to purchase tickets and memberships.
- `purchasedTickets`: An ArrayList to store the tickets purchased by the visitor.

**Methods:**

- `toString()`: Overrides the `toString` method to display visitor information, including name, age, phone number, email, password, and balance.

- `getBalance()`: Retrieves the visitor's current balance.

- `setBalance()`: Sets the visitor's balance.

- `viewAttractions()`: Allows visitors to view the list of attractions in the zoo.

- `viewAnimals()`: Allows visitors to view the list of animals in the zoo.

- `buyTickets()`: Enables visitors to purchase tickets for attractions. The method considers discounts and premium visitor status. It deducts the ticket price from the visitor's balance and adds the purchased ticket to the `purchasedTickets` list.

- `leaveFeedback()`: Allows visitors to leave feedback. The method prompts for an email address and feedback content, which is then added to the zoo's feedback list.

- `buyMembership()`: Lets visitors purchase either basic or premium memberships. The cost is deducted from the visitor's balance, and premium membership status is recorded if purchased.

- `viewDiscount()`: Allows visitors to view available discounts and their corresponding codes.

- `addDiscount()`: Not implemented.

- `modifyDiscount()`: Not implemented.

- `removeDiscount()`: Not implemented.

- `setSpecialDeal()`: Not implemented.

- `removeSpecialDeal()`: Not implemented.

- `viewSpecialDeals()`: Allows visitors to view available special deals and the conditions for applying discounts.

- `applySpecialDeals()`: Applies special deals to the visitor's purchased tickets based on the number of tickets bought, reducing the ticket prices accordingly.

**Static Methods:**

- `getVisitorArrayList()`: Retrieves the list of all visitors.

- `setVisitorArrayList()`: Sets the list of all visitors.

This `Visitor` class forms a core part of the ZOOtopia system, enabling visitors to interact with the zoo's offerings, purchase tickets, provide feedback, and more. Additional functionality related to discounts, special deals, and animal/attraction management is available but not yet implemented in the provided code.