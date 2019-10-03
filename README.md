# Hotel Finder Assignment

A Miami hotel chain would like to offer an internet booking service. The chain is made up of three hotels: Lakewood, Bridgewood and Ridgewood. Each hotel has different weekday or weekend rates, including specific rates for loyalty program participants. Additionally, each hotel has a rating, indicating its service quality.

Write a program to find the cheapest hotel. The program entry will be a sequence of data for a customer participating or not in the loyalty program. Use "Regular" to name a regular customer and "Reward" to a customer participating in the loyalty program. The exit will be the cheapest available hotel or, in case of a tie, the higher rated hotel will be returned.

### Business specifications

- Lakewood has a rating of 3 and its weekday rates are $110 for regular customers and $80 for loyalty program participants. Weekend rates are respectively $90 and $80 for regular customers and loyalty program participants.

- Bridgewood has a rating of 4 and its weekday rates are $160 for regular customers and $110 for loyalty program participants. Weekend rates are respectively $60 and $50 for regular customers and loyalty program participants.

- Ridgewood has a rating of 5 and its weekday rates are $220 for regular customers and $100 for loyalty program participants. Weekend rates are respectively $150 and $40 for regular customers and loyalty program participants.

## Technologies and Prerequisites

* [Java](https://www.oracle.com/technetwork/java/javase/downloads/jdk11-downloads-5066655.html/) - Language (depends on Java 11 or latter)
* [Maven](https://maven.apache.org/) - Dependency Management (depends on Maven 3.6.2 or latter)
* [jUnit5](https://junit.org/junit5/) - Unit Testing Framework

## Project Building and Testing

As this project relies on Maven as a dependency manager and as a test runner, make sure you have Maven 3.6.2 or later installed on your machine entering `mvn --version`  on your terminal. For more information about how to install Maven, access its official website (http://maven.apache.org/install.html).

**Building the Project:** In the terminal, navigate to the project root directory and enter the following command waiting until the project successfully has been builded.

```
mvn package
```

**Testing the Project:** The testing pipeline will automatically be triggered during the building process described above. Even so, if you want/need, you can run it independently by navigating to the project root directory and entering:

```
mvn test
```

## Usage

Once you successfully [build](#project-building-and-testing) the project you are going to be able to run the program simply by entering the following terminal command under the project root directory, which will call the `findCheapestHotel` script passing the value surrounded by quotation marks as input.

```
sh findCheapestHotel "Regular: 16Mar2009(mon), 17Mar2009(tues), 18Mar2009(wed)"
```

If you call the `findCheapestHotel` script without any input string following it, the program will automatically look for an input file named *input* on the project root directory.

```
sh findCheapestHotel
```

Check the "Input Formatting" section [here](#input-formatting) to better understand how inputs must to be formatted.

Check the "Usage Without Shell Script" section [here](#usage-without-shell-script) to run the program without using the `findCheapestHotel` script. 

## Input Formatting

Inputs, both when typed inline on terminal or when pre defined in an input file, must match the following pattern to be considered valid and readable by the program. Letter case will be disconsidered by the program during input parsing.

```
<client_type>: <date>, <date>, <date>, ...
```

### Client Type
There are two  valid `client_type` strings. They are: `Rewards` and `Regular`. 

### Dates
You can specify as many `date` parameters as you want. However, they also must follow a pattern to be considered valid and readable by the program. The `date` string must match the following template:

```
<day><month><year>(<day_of_week>)
```

- `day` and `year` must be whole numbers;
- `month` must be `Jan`, `Feb`, `Mar`, `Apr`, `May`, `Jun`, `Jul`, `Aug`, `Sep`, `Oct`, `Nov` or `Dec`;
- `day_of_week` must be `mon`, `mond`,  `tue`, `tues`, `wed`, `wedn`, `thu`, `thur`, `fri`, `frid`, `sat`, `satu`, `sun` or `sund`

In addition to the above constraints, the date string must also to be calendar consistent. A value greater than 31, for example, would not be considered valid when given as a day. An example of valid input string would be:

```
Regular: 16Mar2009(mon), 17Mar2009(tues), 18Mar2009(wed)
```

### Input Files
When creating an input file, you must have your input strings one below the other, following the above specified rules. Make sure you named your file *"input"* and that it is on the project root folder. An example of valid input file would be:

```
Regular: 16Mar2009(mon), 17Mar2009(tues), 18Mar2009(wed), 19Mar2009(thu)
Regular: 20Mar2009(fri), 21Mar2009(sat)
Rewards: 26Mar2009(thur), 27Mar2009(fri), 28Mar2009(sat)
```

## Usage Without Shell Script

--- Something goes here --- 

## Author

**Thomaz Zandonotto** - Software Developer - 
[Github](https://github.com/thomazmz) |
[Linkedin](https://www.linkedin.com/in/thomaz-zandonotto/)

## License

2019 - This project is licensed under the MIT License - see the [LICENSE.md](LICENSE.md) file for details
