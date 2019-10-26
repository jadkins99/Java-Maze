# Java-Maze
## Object Oriented Design - Fall 2019

A maze program in Java. Created by Atalay Kutlay, Timon Braun, Tyrell Daniels, and Jacob Adkinds. It includes two approaches to create a maze and two approaches to solve a maze. 

![Screenshot](assets/javamaze.gif)

Creating approaches :
- BFSGenerator (Jacob Adkinds)
- HallwayGenerator (Timon Braun)


Solving approaches :
- RandomPathFinder (Atalay Kutlay)
- StayRightPathFinder (Tyrell Daniels)
	
You can find details about the approaches in the documentation below.




# Documentation

## BFSGenerator

BFSGenerator is a maze generator class for our program. The class implements the MazeGenerator interface. 

Methods :

	- generate(Maze m) : This method takes a maze and generates a solveble maze. It creates a random maze first, and then tests if the maze is solveble using a Breadth-first search to find the finishing point from the starting point.

## HallwayGenerator
## Maze
## MazeAdapter
## MazeApplication
## MazeDisplayGraphics

## MazeGenerator

MazeGenerator is an interface for the maze generator approaches.

Methods : 

- generate(Maze m)

## MazeMonster
## PathFinder
## RandomPathFinder
## RectMaze
## Square
## Thing
