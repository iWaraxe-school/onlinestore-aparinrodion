# 4. Collections
## Materials

[Collections](https://docs.oracle.com/javase/tutorial/collections/index.html)

[Lecture 9](https://coherentsolutions.sharepoint.com/sites/training-center/_layouts/15/WopiFrame.aspx?sourcedoc=%7bEF21525C-52B3-45A0-8E14-71BFC9BAB74E%7d&file=L9.pptx&action=default)

[XML](https://en.wikipedia.org/wiki/XML)

[XML processing](https://docs.oracle.com/javase/tutorial/jaxp/)

## VideoLectures
- [Collections, Lists, Sets, Unmodifiable Lists and Sets](https://drive.google.com/file/d/1uC3XlEtUI9rk6bYx-OBsF9PFcRfZjxDv/view?usp=sharing)
- [Lists, Sets, Maps, Unmodifiable Maps](https://drive.google.com/file/d/1wH8SLzZ\_tl97rk9AAc10uWf11oOWrcxQ/view?usp=sharing)
- [Generics (part 1)](https://drive.google.com/file/d/1k4DkEOh40x6vqLu9qVQo7O19tRkElzMd/view?usp=sharing)
- [Generics (part 2)](https://drive.google.com/file/d/1zJxJqgGjLE37Rdaf-2iUAf5FXcvcGY8Y/view?usp=sharing)
- [Functional Interfaces, Introduction to lambdas](https://drive.google.com/file/d/1HFDFxDMCyBZeSAR8wGp2WIZoFlvHw1g4/view?usp=sharing)
- [Lambdas](https://drive.google.com/file/d/1Oak\_SFxlFczz\_gBItECTDEiAyp7awzLC/view?usp=sharing)
- [Stream API](https://drive.google.com/file/d/1YPm2XcxsVy3zDC6kkDBu16Ca7V5duhJn/view?usp=sharing)
- [PrimitiveStream, Optional](https://drive.google.com/file/d/1NuD7hHJmyKlPSK3o2Ww4RuWuc7fYT\_nX/view?usp=sharing)

## Task #4

Starting extend our store. Please append ability user to interact with our store, while sending commands thru read stream.

Add support of such commands: 

- `sort` - products from store according config. In resources folder create xml config file like
```
xml
<sort>
    <name>asc</name>
    <price>asc</price>
    <rate>desc</rate>
</sort>
```
Config file can contains from 1 to N fields. Sort should be done using `Comparator`. Sort and print should not modify
 default store product lists and their order.
  
- `top` - print top 5 products of whole store sorted via price desc
- `quit` - exit app

# 3. OOP
## Materials
[OOP](https://docs.oracle.com/javase/tutorial/java/concepts/index.html)
[Lecture 3](https://coherentsolutions.sharepoint.com/sites/training-center/_layouts/15/WopiFrame.aspx?sourcedoc=%7b21357CB9-7D9D-4E18-AD42-22ADC9979308%7d&file=L3.pptx&action=default)
[Lecture 4](https://coherentsolutions.sharepoint.com/sites/training-center/_layouts/15/WopiFrame.aspx?sourcedoc=%7b87729213-AD13-40A5-876C-67E647EC725A%7d&file=L4.pptx&action=default)
[Reflection](https://docs.oracle.com/javase/tutorial/reflect/)
[Reflections Lib](https://github.com/ronmamo/reflections)
[Faker](https://github.com/DiUS/java-faker)
## VideoLectures
-  [04.oop.u1. Classes & Object](https://drive.google.com/file/d/1dCM52PcuSGPtwimDSsDCEd6\_14tW5Vom/view?usp=sharing)
-  [04.oop.u2. Reflections. ENUM](https://drive.google.com/file/d/1qqcciuQjriqlP-CcLBf1MYxkU5ItGAAS/view?usp=sharing)
-  [04.oop.u3. OOP principles](https://drive.google.com/file/d/1feJG7ydl9qM95iAnZoX\_W6JKDi2k\_W-M/view?usp=sharing)
-  [04.oop.u4. Equals&HashCodes. Abstract Classes](https://drive.google.com/file/d/1a0Nc7j81gvjPuU6zzAsaYpI8KAZITWeX/view?usp=sharing)
-  [04.oop.u5. Wrapper Classes](https://drive.google.com/file/d/1TsJZpwbCZx-AbhM0qJOxK9zEmPRJaHlD/view?usp=sharing)
-  [04.oop.u6. Interfaces](https://drive.google.com/file/d/1xAtAvvy9bcexDkEm1EWAjcowWyevR8al/view?usp=sharing)
## Task #3
Before start creating source code, read carefully all materials about OOP. It is not only 3 principles for interview;)
Store functionality should be based on above principles.
Classes to create:
- `Product` with such attributes as [name, rate, price]
- `Category` classes with the name attribute, for each store category [bike, phone, milk] and products list
- `Store` - class that should handle category list
- `RandomStorePopulator` - utility class that will populate out store/category with fake data using `Faker` lib
- `StoreApp` - class with main method to execute our store scenario.
When invoke main method, application should init store with categories and products and `pretty` print this data.
Also, categories should be read dynamically (at runtime), from base category package using `reflections` lib.
