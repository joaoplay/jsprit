package jsprit.core.problem.job;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class PickupTest {
	
	@SuppressWarnings("deprecation")
	@Test(expected=IllegalStateException.class)
	public void whenNeitherLocationIdNorCoordIsSet_itThrowsException(){
		Pickup.Builder.newInstance("p", 0).build();
	}
	
	@Test
	public void whenAddingTwoCapDimension_nuOfDimsShouldBeTwo(){
		Pickup one = (Pickup)Pickup.Builder.newInstance("s").setLocationId("foofoo")
				.addCapacityDimension(0,2)
				.addCapacityDimension(1,4)
				.build();
		assertEquals(2,one.getCapacity().getNuOfDimensions());
		assertEquals(2,one.getCapacity().get(0));
		assertEquals(4,one.getCapacity().get(1));
		
	}
	
	@Test
	public void whenPickupIsBuiltWithoutSpecifyingCapacity_itShouldHvCapWithOneDimAndDimValOfZero(){
		Pickup one = (Pickup)Pickup.Builder.newInstance("s").setLocationId("foofoo")
				.build();
		assertEquals(1,one.getCapacity().getNuOfDimensions());
		assertEquals(0,one.getCapacity().get(0));
	}
	
	@SuppressWarnings("deprecation")
	@Test
	public void whenPickupIsBuiltWithConstructorWhereSizeIsSpecified_capacityShouldBeSetCorrectly(){
		Pickup one = (Pickup)Pickup.Builder.newInstance("s",1).setLocationId("foofoo")
				.build();
		assertEquals(1,one.getCapacityDemand());
		assertEquals(1,one.getCapacity().getNuOfDimensions());
		assertEquals(1,one.getCapacity().get(0));
	}


}
