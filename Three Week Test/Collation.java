import java.io.*;
import java.util.*;

public class Collation {
static String key;
	static Comparator<String> com = (a, b) -> {

		return (ch(a, b));
		

	};

	
