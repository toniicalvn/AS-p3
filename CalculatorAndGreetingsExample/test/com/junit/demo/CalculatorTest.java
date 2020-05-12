package com.junit.demo;

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
 
public class CalculatorTest {
 
 private Calculator calc;
  
 @Before
 public void setUp() throws Exception {
  calc = new Calculator();
 }
 
 @After
 public void tearDown() throws Exception {
  calc = null;
 }
 
 @Test
 public void testMultiply() {
  double result = calc.multiply(2.5, 100);
  assertEquals(250, result, 0);
 }
 
 @Test
 public void testDivide() {
  double result = calc.divide(100, 10);
  assertEquals(10, result, 0);
   
 }
 
 @Test
 public void testDivideWithTolerance() {
  double result = calc.divide(345, 100);
  assertEquals(3.4, result, 0.1);
   
 }
  
 @Test(expected = ArithmeticException.class)
 public void testDivideByZero() {
  calc.divide(100.5, 0);
 }
 
 @Test
 public void testSum() {
	 double result = calc.sum(3,4);
	 assertEquals(7, result, 0);
 }
 
 @Test (expected = NoEsPotRestarException.class)
 public void testSubstractDisordered () {
	 calc.substract(5, 8);
	 
 }
 
 @Test 
 public void testSubstract() {
	 double result = calc.substract(8, 5);
	 assertEquals(3,result, 0);
 }
 
 @Test
 public void testFactorialZero() {
	 int result = calc.factorial(0);
	 assertEquals(1, result, 0);
 }
 
 @Test (expected = Greetings.nEsNegatiu.class)
 public void testFactorialNegatiu() {
	 calc.factorial(-1);
	 
 }
 
 @Test 
 public void testFactorial() {
	 int result = calc.factorial(2);
	 assertEquals(2, result, 0);
 }
 
}
