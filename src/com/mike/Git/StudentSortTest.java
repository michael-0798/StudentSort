package com.mike.Git;

import java.util.ArrayList;

/**
 * test class for the program
 * insert the score for each student in our class
 * student number is like primary key in SQL (must be unique)
 * sort student (like SQL query: order by score or firstName ASC/DSC)
 * list top N students (like SQL query: select * from table limit N)
 * 
 * @author	 	mikew
 * @since 		Feb 15, 2021
 * @version		1.0
 */
public class StudentSortTest {
	public static void main(String[] args) {
		
		StudentGroup group = new StudentGroup();
		
		// add students
		group.add(new Student("Mike","Colione",5,"M",49));
		group.add(new Student("Ragnar","Rothbrook",3,"M",39));
		group.add(new Student("Sansa","Stark",2,"F",32));
		group.add(new Student("Jon","Snow",1,"M",29));
		group.add(new Student("Mike","Jordan",5,"M",49));
		group.add(new Student("Utred","Ragnason",4,"M",49));
		group.add(new Student("Nucky","Thompson",6,"M",19));
		group.add(new Student("Fiona","Gallagher",7,"F",59));
		group.add(new Student("Tyrion","Lanister",8,"M",59));
		
		// delete student by student#
		group.deleteByNum(5);
		
		// sort students by score ascending
		group.sortScore("a");
		
		// sort students by firstname desc
		group.sortFname("d");
		
		// delete student by name
		group.deleteByName("jon", "snow");
		
		// sort students by score first ,and then by first name
		group.sort("d", "d");
		
		// list all students
		group.show();
	}

}
