# Bitmap Transformer
## In today lab we start working with bmp images using BufferedImage class to read the image  then creating methods to read,write and modifying in the image as we need
### How we did that basically  all images contain pixels and each pixel present numbers these numbers have property we start changing these number to get  same image with different colors , or rotating image abd add text in the image. 
> ### To run code or test it in your images  you need to go inside the directory after you clone the repo then run this command  :  `./gradlew run --args 'image.bmp output.bmp invert'`
* where the first argument is the file you want to use in program(this file must be in the project directory in order for the java code to find it)

* the second argument is the file name that will be saved after the program executes

* the last argument is the functionality(method) you want to be applied on the image file you want.

the available methods are the following: 

### 1. *mirror* method to mirror your image
### 2. *invert* this method will change your image color.
### 3. *addWaterMark* if you want to add text in your images you need to provide your text when you run the command as following :

* the **addWaterMark** the default text is "Hello", if you want a specific text you can pass it as fourth argument as below

>./gradlew run --args image.bmp my_design addWaterMark `here go your text massege`

if the file could not be found -> a message in red color will tell you the error.

if the file is found -> the method name will be printed in the cli and after that you will get a message tells you where the file is saved and what its name as shown below

**Image saved in** _'c/Users/user1/401/bitmap-transformer/lab_04/app/' as 'my_design.bmp'_
