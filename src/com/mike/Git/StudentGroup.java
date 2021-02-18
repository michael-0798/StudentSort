package com.mike.Git;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

/**
 *  group of students,
 *  
 *  using Lambda expression to create methods to:
 * 	1, add students, make sure that student# is unique
 * 	2, sort by scores asc or desc
 * 	3, sort by names asc or desc
 *  4, list top N students 

 * @author mikew
 * @since Feb 15, 2021
 * @version 1.0
 */
public class StudentGroup {
	/*
	 * note:
	 * 1, it seems that HashMap will be easier for add() method, if we use 
	 * student.getNumber() as the key value for the map;
	 * 2, however, when going to the sort part, we could not change the order of the 
	 * map. Yes, we could use map.values() to put all the student objects into a 
	 * new list, and then sort and output. But the output is just a "view", and 
	 * we could not get the query like: 
	 * 		SELECT * FROM table LIMIT 5 
	 * 		ORDER BY score DESC;   
	 * 3, as a conclusion, the best way is to use ArrayList to hold all the student
	 * elements.
	 */

	// variable to determine the sort order, 1 means sort ASC, -1 means sort DESC
	int sign = 0;
	int sign2 = 0;
	
	/**
	 * the list to contain all the students
	 */
	ArrayList<Student> studentList = new ArrayList<Student>();

	
	// how to make the method more efficient?
	/**
	 * add method, add new student to the list
	 * make sure that student Number must be unique
	 * @param ss: the student object to be added
	 * @return: if added successfully, return true; if failed, return false;
	 */
	public boolean add(Student ss) {
		if(studentList.contains(ss)) {
			System.out.println(ss.toString()+" already exists");
			return false;
		}
		Iterator<Student> it = studentList.iterator();
		while(it.hasNext()) {
			if(it.next().getsNumber()==ss.getsNumber()) {
				System.out.println("student with number "+ss.getsNumber()
									+ " exists in the group");
				return false;
			}
		}
		studentList.add(ss);
		return true;
	}
	
	
	/**
	 * delete student
	 * @param num: student# for the student which to be deleted
	 * @return: true, delete successfully; false, fail to delete;
	 */
	public boolean deleteByNum(int studentNum) {
		Iterator<Student> it = studentList.iterator();
		while(it.hasNext()) {
			if(it.next().getsNumber() == studentNum) {
				// use it.remove() !!!!
				it.remove();
				System.out.println("student with student number "+ studentNum + " deleted");
				return true;
			}
		}
		System.out.println("student with student number "+ studentNum + " not found");
		return false;
	}
	
	/**
	 * delete student by first name and last name
	 * @param fName: first name of the student to be deleted
	 * @param lName: last name of the student to be deleted
	 * @return: if deleted successfully, return true; if failed, return false;
	 */
	public boolean deleteByName(String fName, String lName) {
		Iterator<Student> it = studentList.iterator();
		while(it.hasNext()) {
			// must declare a temped object for it.next(); or the pointer will keep 
			// going forward in the it.next().getLastName!!!
			Student ss = it.next();
			if(fName.equalsIgnoreCase(ss.getFirstName()) && lName.equalsIgnoreCase(ss.getLastName())) {
				it.remove();
				System.out.println(fName + " "+ lName + " has been deleted");
				return true;
			}
		}
		System.out.println(fName + " "+ lName + " not found");
		return false;
	}

	/**
	 * sort method, sort by score first, and then first name
	 * @param scoreOrder: if "A", order score ASC; if "D", oder DESC
	 * @param nameOrder: if "A", order name ASC; if "D", oder DESC
	 */
	public void sort(String scoreOrder, String nameOrder) {
//		/* regular expression
		if("A".equalsIgnoreCase(scoreOrder)) {
			sign = 1;
		}else {
			sign = -1;
		}

		if("A".equalsIgnoreCase(nameOrder)) {
			sign2 = 1;
		}else {
			sign2 = -1;
		}
		
		Collections.sort(studentList,new Comparator<Student>() {
			@Override
			public int compare(Student o1, Student o2) {
				if(o1.getScore()==o2.getScore()) {
					return sign2*(o1.getFirstName().compareTo(o2.getFirstName()));
				}
				return sign*(o1.getScore()-o2.getScore());
			}
		});
//		*/
		
		
		// lambda expression
		/*
		Collections.sort(studentList,(o1, o2) -> {
				if(o1.getScore()==o2.getScore()) {
					return sign*o1.getFirstName().compareTo(o2.getFirstName());
				}
				return o1.getScore()-o2.getScore();
		});
		*/

		
	}
	
	/**
	 * sort score method, sort the students by score
	 * @param order:  if "A", order ASC; if "D", oder DESC
	 */
	public void sortScore(String order){
		if("A".equalsIgnoreCase(order)) {
			sign = 1;
		}else {
			sign = -1;
		}
		/* regular expression
		Collections.sort(studentList, new Comparator<Student>() {
			@Override
			public int compare(Student o1, Student o2) {
				return sign*(o1.getScore()-o2.getScore());
			}
		});
		*/
		
		// lambda expression
		Collections.sort(studentList, (o1, o2) ->  {
				return sign*(o1.getScore()-o2.getScore());
			}
		);
	}

	
	/**
	 * sort by firstname
	 * @param order:  if "A", order ASC; if "D", oder DESC
	 */
	public void sortFname(String order) {
		if("A".equalsIgnoreCase(order)) {
			sign = 1;
		}else {
			sign = -1;
		}

		Iterator<Student> it = studentList.iterator();
		/*regular expression
		Collections.sort(STUDENTS,new Comparator<Student>() {
			@Override
			public int compare(Student o1, Student o2) {
				String s1 = o1.getFirstName();
				String s2 = o2.getFirstName();
				return sign*(s1.compareTo(s2));
			}
		});
		*/
		
		// lambda expression
		Collections.sort(studentList,(o1, o2) -> sign*(o1.getFirstName().compareTo(o2.getFirstName())));
}
	
	
	/**
	 * list all the students
	 */
	public void show() {
		Iterator<Student> it = studentList.iterator();
		while(it.hasNext()) {
			System.out.println(it.next().toString());
		}
	}
	
	/**
	 * list students, limit to num
	 * @param num: the number of how many students wants to show in the list
	 */
	public void show(int num) {
		Iterator<Student> it = studentList.iterator();
		int counter =0;
		while(it.hasNext() && counter<num) {
			System.out.println(it.next().toString());
			counter++;
		}
	}

}
