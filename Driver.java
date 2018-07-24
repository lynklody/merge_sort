import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Driver 
{
  public static void main (String[] args) throws FileNotFoundException
  {
	  // gather inputs into the correct columns
	  ArrayList<Integer> c11 = new ArrayList<Integer>();
	  ArrayList<Integer> c22 = new ArrayList<Integer>();
	  ArrayList<Integer> c33 = new ArrayList<Integer>();
	  ArrayList<Integer> c44 = new ArrayList<Integer>();
	  String filename = "";
//	  Scanner kbd = new Scanner(System.in);
//	  System.out.println("Enter input file name: ");
//	  filename = kbd.nextLine();
	  if (args.length == 0)
	  {
		  System.out.println("Please enter the input file name correctly.");
		  System.exit(1);
	  }
	  else
	  {
		  filename = args[0];
	  }
	  Scanner in = new Scanner(new FileInputStream(filename));
	  int linecount = 0;
	  while (in.hasNextLine())
	  {
		  String[] line = in.nextLine().split(" ");
		  linecount++;
		  if (line.length != 4)
		  {
			  System.out.println("The column number is not 4 at line number" + linecount);
			  System.exit(1);
		  }
		  c11.add(Integer.parseInt(line[0]));
		  c22.add(Integer.parseInt(line[1]));
		  c33.add(Integer.parseInt(line[2]));
		  c44.add(Integer.parseInt(line[3]));
	  }

	  if (c11.size() != c22.size() || c11.size() != c33.size() || c11.size() != c44.size())
	  {
		  System.out.println("Different column length!");
		  System.exit(1);
	  }
	  
	  // convert arraylists to arrays
	  int[] c1 = new int[c11.size()];
	  int[] c2 = new int[c11.size()];
	  int[] c3 = new int[c11.size()];
	  int[] c4 = new int[c11.size()];
	  for (int i = 0; i < c11.size(); ++i)
	  {
		  c1[i] = c11.get(i);
		  c2[i] = c22.get(i);
		  c3[i] = c33.get(i);
		  c4[i] = c44.get(i);
	  }

	  // sort each column of numbers
	  ArrayList<Merge> list = new ArrayList<Merge>();
	  Merge m1 = new Merge(c1);
	  list.add(m1);
	  m1.mergeSortStarter();
//	  System.out.println(m1);
	  Merge m2 = new Merge(c2);
	  list.add(m2);
	  m2.mergeSortStarter();
//	  System.out.println(m2);
	  Merge m3 = new Merge(c3);
	  list.add(m3);
	  m3.mergeSortStarter();
//	  System.out.println(m3);
	  Merge m4 = new Merge(c4);
	  list.add(m4);
	  m4.mergeSortStarter();
//	  System.out.println(m4);
	  
	  
	  int common12 = 0;
	  int[] sorted1 = m1.getSortedArray();
	  int[] sorted2 = m2.getSortedArray();
	  int[] sorted3 = m3.getSortedArray();
	  int[] sorted4 = m4.getSortedArray();
	  int m = 0, n = 0;
	  boolean found = false;
	  while (m < sorted1.length && n < sorted1.length)
	  {
		  if (sorted1[m] == sorted2[n])
		  {
			  common12 = sorted1[m];
			  
			  int p = 0, q = 0;
			  while (p < sorted1.length && q < sorted1.length)
			  {
				  if (sorted3[p] == sorted4[q])
				  {
					  if (common12 == sorted3[p])
					  {
						  found = true;
						  System.out.println("The number "+ common12 + " appears in all 4 columns.");
						  break;
					  }
				  }
				  else if (sorted3[p] < sorted4[q])
				  {
					  p++;
				  }
				  else
				  {
					  q++;
				  }
			  }
		  }
		  else if (sorted1[m] < sorted2[n])
		  {
			  m++;
		  }
		  else
		  {
			  n++;
		  }
		  if (found)
		  {
			  break;
		  }
	  }
	  
	  if (!found)
	  {
		  System.out.println("There is no common numbers in the 4 columns.");
	  }  
  }
}
