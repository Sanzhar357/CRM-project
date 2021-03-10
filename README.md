# My OOP endterm project
Our project was designed to analyze customer relationship management data. We took the client database and enter it into PGadmin PostgreSQL and output the data using a java virtual machine. In the project, we used several classes, methods to get the analyzed data.  

Description of classes:

Class Main 

Class MyApplication: 
Store different objects and refer to other classes. 
Methods: start();

Class Customer:
Store customer related fields (name, gender, etc.) includes several methods.
Methods: Customer_loop(),  showAllDataCustomer(), selectTopAgeGroup(), Geolocation(), determineOccupancy();

CustomerInput:
Extends the Customer class, provides data entry, consists of one method InputData().

Class Product:
Includes fields related to products (category, number of photos, weight), there are methods ItemLoop(), letterOfNameDescrip(),massOfProduct();

Class Orders:
Stores order information, includes methods: OrderLoop(), findActiveCustomers(), showOrderStatus();

Class Order_items:
Storing more detailed order information consists of two methods.
Methods: OrderItemLoop(), Top5ExpensiveProducts(), Top5CheapestProducts(), Top3ExpensiveProductsDate(), Top3CheapestProductsDate(), calculateFundOfCompany();
