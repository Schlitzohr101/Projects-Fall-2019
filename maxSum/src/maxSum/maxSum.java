package maxSum;
import java.math.*;
import java.util.*;

class maxSum{

static int stupidFreshmen(int n, ArrayList<Integer> a){  

int maxSum = 0;
//i: starting index of sum
for(int i=0; i < n; i++)
{
 //j: ending index of sum
 for(int j=i; j < n; j++)
 {
 int thisSum = 0;
 for(int k=i; k <= j; k++)
 thisSum += a.get(k);
 if(thisSum > maxSum)
    maxSum = thisSum;
 }
}
return maxSum;
}

static int slightlyLessStupidSophomore(int n, ArrayList<Integer> a) {
	int maxSum = 0;
	//i: starting index of sum
	for(int i=0; i< n; i++)
	{
	 int thisSum= 0;
	 //compute all sums that begin with index i
	 for(int j=i; j< n; j++)
	 {
	 thisSum += a.get(j);
	 if(thisSum > maxSum)
	 maxSum = thisSum;
	 }
	}
	return maxSum;
}

static int gettingSmarterJunior(ArrayList<Integer> a,int left, int right)
{
	 //Base case 1
	 if(right == left)
	 return a.get(left);
	 //Base case 2
	 if(right == left+1)
		 return Math.max(a.get(left),Math.max(a.get(right),a.get(left)+a.get(right)));
	 int mid = (left+right)/2;
	 //Find the MSS that occurs in the left half of a
	 int mss_left = gettingSmarterJunior(a,left,mid);
	 //Find the MSS that occurs in the right half of a
	 int mss_right = gettingSmarterJunior(a,mid+1,right);
	 //Find the MSS that intersects both the left and right halves
	 int mss_middle = gettingSmarterJuniorMiddle(a,left,mid,right);
	 return Math.max(mss_left, Math.max(mss_right,mss_middle));
	}

static int gettingSmarterJuniorMiddle(ArrayList<Integer> a, int left, int mid, int right) {
	int negativeInfinity = Integer.MIN_VALUE;
	 int max_left_sum = negativeInfinity;
	 int sum = 0;
	 int i;
	 for(i = mid; i >= left; i--)
	 {
	 sum += a.get(i);
	 if(sum > max_left_sum)
	 max_left_sum = sum;
	 }
	 int max_right_sum = negativeInfinity;
	 sum = 0;
	 for(i = mid + 1; i <= right; i++)
	 {
	 sum += a.get(i);
	 if(sum > max_right_sum)
	 max_right_sum = sum;
	 }
	 return max_left_sum + max_right_sum;
	}

static int superSmartSenior(ArrayList a) {
int maxSum = 0;
int thisSum = 0;
for(int i = 0; i < a.size(); i++)
{
 thisSum += (int) a.get(i);
 if(thisSum > maxSum)
 maxSum = thisSum;
 else if(thisSum < 0)
 thisSum = 0;
}
return maxSum;
}

public static void main(String[] args) {
	
    ArrayList array = new ArrayList();
    Scanner in = new Scanner(System.in);
    
int selection = 0;
    

while(selection != 4) {
	System.out.println("Please make a selection:\n1) Make your own array \n"
    		+ "2) Time a random array \n3) Select one of the algorithms for computing \n4) Quit ");
	selection = in.nextInt();
	switch(selection){
	case 1:
	{
System.out.println("Enter number of elements you want in the array");
int n = in.nextInt();
int i = 0;
while(i < n ){
System.out.println("Enter a value for your array ");
int value = in.nextInt();
array.add(value);
i++;
}
int l =0;
int r = array.size() - 1;
int algorithm1 = stupidFreshmen(n, array);
int algorithm2 = slightlyLessStupidSophomore(n, array);
int algorithm3 = gettingSmarterJunior(array, l, r);
int algorithm4 = superSmartSenior(array);

System.out.println("Your stupid sum 1 is " + algorithm1);
System.out.println("Your stupid sum 2 is " + algorithm2);
System.out.println("Your stupid sum 3 is " + algorithm3);
System.out.println("Your stupid sum 4 is " + algorithm4);
		}
	break;
	
	case 2:
	{
		System.out.println("Enter number of elements you want in the array");
		int n = in.nextInt();
		int i = 0;
		Random rand = new Random();
		System.out.println("Enter a value for your array ");	
		
		for(i = 0; i < n; i++ ){
		int value = rand.nextInt(((2000 - 0)+1) + 0);
		array.add(value);
		}
		int l =0;
		int r = array.size() - 1;
		System.out.println(array);
		{
		System.out.println("Which algorithms would you like to run?\n Choose 1-4");		
		String algorithmChoice = in.next();
		
		if(algorithmChoice == "1") {
			int algorithm1 = stupidFreshmen(n, array);
			System.out.println("Your stupid sum 1 is " + algorithm1);
		}
		else if(algorithmChoice == "2") {
			int algorithm2 = slightlyLessStupidSophomore(n, array);	
			System.out.println("Your stupid sum 2 is " + algorithm2);
		}
		else if(algorithmChoice == "3") {
			int algorithm3 = gettingSmarterJunior(array, l, r);
			System.out.println("Your stupid sum 3 is " + algorithm3);
		}
		else if(algorithmChoice == "4") {
			int algorithm4 = superSmartSenior(array);
			System.out.println("Your stupid sum 4 is " + algorithm4);
}
		else if(algorithmChoice == "12") {
			
			int algorithm1 = stupidFreshmen(n, array);
			int algorithm2 = slightlyLessStupidSophomore(n, array);
			System.out.println("Your stupid sum 1 is " + algorithm1);
			System.out.println("Your stupid sum 2 is " + algorithm2);
		}
		else if(algorithmChoice == "13") {
			
			int algorithm1 = stupidFreshmen(n, array);
			int algorithm3 = gettingSmarterJunior(array, l, r);
			System.out.println("Your stupid sum 1 is " + algorithm1);
			System.out.println("Your stupid sum 3 is " + algorithm3);
		}
		else if(algorithmChoice == "14") {
			int algorithm1 = stupidFreshmen(n, array);
			int algorithm4 = superSmartSenior(array);
			System.out.println("Your stupid sum 1 is " + algorithm1);
			System.out.println("Your stupid sum 4 is " + algorithm4);
		}
		else if(algorithmChoice == "123") {
			int algorithm1 = stupidFreshmen(n, array);
			int algorithm2 = slightlyLessStupidSophomore(n, array);
			int algorithm3 = gettingSmarterJunior(array, l, r);
			System.out.println("Your stupid sum 1 is " + algorithm1);
			System.out.println("Your stupid sum 2 is " + algorithm2);
			System.out.println("Your stupid sum 3 is " + algorithm3);
		}
		else if(algorithmChoice == "124") {
			int algorithm1 = stupidFreshmen(n, array);
			int algorithm2 = slightlyLessStupidSophomore(n, array);
			int algorithm4 = superSmartSenior(array);
			System.out.println("Your stupid sum 1 is " + algorithm1);
			System.out.println("Your stupid sum 2 is " + algorithm2);
			System.out.println("Your stupid sum 4 is " + algorithm4);
		}
		else if(algorithmChoice == "1234") {
			
			int algorithm1 = stupidFreshmen(n, array);
			int algorithm2 = slightlyLessStupidSophomore(n, array);
			int algorithm3 = gettingSmarterJunior(array, l, r);
			int algorithm4 = superSmartSenior(array);
			System.out.println("Your stupid sum 1 is " + algorithm1);
			System.out.println("Your stupid sum 2 is " + algorithm2);
			System.out.println("Your stupid sum 3 is " + algorithm3);
			System.out.println("Your stupid sum 4 is " + algorithm4);
		}
		else if(algorithmChoice == "23") {
			int algorithm2 = slightlyLessStupidSophomore(n, array);
			int algorithm3 = gettingSmarterJunior(array, l, r);
			System.out.println("Your stupid sum 2 is " + algorithm2);
			System.out.println("Your stupid sum 3 is " + algorithm3);
		}
		else if(algorithmChoice == "24") {
			int algorithm2 = slightlyLessStupidSophomore(n, array);
			int algorithm4 = superSmartSenior(array);
			System.out.println("Your stupid sum 2 is " + algorithm2);
			System.out.println("Your stupid sum 4 is " + algorithm4);
		}
		else if(algorithmChoice == "234") {
			int algorithm2 = slightlyLessStupidSophomore(n, array);
			int algorithm3 = gettingSmarterJunior(array, l, r);
			int algorithm4 = superSmartSenior(array);
			System.out.println("Your stupid sum 2 is " + algorithm2);
			System.out.println("Your stupid sum 3 is " + algorithm3);
			System.out.println("Your stupid sum 4 is " + algorithm4);
		}
		else if(algorithmChoice == "134") {
			int algorithm1 = stupidFreshmen(n, array);
			int algorithm3 = gettingSmarterJunior(array, l, r);
			int algorithm4 = superSmartSenior(array);
			System.out.println("Your stupid sum 1 is " + algorithm1);
			System.out.println("Your stupid sum 3 is " + algorithm3);
			System.out.println("Your stupid sum 4 is " + algorithm4);
		}
		else if(algorithmChoice == "34") {
			int algorithm3 = gettingSmarterJunior(array, l, r);
			int algorithm4 = superSmartSenior(array);
			System.out.println("Your stupid sum 3 is " + algorithm3);
			System.out.println("Your stupid sum 4 is " + algorithm4);
			}
		}
		
	}
		break;
		
	case 3:
	{
		
		
	}
		break;
	
	
	case 4:
	{
		System.out.println("Bye!");
	}
	break;
		}
	}
}


}