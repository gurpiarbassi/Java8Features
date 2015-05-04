package com.gurps.newstuff.streams;

import static org.junit.Assert.*;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.junit.Test;

/**
 * Tests to demonstrate the java streams functionality
 * 
 * @author gurps
 *
 */
public class TestStreams {

	@Test
	/**
	 * Find the highest scoring student in year 2001.
	 */
	public void testFindHighestScorerInYear() {
		
		  List<Student> students = new ArrayList<>(); 
		  students.add(new Student("Gurps",99, 2001L));
		  students.add(new Student("Steve", 78, 2001L)); 
		  students.add(new Student("Dan", 99, 1980L)); 
		  students.add(new Student("Lisa", 26, 1999L));
		  
		  int highest = students.stream()
				  					.filter(s -> s.getYear() == 2001L) //filter records so only consider 2001 grades
				  					.map(s -> s.getScore()) //for each student s, map it to its score so the stream is now scores rather than students
				  					.max(Integer::max).get(); //perform the max function on the stream
		  assertEquals(99, highest);
		 
	}

	@Test
	public void testConvertWordsToUpperCase() {
		List<String> wordList = new ArrayList<>();
		wordList.add("test");
		wordList.add("hello");
		wordList.add("world");

		List<String> output = wordList.stream().map(String::toUpperCase)
				.collect(Collectors.toList());

		/*
		 * Notice how String::toUpperCase is used. String is the class and
		 * toUpperCase is its method. You can even do things like
		 * .map(System.out::println)
		 */

		assertTrue(output.get(0).equals("TEST"));
		assertTrue(output.get(1).equals("HELLO"));
		assertTrue(output.get(2).equals("WORLD"));
	}

	@Test
	public void testFindEvenLengthWords() {
		List<String> wordList = new ArrayList<>();
		wordList.add("test");
		wordList.add("hello");
		wordList.add("world");

		List<String> result = wordList.stream()
				.filter(w -> (w.length() & 1) == 0)
				.collect(Collectors.toList());

		assertTrue(result.size() == 1);
	}

	@Test
	public void testCountLinesInFile() {
		long count = 0;
		ClassLoader classLoader = getClass().getClassLoader();
		File file = new File(classLoader.getResource("file/Test.txt").getFile());
		try (BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(file)))) {
			count = reader.lines().count();
		} catch (IOException ex) {
			ex.printStackTrace();
			fail("something went horribly wrong");
		}
		assertEquals(20, count);
	}
	
	@Test
	public void testLengthOfLongestLineInFile(){
		int longest = 0;
		ClassLoader classLoader = getClass().getClassLoader();
		File file = new File(classLoader.getResource("file/Test.txt").getFile());
		try (BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(file)))) {
			longest = reader.lines().mapToInt(String::length).max().getAsInt();
		} catch (IOException ex) {
			ex.printStackTrace();
			fail("something went horribly wrong");
		}
		assertEquals(33, longest);
	}
}
