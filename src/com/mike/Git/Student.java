package com.mike.Git;
/**
 * class for Student,
 * each student will have firstName, lastName, student#, gender, and score
 * 
 * @author	 	mikew
 * @since 		Feb 15, 2021
 * @version		1.0
 */
public class Student {
	
	private String firstName;
	private String lastName;
	private int sNumber;
	private String gender;
	private int score;
	
	/**
	 * constructor for Student, chained to the non-arg constructor
	 * @param firstName 	first name of the student
	 * @param lastName		last name of the student
	 * @param sNumber 		student nunber of the student
	 * @param gender 		gender of the student, "F" for girl, "M" for boys
	 * @param score			score for the student
	 */
	public Student(String firstName, String lastName, int sNumber, String gender, int score) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.sNumber = sNumber;
		this.gender = gender;
		this.score = score;
	}

	/**
	 * non-arg constructor, called constructor 	public Student(String firstName, String lastName, int sNumber, String gender, int score) {}
	 */
	public Student() {
		this(null, null, 0, null, 0);
	}

	/**
	 * get value of first name
	 * @return first name, String
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * set the value of the first name
	 * @param firstName: value for first name
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	/**
	 * get the value of the last name
	 * @return last name
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * set the value of last name
	 * @param lastName: value for last name
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	/**
	 * get the value of student number
	 * @return:	student number, integer
	 */
	public int getsNumber() {
		return sNumber;
	}

	/**
	 * set the value of student number
	 * @param sNumber: the value of student number
	 */
	public void setsNumber(int sNumber) {
		this.sNumber = sNumber;
	}

	/**
	 * get the value of the gender
	 * @return:  String gender
	 */
	public String getGender() {
		return gender;
	}

	/**
	 * set the value of student's gender
	 * @param gender: gender of the student
	 */
	public void setGender(String gender) {
		this.gender = gender;
	}

	/**
	 * get the score of the student
	 * @return: integer score
	 */
	public int getScore() {
		return score;
	}

	/**
	 * set the score value 
	 * @param score: value of the score
	 */
	public void setScore(int score) {
		this.score = score;
	}

	@Override
	public String toString() {
		return "Student [firstName=" + firstName + ", lastName=" + lastName + ", sNumber=" + sNumber + ", gender="
				+ gender + ", score=" + score + "]";
	}
	
}
