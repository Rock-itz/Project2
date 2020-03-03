package com.company.Mayberry;

import java.util.*;


// Elijah Mayberry, CSCI 1660, 3/3/20
public class Main {
    public static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {

        ArrayList<Task> tasks = new ArrayList<>();
        Task defaultTask = new Task("Change me", "Change me", 0);

        while (true) {

            System.out.println("1) Add a task.");
            System.out.println("2) Remove a task.");
            System.out.println("3) Update a task.");
            System.out.println("4) List all tasks.");
            System.out.println("5) List priority.");
            System.out.println("6) Exit.");

            int option = input.nextInt();
            input.nextLine();

            if (option == 1) {
                tasks.add(addTask());
            }
            if (option == 2) {
                removeTask(tasks);
            }
            if (option == 3) {
                updateTask(tasks);
            }
            if (option == 4) {
                listTask(tasks);
            }
            if (option == 5) {
                listPriority(tasks);
            }
            if (option == 6) {
                break;
            }

        }

    }



    public static Task addTask() {

        String title;
        String description;
        int priority;

        System.out.println("Please enter the title of your task: ");
        title = input.nextLine();
        System.out.println("Please enter the description of your task: ");
        description = input.nextLine();

        while(true) {
            try {
                System.out.println("Please enter the priority of the task(1-5): ");
                priority = input.nextInt();
                while (priority < 1 || priority > 5) {
                    System.out.println("Please enter a priority between 1 and 5: ");
                    priority = input.nextInt();
                }
                break;

            } catch (Exception e) {
                System.out.println("You entered the wrong data type, please try again");
                input.next();

            }
        }

        return new Task(title, description, priority);
    }

    public static void removeTask(ArrayList<Task> a) {
        System.out.println("What task would you like to remove?");
        int remove = input.nextInt();

        a.remove(remove - 1);
    }

    public static void listTask(ArrayList<Task> a) {
        for (Task task : a) {
            System.out.println(task.toString());
        }
    }

    public static void updateTask(ArrayList<Task> a) {
        System.out.println("What is the index of the task you'd like to update? ");
        int index = input.nextInt();
        input.nextLine();

        System.out.println("What is the new title? ");
        String title = input.nextLine();
        System.out.println("What is the new description? ");
        String description = input.nextLine();
        System.out.println("What is the new priority? ");
        int priority = input.nextInt();

        while(priority < 1 || priority > 5) {
            System.out.println("The priority must be between 1 and 5: ");
            priority = input.nextInt();
        }
        a.set(index, new Task(title, description, priority));

    }

    public static void listPriority(ArrayList<Task> a) {
        System.out.println("What priority would you like to list? ");
        int prio = input.nextInt();

        for (Task task : a) {
            if (prio == task.getPriority()) {
                System.out.println(task);
            }
        }
    }

}