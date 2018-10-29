1) This project is for Invoice generation using Spring Boot

2) ExceptionController is default to handle all exception in application 

3) ShoppingController except following requests

	a) GET request with default invoice (response format JSON)
		http://localhost:8080/shopping/invoice

	b) GET request with product and qty ( response format JSON)
		http://localhost:8080/shopping?items=Item1:1,Item2:1

	//jackson parser was not working correctly, i need to work on this 
	c) GET request with product and qty uwing json ( response format JSON)
		http://localhost:8080/shopping/jsoninput?items={{"Product":"Item1","Qty":1},{"Product":"Item1","Qty":1}}


6) For Security (use BASIC AUTH)
	a) Two roles UESR and ADMIN created as default;
	b) user/user and admin/admin are login credential

7) Internationalization is done only on below Get Request (this can be further expand for other requests as well)
	http://localhost:8080/shopping/locale

8) ProductDao and TaxCategoryDao implimented temporary