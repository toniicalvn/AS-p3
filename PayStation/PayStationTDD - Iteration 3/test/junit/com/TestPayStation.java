package junit.com;

import org.junit.*;
import static org.junit.Assert.*;

/** Test cases for the Pay Station system.
 
   This source code is from the book 
     "Flexible, Reliable Software:
       Using Patterns and Agile Development"
     published 2010 by CRC Press.
   Author: 
     Henrik B Christensen 
     Department of Computer Science
     Aarhus University
   
   Please visit http://www.baerbak.com/ for further information.

   Licensed under the Apache License, Version 2.0 (the "License");
   you may not use this file except in compliance with the License.
   You may obtain a copy of the License at
 
       http://www.apache.org/licenses/LICENSE-2.0
 
   Unless required by applicable law or agreed to in writing, software
   distributed under the License is distributed on an "AS IS" BASIS,
   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
   See the License for the specific language governing permissions and
   limitations under the License.

*/
public class TestPayStation {
  PayStation ps;
  /** Fixture for pay station testing. */
  @Before
  public void setUp() {
    ps = new PayStationImpl();
  }

  /**
   * Entering 5 cents should make the display report 2 minutes 
   * parking time.
  */
  @Test
  public void shouldDisplay2MinFor5Cents() throws IllegalCoinException {
    ps.addPayment( 5 );
    assertEquals( "Should display 2 min for 5 cents", 
                  2, ps.readDisplay() ); 
  }

  /**
   * Entering 25 cents should make the display report 10 minutes
   * parking time.
  */
  @Test
  public void shouldDisplay10MinFor25Cents() throws IllegalCoinException {
    ps.addPayment( 25 );
    assertEquals( "Should display 10 min for 25 cents",
                  25 / 5 * 2, ps.readDisplay() );
    // 25 cent in 5 cent coins each giving 2 minutes parking
  }

  @Test
  public void shouldDisplay4MinFor10Cents() throws IllegalCoinException {
    ps.addPayment(10);
    assertEquals("Should display 4 min for 10 cents", 4, ps.readDisplay());
  }

  @Test
  public void shouldDisplay14MinFor10CentsAnd25Cents() throws IllegalCoinException {
    ps.addPayment(10);
    ps.addPayment(25);
    assertEquals("Should display 14 min for 10 cents and 25 cents", 14, ps.readDisplay());
  }

  @Test
  public void buyAfter3ValidCoins() throws IllegalCoinException {
    ps.addPayment(5);
    ps.addPayment(10);
    ps.addPayment(25);
    assertEquals("Should return a receipt of 16 minutes", (5+10+25)/5*2, ps.buy().value());
  }

  /** 
   * Verify that illegal coin values are rejected.
  */
  @Test(expected=IllegalCoinException.class)
  public void shouldRejectIllegalCoin() throws IllegalCoinException {
    ps.addPayment(17);
  }

  @Test
  public void receiptCanStoreValues() {
    int value = 20;
    ReceiptImpl r = new ReceiptImpl(value);
    assertEquals("Should return a receipt of " + value + " minutes", value, r.value());
  }

  @Test
  public void buyFrom100Cents() throws IllegalCoinException{
    ps.addPayment(25);
    ps.addPayment(25);
    ps.addPayment(25);
    ps.addPayment(25);
    assertEquals("Should return a receipt of " + 40 + " minutes", (4*25)/5*2, ps.buy().value());
  }

  @Test
  public void cancelResetsPayStation() throws IllegalCoinException{
    ps.addPayment(10);
    ps.cancel();
    assertEquals("Should return a receipt of " + 0 + " minutes", 0, ps.readDisplay());
    ps.addPayment(25);
    assertEquals("Should return a receipt of " + 10 + " minutes", (25)/5*2, ps.readDisplay());
  }

  @Test
  public void clearingAfterBuyOperation() throws IllegalCoinException{
    ps.addPayment(10);
    ps.buy();
    assertEquals("Should return a receipt of " + 0 + " minutes", 0, ps.readDisplay());
    ps.addPayment(25);
    assertEquals("Should return a receipt of " + 10 + " minutes", (25)/5*2, ps.buy().value());
    assertEquals("Should return a receipt of " + 0 + " minutes", 0, ps.readDisplay());
  }

}
