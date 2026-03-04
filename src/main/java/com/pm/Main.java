package com.pm;

import java.util.*;
import java.util.function.*;
import java.util.stream.*;

public class Main {

    static class Employee {
        String name;
        String department;
        int salary;
        int age;

        Employee(String name, String department, int salary, int age) {
            this.name = name;
            this.department = department;
            this.salary = salary;
            this.age = age;
        }

        public String getName() { return name; }
        public String getDepartment() { return department; }
        public int getSalary() { return salary; }
        public int getAge() { return age; }

        @Override
        public String toString() {
            return name + "-" + department + "-" + salary + "-" + age;
        }
    }

    public static void main(String[] args) {

        List<Integer> numbers = Arrays.asList(1,2,3,4,5,6,7,8,9,10);
        List<String> names = Arrays.asList("Gaurav","Rahul","Ravi","Amit","Ankit","Rohan","gaurav", "apple");
        List<String> words = Arrays.asList("apple","banana","mango","kiwi","pear","grape","orange");

        List<Employee> employees = Arrays.asList(
                new Employee("Amit","IT",60000,28),
                new Employee("Rahul","HR",45000,32),
                new Employee("Ravi","IT",75000,30),
                new Employee("Ankit","Finance",50000,26),
                new Employee("NamaN","IT",90000,29),
                new Employee("Rohan","Media",40000,35)
        );

        /*
        ==================================================
        ================= EASY (1-25) ====================
        ==================================================
        */

        // 1. Filter even numbers from numbers
        // TIP: filter()
        System.out.println("Even numbers are :" + numbers.stream().filter(n -> n % 2 == 0).toList());

        // 2. Filter odd numbers
        System.out.println("Odd numbers are :" + numbers.stream().filter(n -> n % 2 != 0).toList());

        // 3. Multiply each number by 3
        System.out.println("Multiply each number by 3 :"+ numbers.stream().map(item -> item*3).toList());

        // 4. Convert all names to uppercase
        System.out.println("Upper case all names :" +  names.stream().map(String::toUpperCase).toList());

        // 5. Convert all names to lowercase
        System.out.println("Lower case all names :" +  names.stream().map(String::toLowerCase).toList());

        // 6. Count numbers greater than 5
        System.out.println("Numbers greater than 5 are :" + numbers.stream().filter(n -> n > 5).count());

        // 7. Find max number
        System.out.println("Max number is :"+ numbers.stream().max(Integer::compare).orElseThrow());

        // 8. Find min number
        System.out.println("Min number is :"+ numbers.stream().min(Integer::compare).orElseThrow());

        // 9. Find first element
        System.out.println("First element :"+ numbers.stream().findFirst().get());

        // 10. Find any element
        System.out.println("Any element "+ numbers.stream().findAny().get());

        // 11. Check if all numbers are positive
        System.out.println("If all numbers are positive :"+ numbers.stream().allMatch(n -> n > 0));

        // 12. Check if any number > 8
        System.out.println("If numbers greater than 8 :"+ numbers.stream().anyMatch(n -> n > 8));

        // 13. Remove duplicates from names
        System.out.println("Removing duplicates from names :"+names.stream().map(String::toLowerCase).distinct().toList());

        // 14. Sort numbers ascending
        System.out.println("Sort numbers in asc :" + numbers.stream().sorted().toList());

        // 15. Sort numbers descending
        System.out.println("Sort numbers in desc :" + numbers.stream().sorted(Comparator.reverseOrder()).toList());

        // 16. Sum all numbers
        // TIP: reduce()
        System.out.println("Sum of all numbers :"+ numbers.stream().mapToInt(Integer::intValue).sum());

        // 17. Join names with comma
        // TIP: Collectors.joining()
        System.out.println("Joining name with comma :"+ names.stream().collect(Collectors.joining(",")));

        // 18. Limit first 5 numbers
        System.out.println("Limiting first five numbers :"+ numbers.stream().limit(5).toList());

        // 19. Skip first 3 numbers
        System.out.println("Skipping first 3 numbers :"+ numbers.stream().skip(3).toList());

        // 20. Convert numbers to strings
        System.out.println("Numbers to string :"+numbers.stream().map(String::valueOf).toList());

        // 21. Print each name using method reference
        System.out.print("Each name :");
        names.stream().forEach(System.out::println);
        System.out.println();

        // 22. Collect numbers into Set
        System.out.println("Collect into set : "+numbers.stream().collect(Collectors.toSet()));

        // 23. Get square of each number
        System.out.println("Square of each number : "+numbers.stream().map(item -> item*item).toList());

        // 24. Count names starting with 'A'
        System.out.println("Names starting with A count : "+ names.stream().filter(name -> name.toUpperCase().startsWith("A")).count());

        // 25. Get list of name lengths
        System.out.println("Length of each name :" + names.stream().map(String::length).toList());



        /*
        ==================================================
        ================= MEDIUM (26-60) =================
        ==================================================
        */

        // 26. Partition numbers into even/odd
        // TIP: partitioningBy()
        System.out.println("Partition number into odd and even" + numbers.stream().collect(Collectors.partitioningBy(n -> n % 2 == 0)));

        // 27. Group names by first character
        // TIP: groupingBy()
        System.out.println(
                "Group name by first character: " +
                        names.stream()
                                .collect(Collectors.groupingBy(name -> name.toUpperCase().charAt(0)))
        );

        // 28. Count occurrence of each name
        System.out.println("Occurrence of each name :" + names.stream()
                .collect(Collectors.groupingBy(String::toUpperCase, Collectors.counting())));

        // 29. Find second highest number
        System.out.println("Second highest number :"+ numbers.stream().sorted(Comparator.reverseOrder()).skip(1).findFirst().orElseThrow());

        // 30. Find third smallest number
        System.out.println("Third smallest number :"+numbers.stream().sorted().skip(2).findFirst().orElseThrow());

        // 31. Find duplicate names
        Set<String> seen = new HashSet<>();
        System.out.println("Duplicate names are :"+names.stream().map(String::toUpperCase).filter(name -> !seen.add(name)).distinct().toList());

        // 32. Flatten List<List<Integer>>
        // TIP: flatMap()
        System.out.println("Flatten list :" + Stream.of(employees).flatMap(Collection::stream).toList());

        // 33. Find longest word
        System.out.println("Longest word :"+names.stream().max(Comparator.comparingInt(String::length)).orElseThrow());

        // 34. Find shortest word
        System.out.println("Longest word :"+names.stream().min(Comparator.comparingInt(String::length)).orElseThrow());

        // 35. Create Map<String,Integer> name->length
        System.out.println("Map of name -> length :"+names.stream().collect(Collectors.toMap(name-> name, String::length)));

        // 36. Find average of numbers
        System.out.println("Avg of numbers :"+ numbers.stream().mapToInt(Integer::intValue).average().orElseThrow());

        // 37. Get top 3 highest numbers
        System.out.println("Top 3 numbers are : "+ numbers.stream().sorted(Comparator.reverseOrder()).limit(3).toList());

        // 38. Remove null values from list
        System.out.println("removing null from the list :"+ words.stream()
                .filter(Objects::nonNull)
                .toList());

        // 39. Check if list contains duplicates
        System.out.println(
                "Checking duplicate in list : " +
                        (names.stream()
                                .map(String::toUpperCase)
                                .distinct()
                                .count() < names.size())
        );

        // 40. Group numbers by even/odd and sum them
        // TIP: groupingBy + summingInt
        System.out.println(
                "Grouping num -> sum: " +
                        numbers.stream()
                                .collect(Collectors.groupingBy(
                                        n -> n % 2 == 0,
                                        Collectors.summingInt(Integer::intValue)
                                ))
        );

        // 41. Create frequency map of characters in "hello"
        System.out.println("Frequency map of hello : "+Arrays.stream("hello".split(""))
                .collect(Collectors.groupingBy(
                        c -> c,
                        Collectors.counting()
                )));

        // 42. Find names with length > 5
        System.out.println("Names with length greater than 5 : "+names.stream().filter(n -> n.length() > 5).toList());

        // 43. Sort words by length
        System.out.println("Sorting words by length : "+ words.stream().filter(Objects::nonNull).sorted(Comparator.comparingInt(String::length)).toList());

        // 44. Reverse each string in names
        System.out.println("Reversing each string in name : "+names.stream().map(str -> new StringBuilder(str).reverse().toString()).toList());

        // 45. Find product of all numbers
        System.out.println("Product of each number is : "+ numbers.stream().reduce(1, Math::multiplyExact));

        // 46. Convert names to Map<name, uppercaseName>
        System.out.println("name -> nameUppercase :"+names.stream().collect(Collectors.toMap(str-> str, String::toUpperCase)));

        // 47. Find first name starting with R
        System.out.println("Firt name  starting with R : "+ names.stream().filter(name -> name.toUpperCase().startsWith("R")).findFirst().get());

        // 48. Count words containing 'a'
        System.out.println("Words contain A : "+ words.stream().filter(str-> str.contains("a")).count());

        // 49. Check if all words length > 3
        System.out.println("All words length greater than 3 : "+ words.stream().allMatch(str-> str.length()>3));

        // 50. Find distinct sorted characters from string "programming"
        System.out.println(Arrays.stream("programming".split("")).distinct().sorted().toList());

        // 51. Find intersection of two lists
        System.out.println(names.stream().filter(words::contains).toList());

        // 52. Find union of two lists
        System.out.println(Stream.concat(names.stream(), words.stream()).distinct().toList());

        // 53. Remove numbers less than 5
        System.out.println(numbers.stream().filter(number-> number>=5).toList());

        // 54. Find max length word
        System.out.println(words.stream().max(Comparator.comparingInt(String::length)).orElseThrow());

        // 55. Find numbers divisible by both 2 and 3
        System.out.println(numbers.stream().filter(number-> number%2 == 0 && number%3 == 0).toList());

        // 56. Convert List<Employee> to List<String> (only names)
        System.out.println("List : " + employees.stream().map(Employee::getName).toList());

        // 57. Filter employees with salary > 50000
        System.out.println(employees.stream().filter(employee -> employee.getSalary()>=5000).toList());

        // 58. Get average salary
        System.out.println(employees.stream().mapToInt(Employee::getSalary).average().orElseThrow());

        // 59. Find employee with highest salary
        System.out.println(employees.stream().max(Comparator.comparingInt(Employee::getSalary)).orElseThrow());

        // 60. Find youngest employee
        System.out.println(employees.stream().min(Comparator.comparingInt(Employee::getAge)).orElseThrow());


        /*
        ==================================================
        ================= HARD (61-85) ===================
        ==================================================
        */

        // 61. Group employees by department
        System.out.println(employees.stream().collect(Collectors.groupingBy(item-> item.getDepartment())));
        // 62. Find highest salary per department
        // TIP: groupingBy + maxBy
        System.out.println(employees.stream().collect(Collectors.groupingBy(Employee::getDepartment, Collectors.maxBy(Comparator.comparingInt(Employee::getSalary)))));
        // 63. Find total salary per department
        System.out.println(employees.stream().collect(Collectors.groupingBy(Employee::getDepartment, Collectors.summingInt(Employee::getSalary))));
        // 64. Partition employees by age > 30
        System.out.println(employees.stream().collect(Collectors.partitioningBy(emp-> emp.getAge() > 30)));
        // 65. Sort employees by salary descending
        System.out.println(employees.stream().sorted(Comparator.comparingInt(Employee::getSalary).reversed()).toList());
        // 66. Find second highest paid employee
        System.out.println(employees.stream().sorted(Comparator.comparingInt(Employee::getSalary).reversed()).skip(1).limit(1).collect(Collectors.toList()));
        // 67. Group employees by department and count
        System.out.println(employees.stream().collect(Collectors.groupingBy(Employee::getDepartment, Collectors.counting())));
        // 68. Convert employees to Map<name, salary>
        System.out.println(employees.stream().collect(Collectors.toMap(Employee::getName, Employee::getSalary)));
        // 69. Get list of employees sorted by age
        System.out.println(employees.stream().sorted(Comparator.comparingInt(Employee::getAge)).map(Employee::getName).collect(Collectors.toList()));
        // 70. Get departments sorted by total salary descending
        System.out.println(employees.stream().sorted(Comparator.comparingInt(Employee::getSalary).reversed()).map(Employee::getDepartment).collect(Collectors.toList()));
        // 71. Find department with highest average salary
        System.out.println(
                employees.stream()
                        .collect(Collectors.groupingBy(
                                Employee::getDepartment,
                                Collectors.averagingInt(Employee::getSalary)
                        ))
        );
        // 72. Nested grouping: department -> age group (<30, >=30)
        System.out.println(employees.stream().collect(Collectors.groupingBy(Employee::getDepartment, Collectors.groupingBy(emp-> emp.getAge()>=30 ? ">=30" : "<30"))));
        // 73. Find employees whose name starts with 'A'
        System.out.println(employees.stream().map(Employee::getName).filter(name-> name.toUpperCase().startsWith("A")).collect(Collectors.toList()));
        // 74. Get top 2 youngest employees
        System.out.println(employees.stream().sorted(Comparator.comparingInt(Employee::getAge)).limit(2).toList());
        // 75. Get distinct departments
        System.out.println(employees.stream().map(Employee::getDepartment).distinct().toList());
        // 76. Find employee names sorted alphabetically
        System.out.println(employees.stream().map(Employee::getName).toList());
        // 77. Check if any employee salary > 100000
        System.out.println(employees.stream().map(Employee::getSalary).anyMatch(salary-> salary>100000));
        // 78. Find employees older than average age
        System.out.println(employees.stream()
                .filter(employee -> employee.getAge()>employees.stream().collect(Collectors.averagingInt(Employee::getAge)))
                .toList());
        // 79. Create custom comparator to sort by name then salary
        System.out.println(employees.stream().sorted(Comparator.comparing(Employee::getName).thenComparing(Employee::getSalary)).toList());
        // 80. Group employees by salary range (40k-60k, 60k+)
        System.out.println(
                employees.stream()
                        .collect(Collectors.groupingBy(
                                emp -> emp.getSalary() > 60000 ? "60k+" : "40k-60k"
                        ))
        );
        // 81. Find first non-repeated character in string "swiss"
        System.out.println();
        // 82. Find all palindromes from list
        System.out.println(
                employees.stream()
                        .map(Employee::getName)
                        .filter(name -> new StringBuilder(name).reverse().toString().equalsIgnoreCase(name))
                        .toList()
        );
        // 83. Check if two strings are anagrams using streams
        String str1 = "apple";
        String str2 = "aplpe";
        System.out.println(Arrays.equals(str1.chars().sorted().toArray(), str2.chars().sorted().toArray()));
        // 84. Create frequency map of words in sentence
         String sentence = "apple banana apple orange banana apple orange";
        System.out.println(Arrays.stream(sentence.split(" ")).collect(Collectors.groupingBy(word-> word, Collectors.counting())));
        // 85. Flatten nested employee lists
        System.out.println();


        /*
        ==================================================
        ============== ADVANCED (86-100) =================
        ==================================================
        */

        // 86. Use parallel stream to sum numbers

        // 87. Compare sequential vs parallel execution time

        // 88. Create custom collector to collect into LinkedList

        // 89. Use reduce to concatenate names

        // 90. Use collectingAndThen to make unmodifiable list

        // 91. Use teeing collector (Java 12+) to get sum and average together

        // 92. Convert stream to primitive stream and back

        // 93. Find max difference between any two numbers

        // 94. Sliding window sum of size 3 using streams

        // 95. Find running total using streams

        // 96. Create Map<Department, List<EmployeeNamesSortedBySalary>>

        // 97. Multi-level grouping: dept -> salary -> list of employees

        // 98. Find top 3 highest paid employees per department

        // 99. Create immutable map of name -> salary

        // 100. Complex:
        // From employees:
        // - group by department
        // - compute total salary
        // - sort departments by total salary descending
        // - return top department

    }
}