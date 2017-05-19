package udemy.numbers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class BiggerAndSmallerTest {

	private BiggerAndSmaller algorithm;

	@Before
	public void setUp() {

		algorithm = new BiggerAndSmaller();
	}

	private List<Integer> makeList(Integer... numbers) {
		return Arrays.asList(numbers);
	}

	private void assertNumbers(int bigger, int smaller) {
		Assert.assertEquals(bigger, algorithm.getBigger());
		Assert.assertEquals(smaller, algorithm.getSmaller());
	}

	@Test
	public void numbersInIncreasingOrder() throws IllegalArgumentException {
		algorithm.find(makeList(12, 3, 4, 5));
		assertNumbers(12, 3);

	}

	@Test
	public void numbersInDecreasingOrder() throws IllegalArgumentException {
		algorithm.find(makeList(12, 9, 8, 4));
		assertNumbers(12, 4);
	}

	@Test
	public void numbersInAnyOrder() throws IllegalArgumentException {
		algorithm.find(makeList(23, 45, 11, 76, 53, 10));
		assertNumbers(76, 10);

	}

	@Test
	public void onlyOneNumber() throws IllegalArgumentException {
		algorithm.find(makeList(23));
		assertNumbers(23, 23);

	}

	@Test
	public void repeatedNumbers() throws IllegalArgumentException {
		algorithm.find(makeList(23, 23, 34, 12, 12, 34));
		assertNumbers(34, 12);

	}

	@Test(expected = IllegalArgumentException.class)
	public void emptyList() throws IllegalArgumentException {
		algorithm.find(new ArrayList<Integer>());

	}

}
