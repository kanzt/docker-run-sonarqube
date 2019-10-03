package io.javabrains;

import static java.time.Duration.ofMillis;
import static java.time.Duration.ofMinutes;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTimeout;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.Test;

class MathUtilsTest {
// @BeforeAll > @BeforeEach > @Test > @AfterEach > ... > @AfterAll
//	assertTrue
//	assertFalse,
//	assertNull
//	assertNotNull
//	assertEquals
//	assertArrayEquals
//	assertIterableEquals
//	assertLinesMatch
//	assertNotEquals
//	assertSame
//	assertNotSame
	@Test
	void test1() {
		fail("Not yet implemented");
	}

	@Test
	void test2() {
		assertTimeout(ofMinutes(2), () -> {
			// Perform task that takes less than 2 minutes.
			System.out.println("Tarwaan");
		});
	}

	@Test
	void test3() {
		assertTimeout(ofMillis(10), () -> {
			// Perform task that takes less than 10 milliseconds.
			// If this task take more than 10 milliseconds will fail
			Thread.sleep(100);
		});
	}

	@Test
	void test4() {
		// This takes the type of the expected exception, and an Executable functional
		// interface where we can pass the code under test through a lambda expression:
		assertThrows(NumberFormatException.class, () -> {
			Integer.parseInt("One");
		});
	}

	@Test
	void Test5() {
		String test = null;
		assertThrows(NullPointerException.class, () -> {
			// If this scope return NullPointerException will success
			test.length();
		});
	}

	@Test
	void Test6() {
//		assertAll ��������������ö�� group assertions Ẻ��ҧ���������ǡѹ�� �»���������ҷӡ�� assertion �ӹǹ���¢�� ����� assertion �˹�Դ��� failure ��ҡ�����੾�� failure �á��ҹ�� ������Ѻ group assertion ��� �ء assertions �ж١ execute ���� �ѧ��鹶���Դ failures ��ж١ report �͡�Ҿ�����ѹ
		Member member = new Member("Cherprang", "Areekul");
		assertAll("member", () -> assertEquals("Cherprang", member.getFirstName()),
				() -> assertEquals("Areekul", member.getLastName()));
	}

}
