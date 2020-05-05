package com.junit.demo;


public class Calculator {
		  
		 public double multiply(double a, double b) {
		  return a * b;
		 }
		  
		 public double divide(double a, double b) { 
		  if(b == 0) {
		   throw new ArithmeticException();
		  }
		  return a / b;
		 } 
		 
		 public double sum(double a, double b) {
			 return a+b;
		 }
		 
		 public double substract(double a, double b)  {
			if(b > a) {
			 throw new NoEsPotRestarException();
			 }
			else return a - b;
		 }
		 
		 public int factorial(int a) {
			 int resultat = 1;
			 
			 if (a < 0) throw new nEsNegatiu();
			 else if (a > 0) {
				 while(a > 1) {
					 resultat = resultat * a;
					 a--;
				 }
			 }
			 return resultat;
		 }
		 
		 
		 
	}
