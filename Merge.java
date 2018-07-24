public class Merge
{
	  private int[] a;
	  private int ops;

	  public Merge(int[] array)
	  {
		  a = new int[array.length];  
		  for (int i = 0; i < array.length; ++i)
		  {
			  a[i] = array[i];
		  }
		  ops = 0;
	  }
	  
	  public int[] getSortedArray()
	  {
		  return a;
	  }
	  
	  public void mergeSortStarter()
	  {
		  ops = 0;
		  mergeSort(a, 0, a.length - 1);
	  }

	  public void mergeSort(int [] a, int p, int r)
	  {
		  //System.out.println("entering mergeSort with range " + p + ".." + r);
		  ++ops;
		  if (p < r)
		  {
			  ops += 6;
			  int q = (p + r) / 2;
			  mergeSort(a, p, q);
			  mergeSort(a, q + 1, r);
			  merge(a, p, q, r);
		  }
	  }

	  public void merge(int [] a, int p, int q, int r)
	  {
		  int i;
		  int [] b = new int[r-p+1];
		  ops += 2;
		  int leftHand = p;
		  int rightHand = q + 1;
		  for (++ops, i = 0; ++ops>0 && i < b.length; ++ops, ++i)
		  {
			  if ((++ops>0 && rightHand > r) ||
					  ++ops>0 && leftHand <= q && ++ops>0 && a[leftHand] < a[rightHand])
			  {
				  ops += 2;
				  b[i] = a[leftHand];
				  ++leftHand;
				  //System.out.println("left hand case,  b[" + i + "] = " + b[i]);
			  }
			  else
			  {
				  ops += 2;
				  b[i] = a[rightHand];
				  ++rightHand;
				  //System.out.println("right hand case, b[" + i + "] = " + b[i]);
			  }
		}
		  // now copy the temporary b array into a sub-array within a.
		  for (++ops, i = 0; ++ops>0 && i < b.length; ++ops, ++i)
		  {
			  ++ops;
			  a[p+i] = b[i];
		  }

	    //System.out.println("At end of merge, array is " + this);
	  }
	  
	  public String toString()
	  {
		  String str = "";
		  for (int i = 0; i < a.length; ++i)
		  {
			  str += a[i] + " ";
		  }
		  return str;
	  }
}