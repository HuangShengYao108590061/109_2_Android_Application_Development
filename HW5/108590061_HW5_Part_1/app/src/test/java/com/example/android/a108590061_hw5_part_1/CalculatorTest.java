package com.example.android.a108590061_hw5_part_1;

import android.test.suitebuilder.annotation.SmallTest;

import org.junit.Test;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import static org.junit.Assert.assertThat;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.equalTo;


@RunWith(JUnit4.class)
@SmallTest
public class CalculatorTest {

    private Calculator calcs;

    @Before
    public void setUp() {

        calcs = new Calculator();

    }

    @Test
    public void twoOprAdd() {
        double addition_res = calcs.Additions(1d, 1d);
        assertThat(addition_res, is(equalTo(2d)));
    }

    @Test
    public void NegIntfirstOprnd() {
        double Addition_neg_res = calcs.Additions(-8d, 3d);
        assertThat(Addition_neg_res, is(equalTo(-5d)));
    }

    @Test
    public void NegIntsecOprnd() {
        double Addition_neg_res2 = calcs.Additions(8d, -5d);
        assertThat(Addition_neg_res2, is(equalTo(3d)));
    }

    @Test
    public void addnegtwoOpr() {
        double Two_Neg_Addition_res = calcs.Additions(-10d, -11d);
        assertThat(Two_Neg_Addition_res, is(equalTo(-21d)));
    }

    @Test
    public void floataddtwoOpr() {
        double float_res = calcs.Additions(3.42672d, 2.32315d);
        assertThat(float_res, is(equalTo(5.74987)));
    }

    @Test
    public void BigNumsAddition() {
        double bignum_res = calcs.Additions(531278907d, 287128623d);
        assertThat(bignum_res, is(equalTo(818407530d)));
    }

    /* Second test for BigNumsAddition()
    @Test
    public void BigNumsAddition2() {
        double bignum_res = calcs.Additions(71284329102d, 38172950427d);
        assertThat(bignum_res, is(equalTo(109457279529d)));
    }
    */

    @Test
    public void TwoNumsSubtract() {
        double subtract_res = calcs.Subtractions(7d, 7d);
        assertThat(subtract_res, is(equalTo(0d)));
    }

    @Test
    public void SubtractNeg() {
        double subtract_res = calcs.Subtractions(15d, 37d);
        assertThat(subtract_res, is(equalTo(-22d)));
    }

    @Test
    public void TwoNumsMultiply() {
        double multiply_res = calcs.Multiplications(60d, 5d);
        assertThat(multiply_res, is(equalTo(300d)));
    }

    @Test
    public void TwoNumbsDivision() {
        double division_res = calcs.Divisions(58d,2d);
        assertThat(division_res, is(equalTo(29d)));
    }

    @Test(expected = IllegalArgumentException.class)
    public void ThrowExcpDivideByZero() {
        calcs.Divisions(27d,0d);
    }

    /*Numbers divided by zero bears error*/


    /**Power test**/

    /*A test with positive integer operands*/

    @Test
    public void TestPosPowertest(){
        double division_res = calcs.Powers(5d, 2d);
        assertThat(division_res, is(equalTo(25d)));
    }

    /*A test with a negative integer as the first operand*/

    @Test
    public void TestNegIntfirstOprndPower(){
        double power_res = calcs.Powers(-7d, 2d);
        assertThat(power_res, is(equalTo(49d)));
    }

    /*A test with a negative integer as the second operand*/

    @Test
    public void TestNegIntsecOprndPower(){
        double power_res = calcs.Powers(4d, -2d);
        assertThat(power_res, is(equalTo(0.0625d)));
    }

    /* Second test for TestNegIntsecOprndPower()
    @Test
    public void TestNegIntsecOprndPower2(){
        double power_res = calcs.Powers(8d, -3d);
        assertThat(power_res, is(equalTo(0.001953125d)));
    }
    */


    /*A test with 0 as the first operand and a positive integer as the second operand*/

    @Test
    public void TestZeroFirstOprndPosSecOprndPower(){
        double power_res = calcs.Powers(0d, 7d);
        assertThat(power_res, is(equalTo(0d)));
    }

    /*A test with 0 as the second operand*/

    @Test
    public void TestZeroSecOprndPower(){
        double power_res = calcs.Powers(15d, 0d);
        assertThat(power_res, is(equalTo(1d)));
    }

    /*A test with 0 as the first operand and -1 as the second operand*/

    @Test
    public void TestZeroFirstOprndNegOneSecOprndPower(){
        double power_res = calcs.Powers(0d, -1d);
        assertThat(power_res, is(equalTo(Double.POSITIVE_INFINITY)));
    }

    /*A test with -0 as the first operand and any negative number as the second operand*/

    @Test
    public void TestZeroFirstOprndNegSecOprndPower(){
        double power_res = calcs.Powers(-0d, -12d);
        assertThat(power_res, is(equalTo(Double.POSITIVE_INFINITY)));
    }

    /* Second test for TestZeroFirstOprndNegSecOprndPower()
    @Test
    public void TestZeroFirstOprndNegSecOprndPower2(){
        double power_res = calcs.Powers(-0d, -100d);
        assertThat(power_res, is(equalTo(Double.POSITIVE_INFINITY)));
    }
    */

}

