# Hotel Searcher Assignment

A Miami hotel chain would like to offer an internet booking service. The chain is made up of three hotels: Lakewood, Bridgewood and Ridgewood. Each hotel has different weekday or weekend rates, including specific rates for loyalty program participants. Additionally, each hotel has a rating, indicates a service of excellence.

Write a program to find the cheapest hotel. The program entry will be a sequence of data for a customer participating or not in the loyalty program. Use "Regular" to name a regular customer and "Reward" to a customer participating in the loyalty program. Exit will be the cheapest available hotel and in case of a tie, or the higher rated hotel will be returned.

### Business specifications

- Lakewood has a rating of 3 and its weekday rates are $110 for regular customers and $80 for loyalty program participants. Weekend rates are respectively $90 and $80 for regular customers and loyalty program participants.

- Bridgewood has a rating of 4 and its weekday rates are $160 for regular customers and $110 for loyalty program participants. Weekend rates are respectively $60 and $50 for regular customers and loyalty program participants.

- Ridgewood has a rating of 5 and its weekday rates are $220 for regular customers and $100 for loyalty program participants. Weekend rates are respectively $150 and $40 for regular customers and loyalty program participants.

## Getting Started

Once you [build](#project-build) the project you're gonna be able to run it simply by entering the following terminal command under the project directory:

```
 sh findCheapestHotel "Regular: 16Mar2009(mon), 17Mar2009(tues), 18Mar2009(wed)"
```

### Project Building and Testing

This project relies on Maven as dependency manager and test runner. Thus, make shure you have Maven 3.6.2 or latter installed on your machine by entering `mvn --version`  on any terminal window. For more information about how to install Maven, access its official web site (http://maven.apache.org/install.html).

**Building:** Navigate through a terminal window to the project directory and entering:

```
mvn package
```

**Testing:** The testing pipeline will automatically be triggered during the build process discribed above. Even so, if you want/need, you can achieve to run it independently by navigating to the project directory and entering:

```
mvn test
```

## Technologies and Prerequisites

* [Java](https://www.oracle.com/technetwork/java/javase/downloads/jdk11-downloads-5066655.html/) - Chosen language (depends on Java 11 or latter)
* [Maven](https://maven.apache.org/) - Dependency Management (depends on Maven 3.6.2 or latter)
* [jUnit5](https://junit.org/junit5/) - Unit Testing Framework

## Authors

* **Thomaz Zandonotto** - Web Developer - 
[Github](https://github.com/thomazmz) |
[Linkedin](https://www.linkedin.com/in/thomaz-zandonotto/)

## License

This project is licensed under the MIT License - see the [LICENSE.md](LICENSE.md) file for details
