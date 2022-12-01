# README - best price finder
This is a simple java program to demonstrate asynchronous programming with Java.

# Note
This program is based on the java tutorial by [Mosh - Ultimate Java Part 3: Advanced Topics](https://codewithmosh.com/p/ultimate-java-part-3),  
and some modification and refactor were made.

# How to run
You can clone this repo and run the Main.java.

# Explanation
You may assume this program is mock example of a program that fetches the flight price (i.e. Quote) from several websites.  
In such program, generally speaking, it fetches the data from several websites via API.  
In synchronous code, when one data is retrieved faster than others, the gap between them is not utilized and CPU resources are wasted.  
Since this program is written in non-blocking manner, however, the CPU resource can be used for other processes.  
This asynchronous execution of the program can be seen from the following animation.  

![ezgif com-gif-maker](https://user-images.githubusercontent.com/91676145/204954763-6a6a886d-4ea3-4e00-b15d-2b9704ad7a84.gif)
