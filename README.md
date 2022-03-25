## 6. Multithreading

----
### Materials

[Concurrency](https://docs.oracle.com/javase/tutorial/essential/concurrency/)
[L10 from slide 24](https://coherentsolutions.sharepoint.com/sites/training-center/_layouts/15/WopiFrame.aspx?sourcedoc=%7b64853C24-C830-4C50-B8B4-723AFC490668%7d&file=L10.pptx&action=default) 
[L11 from](https://coherentsolutions.sharepoint.com/sites/training-center/_layouts/15/WopiFrame.aspx?sourcedoc=%7b0D5F5DD0-CBDE-4EB7-8D17-CDEC874B3F64%7d&file=L11.pptx&action=default) 

### VideoLectures
- [Multithreading, part 1](https://drive.google.com/file/d/1IwXar_5zJDQ3MeCZ9h0x0FoPrLS3mPRx/view?usp=sharing)
- [ Multithreading, part 2](https://drive.google.com/file/d/1X8l1DoZaBXlEw4DkceQz8aHqK-dUOltq/view?usp=sharing)


### Task #6

Please implement `create order` functionality. Each order should be processed in separate thread. Whe user select product
, generate the random int from 1 to 30, and create thread that will process selected order for selected time, and after it
place the product in another collection (for example, purchased goods).
And create one more thread, that will be executed periodically, e.g. ones in 2 mins, that will clean up purchased collection.

You can implement this in "native" java methods  but better and simplier to use [java.util.concurrent](https://habr.com/ru/company/luxoft/blog/157273/) package.  
