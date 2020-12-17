package connections;
/*
pr68.dat
6
8:22 AM 8:35 AM
9:08 AM 10:03 AM
11:46 AM 12:23 PM
2:50 PM 5:30 PM
9:21 PM 10:29 PM
11:04 PM 11:48 PM
*/

import java.io.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.*;

public class Pr68 {

	public static void main(String[] args) throws FileNotFoundException {
		Scanner scan = new Scanner(new File("pr68.dat"));
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("h:m a");
		int noSets = scan.nextInt();
		scan.nextLine();
		long total = 0;
		while (noSets-- > 0) {
			String[] arr = scan.nextLine().split(" ");
			String time1 = arr[0] + " " + arr[1];
			String time2 = arr[2] + " " + arr[3];
			LocalTime t1 = LocalTime.parse(time1, formatter);
			LocalTime t2 = LocalTime.parse(time2, formatter);
			total += t1.until(t2, ChronoUnit.MINUTES);

		}

		System.out.println("Total Minutes: " + total);

	}

}
