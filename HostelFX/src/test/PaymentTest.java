package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import run.Payment;

class PaymentTest {

	@Test
	void test() {
		Payment p1 = new Payment("January", 175);
        Payment p2 = new Payment("February", 250);

        assertAll("Month",
        		() -> assertEquals("January", p1.getMonth()),
        		() -> assertEquals("February", p2.getMonth())
        		);
        
        assertAll("Amount",
        		() -> assertEquals(175, p1.getAmount()),
        		() -> assertEquals(250, p2.getAmount())
        		);
	}

}
