import java.util.*;
public class galtonBox
{
	static Scanner keyboard = new Scanner(System.in);
	public static void main(String[] args) 
	{
		int numberOfPegs;
		numberOfPegs = getPegs();
		int numberOfBalls;
		numberOfBalls = getballs();
		int seed;
		seed = getseeds();
		int [] slots = new int [numberOfPegs+1];
		System.out.println("Here are the paths for the first five balls: ");
		dropBallsintoSlots(slots,seed,numberOfBalls);
		System.out.println("Here are the counts for the balls in each slot (slot 0 is the leftmost):");
		showSlotCount(slots);	
		System.out.println("Here is the graphic picture of the distribution: ");
		showDistribution(slots);
	}
	
	private static int getPegs ()
	{
		int totalpegs;
		System.out.print("How many pegs are on the board? ");
		totalpegs = keyboard.nextInt();
		keyboard.nextLine();
		return totalpegs;
	}
	
	private static int getballs()
	{
		int totalnoballs;
		System.out.print("How many balls will be dropped?  ");
		totalnoballs = keyboard.nextInt();
		return totalnoballs;	
	}
	
	private static int getseeds()
	{
		int seeds; 
		System.out.print("Enter value for seed: ");
		seeds = keyboard.nextInt();
		keyboard.nextLine();
		return seeds;
	}
	
	private static int getMaximum(int[] slots) 
	{
		int temMax = slots[0];
		int len = slots.length;
		for (int i = 0; i<len;i++)
		{	if (slots[i]>temMax)
				temMax=slots[i];
		}
		return temMax;
	}

	private static void  dropBallsintoSlots(int[] slots, int numberOfBalls, int seed) 
	{
		int ballCounter;
		int rightCounter;
		int pegCounter;
		int numberOfPegs = slots.length-1;
		Random pegDecider = new Random(seed);
		for (int i =0; i<slots.length;i++)
		{
			slots[i]=0;
		}
		for(ballCounter = 0;ballCounter<5;ballCounter++)
		{
			rightCounter =0;			
			for(pegCounter = 0;pegCounter<numberOfPegs;pegCounter++)
			{									
				if(pegDecider.nextInt(2) ==1)
					{System.out.print("R");
					rightCounter++;
					}
				else 
					System.out.print("L");						
			}
			slots[rightCounter]++;
			System.out.println();		
		}		
		
		for (ballCounter =5;ballCounter<numberOfBalls;ballCounter++)
		{
			rightCounter =0;
			for(pegCounter = 0;pegCounter<numberOfPegs;pegCounter++)
			{	
				if(pegDecider.nextInt(2) ==1)	
				{
					rightCounter++;
				}					
			}
			slots[rightCounter]++;	
		}		
	}

	private static void showSlotCount(int[] slots) 
	{
		int len = slots.length;
		
		for (int i = 0; i<len; i++)
		{
		System.out.printf("Slot#%d --%d\n",i,slots[i]);
		}				
	}

private static void showDistribution(int[] slots)
{	
	int numberOfSlots = slots.length;
	int maxCount = getMaximum(slots);
	
	for(int displaycounter= maxCount;displaycounter>0;displaycounter--)
	{
		for (int i=0;i<numberOfSlots;i++)
		{
			if(slots[i]>=displaycounter)
				System.out.printf("%5s","XXX");
			
			else
				System.out.printf("%5s"," ");				
		}
		System.out.println();
	}		
		for (int slotnumber = 0; slotnumber<numberOfSlots; slotnumber++)
			System.out.printf("%5s","---");
				System.out.println();
	}
}
