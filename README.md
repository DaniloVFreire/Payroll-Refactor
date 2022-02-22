# Payroll-Refactor P2 project
[![Badge](https://img.shields.io/static/v1?label=License&message=MIT&color=green&style=for-the-badge&logo=GITHUB)](https://github.com/DaniloVFreire/Payroll)
[![Badge](https://img.shields.io/static/v1?label=State&message=Inprogress&color=yellow&style=for-the-badge&logo=GITHUB)](https://github.com/DaniloVFreire/Payroll/blob/main/LICENSE)
## table of contents


1. [Introduction](#introduction)
2. [Project functionalities](#project-functionalities)
3. [Refactoring process](#refactoring-process)

## Introduction

This is the second part of **payroll system**, this project objective is to **apply the
concepts of project patterns and code smells** learned in
the programming 2 discipline.

## Project functionalities

The project structure is focused on **simulating
a corporate payroll system** that includes:

| N° |             functionalities              | finished |
| :--------: | :-------------------------------:| :---------:|     
|     1    |  Add an employee               |:white_check_mark:
|     2    |  Remove an employee            |:white_check_mark:
|     3    |  Post a time card              |:white_check_mark:
|     4    |  Post sales result             |:white_check_mark:
|     5    |  Post a service tax            |:white_check_mark:
|     6    |  Update employee details       |:white_check_mark:
|     7    |  Run today's payroll           |:white_large_square:
|     8    |  Undo/Redo                     |:white_check_mark:
|     9    |  Schedule payment              |:white_check_mark:
|    10    |  Create a new payment Schedule |:white_check_mark:
---

## Refactoring process
### Code Smells
1. **Code duplication** Code repetition in **constructors of employee's**;
2. **Large Class** all "toString" methods and "dataManager" constructor are doing more than it should
3. **Expeculative generality** creation of unused classes and methods
### Solutions
1. Fixed with **Chain constructors** in [commit]();
2. Fixed with **Stract method** in [commit]();
3. Fixed with **Remove Generative Speculation** in [commit]();

