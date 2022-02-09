++Read this file when you have difficulty, or even before.
## Hints and FAQs
### Where to put classes?
Classes have to be put in relevant modules:
- `StoreApp` → `consoleApp`. `consoleApp` module contains only class `StoreApp` with `main()` method, which `creates` instance of `Store`, fill created store with `Products` and prints all the categories and all the products. The main purpose of this module is to run the store.
- `Product`, `Category`, `BikeCategory`, `PhoneCategory`, `MilkCategory` → `domain`. `domain` module contains only domain classes. The content of this module answers the question: "What is contained in the store?" In addition to products and product categories, in the future we could put such domain classes as `User`, `Admin`, `Cart` and so on here.
- `Store`, `RandomStorePopulator` → `store`. `store` module contains all the business logic. The content of this module answers the question: "How is the business logic implemented?" In the future, there may be interfaces here. Database connection logic and so on. Perhaps now it makes sense to think about creating auxiliary classes `StoreHelper`, into which we will transfer part of the business logic from `Store`. In order our `Store` class to comply with the `SingleResponsibility` principle and not contain many methods loosely related to each other.
### Packages
The names of packages in modules can be as follows:
`by.issoft.consoleApp`, `by.issoft.domain`, `by.issoft.store`. Further inside each of the modules, we can choose the grouping that is convenient for us. For example, child categories can be grouped in the `by.issoft.domain.categories` package. Be creative and use common sense.
### Code in small chunks
This task has three sub-tasks:
- creation of domain classes;
- connection of `Faker` and generation of random product names, prices and rates;
- use of `reflections` in order to create instances of child categories and add them into category list. Remember! You should not create categories by “hands”. All child categories have to be created with help of reflections!
### How then to work smoother and faster?
First of all, create a new branch in your `GitHub` project called `03OOP`. And after creating this branch, create a branch from it to perform the simplest task, for example, with the name `03OOP-domain`. In this branch, create domain classes and create a `pull request` to merge with the `03OOP` branch. After completing this part of the task, when I do a `merge`, create a new branch, for example `03OOP-populator`, in which you work with `Faker` and `RandomStorePopulator`. Further, by analogy, we act with `reflections`.
Why is this course of action preferable? When you turn in the whole assignment at once, I have to look at the entire code at once. Usually it is 10-15 files. Often I find serious errors that lead to the fact that the code has to be rewritten. In addition, it is quite difficult to consider all the changes in one sitting. It takes me about an hour to do a good `Code Revew` and also write comments. To avoid this, we write the code in small portions. This way we will not make big mistakes, we will save our time, and on `Code Review` each of the subtasks will take me only 10-20 minutes. This way you will receive feedback from me the same or the next day after you make a `pull request`.
