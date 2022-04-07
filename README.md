### 8. HTTP

----
#### Materials

[HTTP](https://en.wikipedia.org/wiki/Hypertext_Transfer_Protocol)
[HTTP simple servers (plain java/lib)](https://syntaxcorrect.com/Java/5_Ultra_Lightweight_Http_Server_Implementations_in_Java_for_Blazing_Fast_Microservices_APIs_or_Even_Websites)
[Basic auth](https://en.wikipedia.org/wiki/Basic_access_authentication)
[RestAssured](https://rest-assured.io/)
#### Task #8

The same task as previous, but to store and get store data you should 
- implement HTTP server (use included in java or external lib), that will handle in memory or DB your categories, but you will receive them via HTTP protocol.
- Also, you should implement `add product to cart` logic in this server, and process this request via HTTP.
- And finally, your HTTP service should be secured with basic authentication  (credentials can be hardcoded).
- For Http client side you also can use default (included in java) or use RestAssured. 
   
