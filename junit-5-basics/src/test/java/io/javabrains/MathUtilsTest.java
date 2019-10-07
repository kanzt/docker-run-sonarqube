package io.javabrains;

import static java.time.Duration.ofMillis;
import static java.time.Duration.ofMinutes;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTimeout;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class MathUtilsTest {
// @BeforeAll > @BeforeEach > @Test > @AfterEach > ... > @AfterAll
// @Disabled("All test in this class will be skipped")  << Class level and Method level
//	assertTrue
//	assertFalse,
//	assertNull
//	assertNotNull
//	assertEquals
//	assertArrayEquals
//	assertIterableEquals
//	assertLinesMatch
//	assertNotEquals
//	assertSame		check if same object
//	assertNotSame
	@Test
	void test1() {
		fail("Not yet implemented");
	}

	@Test
	@Disabled("All test in this class will be skipped")
	void test2() {
		assertTimeout(ofMinutes(2), () -> {
			// Perform task that takes less than 2 minutes.
			System.out.println("Tarwaan");
		});
	}

	@Test
	@DisplayName("A special test case")  // annotation ใช้ในการ override ชื่อ test class หรือ method ด้วยการทำ custom message พร้อมสามารถใช้งาน special characters หรือ emojis ได้ด้วย
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
//		assertAll ช่วยให้เราสามารถใช้ group assertions แบบต่างๆในเวลาเดียวกันได้ โดยปกติเวลาเราทำการ assertion จำนวนหลายข้อ เมื่อ assertion ไหนเกิดการ failure เราก็จะรู้เฉพาะ failure แรกเท่านั้น แต่สำหรับ group assertion นั้น ทุก assertions จะถูก execute เสมอ ดังนั้นถ้าเกิด failures ก็จะถูก report ออกมาพร้อมๆกัน
		Member member = new Member("Cherprang", "Areekul");
		assertAll("member", () -> assertEquals("Cherprang", member.getFirstName()),
				() -> assertEquals("Areekul", member.getLastName()));
	}

}
