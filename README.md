# Elevator app
Simulation of working elevator which moves people between different floors. 
The Number of floors and the number of people on each floor generates randomly.
Human`s destination floor generate randomly too when people appeared on the floor;
#### Available setting
 - Elevator`s payload
 - Elevator`s start position
 - Number of floor (with min and max value)
 - Number of people on the floor
 - Numbers of cycles

#### How to start
Run from Main class
#### Example of visualisation
```
******** cycle 0 ********
6 |                   |
5 |                   | 4 0
4 |                   | 6 0
3 |                   | 4 6 6 2 0 2 2 2
2 |                   | 6 0 1
1 |                   | 3 6 5 3 5 2 2 5 3 0
0 | ↑       1 2 2 6 2 | 5
******** cycle 1 ********
6 |                   |
5 |                   | 4 0
4 |                   | 6 0
3 |                   | 4 6 6 2 0 2 2 2
2 |                   | 6 0 1
1 | ↑       2 2 6 2 3 | 6 5 3 5 2 2 5 3 5 0
0 |                   | 5
******** cycle 2 ********
6 |                   |
5 |                   | 4 0
4 |                   | 6 0
3 |                   | 4 6 6 2 0 2 2 2
2 | ↑           6 3 6 | 4 4 0 1 1
1 |                   | 6 5 3 5 2 2 5 3 5 0
0 |                   | 5
******** cycle 3 ********
6 |                   |
5 |                   | 4 0
4 |                   | 6 0
3 | ↑       6 6 4 6 6 | 6 2 0 2 2 2
2 |                   | 4 4 0 1 1
1 |                   | 6 5 3 5 2 2 5 3 5 0
0 |                   | 5
```